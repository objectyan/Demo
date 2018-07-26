package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ah.C5759a;

/* renamed from: com.indooratlas.android.sdk._internal.u */
public abstract class C6009u implements ab {
    /* renamed from: a */
    protected C6012w f24584a;
    /* renamed from: b */
    public String f24585b;
    /* renamed from: c */
    public String f24586c;
    /* renamed from: d */
    private String f24587d;

    public C6009u(String str, C6012w c6012w) {
        this.f24587d = eg.a(str, "endpoint must be non empty", new Object[0]);
        this.f24584a = (C6012w) eg.a(c6012w, "errorHandler must be non null", new Object[0]);
    }

    /* renamed from: a */
    public final ah m21540a(C5759a c5759a) {
        String str = this.f24587d;
        ah ahVar = new ah();
        ahVar.f22941a = str;
        ahVar.f22942b = c5759a;
        return ahVar;
    }

    /* renamed from: a */
    public final void m21541a(String str, String str2) {
        this.f24585b = eg.a(str, "apiKey must be non empty", new Object[0]);
        this.f24586c = eg.a(str2, "apiSecret must be non empty", new Object[0]);
    }

    /* renamed from: a */
    public final boolean m21542a() {
        return (ei.a(this.f24585b) || ei.a(this.f24586c)) ? false : true;
    }

    /* renamed from: b */
    public final void m21543b() throws IllegalStateException {
        if (!m21542a()) {
            throw new IllegalStateException("client is not authenticated");
        }
    }
}
