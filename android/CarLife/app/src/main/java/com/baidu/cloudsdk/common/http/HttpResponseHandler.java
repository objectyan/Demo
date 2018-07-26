package com.baidu.cloudsdk.common.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public class HttpResponseHandler extends Handler {
    protected static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    protected String mDefaultCharset;

    public HttpResponseHandler() {
        this("UTF-8");
    }

    public HttpResponseHandler(String defaultCharset) {
        this.mDefaultCharset = defaultCharset;
    }

    public HttpResponseHandler(Looper looper) {
        super(looper);
        this.mDefaultCharset = "UTF-8";
    }

    protected void onStart() {
    }

    protected void onFinish() {
    }

    protected void onFailure(Throwable error, String responseBody) {
    }

    protected void onSuccess(String responseBody) {
    }

    protected void onSuccess(int statusCode, String responseBody) {
        onSuccess(responseBody);
    }

    protected void sendStartMessage() {
        sendMessage(obtainMessage(2));
    }

    protected void sendFinishMessage() {
        sendMessage(obtainMessage(3));
    }

    protected void sendFailureMessage(Throwable error, String responseBody) {
        sendMessage(obtainMessage(1, new Object[]{error, responseBody}));
    }

    protected void sendFailureMessage(Throwable error, byte[] responseBody) {
        sendMessage(obtainMessage(1, new Object[]{error, responseBody}));
    }

    protected void sendSuccessMessage(int statusCode, String responseBody) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(statusCode), responseBody}));
    }

    protected void sendResponseMessage(HttpResponse response) {
        String responseBody = null;
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                responseBody = EntityUtils.toString(entity, this.mDefaultCharset);
            } catch (Throwable e) {
                sendFailureMessage(e, (String) null);
                return;
            } finally {
                AsyncHttpClient.endEntityViaReflection(entity);
            }
        }
        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() >= 300) {
            sendFailureMessage(new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()), responseBody);
        } else {
            sendSuccessMessage(status.getStatusCode(), responseBody);
        }
    }

    protected void handleSuccessMessage(int statusCode, String responseBody) {
        onSuccess(statusCode, responseBody);
    }

    protected void handleFailureMessage(Throwable error, String responseBody) {
        onFailure(error, responseBody);
    }

    public void handleMessage(Message msg) {
        Object[] objs;
        switch (msg.what) {
            case 0:
                objs = (Object[]) msg.obj;
                handleSuccessMessage(((Integer) objs[0]).intValue(), (String) objs[1]);
                return;
            case 1:
                objs = (Object[]) msg.obj;
                handleFailureMessage((Throwable) objs[0], (String) objs[1]);
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            default:
                return;
        }
    }
}
