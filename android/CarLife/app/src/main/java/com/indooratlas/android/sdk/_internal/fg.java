package com.indooratlas.android.sdk._internal;

import com.baidu.carlife.core.C1253f;
import java.io.IOException;

public interface fg {

    /* renamed from: com.indooratlas.android.sdk._internal.fg$a */
    public static final class C5903a extends C5832c<C5903a> {
        /* renamed from: b */
        public float f23666b;

        public C5903a() {
            this.f23666b = 0.0f;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (Float.floatToIntBits(this.f23666b) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(1, this.f23666b);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (Float.floatToIntBits(this.f23666b) != Float.floatToIntBits(0.0f)) {
                return a + (C5787b.m19948d(1) + 4);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20537a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 13:
                        this.f23666b = Float.intBitsToFloat(c5757a.m19777h());
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

    /* renamed from: com.indooratlas.android.sdk._internal.fg$b */
    public static final class C5904b extends C5832c<C5904b> {
        /* renamed from: b */
        public double[] f23667b;
        /* renamed from: d */
        public double[] f23668d;
        /* renamed from: e */
        public double[] f23669e;
        /* renamed from: f */
        public double[] f23670f;
        /* renamed from: g */
        public double[] f23671g;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20540a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int i;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 9:
                        a2 = C6007s.a(c5757a, 9);
                        if (this.f23667b == null) {
                            a = 0;
                        } else {
                            a = this.f23667b.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23667b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23667b = obj;
                        continue;
                    case 10:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23667b == null ? 0 : this.f23667b.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23667b, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23667b = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 17:
                        a2 = C6007s.a(c5757a, 17);
                        if (this.f23668d == null) {
                            a = 0;
                        } else {
                            a = this.f23668d.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23668d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23668d = obj;
                        continue;
                    case 18:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23668d == null ? 0 : this.f23668d.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23668d, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23668d = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 25:
                        a2 = C6007s.a(c5757a, 25);
                        if (this.f23669e == null) {
                            a = 0;
                        } else {
                            a = this.f23669e.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23669e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23669e = obj;
                        continue;
                    case 26:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23669e == null ? 0 : this.f23669e.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23669e, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23669e = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 33:
                        a2 = C6007s.a(c5757a, 33);
                        if (this.f23670f == null) {
                            a = 0;
                        } else {
                            a = this.f23670f.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23670f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23670f = obj;
                        continue;
                    case 34:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23670f == null ? 0 : this.f23670f.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23670f, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23670f = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 41:
                        a2 = C6007s.a(c5757a, 41);
                        if (this.f23671g == null) {
                            a = 0;
                        } else {
                            a = this.f23671g.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23671g, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23671g = obj;
                        continue;
                    case 42:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23671g == null ? 0 : this.f23671g.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23671g, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23671g = obj2;
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

        public C5904b() {
            this.f23667b = C6007s.f24579d;
            this.f23668d = C6007s.f24579d;
            this.f23669e = C6007s.f24579d;
            this.f23670f = C6007s.f24579d;
            this.f23671g = C6007s.f24579d;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int length;
            int i = 0;
            if (this.f23667b != null && this.f23667b.length > 0) {
                length = this.f23667b.length * 8;
                c5787b.m19974e(10);
                c5787b.m19974e(length);
                for (double a : this.f23667b) {
                    c5787b.m19957a(a);
                }
            }
            if (this.f23668d != null && this.f23668d.length > 0) {
                length = this.f23668d.length * 8;
                c5787b.m19974e(18);
                c5787b.m19974e(length);
                for (double a2 : this.f23668d) {
                    c5787b.m19957a(a2);
                }
            }
            if (this.f23669e != null && this.f23669e.length > 0) {
                length = this.f23669e.length * 8;
                c5787b.m19974e(26);
                c5787b.m19974e(length);
                for (double a22 : this.f23669e) {
                    c5787b.m19957a(a22);
                }
            }
            if (this.f23670f != null && this.f23670f.length > 0) {
                length = this.f23670f.length * 8;
                c5787b.m19974e(34);
                c5787b.m19974e(length);
                for (double a222 : this.f23670f) {
                    c5787b.m19957a(a222);
                }
            }
            if (this.f23671g != null && this.f23671g.length > 0) {
                length = this.f23671g.length * 8;
                c5787b.m19974e(42);
                c5787b.m19974e(length);
                while (i < this.f23671g.length) {
                    c5787b.m19957a(this.f23671g[i]);
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23667b != null && this.f23667b.length > 0) {
                int length = this.f23667b.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23668d != null && this.f23668d.length > 0) {
                length = this.f23668d.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23669e != null && this.f23669e.length > 0) {
                length = this.f23669e.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23670f != null && this.f23670f.length > 0) {
                length = this.f23670f.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23671g == null || this.f23671g.length <= 0) {
                return a;
            }
            length = this.f23671g.length * 8;
            return ((a + length) + 1) + C5787b.m19952f(length);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.fg$c */
    public static final class C5905c extends C5832c<C5905c> {
        /* renamed from: b */
        public double[] f23672b;
        /* renamed from: d */
        public float f23673d;
        /* renamed from: e */
        public C5915g f23674e;
        /* renamed from: f */
        public float[] f23675f;
        /* renamed from: g */
        public float[] f23676g;
        /* renamed from: h */
        public double[] f23677h;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20543a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int i;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 9:
                        a2 = C6007s.a(c5757a, 9);
                        if (this.f23672b == null) {
                            a = 0;
                        } else {
                            a = this.f23672b.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23672b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23672b = obj;
                        continue;
                    case 10:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23672b == null ? 0 : this.f23672b.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23672b, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23672b = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 21:
                        this.f23673d = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 26:
                        if (this.f23674e == null) {
                            this.f23674e = new C5915g();
                        }
                        c5757a.m19766a(this.f23674e);
                        continue;
                    case 34:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23675f == null ? 0 : this.f23675f.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23675f, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23675f = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 37:
                        a2 = C6007s.a(c5757a, 37);
                        if (this.f23675f == null) {
                            a = 0;
                        } else {
                            a = this.f23675f.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23675f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23675f = obj;
                        continue;
                    case 42:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23676g == null ? 0 : this.f23676g.length;
                        obj2 = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23676g, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23676g = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 45:
                        a2 = C6007s.a(c5757a, 45);
                        if (this.f23676g == null) {
                            a = 0;
                        } else {
                            a = this.f23676g.length;
                        }
                        obj = new float[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23676g, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23676g = obj;
                        continue;
                    case 97:
                        a2 = C6007s.a(c5757a, 97);
                        if (this.f23677h == null) {
                            a = 0;
                        } else {
                            a = this.f23677h.length;
                        }
                        obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23677h, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23677h = obj;
                        continue;
                    case 98:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23677h == null ? 0 : this.f23677h.length;
                        obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23677h, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23677h = obj2;
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

        public C5905c() {
            this.f23672b = C6007s.f24579d;
            this.f23673d = 0.0f;
            this.f23674e = null;
            this.f23675f = C6007s.f24578c;
            this.f23676g = C6007s.f24578c;
            this.f23677h = C6007s.f24579d;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int length;
            int i = 0;
            if (this.f23672b != null && this.f23672b.length > 0) {
                length = this.f23672b.length * 8;
                c5787b.m19974e(10);
                c5787b.m19974e(length);
                for (double a : this.f23672b) {
                    c5787b.m19957a(a);
                }
            }
            if (Float.floatToIntBits(this.f23673d) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(2, this.f23673d);
            }
            if (this.f23674e != null) {
                c5787b.m19964a(3, this.f23674e);
            }
            if (this.f23675f != null && this.f23675f.length > 0) {
                length = this.f23675f.length * 4;
                c5787b.m19974e(34);
                c5787b.m19974e(length);
                for (float a2 : this.f23675f) {
                    c5787b.m19958a(a2);
                }
            }
            if (this.f23676g != null && this.f23676g.length > 0) {
                length = this.f23676g.length * 4;
                c5787b.m19974e(42);
                c5787b.m19974e(length);
                for (float a22 : this.f23676g) {
                    c5787b.m19958a(a22);
                }
            }
            if (this.f23677h != null && this.f23677h.length > 0) {
                length = this.f23677h.length * 8;
                c5787b.m19974e(98);
                c5787b.m19974e(length);
                while (i < this.f23677h.length) {
                    c5787b.m19957a(this.f23677h[i]);
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23672b != null && this.f23672b.length > 0) {
                int length = this.f23672b.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23673d) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(2) + 4;
            }
            if (this.f23674e != null) {
                a += C5787b.m19946c(3, this.f23674e);
            }
            if (this.f23675f != null && this.f23675f.length > 0) {
                length = this.f23675f.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23676g != null && this.f23676g.length > 0) {
                length = this.f23676g.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23677h == null || this.f23677h.length <= 0) {
                return a;
            }
            length = this.f23677h.length * 8;
            return ((a + length) + 1) + C5787b.m19952f(length);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.fg$d */
    public static final class C5906d extends C5832c<C5906d> {
        /* renamed from: g */
        private static volatile C5906d[] f23678g;
        /* renamed from: b */
        public long f23679b;
        /* renamed from: d */
        public double f23680d;
        /* renamed from: e */
        public double f23681e;
        /* renamed from: f */
        public double f23682f;

        /* renamed from: d */
        public static C5906d[] m20545d() {
            if (f23678g == null) {
                synchronized (C5978i.f24329c) {
                    if (f23678g == null) {
                        f23678g = new C5906d[0];
                    }
                }
            }
            return f23678g;
        }

        public C5906d() {
            this.f23679b = 0;
            this.f23680d = 0.0d;
            this.f23681e = 0.0d;
            this.f23682f = 0.0d;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23679b != 0) {
                c5787b.m19963a(1, this.f23679b);
            }
            if (Double.doubleToLongBits(this.f23680d) != Double.doubleToLongBits(0.0d)) {
                c5787b.m19960a(2, this.f23680d);
            }
            if (Double.doubleToLongBits(this.f23681e) != Double.doubleToLongBits(0.0d)) {
                c5787b.m19960a(3, this.f23681e);
            }
            if (Double.doubleToLongBits(this.f23682f) != Double.doubleToLongBits(0.0d)) {
                c5787b.m19960a(4, this.f23682f);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23679b != 0) {
                a += C5787b.m19939b(1, this.f23679b);
            }
            if (Double.doubleToLongBits(this.f23680d) != Double.doubleToLongBits(0.0d)) {
                a += C5787b.m19948d(2) + 8;
            }
            if (Double.doubleToLongBits(this.f23681e) != Double.doubleToLongBits(0.0d)) {
                a += C5787b.m19948d(3) + 8;
            }
            if (Double.doubleToLongBits(this.f23682f) != Double.doubleToLongBits(0.0d)) {
                return a + (C5787b.m19948d(4) + 8);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20547a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23679b = c5757a.m19776g();
                        continue;
                    case 17:
                        this.f23680d = Double.longBitsToDouble(c5757a.m19778i());
                        continue;
                    case 25:
                        this.f23681e = Double.longBitsToDouble(c5757a.m19778i());
                        continue;
                    case 33:
                        this.f23682f = Double.longBitsToDouble(c5757a.m19778i());
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

    /* renamed from: com.indooratlas.android.sdk._internal.fg$e */
    public static final class C5907e extends C5832c<C5907e> {
        /* renamed from: b */
        public long f23683b;
        /* renamed from: d */
        public float[] f23684d;
        /* renamed from: e */
        public float f23685e;
        /* renamed from: f */
        public float f23686f;
        /* renamed from: g */
        public double[] f23687g;
        /* renamed from: h */
        public C5904b f23688h;
        /* renamed from: i */
        public C5905c f23689i;
        /* renamed from: j */
        public float f23690j;
        /* renamed from: k */
        public float[] f23691k;
        /* renamed from: l */
        public float f23692l;
        /* renamed from: m */
        public float f23693m;
        /* renamed from: n */
        public int f23694n;
        /* renamed from: o */
        public float f23695o;
        /* renamed from: p */
        public C5903a f23696p;
        /* renamed from: q */
        public C5906d[] f23697q;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20550a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int c;
                int i;
                Object obj;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23683b = c5757a.m19776g();
                        continue;
                    case 18:
                        a = c5757a.m19775f();
                        c = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23684d == null ? 0 : this.f23684d.length;
                        obj = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23684d, 0, obj, 0, a);
                        }
                        while (a < obj.length) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23684d = obj;
                        c5757a.m19771d(c);
                        continue;
                    case 21:
                        c = C6007s.a(c5757a, 21);
                        if (this.f23684d == null) {
                            a = 0;
                        } else {
                            a = this.f23684d.length;
                        }
                        obj2 = new float[(c + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23684d, 0, obj2, 0, a);
                        }
                        while (a < obj2.length - 1) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23684d = obj2;
                        continue;
                    case 29:
                        this.f23685e = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 37:
                        this.f23686f = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 41:
                        c = C6007s.a(c5757a, 41);
                        if (this.f23687g == null) {
                            a = 0;
                        } else {
                            a = this.f23687g.length;
                        }
                        obj2 = new double[(c + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23687g, 0, obj2, 0, a);
                        }
                        while (a < obj2.length - 1) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23687g = obj2;
                        continue;
                    case 42:
                        a = c5757a.m19775f();
                        c = c5757a.m19769c(a);
                        i = a / 8;
                        a = this.f23687g == null ? 0 : this.f23687g.length;
                        obj = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23687g, 0, obj, 0, a);
                        }
                        while (a < obj.length) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23687g = obj;
                        c5757a.m19771d(c);
                        continue;
                    case 50:
                        if (this.f23688h == null) {
                            this.f23688h = new C5904b();
                        }
                        c5757a.m19766a(this.f23688h);
                        continue;
                    case 58:
                        if (this.f23689i == null) {
                            this.f23689i = new C5905c();
                        }
                        c5757a.m19766a(this.f23689i);
                        continue;
                    case 69:
                        this.f23690j = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 74:
                        a = c5757a.m19775f();
                        c = c5757a.m19769c(a);
                        i = a / 4;
                        a = this.f23691k == null ? 0 : this.f23691k.length;
                        obj = new float[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23691k, 0, obj, 0, a);
                        }
                        while (a < obj.length) {
                            obj[a] = Float.intBitsToFloat(c5757a.m19777h());
                            a++;
                        }
                        this.f23691k = obj;
                        c5757a.m19771d(c);
                        continue;
                    case 77:
                        c = C6007s.a(c5757a, 77);
                        if (this.f23691k == null) {
                            a = 0;
                        } else {
                            a = this.f23691k.length;
                        }
                        obj2 = new float[(c + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23691k, 0, obj2, 0, a);
                        }
                        while (a < obj2.length - 1) {
                            obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                            c5757a.m19764a();
                            a++;
                        }
                        obj2[a] = Float.intBitsToFloat(c5757a.m19777h());
                        this.f23691k = obj2;
                        continue;
                    case 85:
                        this.f23692l = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 93:
                        this.f23693m = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 96:
                        this.f23694n = c5757a.m19775f();
                        continue;
                    case 109:
                        this.f23695o = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 114:
                        if (this.f23696p == null) {
                            this.f23696p = new C5903a();
                        }
                        c5757a.m19766a(this.f23696p);
                        continue;
                    case C1253f.df /*122*/:
                        c = C6007s.a(c5757a, C1253f.df);
                        if (this.f23697q == null) {
                            a = 0;
                        } else {
                            a = this.f23697q.length;
                        }
                        obj2 = new C5906d[(c + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23697q, 0, obj2, 0, a);
                        }
                        while (a < obj2.length - 1) {
                            obj2[a] = new C5906d();
                            c5757a.m19766a(obj2[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj2[a] = new C5906d();
                        c5757a.m19766a(obj2[a]);
                        this.f23697q = obj2;
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

        public C5907e() {
            this.f23683b = 0;
            this.f23684d = C6007s.f24578c;
            this.f23685e = 0.0f;
            this.f23686f = 0.0f;
            this.f23687g = C6007s.f24579d;
            this.f23688h = null;
            this.f23689i = null;
            this.f23690j = 0.0f;
            this.f23691k = C6007s.f24578c;
            this.f23692l = 0.0f;
            this.f23693m = 0.0f;
            this.f23694n = 0;
            this.f23695o = 0.0f;
            this.f23696p = null;
            this.f23697q = C5906d.m20545d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i = 0;
            if (this.f23683b != 0) {
                c5787b.m19963a(1, this.f23683b);
            }
            if (this.f23684d != null && this.f23684d.length > 0) {
                int length;
                length = this.f23684d.length * 4;
                c5787b.m19974e(18);
                c5787b.m19974e(length);
                for (float a : this.f23684d) {
                    c5787b.m19958a(a);
                }
            }
            if (Float.floatToIntBits(this.f23685e) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(3, this.f23685e);
            }
            if (Float.floatToIntBits(this.f23686f) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(4, this.f23686f);
            }
            if (this.f23687g != null && this.f23687g.length > 0) {
                length = this.f23687g.length * 8;
                c5787b.m19974e(42);
                c5787b.m19974e(length);
                for (double a2 : this.f23687g) {
                    c5787b.m19957a(a2);
                }
            }
            if (this.f23688h != null) {
                c5787b.m19964a(6, this.f23688h);
            }
            if (this.f23689i != null) {
                c5787b.m19964a(7, this.f23689i);
            }
            if (Float.floatToIntBits(this.f23690j) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(8, this.f23690j);
            }
            if (this.f23691k != null && this.f23691k.length > 0) {
                length = this.f23691k.length * 4;
                c5787b.m19974e(74);
                c5787b.m19974e(length);
                for (float a3 : this.f23691k) {
                    c5787b.m19958a(a3);
                }
            }
            if (Float.floatToIntBits(this.f23692l) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(10, this.f23692l);
            }
            if (Float.floatToIntBits(this.f23693m) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(11, this.f23693m);
            }
            if (this.f23694n != 0) {
                c5787b.m19970b(12, this.f23694n);
            }
            if (Float.floatToIntBits(this.f23695o) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(13, this.f23695o);
            }
            if (this.f23696p != null) {
                c5787b.m19964a(14, this.f23696p);
            }
            if (this.f23697q != null && this.f23697q.length > 0) {
                while (i < this.f23697q.length) {
                    C6001m c6001m = this.f23697q[i];
                    if (c6001m != null) {
                        c5787b.m19964a(15, c6001m);
                    }
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23683b != 0) {
                a += C5787b.m19939b(1, this.f23683b);
            }
            if (this.f23684d != null && this.f23684d.length > 0) {
                int length = this.f23684d.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23685e) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(3) + 4;
            }
            if (Float.floatToIntBits(this.f23686f) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(4) + 4;
            }
            if (this.f23687g != null && this.f23687g.length > 0) {
                length = this.f23687g.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (this.f23688h != null) {
                a += C5787b.m19946c(6, this.f23688h);
            }
            if (this.f23689i != null) {
                a += C5787b.m19946c(7, this.f23689i);
            }
            if (Float.floatToIntBits(this.f23690j) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(8) + 4;
            }
            if (this.f23691k != null && this.f23691k.length > 0) {
                length = this.f23691k.length * 4;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23692l) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(10) + 4;
            }
            if (Float.floatToIntBits(this.f23693m) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(11) + 4;
            }
            if (this.f23694n != 0) {
                a += C5787b.m19951e(12, this.f23694n);
            }
            if (Float.floatToIntBits(this.f23695o) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(13) + 4;
            }
            if (this.f23696p != null) {
                a += C5787b.m19946c(14, this.f23696p);
            }
            if (this.f23697q == null || this.f23697q.length <= 0) {
                return a;
            }
            length = a;
            for (C6001m c6001m : this.f23697q) {
                if (c6001m != null) {
                    length += C5787b.m19946c(15, c6001m);
                }
            }
            return length;
        }
    }
}
