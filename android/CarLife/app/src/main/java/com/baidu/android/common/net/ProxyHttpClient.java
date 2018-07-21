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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class ProxyHttpClient
  extends DefaultHttpClient
{
  private static final boolean DEBUG = false;
  private static final int HTTP_TIMEOUT_MS = 30000;
  private static final String TAG = ProxyHttpClient.class.getSimpleName();
  private RuntimeException mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
  private String mPort;
  private String mProxy;
  private boolean mUseWap;
  
  public ProxyHttpClient(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  public ProxyHttpClient(Context paramContext, ConnectManager paramConnectManager)
  {
    this(paramContext, null, paramConnectManager);
  }
  
  public ProxyHttpClient(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null);
  }
  
  public ProxyHttpClient(Context paramContext, String paramString, ConnectManager paramConnectManager)
  {
    ConnectManager localConnectManager = paramConnectManager;
    if (paramConnectManager == null) {
      localConnectManager = new ConnectManager(paramContext);
    }
    this.mUseWap = localConnectManager.isWapNetwork();
    this.mProxy = localConnectManager.getProxy();
    this.mPort = localConnectManager.getProxyPort();
    if ((this.mProxy != null) && (this.mProxy.length() > 0))
    {
      paramContext = new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue());
      getParams().setParameter("http.route.default-proxy", paramContext);
    }
    HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
    HttpConnectionParams.setSoTimeout(getParams(), 30000);
    HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
    if (!TextUtils.isEmpty(paramString)) {
      HttpProtocolParams.setUserAgent(getParams(), paramString);
    }
  }
  
  public void close()
  {
    if (this.mLeakedException != null)
    {
      getConnectionManager().shutdown();
      this.mLeakedException = null;
    }
  }
  
  protected HttpParams createHttpParams()
  {
    try
    {
      HttpParams localHttpParams = super.createHttpParams();
      HttpProtocolParams.setUseExpectContinue(localHttpParams, false);
      return localHttpParams;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "Apache-HttpClient/UNAVAILABLE (java 1.4)");
      }
    }
  }
  
  public HttpResponse executeSafely(HttpUriRequest paramHttpUriRequest)
    throws ClientProtocolException, IOException
  {
    try
    {
      paramHttpUriRequest = execute(paramHttpUriRequest);
      return paramHttpUriRequest;
    }
    catch (NullPointerException paramHttpUriRequest)
    {
      throw new ClientProtocolException(paramHttpUriRequest);
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.mLeakedException != null) {
      Log.e(TAG, "Leak found", this.mLeakedException);
    }
  }
  
  public boolean isWap()
  {
    return this.mUseWap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/common/net/ProxyHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */