package com.baidu.cloudsdk.common.http;

import android.content.Context;
import com.baidu.android.common.net.ConnectManager;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient
  extends DefaultHttpClient
{
  private static final int DEFAULT_CHECK_INTERVAL = 10000;
  private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
  private static final int DEFAULT_MAX_CONNECTIONS = 10;
  private static final int DEFAULT_MAX_RETRIES = 3;
  private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
  private static final String DEFAULT_USER_AGENT = "Baidu-Android-Lib-V1.0";
  private static final String ENCODING_GZIP = "gzip";
  private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  protected static final ThreadPoolExecutor sThreadPool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
  protected long mLastCheckTime = 0L;
  protected int mNetworkCheckInterval = 10000;
  protected final WeakHashMap<Context, List<WeakReference<Future<?>>>> mRequestMap;
  
  public AsyncHttpClient()
  {
    HttpParams localHttpParams = getParams();
    ConnManagerParams.setTimeout(localHttpParams, 15000L);
    ConnManagerParams.setMaxConnectionsPerRoute(localHttpParams, new ConnPerRouteBean(10));
    ConnManagerParams.setMaxTotalConnections(localHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localHttpParams, 15000);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 15000);
    HttpConnectionParams.setTcpNoDelay(localHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localHttpParams, 8192);
    HttpProtocolParams.setUserAgent(localHttpParams, "Baidu-Android-Lib-V1.0");
    HttpClientParams.setCookiePolicy(localHttpParams, "compatibility");
    localHttpParams.setParameter("http.connection-manager.factory-object", new ClientConnectionManagerFactory()
    {
      public ClientConnectionManager newInstance(HttpParams paramAnonymousHttpParams, SchemeRegistry paramAnonymousSchemeRegistry)
      {
        SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        paramAnonymousSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        paramAnonymousSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, 443));
        return new ThreadSafeClientConnManager(paramAnonymousHttpParams, paramAnonymousSchemeRegistry);
      }
    });
    addRequestInterceptor(new HttpRequestInterceptor()
    {
      public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
        throws HttpException, IOException
      {
        if (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding")) {
          paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
        }
      }
    });
    addResponseInterceptor(new HttpResponseInterceptor()
    {
      public void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
        throws HttpException, IOException
      {
        paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity();
        int j;
        int i;
        if (paramAnonymousHttpContext != null)
        {
          paramAnonymousHttpContext = paramAnonymousHttpContext.getContentEncoding();
          if (paramAnonymousHttpContext != null)
          {
            paramAnonymousHttpContext = paramAnonymousHttpContext.getElements();
            j = paramAnonymousHttpContext.length;
            i = 0;
          }
        }
        for (;;)
        {
          if (i < j)
          {
            if (paramAnonymousHttpContext[i].getName().equalsIgnoreCase("gzip")) {
              paramAnonymousHttpResponse.setEntity(new AsyncHttpClient.InflatingEntity(paramAnonymousHttpResponse.getEntity()));
            }
          }
          else {
            return;
          }
          i += 1;
        }
      }
    });
    this.mRequestMap = new WeakHashMap();
  }
  
  private void checkNetworkStateAndAdjust(Context paramContext)
  {
    long l;
    if (paramContext != null)
    {
      l = System.currentTimeMillis();
      if (l - this.mLastCheckTime > this.mNetworkCheckInterval)
      {
        paramContext = new ConnectManager(paramContext);
        if (!paramContext.isWapNetwork()) {
          break label89;
        }
        String str = paramContext.getProxy();
        int i = Integer.parseInt(paramContext.getProxyPort());
        if ((str != null) && (str.length() > 0)) {
          ConnRouteParams.setDefaultProxy(getParams(), new HttpHost(str, i));
        }
      }
    }
    for (;;)
    {
      this.mLastCheckTime = l;
      return;
      label89:
      ConnRouteParams.setDefaultProxy(getParams(), null);
    }
  }
  
  public static void endEntityViaReflection(HttpEntity paramHttpEntity)
  {
    Object localObject2;
    if ((paramHttpEntity instanceof HttpEntityWrapper)) {
      localObject2 = null;
    }
    try
    {
      Field[] arrayOfField = HttpEntityWrapper.class.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        Object localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = arrayOfField[i];
          if (!((Field)localObject1).getName().equals("wrappedEntity")) {}
        }
        else
        {
          if (localObject1 != null)
          {
            ((Field)localObject1).setAccessible(true);
            paramHttpEntity = (HttpEntity)((Field)localObject1).get(paramHttpEntity);
            if (paramHttpEntity != null) {
              paramHttpEntity.consumeContent();
            }
          }
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramHttpEntity) {}
  }
  
  public static String getUrlWithQueryString(String paramString, RequestParams paramRequestParams)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramRequestParams != null)
      {
        paramRequestParams = paramRequestParams.getQueryString();
        if (paramString.contains("?")) {
          break label52;
        }
        str = paramString + "?" + paramRequestParams;
      }
    }
    return str;
    label52:
    return paramString + "&" + paramRequestParams;
  }
  
  public static void silentCloseInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  public void cancelRequests(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.mRequestMap.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null) {
          localFuture.cancel(paramBoolean);
        }
      }
    }
    this.mRequestMap.remove(paramContext);
  }
  
  public void delete(Context paramContext, String paramString, HttpResponseHandler paramHttpResponseHandler)
  {
    delete(paramContext, paramString, null, null, paramHttpResponseHandler);
  }
  
  public void delete(Context paramContext, String paramString, RequestParams paramRequestParams, HttpResponseHandler paramHttpResponseHandler)
  {
    delete(paramContext, paramString, paramRequestParams, null, paramHttpResponseHandler);
  }
  
  public void delete(Context paramContext, String paramString, RequestParams paramRequestParams, Header[] paramArrayOfHeader, HttpResponseHandler paramHttpResponseHandler)
  {
    paramString = new HttpDelete(getUrlWithQueryString(paramString, paramRequestParams));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    sendRequest(paramString, paramHttpResponseHandler, paramContext);
  }
  
  protected void finalize()
    throws Throwable
  {
    Iterator localIterator = this.mRequestMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      cancelRequests((Context)((Map.Entry)localIterator.next()).getKey(), true);
    }
    super.finalize();
  }
  
  public void get(Context paramContext, String paramString, HttpResponseHandler paramHttpResponseHandler)
  {
    get(paramContext, paramString, null, null, paramHttpResponseHandler);
  }
  
  public void get(Context paramContext, String paramString, RequestParams paramRequestParams, HttpResponseHandler paramHttpResponseHandler)
  {
    get(paramContext, paramString, paramRequestParams, null, paramHttpResponseHandler);
  }
  
  public void get(Context paramContext, String paramString, RequestParams paramRequestParams, Header[] paramArrayOfHeader, HttpResponseHandler paramHttpResponseHandler)
  {
    paramString = new HttpGet(getUrlWithQueryString(paramString, paramRequestParams));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    sendRequest(paramString, paramHttpResponseHandler, paramContext);
  }
  
  public void post(Context paramContext, String paramString, HttpResponseHandler paramHttpResponseHandler)
  {
    post(paramContext, paramString, null, null, paramHttpResponseHandler);
  }
  
  public void post(Context paramContext, String paramString, RequestParams paramRequestParams, HttpResponseHandler paramHttpResponseHandler)
  {
    post(paramContext, paramString, paramRequestParams, null, paramHttpResponseHandler);
  }
  
  public void post(Context paramContext, String paramString, RequestParams paramRequestParams, Header[] paramArrayOfHeader, HttpResponseHandler paramHttpResponseHandler)
  {
    paramString = new HttpPost(paramString);
    if (paramRequestParams != null) {
      paramString.setEntity(paramRequestParams.getHttpEntity());
    }
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    sendRequest(paramString, paramHttpResponseHandler, paramContext);
  }
  
  public void put(Context paramContext, String paramString, HttpResponseHandler paramHttpResponseHandler)
  {
    put(paramContext, paramString, null, null, paramHttpResponseHandler);
  }
  
  public void put(Context paramContext, String paramString, RequestParams paramRequestParams, HttpResponseHandler paramHttpResponseHandler)
  {
    put(paramContext, paramString, paramRequestParams, null, paramHttpResponseHandler);
  }
  
  public void put(Context paramContext, String paramString, RequestParams paramRequestParams, Header[] paramArrayOfHeader, HttpResponseHandler paramHttpResponseHandler)
  {
    paramString = new HttpPut(paramString);
    if (paramRequestParams != null) {
      paramString.setEntity(paramRequestParams.getHttpEntity());
    }
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    sendRequest(paramString, paramHttpResponseHandler, paramContext);
  }
  
  protected void sendRequest(HttpUriRequest paramHttpUriRequest, HttpResponseHandler paramHttpResponseHandler, Context paramContext)
  {
    try
    {
      checkNetworkStateAndAdjust(paramContext);
      paramHttpUriRequest = new AsyncHttpRequest(this, new SyncBasicHttpContext(new BasicHttpContext()), paramHttpUriRequest, paramHttpResponseHandler);
      Future localFuture = sThreadPool.submit(paramHttpUriRequest);
      if (paramContext != null)
      {
        paramHttpResponseHandler = (List)this.mRequestMap.get(paramContext);
        paramHttpUriRequest = paramHttpResponseHandler;
        if (paramHttpResponseHandler == null)
        {
          paramHttpUriRequest = new LinkedList();
          this.mRequestMap.put(paramContext, paramHttpUriRequest);
        }
        paramHttpUriRequest.add(new WeakReference(localFuture));
      }
      return;
    }
    catch (NullPointerException paramHttpUriRequest) {}catch (RejectedExecutionException paramHttpUriRequest) {}
  }
  
  public void setMaxRetries(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 3;
    }
    setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(i, false));
  }
  
  public void setNetworkCheckInterval(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 10000) {
      i = 10000;
    }
    this.mNetworkCheckInterval = i;
  }
  
  public void setTimeout(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 15000;
    }
    HttpParams localHttpParams = getParams();
    ConnManagerParams.setTimeout(localHttpParams, i);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, i);
  }
  
  public void setUserAgent(String paramString)
  {
    HttpProtocolParams.setUserAgent(getParams(), paramString);
  }
  
  private static class InflatingEntity
    extends HttpEntityWrapper
  {
    GZIPInputStream gzipStream;
    InputStream wrappedStream;
    
    public InflatingEntity(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public void consumeContent()
      throws IOException
    {
      AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
      AsyncHttpClient.silentCloseInputStream(this.gzipStream);
      super.consumeContent();
    }
    
    public InputStream getContent()
      throws IOException
    {
      this.wrappedStream = this.wrappedEntity.getContent();
      this.gzipStream = new GZIPInputStream(this.wrappedStream);
      return this.gzipStream;
    }
    
    public long getContentLength()
    {
      return -1L;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/cloudsdk/common/http/AsyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */