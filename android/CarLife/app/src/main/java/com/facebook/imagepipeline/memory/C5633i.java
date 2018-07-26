package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: DefaultFlexByteArrayPoolParams */
/* renamed from: com.facebook.imagepipeline.memory.i */
public class C5633i {
    /* renamed from: a */
    public static final int f22766a = 4194304;
    /* renamed from: b */
    public static final int f22767b = Runtime.getRuntime().availableProcessors();
    /* renamed from: c */
    private static final int f22768c = 131072;

    private C5633i() {
    }

    /* renamed from: a */
    public static SparseIntArray m19514a(int min, int max, int numThreads) {
        SparseIntArray buckets = new SparseIntArray();
        for (int i = min; i <= max; i *= 2) {
            buckets.put(i, numThreads);
        }
        return buckets;
    }

    /* renamed from: a */
    public static C5653v m19515a() {
        return new C5653v(4194304, f22767b * 4194304, C5633i.m19514a(131072, 4194304, f22767b), 131072, 4194304, f22767b);
    }
}
