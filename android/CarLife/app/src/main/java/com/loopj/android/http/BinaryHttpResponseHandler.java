package com.loopj.android.http;

import android.os.Looper;
import cz.msebera.android.httpclient.C6228x;
import cz.msebera.android.httpclient.C6327f;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.p158b.C6266l;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "BinaryHttpRH";
    private String[] mAllowedContentTypes;

    public abstract void onFailure(int i, C6327f[] c6327fArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, C6327f[] c6327fArr, byte[] bArr);

    public BinaryHttpResponseHandler() {
        this.mAllowedContentTypes = new String[]{"application/octet-stream", "image/jpeg", "image/png", "image/gif"};
    }

    public BinaryHttpResponseHandler(String[] allowedContentTypes) {
        this.mAllowedContentTypes = new String[]{"application/octet-stream", "image/jpeg", "image/png", "image/gif"};
        if (allowedContentTypes != null) {
            this.mAllowedContentTypes = allowedContentTypes;
        } else {
            AsyncHttpClient.log.mo4880e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }

    public BinaryHttpResponseHandler(String[] allowedContentTypes, Looper looper) {
        super(looper);
        this.mAllowedContentTypes = new String[]{"application/octet-stream", "image/jpeg", "image/png", "image/gif"};
        if (allowedContentTypes != null) {
            this.mAllowedContentTypes = allowedContentTypes;
        } else {
            AsyncHttpClient.log.mo4880e(LOG_TAG, "Constructor passed allowedContentTypes was null !");
        }
    }

    public String[] getAllowedContentTypes() {
        return this.mAllowedContentTypes;
    }

    public final void sendResponseMessage(C6228x response) throws IOException {
        int i = 0;
        an status = response.mo5067a();
        C6327f[] contentTypeHeaders = response.getHeaders("Content-Type");
        if (contentTypeHeaders.length != 1) {
            sendFailureMessage(status.mo5266b(), response.getAllHeaders(), null, new C6266l(status.mo5266b(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        C6327f contentTypeHeader = contentTypeHeaders[0];
        boolean foundAllowedContentType = false;
        String[] allowedContentTypes = getAllowedContentTypes();
        int length = allowedContentTypes.length;
        while (i < length) {
            String anAllowedContentType = allowedContentTypes[i];
            try {
                if (Pattern.matches(anAllowedContentType, contentTypeHeader.mo5248d())) {
                    foundAllowedContentType = true;
                }
            } catch (PatternSyntaxException e) {
                AsyncHttpClient.log.mo4881e(LOG_TAG, "Given pattern is not valid: " + anAllowedContentType, e);
            }
            i++;
        }
        if (foundAllowedContentType) {
            super.sendResponseMessage(response);
        } else {
            sendFailureMessage(status.mo5266b(), response.getAllHeaders(), null, new C6266l(status.mo5266b(), "Content-Type (" + contentTypeHeader.mo5248d() + ") not allowed!"));
        }
    }
}
