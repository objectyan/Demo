package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.h */
public final class C5935h extends C5832c<C5935h> {
    /* renamed from: b */
    public int f24067b;

    public C5935h() {
        this.f24067b = 0;
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void mo4675a(C5787b c5787b) throws IOException {
        if (this.f24067b != 0) {
            c5787b.m19962a(1, this.f24067b);
        }
        super.mo4675a(c5787b);
    }

    /* renamed from: a */
    protected final int mo4674a() {
        int a = super.mo4674a();
        if (this.f24067b != 0) {
            return a + C5787b.m19949d(1, this.f24067b);
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C6001m m20807a(C5757a c5757a) throws IOException {
        while (true) {
            int a = c5757a.m19764a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f24067b = c5757a.m19775f();
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
