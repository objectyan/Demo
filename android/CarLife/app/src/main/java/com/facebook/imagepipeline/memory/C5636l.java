package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p258g.C5325c;
import com.facebook.imagepipeline.memory.C5624a.C5619b;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: GenericByteArrayPool */
/* renamed from: com.facebook.imagepipeline.memory.l */
public class C5636l extends C5624a<byte[]> implements C5630f {
    /* renamed from: g */
    private final int[] f22772g;

    /* renamed from: b */
    protected /* synthetic */ Object mo4146b(int i) {
        return m19529i(i);
    }

    /* renamed from: b */
    protected /* synthetic */ void mo4147b(Object obj) {
        m19521a((byte[]) obj);
    }

    /* renamed from: c */
    protected /* synthetic */ int mo4149c(Object obj) {
        return m19522b((byte[]) obj);
    }

    public C5636l(C5325c memoryTrimmableRegistry, C5653v poolParams, C5646w poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray bucketSizes = poolParams.f22819d;
        this.f22772g = new int[bucketSizes.size()];
        for (int i = 0; i < bucketSizes.size(); i++) {
            this.f22772g[i] = bucketSizes.keyAt(i);
        }
        m19462a();
    }

    /* renamed from: g */
    public int mo4152g() {
        return this.f22772g[0];
    }

    /* renamed from: i */
    protected byte[] m19529i(int bucketedSize) {
        return new byte[bucketedSize];
    }

    /* renamed from: a */
    protected void m19521a(byte[] value) {
        C5350k.m18310a((Object) value);
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
        for (int bucketedSize : this.f22772g) {
            if (bucketedSize >= intRequestSize) {
                return bucketedSize;
            }
        }
        return requestSize;
    }

    /* renamed from: b */
    protected int m19522b(byte[] value) {
        C5350k.m18310a((Object) value);
        return value.length;
    }
}
