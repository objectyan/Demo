package com.baidu.tts.p233f;

/* compiled from: TimeOutEnum */
/* renamed from: com.baidu.tts.f.l */
public enum C5094l {
    DEFAULT(6, 6000),
    FAST_SWITCH(1, 1200),
    MIX_ONLINE_REQUEST_TIMEOUT(4, 4000);
    
    /* renamed from: d */
    private final long f21127d;
    /* renamed from: e */
    private final long f21128e;

    private C5094l(long j, long j2) {
        this.f21127d = j;
        this.f21128e = j2;
    }

    /* renamed from: a */
    public long m17279a() {
        return this.f21128e;
    }

    /* renamed from: b */
    public int m17280b() {
        return (int) m17279a();
    }
}
