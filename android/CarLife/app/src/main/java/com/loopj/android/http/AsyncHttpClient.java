package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.b.d.k;
import cz.msebera.android.httpclient.b.d.l;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.o;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.n.a;
import cz.msebera.android.httpclient.n.af;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

public class AsyncHttpClient
{
  public static final int DEFAULT_MAX_CONNECTIONS = 10;
  public static final int DEFAULT_MAX_RETRIES = 5;
  public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
  public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
  public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
  public static final String ENCODING_GZIP = "gzip";
  public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
  public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
  public static final String HEADER_CONTENT_RANGE = "Content-Range";
  public static final String HEADER_CONTENT_TYPE = "Content-Type";
  public static final String LOG_TAG = "AsyncHttpClient";
  public static LogInterface log = new LogHandler();
  private final Map<String, String> clientHeaderMap;
  private int connectTimeout = 10000;
  private final cz.msebera.android.httpclient.i.b.s httpClient;
  private final cz.msebera.android.httpclient.n.g httpContext;
  private boolean isUrlEncodingEnabled = true;
  private int maxConnections = 10;
  private final Map<Context, List<RequestHandle>> requestMap;
  private int responseTimeout = 10000;
  private ExecutorService threadPool;
  
  public AsyncHttpClient()
  {
    this(false, 80, 443);
  }
  
  public AsyncHttpClient(int paramInt)
  {
    this(false, paramInt, 443);
  }
  
  public AsyncHttpClient(int paramInt1, int paramInt2)
  {
    this(false, paramInt1, paramInt2);
  }
  
  public AsyncHttpClient(cz.msebera.android.httpclient.e.c.j paramj)
  {
    cz.msebera.android.httpclient.l.b localb = new cz.msebera.android.httpclient.l.b();
    cz.msebera.android.httpclient.e.a.e.a(localb, this.connectTimeout);
    cz.msebera.android.httpclient.e.a.e.a(localb, new cz.msebera.android.httpclient.e.a.g(this.maxConnections));
    cz.msebera.android.httpclient.e.a.e.a(localb, 10);
    cz.msebera.android.httpclient.l.h.a(localb, this.responseTimeout);
    cz.msebera.android.httpclient.l.h.d(localb, this.connectTimeout);
    cz.msebera.android.httpclient.l.h.b(localb, true);
    cz.msebera.android.httpclient.l.h.b(localb, 8192);
    cz.msebera.android.httpclient.l.m.a(localb, ac.d);
    paramj = createConnectionManager(paramj, localb);
    if (paramj != null) {}
    for (;;)
    {
      Utils.asserts(bool, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
      this.threadPool = getDefaultThreadPool();
      this.requestMap = Collections.synchronizedMap(new WeakHashMap());
      this.clientHeaderMap = new HashMap();
      this.httpContext = new af(new a());
      this.httpClient = new cz.msebera.android.httpclient.i.b.s(paramj, localb);
      this.httpClient.a(new w()
      {
        public void process(u paramAnonymousu, cz.msebera.android.httpclient.n.g paramAnonymousg)
        {
          if (!paramAnonymousu.containsHeader("Accept-Encoding")) {
            paramAnonymousu.addHeader("Accept-Encoding", "gzip");
          }
          paramAnonymousg = AsyncHttpClient.this.clientHeaderMap.keySet().iterator();
          while (paramAnonymousg.hasNext())
          {
            String str = (String)paramAnonymousg.next();
            if (paramAnonymousu.containsHeader(str))
            {
              cz.msebera.android.httpclient.f localf = paramAnonymousu.getFirstHeader(str);
              AsyncHttpClient.log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] { str, AsyncHttpClient.this.clientHeaderMap.get(str), localf.c(), localf.d() }));
              paramAnonymousu.removeHeader(localf);
            }
            paramAnonymousu.addHeader(str, (String)AsyncHttpClient.this.clientHeaderMap.get(str));
          }
        }
      });
      this.httpClient.a(new z()
      {
        public void process(x paramAnonymousx, cz.msebera.android.httpclient.n.g paramAnonymousg)
        {
          paramAnonymousg = paramAnonymousx.b();
          if (paramAnonymousg == null) {}
          for (;;)
          {
            return;
            Object localObject = paramAnonymousg.getContentEncoding();
            if (localObject != null)
            {
              localObject = ((cz.msebera.android.httpclient.f)localObject).e();
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                if (localObject[i].a().equalsIgnoreCase("gzip"))
                {
                  paramAnonymousx.a(new AsyncHttpClient.InflatingEntity(paramAnonymousg));
                  return;
                }
                i += 1;
              }
            }
          }
        }
      });
      this.httpClient.a(new w()
      {
        public void process(u paramAnonymousu, cz.msebera.android.httpclient.n.g paramAnonymousg)
          throws p, IOException
        {
          paramAnonymousu = (cz.msebera.android.httpclient.a.i)paramAnonymousg.a("http.auth.target-scope");
          cz.msebera.android.httpclient.b.i locali = (cz.msebera.android.httpclient.b.i)paramAnonymousg.a("http.auth.credentials-provider");
          paramAnonymousg = (r)paramAnonymousg.a("http.target_host");
          if (paramAnonymousu.c() == null)
          {
            paramAnonymousg = locali.a(new cz.msebera.android.httpclient.a.h(paramAnonymousg.a(), paramAnonymousg.b()));
            if (paramAnonymousg != null)
            {
              paramAnonymousu.a(new cz.msebera.android.httpclient.i.a.b());
              paramAnonymousu.a(paramAnonymousg);
            }
          }
        }
      }, 0);
      this.httpClient.a(new RetryHandler(5, 1500));
      return;
      bool = false;
    }
  }
  
  public AsyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(getDefaultSchemeRegistry(paramBoolean, paramInt1, paramInt2));
  }
  
  private cz.msebera.android.httpclient.b.d.f addEntityToRequestBase(cz.msebera.android.httpclient.b.d.f paramf, cz.msebera.android.httpclient.n paramn)
  {
    if (paramn != null) {
      paramf.setEntity(paramn);
    }
    return paramf;
  }
  
  public static void allowRetryExceptionClass(Class<?> paramClass)
  {
    if (paramClass != null) {
      RetryHandler.addClassToWhitelist(paramClass);
    }
  }
  
  public static void blockRetryExceptionClass(Class<?> paramClass)
  {
    if (paramClass != null) {
      RetryHandler.addClassToBlacklist(paramClass);
    }
  }
  
  private void cancelRequests(List<RequestHandle> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((RequestHandle)paramList.next()).cancel(paramBoolean);
      }
    }
  }
  
  public static void endEntityViaReflection(cz.msebera.android.httpclient.n paramn)
  {
    Object localObject2;
    if ((paramn instanceof cz.msebera.android.httpclient.g.j)) {
      localObject2 = null;
    }
    try
    {
      Field[] arrayOfField = cz.msebera.android.httpclient.g.j.class.getDeclaredFields();
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
            paramn = (cz.msebera.android.httpclient.n)((Field)localObject1).get(paramn);
            if (paramn != null) {
              paramn.consumeContent();
            }
          }
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramn)
    {
      log.e("AsyncHttpClient", "wrappedEntity consume", paramn);
    }
  }
  
  private static cz.msebera.android.httpclient.e.c.j getDefaultSchemeRegistry(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
    }
    int i = paramInt1;
    if (paramInt1 < 1)
    {
      i = 80;
      log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 1)
    {
      paramInt1 = 443;
      log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
    }
    if (paramBoolean) {}
    for (cz.msebera.android.httpclient.e.e.j localj = MySSLSocketFactory.getFixedSocketFactory();; localj = cz.msebera.android.httpclient.e.e.j.getSocketFactory())
    {
      cz.msebera.android.httpclient.e.c.j localj1 = new cz.msebera.android.httpclient.e.c.j();
      localj1.a(new cz.msebera.android.httpclient.e.c.f("http", cz.msebera.android.httpclient.e.c.e.a(), i));
      localj1.a(new cz.msebera.android.httpclient.e.c.f("https", localj, paramInt1));
      return localj1;
    }
  }
  
  public static String getUrlWithQueryString(boolean paramBoolean, String paramString, RequestParams paramRequestParams)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (paramBoolean) {}
    try
    {
      localObject = new URL(URLDecoder.decode(paramString, "UTF-8"));
      localObject = new URI(((URL)localObject).getProtocol(), ((URL)localObject).getUserInfo(), ((URL)localObject).getHost(), ((URL)localObject).getPort(), ((URL)localObject).getPath(), ((URL)localObject).getQuery(), ((URL)localObject).getRef()).toASCIIString();
      paramString = (String)localObject;
      if (paramRequestParams != null)
      {
        paramRequestParams = paramRequestParams.getParamString().trim();
        paramString = (String)localObject;
        if (!paramRequestParams.equals(""))
        {
          paramString = (String)localObject;
          if (!paramRequestParams.equals("?"))
          {
            StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
            if (!((String)localObject).contains("?")) {
              break label182;
            }
            paramString = "&";
            paramString = paramString;
            paramString = paramString + paramRequestParams;
          }
        }
      }
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        log.e("AsyncHttpClient", "getUrlWithQueryString encoding URL", localException);
        String str = paramString;
        continue;
        label182:
        paramString = "?";
      }
    }
  }
  
  public static boolean isInputStreamGZIPCompressed(PushbackInputStream paramPushbackInputStream)
    throws IOException
  {
    boolean bool = true;
    if (paramPushbackInputStream == null) {
      return false;
    }
    byte[] arrayOfByte = new byte[2];
    int i = 0;
    for (;;)
    {
      if (i < 2) {}
      try
      {
        int j = paramPushbackInputStream.read(arrayOfByte, i, 2 - i);
        if (j < 0) {
          return false;
        }
        i += j;
      }
      finally
      {
        paramPushbackInputStream.unread(arrayOfByte, 0, i);
      }
    }
    paramPushbackInputStream.unread(arrayOfByte, 0, i);
    if (35615 == (arrayOfByte[0] & 0xFF | arrayOfByte[1] << 8 & 0xFF00)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private cz.msebera.android.httpclient.n paramsToEntity(RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    cz.msebera.android.httpclient.n localn = null;
    if (paramRequestParams != null) {}
    try
    {
      localn = paramRequestParams.getEntity(paramResponseHandlerInterface);
      return localn;
    }
    catch (IOException paramRequestParams)
    {
      if (paramResponseHandlerInterface != null)
      {
        paramResponseHandlerInterface.sendFailureMessage(0, null, null, paramRequestParams);
        return null;
      }
      paramRequestParams.printStackTrace();
    }
    return null;
  }
  
  public static void silentCloseInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      log.w("AsyncHttpClient", "Cannot close input stream", paramInputStream);
    }
  }
  
  public static void silentCloseOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      log.w("AsyncHttpClient", "Cannot close output stream", paramOutputStream);
    }
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.clientHeaderMap.put(paramString1, paramString2);
  }
  
  public void cancelAllRequests(boolean paramBoolean)
  {
    Iterator localIterator = this.requestMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RequestHandle)((Iterator)localObject).next()).cancel(paramBoolean);
        }
      }
    }
    this.requestMap.clear();
  }
  
  public void cancelRequests(Context paramContext, final boolean paramBoolean)
  {
    if (paramContext == null)
    {
      log.e("AsyncHttpClient", "Passed null Context to cancelRequests");
      return;
    }
    final List localList = (List)this.requestMap.get(paramContext);
    this.requestMap.remove(paramContext);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramContext = new Runnable()
      {
        public void run()
        {
          AsyncHttpClient.this.cancelRequests(localList, paramBoolean);
        }
      };
      this.threadPool.submit(paramContext);
      return;
    }
    cancelRequests(localList, paramBoolean);
  }
  
  public void cancelRequestsByTAG(Object paramObject, boolean paramBoolean)
  {
    label17:
    Iterator localIterator;
    if (paramObject == null)
    {
      log.d("AsyncHttpClient", "cancelRequestsByTAG, passed TAG is null, cannot proceed");
      return;
    }
    else
    {
      localIterator = this.requestMap.values().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label17;
      }
      Object localObject = (List)localIterator.next();
      if (localObject == null) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RequestHandle localRequestHandle = (RequestHandle)((Iterator)localObject).next();
        if (paramObject.equals(localRequestHandle.getTag())) {
          localRequestHandle.cancel(paramBoolean);
        }
      }
    }
  }
  
  public void clearCredentialsProvider()
  {
    this.httpClient.K().a();
  }
  
  protected c createConnectionManager(cz.msebera.android.httpclient.e.c.j paramj, cz.msebera.android.httpclient.l.b paramb)
  {
    return new cz.msebera.android.httpclient.i.c.a.h(paramb, paramj);
  }
  
  public RequestHandle delete(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString = new HttpDelete(getURI(paramString));
    return sendRequest(this.httpClient, this.httpContext, paramString, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(Context paramContext, String paramString1, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpDelete(URI.create(paramString1).normalize()), paramn), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(Context paramContext, String paramString, cz.msebera.android.httpclient.f[] paramArrayOff, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOff != null) {
      paramString.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(Context paramContext, String paramString, cz.msebera.android.httpclient.f[] paramArrayOff, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString = new HttpDelete(getURI(paramString));
    if (paramArrayOff != null) {
      paramString.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle delete(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return delete(null, paramString, paramResponseHandlerInterface);
  }
  
  public void delete(String paramString, RequestParams paramRequestParams, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    paramString = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    sendRequest(this.httpClient, this.httpContext, paramString, null, paramAsyncHttpResponseHandler, null);
  }
  
  public RequestHandle get(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(paramContext, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle get(Context paramContext, String paramString1, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpGet(URI.create(paramString1).normalize()), paramn), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(Context paramContext, String paramString, cz.msebera.android.httpclient.f[] paramArrayOff, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOff != null) {
      paramString.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle get(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public int getConnectTimeout()
  {
    return this.connectTimeout;
  }
  
  protected ExecutorService getDefaultThreadPool()
  {
    return Executors.newCachedThreadPool();
  }
  
  public cz.msebera.android.httpclient.b.j getHttpClient()
  {
    return this.httpClient;
  }
  
  public cz.msebera.android.httpclient.n.g getHttpContext()
  {
    return this.httpContext;
  }
  
  public LogInterface getLogInterface()
  {
    return log;
  }
  
  public int getLoggingLevel()
  {
    return log.getLoggingLevel();
  }
  
  public int getMaxConnections()
  {
    return this.maxConnections;
  }
  
  public int getResponseTimeout()
  {
    return this.responseTimeout;
  }
  
  public ExecutorService getThreadPool()
  {
    return this.threadPool;
  }
  
  protected URI getURI(String paramString)
  {
    return URI.create(paramString).normalize();
  }
  
  public RequestHandle head(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, new cz.msebera.android.httpclient.b.d.i(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle head(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(paramContext, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle head(Context paramContext, String paramString, cz.msebera.android.httpclient.f[] paramArrayOff, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString = new cz.msebera.android.httpclient.b.d.i(getUrlWithQueryString(this.isUrlEncodingEnabled, paramString, paramRequestParams));
    if (paramArrayOff != null) {
      paramString.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString, null, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle head(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle head(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public boolean isLoggingEnabled()
  {
    return log.isLoggingEnabled();
  }
  
  public boolean isUrlEncodingEnabled()
  {
    return this.isUrlEncodingEnabled;
  }
  
  protected AsyncHttpRequest newAsyncHttpRequest(cz.msebera.android.httpclient.i.b.s params, cz.msebera.android.httpclient.n.g paramg, q paramq, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    return new AsyncHttpRequest(params, paramg, paramq, paramResponseHandlerInterface);
  }
  
  public RequestHandle patch(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return patch(paramContext, paramString, paramsToEntity(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }
  
  public RequestHandle patch(Context paramContext, String paramString1, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new k(getURI(paramString1)), paramn), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle patch(Context paramContext, String paramString1, cz.msebera.android.httpclient.f[] paramArrayOff, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString1 = addEntityToRequestBase(new k(getURI(paramString1)), paramn);
    if (paramArrayOff != null) {
      paramString1.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle patch(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return patch(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle patch(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return patch(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(paramContext, paramString, paramsToEntity(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new l(getURI(paramString1)), paramn), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, cz.msebera.android.httpclient.f[] paramArrayOff, RequestParams paramRequestParams, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString1 = new l(getURI(paramString1));
    if (paramRequestParams != null) {
      paramString1.setEntity(paramsToEntity(paramRequestParams, paramResponseHandlerInterface));
    }
    if (paramArrayOff != null) {
      paramString1.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, cz.msebera.android.httpclient.f[] paramArrayOff, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString1 = addEntityToRequestBase(new l(getURI(paramString1)), paramn);
    if (paramArrayOff != null) {
      paramString1.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle post(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(paramContext, paramString, paramsToEntity(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(Context paramContext, String paramString1, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new cz.msebera.android.httpclient.b.d.m(getURI(paramString1)), paramn), paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle put(Context paramContext, String paramString1, cz.msebera.android.httpclient.f[] paramArrayOff, cz.msebera.android.httpclient.n paramn, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramString1 = addEntityToRequestBase(new cz.msebera.android.httpclient.b.d.m(getURI(paramString1)), paramn);
    if (paramArrayOff != null) {
      paramString1.setHeaders(paramArrayOff);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle put(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public RequestHandle put(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(null, paramString, null, paramResponseHandlerInterface);
  }
  
  public void removeAllHeaders()
  {
    this.clientHeaderMap.clear();
  }
  
  public void removeHeader(String paramString)
  {
    this.clientHeaderMap.remove(paramString);
  }
  
  protected RequestHandle sendRequest(cz.msebera.android.httpclient.i.b.s params, cz.msebera.android.httpclient.n.g paramg, q paramq, String arg4, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    if (paramq == null) {
      throw new IllegalArgumentException("HttpUriRequest must not be null");
    }
    if (paramResponseHandlerInterface == null) {
      throw new IllegalArgumentException("ResponseHandler must not be null");
    }
    if ((paramResponseHandlerInterface.getUseSynchronousMode()) && (!paramResponseHandlerInterface.getUsePoolThread())) {
      throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
    }
    if (??? != null)
    {
      if ((!(paramq instanceof cz.msebera.android.httpclient.b.d.f)) || (((cz.msebera.android.httpclient.b.d.f)paramq).getEntity() == null) || (!paramq.containsHeader("Content-Type"))) {
        break label278;
      }
      log.w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
    }
    for (;;)
    {
      paramResponseHandlerInterface.setRequestHeaders(paramq.getAllHeaders());
      paramResponseHandlerInterface.setRequestURI(paramq.getURI());
      params = newAsyncHttpRequest(params, paramg, paramq, ???, paramResponseHandlerInterface, paramContext);
      this.threadPool.submit(params);
      paramq = new RequestHandle(params);
      if (paramContext != null) {
        synchronized (this.requestMap)
        {
          paramg = (List)this.requestMap.get(paramContext);
          params = paramg;
          if (paramg == null)
          {
            params = Collections.synchronizedList(new LinkedList());
            this.requestMap.put(paramContext, params);
          }
          params.add(paramq);
          params = params.iterator();
          while (params.hasNext()) {
            if (((RequestHandle)params.next()).shouldBeGarbageCollected())
            {
              params.remove();
              continue;
              label278:
              paramq.setHeader("Content-Type", ???);
            }
          }
        }
      }
    }
    return paramq;
  }
  
  public void setAuthenticationPreemptive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.httpClient.a(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
      return;
    }
    this.httpClient.b(PreemptiveAuthorizationHttpRequestInterceptor.class);
  }
  
  public void setBasicAuth(String paramString1, String paramString2)
  {
    setBasicAuth(paramString1, paramString2, false);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, cz.msebera.android.httpclient.a.h paramh)
  {
    setBasicAuth(paramString1, paramString2, paramh, false);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, cz.msebera.android.httpclient.a.h paramh, boolean paramBoolean)
  {
    setCredentials(paramh, new cz.msebera.android.httpclient.a.s(paramString1, paramString2));
    setAuthenticationPreemptive(paramBoolean);
  }
  
  public void setBasicAuth(String paramString1, String paramString2, boolean paramBoolean)
  {
    setBasicAuth(paramString1, paramString2, null, paramBoolean);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1000) {
      i = 10000;
    }
    this.connectTimeout = i;
    cz.msebera.android.httpclient.l.j localj = this.httpClient.a();
    cz.msebera.android.httpclient.e.a.e.a(localj, this.connectTimeout);
    cz.msebera.android.httpclient.l.h.d(localj, this.connectTimeout);
  }
  
  public void setCookieStore(cz.msebera.android.httpclient.b.h paramh)
  {
    this.httpContext.a("http.cookie-store", paramh);
  }
  
  public void setCredentials(cz.msebera.android.httpclient.a.h paramh, cz.msebera.android.httpclient.a.n paramn)
  {
    if (paramn == null)
    {
      log.d("AsyncHttpClient", "Provided credentials are null, not setting");
      return;
    }
    cz.msebera.android.httpclient.b.i locali = this.httpClient.K();
    cz.msebera.android.httpclient.a.h localh = paramh;
    if (paramh == null) {
      localh = cz.msebera.android.httpclient.a.h.e;
    }
    locali.a(localh, paramn);
  }
  
  public void setEnableRedirects(boolean paramBoolean)
  {
    setEnableRedirects(paramBoolean, paramBoolean, paramBoolean);
  }
  
  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2)
  {
    setEnableRedirects(paramBoolean1, paramBoolean2, true);
  }
  
  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    cz.msebera.android.httpclient.l.j localj = this.httpClient.a();
    if (!paramBoolean2) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localj.b("http.protocol.reject-relative-redirect", paramBoolean2);
      this.httpClient.a().b("http.protocol.allow-circular-redirects", paramBoolean3);
      this.httpClient.a(new MyRedirectHandler(paramBoolean1));
      return;
    }
  }
  
  public void setLogInterface(LogInterface paramLogInterface)
  {
    if (paramLogInterface != null) {
      log = paramLogInterface;
    }
  }
  
  public void setLoggingEnabled(boolean paramBoolean)
  {
    log.setLoggingEnabled(paramBoolean);
  }
  
  public void setLoggingLevel(int paramInt)
  {
    log.setLoggingLevel(paramInt);
  }
  
  public void setMaxConnections(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 10;
    }
    this.maxConnections = i;
    cz.msebera.android.httpclient.e.a.e.a(this.httpClient.a(), new cz.msebera.android.httpclient.e.a.g(this.maxConnections));
  }
  
  public void setMaxRetriesAndTimeout(int paramInt1, int paramInt2)
  {
    this.httpClient.a(new RetryHandler(paramInt1, paramInt2));
  }
  
  public void setProxy(String paramString, int paramInt)
  {
    paramString = new r(paramString, paramInt);
    this.httpClient.a().a("http.route.default-proxy", paramString);
  }
  
  public void setProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.httpClient.K().a(new cz.msebera.android.httpclient.a.h(paramString1, paramInt), new cz.msebera.android.httpclient.a.s(paramString2, paramString3));
    paramString1 = new r(paramString1, paramInt);
    this.httpClient.a().a("http.route.default-proxy", paramString1);
  }
  
  public void setRedirectHandler(o paramo)
  {
    this.httpClient.a(paramo);
  }
  
  public void setResponseTimeout(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1000) {
      i = 10000;
    }
    this.responseTimeout = i;
    cz.msebera.android.httpclient.l.h.a(this.httpClient.a(), this.responseTimeout);
  }
  
  public void setSSLSocketFactory(cz.msebera.android.httpclient.e.e.j paramj)
  {
    this.httpClient.b().a().a(new cz.msebera.android.httpclient.e.c.f("https", paramj, 443));
  }
  
  public void setThreadPool(ExecutorService paramExecutorService)
  {
    this.threadPool = paramExecutorService;
  }
  
  public void setTimeout(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1000) {
      i = 10000;
    }
    setConnectTimeout(i);
    setResponseTimeout(i);
  }
  
  public void setURLEncodingEnabled(boolean paramBoolean)
  {
    this.isUrlEncodingEnabled = paramBoolean;
  }
  
  public void setUserAgent(String paramString)
  {
    cz.msebera.android.httpclient.l.m.c(this.httpClient.a(), paramString);
  }
  
  private static class InflatingEntity
    extends cz.msebera.android.httpclient.g.j
  {
    GZIPInputStream gzippedStream;
    PushbackInputStream pushbackStream;
    InputStream wrappedStream;
    
    public InflatingEntity(cz.msebera.android.httpclient.n paramn)
    {
      super();
    }
    
    public void consumeContent()
      throws IOException
    {
      AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
      AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
      AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
      super.consumeContent();
    }
    
    public InputStream getContent()
      throws IOException
    {
      this.wrappedStream = this.wrappedEntity.getContent();
      this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
      if (AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream))
      {
        this.gzippedStream = new GZIPInputStream(this.pushbackStream);
        return this.gzippedStream;
      }
      return this.pushbackStream;
    }
    
    public long getContentLength()
    {
      if (this.wrappedEntity == null) {
        return 0L;
      }
      return this.wrappedEntity.getContentLength();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/AsyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */