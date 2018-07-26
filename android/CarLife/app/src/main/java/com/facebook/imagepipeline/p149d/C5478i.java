package com.facebook.imagepipeline.p149d;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.C5273m;

/* compiled from: DefaultBitmapMemoryCacheParamsSupplier */
/* renamed from: com.facebook.imagepipeline.d.i */
public class C5478i implements C5273m<C5487q> {
    /* renamed from: a */
    private static final int f22300a = 256;
    /* renamed from: b */
    private static final int f22301b = Integer.MAX_VALUE;
    /* renamed from: c */
    private static final int f22302c = Integer.MAX_VALUE;
    /* renamed from: d */
    private static final int f22303d = Integer.MAX_VALUE;
    /* renamed from: e */
    private final ActivityManager f22304e;

    /* renamed from: b */
    public /* synthetic */ Object mo3969b() {
        return m18789a();
    }

    public C5478i(ActivityManager activityManager) {
        this.f22304e = activityManager;
    }

    /* renamed from: a */
    public C5487q m18789a() {
        return new C5487q(m18788c(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: c */
    private int m18788c() {
        int maxMemory = Math.min(this.f22304e.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (maxMemory < 33554432) {
            return 4194304;
        }
        if (maxMemory < 67108864) {
            return 6291456;
        }
        if (VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return maxMemory / 4;
    }
}
