package com.facebook.common.p254b;

/* compiled from: NoOpDiskTrimmableRegistry */
/* renamed from: com.facebook.common.b.c */
public class C5302c implements C5301b {
    /* renamed from: a */
    private static C5302c f21872a = null;

    private C5302c() {
    }

    /* renamed from: a */
    public static synchronized C5302c m18084a() {
        C5302c c5302c;
        synchronized (C5302c.class) {
            if (f21872a == null) {
                f21872a = new C5302c();
            }
            c5302c = f21872a;
        }
        return c5302c;
    }

    /* renamed from: a */
    public void mo3993a(C5280a trimmable) {
    }

    /* renamed from: b */
    public void mo3994b(C5280a trimmable) {
    }
}
