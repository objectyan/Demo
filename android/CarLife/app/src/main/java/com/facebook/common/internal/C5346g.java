package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImmutableMap */
/* renamed from: com.facebook.common.internal.g */
public class C5346g<K, V> extends HashMap<K, V> {
    private C5346g(Map<? extends K, ? extends V> map) {
        super(map);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18281a() {
        return Collections.unmodifiableMap(new HashMap());
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18282a(K k1, V v1) {
        Map<K, V> map = new HashMap();
        map.put(k1, v1);
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18283a(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18284a(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18285a(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m18286a(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public static <K, V> C5346g<K, V> m18280a(Map<? extends K, ? extends V> map) {
        return new C5346g(map);
    }
}
