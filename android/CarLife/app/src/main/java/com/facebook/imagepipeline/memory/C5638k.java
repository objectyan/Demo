package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p140h.C5329c;
import com.facebook.common.p258g.C5325c;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: FlexByteArrayPool */
/* renamed from: com.facebook.imagepipeline.memory.k */
public class C5638k {
    @VisibleForTesting
    /* renamed from: a */
    final C5637a f22773a;
    /* renamed from: b */
    private final C5329c<byte[]> f22774b;

    /* compiled from: FlexByteArrayPool */
    /* renamed from: com.facebook.imagepipeline.memory.k$1 */
    class C56351 implements C5329c<byte[]> {
        /* renamed from: a */
        final /* synthetic */ C5638k f22771a;

        C56351(C5638k this$0) {
            this.f22771a = this$0;
        }

        /* renamed from: a */
        public void m19520a(byte[] unused) {
            this.f22771a.m19533a(unused);
        }
    }

    @VisibleForTesting
    /* compiled from: FlexByteArrayPool */
    /* renamed from: com.facebook.imagepipeline.memory.k$a */
    static class C5637a extends C5636l {
        public C5637a(C5325c memoryTrimmableRegistry, C5653v poolParams, C5646w poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        /* renamed from: g */
        C2961e<byte[]> mo4153g(int bucketedSize) {
            return new C5648r(mo4150d(bucketedSize), this.b.f22822g, 0);
        }
    }

    public C5638k(C5325c memoryTrimmableRegistry, C5653v params) {
        C5350k.m18315a(params.f22822g > 0);
        this.f22773a = new C5637a(memoryTrimmableRegistry, params, C5647q.m19588a());
        this.f22774b = new C56351(this);
    }

    /* renamed from: a */
    public C2921a<byte[]> m19531a(int size) {
        return C2921a.a(this.f22773a.mo4144a(size), this.f22774b);
    }

    /* renamed from: a */
    public void m19533a(byte[] value) {
        this.f22773a.mo4017a((Object) value);
    }

    /* renamed from: a */
    public Map<String, Integer> m19532a() {
        return this.f22773a.m19477f();
    }

    /* renamed from: b */
    public int m19534b() {
        return this.f22773a.mo4152g();
    }
}
