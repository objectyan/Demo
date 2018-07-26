package com.facebook.imagepipeline.p150f;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.C2923j;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5476e;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p151g.C2949d;
import com.facebook.imagepipeline.p151g.C5523f;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.al;
import com.facebook.imagepipeline.p153l.ao;
import com.facebook.imagepipeline.p153l.as;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.C2960d;
import com.facebook.imagepipeline.p154m.c$b;
import com.facebook.imagepipeline.p276e.C5494c;
import com.facebook.imagepipeline.p278j.C5539c;
import com.facebook.imagepipeline.p278j.C5541b;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p138c.C2918d;
import com.facebook.p138c.C5291e;
import com.facebook.p138c.C5295i;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
import p000a.C0012h;
import p000a.C0027j;

@ThreadSafe
/* compiled from: ImagePipeline */
/* renamed from: com.facebook.imagepipeline.f.g */
public class C5509g {
    /* renamed from: a */
    private static final CancellationException f22363a = new CancellationException("Prefetching is not enabled");
    /* renamed from: b */
    private final C5516m f22364b;
    /* renamed from: c */
    private final C5539c f22365c;
    /* renamed from: d */
    private final C5273m<Boolean> f22366d;
    /* renamed from: e */
    private final C2944p<C5247d, C5534b> f22367e;
    /* renamed from: f */
    private final C2944p<C5247d, C5640y> f22368f;
    /* renamed from: g */
    private final C5476e f22369g;
    /* renamed from: h */
    private final C5476e f22370h;
    /* renamed from: i */
    private final C5477f f22371i;
    /* renamed from: j */
    private final as f22372j;
    /* renamed from: k */
    private AtomicLong f22373k = new AtomicLong();

    /* compiled from: ImagePipeline */
    /* renamed from: com.facebook.imagepipeline.f.g$3 */
    class C55053 implements Predicate<C5247d> {
        /* renamed from: a */
        final /* synthetic */ C5509g f22356a;

        C55053(C5509g this$0) {
            this.f22356a = this$0;
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m18884a((C5247d) obj);
        }

        /* renamed from: a */
        public boolean m18884a(C5247d key) {
            return true;
        }
    }

    public C5509g(C5516m producerSequenceFactory, Set<C5539c> requestListeners, C5273m<Boolean> isPrefetchEnabledSupplier, C2944p<C5247d, C5534b> bitmapMemoryCache, C2944p<C5247d, C5640y> encodedMemoryCache, C5476e mainBufferedDiskCache, C5476e smallImageBufferedDiskCache, C5477f cacheKeyFactory, as threadHandoffProducerQueue) {
        this.f22364b = producerSequenceFactory;
        this.f22365c = new C5541b(requestListeners);
        this.f22366d = isPrefetchEnabledSupplier;
        this.f22367e = bitmapMemoryCache;
        this.f22368f = encodedMemoryCache;
        this.f22369g = mainBufferedDiskCache;
        this.f22370h = smallImageBufferedDiskCache;
        this.f22371i = cacheKeyFactory;
        this.f22372j = threadHandoffProducerQueue;
    }

    /* renamed from: i */
    private String m18894i() {
        return String.valueOf(this.f22373k.getAndIncrement());
    }

    /* renamed from: a */
    public C5273m<C2918d<C2921a<C5534b>>> m18897a(final C2959c imageRequest, final Object callerContext, final boolean bitmapCacheOnly) {
        return new C5273m<C2918d<C2921a<C5534b>>>(this) {
            /* renamed from: d */
            final /* synthetic */ C5509g f22352d;

            /* renamed from: b */
            public /* synthetic */ Object mo3969b() {
                return m18880a();
            }

            /* renamed from: a */
            public C2918d<C2921a<C5534b>> m18880a() {
                if (bitmapCacheOnly) {
                    return this.f22352d.m18901b(imageRequest, callerContext);
                }
                return this.f22352d.m18905c(imageRequest, callerContext);
            }

            public String toString() {
                return C2923j.a(this).m18305a("uri", imageRequest.b()).toString();
            }
        };
    }

    /* renamed from: a */
    public C5273m<C2918d<C2921a<C5640y>>> m18896a(final C2959c imageRequest, final Object callerContext) {
        return new C5273m<C2918d<C2921a<C5640y>>>(this) {
            /* renamed from: c */
            final /* synthetic */ C5509g f22355c;

            /* renamed from: b */
            public /* synthetic */ Object mo3969b() {
                return m18882a();
            }

            /* renamed from: a */
            public C2918d<C2921a<C5640y>> m18882a() {
                return this.f22355c.m18910d(imageRequest, callerContext);
            }

            public String toString() {
                return C2923j.a(this).m18305a("uri", imageRequest.b()).toString();
            }
        };
    }

    /* renamed from: b */
    public C2918d<C2921a<C5534b>> m18901b(C2959c imageRequest, Object callerContext) {
        try {
            return m18890a(this.f22364b.m18988c(imageRequest), imageRequest, c$b.BITMAP_MEMORY_CACHE, callerContext);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: c */
    public C2918d<C2921a<C5534b>> m18905c(C2959c imageRequest, Object callerContext) {
        try {
            return m18890a(this.f22364b.m18988c(imageRequest), imageRequest, c$b.FULL_FETCH, callerContext);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: d */
    public C2918d<C2921a<C5640y>> m18910d(C2959c imageRequest, Object callerContext) {
        C5350k.m18310a(imageRequest.b());
        try {
            ai<C2921a<C5640y>> producerSequence = this.f22364b.m18986a(imageRequest);
            if (imageRequest.e() != null) {
                imageRequest = C2960d.a(imageRequest).a(null).m();
            }
            return m18890a(producerSequence, imageRequest, c$b.FULL_FETCH, callerContext);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: e */
    public C2918d<Void> m18913e(C2959c imageRequest, Object callerContext) {
        if (!((Boolean) this.f22366d.mo3969b()).booleanValue()) {
            return C5291e.m18039a(f22363a);
        }
        try {
            return m18891a(this.f22364b.m18989d(imageRequest), imageRequest, c$b.FULL_FETCH, callerContext, C5494c.MEDIUM);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: f */
    public C2918d<Void> m18917f(C2959c imageRequest, Object callerContext) {
        return m18895a(imageRequest, callerContext, C5494c.MEDIUM);
    }

    /* renamed from: a */
    public C2918d<Void> m18895a(C2959c imageRequest, Object callerContext, C5494c priority) {
        if (!((Boolean) this.f22366d.mo3969b()).booleanValue()) {
            return C5291e.m18039a(f22363a);
        }
        try {
            return m18891a(this.f22364b.m18987b(imageRequest), imageRequest, c$b.FULL_FETCH, callerContext, priority);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: a */
    public void m18899a(Uri uri) {
        Predicate<C5247d> predicate = m18893g(uri);
        this.f22367e.a(predicate);
        this.f22368f.a(predicate);
    }

    /* renamed from: b */
    public void m18903b(Uri uri) {
        m18900a(C2959c.a(uri));
    }

    /* renamed from: a */
    public void m18900a(C2959c imageRequest) {
        C5247d cacheKey = this.f22371i.mo4064c(imageRequest, null);
        this.f22369g.m18780d(cacheKey);
        this.f22370h.m18780d(cacheKey);
    }

    /* renamed from: c */
    public void m18907c(Uri uri) {
        m18899a(uri);
        m18903b(uri);
    }

    /* renamed from: a */
    public void m18898a() {
        Predicate<C5247d> allPredicate = new C55053(this);
        this.f22367e.a(allPredicate);
        this.f22368f.a(allPredicate);
    }

    /* renamed from: b */
    public void m18902b() {
        this.f22369g.m18774a();
        this.f22370h.m18774a();
    }

    /* renamed from: c */
    public void m18906c() {
        m18898a();
        m18902b();
    }

    /* renamed from: d */
    public boolean m18912d(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.f22367e.b(m18893g(uri));
    }

    /* renamed from: d */
    public C2944p<C5247d, C5534b> m18911d() {
        return this.f22367e;
    }

    /* renamed from: b */
    public boolean m18904b(C2959c imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        C2921a<C5534b> ref = this.f22367e.a(this.f22371i.mo4062a(imageRequest, null));
        try {
            boolean a = C2921a.a(ref);
            return a;
        } finally {
            C2921a.c(ref);
        }
    }

    /* renamed from: e */
    public boolean m18915e(Uri uri) {
        return m18908c(C2959c.a(uri));
    }

    /* renamed from: c */
    public boolean m18908c(C2959c imageRequest) {
        return this.f22369g.m18779c(this.f22371i.mo4064c(imageRequest, null));
    }

    /* renamed from: f */
    public C2918d<Boolean> m18916f(Uri uri) {
        return m18909d(C2959c.a(uri));
    }

    /* renamed from: d */
    public C2918d<Boolean> m18909d(C2959c imageRequest) {
        final C5247d cacheKey = this.f22371i.mo4064c(imageRequest, null);
        final C5295i<Boolean> dataSource = C5295i.m18055j();
        this.f22369g.m18778b(cacheKey).b(new C0012h<Boolean, C0027j<Boolean>>(this) {
            /* renamed from: b */
            final /* synthetic */ C5509g f22360b;

            /* renamed from: a */
            public /* synthetic */ Object m18887a(C0027j c0027j) throws Exception {
                return m18888b(c0027j);
            }

            /* renamed from: b */
            public C0027j<Boolean> m18888b(C0027j<Boolean> task) throws Exception {
                if (task.d() || task.e() || !((Boolean) task.f()).booleanValue()) {
                    return this.f22360b.f22370h.m18778b(cacheKey);
                }
                return C0027j.a(Boolean.valueOf(true));
            }
        }).a(new C0012h<Boolean, Void>(this) {
            /* renamed from: b */
            final /* synthetic */ C5509g f22358b;

            /* renamed from: a */
            public /* synthetic */ Object m18885a(C0027j c0027j) throws Exception {
                return m18886b(c0027j);
            }

            /* renamed from: b */
            public Void m18886b(C0027j<Boolean> task) throws Exception {
                C5295i c5295i = dataSource;
                boolean z = (task.d() || task.e() || !((Boolean) task.f()).booleanValue()) ? false : true;
                c5295i.m18059b(Boolean.valueOf(z));
                return null;
            }
        });
        return dataSource;
    }

    /* renamed from: a */
    private <T> C2918d<C2921a<T>> m18890a(ai<C2921a<T>> producerSequence, C2959c imageRequest, c$b lowestPermittedRequestLevelOnSubmit, Object callerContext) {
        boolean z = false;
        try {
            c$b lowestPermittedRequestLevel = c$b.m19440a(imageRequest.k(), lowestPermittedRequestLevelOnSubmit);
            String i = m18894i();
            al alVar = this.f22365c;
            if (imageRequest.h() || !C2924g.a(imageRequest.b())) {
                z = true;
            }
            return C2949d.a(producerSequence, new ao(imageRequest, i, alVar, callerContext, lowestPermittedRequestLevel, false, z, imageRequest.j()), this.f22365c);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: a */
    private C2918d<Void> m18891a(ai<Void> producerSequence, C2959c imageRequest, c$b lowestPermittedRequestLevelOnSubmit, Object callerContext, C5494c priority) {
        try {
            return C5523f.m19023a(producerSequence, new ao(imageRequest, m18894i(), this.f22365c, callerContext, c$b.m19440a(imageRequest.k(), lowestPermittedRequestLevelOnSubmit), true, false, priority), this.f22365c);
        } catch (Throwable exception) {
            return C5291e.m18039a(exception);
        }
    }

    /* renamed from: g */
    private Predicate<C5247d> m18893g(final Uri uri) {
        return new Predicate<C5247d>(this) {
            /* renamed from: b */
            final /* synthetic */ C5509g f22362b;

            public /* synthetic */ boolean apply(Object obj) {
                return m18889a((C5247d) obj);
            }

            /* renamed from: a */
            public boolean m18889a(C5247d key) {
                return key.mo3933a(uri);
            }
        };
    }

    /* renamed from: e */
    public void m18914e() {
        this.f22372j.m19259a();
    }

    /* renamed from: f */
    public void m18918f() {
        this.f22372j.m19261b();
    }

    /* renamed from: g */
    public boolean m18919g() {
        return this.f22372j.m19263c();
    }

    /* renamed from: h */
    public C5477f m18920h() {
        return this.f22371i;
    }
}
