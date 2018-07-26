package com.tencent.wxop.stat;

/* renamed from: com.tencent.wxop.stat.h */
public enum C6158h {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    /* renamed from: h */
    int f25087h;

    private C6158h(int i) {
        this.f25087h = i;
    }

    /* renamed from: a */
    public static C6158h m22058a(int i) {
        for (C6158h c6158h : C6158h.values()) {
            if (i == c6158h.m22059a()) {
                return c6158h;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final int m22059a() {
        return this.f25087h;
    }
}
