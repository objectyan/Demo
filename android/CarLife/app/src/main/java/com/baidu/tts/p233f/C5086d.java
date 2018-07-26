package com.baidu.tts.p233f;

/* compiled from: CharSetEnum */
/* renamed from: com.baidu.tts.f.d */
public enum C5086d {
    GB18030("gb18030", "0"),
    BIG5("big5", "1"),
    UTF8("utf-8", "2"),
    GBK("gbk", "4"),
    UNICODE("unicode", "5");
    
    /* renamed from: f */
    private final String f21037f;
    /* renamed from: g */
    private final String f21038g;

    private C5086d(String str, String str2) {
        this.f21037f = str;
        this.f21038g = str2;
    }

    /* renamed from: a */
    public String m17269a() {
        return this.f21037f;
    }

    /* renamed from: b */
    public String m17270b() {
        return this.f21038g;
    }

    /* renamed from: a */
    public static C5086d m17268a(String str) {
        for (C5086d c5086d : C5086d.values()) {
            if (c5086d.m17270b().equals(str)) {
                return c5086d;
            }
        }
        return null;
    }
}
