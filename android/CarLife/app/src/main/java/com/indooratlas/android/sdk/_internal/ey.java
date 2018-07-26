package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface ey {

    /* renamed from: com.indooratlas.android.sdk._internal.ey$a */
    public static final class C5878a extends C5832c<C5878a> {
        /* renamed from: b */
        public double f23581b;
        /* renamed from: d */
        public double f23582d;

        public C5878a() {
            this.f23581b = 0.0d;
            this.f23582d = 0.0d;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (Double.doubleToLongBits(this.f23581b) != Double.doubleToLongBits(0.0d)) {
                c5787b.m19960a(1, this.f23581b);
            }
            if (Double.doubleToLongBits(this.f23582d) != Double.doubleToLongBits(0.0d)) {
                c5787b.m19960a(2, this.f23582d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (Double.doubleToLongBits(this.f23581b) != Double.doubleToLongBits(0.0d)) {
                a += C5787b.m19948d(1) + 8;
            }
            if (Double.doubleToLongBits(this.f23582d) != Double.doubleToLongBits(0.0d)) {
                return a + (C5787b.m19948d(2) + 8);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20455a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 9:
                        this.f23581b = Double.longBitsToDouble(c5757a.m19778i());
                        continue;
                    case 17:
                        this.f23582d = Double.longBitsToDouble(c5757a.m19778i());
                        continue;
                    default:
                        if (!m20198a(c5757a, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ey$b */
    public static final class C5879b extends C5832c<C5879b> {
        /* renamed from: m */
        private static volatile C5879b[] f23583m;
        /* renamed from: b */
        public C5878a f23584b;
        /* renamed from: d */
        public long f23585d;
        /* renamed from: e */
        public long f23586e;
        /* renamed from: f */
        public float f23587f;
        /* renamed from: g */
        public C5915g f23588g;
        /* renamed from: h */
        public C5915g f23589h;
        /* renamed from: i */
        public float f23590i;
        /* renamed from: j */
        public int f23591j;
        /* renamed from: k */
        public C5935h f23592k;
        /* renamed from: l */
        public C5935h f23593l;

        /* renamed from: d */
        public static C5879b[] m20457d() {
            if (f23583m == null) {
                synchronized (C5978i.f24329c) {
                    if (f23583m == null) {
                        f23583m = new C5879b[0];
                    }
                }
            }
            return f23583m;
        }

        public C5879b() {
            this.f23584b = null;
            this.f23585d = 0;
            this.f23586e = 0;
            this.f23587f = 0.0f;
            this.f23588g = null;
            this.f23589h = null;
            this.f23590i = 0.0f;
            this.f23591j = 0;
            this.f23592k = null;
            this.f23593l = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23584b != null) {
                c5787b.m19964a(1, this.f23584b);
            }
            if (this.f23585d != 0) {
                c5787b.m19963a(2, this.f23585d);
            }
            if (this.f23586e != 0) {
                c5787b.m19963a(3, this.f23586e);
            }
            if (Float.floatToIntBits(this.f23587f) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(4, this.f23587f);
            }
            if (this.f23588g != null) {
                c5787b.m19964a(5, this.f23588g);
            }
            if (this.f23589h != null) {
                c5787b.m19964a(6, this.f23589h);
            }
            if (Float.floatToIntBits(this.f23590i) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(7, this.f23590i);
            }
            if (this.f23591j != 0) {
                c5787b.m19962a(8, this.f23591j);
            }
            if (this.f23592k != null) {
                c5787b.m19964a(9, this.f23592k);
            }
            if (this.f23593l != null) {
                c5787b.m19964a(10, this.f23593l);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23584b != null) {
                a += C5787b.m19946c(1, this.f23584b);
            }
            if (this.f23585d != 0) {
                a += C5787b.m19939b(2, this.f23585d);
            }
            if (this.f23586e != 0) {
                a += C5787b.m19939b(3, this.f23586e);
            }
            if (Float.floatToIntBits(this.f23587f) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(4) + 4;
            }
            if (this.f23588g != null) {
                a += C5787b.m19946c(5, this.f23588g);
            }
            if (this.f23589h != null) {
                a += C5787b.m19946c(6, this.f23589h);
            }
            if (Float.floatToIntBits(this.f23590i) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(7) + 4;
            }
            if (this.f23591j != 0) {
                a += C5787b.m19949d(8, this.f23591j);
            }
            if (this.f23592k != null) {
                a += C5787b.m19946c(9, this.f23592k);
            }
            if (this.f23593l != null) {
                return a + C5787b.m19946c(10, this.f23593l);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20459a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f23584b == null) {
                            this.f23584b = new C5878a();
                        }
                        c5757a.m19766a(this.f23584b);
                        continue;
                    case 16:
                        this.f23585d = c5757a.m19776g();
                        continue;
                    case 24:
                        this.f23586e = c5757a.m19776g();
                        continue;
                    case 37:
                        this.f23587f = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 42:
                        if (this.f23588g == null) {
                            this.f23588g = new C5915g();
                        }
                        c5757a.m19766a(this.f23588g);
                        continue;
                    case 50:
                        if (this.f23589h == null) {
                            this.f23589h = new C5915g();
                        }
                        c5757a.m19766a(this.f23589h);
                        continue;
                    case 61:
                        this.f23590i = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 64:
                        a = c5757a.m19775f();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                this.f23591j = a;
                                break;
                            default:
                                continue;
                        }
                    case 74:
                        if (this.f23592k == null) {
                            this.f23592k = new C5935h();
                        }
                        c5757a.m19766a(this.f23592k);
                        continue;
                    case 82:
                        if (this.f23593l == null) {
                            this.f23593l = new C5935h();
                        }
                        c5757a.m19766a(this.f23593l);
                        continue;
                    default:
                        if (!m20198a(c5757a, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }
}
