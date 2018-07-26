package com.indooratlas.android.sdk._internal;

public final class ae<R> {
    /* renamed from: a */
    public final boolean f22927a;
    /* renamed from: b */
    public final R f22928b;
    /* renamed from: c */
    public C6013x f22929c;
    /* renamed from: d */
    public final ad f22930d;

    private ae(boolean z, C6013x c6013x, R r, ad adVar) {
        this.f22927a = z;
        this.f22928b = r;
        this.f22930d = adVar;
        this.f22929c = c6013x;
    }

    /* renamed from: a */
    public static <R> ae<R> m19794a(ad adVar, R r) {
        return new ae(false, null, r, adVar);
    }

    /* renamed from: a */
    public static <R> ae<R> m19795a(C6013x c6013x, R r) {
        return new ae(true, c6013x, r, null);
    }

    public final String toString() {
        return "RestResponse{success=" + this.f22927a + ", result=" + this.f22928b + ", response=" + this.f22929c + ", error=" + this.f22930d + '}';
    }
}
