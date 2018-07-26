package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface ev {

    /* renamed from: com.indooratlas.android.sdk._internal.ev$a */
    public static final class C5875a extends C5832c<C5875a> {
        /* renamed from: o */
        private static volatile C5875a[] f23555o;
        /* renamed from: b */
        public long f23556b;
        /* renamed from: d */
        public double[] f23557d;
        /* renamed from: e */
        public float f23558e;
        /* renamed from: f */
        public float[] f23559f;
        /* renamed from: g */
        public float[] f23560g;
        /* renamed from: h */
        public boolean f23561h;
        /* renamed from: i */
        public double[] f23562i;
        /* renamed from: j */
        public float f23563j;
        /* renamed from: k */
        public float[] f23564k;
        /* renamed from: l */
        public float[] f23565l;
        /* renamed from: m */
        public long f23566m;
        /* renamed from: n */
        public double[] f23567n;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20446a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int i;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23556b = c5757a.m19776g();
                        continue;
                    case 17:
                        a2 = C6007s.a(c5757a, 17);
                        if (this.f23557d == null) {
                            a = 0;
                        } else {
                            a = this.f23557d.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23557d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23557d = obj;
                        continue;
                    case 18:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23557d == null ? 0 : this.f23557d.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23557d, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23557d = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 29:
                        this.f23558e = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 34:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23559f == null ? 0 : this.f23559f.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23559f, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23559f = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 37:
                        a2 = C6007s.a(c5757a, 37);
                        if (this.f23559f == null) {
                            a = 0;
                        } else {
                            a = this.f23559f.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23559f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23559f = obj;
                        continue;
                    case 42:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23560g == null ? 0 : this.f23560g.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23560g, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23560g = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 45:
                        a2 = C6007s.a(c5757a, 45);
                        if (this.f23560g == null) {
                            a = 0;
                        } else {
                            a = this.f23560g.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23560g, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23560g = obj;
                        continue;
                    case 48:
                        this.f23561h = c5757a.m19767b();
                        continue;
                    case 57:
                        a2 = C6007s.a(c5757a, 57);
                        if (this.f23562i == null) {
                            a = 0;
                        } else {
                            a = this.f23562i.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23562i, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23562i = obj;
                        continue;
                    case 58:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23562i == null ? 0 : this.f23562i.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23562i, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23562i = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 69:
                        this.f23563j = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 74:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23564k == null ? 0 : this.f23564k.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23564k, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23564k = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 77:
                        a2 = C6007s.a(c5757a, 77);
                        if (this.f23564k == null) {
                            a = 0;
                        } else {
                            a = this.f23564k.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23564k, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23564k = obj;
                        continue;
                    case 82:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23565l == null ? 0 : this.f23565l.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23565l, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23565l = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 85:
                        a2 = C6007s.a(c5757a, 85);
                        if (this.f23565l == null) {
                            a = 0;
                        } else {
                            a = this.f23565l.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23565l, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23565l = obj;
                        continue;
                    case 88:
                        this.f23566m = c5757a.m19776g();
                        continue;
                    case 97:
                        a2 = C6007s.a(c5757a, 97);
                        if (this.f23567n == null) {
                            a = 0;
                        } else {
                            a = this.f23567n.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23567n, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23567n = obj;
                        continue;
                    case 98:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23567n == null ? 0 : this.f23567n.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23567n, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23567n = obj2;
                        c5757a.m19771d(a2);
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

        /* renamed from: d */
        public static C5875a[] m20444d() {
            if (f23555o == null) {
                synchronized (C5978i.f24329c) {
                    if (f23555o == null) {
                        f23555o = new C5875a[0];
                    }
                }
            }
            return f23555o;
        }

        public C5875a() {
            this.f23556b = 0;
            this.f23557d = C6007s.f24579d;
            this.f23558e = 0.0f;
            this.f23559f = C6007s.f24578c;
            this.f23560g = C6007s.f24578c;
            this.f23561h = false;
            this.f23562i = C6007s.f24579d;
            this.f23563j = 0.0f;
            this.f23564k = C6007s.f24578c;
            this.f23565l = C6007s.f24578c;
            this.f23566m = 0;
            this.f23567n = C6007s.f24579d;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int length;
            int i = 0;
            if (this.f23556b != 0) {
                c5787b.m19963a(1, this.f23556b);
            }
            if (this.f23557d != null && this.f23557d.length > 0) {
                length = this.f23557d.length * 8;
                c5787b.m19974e(18);
                c5787b.m19974e(length);
                for (double a : this.f23557d) {
                    c5787b.m19957a(a);
                }
            }
            if (Float.floatToIntBits(this.f23558e) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(3, this.f23558e);
            }
            if (this.f23559f != null && this.f23559f.length > 0) {
                length = this.f23559f.length * 4;
                c5787b.m19974e(34);
                c5787b.m19974e(length);
                for (float a2 : this.f23559f) {
                    c5787b.m19958a(a2);
                }
            }
            if (this.f23560g != null && this.f23560g.length > 0) {
                length = this.f23560g.length * 4;
                c5787b.m19974e(42);
                c5787b.m19974e(length);
                for (float a22 : this.f23560g) {
                    c5787b.m19958a(a22);
                }
            }
            if (this.f23561h) {
                c5787b.m19966a(6, this.f23561h);
            }
            if (this.f23562i != null && this.f23562i.length > 0) {
                length = this.f23562i.length * 8;
                c5787b.m19974e(58);
                c5787b.m19974e(length);
                for (double a3 : this.f23562i) {
                    c5787b.m19957a(a3);
                }
            }
            if (Float.floatToIntBits(this.f23563j) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(8, this.f23563j);
            }
            if (this.f23564k != null && this.f23564k.length > 0) {
                length = this.f23564k.length * 4;
                c5787b.m19974e(74);
                c5787b.m19974e(length);
                for (float a222 : this.f23564k) {
                    c5787b.m19958a(a222);
                }
            }
            if (this.f23565l != null && this.f23565l.length > 0) {
                length = this.f23565l.length * 4;
                c5787b.m19974e(82);
                c5787b.m19974e(length);
                for (float a2222 : this.f23565l) {
                    c5787b.m19958a(a2222);
                }
            }
            if (this.f23566m != 0) {
                c5787b.m19963a(11, this.f23566m);
            }
            if (this.f23567n != null && this.f23567n.length > 0) {
                length = this.f23567n.length * 8;
                c5787b.m19974e(98);
                c5787b.m19974e(length);
                while (i < this.f23567n.length) {
                    c5787b.m19957a(this.f23567n[i]);
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23556b != 0) {
                a += C5787b.m19939b(1, this.f23556b);
            }
            if (this.f23557d != null && this.f23557d.length > 0) {
                int length = this.f23557d.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23558e) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(3) + 4;
            }
            if (this.f23559f != null && this.f23559f.length > 0) {
                length = this.f23559f.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23560g != null && this.f23560g.length > 0) {
                length = this.f23560g.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23561h) {
                a += C5787b.m19948d(6) + 1;
            }
            if (this.f23562i != null && this.f23562i.length > 0) {
                length = this.f23562i.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23563j) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(8) + 4;
            }
            if (this.f23564k != null && this.f23564k.length > 0) {
                length = this.f23564k.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23565l != null && this.f23565l.length > 0) {
                length = this.f23565l.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23566m != 0) {
                a += C5787b.m19939b(11, this.f23566m);
            }
            if (this.f23567n == null || this.f23567n.length <= 0) {
                return a;
            }
            length = this.f23567n.length * 8;
            return ((a + length) + 1) + C5787b.m19952f(length);
        }
    }
}
