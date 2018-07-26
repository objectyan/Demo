package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p154m.C2957e;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.C5615f;
import com.facebook.p135b.p136a.C5247d;
import java.util.Map;

/* compiled from: PostprocessedBitmapMemoryCacheProducer */
/* renamed from: com.facebook.imagepipeline.l.ag */
public class ag implements ai<C2921a<C5534b>> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22503a = "PostprocessedBitmapMemoryCacheProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22504b = "cached_value_found";
    /* renamed from: c */
    private final C2944p<C5247d, C5534b> f22505c;
    /* renamed from: d */
    private final C5477f f22506d;
    /* renamed from: e */
    private final ai<C2921a<C5534b>> f22507e;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer */
    /* renamed from: com.facebook.imagepipeline.l.ag$a */
    public static class C5556a extends C5549m<C2921a<C5534b>, C2921a<C5534b>> {
        /* renamed from: a */
        private final C5247d f22500a;
        /* renamed from: b */
        private final boolean f22501b;
        /* renamed from: c */
        private final C2944p<C5247d, C5534b> f22502c;

        public C5556a(C5517j<C2921a<C5534b>> consumer, C5247d cacheKey, boolean isRepeatedProcessor, C2944p<C5247d, C5534b> memoryCache) {
            super(consumer);
            this.f22500a = cacheKey;
            this.f22501b = isRepeatedProcessor;
            this.f22502c = memoryCache;
        }

        /* renamed from: a */
        protected void m19199a(C2921a<C5534b> newResult, boolean isLast) {
            if (newResult == null) {
                if (isLast) {
                    m19142d().mo4087b(null, true);
                }
            } else if (isLast || this.f22501b) {
                C2921a<C5534b> newCachedResult = this.f22502c.a(this.f22500a, newResult);
                try {
                    m19142d().mo4086b(1.0f);
                    C5517j d = m19142d();
                    if (newCachedResult != null) {
                        newResult = newCachedResult;
                    }
                    d.mo4087b(newResult, isLast);
                } finally {
                    C2921a.c(newCachedResult);
                }
            }
        }
    }

    public ag(C2944p<C5247d, C5534b> memoryCache, C5477f cacheKeyFactory, ai<C2921a<C5534b>> inputProducer) {
        this.f22505c = memoryCache;
        this.f22506d = cacheKeyFactory;
        this.f22507e = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5534b>> consumer, aj producerContext) {
        Map map = null;
        al listener = producerContext.m19213c();
        String requestId = producerContext.m19212b();
        C2959c imageRequest = producerContext.m19210a();
        Object callerContext = producerContext.m19214d();
        C2957e postprocessor = imageRequest.n();
        if (postprocessor == null || postprocessor.b() == null) {
            this.f22507e.mo4122a(consumer, producerContext);
            return;
        }
        listener.mo4111a(requestId, m19201a());
        C5247d cacheKey = this.f22506d.mo4063b(imageRequest, callerContext);
        C2921a<C5534b> cachedReference = this.f22505c.a(cacheKey);
        if (cachedReference != null) {
            String a = m19201a();
            if (listener.mo4116b(requestId)) {
                map = C5346g.m18282a(f22504b, "true");
            }
            listener.mo4114a(requestId, a, map);
            consumer.mo4086b(1.0f);
            consumer.mo4087b(cachedReference, true);
            cachedReference.close();
            return;
        }
        C5517j<C2921a<C5534b>> cachedConsumer = new C5556a(consumer, cacheKey, postprocessor instanceof C5615f, this.f22505c);
        a = m19201a();
        if (listener.mo4116b(requestId)) {
            map = C5346g.m18282a(f22504b, "false");
        }
        listener.mo4114a(requestId, a, map);
        this.f22507e.mo4122a(cachedConsumer, producerContext);
    }

    /* renamed from: a */
    protected String m19201a() {
        return f22503a;
    }
}
