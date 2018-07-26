package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.p */
public final class C6004p extends C5832c<C6004p> {
    /* renamed from: b */
    public long f24570b;

    public C6004p() {
        this.f24570b = 0;
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void m21521a(C5787b c5787b) throws IOException {
        if (this.f24570b != 0) {
            c5787b.a(1, this.f24570b);
        }
        super.a(c5787b);
    }

    /* renamed from: a */
    protected final int m21519a() {
        int a = super.a();
        if (this.f24570b != 0) {
            return a + C5787b.b(1, this.f24570b);
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C6001m m21520a(C5757a c5757a) throws IOException {
        while (true) {
            int a = c5757a.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.f24570b = c5757a.g();
                    continue;
                default:
                    if (!a(c5757a, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
