package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract class is implements jd {
    /* renamed from: a */
    private final jd f24401a;

    public is(jd jdVar) {
        if (jdVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f24401a = jdVar;
    }

    /* renamed from: a */
    public long mo4730a(in inVar, long j) throws IOException {
        return this.f24401a.mo4730a(inVar, j);
    }

    /* renamed from: a */
    public final je mo4731a() {
        return this.f24401a.mo4731a();
    }

    public void close() throws IOException {
        this.f24401a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f24401a.toString() + ")";
    }
}
