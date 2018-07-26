package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import android.os.Looper;
import com.baidu.mapframework.commonlib.http.DNSProxy;
import com.baidu.mapframework.commonlib.http.DNSProxyCompatX509HostnameVerifier;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.network.NetworkManager;
import com.baidu.mapframework.nirvana.network.NetworkTask;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
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
    public static final String HEADER_HOST = "Host";
    public static final String HEADER_ORG_HOST = "_org_host_";
    public static final String LOG_TAG = "AsyncHttpClient";
    public static LogInterface log = new LogHandler();
    protected static DNSProxy sDNS_PROXY;
    /* renamed from: a */
    final Map<String, String> f18799a;
    /* renamed from: b */
    boolean f18800b;
    /* renamed from: c */
    private int f18801c;
    /* renamed from: d */
    private int f18802d;
    /* renamed from: e */
    private int f18803e;
    /* renamed from: f */
    private ExecutorService f18804f;
    protected final DefaultHttpClient httpClient;
    protected final HttpContext httpContext;
    protected final Map<Context, List<RequestHandle>> requestMap;

    /* renamed from: com.baidu.mapframework.commonlib.asynchttp.AsyncHttpClient$1 */
    class C34881 implements HttpRequestInterceptor {
        /* renamed from: a */
        final /* synthetic */ AsyncHttpClient f18790a;

        C34881(AsyncHttpClient this$0) {
            this.f18790a = this$0;
        }

        public void process(HttpRequest request, HttpContext context) {
            if (!request.containsHeader("Accept-Encoding")) {
                request.addHeader("Accept-Encoding", "gzip");
            }
            if (request.containsHeader(AsyncHttpClient.HEADER_ORG_HOST) && request.containsHeader("Host")) {
                Header orgHost = request.getFirstHeader(AsyncHttpClient.HEADER_ORG_HOST);
                Header host = request.getFirstHeader("Host");
                if (request.containsHeader("Host")) {
                    request.removeHeader(host);
                }
                request.addHeader("Host", request.getFirstHeader(AsyncHttpClient.HEADER_ORG_HOST).getValue());
                request.removeHeader(orgHost);
            }
            for (String header : this.f18790a.f18799a.keySet()) {
                if (request.containsHeader(header)) {
                    AsyncHttpClient.log.mo2623d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{header, this.f18790a.f18799a.get(header), overwritten.getName(), request.getFirstHeader(header).getValue()}));
                    request.removeHeader(overwritten);
                }
                request.addHeader(header, (String) this.f18790a.f18799a.get(header));
            }
        }
    }

    /* renamed from: com.baidu.mapframework.commonlib.asynchttp.AsyncHttpClient$2 */
    class C34892 implements HttpResponseInterceptor {
        /* renamed from: a */
        final /* synthetic */ AsyncHttpClient f18791a;

        C34892(AsyncHttpClient this$0) {
            this.f18791a = this$0;
        }

        public void process(HttpResponse response, HttpContext context) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                Header encoding = entity.getContentEncoding();
                if (encoding != null) {
                    for (HeaderElement element : encoding.getElements()) {
                        if (element.getName().equalsIgnoreCase("gzip")) {
                            response.setEntity(new InflatingEntity(entity));
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.mapframework.commonlib.asynchttp.AsyncHttpClient$3 */
    class C34903 implements HttpRequestInterceptor {
        /* renamed from: a */
        final /* synthetic */ AsyncHttpClient f18792a;

        C34903(AsyncHttpClient this$0) {
            this.f18792a = this$0;
        }

        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            AuthState authState = (AuthState) context.getAttribute("http.auth.target-scope");
            CredentialsProvider credsProvider = (CredentialsProvider) context.getAttribute("http.auth.credentials-provider");
            HttpHost targetHost = (HttpHost) context.getAttribute("http.target_host");
            if (authState.getAuthScheme() == null) {
                Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()));
                if (creds != null) {
                    authState.setAuthScheme(new BasicScheme());
                    authState.setCredentials(creds);
                }
            }
        }
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        /* renamed from: a */
        InputStream f18796a;
        /* renamed from: b */
        PushbackInputStream f18797b;
        /* renamed from: c */
        GZIPInputStream f18798c;

        public InflatingEntity(HttpEntity wrapped) {
            super(wrapped);
        }

        public InputStream getContent() throws IOException {
            this.f18796a = this.wrappedEntity.getContent();
            this.f18797b = new PushbackInputStream(this.f18796a, 2);
            if (!AsyncHttpClient.isInputStreamGZIPCompressed(this.f18797b)) {
                return this.f18797b;
            }
            this.f18798c = new GZIPInputStream(this.f18797b);
            return this.f18798c;
        }

        public long getContentLength() {
            return this.wrappedEntity == null ? 0 : this.wrappedEntity.getContentLength();
        }

        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.f18796a);
            AsyncHttpClient.silentCloseInputStream(this.f18797b);
            AsyncHttpClient.silentCloseInputStream(this.f18798c);
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
        this(m14926a(fixNoHttpResponseException, httpPort, httpsPort));
    }

    /* renamed from: a */
    private static SchemeRegistry m14926a(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        SSLSocketFactory sslSocketFactory;
        if (fixNoHttpResponseException) {
            log.mo2623d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (httpPort < 1) {
            httpPort = 80;
            log.mo2623d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (httpsPort < 1) {
            httpsPort = 443;
            log.mo2623d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (fixNoHttpResponseException) {
            sslSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
        } else {
            sslSocketFactory = SSLSocketFactory.getSocketFactory();
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), httpPort));
        schemeRegistry.register(new Scheme(C2924g.f12888b, sslSocketFactory, httpsPort));
        return schemeRegistry;
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        boolean z = true;
        this.f18801c = 10;
        this.f18802d = 10000;
        this.f18803e = 10000;
        this.f18800b = false;
        BasicHttpParams httpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(httpParams, (long) this.f18802d);
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams, new ConnPerRouteBean(this.f18801c));
        ConnManagerParams.setMaxTotalConnections(httpParams, 10);
        HttpConnectionParams.setSoTimeout(httpParams, this.f18803e);
        HttpConnectionParams.setConnectionTimeout(httpParams, this.f18802d);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager cm = createConnectionManager(schemeRegistry, httpParams);
        if (cm == null) {
            z = false;
        }
        Utils.asserts(z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.f18804f = getDefaultThreadPool();
        this.requestMap = Collections.synchronizedMap(new WeakHashMap());
        this.f18799a = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(cm, httpParams);
        this.httpClient.addRequestInterceptor(new C34881(this));
        this.httpClient.addResponseInterceptor(new C34892(this));
        this.httpClient.addRequestInterceptor(new C34903(this), 0);
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
        setEnableRedirects(false);
    }

    public static void allowRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.m14968a(cls);
        }
    }

    public static void blockRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.m14969b(cls);
        }
    }

    public static void setDNSProxy(DNSProxy dnsProxy) {
        sDNS_PROXY = dnsProxy;
        SSLSocketFactory sslSocketFactory = SSLSocketFactory.getSocketFactory();
        DNSProxyCompatX509HostnameVerifier x509HostnameVerifierWrapper = new DNSProxyCompatX509HostnameVerifier(sslSocketFactory.getHostnameVerifier());
        x509HostnameVerifierWrapper.setDNSProxy(sDNS_PROXY);
        sslSocketFactory.setHostnameVerifier(x509HostnameVerifierWrapper);
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

    public ExecutorService getThreadPool() {
        return this.f18804f;
    }

    protected ExecutorService getDefaultThreadPool() {
        return NetworkManager.getAppNetworkThreadPool();
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
        return this.f18801c;
    }

    public void setMaxConnections(int maxConnections) {
        if (maxConnections < 1) {
            maxConnections = 10;
        }
        this.f18801c = maxConnections;
        ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), new ConnPerRouteBean(this.f18801c));
    }

    public void setTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        setConnectTimeout(value);
        setResponseTimeout(value);
    }

    public int getConnectTimeout() {
        return this.f18802d;
    }

    public void setConnectTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        this.f18802d = value;
        HttpParams httpParams = this.httpClient.getParams();
        ConnManagerParams.setTimeout(httpParams, (long) this.f18802d);
        HttpConnectionParams.setConnectionTimeout(httpParams, this.f18802d);
    }

    public int getResponseTimeout() {
        return this.f18803e;
    }

    public void setResponseTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        this.f18803e = value;
        HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.f18803e);
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
        this.f18799a.clear();
    }

    public void addHeader(String header, String value) {
        this.f18799a.put(header, value);
    }

    public void removeHeader(String header) {
        this.f18799a.remove(header);
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
            log.mo2623d("AsyncHttpClient", "Provided credentials are null, not setting");
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
            log.mo2625e("AsyncHttpClient", "Passed null Context to cancelRequests");
            return;
        }
        final List requestList = (List) this.requestMap.get(context);
        this.requestMap.remove(context);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f18804f.submit(new Runnable(this) {
                /* renamed from: c */
                final /* synthetic */ AsyncHttpClient f18795c;

                public void run() {
                    this.f18795c.m14928a(requestList, mayInterruptIfRunning);
                }
            });
            return;
        }
        m14928a(requestList, mayInterruptIfRunning);
    }

    /* renamed from: a */
    private void m14928a(List<RequestHandle> requestList, boolean mayInterruptIfRunning) {
        if (requestList != null) {
            for (RequestHandle requestHandle : requestList) {
                requestHandle.cancel(mayInterruptIfRunning);
            }
        }
    }

    public void cancelAllRequests(boolean mayInterruptIfRunning) {
        for (List<RequestHandle> requestList : this.requestMap.values()) {
            if (requestList != null) {
                for (RequestHandle requestHandle : requestList) {
                    requestHandle.cancel(mayInterruptIfRunning);
                }
            }
        }
        this.requestMap.clear();
    }

    public void cancelRequestsByTAG(Object TAG, boolean mayInterruptIfRunning) {
        if (TAG == null) {
            log.mo2623d("AsyncHttpClient", "cancelRequestsByTAG, passed TAG is null, cannot proceed");
            return;
        }
        for (List<RequestHandle> requestList : this.requestMap.values()) {
            if (requestList != null) {
                for (RequestHandle requestHandle : requestList) {
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
        return sendRequest(this.httpClient, this.httpContext, new HttpHead(getUrlWithQueryString(this.f18800b, url, params)), null, responseHandler, context);
    }

    public RequestHandle head(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest request = new HttpHead(getUrlWithQueryString(this.f18800b, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, null, responseHandler, context);
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
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.f18800b, url, params)), null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest request = new HttpGet(getUrlWithQueryString(this.f18800b, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpGet(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(String url, ResponseHandlerInterface responseHandler) {
        return post(null, url, null, responseHandler);
    }

    public RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(null, url, params, responseHandler);
    }

    public RequestHandle post(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(context, url, m14929a(params, responseHandler), null, responseHandler);
    }

    public RequestHandle post(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpPost(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, RequestParams params, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = new HttpPost(getURI(url));
        if (params != null) {
            request.setEntity(m14929a(params, responseHandler));
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = m14930a(new HttpPost(getURI(url)), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle put(String url, ResponseHandlerInterface responseHandler) {
        return put(null, url, null, responseHandler);
    }

    public RequestHandle put(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(null, url, params, responseHandler);
    }

    public RequestHandle put(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(context, url, m14929a(params, responseHandler), null, responseHandler);
    }

    public RequestHandle put(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpPut(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle put(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = m14930a(new HttpPut(getURI(url)), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle patch(String url, ResponseHandlerInterface responseHandler) {
        return patch(null, url, null, responseHandler);
    }

    public RequestHandle patch(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return patch(null, url, params, responseHandler);
    }

    public RequestHandle patch(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return patch(context, url, m14929a(params, responseHandler), null, responseHandler);
    }

    public RequestHandle patch(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpPatch(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle patch(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = m14930a(new HttpPatch(getURI(url)), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle delete(String url, ResponseHandlerInterface responseHandler) {
        return delete(null, url, responseHandler);
    }

    public RequestHandle delete(Context context, String url, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, new HttpDelete(getURI(url)), null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, ResponseHandlerInterface responseHandler) {
        HttpDelete delete = new HttpDelete(getURI(url));
        if (headers != null) {
            delete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, delete, null, responseHandler, context);
    }

    public void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        sendRequest(this.httpClient, this.httpContext, new HttpDelete(getUrlWithQueryString(this.f18800b, url, params)), null, responseHandler, null);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(this.f18800b, url, params));
        if (headers != null) {
            httpDelete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpDelete(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    public static String getUrlWithQueryString(boolean shouldEncodeUrl, String url, RequestParams params) {
        if (url == null) {
            return null;
        }
        if (shouldEncodeUrl) {
            try {
                URL _url = new URL(URLDecoder.decode(url, "UTF-8"));
                url = new URI(_url.getProtocol(), _url.getUserInfo(), _url.getHost(), _url.getPort(), _url.getPath(), _url.getQuery(), _url.getRef()).toASCIIString();
            } catch (Exception ex) {
                log.mo2626e("AsyncHttpClient", "getUrlWithQueryString encoding URL", ex);
            }
        }
        if (params != null) {
            String paramString = params.getParamString().trim();
            if (!(paramString.equals("") || paramString.equals("?"))) {
                url = (url + (url.contains("?") ? "&" : "?")) + paramString;
            }
        }
        return url;
    }

    protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        return new AsyncHttpRequest(client, httpContext, uriRequest, responseHandler);
    }

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream inputStream) throws IOException {
        boolean z = true;
        if (inputStream == null) {
            return false;
        }
        byte[] signature = new byte[2];
        int readStatus = inputStream.read(signature);
        inputStream.unread(signature);
        int streamHeader = (signature[0] & 255) | ((signature[1] << 8) & 65280);
        if (!(readStatus == 2 && 35615 == streamHeader)) {
            z = false;
        }
        return z;
    }

    protected RequestHandle sendRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        AsyncHttpRequest request = m14924a(client, httpContext, uriRequest, contentType, responseHandler, context);
        NetworkTask task = new NetworkTask(uriRequest.getURI().toString(), uriRequest, null, request);
        if (responseHandler instanceof NirvanaResponseHandlerInterface) {
            NetworkManager.executeTask(((NirvanaResponseHandlerInterface) responseHandler).getNirvanaModule(), task, ((NirvanaResponseHandlerInterface) responseHandler).getNirvanaScheduleConfig());
        } else {
            NetworkManager.executeTask(Module.SEARCH_FRAMEWORK_MODULE, task, ScheduleConfig.forData());
        }
        return m14925a(request, context);
    }

    /* renamed from: a */
    private AsyncHttpRequest m14924a(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (uriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandler == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!responseHandler.getUseSynchronousMode() || responseHandler.getUsePoolThread()) {
            if (contentType != null) {
                if ((uriRequest instanceof HttpEntityEnclosingRequestBase) && ((HttpEntityEnclosingRequestBase) uriRequest).getEntity() != null && uriRequest.containsHeader("Content-Type")) {
                    log.mo2636w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                } else {
                    uriRequest.setHeader("Content-Type", contentType);
                }
            }
            responseHandler.setRequestHeaders(uriRequest.getAllHeaders());
            responseHandler.setRequestURI(uriRequest.getURI());
            URI uri = uriRequest.getURI();
            String url = uri.toString();
            String host = uri.getHost();
            if (sDNS_PROXY != null) {
                String ip = sDNS_PROXY.getIP(host);
                if (!(ip == null || ip.equals(""))) {
                    sDNS_PROXY.putIP2DomainsRecord(ip, host);
                    url = url.replace(host, ip);
                    if (uriRequest instanceof HttpRequestBase) {
                        ((HttpRequestBase) uriRequest).setURI(URI.create(url));
                    }
                    uriRequest.setHeader(HEADER_ORG_HOST, host);
                }
            }
            return newAsyncHttpRequest(client, httpContext, uriRequest, contentType, responseHandler, context);
        } else {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
    }

    /* renamed from: a */
    private RequestHandle m14925a(AsyncHttpRequest request, Context context) {
        RequestHandle requestHandle = new RequestHandle(request);
        if (context != null) {
            List<RequestHandle> requestList;
            synchronized (this.requestMap) {
                requestList = (List) this.requestMap.get(context);
                if (requestList == null) {
                    requestList = Collections.synchronizedList(new LinkedList());
                    this.requestMap.put(context, requestList);
                }
            }
            requestList.add(requestHandle);
            Iterator<RequestHandle> iterator = requestList.iterator();
            while (iterator.hasNext()) {
                if (((RequestHandle) iterator.next()).shouldBeGarbageCollected()) {
                    iterator.remove();
                }
            }
        }
        return requestHandle;
    }

    protected RequestHandle sendNirvanaRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, NirvanaResponseHandlerInterface responseHandler, Context context) {
        AsyncHttpRequest request = m14924a(client, httpContext, uriRequest, contentType, responseHandler, context);
        NetworkManager.executeTask(responseHandler.getNirvanaModule(), new NetworkTask(uriRequest.getURI().toString(), uriRequest, null, request), responseHandler.getNirvanaScheduleConfig());
        return m14925a(request, context);
    }

    public static void silentCloseInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                log.mo2637w("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    protected URI getURI(String url) {
        return URI.create(url).normalize();
    }

    public static void silentCloseOutputStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                log.mo2637w("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    public void setURLEncodingEnabled(boolean enabled) {
        this.f18800b = enabled;
    }

    /* renamed from: a */
    HttpEntity m14929a(RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpEntity entity = null;
        if (params != null) {
            try {
                entity = params.getEntity(responseHandler);
            } catch (IOException e) {
                if (responseHandler != null) {
                    responseHandler.sendFailureMessage(0, null, null, e);
                } else {
                    e.printStackTrace();
                }
            }
        }
        return entity;
    }

    public boolean isUrlEncodingEnabled() {
        return this.f18800b;
    }

    /* renamed from: a */
    HttpEntityEnclosingRequestBase m14930a(HttpEntityEnclosingRequestBase requestBase, HttpEntity entity) {
        if (entity != null) {
            requestBase.setEntity(entity);
        }
        return requestBase;
    }

    public static void endEntityViaReflection(HttpEntity entity) {
        if (entity instanceof HttpEntityWrapper) {
            Field f = null;
            try {
                for (Field ff : HttpEntityWrapper.class.getDeclaredFields()) {
                    if (ff.getName().equals("wrappedEntity")) {
                        f = ff;
                        break;
                    }
                }
                if (f != null) {
                    f.setAccessible(true);
                    HttpEntity wrapped = (HttpEntity) f.get(entity);
                    if (wrapped != null) {
                        wrapped.consumeContent();
                    }
                }
            } catch (Throwable t) {
                log.mo2626e("AsyncHttpClient", "wrappedEntity consume", t);
            }
        }
    }
}
