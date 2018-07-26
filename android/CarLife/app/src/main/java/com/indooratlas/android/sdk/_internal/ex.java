package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ey.C5878a;
import java.io.IOException;

public interface ex {

    /* renamed from: com.indooratlas.android.sdk._internal.ex$a */
    public static final class C5877a extends C5832c<C5877a> {
        /* renamed from: b */
        public C5878a f23571b;
        /* renamed from: d */
        public float f23572d;
        /* renamed from: e */
        public float f23573e;
        /* renamed from: f */
        public C5915g f23574f;
        /* renamed from: g */
        public C5935h f23575g;
        /* renamed from: h */
        public long f23576h;
        /* renamed from: i */
        public double[] f23577i;
        /* renamed from: j */
        public float f23578j;
        /* renamed from: k */
        public float f23579k;
        /* renamed from: l */
        public C5915g f23580l;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20452a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f23571b == null) {
                            this.f23571b = new C5878a();
                        }
                        c5757a.m19766a(this.f23571b);
                        continue;
                    case 21:
                        this.f23572d = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 29:
                        this.f23573e = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 34:
                        if (this.f23574f == null) {
                            this.f23574f = new C5915g();
                        }
                        c5757a.m19766a(this.f23574f);
                        continue;
                    case 42:
                        if (this.f23575g == null) {
                            this.f23575g = new C5935h();
                        }
                        c5757a.m19766a(this.f23575g);
                        continue;
                    case 48:
                        this.f23576h = c5757a.m19776g();
                        continue;
                    case 57:
                        a2 = C6007s.a(c5757a, 57);
                        if (this.f23577i == null) {
                            a = 0;
                        } else {
                            a = this.f23577i.length;
                        }
                        Object obj = new double[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23577i, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = Double.longBitsToDouble(c5757a.m19778i());
                        this.f23577i = obj;
                        continue;
                    case 58:
                        a = c5757a.m19775f();
                        a2 = c5757a.m19769c(a);
                        int i = a / 8;
                        a = this.f23577i == null ? 0 : this.f23577i.length;
                        Object obj2 = new double[(i + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23577i, 0, obj2, 0, a);
                        }
                        while (a < obj2.length) {
                            obj2[a] = Double.longBitsToDouble(c5757a.m19778i());
                            a++;
                        }
                        this.f23577i = obj2;
                        c5757a.m19771d(a2);
                        continue;
                    case 69:
                        this.f23578j = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 77:
                        this.f23579k = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 82:
                        if (this.f23580l == null) {
                            this.f23580l = new C5915g();
                        }
                        c5757a.m19766a(this.f23580l);
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

        public C5877a() {
            this.f23571b = null;
            this.f23572d = 0.0f;
            this.f23573e = 0.0f;
            this.f23574f = null;
            this.f23575g = null;
            this.f23576h = 0;
            this.f23577i = C6007s.f24579d;
            this.f23578j = 0.0f;
            this.f23579k = 0.0f;
            this.f23580l = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23571b != null) {
                c5787b.m19964a(1, this.f23571b);
            }
            if (Float.floatToIntBits(this.f23572d) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(2, this.f23572d);
            }
            if (Float.floatToIntBits(this.f23573e) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(3, this.f23573e);
            }
            if (this.f23574f != null) {
                c5787b.m19964a(4, this.f23574f);
            }
            if (this.f23575g != null) {
                c5787b.m19964a(5, this.f23575g);
            }
            if (this.f23576h != 0) {
                c5787b.m19963a(6, this.f23576h);
            }
            if (this.f23577i != null && this.f23577i.length > 0) {
                int length = this.f23577i.length * 8;
                c5787b.m19974e(58);
                c5787b.m19974e(length);
                for (double a : this.f23577i) {
                    c5787b.m19957a(a);
                }
            }
            if (Float.floatToIntBits(this.f23578j) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(8, this.f23578j);
            }
            if (Float.floatToIntBits(this.f23579k) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(9, this.f23579k);
            }
            if (this.f23580l != null) {
                c5787b.m19964a(10, this.f23580l);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23571b != null) {
                a += C5787b.m19946c(1, this.f23571b);
            }
            if (Float.floatToIntBits(this.f23572d) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(2) + 4;
            }
            if (Float.floatToIntBits(this.f23573e) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(3) + 4;
            }
            if (this.f23574f != null) {
                a += C5787b.m19946c(4, this.f23574f);
            }
            if (this.f23575g != null) {
                a += C5787b.m19946c(5, this.f23575g);
            }
            if (this.f23576h != 0) {
                a += C5787b.m19939b(6, this.f23576h);
            }
            if (this.f23577i != null && this.f23577i.length > 0) {
                int length = this.f23577i.length * 8;
                a = ((a + length) + 1) + C5787b.m19952f(length);
            }
            if (Float.floatToIntBits(this.f23578j) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(8) + 4;
            }
            if (Float.floatToIntBits(this.f23579k) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(9) + 4;
            }
            if (this.f23580l != null) {
                return a + C5787b.m19946c(10, this.f23580l);
            }
            return a;
        }
    }
}
