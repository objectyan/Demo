package com.baidu.mapframework.commonlib.asynchttp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
    /* renamed from: a */
    private static byte[] f18828a = new byte[0];
    /* renamed from: b */
    private final Coder f18829b;
    /* renamed from: c */
    private final int f18830c;
    /* renamed from: d */
    private byte[] f18831d;
    /* renamed from: e */
    private int f18832e;

    public Base64OutputStream(OutputStream out, int flags) {
        this(out, flags, true);
    }

    public Base64OutputStream(OutputStream out, int flags, boolean encode) {
        super(out);
        this.f18831d = null;
        this.f18832e = 0;
        this.f18830c = flags;
        if (encode) {
            this.f18829b = new Encoder(flags, null);
        } else {
            this.f18829b = new Decoder(flags, null);
        }
    }

    public void write(int b) throws IOException {
        if (this.f18831d == null) {
            this.f18831d = new byte[1024];
        }
        if (this.f18832e >= this.f18831d.length) {
            m14935a(this.f18831d, 0, this.f18832e, false);
            this.f18832e = 0;
        }
        byte[] bArr = this.f18831d;
        int i = this.f18832e;
        this.f18832e = i + 1;
        bArr[i] = (byte) b;
    }

    /* renamed from: a */
    private void m14934a() throws IOException {
        if (this.f18832e > 0) {
            m14935a(this.f18831d, 0, this.f18832e, false);
            this.f18832e = 0;
        }
    }

    public void write(byte[] b, int off, int len) throws IOException {
        if (len > 0) {
            m14934a();
            m14935a(b, off, len, false);
        }
    }

    public void close() throws IOException {
        IOException thrown = null;
        try {
            m14934a();
            m14935a(f18828a, 0, 0, true);
        } catch (IOException e) {
            thrown = e;
        }
        try {
            if ((this.f18830c & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
        } catch (IOException e2) {
            if (thrown != null) {
                thrown = e2;
            }
        }
        if (thrown != null) {
            throw thrown;
        }
    }

    /* renamed from: a */
    private void m14935a(byte[] b, int off, int len, boolean finish) throws IOException {
        this.f18829b.output = m14936a(this.f18829b.output, this.f18829b.maxOutputSize(len));
        if (this.f18829b.process(b, off, len, finish)) {
            this.out.write(this.f18829b.output, 0, this.f18829b.op);
            return;
        }
        throw new Base64DataException("bad base-64");
    }

    /* renamed from: a */
    private byte[] m14936a(byte[] b, int len) {
        if (b == null || b.length < len) {
            return new byte[len];
        }
        return b;
    }
}
