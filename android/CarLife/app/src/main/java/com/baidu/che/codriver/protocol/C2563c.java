package com.baidu.che.codriver.protocol;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.baidu.che.codriver.util.C2725h;
import com.google.gson.Gson;

/* compiled from: GsonRequest */
/* renamed from: com.baidu.che.codriver.protocol.c */
public class C2563c<T> extends Request<T> {
    /* renamed from: a */
    private final Listener<T> f8513a;
    /* renamed from: b */
    private final ErrorListener f8514b;
    /* renamed from: c */
    private Gson f8515c;
    /* renamed from: d */
    private Class<T> f8516d;

    public C2563c(int method, String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.f8515c = new Gson();
        this.f8516d = clazz;
        this.f8513a = listener;
        this.f8514b = errorListener;
    }

    public C2563c(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
        this(0, url, clazz, listener, errorListener);
    }

    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            C2725h.m10214e("parseNetworkResponse", jsonString);
            return Response.success(this.f8515c.fromJson(jsonString, this.f8516d), HttpHeaderParser.parseCacheHeaders(response));
        } catch (Throwable e) {
            return Response.error(new ParseError(e));
        } catch (Throwable je) {
            je.printStackTrace();
            C2725h.m10214e("GsonRequest", je.getMessage() != null ? je.getMessage() : "JsonSyntaxError");
            return Response.error(new ParseError(je));
        }
    }

    protected void deliverResponse(T response) {
        this.f8513a.onResponse(response);
    }

    public void deliverError(VolleyError error) {
        this.f8514b.onErrorResponse(error);
    }
}
