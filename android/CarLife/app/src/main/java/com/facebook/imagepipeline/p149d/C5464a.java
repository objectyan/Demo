package com.facebook.imagepipeline.p149d;

import com.facebook.common.internal.C5273m;
import com.facebook.common.p258g.C5325c;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: BitmapCountingMemoryCacheFactory */
/* renamed from: com.facebook.imagepipeline.d.a */
public class C5464a {

    /* compiled from: BitmapCountingMemoryCacheFactory */
    /* renamed from: com.facebook.imagepipeline.d.a$1 */
    static class C54631 implements C5462v<C5534b> {
        C54631() {
        }

        /* renamed from: a */
        public int m18743a(C5534b value) {
            return value.mo4099b();
        }
    }

    /* renamed from: a */
    public static C2945h<C5247d, C5534b> m18745a(C5273m<C5487q> bitmapMemoryCacheParamsSupplier, C5325c memoryTrimmableRegistry) {
        C2945h<C5247d, C5534b> countingCache = new C2945h(new C54631(), new C5469d(), bitmapMemoryCacheParamsSupplier);
        memoryTrimmableRegistry.mo4015a(countingCache);
        return countingCache;
    }
}
