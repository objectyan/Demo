package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: CountingOutputStream */
/* renamed from: com.facebook.common.internal.d */
public class C5343d extends FilterOutputStream {
    /* renamed from: a */
    private long f21918a = 0;

    public C5343d(OutputStream out) {
        super(out);
    }

    /* renamed from: a */
    public long m18276a() {
        return this.f21918a;
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        this.f21918a += (long) len;
    }

    public void write(int b) throws IOException {
        this.out.write(b);
        this.f21918a++;
    }

    public void close() throws IOException {
        this.out.close();
    }
}
