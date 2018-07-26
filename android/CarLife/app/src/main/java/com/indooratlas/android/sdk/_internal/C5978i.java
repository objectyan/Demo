package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.C6000l.C5998b;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.indooratlas.android.sdk._internal.i */
public final class C5978i {
    /* renamed from: a */
    protected static final Charset f24327a = Charset.forName("UTF-8");
    /* renamed from: b */
    protected static final Charset f24328b = Charset.forName("ISO-8859-1");
    /* renamed from: c */
    public static final Object f24329c = new Object();

    /* renamed from: a */
    public static final <K, V> Map<K, V> m21087a(C5757a c5757a, Map<K, V> map, C5998b c5998b, V v) throws IOException {
        Map<K, V> a = c5998b.mo4830a(map);
        int c = c5757a.c(c5757a.f());
        Object obj = null;
        while (true) {
            int a2 = c5757a.a();
            if (a2 == 0) {
                break;
            } else if (a2 == 10) {
                obj = c5757a.l();
            } else if (a2 == 18) {
                c5757a.a((C6001m) v);
            } else if (!c5757a.b(a2)) {
                break;
            }
        }
        c5757a.a(0);
        c5757a.d(c);
        if (obj == null) {
            obj = "";
        }
        a.put(obj, v);
        return a;
    }

    /* renamed from: a */
    public static <K, V> void m21088a(C5787b c5787b, Map<K, V> map) throws IOException {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int a = C5787b.a(1, 9, key) + C5787b.a(2, 11, value);
            c5787b.g(1, 2);
            c5787b.e(a);
            c5787b.b(1, 9, key);
            c5787b.b(2, 11, value);
        }
    }

    /* renamed from: a */
    public static <K, V> int m21086a(Map<K, V> map) {
        int d = C5787b.d(1);
        int i = 0;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int a = C5787b.a(2, 11, value) + C5787b.a(1, 9, key);
            i = (C5787b.f(a) + (d + a)) + i;
        }
        return i;
    }

    /* renamed from: a */
    public static void m21089a(C5832c c5832c, C5832c c5832c2) {
        if (c5832c.f23282a != null) {
            c5832c2.f23282a = c5832c.f23282a.c();
        }
    }
}
