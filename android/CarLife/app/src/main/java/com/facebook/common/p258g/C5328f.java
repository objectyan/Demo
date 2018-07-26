package com.facebook.common.p258g;

/* compiled from: NoOpMemoryTrimmableRegistry */
/* renamed from: com.facebook.common.g.f */
public class C5328f implements C5325c {
    /* renamed from: a */
    private static C5328f f21910a = null;

    /* renamed from: a */
    public static synchronized C5328f m18243a() {
        C5328f c5328f;
        synchronized (C5328f.class) {
            if (f21910a == null) {
                f21910a = new C5328f();
            }
            c5328f = f21910a;
        }
        return c5328f;
    }

    /* renamed from: a */
    public void mo4015a(C5324b trimmable) {
    }

    /* renamed from: b */
    public void mo4016b(C5324b trimmable) {
    }
}
