package com.loopj.android.http;

import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;

public class BlackholeHttpResponseHandler extends AsyncHttpResponseHandler {
    public void onSuccess(int statusCode, C6327f[] headers, byte[] responseBody) {
    }

    public void onFailure(int statusCode, C6327f[] headers, byte[] responseBody, Throwable error) {
    }

    public void onProgress(long bytesWritten, long totalSize) {
    }

    public void onCancel() {
    }

    public void onFinish() {
    }

    public void onPostProcessResponse(ResponseHandlerInterface instance, C6228x response) {
    }

    public void onPreProcessResponse(ResponseHandlerInterface instance, C6228x response) {
    }

    public void onRetry(int retryNo) {
    }

    public void onStart() {
    }

    public void onUserException(Throwable error) {
    }
}
