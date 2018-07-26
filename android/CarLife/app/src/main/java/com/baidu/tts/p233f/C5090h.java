package com.baidu.tts.p233f;

/* compiled from: LanguageEnum */
/* renamed from: com.baidu.tts.f.h */
public enum C5090h {
    ZH("chinese", "ZH"),
    EN("english", "EN");
    
    /* renamed from: c */
    private final String f21108c;
    /* renamed from: d */
    private final String f21109d;

    private C5090h(String str, String str2) {
        this.f21108c = str;
        this.f21109d = str2;
    }

    /* renamed from: a */
    public String m17276a() {
        return this.f21109d;
    }

    /* renamed from: a */
    public static C5090h m17275a(String str) {
        for (C5090h c5090h : C5090h.values()) {
            if (c5090h.m17276a().equalsIgnoreCase(str)) {
                return c5090h;
            }
        }
        return null;
    }
}
