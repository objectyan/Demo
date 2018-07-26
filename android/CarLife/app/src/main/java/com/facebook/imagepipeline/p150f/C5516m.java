package com.facebook.imagepipeline.p150f;

import android.os.Build.VERSION;
import com.facebook.common.internal.C5350k;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.p139f.C2920a;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p141m.C2924g;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p153l.ae;
import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.am;
import com.facebook.imagepipeline.p153l.as;
import com.facebook.imagepipeline.p153l.au;
import com.facebook.imagepipeline.p153l.av;
import com.facebook.imagepipeline.p154m.C2959c;
import com.facebook.imagepipeline.p154m.c$b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProducerSequenceFactory */
/* renamed from: com.facebook.imagepipeline.f.m */
public class C5516m {
    @VisibleForTesting
    /* renamed from: a */
    ai<C2921a<C5534b>> f22406a;
    @VisibleForTesting
    /* renamed from: b */
    ai<C2952d> f22407b;
    @VisibleForTesting
    /* renamed from: c */
    ai<C2921a<C5640y>> f22408c;
    @VisibleForTesting
    /* renamed from: d */
    ai<Void> f22409d;
    @VisibleForTesting
    /* renamed from: e */
    ai<C2921a<C5534b>> f22410e;
    @VisibleForTesting
    /* renamed from: f */
    ai<C2921a<C5534b>> f22411f;
    @VisibleForTesting
    /* renamed from: g */
    ai<C2921a<C5534b>> f22412g;
    @VisibleForTesting
    /* renamed from: h */
    ai<C2921a<C5534b>> f22413h;
    @VisibleForTesting
    /* renamed from: i */
    ai<C2921a<C5534b>> f22414i;
    @VisibleForTesting
    /* renamed from: j */
    ai<C2921a<C5534b>> f22415j;
    @VisibleForTesting
    /* renamed from: k */
    Map<ai<C2921a<C5534b>>, ai<C2921a<C5534b>>> f22416k = new HashMap();
    @VisibleForTesting
    /* renamed from: l */
    Map<ai<C2921a<C5534b>>, ai<Void>> f22417l = new HashMap();
    /* renamed from: m */
    private final C5515l f22418m;
    /* renamed from: n */
    private final ae f22419n;
    /* renamed from: o */
    private final boolean f22420o;
    /* renamed from: p */
    private final boolean f22421p;
    /* renamed from: q */
    private final boolean f22422q;
    /* renamed from: r */
    private final as f22423r;
    /* renamed from: s */
    private final int f22424s;
    /* renamed from: t */
    private ai<C2952d> f22425t;

    public C5516m(C5515l producerFactory, ae networkFetcher, boolean resizeAndRotateEnabledForNetwork, boolean downsampleEnabled, boolean webpSupportEnabled, as threadHandoffProducerQueue, int throttlingMaxSimultaneousRequests) {
        this.f22418m = producerFactory;
        this.f22419n = networkFetcher;
        this.f22420o = resizeAndRotateEnabledForNetwork;
        this.f22422q = downsampleEnabled;
        this.f22421p = webpSupportEnabled;
        this.f22423r = threadHandoffProducerQueue;
        this.f22424s = throttlingMaxSimultaneousRequests;
    }

    /* renamed from: a */
    public ai<C2921a<C5640y>> m18986a(C2959c imageRequest) {
        C5516m.m18978e(imageRequest);
        synchronized (this) {
            if (this.f22408c == null) {
                this.f22408c = new am(m18969b());
            }
        }
        return this.f22408c;
    }

    /* renamed from: b */
    public ai<Void> m18987b(C2959c imageRequest) {
        C5516m.m18978e(imageRequest);
        return m18972c();
    }

    /* renamed from: e */
    private static void m18978e(C2959c imageRequest) {
        C5350k.m18310a((Object) imageRequest);
        C5350k.m18315a(C2924g.a(imageRequest.b()));
        C5350k.m18315a(imageRequest.k().m19441a() <= c$b.ENCODED_MEMORY_CACHE.m19441a());
    }

    /* renamed from: c */
    public ai<C2921a<C5534b>> m18988c(C2959c imageRequest) {
        ai pipelineSequence = m18981f(imageRequest);
        if (imageRequest.n() != null) {
            return m18977e(pipelineSequence);
        }
        return pipelineSequence;
    }

    /* renamed from: d */
    public ai<Void> m18989d(C2959c imageRequest) {
        return m18980f(m18981f(imageRequest));
    }

    /* renamed from: f */
    private ai<C2921a<C5534b>> m18981f(C2959c imageRequest) {
        C5350k.m18310a((Object) imageRequest);
        Object uri = imageRequest.b();
        C5350k.m18311a(uri, (Object) "Uri is null.");
        if (C2924g.a(uri)) {
            return m18965a();
        }
        if (C2924g.b(uri)) {
            if (C2920a.b(C2920a.c(uri.getPath()))) {
                return m18979f();
            }
            return m18976e();
        } else if (C2924g.c(uri)) {
            return m18982g();
        } else {
            if (C2924g.f(uri)) {
                return m18984i();
            }
            if (C2924g.g(uri)) {
                return m18983h();
            }
            if (C2924g.h(uri)) {
                return m18985j();
            }
            String uriString = uri.toString();
            if (uriString.length() > 30) {
                uriString = uriString.substring(0, 30) + "...";
            }
            throw new RuntimeException("Unsupported uri scheme! Uri is: " + uriString);
        }
    }

    /* renamed from: a */
    private synchronized ai<C2921a<C5534b>> m18965a() {
        if (this.f22406a == null) {
            this.f22406a = m18970b(m18974d());
        }
        return this.f22406a;
    }

    /* renamed from: b */
    private synchronized ai<C2952d> m18969b() {
        if (this.f22407b == null) {
            this.f22407b = this.f22418m.m18943a(m18974d(), this.f22423r);
        }
        return this.f22407b;
    }

    /* renamed from: c */
    private synchronized ai<Void> m18972c() {
        if (this.f22409d == null) {
            C5515l c5515l = this.f22418m;
            this.f22409d = C5515l.m18941l(m18969b());
        }
        return this.f22409d;
    }

    /* renamed from: d */
    private synchronized ai<C2952d> m18974d() {
        if (this.f22425t == null) {
            this.f22425t = C5515l.m18938a(m18973c(this.f22418m.m18942a(this.f22419n)));
            if (this.f22420o && !this.f22422q) {
                this.f22425t = this.f22418m.m18963k(this.f22425t);
            }
        }
        return this.f22425t;
    }

    /* renamed from: e */
    private synchronized ai<C2921a<C5534b>> m18976e() {
        if (this.f22410e == null) {
            this.f22410e = m18966a(this.f22418m.m18956f());
        }
        return this.f22410e;
    }

    /* renamed from: f */
    private synchronized ai<C2921a<C5534b>> m18979f() {
        if (this.f22411f == null) {
            this.f22411f = m18975d(this.f22418m.m18959h());
        }
        return this.f22411f;
    }

    /* renamed from: g */
    private synchronized ai<C2921a<C5534b>> m18982g() {
        if (this.f22412g == null) {
            this.f22412g = m18967a(this.f22418m.m18950c(), new av[]{this.f22418m.m18952d(), this.f22418m.m18954e()});
        }
        return this.f22412g;
    }

    /* renamed from: h */
    private synchronized ai<C2921a<C5534b>> m18983h() {
        if (this.f22413h == null) {
            this.f22413h = m18966a(this.f22418m.m18957g());
        }
        return this.f22413h;
    }

    /* renamed from: i */
    private synchronized ai<C2921a<C5534b>> m18984i() {
        if (this.f22414i == null) {
            this.f22414i = m18966a(this.f22418m.m18948b());
        }
        return this.f22414i;
    }

    /* renamed from: j */
    private synchronized ai<C2921a<C5534b>> m18985j() {
        if (this.f22415j == null) {
            ai inputProducer = this.f22418m.m18946a();
            if (VERSION.SDK_INT < 18 && !this.f22421p) {
                inputProducer = this.f22418m.m18964m(inputProducer);
            }
            C5515l c5515l = this.f22418m;
            inputProducer = C5515l.m18938a(inputProducer);
            if (!this.f22422q) {
                inputProducer = this.f22418m.m18963k(inputProducer);
            }
            this.f22415j = m18970b(inputProducer);
        }
        return this.f22415j;
    }

    /* renamed from: a */
    private ai<C2921a<C5534b>> m18966a(ai<C2952d> inputProducer) {
        return m18967a(inputProducer, new av[]{this.f22418m.m18954e()});
    }

    /* renamed from: a */
    private ai<C2921a<C5534b>> m18967a(ai<C2952d> inputProducer, av<C2952d>[] thumbnailProducers) {
        return m18970b(m18971b(m18973c((ai) inputProducer), thumbnailProducers));
    }

    /* renamed from: b */
    private ai<C2921a<C5534b>> m18970b(ai<C2952d> inputProducer) {
        return m18975d(this.f22418m.m18953e(inputProducer));
    }

    /* renamed from: c */
    private ai<C2952d> m18973c(ai<C2952d> inputProducer) {
        if (VERSION.SDK_INT < 18 && !this.f22421p) {
            inputProducer = this.f22418m.m18964m(inputProducer);
        }
        return this.f22418m.m18958g(this.f22418m.m18960h(this.f22418m.m18955f(inputProducer)));
    }

    /* renamed from: d */
    private ai<C2921a<C5534b>> m18975d(ai<C2921a<C5534b>> inputProducer) {
        return this.f22418m.m18947b(this.f22418m.m18943a(this.f22418m.m18949c(this.f22418m.m18951d(inputProducer)), this.f22423r));
    }

    /* renamed from: b */
    private ai<C2952d> m18971b(ai<C2952d> inputProducer, av<C2952d>[] thumbnailProducers) {
        ai localImageProducer = C5515l.m18938a((ai) inputProducer);
        if (!this.f22422q) {
            localImageProducer = this.f22418m.m18963k(localImageProducer);
        }
        ai localImageThrottlingProducer = this.f22418m.m18944a(this.f22424s, localImageProducer);
        C5515l c5515l = this.f22418m;
        return C5515l.m18939a(m18968a((av[]) thumbnailProducers), localImageThrottlingProducer);
    }

    /* renamed from: a */
    private ai<C2952d> m18968a(av<C2952d>[] thumbnailProducers) {
        au thumbnailBranchProducer = this.f22418m.m18945a((av[]) thumbnailProducers);
        return this.f22422q ? thumbnailBranchProducer : this.f22418m.m18963k(thumbnailBranchProducer);
    }

    /* renamed from: e */
    private synchronized ai<C2921a<C5534b>> m18977e(ai<C2921a<C5534b>> inputProducer) {
        if (!this.f22416k.containsKey(inputProducer)) {
            this.f22416k.put(inputProducer, this.f22418m.m18961i(this.f22418m.m18962j(inputProducer)));
        }
        return (ai) this.f22416k.get(inputProducer);
    }

    /* renamed from: f */
    private synchronized ai<Void> m18980f(ai<C2921a<C5534b>> inputProducer) {
        if (!this.f22417l.containsKey(inputProducer)) {
            C5515l c5515l = this.f22418m;
            this.f22417l.put(inputProducer, C5515l.m18941l(inputProducer));
        }
        return (ai) this.f22417l.get(inputProducer);
    }
}
