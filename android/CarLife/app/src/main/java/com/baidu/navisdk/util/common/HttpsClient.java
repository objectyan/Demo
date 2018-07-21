package com.baidu.navisdk.util.common;

import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpsClient
  extends DefaultHttpClient
{
  public static final String CHARSET = "UTF-8";
  public static final long CONN_MGR_TIMEOUT = 30000L;
  public static final int CONN_TIMEOUT = 60000;
  public static final int MAX_CONNS_PER_ROUTE = 2;
  public static final int MAX_TOTAL_CONNECTIONS = 4;
  public static final int SOCKET_TIMEOUT = 60000;
  public static final String USER_AGENT = "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; HTC_DesireS_S510e Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
  
  private HttpsClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }
  
  public static HttpsClient getHttpClient()
  {
    try
    {
      Object localObject1 = new BasicHttpParams();
      ((HttpParams)localObject1).setParameter("http.protocol.handle-redirects", Boolean.valueOf(false));
      HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)localObject1, "UTF-8");
      HttpProtocolParams.setUseExpectContinue((HttpParams)localObject1, false);
      HttpProtocolParams.setUserAgent((HttpParams)localObject1, "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; HTC_DesireS_S510e Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
      ConnManagerParams.setMaxTotalConnections((HttpParams)localObject1, 4);
      ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)localObject1, new ConnPerRouteBean(2));
      ConnManagerParams.setTimeout((HttpParams)localObject1, 30000L);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, 60000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject1, 60000);
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
      localObject1 = new HttpsClient(new SingleClientConnManager((HttpParams)localObject1, localSchemeRegistry), (HttpParams)localObject1);
      return (HttpsClient)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/HttpsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */