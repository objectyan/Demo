package com.facebook.imagepipeline.p150f;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.facebook.common.internal.C5273m;
import com.facebook.common.internal.C5350k;
import com.facebook.common.p258g.C5325c;
import com.facebook.common.p258g.C5328f;
import com.facebook.imagepipeline.memory.C5651t;
import com.facebook.imagepipeline.memory.C5652u;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p149d.C5478i;
import com.facebook.imagepipeline.p149d.C5479j;
import com.facebook.imagepipeline.p149d.C5480k;
import com.facebook.imagepipeline.p149d.C5485n;
import com.facebook.imagepipeline.p149d.C5487q;
import com.facebook.imagepipeline.p149d.C5490t;
import com.facebook.imagepipeline.p150f.C5512i.C5511a;
import com.facebook.imagepipeline.p153l.C5600s;
import com.facebook.imagepipeline.p153l.ae;
import com.facebook.imagepipeline.p271a.p272a.C5445d;
import com.facebook.imagepipeline.p275c.C5456e;
import com.facebook.imagepipeline.p277h.C5526b;
import com.facebook.imagepipeline.p277h.C5527c;
import com.facebook.imagepipeline.p277h.C5532e;
import com.facebook.imagepipeline.p278j.C5539c;
import com.facebook.p135b.p137b.C5274c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: ImagePipelineConfig */
/* renamed from: com.facebook.imagepipeline.f.h */
public class C2947h {
    @Nullable
    /* renamed from: a */
    private final C5445d f13084a;
    /* renamed from: b */
    private final Config f13085b;
    /* renamed from: c */
    private final C5273m<C5487q> f13086c;
    /* renamed from: d */
    private final C5477f f13087d;
    /* renamed from: e */
    private final Context f13088e;
    /* renamed from: f */
    private final boolean f13089f;
    /* renamed from: g */
    private final boolean f13090g;
    /* renamed from: h */
    private final C5499f f13091h;
    /* renamed from: i */
    private final C5273m<C5487q> f13092i;
    /* renamed from: j */
    private final C5497e f13093j;
    /* renamed from: k */
    private final C5485n f13094k;
    @Nullable
    /* renamed from: l */
    private final C5526b f13095l;
    /* renamed from: m */
    private final C5273m<Boolean> f13096m;
    /* renamed from: n */
    private final C5274c f13097n;
    /* renamed from: o */
    private final C5325c f13098o;
    /* renamed from: p */
    private final ae f13099p;
    @Nullable
    /* renamed from: q */
    private final C5456e f13100q;
    /* renamed from: r */
    private final C5652u f13101r;
    /* renamed from: s */
    private final C5527c f13102s;
    /* renamed from: t */
    private final Set<C5539c> f13103t;
    /* renamed from: u */
    private final boolean f13104u;
    /* renamed from: v */
    private final C5274c f13105v;
    /* renamed from: w */
    private final C5512i f13106w;

    /* compiled from: ImagePipelineConfig */
    /* renamed from: com.facebook.imagepipeline.f.h$a */
    public static class C2946a {
        /* renamed from: a */
        private C5445d f13061a;
        /* renamed from: b */
        private Config f13062b;
        /* renamed from: c */
        private C5273m<C5487q> f13063c;
        /* renamed from: d */
        private C5477f f13064d;
        /* renamed from: e */
        private final Context f13065e;
        /* renamed from: f */
        private boolean f13066f;
        /* renamed from: g */
        private boolean f13067g;
        /* renamed from: h */
        private C5273m<C5487q> f13068h;
        /* renamed from: i */
        private C5497e f13069i;
        /* renamed from: j */
        private C5485n f13070j;
        /* renamed from: k */
        private C5526b f13071k;
        /* renamed from: l */
        private C5273m<Boolean> f13072l;
        /* renamed from: m */
        private C5274c f13073m;
        /* renamed from: n */
        private C5325c f13074n;
        /* renamed from: o */
        private ae f13075o;
        /* renamed from: p */
        private C5456e f13076p;
        /* renamed from: q */
        private C5652u f13077q;
        /* renamed from: r */
        private C5527c f13078r;
        /* renamed from: s */
        private Set<C5539c> f13079s;
        /* renamed from: t */
        private boolean f13080t;
        /* renamed from: u */
        private C5274c f13081u;
        /* renamed from: v */
        private C5499f f13082v;
        /* renamed from: w */
        private final C5511a f13083w;

        private C2946a(Context context) {
            this.f13066f = false;
            this.f13080t = true;
            this.f13083w = new C5511a(this);
            this.f13065e = (Context) C5350k.a(context);
        }

        /* renamed from: a */
        public C2946a m11677a(C5445d animatedImageFactory) {
            this.f13061a = animatedImageFactory;
            return this;
        }

        /* renamed from: a */
        public C2946a m11673a(Config config) {
            this.f13062b = config;
            return this;
        }

        /* renamed from: a */
        public C2946a m11676a(C5273m<C5487q> bitmapMemoryCacheParamsSupplier) {
            this.f13063c = (C5273m) C5350k.a(bitmapMemoryCacheParamsSupplier);
            return this;
        }

        /* renamed from: a */
        public C2946a m11679a(C5477f cacheKeyFactory) {
            this.f13064d = cacheKeyFactory;
            return this;
        }

        /* renamed from: a */
        public C2946a m11689a(boolean decodeMemoryFileEnabled) {
            this.f13067g = decodeMemoryFileEnabled;
            return this;
        }

        /* renamed from: a */
        public C2946a m11683a(C5499f fileCacheFactory) {
            this.f13082v = fileCacheFactory;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public C2946a m11681a(C5501c diskStorageFactory) {
            m11683a(new C5500b(diskStorageFactory));
            return this;
        }

        /* renamed from: a */
        public boolean m11690a() {
            return this.f13066f;
        }

        /* renamed from: b */
        public C2946a m11693b(boolean downsampleEnabled) {
            this.f13066f = downsampleEnabled;
            return this;
        }

        /* renamed from: b */
        public C2946a m11692b(C5273m<C5487q> encodedMemoryCacheParamsSupplier) {
            this.f13068h = (C5273m) C5350k.a(encodedMemoryCacheParamsSupplier);
            return this;
        }

        /* renamed from: a */
        public C2946a m11682a(C5497e executorSupplier) {
            this.f13069i = executorSupplier;
            return this;
        }

        /* renamed from: a */
        public C2946a m11680a(C5485n imageCacheStatsTracker) {
            this.f13070j = imageCacheStatsTracker;
            return this;
        }

        /* renamed from: a */
        public C2946a m11684a(C5526b imageDecoder) {
            this.f13071k = imageDecoder;
            return this;
        }

        /* renamed from: c */
        public C2946a m11695c(C5273m<Boolean> isPrefetchEnabledSupplier) {
            this.f13072l = isPrefetchEnabledSupplier;
            return this;
        }

        /* renamed from: a */
        public C2946a m11674a(C5274c mainDiskCacheConfig) {
            this.f13073m = mainDiskCacheConfig;
            return this;
        }

        /* renamed from: a */
        public C2946a m11675a(C5325c memoryTrimmableRegistry) {
            this.f13074n = memoryTrimmableRegistry;
            return this;
        }

        /* renamed from: a */
        public C2946a m11686a(ae networkFetcher) {
            this.f13075o = networkFetcher;
            return this;
        }

        /* renamed from: a */
        public C2946a m11678a(C5456e platformBitmapFactory) {
            this.f13076p = platformBitmapFactory;
            return this;
        }

        /* renamed from: a */
        public C2946a m11687a(C5652u poolFactory) {
            this.f13077q = poolFactory;
            return this;
        }

        /* renamed from: a */
        public C2946a m11685a(C5527c progressiveJpegConfig) {
            this.f13078r = progressiveJpegConfig;
            return this;
        }

        /* renamed from: a */
        public C2946a m11688a(Set<C5539c> requestListeners) {
            this.f13079s = requestListeners;
            return this;
        }

        /* renamed from: c */
        public C2946a m11696c(boolean resizeAndRotateEnabledForNetwork) {
            this.f13080t = resizeAndRotateEnabledForNetwork;
            return this;
        }

        /* renamed from: b */
        public C2946a m11691b(C5274c smallImageDiskCacheConfig) {
            this.f13081u = smallImageDiskCacheConfig;
            return this;
        }

        /* renamed from: b */
        public C5511a m11694b() {
            return this.f13083w;
        }

        /* renamed from: c */
        public C2947h m11697c() {
            return new C2947h();
        }
    }

    private C2947h(C2946a builder) {
        C5273m c5478i;
        Config config;
        C5477f a;
        C5499f c5500b;
        C5485n l;
        C5274c b;
        C5325c a2;
        ae c5600s;
        C5652u c5652u;
        C5527c c5532e;
        Set hashSet;
        C5497e c5498a;
        this.f13084a = builder.f13061a;
        if (builder.f13063c == null) {
            c5478i = new C5478i((ActivityManager) builder.f13065e.getSystemService(BusinessActivityManager.AUDIO_DIR));
        } else {
            c5478i = builder.f13063c;
        }
        this.f13086c = c5478i;
        if (builder.f13062b == null) {
            config = Config.ARGB_8888;
        } else {
            config = builder.f13062b;
        }
        this.f13085b = config;
        if (builder.f13064d == null) {
            a = C5479j.a();
        } else {
            a = builder.f13064d;
        }
        this.f13087d = a;
        this.f13088e = (Context) C5350k.a(builder.f13065e);
        this.f13090g = builder.f13067g;
        if (builder.f13082v == null) {
            c5500b = new C5500b(new C5502d());
        } else {
            c5500b = builder.f13082v;
        }
        this.f13091h = c5500b;
        this.f13089f = builder.f13066f;
        if (builder.f13068h == null) {
            c5478i = new C5480k();
        } else {
            c5478i = builder.f13068h;
        }
        this.f13092i = c5478i;
        if (builder.f13070j == null) {
            l = C5490t.l();
        } else {
            l = builder.f13070j;
        }
        this.f13094k = l;
        this.f13095l = builder.f13071k;
        if (builder.f13072l == null) {
            c5478i = new h$1(this);
        } else {
            c5478i = builder.f13072l;
        }
        this.f13096m = c5478i;
        if (builder.f13073m == null) {
            b = C2947h.m11699b(builder.f13065e);
        } else {
            b = builder.f13073m;
        }
        this.f13097n = b;
        if (builder.f13074n == null) {
            a2 = C5328f.a();
        } else {
            a2 = builder.f13074n;
        }
        this.f13098o = a2;
        if (builder.f13075o == null) {
            c5600s = new C5600s();
        } else {
            c5600s = builder.f13075o;
        }
        this.f13099p = c5600s;
        this.f13100q = builder.f13076p;
        if (builder.f13077q == null) {
            c5652u = new C5652u(C5651t.i().a());
        } else {
            c5652u = builder.f13077q;
        }
        this.f13101r = c5652u;
        if (builder.f13078r == null) {
            c5532e = new C5532e();
        } else {
            c5532e = builder.f13078r;
        }
        this.f13102s = c5532e;
        if (builder.f13079s == null) {
            hashSet = new HashSet();
        } else {
            hashSet = builder.f13079s;
        }
        this.f13103t = hashSet;
        this.f13104u = builder.f13080t;
        if (builder.f13081u == null) {
            b = this.f13097n;
        } else {
            b = builder.f13081u;
        }
        this.f13105v = b;
        int numCpuBoundThreads = this.f13101r.c();
        if (builder.f13069i == null) {
            c5498a = new C5498a(numCpuBoundThreads);
        } else {
            c5498a = builder.f13069i;
        }
        this.f13093j = c5498a;
        this.f13106w = builder.f13083w.a();
    }

    /* renamed from: b */
    private static C5274c m11699b(Context context) {
        return C5274c.a(context).m11175a();
    }

    @Nullable
    /* renamed from: a */
    public C5445d m11700a() {
        return this.f13084a;
    }

    /* renamed from: b */
    public Config m11701b() {
        return this.f13085b;
    }

    /* renamed from: c */
    public C5273m<C5487q> m11702c() {
        return this.f13086c;
    }

    /* renamed from: d */
    public C5477f m11703d() {
        return this.f13087d;
    }

    /* renamed from: e */
    public Context m11704e() {
        return this.f13088e;
    }

    /* renamed from: f */
    public boolean m11705f() {
        return this.f13106w.a();
    }

    /* renamed from: g */
    public boolean m11706g() {
        return this.f13090g;
    }

    /* renamed from: h */
    public C5499f m11707h() {
        return this.f13091h;
    }

    /* renamed from: i */
    public boolean m11708i() {
        return this.f13089f;
    }

    /* renamed from: j */
    public boolean m11709j() {
        return this.f13106w.c();
    }

    /* renamed from: k */
    public C5273m<C5487q> m11710k() {
        return this.f13092i;
    }

    /* renamed from: l */
    public C5497e m11711l() {
        return this.f13093j;
    }

    @Deprecated
    /* renamed from: m */
    public int m11712m() {
        return this.f13106w.b();
    }

    /* renamed from: n */
    public C5485n m11713n() {
        return this.f13094k;
    }

    @Nullable
    /* renamed from: o */
    public C5526b m11714o() {
        return this.f13095l;
    }

    /* renamed from: p */
    public C5273m<Boolean> m11715p() {
        return this.f13096m;
    }

    /* renamed from: q */
    public C5274c m11716q() {
        return this.f13097n;
    }

    /* renamed from: r */
    public C5325c m11717r() {
        return this.f13098o;
    }

    /* renamed from: s */
    public ae m11718s() {
        return this.f13099p;
    }

    @Nullable
    /* renamed from: t */
    public C5456e m11719t() {
        return this.f13100q;
    }

    /* renamed from: u */
    public C5652u m11720u() {
        return this.f13101r;
    }

    /* renamed from: v */
    public C5527c m11721v() {
        return this.f13102s;
    }

    /* renamed from: w */
    public Set<C5539c> m11722w() {
        return Collections.unmodifiableSet(this.f13103t);
    }

    /* renamed from: x */
    public boolean m11723x() {
        return this.f13104u;
    }

    /* renamed from: y */
    public C5274c m11724y() {
        return this.f13105v;
    }

    /* renamed from: z */
    public C5512i m11725z() {
        return this.f13106w;
    }

    /* renamed from: a */
    public static C2946a m11698a(Context context) {
        return new C2946a(context);
    }
}
