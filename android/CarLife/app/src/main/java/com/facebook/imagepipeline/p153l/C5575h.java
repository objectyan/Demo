package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5537g;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.p135b.p136a.C5247d;
import java.util.Map;

/* compiled from: BitmapMemoryCacheProducer */
/* renamed from: com.facebook.imagepipeline.l.h */
public class C5575h implements ai<C2921a<C5534b>> {
    @VisibleForTesting
    /* renamed from: b */
    static final String f22584b = "BitmapMemoryCacheProducer";
    @VisibleForTesting
    /* renamed from: c */
    static final String f22585c = "cached_value_found";
    /* renamed from: a */
    private final C2944p<C5247d, C5534b> f22586a;
    /* renamed from: d */
    private final C5477f f22587d;
    /* renamed from: e */
    private final ai<C2921a<C5534b>> f22588e;

    public C5575h(C2944p<C5247d, C5534b> memoryCache, C5477f cacheKeyFactory, ai<C2921a<C5534b>> inputProducer) {
        this.f22586a = memoryCache;
        this.f22587d = cacheKeyFactory;
        this.f22588e = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2921a<C5534b>> consumer, aj producerContext) {
        Map a;
        Map map = null;
        al listener = producerContext.m19213c();
        String requestId = producerContext.m19212b();
        listener.mo4111a(requestId, mo4136a());
        C5247d cacheKey = this.f22587d.mo4062a(producerContext.m19210a(), producerContext.m19214d());
        C2921a<C5534b> cachedReference = this.f22586a.a(cacheKey);
        if (cachedReference != null) {
            boolean isFinal = ((C5534b) cachedReference.a()).mo4097d().mo4106c();
            if (isFinal) {
                String a2 = mo4136a();
                if (listener.mo4116b(requestId)) {
                    a = C5346g.m18282a(f22585c, "true");
                } else {
                    a = null;
                }
                listener.mo4114a(requestId, a2, a);
                consumer.mo4086b(1.0f);
            }
            consumer.mo4087b(cachedReference, isFinal);
            cachedReference.close();
            if (isFinal) {
                return;
            }
        }
        if (producerContext.m19215e().m19441a() >= c$b.BITMAP_MEMORY_CACHE.m19441a()) {
            a2 = mo4136a();
            if (listener.mo4116b(requestId)) {
                a = C5346g.m18282a(f22585c, "false");
            } else {
                a = null;
            }
            listener.mo4114a(requestId, a2, a);
            consumer.mo4087b(null, true);
            return;
        }
        C5517j<C2921a<C5534b>> wrappedConsumer = mo4135a((C5517j) consumer, cacheKey);
        String a3 = mo4136a();
        if (listener.mo4116b(requestId)) {
            map = C5346g.m18282a(f22585c, "false");
        }
        listener.mo4114a(requestId, a3, map);
        this.f22588e.mo4122a(wrappedConsumer, producerContext);
    }

    /* renamed from: a */
    protected C5517j<C2921a<C5534b>> mo4135a(C5517j<C2921a<C5534b>> consumer, final C5247d cacheKey) {
        return new C5549m<C2921a<C5534b>, C2921a<C5534b>>(this, consumer) {
            /* renamed from: b */
            final /* synthetic */ C5575h f22592b;

            /* renamed from: a */
            public void m19312a(C2921a<C5534b> newResult, boolean isLast) {
                if (newResult == null) {
                    if (isLast) {
                        m19142d().mo4087b(null, true);
                    }
                } else if (((C5534b) newResult.a()).m19050e()) {
                    m19142d().mo4087b(newResult, isLast);
                } else {
                    if (!isLast) {
                        C2921a<C5534b> currentCachedResult = this.f22592b.f22586a.a(cacheKey);
                        if (currentCachedResult != null) {
                            try {
                                C5537g newInfo = ((C5534b) newResult.a()).mo4097d();
                                C5537g cachedInfo = ((C5534b) currentCachedResult.a()).mo4097d();
                                if (cachedInfo.mo4106c() || cachedInfo.mo4104a() >= newInfo.mo4104a()) {
                                    m19142d().mo4087b(currentCachedResult, false);
                                    return;
                                }
                                C2921a.c(currentCachedResult);
                            } finally {
                                C2921a.c(currentCachedResult);
                            }
                        }
                    }
                    C2921a<C5534b> newCachedResult = this.f22592b.f22586a.a(cacheKey, newResult);
                    if (isLast) {
                        try {
                            m19142d().mo4086b(1.0f);
                        } catch (Throwable th) {
                            C2921a.c(newCachedResult);
                        }
                    }
                    C5517j d = m19142d();
                    if (newCachedResult != null) {
                        newResult = newCachedResult;
                    }
                    d.mo4087b(newResult, isLast);
                    C2921a.c(newCachedResult);
                }
            }
        };
    }

    /* renamed from: a */
    protected String mo4136a() {
        return f22584b;
    }
}
