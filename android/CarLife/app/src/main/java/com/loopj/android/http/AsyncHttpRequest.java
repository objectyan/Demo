package com.loopj.android.http;

import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.p158b.C6048k;
import cz.msebera.android.httpclient.p158b.p159d.C6034q;
import cz.msebera.android.httpclient.p173i.p175b.C3058c;
import cz.msebera.android.httpclient.p185n.C6198g;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final C3058c client;
    private final C6198g context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final C6034q request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(C3058c client, C6198g context, C6034q request, ResponseHandlerInterface responseHandler) {
        this.client = (C3058c) Utils.notNull(client, "client");
        this.context = (C6198g) Utils.notNull(context, "context");
        this.request = (C6034q) Utils.notNull(request, "request");
        this.responseHandler = (ResponseHandlerInterface) Utils.notNull(responseHandler, "responseHandler");
    }

    public void onPreProcessRequest(AsyncHttpRequest request) {
    }

    public void onPostProcessRequest(AsyncHttpRequest request) {
    }

    public void run() {
        if (!isCancelled()) {
            if (!this.isRequestPreProcessed) {
                this.isRequestPreProcessed = true;
                onPreProcessRequest(this);
            }
            if (!isCancelled()) {
                this.responseHandler.sendStartMessage();
                if (!isCancelled()) {
                    try {
                        makeRequestWithRetries();
                    } catch (IOException e) {
                        if (isCancelled()) {
                            AsyncHttpClient.log.mo4881e("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
                        } else {
                            this.responseHandler.sendFailureMessage(0, null, null, e);
                        }
                    }
                    if (!isCancelled()) {
                        this.responseHandler.sendFinishMessage();
                        if (!isCancelled()) {
                            onPostProcessRequest(this);
                            this.isFinished = true;
                        }
                    }
                }
            }
        }
    }

    private void makeRequest() throws IOException {
        if (!isCancelled()) {
            if (this.request.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            if (this.responseHandler instanceof RangeFileAsyncHttpResponseHandler) {
                ((RangeFileAsyncHttpResponseHandler) this.responseHandler).updateRequestHeaders(this.request);
            }
            C6228x response = this.client.b(this.request, this.context);
            if (!isCancelled()) {
                this.responseHandler.onPreProcessResponse(this.responseHandler, response);
                if (!isCancelled()) {
                    this.responseHandler.sendResponseMessage(response);
                    if (!isCancelled()) {
                        this.responseHandler.onPostProcessResponse(this.responseHandler, response);
                    }
                }
            }
        }
    }

    private void makeRequestWithRetries() throws IOException {
        IOException cause;
        int i;
        Exception e;
        boolean retry = true;
        C6048k retryHandler = this.client.C();
        IOException cause2 = null;
        while (retry) {
            try {
                makeRequest();
                return;
            } catch (UnknownHostException e2) {
                try {
                    cause = new IOException("UnknownHostException exception: " + e2.getMessage());
                    if (this.executionCount > 0) {
                        i = this.executionCount + 1;
                        this.executionCount = i;
                        if (retryHandler.retryRequest(e2, i, this.context)) {
                            retry = true;
                            if (retry) {
                                cause2 = cause;
                            } else {
                                this.responseHandler.sendRetryMessage(this.executionCount);
                                cause2 = cause;
                            }
                        }
                    }
                    retry = false;
                    if (retry) {
                        cause2 = cause;
                    } else {
                        this.responseHandler.sendRetryMessage(this.executionCount);
                        cause2 = cause;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cause = cause2;
                }
            } catch (NullPointerException e4) {
                cause = new IOException("NPE in HttpClient: " + e4.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                retry = retryHandler.retryRequest(cause, i, this.context);
                if (retry) {
                    this.responseHandler.sendRetryMessage(this.executionCount);
                    cause2 = cause;
                } else {
                    cause2 = cause;
                }
            } catch (IOException e5) {
                if (!isCancelled()) {
                    cause = e5;
                    try {
                        i = this.executionCount + 1;
                        this.executionCount = i;
                        retry = retryHandler.retryRequest(cause, i, this.context);
                        if (retry) {
                            cause2 = cause;
                        } else {
                            this.responseHandler.sendRetryMessage(this.executionCount);
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
        AsyncHttpClient.log.mo4881e("AsyncHttpRequest", "Unhandled exception origin cause", e);
        cause = new IOException("Unhandled exception: " + e.getMessage());
        throw cause;
    }

    public boolean isCancelled() {
        boolean cancelled = this.isCancelled.get();
        if (cancelled) {
            sendCancelNotification();
        }
        return cancelled;
    }

    private synchronized void sendCancelNotification() {
        if (!(this.isFinished || !this.isCancelled.get() || this.cancelIsNotified)) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
        }
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        this.isCancelled.set(true);
        this.request.abort();
        return isCancelled();
    }

    public AsyncHttpRequest setRequestTag(Object TAG) {
        this.responseHandler.setTag(TAG);
        return this;
    }

    public Object getTag() {
        return this.responseHandler.getTag();
    }
}
