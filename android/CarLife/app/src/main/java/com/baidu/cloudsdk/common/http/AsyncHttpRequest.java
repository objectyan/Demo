package com.baidu.cloudsdk.common.http;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class AsyncHttpRequest implements Runnable {
    private AbstractHttpClient mHttpClient;
    private HttpContext mHttpContext;
    private boolean mIsBinaryRequest;
    private HttpUriRequest mRequest;
    private HttpResponseHandler mResponseHandler;

    public AsyncHttpRequest(AbstractHttpClient httpClient, HttpContext httpContext, HttpUriRequest request, HttpResponseHandler responseHandler) {
        this.mHttpClient = httpClient;
        this.mHttpContext = httpContext;
        this.mRequest = request;
        this.mResponseHandler = responseHandler;
        this.mIsBinaryRequest = responseHandler instanceof BinaryHttpResponseHandler;
    }

    public void run() {
        try {
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendStartMessage();
            }
            makeRequest();
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendFinishMessage();
            }
        } catch (InterruptedException e) {
        } catch (Throwable e2) {
            if (this.mResponseHandler != null) {
                this.mResponseHandler.sendFinishMessage();
                if (this.mIsBinaryRequest) {
                    this.mResponseHandler.sendFailureMessage(e2, (byte[]) null);
                } else {
                    this.mResponseHandler.sendFailureMessage(e2, (String) null);
                }
            }
        }
    }

    private void makeRequest() throws IOException, InterruptedException {
        if (!Thread.currentThread().isInterrupted()) {
            HttpResponse response = this.mHttpClient.execute(this.mRequest, this.mHttpContext);
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("the request has been cancelled");
            } else if (this.mResponseHandler != null) {
                this.mResponseHandler.sendResponseMessage(response);
            }
        }
    }
}
