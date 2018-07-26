package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.ProtocolException;

public final class ic implements jc {
    /* renamed from: a */
    public final in f24330a;
    /* renamed from: b */
    private boolean f24331b;
    /* renamed from: c */
    private final int f24332c;

    public ic(int i) {
        this.f24330a = new in();
        this.f24332c = i;
    }

    public ic() {
        this(-1);
    }

    public final void close() throws IOException {
        if (!this.f24331b) {
            this.f24331b = true;
            if (this.f24330a.f24392b < ((long) this.f24332c)) {
                throw new ProtocolException("content-length promised " + this.f24332c + " bytes, but received " + this.f24330a.f24392b);
            }
        }
    }

    public final void a_(in inVar, long j) throws IOException {
        if (this.f24331b) {
            throw new IllegalStateException("closed");
        }
        gy.a(inVar.f24392b, j);
        if (this.f24332c == -1 || this.f24330a.f24392b <= ((long) this.f24332c) - j) {
            this.f24330a.a_(inVar, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f24332c + " bytes");
    }

    public final void flush() throws IOException {
    }

    /* renamed from: a */
    public final je mo4733a() {
        return je.f24380b;
    }

    /* renamed from: a */
    public final void m21094a(jc jcVar) throws IOException {
        in inVar = new in();
        this.f24330a.m21181a(inVar, 0, this.f24330a.f24392b);
        jcVar.a_(inVar, inVar.f24392b);
    }
}
