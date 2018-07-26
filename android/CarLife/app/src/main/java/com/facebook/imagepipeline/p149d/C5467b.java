package com.facebook.imagepipeline.p149d;

import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: BitmapMemoryCacheFactory */
/* renamed from: com.facebook.imagepipeline.d.b */
public class C5467b {
    /* renamed from: a */
    public static C2944p<C5247d, C5534b> m18752a(C2945h<C5247d, C5534b> bitmapCountingMemoryCache, final C5485n imageCacheStatsTracker) {
        imageCacheStatsTracker.mo4066a(bitmapCountingMemoryCache);
        return new C5486o(bitmapCountingMemoryCache, new C5465r() {
            /* renamed from: a */
            public void mo4058a() {
                imageCacheStatsTracker.mo4067b();
            }

            /* renamed from: b */
            public void mo4059b() {
                imageCacheStatsTracker.mo4069c();
            }

            /* renamed from: c */
            public void mo4060c() {
                imageCacheStatsTracker.mo4065a();
            }
        });
    }
}
