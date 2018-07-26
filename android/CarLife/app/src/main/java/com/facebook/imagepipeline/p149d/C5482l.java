package com.facebook.imagepipeline.p149d;

import com.facebook.common.internal.C5273m;
import com.facebook.common.p258g.C5325c;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: EncodedCountingMemoryCacheFactory */
/* renamed from: com.facebook.imagepipeline.d.l */
public class C5482l {

    /* compiled from: EncodedCountingMemoryCacheFactory */
    /* renamed from: com.facebook.imagepipeline.d.l$1 */
    static class C54811 implements C5462v<C5640y> {
        C54811() {
        }

        /* renamed from: a */
        public int m18799a(C5640y value) {
            return value.mo4155a();
        }
    }

    /* renamed from: a */
    public static C2945h<C5247d, C5640y> m18801a(C5273m<C5487q> encodedMemoryCacheParamsSupplier, C5325c memoryTrimmableRegistry) {
        C2945h<C5247d, C5640y> countingCache = new C2945h(new C54811(), new C5489s(), encodedMemoryCacheParamsSupplier);
        memoryTrimmableRegistry.mo4015a(countingCache);
        return countingCache;
    }
}
