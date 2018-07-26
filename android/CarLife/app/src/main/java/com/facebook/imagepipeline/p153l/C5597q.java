package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.p135b.p136a.C5247d;
import java.util.Map;

/* compiled from: EncodedMemoryCacheProducer */
/* renamed from: com.facebook.imagepipeline.l.q */
public class C5597q implements ai<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22656a = "EncodedMemoryCacheProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22657b = "cached_value_found";
    /* renamed from: c */
    private final C2944p<C5247d, C5640y> f22658c;
    /* renamed from: d */
    private final C5477f f22659d;
    /* renamed from: e */
    private final ai<C2952d> f22660e;

    public C5597q(C2944p<C5247d, C5640y> memoryCache, C5477f cacheKeyFactory, ai<C2952d> inputProducer) {
        this.f22658c = memoryCache;
        this.f22659d = cacheKeyFactory;
        this.f22660e = inputProducer;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj producerContext) {
        Map map = null;
        String requestId = producerContext.m19212b();
        al listener = producerContext.m19213c();
        listener.mo4111a(requestId, f22656a);
        final C5247d cacheKey = this.f22659d.mo4064c(producerContext.m19210a(), producerContext.m19214d());
        C2921a<C5640y> cachedReference = this.f22658c.a(cacheKey);
        String str;
        if (cachedReference != null) {
            C2952d cachedEncodedImage;
            try {
                cachedEncodedImage = new C2952d(cachedReference);
                str = f22656a;
                if (listener.mo4116b(requestId)) {
                    map = C5346g.m18282a(f22657b, "true");
                }
                listener.mo4114a(requestId, str, map);
                consumer.mo4086b(1.0f);
                consumer.mo4087b(cachedEncodedImage, true);
                C2952d.d(cachedEncodedImage);
                C2921a.c(cachedReference);
            } catch (Throwable th) {
                C2921a.c(cachedReference);
            }
        } else if (producerContext.m19215e().m19441a() >= c$b.ENCODED_MEMORY_CACHE.m19441a()) {
            str = f22656a;
            if (listener.mo4116b(requestId)) {
                map = C5346g.m18282a(f22657b, "false");
            }
            listener.mo4114a(requestId, str, map);
            consumer.mo4087b(null, true);
            C2921a.c(cachedReference);
        } else {
            C5517j<C2952d> consumerOfInputProducer = new C5549m<C2952d, C2952d>(this, consumer) {
                /* renamed from: b */
                final /* synthetic */ C5597q f22655b;

                /* renamed from: a */
                public void m19383a(C2952d newResult, boolean isLast) {
                    if (!isLast || newResult == null) {
                        m19142d().mo4087b(newResult, isLast);
                        return;
                    }
                    C2921a<C5640y> ref = newResult.c();
                    if (ref != null) {
                        try {
                            C2921a<C5640y> cachedResult = this.f22655b.f22658c.a(cacheKey, ref);
                            if (cachedResult != null) {
                                try {
                                    C2952d cachedEncodedImage = new C2952d(cachedResult);
                                    cachedEncodedImage.b(newResult);
                                    try {
                                        m19142d().mo4086b(1.0f);
                                        m19142d().mo4087b(cachedEncodedImage, true);
                                        return;
                                    } finally {
                                        C2952d.d(cachedEncodedImage);
                                    }
                                } finally {
                                    C2921a.c(cachedResult);
                                }
                            }
                        } finally {
                            C2921a.c(ref);
                        }
                    }
                    m19142d().mo4087b(newResult, true);
                }
            };
            str = f22656a;
            if (listener.mo4116b(requestId)) {
                map = C5346g.m18282a(f22657b, "false");
            }
            listener.mo4114a(requestId, str, map);
            this.f22660e.mo4122a(consumerOfInputProducer, producerContext);
            C2921a.c(cachedReference);
        }
    }
}
