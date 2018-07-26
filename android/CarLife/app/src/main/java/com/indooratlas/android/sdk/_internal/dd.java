package com.indooratlas.android.sdk._internal;

import android.os.Bundle;

public final class dd implements cy {
    /* renamed from: a */
    public int f23375a;
    /* renamed from: b */
    public dc[] f23376b = new dc[0];
    /* renamed from: c */
    public Bundle f23377c = new Bundle();
    /* renamed from: d */
    private int f23378d;

    /* renamed from: a */
    public final void mo4657a(cx cxVar) {
        this.f23378d = 0;
        m20302b((cx) eg.m20413a((Object) cxVar, "event must not be null", new Object[0]));
    }

    /* renamed from: a */
    public final void m20301a(dc dcVar) {
        if (this.f23375a == this.f23376b.length) {
            Object obj = new dc[(this.f23375a + 1)];
            System.arraycopy(this.f23376b, 0, obj, 0, this.f23375a);
            this.f23376b = obj;
        }
        dc[] dcVarArr = this.f23376b;
        int i = this.f23375a;
        this.f23375a = i + 1;
        dcVarArr[i] = dcVar;
    }

    /* renamed from: b */
    public final void m20302b(cx cxVar) {
        while (this.f23378d < this.f23375a) {
            dc[] dcVarArr = this.f23376b;
            int i = this.f23378d;
            this.f23378d = i + 1;
            dc dcVar = dcVarArr[i];
            if (dcVar.mo4617a()) {
                dcVar.mo4616a(cxVar, this);
                return;
            }
        }
    }
}
