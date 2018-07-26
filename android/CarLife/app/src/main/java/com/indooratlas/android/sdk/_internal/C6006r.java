package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.r */
public final class C6006r extends C5832c<C6006r> {
    /* renamed from: e */
    private static volatile C6006r[] f24573e;
    /* renamed from: b */
    public int f24574b;
    /* renamed from: d */
    public Object f24575d;

    /* renamed from: a */
    public final /* synthetic */ C6001m m21524a(C5757a c5757a) throws IOException {
        while (true) {
            int a = c5757a.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f24575d = Integer.valueOf(c5757a.f());
                    this.f24574b = 1;
                    continue;
                case 17:
                    this.f24575d = Double.valueOf(Double.longBitsToDouble(c5757a.i()));
                    this.f24574b = 2;
                    continue;
                case 26:
                    this.f24575d = c5757a.c();
                    this.f24574b = 3;
                    continue;
                case 32:
                    this.f24575d = Boolean.valueOf(c5757a.b());
                    this.f24574b = 4;
                    continue;
                case 42:
                    if (this.f24574b != 5) {
                        this.f24575d = new C6003o();
                    }
                    c5757a.a((C6001m) this.f24575d);
                    this.f24574b = 5;
                    continue;
                case 50:
                    if (this.f24574b != 6) {
                        this.f24575d = new C5996k();
                    }
                    c5757a.a((C6001m) this.f24575d);
                    this.f24574b = 6;
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

    /* renamed from: d */
    public static C6006r[] m21522d() {
        if (f24573e == null) {
            synchronized (C5978i.f24329c) {
                if (f24573e == null) {
                    f24573e = new C6006r[0];
                }
            }
        }
        return f24573e;
    }

    public C6006r() {
        this.f24574b = 0;
        this.f24574b = 0;
        this.f24575d = null;
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void m21525a(C5787b c5787b) throws IOException {
        if (this.f24574b == 1) {
            c5787b.c(1, ((Integer) this.f24575d).intValue());
        }
        if (this.f24574b == 2) {
            c5787b.a(2, ((Double) this.f24575d).doubleValue());
        }
        if (this.f24574b == 3) {
            c5787b.a(3, (String) this.f24575d);
        }
        if (this.f24574b == 4) {
            c5787b.a(4, ((Boolean) this.f24575d).booleanValue());
        }
        if (this.f24574b == 5) {
            c5787b.a(5, (C6001m) this.f24575d);
        }
        if (this.f24574b == 6) {
            c5787b.a(6, (C6001m) this.f24575d);
        }
        super.a(c5787b);
    }

    /* renamed from: a */
    protected final int m21523a() {
        int a = super.a();
        if (this.f24574b == 1) {
            a = C5787b.f(1, ((Integer) this.f24575d).intValue()) + a;
        }
        if (this.f24574b == 2) {
            ((Double) this.f24575d).doubleValue();
            a += C5787b.d(2) + 8;
        }
        if (this.f24574b == 3) {
            a += C5787b.b(3, (String) this.f24575d);
        }
        if (this.f24574b == 4) {
            ((Boolean) this.f24575d).booleanValue();
            a += C5787b.d(4) + 1;
        }
        if (this.f24574b == 5) {
            a += C5787b.c(5, (C6001m) this.f24575d);
        }
        if (this.f24574b == 6) {
            return a + C5787b.c(6, (C6001m) this.f24575d);
        }
        return a;
    }
}
