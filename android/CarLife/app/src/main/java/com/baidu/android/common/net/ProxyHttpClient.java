package com.baidu.android.common.net;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class ProxyHttpClient extends DefaultHttpClient {
    private static final boolean DEBUG = false;
    private static final int HTTP_TIMEOUT_MS = 30000;
    private static final String TAG = ProxyHttpClient.class.getSimpleName();
    private RuntimeException mLeakedException;
    private String mPort;
    private String mProxy;
    private boolean mUseWap;

    public ProxyHttpClient(Context context) {
        this(context, null, null);
    }

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, null, connectManager);
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, null);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        this.mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
        if (connectManager == null) {
            connectManager = new ConnectManager(context);
        }
        this.mUseWap = connectManager.isWapNetwork();
        this.mProxy = connectManager.getProxy();
        this.mPort = connectManager.getProxyPort();
        if (this.mProxy != null && this.mProxy.length() > 0) {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    protected HttpParams createHttpParams() {
        HttpParams createHttpParams;
        try {
            createHttpParams = super.createHttpParams();
        } catch (ArrayIndexOutOfBoundsException e) {
            createHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(createHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(createHttpParams, "ISO-8859-1");
            HttpProtocolParams.setUserAgent(createHttpParams, "Apache-HttpClient/UNAVAILABLE (java 1.4)");
        }
        HttpProtocolParams.setUseExpectContinue(createHttpParams, false);
        return createHttpParams;
    }

    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        try {
            return execute(httpUriRequest);
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.m1731e(TAG, "Leak found", this.mLeakedException);
        }
    }

    public boolean isWap() {
        return this.mUseWap;
    }
}
