package com.baidu.carlife.wechat.p108b;

/* compiled from: Music */
/* renamed from: com.baidu.carlife.wechat.b.e */
public class C2383e {
    /* renamed from: a */
    private String f7894a;
    /* renamed from: b */
    private String f7895b;
    /* renamed from: c */
    private String f7896c;

    public C2383e(String title, String singer, String url) {
        this.f7894a = title;
        this.f7895b = singer;
        this.f7896c = url.replaceAll("amp;", "");
    }

    public String toString() {
        return "Music[" + this.f7894a + "," + this.f7895b + "," + this.f7896c + "]";
    }

    /* renamed from: a */
    public String m9115a() {
        return this.f7894a;
    }

    /* renamed from: b */
    public String m9116b() {
        return this.f7895b;
    }

    /* renamed from: c */
    public String m9117c() {
        return this.f7896c;
    }
}
