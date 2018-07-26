package com.facebook.imagepipeline.p149d;

import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: EncodedMemoryCacheFactory */
/* renamed from: com.facebook.imagepipeline.d.m */
public class C5484m {
    /* renamed from: a */
    public static C2944p<C5247d, C5640y> m18805a(C2945h<C5247d, C5640y> encodedCountingMemoryCache, final C5485n imageCacheStatsTracker) {
        imageCacheStatsTracker.mo4068b(encodedCountingMemoryCache);
        return new C5486o(encodedCountingMemoryCache, new C5465r() {
            /* renamed from: a */
            public void mo4058a() {
                imageCacheStatsTracker.mo4071e();
            }

            /* renamed from: b */
            public void mo4059b() {
                imageCacheStatsTracker.mo4072f();
            }

            /* renamed from: c */
            public void mo4060c() {
                imageCacheStatsTracker.mo4070d();
            }
        });
    }
}
