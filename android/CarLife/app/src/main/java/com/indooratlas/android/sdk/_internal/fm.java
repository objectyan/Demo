package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public interface fm {

    /* renamed from: com.indooratlas.android.sdk._internal.fm$a */
    public static final class C5908a extends C5832c<C5908a> {
        /* renamed from: b */
        public int f23704b;
        /* renamed from: d */
        public String f23705d;
        /* renamed from: e */
        public int f23706e;

        public C5908a() {
            this.f23704b = 0;
            this.f23705d = "";
            this.f23706e = 0;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23704b != 0) {
                c5787b.m19962a(1, this.f23704b);
            }
            if (!this.f23705d.equals("")) {
                c5787b.m19965a(2, this.f23705d);
            }
            if (this.f23706e != 0) {
                c5787b.m19962a(3, this.f23706e);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23704b != 0) {
                a += C5787b.m19949d(1, this.f23704b);
            }
            if (!this.f23705d.equals("")) {
                a += C5787b.m19941b(2, this.f23705d);
            }
            if (this.f23706e != 0) {
                return a + C5787b.m19949d(3, this.f23706e);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20560a(C5757a c5757a) throws IOException {
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
                                this.f23704b = a;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f23705d = c5757a.m19770c();
                        continue;
                    case 24:
                        a = c5757a.m19775f();
                        switch (a) {
                            case 0:
                            case 1:
                                this.f23706e = a;
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
}
