package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public interface el {

    /* renamed from: com.indooratlas.android.sdk._internal.el$a */
    public static final class C5868a extends C5832c<C5868a> {
        /* renamed from: b */
        public int f23515b;
        /* renamed from: d */
        public int f23516d;
        /* renamed from: e */
        public byte[] f23517e;

        public C5868a() {
            this.f23515b = 0;
            this.f23516d = 0;
            this.f23517e = C6007s.f24583h;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23515b != 0) {
                c5787b.m19962a(1, this.f23515b);
            }
            if (this.f23516d != 0) {
                c5787b.m19970b(2, this.f23516d);
            }
            if (!Arrays.equals(this.f23517e, C6007s.f24583h)) {
                c5787b.m19967a(3, this.f23517e);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23515b != 0) {
                a += C5787b.m19949d(1, this.f23515b);
            }
            if (this.f23516d != 0) {
                a += C5787b.m19951e(2, this.f23516d);
            }
            if (Arrays.equals(this.f23517e, C6007s.f24583h)) {
                return a;
            }
            return a + C5787b.m19942b(3, this.f23517e);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20421a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = c5757a.m19775f();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.f23515b = a;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.f23516d = c5757a.m19775f();
                        continue;
                    case 26:
                        this.f23517e = c5757a.m19772d();
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
