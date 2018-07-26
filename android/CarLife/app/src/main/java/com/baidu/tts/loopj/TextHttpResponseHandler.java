package com.baidu.tts.loopj;

import org.apache.http.Header;

public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "TextHttpRH";

    public abstract void onFailure(int i, Header[] headerArr, String str, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, String str);

    public TextHttpResponseHandler() {
        this("UTF-8");
    }

    public TextHttpResponseHandler(String encoding) {
        setCharset(encoding);
    }

    public void onSuccess(int statusCode, Header[] headers, byte[] responseBytes) {
        onSuccess(statusCode, headers, getResponseString(responseBytes, getCharset()));
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        onFailure(statusCode, headers, getResponseString(responseBytes, getCharset()), throwable);
    }

    public static String getResponseString(byte[] stringBytes, String charset) {
        String str = stringBytes == null ? null : new String(stringBytes, charset);
        if (str != null) {
            try {
                if (str.startsWith("﻿")) {
                    return str.substring(1);
                }
            } catch (Throwable e) {
                AsyncHttpClient.log.mo3897e(LOG_TAG, "Encoding response into string failed", e);
                return null;
            }
        }
        return str;
    }
}
