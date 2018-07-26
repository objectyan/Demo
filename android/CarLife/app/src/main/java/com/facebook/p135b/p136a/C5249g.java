package com.facebook.p135b.p136a;

import com.facebook.p135b.p136a.C5244a.C5243a;
import javax.annotation.Nullable;

/* compiled from: NoOpCacheErrorLogger */
/* renamed from: com.facebook.b.a.g */
public class C5249g implements C5244a {
    /* renamed from: a */
    private static C5249g f21762a = null;

    private C5249g() {
    }

    /* renamed from: a */
    public static synchronized C5249g m17841a() {
        C5249g c5249g;
        synchronized (C5249g.class) {
            if (f21762a == null) {
                f21762a = new C5249g();
            }
            c5249g = f21762a;
        }
        return c5249g;
    }

    /* renamed from: a */
    public void mo3937a(C5243a category, Class<?> cls, String message, @Nullable Throwable throwable) {
    }
}
