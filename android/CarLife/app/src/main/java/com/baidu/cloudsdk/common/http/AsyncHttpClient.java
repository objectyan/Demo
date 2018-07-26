package com.baidu.cloudsdk.common.http;

import android.content.Context;
import com.baidu.android.common.net.ConnectManager;
import com.facebook.common.p141m.C2924g;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
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
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
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

public class AsyncHttpClient extends DefaultHttpClient {
    private static final int DEFAULT_CHECK_INTERVAL = 10000;
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String DEFAULT_USER_AGENT = "Baidu-Android-Lib-V1.0";
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    protected static final ThreadPoolExecutor sThreadPool = ((ThreadPoolExecutor) Executors.newCachedThreadPool());
    protected long mLastCheckTime = 0;
    protected int mNetworkCheckInterval = 10000;
    protected final WeakHashMap<Context, List<WeakReference<Future<?>>>> mRequestMap;

    /* renamed from: com.baidu.cloudsdk.common.http.AsyncHttpClient$1 */
    class C28871 implements ClientConnectionManagerFactory {
        C28871() {
        }

        public ClientConnectionManager newInstance(HttpParams httpparams, SchemeRegistry schemeregistry) {
            SocketFactory sf = SSLSocketFactory.getSocketFactory();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme(C2924g.f12888b, sf, 443));
            return new ThreadSafeClientConnManager(httpparams, schemeregistry);
        }
    }

    /* renamed from: com.baidu.cloudsdk.common.http.AsyncHttpClient$2 */
    class C28882 implements HttpRequestInterceptor {
        C28882() {
        }

        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            if (!request.containsHeader("Accept-Encoding")) {
                request.addHeader("Accept-Encoding", "gzip");
            }
        }
    }

    /* renamed from: com.baidu.cloudsdk.common.http.AsyncHttpClient$3 */
    class C28893 implements HttpResponseInterceptor {
        C28893() {
        }

        public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                Header encoding = entity.getContentEncoding();
                if (encoding != null) {
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
        GZIPInputStream gzipStream;
        InputStream wrappedStream;

        public InflatingEntity(HttpEntity wrapped) {
            super(wrapped);
        }

        public InputStream getContent() throws IOException {
            this.wrappedStream = this.wrappedEntity.getContent();
            this.gzipStream = new GZIPInputStream(this.wrappedStream);
            return this.gzipStream;
        }

        public long getContentLength() {
            return -1;
        }

        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
            AsyncHttpClient.silentCloseInputStream(this.gzipStream);
            super.consumeContent();
        }
    }

    public AsyncHttpClient() {
        HttpParams params = getParams();
        ConnManagerParams.setTimeout(params, 15000);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(params, 10);
        HttpConnectionParams.setSoTimeout(params, 15000);
        HttpConnectionParams.setConnectionTimeout(params, 15000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpConnectionParams.setSocketBufferSize(params, 8192);
        HttpProtocolParams.setUserAgent(params, DEFAULT_USER_AGENT);
        HttpClientParams.setCookiePolicy(params, "compatibility");
        params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY, new C28871());
        addRequestInterceptor(new C28882());
        addResponseInterceptor(new C28893());
        this.mRequestMap = new WeakHashMap();
    }

    protected void finalize() throws Throwable {
        for (Entry<Context, List<WeakReference<Future<?>>>> entry : this.mRequestMap.entrySet()) {
            cancelRequests((Context) entry.getKey(), true);
        }
        super.finalize();
    }

    public void setTimeout(int timeout) {
        if (timeout <= 0) {
            timeout = 15000;
        }
        HttpParams params = getParams();
        ConnManagerParams.setTimeout(params, (long) timeout);
        HttpConnectionParams.setSoTimeout(params, timeout);
        HttpConnectionParams.setConnectionTimeout(params, timeout);
    }

    public void setUserAgent(String userAgent) {
        HttpProtocolParams.setUserAgent(getParams(), userAgent);
    }

    public void setNetworkCheckInterval(int interval) {
        if (interval <= 10000) {
            interval = 10000;
        }
        this.mNetworkCheckInterval = interval;
    }

    public void setMaxRetries(int maxRetries) {
        if (maxRetries <= 0) {
            maxRetries = 3;
        }
        setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(maxRetries, false));
    }

    public void get(Context context, String url, HttpResponseHandler responseHandler) {
        get(context, url, null, null, responseHandler);
    }

    public void get(Context context, String url, RequestParams params, HttpResponseHandler responseHandler) {
        get(context, url, params, null, responseHandler);
    }

    public void get(Context context, String url, RequestParams params, Header[] headers, HttpResponseHandler responseHandler) {
        HttpUriRequest request = new HttpGet(getUrlWithQueryString(url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        sendRequest(request, responseHandler, context);
    }

    public void post(Context context, String url, HttpResponseHandler responseHandler) {
        post(context, url, null, null, responseHandler);
    }

    public void post(Context context, String url, RequestParams params, HttpResponseHandler responseHandler) {
        post(context, url, params, null, responseHandler);
    }

    public void post(Context context, String url, RequestParams params, Header[] headers, HttpResponseHandler responseHandler) {
        HttpEntityEnclosingRequestBase request = new HttpPost(url);
        if (params != null) {
            request.setEntity(params.getHttpEntity());
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        sendRequest(request, responseHandler, context);
    }

    public void delete(Context context, String url, HttpResponseHandler responseHandler) {
        delete(context, url, null, null, responseHandler);
    }

    public void delete(Context context, String url, RequestParams params, HttpResponseHandler responseHandler) {
        delete(context, url, params, null, responseHandler);
    }

    public void delete(Context context, String url, RequestParams params, Header[] headers, HttpResponseHandler responseHandler) {
        HttpUriRequest request = new HttpDelete(getUrlWithQueryString(url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        sendRequest(request, responseHandler, context);
    }

    public void put(Context context, String url, HttpResponseHandler responseHandler) {
        put(context, url, null, null, responseHandler);
    }

    public void put(Context context, String url, RequestParams params, HttpResponseHandler responseHandler) {
        put(context, url, params, null, responseHandler);
    }

    public void put(Context context, String url, RequestParams params, Header[] headers, HttpResponseHandler responseHandler) {
        HttpEntityEnclosingRequestBase request = new HttpPut(url);
        if (params != null) {
            request.setEntity(params.getHttpEntity());
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        sendRequest(request, responseHandler, context);
    }

    public void cancelRequests(Context context, boolean mayInterruptIfRunning) {
        List<WeakReference<Future<?>>> requestList = (List) this.mRequestMap.get(context);
        if (requestList != null) {
            for (WeakReference<Future<?>> requestRef : requestList) {
                Future<?> request = (Future) requestRef.get();
                if (request != null) {
                    request.cancel(mayInterruptIfRunning);
                }
            }
        }
        this.mRequestMap.remove(context);
    }

    public static String getUrlWithQueryString(String url, RequestParams params) {
        if (url == null || params == null) {
            return url;
        }
        String queryString = params.getQueryString();
        if (url.contains("?")) {
            return url + "&" + queryString;
        }
        return url + "?" + queryString;
    }

    public static void silentCloseInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    protected void sendRequest(HttpUriRequest request, HttpResponseHandler responseHandler, Context context) {
        try {
            checkNetworkStateAndAdjust(context);
            Future<?> future = sThreadPool.submit(new AsyncHttpRequest(this, new SyncBasicHttpContext(new BasicHttpContext()), request, responseHandler));
            if (context != null) {
                List<WeakReference<Future<?>>> requestList = (List) this.mRequestMap.get(context);
                if (requestList == null) {
                    requestList = new LinkedList();
                    this.mRequestMap.put(context, requestList);
                }
                requestList.add(new WeakReference(future));
            }
        } catch (RejectedExecutionException e) {
        } catch (NullPointerException e2) {
        }
    }

    private void checkNetworkStateAndAdjust(Context context) {
        if (context != null) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - this.mLastCheckTime > ((long) this.mNetworkCheckInterval)) {
                ConnectManager conman = new ConnectManager(context);
                if (conman.isWapNetwork()) {
                    String host = conman.getProxy();
                    int port = Integer.parseInt(conman.getProxyPort());
                    if (host != null && host.length() > 0) {
                        ConnRouteParams.setDefaultProxy(getParams(), new HttpHost(host, port));
                    }
                } else {
                    ConnRouteParams.setDefaultProxy(getParams(), null);
                }
                this.mLastCheckTime = currentTime;
            }
        }
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
            } catch (Throwable th) {
            }
        }
    }
}
