package com.baidu.baidumaps.p036a;

/* compiled from: ComponentNaviHelper */
/* renamed from: com.baidu.baidumaps.a.a */
public class C0649a {
    /* renamed from: a */
    public static final int f2078a = 2909;
    /* renamed from: b */
    public static final int f2079b = 2910;
    /* renamed from: c */
    public static final int f2080c = 2934;
    /* renamed from: d */
    public static final int f2081d = 9000;
    /* renamed from: e */
    private static C0649a f2082e = new C0649a();

    private C0649a() {
    }

    /* renamed from: a */
    public static C0649a m2829a() {
        return f2082e;
    }

    /* renamed from: a */
    public boolean m2830a(double x, double y, int cityId) {
        if (cityId <= 0) {
            cityId = C0652b.m2831a((int) x, (int) y);
        }
        return cityId == f2078a || ((cityId >= f2079b && cityId <= f2080c) || cityId >= 9000);
    }
}
