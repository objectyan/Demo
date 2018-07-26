package com.baidu.tts.p233f;

/* compiled from: TtsEnum */
/* renamed from: com.baidu.tts.f.m */
public enum C5095m {
    ONLINE(0, "just online"),
    OFFLINE(1, "just offline"),
    MIX(2, "if online cannot use switch from online to offline");
    
    /* renamed from: d */
    private final int f21133d;
    /* renamed from: e */
    private final String f21134e;

    private C5095m(int i, String str) {
        this.f21133d = i;
        this.f21134e = str;
    }

    /* renamed from: a */
    public int m17281a() {
        return this.f21133d;
    }

    /* renamed from: b */
    public String m17282b() {
        return this.f21134e;
    }
}
