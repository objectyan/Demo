package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: DefaultBitmapPoolParams */
/* renamed from: com.facebook.imagepipeline.memory.g */
public class C5631g {
    /* renamed from: a */
    private static final int f22760a = 0;
    /* renamed from: b */
    private static final SparseIntArray f22761b = new SparseIntArray(0);

    private C5631g() {
    }

    /* renamed from: b */
    private static int m19512b() {
        int maxMemory = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (maxMemory > 16777216) {
            return (maxMemory / 4) * 3;
        }
        return maxMemory / 2;
    }

    /* renamed from: a */
    public static C5653v m19511a() {
        return new C5653v(0, C5631g.m19512b(), f22761b);
    }
}
