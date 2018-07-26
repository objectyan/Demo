package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.k */
public final class C5996k extends C5832c<C5996k> {
    /* renamed from: b */
    public C6006r[] f24538b;

    /* renamed from: a */
    public final /* synthetic */ C6001m m21447a(C5757a c5757a) throws IOException {
        while (true) {
            int a = c5757a.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int a2 = C6007s.m21528a(c5757a, 10);
                    if (this.f24538b == null) {
                        a = 0;
                    } else {
                        a = this.f24538b.length;
                    }
                    Object obj = new C6006r[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f24538b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new C6006r();
                        c5757a.a(obj[a]);
                        c5757a.a();
                        a++;
                    }
                    obj[a] = new C6006r();
                    c5757a.a(obj[a]);
                    this.f24538b = obj;
                    continue;
                default:
                    if (!a(c5757a, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public C5996k() {
        this.f24538b = C6006r.m21522d();
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void m21448a(C5787b c5787b) throws IOException {
        if (this.f24538b != null && this.f24538b.length > 0) {
            for (C6001m c6001m : this.f24538b) {
                if (c6001m != null) {
                    c5787b.a(1, c6001m);
                }
            }
        }
        super.a(c5787b);
    }

    /* renamed from: a */
    protected final int m21446a() {
        int a = super.a();
        if (this.f24538b != null && this.f24538b.length > 0) {
            for (C6001m c6001m : this.f24538b) {
                if (c6001m != null) {
                    a += C5787b.c(1, c6001m);
                }
            }
        }
        return a;
    }
}
