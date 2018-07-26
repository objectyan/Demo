package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ev.C5875a;
import com.indooratlas.android.sdk._internal.ew.C5876a;
import com.indooratlas.android.sdk._internal.ey.C5879b;
import com.indooratlas.android.sdk._internal.ff.C5902h;
import java.io.IOException;
import java.util.Arrays;

public interface fb {

    /* renamed from: com.indooratlas.android.sdk._internal.fb$a */
    public static final class C5883a extends C5832c<C5883a> {
        /* renamed from: e */
        private static volatile C5883a[] f23603e;
        /* renamed from: b */
        public long f23604b;
        /* renamed from: d */
        public byte[] f23605d;

        /* renamed from: d */
        public static C5883a[] m20471d() {
            if (f23603e == null) {
                synchronized (C5978i.f24329c) {
                    if (f23603e == null) {
                        f23603e = new C5883a[0];
                    }
                }
            }
            return f23603e;
        }

        public C5883a() {
            this.f23604b = 0;
            this.f23605d = C6007s.f24583h;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23604b != 0) {
                c5787b.m19963a(1, this.f23604b);
            }
            if (!Arrays.equals(this.f23605d, C6007s.f24583h)) {
                c5787b.m19967a(2, this.f23605d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23604b != 0) {
                a += C5787b.m19939b(1, this.f23604b);
            }
            if (Arrays.equals(this.f23605d, C6007s.f24583h)) {
                return a;
            }
            return a + C5787b.m19942b(2, this.f23605d);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20473a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23604b = c5757a.m19776g();
                        continue;
                    case 18:
                        this.f23605d = c5757a.m19772d();
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

    /* renamed from: com.indooratlas.android.sdk._internal.fb$b */
    public static final class C5884b extends C5832c<C5884b> {
        /* renamed from: b */
        public C5879b[] f23606b;
        /* renamed from: d */
        public C5876a f23607d;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20476a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 18:
                        int a2 = C6007s.a(c5757a, 18);
                        if (this.f23606b == null) {
                            a = 0;
                        } else {
                            a = this.f23606b.length;
                        }
                        Object obj = new C5879b[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23606b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5879b();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5879b();
                        c5757a.m19766a(obj[a]);
                        this.f23606b = obj;
                        continue;
                    case 162:
                        if (this.f23607d == null) {
                            this.f23607d = new C5876a();
                        }
                        c5757a.m19766a(this.f23607d);
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

        public C5884b() {
            this.f23606b = C5879b.m20457d();
            this.f23607d = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23606b != null && this.f23606b.length > 0) {
                for (C6001m c6001m : this.f23606b) {
                    if (c6001m != null) {
                        c5787b.m19964a(2, c6001m);
                    }
                }
            }
            if (this.f23607d != null) {
                c5787b.m19964a(20, this.f23607d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23606b != null && this.f23606b.length > 0) {
                for (C6001m c6001m : this.f23606b) {
                    if (c6001m != null) {
                        a += C5787b.m19946c(2, c6001m);
                    }
                }
            }
            if (this.f23607d != null) {
                return a + C5787b.m19946c(20, this.f23607d);
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.fb$c */
    public static final class C5885c extends C5832c<C5885c> {
        /* renamed from: b */
        public int f23608b;
        /* renamed from: d */
        public C5884b f23609d;
        /* renamed from: e */
        public C5887e f23610e;
        /* renamed from: f */
        public C5902h f23611f;
        /* renamed from: g */
        public C5886d f23612g;
        /* renamed from: h */
        public C5875a[] f23613h;
        /* renamed from: i */
        public C5883a[] f23614i;
        /* renamed from: j */
        public int f23615j;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20479a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23608b = c5757a.m19775f();
                        continue;
                    case 18:
                        if (this.f23609d == null) {
                            this.f23609d = new C5884b();
                        }
                        c5757a.m19766a(this.f23609d);
                        continue;
                    case 26:
                        if (this.f23610e == null) {
                            this.f23610e = new C5887e();
                        }
                        c5757a.m19766a(this.f23610e);
                        continue;
                    case 34:
                        if (this.f23611f == null) {
                            this.f23611f = new C5902h();
                        }
                        c5757a.m19766a(this.f23611f);
                        continue;
                    case 42:
                        a2 = C6007s.a(c5757a, 42);
                        if (this.f23613h == null) {
                            a = 0;
                        } else {
                            a = this.f23613h.length;
                        }
                        obj = new C5875a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23613h, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5875a();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5875a();
                        c5757a.m19766a(obj[a]);
                        this.f23613h = obj;
                        continue;
                    case 48:
                        this.f23615j = c5757a.m19775f();
                        continue;
                    case 58:
                        a2 = C6007s.a(c5757a, 58);
                        if (this.f23614i == null) {
                            a = 0;
                        } else {
                            a = this.f23614i.length;
                        }
                        obj = new C5883a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23614i, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5883a();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5883a();
                        c5757a.m19766a(obj[a]);
                        this.f23614i = obj;
                        continue;
                    case 66:
                        if (this.f23612g == null) {
                            this.f23612g = new C5886d();
                        }
                        c5757a.m19766a(this.f23612g);
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

        public C5885c() {
            this.f23608b = 0;
            this.f23609d = null;
            this.f23610e = null;
            this.f23611f = null;
            this.f23612g = null;
            this.f23613h = C5875a.m20444d();
            this.f23614i = C5883a.m20471d();
            this.f23615j = 0;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i = 0;
            if (this.f23608b != 0) {
                c5787b.m19970b(1, this.f23608b);
            }
            if (this.f23609d != null) {
                c5787b.m19964a(2, this.f23609d);
            }
            if (this.f23610e != null) {
                c5787b.m19964a(3, this.f23610e);
            }
            if (this.f23611f != null) {
                c5787b.m19964a(4, this.f23611f);
            }
            if (this.f23613h != null && this.f23613h.length > 0) {
                for (C6001m c6001m : this.f23613h) {
                    if (c6001m != null) {
                        c5787b.m19964a(5, c6001m);
                    }
                }
            }
            if (this.f23615j != 0) {
                c5787b.m19970b(6, this.f23615j);
            }
            if (this.f23614i != null && this.f23614i.length > 0) {
                while (i < this.f23614i.length) {
                    C6001m c6001m2 = this.f23614i[i];
                    if (c6001m2 != null) {
                        c5787b.m19964a(7, c6001m2);
                    }
                    i++;
                }
            }
            if (this.f23612g != null) {
                c5787b.m19964a(8, this.f23612g);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i = 0;
            int a = super.mo4674a();
            if (this.f23608b != 0) {
                a += C5787b.m19951e(1, this.f23608b);
            }
            if (this.f23609d != null) {
                a += C5787b.m19946c(2, this.f23609d);
            }
            if (this.f23610e != null) {
                a += C5787b.m19946c(3, this.f23610e);
            }
            if (this.f23611f != null) {
                a += C5787b.m19946c(4, this.f23611f);
            }
            if (this.f23613h != null && this.f23613h.length > 0) {
                int i2 = a;
                for (C6001m c6001m : this.f23613h) {
                    if (c6001m != null) {
                        i2 += C5787b.m19946c(5, c6001m);
                    }
                }
                a = i2;
            }
            if (this.f23615j != 0) {
                a += C5787b.m19951e(6, this.f23615j);
            }
            if (this.f23614i != null && this.f23614i.length > 0) {
                while (i < this.f23614i.length) {
                    C6001m c6001m2 = this.f23614i[i];
                    if (c6001m2 != null) {
                        a += C5787b.m19946c(7, c6001m2);
                    }
                    i++;
                }
            }
            if (this.f23612g != null) {
                return a + C5787b.m19946c(8, this.f23612g);
            }
            return a;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.fb$d */
    public static final class C5886d extends C5832c<C5886d> {
        /* renamed from: b */
        public long f23616b;

        public C5886d() {
            this.f23616b = 0;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23616b != 0) {
                c5787b.m19963a(1, this.f23616b);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23616b != 0) {
                return a + C5787b.m19939b(1, this.f23616b);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20482a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23616b = c5757a.m19776g();
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

    /* renamed from: com.indooratlas.android.sdk._internal.fb$e */
    public static final class C5887e extends C5832c<C5887e> {
        /* renamed from: b */
        public byte[][] f23617b;
        /* renamed from: d */
        public C5888f[] f23618d;

        /* renamed from: a */
        public final /* synthetic */ C6001m m20485a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a2 = C6007s.a(c5757a, 10);
                        a = this.f23617b == null ? 0 : this.f23617b.length;
                        obj = new byte[(a2 + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f23617b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c5757a.m19772d();
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = c5757a.m19772d();
                        this.f23617b = obj;
                        continue;
                    case 18:
                        a2 = C6007s.a(c5757a, 18);
                        if (this.f23618d == null) {
                            a = 0;
                        } else {
                            a = this.f23618d.length;
                        }
                        obj = new C5888f[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f23618d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C5888f();
                            c5757a.m19766a(obj[a]);
                            c5757a.m19764a();
                            a++;
                        }
                        obj[a] = new C5888f();
                        c5757a.m19766a(obj[a]);
                        this.f23618d = obj;
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

        public C5887e() {
            this.f23617b = C6007s.f24582g;
            this.f23618d = C5888f.m20487d();
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            int i = 0;
            if (this.f23617b != null && this.f23617b.length > 0) {
                for (byte[] bArr : this.f23617b) {
                    if (bArr != null) {
                        c5787b.m19967a(1, bArr);
                    }
                }
            }
            if (this.f23618d != null && this.f23618d.length > 0) {
                while (i < this.f23618d.length) {
                    C6001m c6001m = this.f23618d[i];
                    if (c6001m != null) {
                        c5787b.m19964a(2, c6001m);
                    }
                    i++;
                }
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int i;
            int i2 = 0;
            int a = super.mo4674a();
            if (this.f23617b == null || this.f23617b.length <= 0) {
                i = a;
            } else {
                int i3 = 0;
                int i4 = 0;
                for (byte[] bArr : this.f23617b) {
                    if (bArr != null) {
                        i4++;
                        i3 += C5787b.m19935a(bArr);
                    }
                }
                i = (a + i3) + (i4 * 1);
            }
            if (this.f23618d != null && this.f23618d.length > 0) {
                while (i2 < this.f23618d.length) {
                    C6001m c6001m = this.f23618d[i2];
                    if (c6001m != null) {
                        i += C5787b.m19946c(2, c6001m);
                    }
                    i2++;
                }
            }
            return i;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.fb$f */
    public static final class C5888f extends C5832c<C5888f> {
        /* renamed from: e */
        private static volatile C5888f[] f23619e;
        /* renamed from: b */
        public long f23620b;
        /* renamed from: d */
        public byte[] f23621d;

        /* renamed from: d */
        public static C5888f[] m20487d() {
            if (f23619e == null) {
                synchronized (C5978i.f24329c) {
                    if (f23619e == null) {
                        f23619e = new C5888f[0];
                    }
                }
            }
            return f23619e;
        }

        public C5888f() {
            this.f23620b = 0;
            this.f23621d = C6007s.f24583h;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23620b != 0) {
                c5787b.m19963a(1, this.f23620b);
            }
            if (!Arrays.equals(this.f23621d, C6007s.f24583h)) {
                c5787b.m19967a(2, this.f23621d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23620b != 0) {
                a += C5787b.m19939b(1, this.f23620b);
            }
            if (Arrays.equals(this.f23621d, C6007s.f24583h)) {
                return a;
            }
            return a + C5787b.m19942b(2, this.f23621d);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20489a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23620b = c5757a.m19776g();
                        continue;
                    case 18:
                        this.f23621d = c5757a.m19772d();
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
