package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class ad extends RuntimeException {
    /* renamed from: a */
    public C5758a f22924a;
    /* renamed from: b */
    public C6013x f22925b;
    /* renamed from: c */
    private String f22926c;

    /* renamed from: com.indooratlas.android.sdk._internal.ad$a */
    public enum C5758a {
        CONVERSION,
        HTTP,
        NETWORK,
        UNEXPECTED
    }

    private ad(C5758a c5758a, String str, Throwable th, C6013x c6013x) {
        super(th);
        this.f22926c = str;
        this.f22924a = c5758a;
        this.f22925b = c6013x;
    }

    /* renamed from: a */
    public static ad m19793a(String str, IOException iOException) {
        return new ad(C5758a.NETWORK, str, iOException, null);
    }

    /* renamed from: a */
    public static ad m19791a(String str, C6013x c6013x) {
        return new ad(C5758a.HTTP, str, null, c6013x);
    }

    /* renamed from: a */
    public static ad m19792a(String str, C6013x c6013x, Throwable th) {
        return new ad(C5758a.CONVERSION, str, th, c6013x);
    }

    public final String toString() {
        StringBuilder append = new StringBuilder("RestError{mKind=").append(this.f22924a).append(", mUrl='").append(this.f22926c).append('\'').append(", mHttpResponse=").append(this.f22925b);
        if (getCause() != null) {
            append.append(", cause=").append(getCause());
        }
        append.append('}');
        return append.toString();
    }
}
