package com.baidu.tts.loopj;

import android.content.Context;
import android.os.Looper;
import com.facebook.common.p141m.C2924g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient {
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
    private int connectTimeout;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private int responseTimeout;
    private ExecutorService threadPool;

    /* renamed from: com.baidu.tts.loopj.AsyncHttpClient$1 */
    class C51211 implements HttpRequestInterceptor {
        C51211() {
        }

        public void process(HttpRequest request, HttpContext context) {
            if (!request.containsHeader("Accept-Encoding")) {
                request.addHeader("Accept-Encoding", "gzip");
            }
            for (String str : AsyncHttpClient.this.clientHeaderMap.keySet()) {
                if (request.containsHeader(str)) {
                    AsyncHttpClient.log.mo3894d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, AsyncHttpClient.this.clientHeaderMap.get(str), r1.getName(), request.getFirstHeader(str).getValue()}));
                    request.removeHeader(r1);
                }
                request.addHeader(str, (String) AsyncHttpClient.this.clientHeaderMap.get(str));
            }
        }
    }

    /* renamed from: com.baidu.tts.loopj.AsyncHttpClient$2 */
    class C51222 implements HttpResponseInterceptor {
        C51222() {
        }

        public void process(HttpResponse response, HttpContext context) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase("gzip")) {
                            response.setEntity(new InflatingEntity(entity));
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.tts.loopj.AsyncHttpClient$3 */
    class C51233 implements HttpRequestInterceptor {
        C51233() {
        }

        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            AuthState authState = (AuthState) context.getAttribute("http.auth.target-scope");
            CredentialsProvider credentialsProvider = (CredentialsProvider) context.getAttribute("http.auth.credentials-provider");
            HttpHost httpHost = (HttpHost) context.getAttribute("http.target_host");
            if (authState.getAuthScheme() == null) {
                Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()));
                if (credentials != null) {
                    authState.setAuthScheme(new BasicScheme());
                    authState.setCredentials(credentials);
                }
            }
        }
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        GZIPInputStream gzippedStream;
        PushbackInputStream pushbackStream;
        InputStream wrappedStream;

        public InflatingEntity(HttpEntity wrapped) {
            super(wrapped);
        }

        public InputStream getContent() throws IOException {
            this.wrappedStream = this.wrappedEntity.getContent();
            this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
            if (!AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream)) {
                return this.pushbackStream;
            }
            this.gzippedStream = new GZIPInputStream(this.pushbackStream);
            return this.gzippedStream;
        }

        public long getContentLength() {
            return this.wrappedEntity == null ? 0 : this.wrappedEntity.getContentLength();
        }

        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
            AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
            AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
            super.consumeContent();
        }
    }

    public AsyncHttpClient() {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int httpPort) {
        this(false, httpPort, 443);
    }

    public AsyncHttpClient(int httpPort, int httpsPort) {
        this(false, httpPort, httpsPort);
    }

    public AsyncHttpClient(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        this(getDefaultSchemeRegistry(fixNoHttpResponseException, httpPort, httpsPort));
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        SocketFactory socketFactory;
        if (fixNoHttpResponseException) {
            if (httpPort < 1) {
                httpPort = 80;
                log.mo3894d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
            }
            if (httpsPort < 1) {
                httpsPort = 443;
                log.mo3894d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
            }
            if (fixNoHttpResponseException) {
                socketFactory = SSLSocketFactory.getSocketFactory();
            } else {
                socketFactory = MySSLSocketFactory.getFixedSocketFactory();
            }
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), httpPort));
            schemeRegistry.register(new Scheme(C2924g.f12888b, socketFactory, httpsPort));
            return schemeRegistry;
        }
        if (httpPort < 1) {
            httpPort = 80;
            log.mo3894d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (httpsPort < 1) {
            httpsPort = 443;
            log.mo3894d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (fixNoHttpResponseException) {
            socketFactory = SSLSocketFactory.getSocketFactory();
        } else {
            socketFactory = MySSLSocketFactory.getFixedSocketFactory();
        }
        SchemeRegistry schemeRegistry2 = new SchemeRegistry();
        schemeRegistry2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), httpPort));
        schemeRegistry2.register(new Scheme(C2924g.f12888b, socketFactory, httpsPort));
        return schemeRegistry2;
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        boolean z = true;
        this.maxConnections = 10;
        this.connectTimeout = 10000;
        this.responseTimeout = 10000;
        this.isUrlEncodingEnabled = true;
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) this.connectTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.responseTimeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.connectTimeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager createConnectionManager = createConnectionManager(schemeRegistry, basicHttpParams);
        if (createConnectionManager == null) {
            z = false;
        }
        Utils.asserts(z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.threadPool = getDefaultThreadPool();
        this.requestMap = Collections.synchronizedMap(new WeakHashMap());
        this.clientHeaderMap = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(createConnectionManager, basicHttpParams);
        this.httpClient.addRequestInterceptor(new C51211());
        this.httpClient.addResponseInterceptor(new C51222());
        this.httpClient.addRequestInterceptor(new C51233(), 0);
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
    }

    public static void allowRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToWhitelist(cls);
        }
    }

    public static void blockRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToBlacklist(cls);
        }
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext getHttpContext() {
        return this.httpContext;
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        log.setLoggingEnabled(loggingEnabled);
    }

    public boolean isLoggingEnabled() {
        return log.isLoggingEnabled();
    }

    public void setLoggingLevel(int logLevel) {
        log.setLoggingLevel(logLevel);
    }

    public int getLoggingLevel() {
        return log.getLoggingLevel();
    }

    public LogInterface getLogInterface() {
        return log;
    }

    public void setLogInterface(LogInterface logInterfaceInstance) {
        if (logInterfaceInstance != null) {
            log = logInterfaceInstance;
        }
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    protected ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    protected ClientConnectionManager createConnectionManager(SchemeRegistry schemeRegistry, BasicHttpParams httpParams) {
        return new ThreadSafeClientConnManager(httpParams, schemeRegistry);
    }

    public void setEnableRedirects(boolean enableRedirects, boolean enableRelativeRedirects, boolean enableCircularRedirects) {
        this.httpClient.getParams().setBooleanParameter("http.protocol.reject-relative-redirect", !enableRelativeRedirects);
        this.httpClient.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", enableCircularRedirects);
        this.httpClient.setRedirectHandler(new MyRedirectHandler(enableRedirects));
    }

    public void setEnableRedirects(boolean enableRedirects, boolean enableRelativeRedirects) {
        setEnableRedirects(enableRedirects, enableRelativeRedirects, true);
    }

    public void setEnableRedirects(boolean enableRedirects) {
        setEnableRedirects(enableRedirects, enableRedirects, enableRedirects);
    }

    public void setRedirectHandler(RedirectHandler customRedirectHandler) {
        this.httpClient.setRedirectHandler(customRedirectHandler);
    }

    public void setUserAgent(String userAgent) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), userAgent);
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        if (maxConnections < 1) {
            maxConnections = 10;
        }
        this.maxConnections = maxConnections;
        ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), new ConnPerRouteBean(this.maxConnections));
    }

    public void setTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        setConnectTimeout(value);
        setResponseTimeout(value);
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        this.connectTimeout = value;
        HttpParams params = this.httpClient.getParams();
        ConnManagerParams.setTimeout(params, (long) this.connectTimeout);
        HttpConnectionParams.setConnectionTimeout(params, this.connectTimeout);
    }

    public int getResponseTimeout() {
        return this.responseTimeout;
    }

    public void setResponseTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        this.responseTimeout = value;
        HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.responseTimeout);
    }

    public void setProxy(String hostname, int port) {
        this.httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(hostname, port));
    }

    public void setProxy(String hostname, int port, String username, String password) {
        this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(hostname, port), new UsernamePasswordCredentials(username, password));
        this.httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(hostname, port));
    }

    public void setSSLSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(C2924g.f12888b, sslSocketFactory, 443));
    }

    public void setMaxRetriesAndTimeout(int retries, int timeout) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(retries, timeout));
    }

    public void removeAllHeaders() {
        this.clientHeaderMap.clear();
    }

    public void addHeader(String header, String value) {
        this.clientHeaderMap.put(header, value);
    }

    public void removeHeader(String header) {
        this.clientHeaderMap.remove(header);
    }

    public void setBasicAuth(String username, String password) {
        setBasicAuth(username, password, false);
    }

    public void setBasicAuth(String username, String password, boolean preemptive) {
        setBasicAuth(username, password, null, preemptive);
    }

    public void setBasicAuth(String username, String password, AuthScope scope) {
        setBasicAuth(username, password, scope, false);
    }

    public void setBasicAuth(String username, String password, AuthScope scope, boolean preemptive) {
        setCredentials(scope, new UsernamePasswordCredentials(username, password));
        setAuthenticationPreemptive(preemptive);
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        if (credentials == null) {
            log.mo3894d("AsyncHttpClient", "Provided credentials are null, not setting");
            return;
        }
        CredentialsProvider credentialsProvider = this.httpClient.getCredentialsProvider();
        if (authScope == null) {
            authScope = AuthScope.ANY;
        }
        credentialsProvider.setCredentials(authScope, credentials);
    }

    public void setAuthenticationPreemptive(boolean isPreemptive) {
        if (isPreemptive) {
            this.httpClient.addRequestInterceptor(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
        } else {
            this.httpClient.removeRequestInterceptorByClass(PreemptiveAuthorizationHttpRequestInterceptor.class);
        }
    }

    public void clearCredentialsProvider() {
        this.httpClient.getCredentialsProvider().clear();
    }

    public void cancelRequests(Context context, final boolean mayInterruptIfRunning) {
        if (context == null) {
            log.mo3896e("AsyncHttpClient", "Passed null Context to cancelRequests");
            return;
        }
        final List list = (List) this.requestMap.get(context);
        this.requestMap.remove(context);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.threadPool.submit(new Runnable() {
                public void run() {
                    AsyncHttpClient.this.cancelRequests(list, mayInterruptIfRunning);
                }
            });
            return;
        }
        cancelRequests(list, mayInterruptIfRunning);
    }

    private void cancelRequests(List<RequestHandle> requestList, boolean mayInterruptIfRunning) {
        if (requestList != null) {
            for (RequestHandle cancel : requestList) {
                cancel.cancel(mayInterruptIfRunning);
            }
        }
    }

    public void cancelAllRequests(boolean mayInterruptIfRunning) {
        for (List<RequestHandle> list : this.requestMap.values()) {
            if (list != null) {
                for (RequestHandle cancel : list) {
                    cancel.cancel(mayInterruptIfRunning);
                }
            }
        }
        this.requestMap.clear();
    }

    public void cancelRequestsByTAG(Object TAG, boolean mayInterruptIfRunning) {
        if (TAG == null) {
            log.mo3894d("AsyncHttpClient", "cancelRequestsByTAG, passed TAG is null, cannot proceed");
            return;
        }
        for (List<RequestHandle> list : this.requestMap.values()) {
            if (list != null) {
                for (RequestHandle requestHandle : list) {
                    if (TAG.equals(requestHandle.getTag())) {
                        requestHandle.cancel(mayInterruptIfRunning);
                    }
                }
            }
        }
    }

    public RequestHandle head(String url, ResponseHandlerInterface responseHandler) {
        return head(null, url, null, responseHandler);
    }

    public RequestHandle head(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return head(null, url, params, responseHandler);
    }

    public RequestHandle head(Context context, String url, ResponseHandlerInterface responseHandler) {
        return head(context, url, null, responseHandler);
    }

    public RequestHandle head(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle head(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest httpHead = new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            httpHead.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpHead, null, responseHandler, context);
    }

    public RequestHandle get(String url, ResponseHandlerInterface responseHandler) {
        return get(null, url, null, responseHandler);
    }

    public RequestHandle get(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return get(null, url, params, responseHandler);
    }

    public RequestHandle get(Context context, String url, ResponseHandlerInterface responseHandler) {
        return get(context, url, null, responseHandler);
    }

    public RequestHandle get(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest httpGet = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            httpGet.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpGet, null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpGet(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(String url, ResponseHandlerInterface responseHandler) {
        return post(null, url, null, responseHandler);
    }

    public RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(null, url, params, responseHandler);
    }

    public RequestHandle post(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle post(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, RequestParams params, String contentType, ResponseHandlerInterface responseHandler) {
        HttpUriRequest httpPost = new HttpPost(getURI(url));
        if (params != null) {
            httpPost.setEntity(paramsToEntity(params, responseHandler));
        }
        if (headers != null) {
            httpPost.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpPost, contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPost(getURI(url)), entity);
        if (headers != null) {
            addEntityToRequestBase.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, contentType, responseHandler, context);
    }

    public RequestHandle put(String url, ResponseHandlerInterface responseHandler) {
        return put(null, url, null, responseHandler);
    }

    public RequestHandle put(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(null, url, params, responseHandler);
    }

    public RequestHandle put(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle put(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPut(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle put(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPut(getURI(url)), entity);
        if (headers != null) {
            addEntityToRequestBase.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, contentType, responseHandler, context);
    }

    public RequestHandle patch(String url, ResponseHandlerInterface responseHandler) {
        return patch(null, url, null, responseHandler);
    }

    public RequestHandle patch(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return patch(null, url, params, responseHandler);
    }

    public RequestHandle patch(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return patch(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle patch(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPatch(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle patch(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(new HttpPatch(getURI(url)), entity);
        if (headers != null) {
            addEntityToRequestBase.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, contentType, responseHandler, context);
    }

    public RequestHandle delete(String url, ResponseHandlerInterface responseHandler) {
        return delete(null, url, responseHandler);
    }

    public RequestHandle delete(Context context, String url, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, new HttpDelete(getURI(url)), null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, ResponseHandlerInterface responseHandler) {
        HttpUriRequest httpDelete = new HttpDelete(getURI(url));
        if (headers != null) {
            httpDelete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, null, responseHandler, context);
    }

    public void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        sendRequest(this.httpClient, this.httpContext, new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, null);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest httpDelete = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            httpDelete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpDelete(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        return new AsyncHttpRequest(client, httpContext, uriRequest, responseHandler);
    }

    protected RequestHandle sendRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (uriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandler == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!responseHandler.getUseSynchronousMode() || responseHandler.getUsePoolThread()) {
            if (contentType != null) {
                if ((uriRequest instanceof HttpEntityEnclosingRequestBase) && ((HttpEntityEnclosingRequestBase) uriRequest).getEntity() != null && uriRequest.containsHeader("Content-Type")) {
                    log.mo3907w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                } else {
                    uriRequest.setHeader("Content-Type", contentType);
                }
            }
            responseHandler.setRequestHeaders(uriRequest.getAllHeaders());
            responseHandler.setRequestURI(uriRequest.getURI());
            Object newAsyncHttpRequest = newAsyncHttpRequest(client, httpContext, uriRequest, contentType, responseHandler, context);
            this.threadPool.submit(newAsyncHttpRequest);
            RequestHandle requestHandle = new RequestHandle(newAsyncHttpRequest);
            if (context != null) {
                List list;
                synchronized (this.requestMap) {
                    list = (List) this.requestMap.get(context);
                    if (list == null) {
                        list = Collections.synchronizedList(new LinkedList());
                        this.requestMap.put(context, list);
                    }
                }
                list.add(requestHandle);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((RequestHandle) it.next()).shouldBeGarbageCollected()) {
                        it.remove();
                    }
                }
            }
            return requestHandle;
        } else {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
    }

    protected URI getURI(String url) {
        return URI.create(url).normalize();
    }

    public void setURLEncodingEnabled(boolean enabled) {
        this.isUrlEncodingEnabled = enabled;
    }

    public static String getUrlWithQueryString(boolean shouldEncodeUrl, String url, RequestParams params) {
        if (url == null) {
            return null;
        }
        if (shouldEncodeUrl) {
            try {
                URL url2 = new URL(URLDecoder.decode(url, "UTF-8"));
                url = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef()).toASCIIString();
            } catch (Throwable e) {
                log.mo3897e("AsyncHttpClient", "getUrlWithQueryString encoding URL", e);
            }
        }
        if (params != null) {
            String trim = params.getParamString().trim();
            if (!(trim.equals("") || trim.equals("?"))) {
                url = (url + (url.contains("?") ? "&" : "?")) + trim;
            }
        }
        return url;
    }

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream inputStream) throws IOException {
        boolean z = true;
        if (inputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int read = inputStream.read(bArr);
        inputStream.unread(bArr);
        int i = ((bArr[1] << 8) & 65280) | (bArr[0] & 255);
        if (!(read == 2 && 35615 == i)) {
            z = false;
        }
        return z;
    }

    public static void silentCloseInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (Throwable e) {
                log.mo3908w("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    public static void silentCloseOutputStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (Throwable e) {
                log.mo3908w("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    private HttpEntity paramsToEntity(RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpEntity httpEntity = null;
        if (params != null) {
            try {
                httpEntity = params.getEntity(responseHandler);
            } catch (Throwable e) {
                if (responseHandler != null) {
                    responseHandler.sendFailureMessage(0, httpEntity, httpEntity, e);
                } else {
                    e.printStackTrace();
                }
            }
        }
        return httpEntity;
    }

    public boolean isUrlEncodingEnabled() {
        return this.isUrlEncodingEnabled;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase requestBase, HttpEntity entity) {
        if (entity != null) {
            requestBase.setEntity(entity);
        }
        return requestBase;
    }

    public static void endEntityViaReflection(HttpEntity entity) {
        if (entity instanceof HttpEntityWrapper) {
            try {
                for (Field field : HttpEntityWrapper.class.getDeclaredFields()) {
                    if (field.getName().equals("wrappedEntity")) {
                        break;
                    }
                }
                Field field2 = null;
                if (field2 != null) {
                    field2.setAccessible(true);
                    HttpEntity httpEntity = (HttpEntity) field2.get(entity);
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                }
            } catch (Throwable th) {
                log.mo3897e("AsyncHttpClient", "wrappedEntity consume", th);
            }
        }
    }
}
