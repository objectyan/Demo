package com.baidu.navi.utils.http;

import android.text.TextUtils;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.HttpUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
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

public class BaseHttpClient
{
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
  
  public BaseHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, 60000L);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(5));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 5);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, String.format("BaiduNavi/%s (http://www.navi.baidu.com)", new Object[] { "1.0" }));
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ((SchemeRegistry)localObject).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
    if ((NetworkUtils.mUseProxy) && (TextUtils.isEmpty(NetworkUtils.mProxyHost))) {
      localBasicHttpParams.setParameter("http.route.default-proxy", new HttpHost(NetworkUtils.mProxyHost, NetworkUtils.mProxyPort));
    }
    this.mHttpContext = new SyncBasicHttpContext(new BasicHttpContext());
    this.mHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
    this.mHttpClient.addRequestInterceptor(new HttpRequestInterceptor()
    {
      public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
      {
        if ((BaseHttpClient.this.isSupportGZIP) && (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding"))) {
          paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
        paramAnonymousHttpContext = BaseHttpClient.this.mClientHeaderMap.keySet().iterator();
        while (paramAnonymousHttpContext.hasNext())
        {
          String str = (String)paramAnonymousHttpContext.next();
          paramAnonymousHttpRequest.addHeader(str, (String)BaseHttpClient.this.mClientHeaderMap.get(str));
        }
      }
    });
    this.mHttpClient.addResponseInterceptor(new HttpResponseInterceptor()
    {
      public void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
      {
        paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity();
        if (paramAnonymousHttpContext == null) {}
        for (;;)
        {
          return;
          paramAnonymousHttpContext = paramAnonymousHttpContext.getContentEncoding();
          if ((BaseHttpClient.this.isSupportGZIP) && (paramAnonymousHttpContext != null))
          {
            paramAnonymousHttpContext = paramAnonymousHttpContext.getElements();
            int j = paramAnonymousHttpContext.length;
            int i = 0;
            while (i < j)
            {
              if (paramAnonymousHttpContext[i].getName().equalsIgnoreCase("gzip"))
              {
                paramAnonymousHttpResponse.setEntity(new BaseHttpClient.InflatingEntity(paramAnonymousHttpResponse.getEntity()));
                return;
              }
              i += 1;
            }
          }
        }
      }
    });
    this.mClientHeaderMap = new HashMap();
  }
  
  public void addGZIPSupport()
  {
    this.isSupportGZIP = true;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.mClientHeaderMap.put(paramString1, paramString2);
  }
  
  public void get(String paramString, BaseRspHandler paramBaseRspHandler)
  {
    get(paramString, null, paramBaseRspHandler);
  }
  
  public void get(String paramString, ReqParams paramReqParams, BaseRspHandler paramBaseRspHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramReqParams == null) {}
    for (;;)
    {
      paramString = new HttpGet(paramString);
      sendRequest(this.mHttpClient, this.mHttpContext, paramString, paramBaseRspHandler);
      return;
      paramString = paramReqParams.buildQueryUrl(paramString);
    }
  }
  
  public DefaultHttpClient getHttpClient()
  {
    return this.mHttpClient;
  }
  
  public HttpContext getHttpContext()
  {
    return this.mHttpContext;
  }
  
  public void post(String paramString, ReqParams paramReqParams, BaseRspHandler paramBaseRspHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new HttpPost(paramString);
    if (paramReqParams != null)
    {
      paramReqParams.putSimpleValue("sign", HttpUtils.calcUrlSign(paramReqParams.getNamePairList()));
      paramString.setEntity(paramReqParams.getEntity());
    }
    sendRequest(this.mHttpClient, this.mHttpContext, paramString, paramBaseRspHandler);
  }
  
  public void postEncode(String paramString, ReqParams paramReqParams, BaseRspHandler paramBaseRspHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new HttpPost(paramString);
    if (paramReqParams != null)
    {
      localArrayList.add(new BasicNameValuePair("BDUSS", NaviAccountUtils.getInstance().syncGetBduss()));
      paramReqParams.putSimpleValue("sign", HttpUtils.calcUrlSign(localArrayList));
      paramString.setEntity(paramReqParams.getEntity());
    }
    sendRequest(this.mHttpClient, this.mHttpContext, paramString, paramBaseRspHandler);
  }
  
  protected void sendRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, BaseRspHandler paramBaseRspHandler)
  {
    new BaseReqHandler(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramBaseRspHandler).run();
  }
  
  private static class InflatingEntity
    extends HttpEntityWrapper
  {
    public InflatingEntity(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public InputStream getContent()
      throws IOException
    {
      return new GZIPInputStream(this.wrappedEntity.getContent());
    }
    
    public long getContentLength()
    {
      return -1L;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BaseHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */