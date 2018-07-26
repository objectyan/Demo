package com.loopj.android.http;

import cz.msebera.android.httpclient.p158b.p159d.C6037f;
import java.net.URI;

public final class HttpGet extends C6037f {
    public static final String METHOD_NAME = "GET";

    public HttpGet(URI uri) {
        setURI(uri);
    }

    public HttpGet(String uri) {
        setURI(URI.create(uri));
    }

    public String getMethod() {
        return "GET";
    }
}
