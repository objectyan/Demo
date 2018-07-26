package com.facebook.imagepipeline.p149d;

import com.facebook.common.internal.C5273m;

/* compiled from: DefaultEncodedMemoryCacheParamsSupplier */
/* renamed from: com.facebook.imagepipeline.d.k */
public class C5480k implements C5273m<C5487q> {
    /* renamed from: a */
    private static final int f22306a = Integer.MAX_VALUE;
    /* renamed from: b */
    private static final int f22307b = Integer.MAX_VALUE;

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18797a();
    }

    /* renamed from: a */
    public C5487q m18797a() {
        int maxCacheSize = m18796c();
        return new C5487q(maxCacheSize, Integer.MAX_VALUE, maxCacheSize, Integer.MAX_VALUE, maxCacheSize / 8);
    }

    /* renamed from: c */
    private int m18796c() {
        int maxMemory = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (maxMemory < 16777216) {
            return 1048576;
        }
        if (maxMemory < 33554432) {
            return 2097152;
        }
        return 4194304;
    }
}
