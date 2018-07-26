package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: BitmapMemoryCacheGetProducer */
/* renamed from: com.facebook.imagepipeline.l.f */
public class C5576f extends C5575h {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22589a = "BitmapMemoryCacheGetProducer";

    public C5576f(C2944p<C5247d, C5534b> memoryCache, C5477f cacheKeyFactory, ai<C2921a<C5534b>> inputProducer) {
        super(memoryCache, cacheKeyFactory, inputProducer);
    }

    /* renamed from: a */
    protected C5517j<C2921a<C5534b>> mo4135a(C5517j<C2921a<C5534b>> consumer, C5247d cacheKey) {
        return consumer;
    }

    /* renamed from: a */
    protected String mo4136a() {
        return f22589a;
    }
}
