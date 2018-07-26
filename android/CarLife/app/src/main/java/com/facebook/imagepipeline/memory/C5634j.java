package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

/* compiled from: DefaultNativeMemoryChunkPoolParams */
/* renamed from: com.facebook.imagepipeline.memory.j */
public class C5634j {
    /* renamed from: a */
    private static final int f22769a = 5;
    /* renamed from: b */
    private static final int f22770b = 2;

    /* renamed from: a */
    public static C5653v m19516a() {
        SparseIntArray DEFAULT_BUCKETS = new SparseIntArray();
        DEFAULT_BUCKETS.put(1024, 5);
        DEFAULT_BUCKETS.put(2048, 5);
        DEFAULT_BUCKETS.put(4096, 5);
        DEFAULT_BUCKETS.put(8192, 5);
        DEFAULT_BUCKETS.put(16384, 5);
        DEFAULT_BUCKETS.put(32768, 5);
        DEFAULT_BUCKETS.put(65536, 5);
        DEFAULT_BUCKETS.put(131072, 5);
        DEFAULT_BUCKETS.put(262144, 2);
        DEFAULT_BUCKETS.put(524288, 2);
        DEFAULT_BUCKETS.put(1048576, 2);
        return new C5653v(C5634j.m19517b(), C5634j.m19518c(), DEFAULT_BUCKETS);
    }

    /* renamed from: b */
    private static int m19517b() {
        int maxMemory = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (maxMemory < 16777216) {
            return MapGLSurfaceView.FLAG_OVERLAY_BMBAR_DYNAMCI_MAP;
        }
        if (maxMemory < 33554432) {
            return 6291456;
        }
        return 12582912;
    }

    /* renamed from: c */
    private static int m19518c() {
        int maxMemory = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (maxMemory < 16777216) {
            return maxMemory / 2;
        }
        return (maxMemory / 4) * 3;
    }
}
