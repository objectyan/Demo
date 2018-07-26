package com.baidu.mapframework.commonlib.asynchttp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest implements Runnable {
    /* renamed from: a */
    private final AbstractHttpClient f18805a;
    /* renamed from: b */
    private final HttpContext f18806b;
    /* renamed from: c */
    private final HttpUriRequest f18807c;
    /* renamed from: d */
    private final ResponseHandlerInterface f18808d;
    /* renamed from: e */
    private final AtomicBoolean f18809e = new AtomicBoolean();
    /* renamed from: f */
    private int f18810f;
    /* renamed from: g */
    private boolean f18811g;
    /* renamed from: h */
    private volatile boolean f18812h;
    /* renamed from: i */
    private boolean f18813i;

    public AsyncHttpRequest(AbstractHttpClient client, HttpContext context, HttpUriRequest request, ResponseHandlerInterface responseHandler) {
        this.f18805a = (AbstractHttpClient) Utils.notNull(client, "client");
        this.f18806b = (HttpContext) Utils.notNull(context, "context");
        this.f18807c = (HttpUriRequest) Utils.notNull(request, "request");
        this.f18808d = (ResponseHandlerInterface) Utils.notNull(responseHandler, "responseHandler");
    }

    public void onPreProcessRequest(AsyncHttpRequest request) {
    }

    public void onPostProcessRequest(AsyncHttpRequest request) {
    }

    public void run() {
        if (!isCancelled()) {
            if (!this.f18813i) {
                this.f18813i = true;
                onPreProcessRequest(this);
            }
            if (!isCancelled()) {
                this.f18808d.sendStartMessage();
                if (!isCancelled()) {
                    try {
                        m14932b();
                    } catch (IOException e) {
                        if (isCancelled()) {
                            AsyncHttpClient.log.mo2626e("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
                        } else {
                            this.f18808d.sendFailureMessage(0, null, null, e);
                        }
                    }
                    if (!isCancelled()) {
                        this.f18808d.sendFinishMessage();
                        if (!isCancelled()) {
                            onPostProcessRequest(this);
                            this.f18812h = true;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m14931a() throws IOException {
        if (!isCancelled()) {
            if (this.f18807c.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            if (this.f18808d instanceof RangeFileAsyncHttpResponseHandler) {
                ((RangeFileAsyncHttpResponseHandler) this.f18808d).updateRequestHeaders(this.f18807c);
            }
            HttpResponse response = this.f18805a.execute(this.f18807c, this.f18806b);
            if (!isCancelled()) {
                this.f18808d.onPreProcessResponse(this.f18808d, response);
                if (!isCancelled()) {
                    this.f18808d.sendResponseMessage(response);
                    if (!isCancelled()) {
                        this.f18808d.onPostProcessResponse(this.f18808d, response);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m14932b() throws IOException {
        IOException cause;
        int i;
        Exception e;
        boolean retry = true;
        HttpRequestRetryHandler retryHandler = this.f18805a.getHttpRequestRetryHandler();
        IOException cause2 = null;
        while (retry) {
            try {
                m14931a();
                return;
            } catch (UnknownHostException e2) {
                try {
                    cause = new IOException("UnknownHostException exception: " + e2.getMessage());
                    if (this.f18810f > 0) {
                        i = this.f18810f + 1;
                        this.f18810f = i;
                        if (retryHandler.retryRequest(e2, i, this.f18806b)) {
                            retry = true;
                            if (retry) {
                                cause2 = cause;
                            } else {
                                this.f18808d.sendRetryMessage(this.f18810f);
                                cause2 = cause;
                            }
                        }
                    }
                    retry = false;
                    if (retry) {
                        cause2 = cause;
                    } else {
                        this.f18808d.sendRetryMessage(this.f18810f);
                        cause2 = cause;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cause = cause2;
                }
            } catch (NullPointerException e4) {
                cause = new IOException("NPE in HttpClient: " + e4.getMessage());
                i = this.f18810f + 1;
                this.f18810f = i;
                retry = retryHandler.retryRequest(cause, i, this.f18806b);
                if (retry) {
                    this.f18808d.sendRetryMessage(this.f18810f);
                    cause2 = cause;
                } else {
                    cause2 = cause;
                }
            } catch (IOException e5) {
                if (!isCancelled()) {
                    cause = e5;
                    try {
                        i = this.f18810f + 1;
                        this.f18810f = i;
                        retry = retryHandler.retryRequest(cause, i, this.f18806b);
                        if (retry) {
                            cause2 = cause;
                        } else {
                            this.f18808d.sendRetryMessage(this.f18810f);
                            cause2 = cause;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                } else {
                    return;
                }
            }
        }
        cause = cause2;
        throw cause;
        AsyncHttpClient.log.mo2626e("AsyncHttpRequest", "Unhandled exception origin cause", e);
        cause = new IOException("Unhandled exception: " + e.getMessage());
        throw cause;
    }

    public boolean isCancelled() {
        boolean cancelled = this.f18809e.get();
        if (cancelled) {
            m14933c();
        }
        return cancelled;
    }

    /* renamed from: c */
    private synchronized void m14933c() {
        if (!(this.f18812h || !this.f18809e.get() || this.f18811g)) {
            this.f18811g = true;
            this.f18808d.sendCancelMessage();
        }
    }

    public boolean isDone() {
        return isCancelled() || this.f18812h;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        this.f18809e.set(true);
        this.f18807c.abort();
        return isCancelled();
    }

    public AsyncHttpRequest setRequestTag(Object TAG) {
        this.f18808d.setTag(TAG);
        return this;
    }

    public Object getTag() {
        return this.f18808d.getTag();
    }
}
