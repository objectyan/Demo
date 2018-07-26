package com.baidu.navi.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class BaseReqHandler implements Runnable {
    private final AbstractHttpClient mClient;
    private final HttpContext mHttpContext;
    private final HttpUriRequest mRequest;
    private final BaseRspHandler mResponseHandler;

    public BaseReqHandler(AbstractHttpClient client, HttpContext context, HttpUriRequest request, BaseRspHandler responseHandler) {
        this.mClient = client;
        this.mHttpContext = context;
        this.mRequest = request;
        this.mResponseHandler = responseHandler;
        if (responseHandler instanceof FileRspHandler) {
            long previousFileSize = ((FileRspHandler) responseHandler).getPreviousFileSize();
            if (previousFileSize > 0) {
                this.mRequest.setHeader("RANGE", "bytes=" + previousFileSize + "-");
            }
        }
    }

    public void run() {
        if (this.mResponseHandler != null) {
            this.mResponseHandler.handleStartMessage(null);
        }
        try {
            makeRequest();
        } catch (Exception e) {
            Exception e2 = e;
            if (this.mResponseHandler != null) {
                if (e2 == null || e2.getMessage() == null) {
                    e2 = new Exception("unknow error");
                }
                this.mResponseHandler.handleFailureMessage(e2);
            }
        }
        if (this.mResponseHandler != null) {
            this.mResponseHandler.handleFinishMessage(null);
        }
    }

    private void makeRequest() throws Exception {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                HttpResponse response = this.mClient.execute(this.mRequest, this.mHttpContext);
                if (!Thread.currentThread().isInterrupted() && this.mResponseHandler != null) {
                    this.mResponseHandler.handleResponse(response);
                }
            } catch (Exception e) {
                if (!Thread.currentThread().isInterrupted()) {
                    throw e;
                }
            }
        }
    }
}
