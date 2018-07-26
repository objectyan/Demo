package com.baidu.tts.loopj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient client, HttpContext context, HttpUriRequest request, ResponseHandlerInterface responseHandler) {
        this.client = (AbstractHttpClient) Utils.notNull(client, "client");
        this.context = (HttpContext) Utils.notNull(context, "context");
        this.request = (HttpUriRequest) Utils.notNull(request, "request");
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
                    } catch (Throwable e) {
                        if (isCancelled()) {
                            AsyncHttpClient.log.mo3897e("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
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
            HttpResponse execute = this.client.execute(this.request, this.context);
            if (!isCancelled()) {
                this.responseHandler.onPreProcessResponse(this.responseHandler, execute);
                if (!isCancelled()) {
                    this.responseHandler.sendResponseMessage(execute);
                    if (!isCancelled()) {
                        this.responseHandler.onPostProcessResponse(this.responseHandler, execute);
                    }
                }
            }
        }
    }

    private void makeRequestWithRetries() throws IOException {
        int i;
        IOException iOException = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                makeRequest();
                return;
            } catch (IOException iOException2) {
                try {
                    boolean z2;
                    IOException iOException3;
                    IOException iOException4 = new IOException("UnknownHostException exception: " + iOException2.getMessage());
                    if (this.executionCount >= 0) {
                        int i2 = this.executionCount + 1;
                        this.executionCount = i2;
                        if (httpRequestRetryHandler.retryRequest(iOException2, i2, this.context)) {
                            z2 = true;
                            iOException3 = iOException4;
                            z = z2;
                            iOException2 = iOException3;
                        }
                    }
                    z2 = false;
                    iOException3 = iOException4;
                    z = z2;
                    iOException2 = iOException3;
                } catch (Throwable e) {
                    Throwable th = e;
                    AsyncHttpClient.log.mo3897e("AsyncHttpRequest", "Unhandled exception origin cause", th);
                    iOException2 = new IOException("Unhandled exception: " + th.getMessage());
                }
            } catch (NullPointerException e2) {
                iOException2 = new IOException("NPE in HttpClient: " + e2.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                z = httpRequestRetryHandler.retryRequest(iOException2, i, this.context);
            } catch (IOException e3) {
                iOException2 = e3;
                if (!isCancelled()) {
                    i = this.executionCount + 1;
                    this.executionCount = i;
                    z = httpRequestRetryHandler.retryRequest(iOException2, i, this.context);
                } else {
                    return;
                }
            }
        }
        throw iOException2;
        if (z) {
            this.responseHandler.sendRetryMessage(this.executionCount);
        }
    }

    public boolean isCancelled() {
        boolean z = this.isCancelled.get();
        if (z) {
            sendCancelNotification();
        }
        return z;
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
