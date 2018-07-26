package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class gn implements Closeable {
    /* renamed from: a */
    public abstract gg m20738a();

    /* renamed from: b */
    public abstract long m20739b();

    /* renamed from: c */
    public abstract ip m20740c();

    /* renamed from: e */
    private byte[] m20737e() throws IOException {
        long b = m20739b();
        if (b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
        Closeable c = m20740c();
        try {
            byte[] n = c.n();
            if (b == -1 || b == ((long) n.length)) {
                return n;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            gy.m20790a(c);
        }
    }

    /* renamed from: d */
    public final String m20741d() throws IOException {
        Charset charset;
        byte[] e = m20737e();
        gg a = m20738a();
        if (a != null) {
            charset = gy.f24042c;
            if (a.f23872a != null) {
                charset = Charset.forName(a.f23872a);
            }
        } else {
            charset = gy.f24042c;
        }
        return new String(e, charset.name());
    }

    public void close() {
        gy.m20790a(m20740c());
    }
}
