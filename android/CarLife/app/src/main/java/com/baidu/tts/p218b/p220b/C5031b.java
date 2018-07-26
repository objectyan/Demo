package com.baidu.tts.p218b.p220b;

import com.baidu.tts.p218b.p220b.p227b.C5026c;
import com.baidu.tts.p218b.p220b.p227b.C5030b;

/* compiled from: PlayerFactory */
/* renamed from: com.baidu.tts.b.b.b */
public class C5031b {
    /* renamed from: a */
    private static volatile C5031b f20813a = null;

    private C5031b() {
    }

    /* renamed from: a */
    public static C5031b m16996a() {
        if (f20813a == null) {
            synchronized (C5031b.class) {
                if (f20813a == null) {
                    f20813a = new C5031b();
                }
            }
        }
        return f20813a;
    }

    /* renamed from: b */
    public C5026c m16998b() {
        return m16997c();
    }

    /* renamed from: c */
    private C5030b m16997c() {
        return new C5030b();
    }
}
