package com.baidu.baidumaps.p042f.p043a.p045b;

import com.baidu.navi.fragment.NaviFragmentManager;

/* compiled from: CarResultModel */
/* renamed from: com.baidu.baidumaps.f.a.b.a */
public class C0706a {
    /* renamed from: a */
    public static int f2277a = 155;
    /* renamed from: b */
    public static int f2278b = 155;
    /* renamed from: c */
    public static int f2279c = NaviFragmentManager.TYPE_CAR_DRV_SETTING;
    /* renamed from: d */
    public static final int f2280d = 130;
    /* renamed from: e */
    public static final int f2281e = 56;
    /* renamed from: f */
    public static final int f2282f = 13;
    /* renamed from: g */
    public static final int f2283g = 7;
    /* renamed from: h */
    public static final int f2284h = 53;
    /* renamed from: i */
    public static final int f2285i = 50;
    /* renamed from: s */
    public static final String f2286s = "CarRouteDMapPG";
    /* renamed from: x */
    private static C0706a f2287x = null;
    /* renamed from: A */
    private boolean f2288A = false;
    /* renamed from: j */
    public boolean f2289j = false;
    /* renamed from: k */
    public boolean f2290k = false;
    /* renamed from: l */
    public boolean f2291l = false;
    /* renamed from: m */
    public boolean f2292m = false;
    /* renamed from: n */
    public boolean f2293n = false;
    /* renamed from: o */
    public boolean f2294o = false;
    /* renamed from: p */
    public boolean f2295p = false;
    /* renamed from: q */
    public boolean f2296q = false;
    /* renamed from: r */
    public boolean f2297r = false;
    /* renamed from: t */
    public boolean f2298t = false;
    /* renamed from: u */
    public boolean f2299u = false;
    /* renamed from: v */
    public int f2300v = -1;
    /* renamed from: w */
    public String f2301w = "0";
    /* renamed from: y */
    private boolean f2302y = false;
    /* renamed from: z */
    private boolean f2303z = false;

    /* renamed from: a */
    public static C0706a m2986a() {
        if (f2287x == null) {
            f2287x = new C0706a();
        }
        return f2287x;
    }

    /* renamed from: b */
    public static void m2987b() {
        if (f2287x != null) {
            f2287x.m2990c();
        }
    }

    private C0706a() {
    }

    /* renamed from: c */
    public void m2990c() {
        this.f2302y = false;
        this.f2303z = false;
        this.f2299u = false;
        this.f2293n = false;
        this.f2298t = false;
    }

    /* renamed from: d */
    public boolean m2992d() {
        return this.f2288A;
    }

    /* renamed from: a */
    public void m2988a(boolean needPreloadRoute) {
        this.f2288A = needPreloadRoute;
        this.f2294o = needPreloadRoute;
    }

    /* renamed from: e */
    public boolean m2993e() {
        return this.f2302y;
    }

    /* renamed from: b */
    public void m2989b(boolean comeinWithRouteCars) {
        this.f2302y = comeinWithRouteCars;
    }

    /* renamed from: f */
    public boolean m2994f() {
        return this.f2303z;
    }

    /* renamed from: c */
    public void m2991c(boolean carResultFullviewInYellowBar) {
        this.f2303z = carResultFullviewInYellowBar;
    }
}
