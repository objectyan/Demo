package com.indooratlas.android.sdk._internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.indooratlas.android.sdk._internal.l */
public final class C6000l {
    /* renamed from: a */
    private static volatile C5998b f24567a = new C5999a();

    /* renamed from: com.indooratlas.android.sdk._internal.l$b */
    public interface C5998b {
        /* renamed from: a */
        <K, V> Map<K, V> mo4830a(Map<K, V> map);
    }

    /* renamed from: com.indooratlas.android.sdk._internal.l$a */
    static class C5999a implements C5998b {
        private C5999a() {
        }

        /* renamed from: a */
        public final <K, V> Map<K, V> mo4830a(Map<K, V> map) {
            if (map == null) {
                return new HashMap();
            }
            return map;
        }
    }

    /* renamed from: a */
    public static C5998b m21503a() {
        return f24567a;
    }
}
