package com.baidu.carlife.wechat.p108b;

/* compiled from: POI */
/* renamed from: com.baidu.carlife.wechat.b.f */
public class C2384f {
    /* renamed from: a */
    private String f7897a;
    /* renamed from: b */
    private String f7898b;
    /* renamed from: c */
    private String f7899c;

    public C2384f(String address, String latitude, String longitude) {
        this.f7897a = address;
        this.f7898b = latitude;
        this.f7899c = longitude;
    }

    public String toString() {
        return "POI[" + this.f7897a + "," + this.f7898b + "," + this.f7899c + "]";
    }

    /* renamed from: a */
    public void m9119a(String address) {
        this.f7897a = address;
    }

    /* renamed from: a */
    public String m9118a() {
        return this.f7897a;
    }

    /* renamed from: b */
    public String m9120b() {
        return this.f7898b;
    }

    /* renamed from: c */
    public String m9121c() {
        return this.f7899c;
    }
}
