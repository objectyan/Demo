package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: DefaultByteArrayPoolParams */
/* renamed from: com.facebook.imagepipeline.memory.h */
public class C5632h {
    /* renamed from: a */
    private static final int f22762a = 16384;
    /* renamed from: b */
    private static final int f22763b = 5;
    /* renamed from: c */
    private static final int f22764c = 81920;
    /* renamed from: d */
    private static final int f22765d = 1048576;

    /* renamed from: a */
    public static C5653v m19513a() {
        SparseIntArray defaultBuckets = new SparseIntArray();
        defaultBuckets.put(16384, 5);
        return new C5653v(f22764c, 1048576, defaultBuckets);
    }
}
