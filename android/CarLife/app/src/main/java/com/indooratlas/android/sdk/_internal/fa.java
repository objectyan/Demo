package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface fa {

    /* renamed from: com.indooratlas.android.sdk._internal.fa$a */
    public static final class C5882a extends C5832c<C5882a> {
        /* renamed from: b */
        public String f23601b;
        /* renamed from: d */
        public String f23602d;

        public C5882a() {
            this.f23601b = "";
            this.f23602d = "";
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (!this.f23601b.equals("")) {
                c5787b.m19965a(1, this.f23601b);
            }
            if (!this.f23602d.equals("")) {
                c5787b.m19965a(2, this.f23602d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (!this.f23601b.equals("")) {
                a += C5787b.m19941b(1, this.f23601b);
            }
            if (this.f23602d.equals("")) {
                return a;
            }
            return a + C5787b.m19941b(2, this.f23602d);
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20469a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f23601b = c5757a.m19770c();
                        continue;
                    case 18:
                        this.f23602d = c5757a.m19770c();
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
