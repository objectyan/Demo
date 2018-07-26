package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import com.facebook.common.p141m.C2924g;
import cz.msebera.android.httpclient.C3008n;
import cz.msebera.android.httpclient.C6020w;
import cz.msebera.android.httpclient.C6022z;
import cz.msebera.android.httpclient.C6033u;
import cz.msebera.android.httpclient.C6183p;
import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;
import cz.msebera.android.httpclient.C6364g;
import cz.msebera.android.httpclient.C6592r;
import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.p155a.C2969i;
import cz.msebera.android.httpclient.p155a.C6182h;
import cz.msebera.android.httpclient.p155a.C6188n;
import cz.msebera.android.httpclient.p155a.C6193s;
import cz.msebera.android.httpclient.p157l.C3062j;
import cz.msebera.android.httpclient.p157l.C3128b;
import cz.msebera.android.httpclient.p157l.C3131h;
import cz.msebera.android.httpclient.p157l.C3134m;
import cz.msebera.android.httpclient.p158b.C2997j;
import cz.msebera.android.httpclient.p158b.C2998o;
import cz.msebera.android.httpclient.p158b.C6045h;
import cz.msebera.android.httpclient.p158b.C6265i;
import cz.msebera.android.httpclient.p158b.p159d.C6034q;
import cz.msebera.android.httpclient.p158b.p159d.C6037f;
import cz.msebera.android.httpclient.p158b.p159d.C6233i;
import cz.msebera.android.httpclient.p158b.p159d.C6235k;
import cz.msebera.android.httpclient.p158b.p159d.C6236l;
import cz.msebera.android.httpclient.p158b.p159d.C6237m;
import cz.msebera.android.httpclient.p162e.C3025c;
import cz.msebera.android.httpclient.p162e.p163a.C3002e;
import cz.msebera.android.httpclient.p162e.p163a.C3004g;
import cz.msebera.android.httpclient.p162e.p169c.C3018e;
import cz.msebera.android.httpclient.p162e.p169c.C3019f;
import cz.msebera.android.httpclient.p162e.p169c.C3024j;
import cz.msebera.android.httpclient.p162e.p170e.C3028j;
import cz.msebera.android.httpclient.p168g.C3009j;
import cz.msebera.android.httpclient.p173i.p174a.C3051b;
import cz.msebera.android.httpclient.p173i.p175b.C3059s;
import cz.msebera.android.httpclient.p173i.p177c.p178a.C3085h;
import cz.msebera.android.httpclient.p185n.C6198g;
import cz.msebera.android.httpclient.p185n.C6568a;
import cz.msebera.android.httpclient.p185n.af;
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
    private final C3059s httpClient;
    private final C6198g httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private int responseTimeout;
    private ExecutorService threadPool;

    /* renamed from: com.loopj.android.http.AsyncHttpClient$1 */
    class C60211 implements C6020w {
        C60211() {
        }

        public void process(C6033u request, C6198g context) {
            if (!request.containsHeader("Accept-Encoding")) {
                request.addHeader("Accept-Encoding", "gzip");
            }
            for (String header : AsyncHttpClient.this.clientHeaderMap.keySet()) {
                if (request.containsHeader(header)) {
                    AsyncHttpClient.log.mo4878d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{header, AsyncHttpClient.this.clientHeaderMap.get(header), overwritten.mo5247c(), request.getFirstHeader(header).mo5248d()}));
                    request.removeHeader(overwritten);
                }
                request.addHeader(header, (String) AsyncHttpClient.this.clientHeaderMap.get(header));
            }
        }
    }

    /* renamed from: com.loopj.android.http.AsyncHttpClient$2 */
    class C60232 implements C6022z {
        C60232() {
        }

        public void process(C6228x response, C6198g context) {
            C3008n entity = response.mo5075b();
            if (entity != null) {
                C6327f encoding = entity.getContentEncoding();
                if (encoding != null) {
                    for (C6364g element : encoding.mo5249e()) {
                        if (element.mo5252a().equalsIgnoreCase("gzip")) {
                            response.mo5072a(new InflatingEntity(entity));
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.loopj.android.http.AsyncHttpClient$3 */
    class C60243 implements C6020w {
        C60243() {
        }

        public void process(C6033u request, C6198g context) throws C6183p, IOException {
            C2969i authState = (C2969i) context.mo5023a("http.auth.target-scope");
            C6265i credsProvider = (C6265i) context.mo5023a("http.auth.credentials-provider");
            C6592r targetHost = (C6592r) context.mo5023a("http.target_host");
            if (authState.c() == null) {
                C6188n creds = credsProvider.mo5111a(new C6182h(targetHost.m24203a(), targetHost.m24204b()));
                if (creds != null) {
                    authState.a(new C3051b());
                    authState.a(creds);
                }
            }
        }
    }

    private static class InflatingEntity extends C3009j {
        GZIPInputStream gzippedStream;
        PushbackInputStream pushbackStream;
        InputStream wrappedStream;

        public InflatingEntity(C3008n wrapped) {
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

    public AsyncHttpClient(C3024j schemeRegistry) {
        boolean z = true;
        this.maxConnections = 10;
        this.connectTimeout = 10000;
        this.responseTimeout = 10000;
        this.isUrlEncodingEnabled = true;
        C3128b httpParams = new C3128b();
        C3002e.a(httpParams, (long) this.connectTimeout);
        C3002e.a(httpParams, new C3004g(this.maxConnections));
        C3002e.a(httpParams, 10);
        C3131h.a(httpParams, this.responseTimeout);
        C3131h.d(httpParams, this.connectTimeout);
        C3131h.b(httpParams, true);
        C3131h.b(httpParams, 8192);
        C3134m.a(httpParams, ac.f25260d);
        C3025c cm = createConnectionManager(schemeRegistry, httpParams);
        if (cm == null) {
            z = false;
        }
        Utils.asserts(z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.threadPool = getDefaultThreadPool();
        this.requestMap = Collections.synchronizedMap(new WeakHashMap());
        this.clientHeaderMap = new HashMap();
        this.httpContext = new af(new C6568a());
        this.httpClient = new C3059s(cm, httpParams);
        this.httpClient.a(new C60211());
        this.httpClient.a(new C60232());
        this.httpClient.a(new C60243(), 0);
        this.httpClient.a(new RetryHandler(5, 1500));
    }

    private static C3024j getDefaultSchemeRegistry(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        C3028j sslSocketFactory;
        if (fixNoHttpResponseException) {
            log.mo4878d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (httpPort < 1) {
            httpPort = 80;
            log.mo4878d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (httpsPort < 1) {
            httpsPort = 443;
            log.mo4878d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (fixNoHttpResponseException) {
            sslSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
        } else {
            sslSocketFactory = C3028j.getSocketFactory();
        }
        C3024j schemeRegistry = new C3024j();
        schemeRegistry.a(new C3019f("http", C3018e.a(), httpPort));
        schemeRegistry.a(new C3019f(C2924g.f12888b, sslSocketFactory, httpsPort));
        return schemeRegistry;
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

    public static String getUrlWithQueryString(boolean shouldEncodeUrl, String url, RequestParams params) {
        if (url == null) {
            return null;
        }
        if (shouldEncodeUrl) {
            try {
                URL _url = new URL(URLDecoder.decode(url, "UTF-8"));
                url = new URI(_url.getProtocol(), _url.getUserInfo(), _url.getHost(), _url.getPort(), _url.getPath(), _url.getQuery(), _url.getRef()).toASCIIString();
            } catch (Exception ex) {
                log.mo4881e("AsyncHttpClient", "getUrlWithQueryString encoding URL", ex);
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

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream inputStream) throws IOException {
        boolean z = true;
        if (inputStream == null) {
            return false;
        }
        byte[] signature = new byte[2];
        int count = 0;
        while (count < 2) {
            try {
                int readCount = inputStream.read(signature, count, 2 - count);
                if (readCount < 0) {
                    return false;
                }
                count += readCount;
            } finally {
                inputStream.unread(signature, 0, count);
            }
        }
        inputStream.unread(signature, 0, count);
        if (35615 != ((signature[0] & 255) | ((signature[1] << 8) & 65280))) {
            z = false;
        }
        return z;
    }

    public static void silentCloseInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                log.mo4892w("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    public static void silentCloseOutputStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                log.mo4892w("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    public static void endEntityViaReflection(C3008n entity) {
        if (entity instanceof C3009j) {
            Field f = null;
            try {
                for (Field ff : C3009j.class.getDeclaredFields()) {
                    if (ff.getName().equals("wrappedEntity")) {
                        f = ff;
                        break;
                    }
                }
                if (f != null) {
                    f.setAccessible(true);
                    C3008n wrapped = (C3008n) f.get(entity);
                    if (wrapped != null) {
                        wrapped.consumeContent();
                    }
                }
            } catch (Throwable t) {
                log.mo4881e("AsyncHttpClient", "wrappedEntity consume", t);
            }
        }
    }

    public C2997j getHttpClient() {
        return this.httpClient;
    }

    public C6198g getHttpContext() {
        return this.httpContext;
    }

    public boolean isLoggingEnabled() {
        return log.isLoggingEnabled();
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        log.setLoggingEnabled(loggingEnabled);
    }

    public int getLoggingLevel() {
        return log.getLoggingLevel();
    }

    public void setLoggingLevel(int logLevel) {
        log.setLoggingLevel(logLevel);
    }

    public LogInterface getLogInterface() {
        return log;
    }

    public void setLogInterface(LogInterface logInterfaceInstance) {
        if (logInterfaceInstance != null) {
            log = logInterfaceInstance;
        }
    }

    public void setCookieStore(C6045h cookieStore) {
        this.httpContext.mo5024a("http.cookie-store", cookieStore);
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    protected ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    protected C3025c createConnectionManager(C3024j schemeRegistry, C3128b httpParams) {
        return new C3085h(httpParams, schemeRegistry);
    }

    public void setEnableRedirects(boolean enableRedirects, boolean enableRelativeRedirects, boolean enableCircularRedirects) {
        this.httpClient.a().b("http.protocol.reject-relative-redirect", !enableRelativeRedirects);
        this.httpClient.a().b("http.protocol.allow-circular-redirects", enableCircularRedirects);
        this.httpClient.a(new MyRedirectHandler(enableRedirects));
    }

    public void setEnableRedirects(boolean enableRedirects, boolean enableRelativeRedirects) {
        setEnableRedirects(enableRedirects, enableRelativeRedirects, true);
    }

    public void setEnableRedirects(boolean enableRedirects) {
        setEnableRedirects(enableRedirects, enableRedirects, enableRedirects);
    }

    public void setRedirectHandler(C2998o customRedirectHandler) {
        this.httpClient.a(customRedirectHandler);
    }

    public void setUserAgent(String userAgent) {
        C3134m.c(this.httpClient.a(), userAgent);
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        if (maxConnections < 1) {
            maxConnections = 10;
        }
        this.maxConnections = maxConnections;
        C3002e.a(this.httpClient.a(), new C3004g(this.maxConnections));
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
        C3062j httpParams = this.httpClient.a();
        C3002e.a(httpParams, (long) this.connectTimeout);
        C3131h.d(httpParams, this.connectTimeout);
    }

    public int getResponseTimeout() {
        return this.responseTimeout;
    }

    public void setResponseTimeout(int value) {
        if (value < 1000) {
            value = 10000;
        }
        this.responseTimeout = value;
        C3131h.a(this.httpClient.a(), this.responseTimeout);
    }

    public void setProxy(String hostname, int port) {
        this.httpClient.a().a("http.route.default-proxy", new C6592r(hostname, port));
    }

    public void setProxy(String hostname, int port, String username, String password) {
        this.httpClient.K().mo5113a(new C6182h(hostname, port), new C6193s(username, password));
        this.httpClient.a().a("http.route.default-proxy", new C6592r(hostname, port));
    }

    public void setSSLSocketFactory(C3028j sslSocketFactory) {
        this.httpClient.b().a().a(new C3019f(C2924g.f12888b, sslSocketFactory, 443));
    }

    public void setMaxRetriesAndTimeout(int retries, int timeout) {
        this.httpClient.a(new RetryHandler(retries, timeout));
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

    public void setBasicAuth(String username, String password, C6182h scope) {
        setBasicAuth(username, password, scope, false);
    }

    public void setBasicAuth(String username, String password, C6182h scope, boolean preemptive) {
        setCredentials(scope, new C6193s(username, password));
        setAuthenticationPreemptive(preemptive);
    }

    public void setCredentials(C6182h authScope, C6188n credentials) {
        if (credentials == null) {
            log.mo4878d("AsyncHttpClient", "Provided credentials are null, not setting");
            return;
        }
        C6265i K = this.httpClient.K();
        if (authScope == null) {
            authScope = C6182h.f25178e;
        }
        K.mo5113a(authScope, credentials);
    }

    public void setAuthenticationPreemptive(boolean isPreemptive) {
        if (isPreemptive) {
            this.httpClient.a(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
        } else {
            this.httpClient.b(PreemptiveAuthorizationHttpRequestInterceptor.class);
        }
    }

    public void clearCredentialsProvider() {
        this.httpClient.K().mo5112a();
    }

    public void cancelRequests(Context context, final boolean mayInterruptIfRunning) {
        if (context == null) {
            log.mo4880e("AsyncHttpClient", "Passed null Context to cancelRequests");
            return;
        }
        final List requestList = (List) this.requestMap.get(context);
        this.requestMap.remove(context);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.threadPool.submit(new Runnable() {
                public void run() {
                    AsyncHttpClient.this.cancelRequests(requestList, mayInterruptIfRunning);
                }
            });
            return;
        }
        cancelRequests(requestList, mayInterruptIfRunning);
    }

    private void cancelRequests(List<RequestHandle> requestList, boolean mayInterruptIfRunning) {
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
            log.mo4878d("AsyncHttpClient", "cancelRequestsByTAG, passed TAG is null, cannot proceed");
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
        return sendRequest(this.httpClient, this.httpContext, new C6233i(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle head(Context context, String url, C6327f[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        C6034q request = new C6233i(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
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
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, C6327f[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        C6034q request = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
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

    public RequestHandle post(Context context, String url, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new C6236l(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, C6327f[] headers, RequestParams params, String contentType, ResponseHandlerInterface responseHandler) {
        C6037f request = new C6236l(getURI(url));
        if (params != null) {
            request.setEntity(paramsToEntity(params, responseHandler));
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, C6327f[] headers, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        C6037f request = addEntityToRequestBase(new C6236l(getURI(url)), entity);
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
        return put(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle put(Context context, String url, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new C6237m(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle put(Context context, String url, C6327f[] headers, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        C6037f request = addEntityToRequestBase(new C6237m(getURI(url)), entity);
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
        return patch(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle patch(Context context, String url, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new C6235k(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle patch(Context context, String url, C6327f[] headers, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        C6037f request = addEntityToRequestBase(new C6235k(getURI(url)), entity);
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

    public RequestHandle delete(Context context, String url, C6327f[] headers, ResponseHandlerInterface responseHandler) {
        HttpDelete delete = new HttpDelete(getURI(url));
        if (headers != null) {
            delete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, delete, null, responseHandler, context);
    }

    public void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        sendRequest(this.httpClient, this.httpContext, new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, null);
    }

    public RequestHandle delete(Context context, String url, C6327f[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            httpDelete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, C3008n entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpDelete(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    protected AsyncHttpRequest newAsyncHttpRequest(C3059s client, C6198g httpContext, C6034q uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        return new AsyncHttpRequest(client, httpContext, uriRequest, responseHandler);
    }

    protected RequestHandle sendRequest(C3059s client, C6198g httpContext, C6034q uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (uriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandler == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!responseHandler.getUseSynchronousMode() || responseHandler.getUsePoolThread()) {
            if (contentType != null) {
                if ((uriRequest instanceof C6037f) && ((C6037f) uriRequest).getEntity() != null && uriRequest.containsHeader("Content-Type")) {
                    log.mo4891w("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                } else {
                    uriRequest.setHeader("Content-Type", contentType);
                }
            }
            responseHandler.setRequestHeaders(uriRequest.getAllHeaders());
            responseHandler.setRequestURI(uriRequest.getURI());
            AsyncHttpRequest request = newAsyncHttpRequest(client, httpContext, uriRequest, contentType, responseHandler, context);
            this.threadPool.submit(request);
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

    private C3008n paramsToEntity(RequestParams params, ResponseHandlerInterface responseHandler) {
        C3008n entity = null;
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
        return this.isUrlEncodingEnabled;
    }

    private C6037f addEntityToRequestBase(C6037f requestBase, C3008n entity) {
        if (entity != null) {
            requestBase.setEntity(entity);
        }
        return requestBase;
    }
}
