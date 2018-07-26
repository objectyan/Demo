package com.baidu.tts.p233f;

/* compiled from: EngineEnum */
/* renamed from: com.baidu.tts.f.f */
public enum C5088f {
    ONLINE(0, "online engine"),
    OFFLINE(1, "offline engine"),
    MIX(2, "online and offline mix engine");
    
    /* renamed from: d */
    private final int f21051d;
    /* renamed from: e */
    private final String f21052e;

    private C5088f(int i, String str) {
        this.f21051d = i;
        this.f21052e = str;
    }

    /* renamed from: a */
    public int m17271a() {
        return this.f21051d;
    }
}
