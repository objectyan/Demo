package com.facebook.imagepipeline.p153l;

import android.net.Uri;
import com.facebook.imagepipeline.p152i.C2952d;

/* compiled from: FetchState */
/* renamed from: com.facebook.imagepipeline.l.r */
public class C5453r {
    /* renamed from: a */
    private final C5517j<C2952d> f22252a;
    /* renamed from: b */
    private final aj f22253b;
    /* renamed from: c */
    private long f22254c = 0;

    public C5453r(C5517j<C2952d> consumer, aj context) {
        this.f22252a = consumer;
        this.f22253b = context;
    }

    /* renamed from: a */
    public C5517j<C2952d> m18715a() {
        return this.f22252a;
    }

    /* renamed from: b */
    public aj m18717b() {
        return this.f22253b;
    }

    /* renamed from: c */
    public String m18718c() {
        return this.f22253b.m19212b();
    }

    /* renamed from: d */
    public al m18719d() {
        return this.f22253b.m19213c();
    }

    /* renamed from: e */
    public Uri m18720e() {
        return this.f22253b.m19210a().b();
    }

    /* renamed from: f */
    public long m18721f() {
        return this.f22254c;
    }

    /* renamed from: a */
    public void m18716a(long lastIntermediateResultTimeMs) {
        this.f22254c = lastIntermediateResultTimeMs;
    }
}
