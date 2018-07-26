package com.indooratlas.android.sdk._internal;

public final class bh {
    /* renamed from: a */
    int f23197a;
    /* renamed from: b */
    String f23198b;
    /* renamed from: c */
    private Throwable f23199c;

    private bh(int i, String str, Throwable th) {
        this.f23197a = i;
        this.f23198b = str;
        this.f23199c = th;
    }

    /* renamed from: a */
    public static bh m20095a(int i, Throwable th, String str, Object... objArr) {
        return new bh(i, ct.m20256a(str, objArr), th);
    }

    public final String toString() {
        return "IAManagerStatus{mErrorCode=" + this.f23197a + ", mErrorMessage='" + this.f23198b + '\'' + '}';
    }
}
