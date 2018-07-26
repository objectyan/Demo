package com.baidu.navi.utils.http;

import android.text.TextUtils;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.HttpUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.facebook.common.p141m.C2924g;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class BaseHttpClient {
    private static final String CHARSET = "UTF-8";
    private static final int DEFAULT_MAX_CONNECTIONS = 5;
    private static final int DEFAULT_MAX_RETRIES = 1;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 60000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String VERSION = "1.0";
    private boolean isSupportGZIP = false;
    private Map<String, String> mClientHeaderMap;
    private DefaultHttpClient mHttpClient;
    private HttpContext mHttpContext;

    /* renamed from: com.baidu.navi.utils.http.BaseHttpClient$1 */
    class C39821 implements HttpRequestInterceptor {
        C39821() {
        }

        public void process(HttpRequest request, HttpContext context) {
            if (BaseHttpClient.this.isSupportGZIP && !request.containsHeader("Accept-Encoding")) {
                request.addHeader("Accept-Encoding", "gzip");
            }
            for (String header : BaseHttpClient.this.mClientHeaderMap.keySet()) {
                request.addHeader(header, (String) BaseHttpClient.this.mClientHeaderMap.get(header));
            }
        }
    }

    /* renamed from: com.baidu.navi.utils.http.BaseHttpClient$2 */
    class C39832 implements HttpResponseInterceptor {
        C39832() {
        }

        public void process(HttpResponse response, HttpContext context) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                Header encoding = entity.getContentEncoding();
                if (BaseHttpClient.this.isSupportGZIP && encoding != null) {
                    for (HeaderElement element : encoding.getElements()) {
                        if (element.getName().equalsIgnoreCase("gzip")) {
                            response.setEntity(new InflatingEntity(response.getEntity()));
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        public InflatingEntity(HttpEntity wrapped) {
            super(wrapped);
        }

        public InputStream getContent() throws IOException {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1;
        }
    }

    public BaseHttpClient() {
        BasicHttpParams httpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(httpParams, 60000);
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams, new ConnPerRouteBean(5));
        ConnManagerParams.setMaxTotalConnections(httpParams, 5);
        HttpConnectionParams.setSoTimeout(httpParams, 60000);
        HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpProtocolParams.setContentCharset(httpParams, "UTF-8");
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(httpParams, String.format("BaiduNavi/%s (http://www.navi.baidu.com)", new Object[]{"1.0"}));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme(C2924g.f12888b, SSLSocketFactory.getSocketFactory(), 443));
        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(httpParams, schemeRegistry);
        if (NetworkUtils.mUseProxy && TextUtils.isEmpty(NetworkUtils.mProxyHost)) {
            httpParams.setParameter("http.route.default-proxy", new HttpHost(NetworkUtils.mProxyHost, NetworkUtils.mProxyPort));
        }
        this.mHttpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.mHttpClient = new DefaultHttpClient(cm, httpParams);
        this.mHttpClient.addRequestInterceptor(new C39821());
        this.mHttpClient.addResponseInterceptor(new C39832());
        this.mClientHeaderMap = new HashMap();
    }

    public void addGZIPSupport() {
        this.isSupportGZIP = true;
    }

    public DefaultHttpClient getHttpClient() {
        return this.mHttpClient;
    }

    public HttpContext getHttpContext() {
        return this.mHttpContext;
    }

    public void addHeader(String header, String value) {
        this.mClientHeaderMap.put(header, value);
    }

    public void get(String url, BaseRspHandler responseHandler) {
        get(url, null, responseHandler);
    }

    public void get(String url, ReqParams params, BaseRspHandler responseHandler) {
        if (!TextUtils.isEmpty(url)) {
            if (params != null) {
                url = params.buildQueryUrl(url);
            }
            sendRequest(this.mHttpClient, this.mHttpContext, new HttpGet(url), responseHandler);
        }
    }

    public void post(String url, ReqParams params, BaseRspHandler responseHandler) {
        if (!TextUtils.isEmpty(url)) {
            HttpEntityEnclosingRequestBase request = new HttpPost(url);
            if (params != null) {
                params.putSimpleValue("sign", HttpUtils.calcUrlSign(params.getNamePairList()));
                request.setEntity(params.getEntity());
            }
            sendRequest(this.mHttpClient, this.mHttpContext, request, responseHandler);
        }
    }

    public void postEncode(String url, ReqParams params, BaseRspHandler responseHandler) {
        if (!TextUtils.isEmpty(url)) {
            List<NameValuePair> signPair = new ArrayList();
            HttpEntityEnclosingRequestBase request = new HttpPost(url);
            if (params != null) {
                signPair.add(new BasicNameValuePair("BDUSS", NaviAccountUtils.getInstance().syncGetBduss()));
                params.putSimpleValue("sign", HttpUtils.calcUrlSign(signPair));
                request.setEntity(params.getEntity());
            }
            sendRequest(this.mHttpClient, this.mHttpContext, request, responseHandler);
        }
    }

    protected void sendRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, BaseRspHandler responseHandler) {
        new BaseReqHandler(client, httpContext, uriRequest, responseHandler).run();
    }
}
