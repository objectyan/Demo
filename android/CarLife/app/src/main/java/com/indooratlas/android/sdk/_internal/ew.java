package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface ew {

    /* renamed from: com.indooratlas.android.sdk._internal.ew$a */
    public static final class C5876a extends C5832c<C5876a> {
        /* renamed from: b */
        public int f23568b;
        /* renamed from: d */
        public String f23569d;
        /* renamed from: e */
        public String f23570e;

        public C5876a() {
            this.f23568b = 0;
            this.f23569d = "";
            this.f23570e = "";
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23568b != 0) {
                c5787b.m19962a(1, this.f23568b);
            }
            if (!this.f23569d.equals("")) {
                c5787b.m19965a(2, this.f23569d);
            }
            if (!this.f23570e.equals("")) {
                c5787b.m19965a(3, this.f23570e);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23568b != 0) {
                a += C5787b.m19949d(1, this.f23568b);
            }
            if (!this.f23569d.equals("")) {
                a += C5787b.m19941b(2, this.f23569d);
            }
            if (this.f23570e.equals("")) {
                return a;
            }
            return a + C5787b.m19941b(3, this.f23570e);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20449a(C5757a c5757a) throws IOException {
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
                                this.f23568b = a;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f23569d = c5757a.m19770c();
                        continue;
                    case 26:
                        this.f23570e = c5757a.m19770c();
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
