package com.baidu.cloudsdk.common.http;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams {
    protected static final String ENCODING = "UTF-8";
    protected HashMap<String, String> mParams;
    protected HashMap<String, ArrayList<String>> mParamsWithArray;

    public RequestParams() {
        this.mParams = new HashMap();
        this.mParamsWithArray = new HashMap();
    }

    public RequestParams(String key, String value) {
        this();
        put(key, value);
    }

    public RequestParams(Map<String, String> params) {
        this();
        if (params != null) {
            for (Entry<String, String> entry : params.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public RequestParams(Object... keysAndValues) {
        this();
        int len = keysAndValues.length;
        if (len % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        int i = 0;
        while (i < len) {
            if (!(keysAndValues[i] == null || keysAndValues[i + 1] == null)) {
                put(String.valueOf(keysAndValues[i]), String.valueOf(keysAndValues[i + 1]));
            }
            i += 2;
        }
    }

    public void put(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            this.mParams.put(key, value);
        }
    }

    public void put(String key, ArrayList<String> values) {
        if (!TextUtils.isEmpty(key) && values != null && values.size() > 0) {
            this.mParamsWithArray.put(key, values);
        }
    }

    public void remove(String key) {
        if (key != null) {
            this.mParams.remove(key);
            this.mParamsWithArray.remove(key);
        }
    }

    public HttpEntity getHttpEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public final String getQueryString() {
        return URLEncodedUtils.format(getParamsList(), "UTF-8");
    }

    public final String toString() {
        return getStringBuilder().toString();
    }

    protected StringBuilder getStringBuilder() {
        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> entry : this.mParams.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append((String) entry.getKey()).append("=").append((String) entry.getValue());
        }
        for (Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            boolean isFirst = true;
            String key = (String) entry2.getKey();
            Iterator i$ = ((ArrayList) entry2.getValue()).iterator();
            while (i$.hasNext()) {
                String value = (String) i$.next();
                if (!TextUtils.isEmpty(value)) {
                    if (!isFirst) {
                        builder.append("&");
                    }
                    isFirst = false;
                    builder.append(key).append("=").append(value);
                }
            }
        }
        return builder;
    }

    private List<BasicNameValuePair> getParamsList() {
        List<BasicNameValuePair> params = new LinkedList();
        for (Entry<String, String> entry : this.mParams.entrySet()) {
            params.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        for (Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            String key = (String) entry2.getKey();
            Iterator i$ = ((ArrayList) entry2.getValue()).iterator();
            while (i$.hasNext()) {
                String value = (String) i$.next();
                if (!TextUtils.isEmpty(value)) {
                    params.add(new BasicNameValuePair(key, value));
                }
            }
        }
        return params;
    }
}
