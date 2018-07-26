package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public interface eu {

    /* renamed from: com.indooratlas.android.sdk._internal.eu$a */
    public static final class C5872a extends C5832c<C5872a> {
        /* renamed from: b */
        public C5873b[] f23547b;
        /* renamed from: d */
        public int f23548d;
        /* renamed from: e */
        public boolean f23549e;
        /* renamed from: f */
        public boolean f23550f;
        /* renamed from: g */
        public C5871a[] f23551g;

        /* renamed from: com.indooratlas.android.sdk._internal.eu$a$a */
        public static final class C5871a extends C5832c<C5871a> {
            /* renamed from: e */
            private static volatile C5871a[] f23544e;
            /* renamed from: b */
            public byte[] f23545b;
            /* renamed from: d */
            public int f23546d;

            /* renamed from: d */
            public static C5871a[] m20430d() {
                if (f23544e == null) {
                    synchronized (C5978i.f24329c) {
                        if (f23544e == null) {
                            f23544e = new C5871a[0];
                        }
                    }
                }
                return f23544e;
            }

            public C5871a() {
                this.f23545b = C6007s.f24583h;
                this.f23546d = 0;
                this.a = null;
                this.c = -1;
            }

            /* renamed from: a */
            public final void mo4675a(C5787b c5787b) throws IOException {
                if (!Arrays.equals(this.f23545b, C6007s.f24583h)) {
                    c5787b.m19967a(1, this.f23545b);
                }
                if (this.f23546d != 0) {
                    c5787b.m19962a(2, this.f23546d);
                }
                super.mo4675a(c5787b);
            }

            /* renamed from: a */
            protected final int mo4674a() {
                int a = super.mo4674a();
                if (!Arrays.equals(this.f23545b, C6007s.f24583h)) {
                    a += C5787b.m19942b(1, this.f23545b);
                }
                if (this.f23546d != 0) {
                    return a + C5787b.m19949d(2, this.f23546d);
                }
                return a;
            }

            /* renamed from: a */
            public final /* synthetic */ C6001m m20432a(C5757a c5757a) throws IOException {
                while (true) {
                    int a = c5757a.m19764a();
                    switch (a) {
                        case 0:
                            break;
                        case 10:
                            this.f23545b = c5757a.m19772d();
                            continue;
                        case 16:
                            a = c5757a.m19775f();
                            switch (a) {
                                case 0:
                                case 1:
                                case 2:
                                    this.f23546d = a;
                                    break;
                                default:
                                    continue;
                            }
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

        /* renamed from: a */
        public final /* synthetic */ C6001m m20435a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a2 = C6007s.a(c5757a, 10);
                        if (this.f23547b == null) {
                            a = 0;
                        } else {
                            a = this.f23547b.length;
                        }
                        obj = new C5873b[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23547b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5873b();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5873b();
                        c5757a.m19766a(obj[a]);
                        this.f23547b = obj;
                        continue;
                    case 16:
                        this.f23548d = c5757a.m19775f();
                        continue;
                    case 24:
                        this.f23549e = c5757a.m19767b();
                        continue;
                    case 32:
                        this.f23550f = c5757a.m19767b();
                        continue;
                    case 42:
                        a2 = C6007s.a(c5757a, 42);
                        if (this.f23551g == null) {
                            a = 0;
                        } else {
                            a = this.f23551g.length;
                        }
                        obj = new C5871a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23551g, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5871a();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5871a();
                        c5757a.m19766a(obj[a]);
                        this.f23551g = obj;
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

        public C5872a() {
            this.f23547b = C5873b.m20437d();
            this.f23548d = 0;
            this.f23549e = false;
            this.f23550f = false;
            this.f23551g = C5871a.m20430d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i = 0;
            if (this.f23547b != null && this.f23547b.length > 0) {
                for (C6001m c6001m : this.f23547b) {
                    if (c6001m != null) {
                        c5787b.m19964a(1, c6001m);
                    }
                }
            }
            if (this.f23548d != 0) {
                c5787b.m19970b(2, this.f23548d);
            }
            if (this.f23549e) {
                c5787b.m19966a(3, this.f23549e);
            }
            if (this.f23550f) {
                c5787b.m19966a(4, this.f23550f);
            }
            if (this.f23551g != null && this.f23551g.length > 0) {
                while (i < this.f23551g.length) {
                    C6001m c6001m2 = this.f23551g[i];
                    if (c6001m2 != null) {
                        c5787b.m19964a(5, c6001m2);
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
            if (this.f23547b != null && this.f23547b.length > 0) {
                int i2 = a;
                for (C6001m c6001m : this.f23547b) {
                    if (c6001m != null) {
                        i2 += C5787b.m19946c(1, c6001m);
                    }
                }
                a = i2;
            }
            if (this.f23548d != 0) {
                a += C5787b.m19951e(2, this.f23548d);
            }
            if (this.f23549e) {
                a += C5787b.m19948d(3) + 1;
            }
            if (this.f23550f) {
                a += C5787b.m19948d(4) + 1;
            }
            if (this.f23551g != null && this.f23551g.length > 0) {
                while (i < this.f23551g.length) {
                    C6001m c6001m2 = this.f23551g[i];
                    if (c6001m2 != null) {
                        a += C5787b.m19946c(5, c6001m2);
                    }
                    i++;
                }
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.eu$b */
    public static final class C5873b extends C5832c<C5873b> {
        /* renamed from: d */
        private static volatile C5873b[] f23552d;
        /* renamed from: b */
        public String f23553b;

        /* renamed from: d */
        public static C5873b[] m20437d() {
            if (f23552d == null) {
                synchronized (C5978i.f24329c) {
                    if (f23552d == null) {
                        f23552d = new C5873b[0];
                    }
                }
            }
            return f23552d;
        }

        public C5873b() {
            this.f23553b = "";
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (!this.f23553b.equals("")) {
                c5787b.m19965a(1, this.f23553b);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23553b.equals("")) {
                return a;
            }
            return a + C5787b.m19941b(1, this.f23553b);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20439a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f23553b = c5757a.m19770c();
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

    /* renamed from: com.indooratlas.android.sdk._internal.eu$c */
    public static final class C5874c extends C5832c<C5874c> {
        /* renamed from: b */
        public C5872a f23554b;

        public C5874c() {
            this.f23554b = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23554b != null) {
                c5787b.m19964a(1, this.f23554b);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23554b != null) {
                return a + C5787b.m19946c(1, this.f23554b);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20442a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f23554b == null) {
                            this.f23554b = new C5872a();
                        }
                        c5757a.m19766a(this.f23554b);
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
