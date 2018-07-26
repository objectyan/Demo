package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface fd {

    /* renamed from: com.indooratlas.android.sdk._internal.fd$a */
    public static final class C5893a extends C5832c<C5893a> {
        /* renamed from: b */
        public int f23632b;
        /* renamed from: d */
        public int f23633d;
        /* renamed from: e */
        public C6003o f23634e;
        /* renamed from: f */
        public C6003o f23635f;

        public C5893a() {
            this.f23632b = 0;
            this.f23633d = 0;
            this.f23634e = null;
            this.f23635f = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23632b != 0) {
                c5787b.m19970b(1, this.f23632b);
            }
            if (this.f23633d != 0) {
                c5787b.m19970b(2, this.f23633d);
            }
            if (this.f23634e != null) {
                c5787b.m19964a(5, this.f23634e);
            }
            if (this.f23635f != null) {
                c5787b.m19964a(20, this.f23635f);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23632b != 0) {
                a += C5787b.m19951e(1, this.f23632b);
            }
            if (this.f23633d != 0) {
                a += C5787b.m19951e(2, this.f23633d);
            }
            if (this.f23634e != null) {
                a += C5787b.m19946c(5, this.f23634e);
            }
            if (this.f23635f != null) {
                return a + C5787b.m19946c(20, this.f23635f);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20504a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23632b = c5757a.m19775f();
                        continue;
                    case 16:
                        this.f23633d = c5757a.m19775f();
                        continue;
                    case 42:
                        if (this.f23634e == null) {
                            this.f23634e = new C6003o();
                        }
                        c5757a.m19766a(this.f23634e);
                        continue;
                    case 162:
                        if (this.f23635f == null) {
                            this.f23635f = new C6003o();
                        }
                        c5757a.m19766a(this.f23635f);
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
