package com.baidu.carlife.p054k.p055a;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.baidu.carlife.core.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

/* compiled from: MultipartRequest */
/* renamed from: com.baidu.carlife.k.a.c */
public class C1619c extends Request<String> {
    /* renamed from: a */
    private String f4953a = "NetWorkRequest";
    /* renamed from: b */
    private Listener<String> f4954b = null;
    /* renamed from: c */
    private C1622d f4955c = null;
    /* renamed from: d */
    private long f4956d;
    /* renamed from: e */
    private HttpEntity f4957e = null;

    protected /* synthetic */ void deliverResponse(Object obj) {
        m5905a((String) obj);
    }

    public C1619c(int method, String url, C1622d params, Listener<String> listener, ErrorListener errorListener, boolean shouldCache, String logTag) {
        super(method, url, errorListener);
        this.f4954b = listener;
        this.f4955c = params;
        if (params != null) {
            params.setTag(logTag);
        }
        this.f4953a = logTag;
        this.f4956d = System.currentTimeMillis();
        setShouldCache(shouldCache);
    }

    /* renamed from: a */
    public long m5904a() {
        return this.f4956d;
    }

    public byte[] getBody() throws AuthFailureError {
        if (!m5903b()) {
            return super.getBody();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        this.f4957e = this.f4955c.getEntity();
        try {
            this.f4957e.writeTo(baos);
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e4) {
                }
            }
        }
        return baos.toByteArray();
    }

    /* renamed from: b */
    private boolean m5903b() {
        if (this.f4955c == null) {
            return false;
        }
        if (this.f4955c.fileParams != null && !this.f4955c.fileParams.isEmpty()) {
            return true;
        }
        if (this.f4955c.isSignNeed()) {
            return true;
        }
        return false;
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        if (this.f4955c == null || this.f4955c.urlParams == null || this.f4955c.urlParams.isEmpty()) {
            return super.getParams();
        }
        Map<String, String> map = new HashMap();
        for (NameValuePair param : this.f4955c.urlParams) {
            map.put(param.getName(), param.getValue());
        }
        LogUtil.d(this.f4953a, "the post params is:" + map.toString());
        return map;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    public String getBodyContentType() {
        if (m5903b()) {
            return this.f4957e.getContentType().getValue();
        }
        return super.getBodyContentType();
    }

    /* renamed from: a */
    protected void m5905a(String response) {
        if (this.f4954b != null) {
            this.f4954b.onResponse(response);
        }
    }

    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
