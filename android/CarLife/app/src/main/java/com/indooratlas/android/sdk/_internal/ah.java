package com.indooratlas.android.sdk._internal;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

public final class ah {
    /* renamed from: a */
    String f22941a;
    /* renamed from: b */
    C5759a f22942b;
    /* renamed from: c */
    public ArrayList<C5760b> f22943c;
    /* renamed from: d */
    private StringBuilder f22944d = new StringBuilder();
    /* renamed from: e */
    private String f22945e;

    /* renamed from: com.indooratlas.android.sdk._internal.ah$a */
    public enum C5759a {
        V1("/atlas"),
        V2("/v2"),
        SDK_V1("/sdk/v1"),
        CONTEXTS_V1("/contexts/v1"),
        MAPPING_V1("/mapping/v1");
        
        /* renamed from: f */
        final String f22938f;

        private C5759a(String str) {
            this.f22938f = str;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ah$b */
    public static class C5760b {
        /* renamed from: a */
        String f22939a;
        /* renamed from: b */
        String f22940b = ah.m19802b();

        public C5760b(String str) {
            this.f22939a = str;
        }
    }

    ah() {
    }

    /* renamed from: a */
    public final ah m19803a(String str, Object... objArr) {
        String a = eg.m20414a(str, "path cannot be null", new Object[0]);
        if (!a.startsWith("/")) {
            a = this.f22944d.append("/").append(a).toString();
        }
        this.f22945e = String.format(Locale.US, a, objArr);
        return this;
    }

    /* renamed from: a */
    public final String m19804a() {
        int i = 0;
        eg.m20413a(this.f22942b, "url version was never set", new Object[0]);
        eg.m20414a(this.f22941a, "endpoint must be non empty", new Object[0]);
        this.f22944d.setLength(0);
        StringBuilder stringBuilder = this.f22944d;
        String str = this.f22941a;
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        stringBuilder.append(str);
        this.f22944d.append(this.f22942b.f22938f);
        this.f22944d.append(this.f22945e);
        stringBuilder = this.f22944d;
        if (!(this.f22943c == null || this.f22943c.isEmpty())) {
            if (stringBuilder.indexOf("?") == -1) {
                stringBuilder.append('?');
            }
            int size = this.f22943c.size();
            while (i < size) {
                C5760b c5760b = (C5760b) this.f22943c.get(i);
                stringBuilder.append(c5760b.f22939a).append('=').append(c5760b.f22940b);
                if (i < size - 1) {
                    stringBuilder.append('&');
                }
                i++;
            }
        }
        return this.f22944d.toString();
    }

    /* renamed from: b */
    static String m19802b() {
        try {
            return URLEncoder.encode(null, "UTF-8");
        } catch (Throwable e) {
            throw new IllegalStateException("cannot encode query param, UTF-8 missing", e);
        }
    }
}
