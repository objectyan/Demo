package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.g */
public final class C5915g extends C5832c<C5915g> {
    /* renamed from: b */
    public float f23832b;

    public C5915g() {
        this.f23832b = 0.0f;
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void mo4675a(C5787b c5787b) throws IOException {
        if (Float.floatToIntBits(this.f23832b) != Float.floatToIntBits(0.0f)) {
            c5787b.m19961a(1, this.f23832b);
        }
        super.mo4675a(c5787b);
    }

    /* renamed from: a */
    protected final int mo4674a() {
        int a = super.mo4674a();
        if (Float.floatToIntBits(this.f23832b) != Float.floatToIntBits(0.0f)) {
            return a + (C5787b.m19948d(1) + 4);
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C6001m m20597a(C5757a c5757a) throws IOException {
        while (true) {
            int a = c5757a.m19764a();
            switch (a) {
                case 0:
                    break;
                case 13:
                    this.f23832b = Float.intBitsToFloat(c5757a.m19777h());
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
