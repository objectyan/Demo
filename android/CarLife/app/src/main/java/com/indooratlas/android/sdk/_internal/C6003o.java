package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.C6000l.C5998b;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.indooratlas.android.sdk._internal.o */
public final class C6003o extends C5832c<C6003o> {
    /* renamed from: b */
    public Map<String, C6006r> f24569b;

    public C6003o() {
        this.f24569b = null;
        this.a = null;
        this.c = -1;
    }

    /* renamed from: a */
    public final void m21518a(C5787b c5787b) throws IOException {
        if (this.f24569b != null) {
            C5978i.m21088a(c5787b, this.f24569b);
        }
        super.a(c5787b);
    }

    /* renamed from: a */
    protected final int m21516a() {
        int a = super.a();
        if (this.f24569b != null) {
            return a + C5978i.m21086a(this.f24569b);
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C6001m m21517a(C5757a c5757a) throws IOException {
        C5998b a = C6000l.m21503a();
        while (true) {
            int a2 = c5757a.a();
            switch (a2) {
                case 0:
                    break;
                case 10:
                    this.f24569b = C5978i.m21087a(c5757a, this.f24569b, a, new C6006r());
                    continue;
                default:
                    if (!a(c5757a, a2)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
