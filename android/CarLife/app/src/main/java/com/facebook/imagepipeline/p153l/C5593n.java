package com.facebook.imagepipeline.p153l;

import com.facebook.common.internal.C5346g;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.p149d.C5476e;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.c$a;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.p135b.p136a.C5247d;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.C0012h;
import p000a.C0027j;

/* compiled from: DiskCacheProducer */
/* renamed from: com.facebook.imagepipeline.l.n */
public class C5593n implements ai<C2952d> {
    @VisibleForTesting
    /* renamed from: a */
    static final String f22642a = "DiskCacheProducer";
    @VisibleForTesting
    /* renamed from: b */
    static final String f22643b = "cached_value_found";
    /* renamed from: c */
    private final C5476e f22644c;
    /* renamed from: d */
    private final C5476e f22645d;
    /* renamed from: e */
    private final C5477f f22646e;
    /* renamed from: f */
    private final ai<C2952d> f22647f;
    /* renamed from: g */
    private final boolean f22648g;
    /* renamed from: h */
    private final int f22649h;

    /* compiled from: DiskCacheProducer */
    /* renamed from: com.facebook.imagepipeline.l.n$a */
    private class C5592a extends C5549m<C2952d, C2952d> {
        /* renamed from: a */
        final /* synthetic */ C5593n f22639a;
        /* renamed from: b */
        private final C5476e f22640b;
        /* renamed from: c */
        private final C5247d f22641c;

        private C5592a(C5593n c5593n, C5517j<C2952d> consumer, C5476e cache, C5247d cacheKey) {
            this.f22639a = c5593n;
            super(consumer);
            this.f22640b = cache;
            this.f22641c = cacheKey;
        }

        /* renamed from: a */
        public void m19359a(C2952d newResult, boolean isLast) {
            if (newResult != null && isLast) {
                if (this.f22639a.f22648g) {
                    int size = newResult.j();
                    if (size <= 0 || size >= this.f22639a.f22649h) {
                        this.f22639a.f22644c.m18776a(this.f22641c, newResult);
                    } else {
                        this.f22639a.f22645d.m18776a(this.f22641c, newResult);
                    }
                } else {
                    this.f22640b.m18776a(this.f22641c, newResult);
                }
            }
            m19142d().mo4087b(newResult, isLast);
        }
    }

    public C5593n(C5476e defaultBufferedDiskCache, C5476e smallImageBufferedDiskCache, C5477f cacheKeyFactory, ai<C2952d> inputProducer, int forceSmallCacheThresholdBytes) {
        this.f22644c = defaultBufferedDiskCache;
        this.f22645d = smallImageBufferedDiskCache;
        this.f22646e = cacheKeyFactory;
        this.f22647f = inputProducer;
        this.f22649h = forceSmallCacheThresholdBytes;
        this.f22648g = forceSmallCacheThresholdBytes > 0;
    }

    /* renamed from: a */
    public void mo4122a(C5517j<C2952d> consumer, aj producerContext) {
        C2959c imageRequest = producerContext.m19210a();
        if (imageRequest.l()) {
            C5476e preferredCache;
            C0027j<C2952d> diskLookupTask;
            producerContext.m19213c().mo4111a(producerContext.m19212b(), f22642a);
            final C5247d cacheKey = this.f22646e.mo4064c(imageRequest, producerContext.m19214d());
            if (imageRequest.a() == c$a.f22712a) {
                preferredCache = this.f22645d;
            } else {
                preferredCache = this.f22644c;
            }
            final AtomicBoolean isCancelled = new AtomicBoolean(false);
            if (this.f22648g) {
                C5476e firstCache;
                C5476e secondCache;
                boolean alreadyInSmall = this.f22645d.m18777a(cacheKey);
                boolean alreadyInMain = this.f22644c.m18777a(cacheKey);
                if (alreadyInSmall || !alreadyInMain) {
                    firstCache = this.f22645d;
                    secondCache = this.f22644c;
                } else {
                    firstCache = this.f22644c;
                    secondCache = this.f22645d;
                }
                diskLookupTask = firstCache.m18775a(cacheKey, isCancelled).b(new C0012h<C2952d, C0027j<C2952d>>(this) {
                    /* renamed from: d */
                    final /* synthetic */ C5593n f22629d;

                    /* renamed from: a */
                    public /* synthetic */ Object m19354a(C0027j c0027j) throws Exception {
                        return m19355b(c0027j);
                    }

                    /* renamed from: b */
                    public C0027j<C2952d> m19355b(C0027j<C2952d> task) throws Exception {
                        if (C5593n.m19369b((C0027j) task)) {
                            return task;
                        }
                        return (task.e() || task.f() == null) ? secondCache.m18775a(cacheKey, isCancelled) : task;
                    }
                });
            } else {
                diskLookupTask = preferredCache.m18775a(cacheKey, isCancelled);
            }
            diskLookupTask.a(m19361a((C5517j) consumer, preferredCache, cacheKey, producerContext));
            m19365a(isCancelled, producerContext);
            return;
        }
        m19363a((C5517j) consumer, (C5517j) consumer, producerContext);
    }

    /* renamed from: a */
    private C0012h<C2952d, Void> m19361a(C5517j<C2952d> consumer, C5476e preferredCache, C5247d preferredCacheKey, aj producerContext) {
        final String requestId = producerContext.m19212b();
        final al listener = producerContext.m19213c();
        final C5517j<C2952d> c5517j = consumer;
        final C5476e c5476e = preferredCache;
        final C5247d c5247d = preferredCacheKey;
        final aj ajVar = producerContext;
        return new C0012h<C2952d, Void>(this) {
            /* renamed from: g */
            final /* synthetic */ C5593n f22636g;

            /* renamed from: a */
            public /* synthetic */ Object m19356a(C0027j c0027j) throws Exception {
                return m19357b(c0027j);
            }

            /* renamed from: b */
            public Void m19357b(C0027j<C2952d> task) throws Exception {
                if (C5593n.m19369b((C0027j) task)) {
                    listener.mo4115b(requestId, C5593n.f22642a, null);
                    c5517j.mo4085b();
                } else if (task.e()) {
                    listener.mo4113a(requestId, C5593n.f22642a, task.g(), null);
                    this.f22636g.m19363a(c5517j, new C5592a(c5517j, c5476e, c5247d), ajVar);
                } else {
                    C2952d cachedReference = (C2952d) task.f();
                    if (cachedReference != null) {
                        listener.mo4114a(requestId, C5593n.f22642a, C5593n.m19362a(listener, requestId, true));
                        c5517j.mo4086b(1.0f);
                        c5517j.mo4087b(cachedReference, true);
                        cachedReference.close();
                    } else {
                        listener.mo4114a(requestId, C5593n.f22642a, C5593n.m19362a(listener, requestId, false));
                        this.f22636g.m19363a(c5517j, new C5592a(c5517j, c5476e, c5247d), ajVar);
                    }
                }
                return null;
            }
        };
    }

    /* renamed from: b */
    private static boolean m19369b(C0027j<?> task) {
        return task.d() || (task.e() && (task.g() instanceof CancellationException));
    }

    /* renamed from: a */
    private void m19363a(C5517j<C2952d> consumerOfDiskCacheProducer, C5517j<C2952d> consumerOfInputProducer, aj producerContext) {
        if (producerContext.m19215e().m19441a() >= c$b.DISK_CACHE.m19441a()) {
            consumerOfDiskCacheProducer.mo4087b(null, true);
        } else {
            this.f22647f.mo4122a(consumerOfInputProducer, producerContext);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static Map<String, String> m19362a(al listener, String requestId, boolean valueFound) {
        if (listener.mo4116b(requestId)) {
            return C5346g.m18282a(f22643b, String.valueOf(valueFound));
        }
        return null;
    }

    /* renamed from: a */
    private void m19365a(final AtomicBoolean isCancelled, aj producerContext) {
        producerContext.m19211a(new C5450e(this) {
            /* renamed from: b */
            final /* synthetic */ C5593n f22638b;

            /* renamed from: a */
            public void mo4052a() {
                isCancelled.set(true);
            }
        });
    }
}
