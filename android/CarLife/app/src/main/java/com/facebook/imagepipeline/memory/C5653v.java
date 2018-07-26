package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.C5350k;
import javax.annotation.Nullable;

/* compiled from: PoolParams */
/* renamed from: com.facebook.imagepipeline.memory.v */
public class C5653v {
    /* renamed from: a */
    public static final int f22816a = -1;
    /* renamed from: b */
    public final int f22817b;
    /* renamed from: c */
    public final int f22818c;
    /* renamed from: d */
    public final SparseIntArray f22819d;
    /* renamed from: e */
    public final int f22820e;
    /* renamed from: f */
    public final int f22821f;
    /* renamed from: g */
    public final int f22822g;

    public C5653v(int maxSize, @Nullable SparseIntArray bucketSizes) {
        this(maxSize, maxSize, bucketSizes, 0, Integer.MAX_VALUE, -1);
    }

    public C5653v(int maxSizeSoftCap, int maxSizeHardCap, @Nullable SparseIntArray bucketSizes) {
        this(maxSizeSoftCap, maxSizeHardCap, bucketSizes, 0, Integer.MAX_VALUE, -1);
    }

    public C5653v(int maxSizeSoftCap, int maxSizeHardCap, @Nullable SparseIntArray bucketSizes, int minBucketSize, int maxBucketSize, int maxNumThreads) {
        boolean z = maxSizeSoftCap >= 0 && maxSizeHardCap >= maxSizeSoftCap;
        C5350k.m18321b(z);
        this.f22818c = maxSizeSoftCap;
        this.f22817b = maxSizeHardCap;
        this.f22819d = bucketSizes;
        this.f22820e = minBucketSize;
        this.f22821f = maxBucketSize;
        this.f22822g = maxNumThreads;
    }
}
