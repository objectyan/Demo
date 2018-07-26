package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.eu.C5874c;
import java.io.IOException;
import java.util.Arrays;

public interface ez {

    /* renamed from: com.indooratlas.android.sdk._internal.ez$a */
    public static final class C5880a extends C5832c<C5880a> {
        /* renamed from: b */
        public int f23594b;
        /* renamed from: d */
        public C6003o f23595d;
        /* renamed from: e */
        public byte[] f23596e;
        /* renamed from: f */
        public C5874c f23597f;

        public C5880a() {
            this.f23594b = 0;
            this.f23595d = null;
            this.f23596e = C6007s.f24583h;
            this.f23597f = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23594b != 0) {
                c5787b.m19970b(1, this.f23594b);
            }
            if (this.f23595d != null) {
                c5787b.m19964a(2, this.f23595d);
            }
            if (!Arrays.equals(this.f23596e, C6007s.f24583h)) {
                c5787b.m19967a(3, this.f23596e);
            }
            if (this.f23597f != null) {
                c5787b.m19964a(4, this.f23597f);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23594b != 0) {
                a += C5787b.m19951e(1, this.f23594b);
            }
            if (this.f23595d != null) {
                a += C5787b.m19946c(2, this.f23595d);
            }
            if (!Arrays.equals(this.f23596e, C6007s.f24583h)) {
                a += C5787b.m19942b(3, this.f23596e);
            }
            if (this.f23597f != null) {
                return a + C5787b.m19946c(4, this.f23597f);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20462a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f23594b = c5757a.m19775f();
                        continue;
                    case 18:
                        if (this.f23595d == null) {
                            this.f23595d = new C6003o();
                        }
                        c5757a.m19766a(this.f23595d);
                        continue;
                    case 26:
                        this.f23596e = c5757a.m19772d();
                        continue;
                    case 34:
                        if (this.f23597f == null) {
                            this.f23597f = new C5874c();
                        }
                        c5757a.m19766a(this.f23597f);
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
