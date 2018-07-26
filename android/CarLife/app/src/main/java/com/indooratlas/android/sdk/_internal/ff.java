package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public interface ff {

    /* renamed from: com.indooratlas.android.sdk._internal.ff$a */
    public static final class C5895a extends C5832c<C5895a> {
        /* renamed from: e */
        private static volatile C5895a[] f23636e;
        /* renamed from: b */
        public byte[] f23637b;
        /* renamed from: d */
        public C5896b[] f23638d;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20509a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f23637b = c5757a.m19772d();
                        continue;
                    case 18:
                        int a2 = C6007s.a(c5757a, 18);
                        if (this.f23638d == null) {
                            a = 0;
                        } else {
                            a = this.f23638d.length;
                        }
                        Object obj = new C5896b[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23638d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5896b();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5896b();
                        c5757a.m19766a(obj[a]);
                        this.f23638d = obj;
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
        public static C5895a[] m20507d() {
            if (f23636e == null) {
                synchronized (C5978i.f24329c) {
                    if (f23636e == null) {
                        f23636e = new C5895a[0];
                    }
                }
            }
            return f23636e;
        }

        public C5895a() {
            this.f23637b = C6007s.f24583h;
            this.f23638d = C5896b.m20511d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (!Arrays.equals(this.f23637b, C6007s.f24583h)) {
                c5787b.m19967a(1, this.f23637b);
            }
            if (this.f23638d != null && this.f23638d.length > 0) {
                for (C6001m c6001m : this.f23638d) {
                    if (c6001m != null) {
                        c5787b.m19964a(2, c6001m);
                    }
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (!Arrays.equals(this.f23637b, C6007s.f24583h)) {
                a += C5787b.m19942b(1, this.f23637b);
            }
            if (this.f23638d == null || this.f23638d.length <= 0) {
                return a;
            }
            int i = a;
            for (C6001m c6001m : this.f23638d) {
                if (c6001m != null) {
                    i += C5787b.m19946c(2, c6001m);
                }
            }
            return i;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$b */
    public static final class C5896b extends C5832c<C5896b> {
        /* renamed from: g */
        private static volatile C5896b[] f23639g;
        /* renamed from: b */
        public byte[] f23640b;
        /* renamed from: d */
        public int[] f23641d;
        /* renamed from: e */
        public int[] f23642e;
        /* renamed from: f */
        public long f23643f;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20513a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f23640b = c5757a.m19772d();
                        continue;
                    case 16:
                        a2 = C6007s.a(c5757a, 16);
                        a = this.f23641d == null ? 0 : this.f23641d.length;
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23641d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19773e();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19773e();
                        this.f23641d = obj;
                        continue;
                    case 18:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19773e();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23641d == null ? 0 : this.f23641d.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23641d, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19773e();
                            a2++;
                        }
                        this.f23641d = obj2;
                        c5757a.m19771d(c);
                        continue;
                    case 24:
                        a2 = C6007s.a(c5757a, 24);
                        if (this.f23642e == null) {
                            a = 0;
                        } else {
                            a = this.f23642e.length;
                        }
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23642e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19775f();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19775f();
                        this.f23642e = obj;
                        continue;
                    case 26:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19775f();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23642e == null ? 0 : this.f23642e.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23642e, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19775f();
                            a2++;
                        }
                        this.f23642e = obj2;
                        c5757a.m19771d(c);
                        continue;
                    case 32:
                        this.f23643f = c5757a.m19776g();
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
        public static C5896b[] m20511d() {
            if (f23639g == null) {
                synchronized (C5978i.f24329c) {
                    if (f23639g == null) {
                        f23639g = new C5896b[0];
                    }
                }
            }
            return f23639g;
        }

        public C5896b() {
            this.f23640b = C6007s.f24583h;
            this.f23641d = C6007s.f24576a;
            this.f23642e = C6007s.f24576a;
            this.f23643f = 0;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i;
            int i2 = 0;
            if (!Arrays.equals(this.f23640b, C6007s.f24583h)) {
                c5787b.m19967a(1, this.f23640b);
            }
            if (this.f23641d != null && this.f23641d.length > 0) {
                i = 0;
                for (int g : this.f23641d) {
                    i += C5787b.m19952f(C5787b.m19954g(g));
                }
                c5787b.m19974e(18);
                c5787b.m19974e(i);
                for (int i3 : this.f23641d) {
                    c5787b.m19969b(i3);
                }
            }
            if (this.f23642e != null && this.f23642e.length > 0) {
                i3 = 0;
                for (int g2 : this.f23642e) {
                    i3 += C5787b.m19945c(g2);
                }
                c5787b.m19974e(26);
                c5787b.m19974e(i3);
                while (i2 < this.f23642e.length) {
                    c5787b.m19959a(this.f23642e[i2]);
                    i2++;
                }
            }
            if (this.f23643f != 0) {
                c5787b.m19963a(4, this.f23643f);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i;
            int i2 = 0;
            int a = super.mo4674a();
            if (!Arrays.equals(this.f23640b, C6007s.f24583h)) {
                a += C5787b.m19942b(1, this.f23640b);
            }
            if (this.f23641d != null && this.f23641d.length > 0) {
                int i3 = 0;
                for (int g : this.f23641d) {
                    i3 += C5787b.m19952f(C5787b.m19954g(g));
                }
                a = ((a + i3) + 1) + C5787b.m19952f(i3);
            }
            if (this.f23642e != null && this.f23642e.length > 0) {
                i = 0;
                while (i2 < this.f23642e.length) {
                    i += C5787b.m19945c(this.f23642e[i2]);
                    i2++;
                }
                a = ((a + i) + 1) + C5787b.m19952f(i);
            }
            if (this.f23643f != 0) {
                return a + C5787b.m19939b(4, this.f23643f);
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$c */
    public static final class C5897c extends C5832c<C5897c> {
        /* renamed from: b */
        public C5899e[] f23644b;
        /* renamed from: d */
        public C5895a[] f23645d;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20516a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 26:
                        a2 = C6007s.a(c5757a, 26);
                        if (this.f23644b == null) {
                            a = 0;
                        } else {
                            a = this.f23644b.length;
                        }
                        obj = new C5899e[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23644b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5899e();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5899e();
                        c5757a.m19766a(obj[a]);
                        this.f23644b = obj;
                        continue;
                    case 34:
                        a2 = C6007s.a(c5757a, 34);
                        if (this.f23645d == null) {
                            a = 0;
                        } else {
                            a = this.f23645d.length;
                        }
                        obj = new C5895a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23645d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5895a();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5895a();
                        c5757a.m19766a(obj[a]);
                        this.f23645d = obj;
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

        public C5897c() {
            this.f23644b = C5899e.m20522d();
            this.f23645d = C5895a.m20507d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i = 0;
            if (this.f23644b != null && this.f23644b.length > 0) {
                for (C6001m c6001m : this.f23644b) {
                    if (c6001m != null) {
                        c5787b.m19964a(3, c6001m);
                    }
                }
            }
            if (this.f23645d != null && this.f23645d.length > 0) {
                while (i < this.f23645d.length) {
                    C6001m c6001m2 = this.f23645d[i];
                    if (c6001m2 != null) {
                        c5787b.m19964a(4, c6001m2);
                    }
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i = 0;
            int a = super.mo4674a();
            if (this.f23644b != null && this.f23644b.length > 0) {
                int i2 = a;
                for (C6001m c6001m : this.f23644b) {
                    if (c6001m != null) {
                        i2 += C5787b.m19946c(3, c6001m);
                    }
                }
                a = i2;
            }
            if (this.f23645d != null && this.f23645d.length > 0) {
                while (i < this.f23645d.length) {
                    C6001m c6001m2 = this.f23645d[i];
                    if (c6001m2 != null) {
                        a += C5787b.m19946c(4, c6001m2);
                    }
                    i++;
                }
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$d */
    public static final class C5898d extends C5832c<C5898d> {
        /* renamed from: i */
        private static volatile C5898d[] f23646i;
        /* renamed from: b */
        public int f23647b;
        /* renamed from: d */
        public int f23648d;
        /* renamed from: e */
        public int f23649e;
        /* renamed from: f */
        public int[] f23650f;
        /* renamed from: g */
        public int[] f23651g;
        /* renamed from: h */
        public long f23652h;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20520a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 16:
                        this.f23647b = c5757a.m19775f();
                        continue;
                    case 24:
                        this.f23648d = c5757a.m19775f();
                        continue;
                    case 32:
                        this.f23649e = c5757a.m19775f();
                        continue;
                    case 40:
                        a2 = C6007s.a(c5757a, 40);
                        a = this.f23650f == null ? 0 : this.f23650f.length;
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23650f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19773e();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19773e();
                        this.f23650f = obj;
                        continue;
                    case 42:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19773e();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23650f == null ? 0 : this.f23650f.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23650f, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19773e();
                            a2++;
                        }
                        this.f23650f = obj2;
                        c5757a.m19771d(c);
                        continue;
                    case 48:
                        a2 = C6007s.a(c5757a, 48);
                        if (this.f23651g == null) {
                            a = 0;
                        } else {
                            a = this.f23651g.length;
                        }
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23651g, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19775f();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19775f();
                        this.f23651g = obj;
                        continue;
                    case 50:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19775f();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23651g == null ? 0 : this.f23651g.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23651g, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19775f();
                            a2++;
                        }
                        this.f23651g = obj2;
                        c5757a.m19771d(c);
                        continue;
                    case 56:
                        this.f23652h = c5757a.m19776g();
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
        public static C5898d[] m20518d() {
            if (f23646i == null) {
                synchronized (C5978i.f24329c) {
                    if (f23646i == null) {
                        f23646i = new C5898d[0];
                    }
                }
            }
            return f23646i;
        }

        public C5898d() {
            this.f23647b = 0;
            this.f23648d = 0;
            this.f23649e = 0;
            this.f23650f = C6007s.f24576a;
            this.f23651g = C6007s.f24576a;
            this.f23652h = 0;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i;
            int i2 = 0;
            if (this.f23647b != 0) {
                c5787b.m19970b(2, this.f23647b);
            }
            if (this.f23648d != 0) {
                c5787b.m19970b(3, this.f23648d);
            }
            if (this.f23649e != 0) {
                c5787b.m19962a(4, this.f23649e);
            }
            if (this.f23650f != null && this.f23650f.length > 0) {
                i = 0;
                for (int g : this.f23650f) {
                    i += C5787b.m19952f(C5787b.m19954g(g));
                }
                c5787b.m19974e(42);
                c5787b.m19974e(i);
                for (int i3 : this.f23650f) {
                    c5787b.m19969b(i3);
                }
            }
            if (this.f23651g != null && this.f23651g.length > 0) {
                i3 = 0;
                for (int g2 : this.f23651g) {
                    i3 += C5787b.m19945c(g2);
                }
                c5787b.m19974e(50);
                c5787b.m19974e(i3);
                while (i2 < this.f23651g.length) {
                    c5787b.m19959a(this.f23651g[i2]);
                    i2++;
                }
            }
            if (this.f23652h != 0) {
                c5787b.m19963a(7, this.f23652h);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i;
            int i2 = 0;
            int a = super.mo4674a();
            if (this.f23647b != 0) {
                a += C5787b.m19951e(2, this.f23647b);
            }
            if (this.f23648d != 0) {
                a += C5787b.m19951e(3, this.f23648d);
            }
            if (this.f23649e != 0) {
                a += C5787b.m19949d(4, this.f23649e);
            }
            if (this.f23650f != null && this.f23650f.length > 0) {
                int i3 = 0;
                for (int g : this.f23650f) {
                    i3 += C5787b.m19952f(C5787b.m19954g(g));
                }
                a = ((a + i3) + 1) + C5787b.m19952f(i3);
            }
            if (this.f23651g != null && this.f23651g.length > 0) {
                i = 0;
                while (i2 < this.f23651g.length) {
                    i += C5787b.m19945c(this.f23651g[i2]);
                    i2++;
                }
                a = ((a + i) + 1) + C5787b.m19952f(i);
            }
            if (this.f23652h != 0) {
                return a + C5787b.m19939b(7, this.f23652h);
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$e */
    public static final class C5899e extends C5832c<C5899e> {
        /* renamed from: e */
        private static volatile C5899e[] f23653e;
        /* renamed from: b */
        public String f23654b;
        /* renamed from: d */
        public C5898d[] f23655d;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20524a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f23654b = c5757a.m19770c();
                        continue;
                    case 18:
                        int a2 = C6007s.a(c5757a, 18);
                        if (this.f23655d == null) {
                            a = 0;
                        } else {
                            a = this.f23655d.length;
                        }
                        Object obj = new C5898d[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23655d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5898d();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5898d();
                        c5757a.m19766a(obj[a]);
                        this.f23655d = obj;
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
        public static C5899e[] m20522d() {
            if (f23653e == null) {
                synchronized (C5978i.f24329c) {
                    if (f23653e == null) {
                        f23653e = new C5899e[0];
                    }
                }
            }
            return f23653e;
        }

        public C5899e() {
            this.f23654b = "";
            this.f23655d = C5898d.m20518d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (!this.f23654b.equals("")) {
                c5787b.m19965a(1, this.f23654b);
            }
            if (this.f23655d != null && this.f23655d.length > 0) {
                for (C6001m c6001m : this.f23655d) {
                    if (c6001m != null) {
                        c5787b.m19964a(2, c6001m);
                    }
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (!this.f23654b.equals("")) {
                a += C5787b.m19941b(1, this.f23654b);
            }
            if (this.f23655d == null || this.f23655d.length <= 0) {
                return a;
            }
            int i = a;
            for (C6001m c6001m : this.f23655d) {
                if (c6001m != null) {
                    i += C5787b.m19946c(2, c6001m);
                }
            }
            return i;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$f */
    public static final class C5900f extends C5832c<C5900f> {
        /* renamed from: f */
        private static volatile C5900f[] f23656f;
        /* renamed from: b */
        public long f23657b;
        /* renamed from: d */
        public int[] f23658d;
        /* renamed from: e */
        public int[] f23659e;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20528a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23657b = c5757a.m19776g();
                        continue;
                    case 16:
                        a2 = C6007s.a(c5757a, 16);
                        a = this.f23658d == null ? 0 : this.f23658d.length;
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23658d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19773e();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19773e();
                        this.f23658d = obj;
                        continue;
                    case 18:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19773e();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23658d == null ? 0 : this.f23658d.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23658d, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19773e();
                            a2++;
                        }
                        this.f23658d = obj2;
                        c5757a.m19771d(c);
                        continue;
                    case 24:
                        a2 = C6007s.a(c5757a, 24);
                        if (this.f23659e == null) {
                            a = 0;
                        } else {
                            a = this.f23659e.length;
                        }
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23659e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19775f();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19775f();
                        this.f23659e = obj;
                        continue;
                    case 26:
                        c = c5757a.m19769c(c5757a.m19775f());
                        a2 = c5757a.m19780k();
                        a = 0;
                        while (c5757a.m19779j() > 0) {
                            c5757a.m19775f();
                            a++;
                        }
                        c5757a.m19774e(a2);
                        a2 = this.f23659e == null ? 0 : this.f23659e.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f23659e, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = c5757a.m19775f();
                            a2++;
                        }
                        this.f23659e = obj2;
                        c5757a.m19771d(c);
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
        public static C5900f[] m20526d() {
            if (f23656f == null) {
                synchronized (C5978i.f24329c) {
                    if (f23656f == null) {
                        f23656f = new C5900f[0];
                    }
                }
            }
            return f23656f;
        }

        public C5900f() {
            this.f23657b = 0;
            this.f23658d = C6007s.f24576a;
            this.f23659e = C6007s.f24576a;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i;
            int i2 = 0;
            if (this.f23657b != 0) {
                c5787b.m19963a(1, this.f23657b);
            }
            if (this.f23658d != null && this.f23658d.length > 0) {
                i = 0;
                for (int g : this.f23658d) {
                    i += C5787b.m19952f(C5787b.m19954g(g));
                }
                c5787b.m19974e(18);
                c5787b.m19974e(i);
                for (int i3 : this.f23658d) {
                    c5787b.m19969b(i3);
                }
            }
            if (this.f23659e != null && this.f23659e.length > 0) {
                i3 = 0;
                for (int g2 : this.f23659e) {
                    i3 += C5787b.m19945c(g2);
                }
                c5787b.m19974e(26);
                c5787b.m19974e(i3);
                while (i2 < this.f23659e.length) {
                    c5787b.m19959a(this.f23659e[i2]);
                    i2++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i;
            int i2 = 0;
            int a = super.mo4674a();
            if (this.f23657b != 0) {
                a += C5787b.m19939b(1, this.f23657b);
            }
            if (this.f23658d != null && this.f23658d.length > 0) {
                int i3 = 0;
                for (int g : this.f23658d) {
                    i3 += C5787b.m19952f(C5787b.m19954g(g));
                }
                a = ((a + i3) + 1) + C5787b.m19952f(i3);
            }
            if (this.f23659e == null || this.f23659e.length <= 0) {
                return a;
            }
            i = 0;
            while (i2 < this.f23659e.length) {
                i += C5787b.m19945c(this.f23659e[i2]);
                i2++;
            }
            return ((a + i) + 1) + C5787b.m19952f(i);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$g */
    public static final class C5901g extends C5832c<C5901g> {
        /* renamed from: b */
        public C5900f[] f23660b;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20531a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int a2 = C6007s.a(c5757a, 10);
                        if (this.f23660b == null) {
                            a = 0;
                        } else {
                            a = this.f23660b.length;
                        }
                        Object obj = new C5900f[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23660b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5900f();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5900f();
                        c5757a.m19766a(obj[a]);
                        this.f23660b = obj;
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

        public C5901g() {
            this.f23660b = C5900f.m20526d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23660b != null && this.f23660b.length > 0) {
                for (C6001m c6001m : this.f23660b) {
                    if (c6001m != null) {
                        c5787b.m19964a(1, c6001m);
                    }
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23660b != null && this.f23660b.length > 0) {
                for (C6001m c6001m : this.f23660b) {
                    if (c6001m != null) {
                        a += C5787b.m19946c(1, c6001m);
                    }
                }
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.ff$h */
    public static final class C5902h extends C5832c<C5902h> {
        /* renamed from: b */
        public long f23661b;
        /* renamed from: d */
        public C5901g f23662d;
        /* renamed from: e */
        public C5901g f23663e;
        /* renamed from: f */
        public C6004p f23664f;
        /* renamed from: g */
        public C5897c f23665g;

        public C5902h() {
            this.f23661b = 0;
            this.f23662d = null;
            this.f23663e = null;
            this.f23664f = null;
            this.f23665g = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23661b != 0) {
                c5787b.m19963a(1, this.f23661b);
            }
            if (this.f23662d != null) {
                c5787b.m19964a(2, this.f23662d);
            }
            if (this.f23663e != null) {
                c5787b.m19964a(3, this.f23663e);
            }
            if (this.f23664f != null) {
                c5787b.m19964a(4, this.f23664f);
            }
            if (this.f23665g != null) {
                c5787b.m19964a(5, this.f23665g);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23661b != 0) {
                a += C5787b.m19939b(1, this.f23661b);
            }
            if (this.f23662d != null) {
                a += C5787b.m19946c(2, this.f23662d);
            }
            if (this.f23663e != null) {
                a += C5787b.m19946c(3, this.f23663e);
            }
            if (this.f23664f != null) {
                a += C5787b.m19946c(4, this.f23664f);
            }
            if (this.f23665g != null) {
                return a + C5787b.m19946c(5, this.f23665g);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20534a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23661b = c5757a.m19776g();
                        continue;
                    case 18:
                        if (this.f23662d == null) {
                            this.f23662d = new C5901g();
                        }
                        c5757a.m19766a(this.f23662d);
                        continue;
                    case 26:
                        if (this.f23663e == null) {
                            this.f23663e = new C5901g();
                        }
                        c5757a.m19766a(this.f23663e);
                        continue;
                    case 34:
                        if (this.f23664f == null) {
                            this.f23664f = new C6004p();
                        }
                        c5757a.m19766a(this.f23664f);
                        continue;
                    case 42:
                        if (this.f23665g == null) {
                            this.f23665g = new C5897c();
                        }
                        c5757a.m19766a(this.f23665g);
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
