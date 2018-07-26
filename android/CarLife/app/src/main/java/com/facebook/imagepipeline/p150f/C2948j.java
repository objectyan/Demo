package com.facebook.imagepipeline.p150f;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.C5338a;
import com.facebook.common.internal.C5350k;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5652u;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C2945h;
import com.facebook.imagepipeline.p149d.C5464a;
import com.facebook.imagepipeline.p149d.C5467b;
import com.facebook.imagepipeline.p149d.C5476e;
import com.facebook.imagepipeline.p149d.C5482l;
import com.facebook.imagepipeline.p149d.C5484m;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p153l.as;
import com.facebook.imagepipeline.p271a.p272a.C5443b;
import com.facebook.imagepipeline.p271a.p272a.C5444c;
import com.facebook.imagepipeline.p271a.p272a.C5445d;
import com.facebook.imagepipeline.p275c.C5456e;
import com.facebook.imagepipeline.p275c.C5457a;
import com.facebook.imagepipeline.p275c.C5458b;
import com.facebook.imagepipeline.p275c.C5459c;
import com.facebook.imagepipeline.p275c.C5460d;
import com.facebook.imagepipeline.p277h.C5526b;
import com.facebook.imagepipeline.p279k.C5543e;
import com.facebook.imagepipeline.p279k.C5544a;
import com.facebook.imagepipeline.p279k.C5546c;
import com.facebook.imagepipeline.p279k.C5547d;
import com.facebook.p135b.p136a.C5247d;
import com.facebook.p135b.p137b.C5266d;
import com.facebook.p135b.p137b.C5274c;
import com.facebook.p135b.p137b.C5281j;
import com.facebook.p135b.p137b.C5282e;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: ImagePipelineFactory */
/* renamed from: com.facebook.imagepipeline.f.j */
public class C2948j {
    /* renamed from: a */
    private static C2948j f13107a = null;
    /* renamed from: b */
    private final as f13108b;
    /* renamed from: c */
    private final C2947h f13109c;
    /* renamed from: d */
    private C2945h<C5247d, C5534b> f13110d;
    /* renamed from: e */
    private C2944p<C5247d, C5534b> f13111e;
    /* renamed from: f */
    private C2945h<C5247d, C5640y> f13112f;
    /* renamed from: g */
    private C2944p<C5247d, C5640y> f13113g;
    /* renamed from: h */
    private C5476e f13114h;
    /* renamed from: i */
    private C5281j f13115i;
    /* renamed from: j */
    private C5526b f13116j;
    /* renamed from: k */
    private C5509g f13117k;
    /* renamed from: l */
    private C5515l f13118l;
    /* renamed from: m */
    private C5516m f13119m;
    /* renamed from: n */
    private C5476e f13120n;
    /* renamed from: o */
    private C5281j f13121o;
    /* renamed from: p */
    private C5456e f13122p;
    /* renamed from: q */
    private C5543e f13123q;
    /* renamed from: r */
    private C5443b f13124r;

    /* renamed from: a */
    public static C2948j m11728a() {
        return (C2948j) C5350k.a(f13107a, "ImagePipelineFactory was not initialized!");
    }

    /* renamed from: a */
    public static void m11730a(Context context) {
        C2948j.m11731a(C2947h.m11698a(context).m11697c());
    }

    /* renamed from: a */
    public static void m11731a(C2947h imagePipelineConfig) {
        f13107a = new C2948j(imagePipelineConfig);
    }

    /* renamed from: b */
    public static void m11732b() {
        if (f13107a != null) {
            f13107a.m11740e().mo2038a(C5338a.a());
            f13107a.m11742g().mo2038a(C5338a.a());
            f13107a = null;
        }
    }

    public C2948j(C2947h config) {
        this.f13109c = (C2947h) C5350k.a(config);
        this.f13108b = new as(config.m11711l().e());
    }

    /* renamed from: c */
    public C5443b m11738c() {
        if (this.f13124r == null) {
            this.f13124r = C5444c.a(m11746k(), this.f13109c.m11711l());
        }
        return this.f13124r;
    }

    /* renamed from: d */
    public C2945h<C5247d, C5534b> m11739d() {
        if (this.f13110d == null) {
            this.f13110d = C5464a.a(this.f13109c.m11702c(), this.f13109c.m11717r());
        }
        return this.f13110d;
    }

    /* renamed from: e */
    public C2944p<C5247d, C5534b> m11740e() {
        if (this.f13111e == null) {
            this.f13111e = C5467b.a(m11739d(), this.f13109c.m11713n());
        }
        return this.f13111e;
    }

    @Deprecated
    /* renamed from: a */
    public static C5282e m11726a(C5274c diskCacheConfig, C5266d diskStorage) {
        return C5500b.a(diskCacheConfig, diskStorage);
    }

    /* renamed from: f */
    public C2945h<C5247d, C5640y> m11741f() {
        if (this.f13112f == null) {
            this.f13112f = C5482l.a(this.f13109c.m11710k(), this.f13109c.m11717r());
        }
        return this.f13112f;
    }

    /* renamed from: g */
    public C2944p<C5247d, C5640y> m11742g() {
        if (this.f13113g == null) {
            this.f13113g = C5484m.a(m11741f(), this.f13109c.m11713n());
        }
        return this.f13113g;
    }

    /* renamed from: o */
    private C5526b m11733o() {
        if (this.f13116j == null) {
            if (this.f13109c.m11714o() != null) {
                this.f13116j = this.f13109c.m11714o();
            } else {
                C5445d animatedImageFactory;
                if (m11738c() != null) {
                    animatedImageFactory = m11738c().a();
                } else {
                    animatedImageFactory = null;
                }
                this.f13116j = new C5526b(animatedImageFactory, m11747l(), this.f13109c.m11701b());
            }
        }
        return this.f13116j;
    }

    /* renamed from: p */
    private C5476e m11734p() {
        if (this.f13114h == null) {
            this.f13114h = new C5476e(m11744i(), this.f13109c.m11720u().e(), this.f13109c.m11720u().f(), this.f13109c.m11711l().a(), this.f13109c.m11711l().b(), this.f13109c.m11713n());
        }
        return this.f13114h;
    }

    @Deprecated
    /* renamed from: h */
    public C5281j m11743h() {
        return m11744i();
    }

    /* renamed from: i */
    public C5281j m11744i() {
        if (this.f13115i == null) {
            this.f13115i = this.f13109c.m11707h().a(this.f13109c.m11716q());
        }
        return this.f13115i;
    }

    /* renamed from: j */
    public C5509g m11745j() {
        if (this.f13117k == null) {
            this.f13117k = new C5509g(m11736r(), this.f13109c.m11722w(), this.f13109c.m11715p(), m11740e(), m11742g(), m11734p(), m11737s(), this.f13109c.m11703d(), this.f13108b);
        }
        return this.f13117k;
    }

    /* renamed from: a */
    public static C5456e m11727a(C5652u poolFactory, C5543e platformDecoder) {
        if (VERSION.SDK_INT >= 21) {
            return new C5457a(poolFactory.a());
        }
        if (VERSION.SDK_INT >= 11) {
            return new C5460d(new C5458b(poolFactory.e()), platformDecoder);
        }
        return new C5459c();
    }

    /* renamed from: k */
    public C5456e m11746k() {
        if (this.f13122p == null) {
            this.f13122p = C2948j.m11727a(this.f13109c.m11720u(), m11747l());
        }
        return this.f13122p;
    }

    /* renamed from: a */
    public static C5543e m11729a(C5652u poolFactory, boolean decodeMemoryFileEnabled, boolean webpSupportEnabled) {
        if (VERSION.SDK_INT >= 21) {
            int maxNumThreads = poolFactory.c();
            return new C5544a(poolFactory.a(), maxNumThreads, new SynchronizedPool(maxNumThreads));
        } else if (!decodeMemoryFileEnabled || VERSION.SDK_INT >= 19) {
            return new C5547d(poolFactory.b());
        } else {
            return new C5546c(webpSupportEnabled);
        }
    }

    /* renamed from: l */
    public C5543e m11747l() {
        if (this.f13123q == null) {
            this.f13123q = C2948j.m11729a(this.f13109c.m11720u(), this.f13109c.m11706g(), this.f13109c.m11725z().c());
        }
        return this.f13123q;
    }

    /* renamed from: q */
    private C5515l m11735q() {
        if (this.f13118l == null) {
            this.f13118l = new C5515l(this.f13109c.m11704e(), this.f13109c.m11720u().h(), m11733o(), this.f13109c.m11721v(), this.f13109c.m11708i(), this.f13109c.m11723x(), this.f13109c.m11711l(), this.f13109c.m11720u().e(), m11740e(), m11742g(), m11734p(), m11737s(), this.f13109c.m11703d(), m11746k(), this.f13109c.m11725z().a(), this.f13109c.m11725z().b());
        }
        return this.f13118l;
    }

    /* renamed from: r */
    private C5516m m11736r() {
        if (this.f13119m == null) {
            this.f13119m = new C5516m(m11735q(), this.f13109c.m11718s(), this.f13109c.m11723x(), this.f13109c.m11708i(), this.f13109c.m11725z().c(), this.f13108b, this.f13109c.m11725z().d());
        }
        return this.f13119m;
    }

    @Deprecated
    /* renamed from: m */
    public C5281j m11748m() {
        return m11749n();
    }

    /* renamed from: n */
    public C5281j m11749n() {
        if (this.f13121o == null) {
            this.f13121o = this.f13109c.m11707h().a(this.f13109c.m11724y());
        }
        return this.f13121o;
    }

    /* renamed from: s */
    private C5476e m11737s() {
        if (this.f13120n == null) {
            this.f13120n = new C5476e(m11749n(), this.f13109c.m11720u().e(), this.f13109c.m11720u().f(), this.f13109c.m11711l().a(), this.f13109c.m11711l().b(), this.f13109c.m11713n());
        }
        return this.f13120n;
    }
}
