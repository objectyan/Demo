package com.tencent.wxop.stat.p290a;

/* renamed from: com.tencent.wxop.stat.a.f */
public enum C6124f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005);
    
    /* renamed from: j */
    private int f24784j;

    private C6124f(int i) {
        this.f24784j = i;
    }

    /* renamed from: a */
    public final int m21728a() {
        return this.f24784j;
    }
}
