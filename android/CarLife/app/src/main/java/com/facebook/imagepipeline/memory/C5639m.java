package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p258g.C5325c;
import com.facebook.imagepipeline.memory.C5624a.C5619b;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: NativeMemoryChunkPool */
/* renamed from: com.facebook.imagepipeline.memory.m */
public class C5639m extends C5624a<NativeMemoryChunk> {
    /* renamed from: g */
    private final int[] f22775g;

    /* renamed from: b */
    protected /* synthetic */ Object mo4146b(int i) {
        return m19545i(i);
    }

    /* renamed from: b */
    protected /* synthetic */ void mo4147b(Object obj) {
        m19535a((NativeMemoryChunk) obj);
    }

    /* renamed from: c */
    protected /* synthetic */ int mo4149c(Object obj) {
        return m19536b((NativeMemoryChunk) obj);
    }

    /* renamed from: d */
    protected /* synthetic */ boolean mo4151d(Object obj) {
        return m19541c((NativeMemoryChunk) obj);
    }

    public C5639m(C5325c memoryTrimmableRegistry, C5653v poolParams, C5646w nativeMemoryChunkPoolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, nativeMemoryChunkPoolStatsTracker);
        SparseIntArray bucketSizes = poolParams.f22819d;
        this.f22775g = new int[bucketSizes.size()];
        for (int i = 0; i < this.f22775g.length; i++) {
            this.f22775g[i] = bucketSizes.keyAt(i);
        }
        m19462a();
    }

    /* renamed from: g */
    public int mo4152g() {
        return this.f22775g[0];
    }

    /* renamed from: i */
    protected NativeMemoryChunk m19545i(int bucketedSize) {
        return new NativeMemoryChunk(bucketedSize);
    }

    /* renamed from: a */
    protected void m19535a(NativeMemoryChunk value) {
        C5350k.m18310a((Object) value);
        value.close();
    }

    /* renamed from: d */
    protected int mo4150d(int bucketedSize) {
        return bucketedSize;
    }

    /* renamed from: c */
    protected int mo4148c(int requestSize) {
        int intRequestSize = requestSize;
        if (intRequestSize <= 0) {
            throw new C5619b(Integer.valueOf(requestSize));
        }
        for (int bucketedSize : this.f22775g) {
            if (bucketedSize >= intRequestSize) {
                return bucketedSize;
            }
        }
        return requestSize;
    }

    /* renamed from: b */
    protected int m19536b(NativeMemoryChunk value) {
        C5350k.m18310a((Object) value);
        return value.m19450b();
    }

    /* renamed from: c */
    protected boolean m19541c(NativeMemoryChunk value) {
        C5350k.m18310a((Object) value);
        return !value.m19449a();
    }
}
