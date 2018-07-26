package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ew.C5876a;
import com.indooratlas.android.sdk._internal.ex.C5877a;
import java.io.IOException;

public interface fc {

    /* renamed from: com.indooratlas.android.sdk._internal.fc$a */
    public static final class C5889a extends C5832c<C5889a> {
        /* renamed from: b */
        public C5876a f23622b;

        public C5889a() {
            this.f23622b = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23622b != null) {
                c5787b.m19964a(2, this.f23622b);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23622b != null) {
                return a + C5787b.m19946c(2, this.f23622b);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20492a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 18:
                        if (this.f23622b == null) {
                            this.f23622b = new C5876a();
                        }
                        c5757a.m19766a(this.f23622b);
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

    /* renamed from: com.indooratlas.android.sdk._internal.fc$b */
    public static final class C5890b extends C5832c<C5890b> {
        /* renamed from: b */
        public C5877a f23623b;
        /* renamed from: d */
        public C5892d f23624d;

        public C5890b() {
            this.f23623b = null;
            this.f23624d = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23623b != null) {
                c5787b.m19964a(1, this.f23623b);
            }
            if (this.f23624d != null) {
                c5787b.m19964a(2, this.f23624d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23623b != null) {
                a += C5787b.m19946c(1, this.f23623b);
            }
            if (this.f23624d != null) {
                return a + C5787b.m19946c(2, this.f23624d);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20495a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f23623b == null) {
                            this.f23623b = new C5877a();
                        }
                        c5757a.m19766a(this.f23623b);
                        continue;
                    case 18:
                        if (this.f23624d == null) {
                            this.f23624d = new C5892d();
                        }
                        c5757a.m19766a(this.f23624d);
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

    /* renamed from: com.indooratlas.android.sdk._internal.fc$c */
    public static final class C5891c extends C5832c<C5891c> {
        /* renamed from: b */
        public C5890b f23625b;
        /* renamed from: d */
        public C5889a f23626d;
        /* renamed from: e */
        public C5889a f23627e;
        /* renamed from: f */
        public int f23628f;
        /* renamed from: g */
        public C6003o f23629g;

        public C5891c() {
            this.f23625b = null;
            this.f23626d = null;
            this.f23627e = null;
            this.f23628f = 0;
            this.f23629g = null;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (this.f23625b != null) {
                c5787b.m19964a(1, this.f23625b);
            }
            if (this.f23626d != null) {
                c5787b.m19964a(2, this.f23626d);
            }
            if (this.f23628f != 0) {
                c5787b.m19970b(3, this.f23628f);
            }
            if (this.f23627e != null) {
                c5787b.m19964a(4, this.f23627e);
            }
            if (this.f23629g != null) {
                c5787b.m19964a(16, this.f23629g);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (this.f23625b != null) {
                a += C5787b.m19946c(1, this.f23625b);
            }
            if (this.f23626d != null) {
                a += C5787b.m19946c(2, this.f23626d);
            }
            if (this.f23628f != 0) {
                a += C5787b.m19951e(3, this.f23628f);
            }
            if (this.f23627e != null) {
                a += C5787b.m19946c(4, this.f23627e);
            }
            if (this.f23629g != null) {
                return a + C5787b.m19946c(16, this.f23629g);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20498a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f23625b == null) {
                            this.f23625b = new C5890b();
                        }
                        c5757a.m19766a(this.f23625b);
                        continue;
                    case 18:
                        if (this.f23626d == null) {
                            this.f23626d = new C5889a();
                        }
                        c5757a.m19766a(this.f23626d);
                        continue;
                    case 24:
                        this.f23628f = c5757a.m19775f();
                        continue;
                    case 34:
                        if (this.f23627e == null) {
                            this.f23627e = new C5889a();
                        }
                        c5757a.m19766a(this.f23627e);
                        continue;
                    case 130:
                        if (this.f23629g == null) {
                            this.f23629g = new C6003o();
                        }
                        c5757a.m19766a(this.f23629g);
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

    /* renamed from: com.indooratlas.android.sdk._internal.fc$d */
    public static final class C5892d extends C5832c<C5892d> {
        /* renamed from: b */
        public float f23630b;
        /* renamed from: d */
        public float f23631d;

        public C5892d() {
            this.f23630b = 0.0f;
            this.f23631d = 0.0f;
            this.a = null;
            this.c = -1;
        }

        /* renamed from: a */
        public final void mo4675a(C5787b c5787b) throws IOException {
            if (Float.floatToIntBits(this.f23630b) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(1, this.f23630b);
            }
            if (Float.floatToIntBits(this.f23631d) != Float.floatToIntBits(0.0f)) {
                c5787b.m19961a(2, this.f23631d);
            }
            super.mo4675a(c5787b);
        }

        /* renamed from: a */
        protected final int mo4674a() {
            int a = super.mo4674a();
            if (Float.floatToIntBits(this.f23630b) != Float.floatToIntBits(0.0f)) {
                a += C5787b.m19948d(1) + 4;
            }
            if (Float.floatToIntBits(this.f23631d) != Float.floatToIntBits(0.0f)) {
                return a + (C5787b.m19948d(2) + 4);
            }
            return a;
        }

        /* renamed from: a */
        public final /* synthetic */ C6001m m20501a(C5757a c5757a) throws IOException {
            while (true) {
                int a = c5757a.m19764a();
                switch (a) {
                    case 0:
                        break;
                    case 13:
                        this.f23630b = Float.intBitsToFloat(c5757a.m19777h());
                        continue;
                    case 21:
                        this.f23631d = Float.intBitsToFloat(c5757a.m19777h());
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
