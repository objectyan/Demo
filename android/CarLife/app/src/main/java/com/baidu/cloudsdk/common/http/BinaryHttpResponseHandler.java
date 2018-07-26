package com.baidu.cloudsdk.common.http;

import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public class BinaryHttpResponseHandler extends HttpResponseHandler {
    private String[] mAllowedContentTypes;

    public BinaryHttpResponseHandler() {
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
    }

    public BinaryHttpResponseHandler(String[] allowedContentTypes) {
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
        this.mAllowedContentTypes = allowedContentTypes;
    }

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
    }

    public BinaryHttpResponseHandler(Looper looper, String[] allowedContentTypes) {
        super(looper);
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
        this.mAllowedContentTypes = allowedContentTypes;
    }

    protected void onFailure(Throwable error, byte[] binaryData) {
    }

    protected void onSuccess(byte[] binaryData) {
    }

    protected void onSuccess(int statusCode, byte[] binaryData) {
        onSuccess(binaryData);
    }

    protected void sendSuccessMessage(int statusCode, byte[] binaryData) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(statusCode), binaryData}));
    }

    protected void sendResponseMessage(HttpResponse response) {
        StatusLine status = response.getStatusLine();
        Header[] contentTypeHeaders = response.getHeaders("Content-Type");
        if (contentTypeHeaders.length != 1) {
            sendFailureMessage(new HttpResponseException(status.getStatusCode(), "None or more than one Content-Type Header found!"), (byte[]) null);
            return;
        }
        Header contentTypeHeader = contentTypeHeaders[0];
        boolean foundAllowedContentType = false;
        for (String anAllowedContentType : this.mAllowedContentTypes) {
            if (anAllowedContentType.equalsIgnoreCase(contentTypeHeader.getValue())) {
                foundAllowedContentType = true;
                break;
            }
        }
        if (foundAllowedContentType) {
            byte[] responseBody = null;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    responseBody = EntityUtils.toByteArray(entity);
                } catch (IOException e) {
                    sendFailureMessage((Throwable) e, (byte[]) null);
                    return;
                } finally {
                    AsyncHttpClient.endEntityViaReflection(entity);
                }
            }
            if (status.getStatusCode() >= 300) {
                sendFailureMessage(new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()), responseBody);
                return;
            } else {
                sendSuccessMessage(status.getStatusCode(), responseBody);
                return;
            }
        }
        sendFailureMessage(new HttpResponseException(status.getStatusCode(), "Content-Type not allowed!"), (byte[]) null);
    }

    protected void handleSuccessMessage(int statusCode, byte[] binaryData) {
        onSuccess(statusCode, binaryData);
    }

    protected void handleFailureMessage(Throwable error, byte[] binaryData) {
        onFailure(error, binaryData);
    }

    public void handleMessage(Message msg) {
        Object[] objs;
        switch (msg.what) {
            case 0:
                objs = (Object[]) msg.obj;
                handleSuccessMessage(((Integer) objs[0]).intValue(), (byte[]) objs[1]);
                return;
            case 1:
                objs = (Object[]) msg.obj;
                handleFailureMessage((Throwable) objs[0], (byte[]) objs[1]);
                break;
        }
        super.handleMessage(msg);
    }
}
