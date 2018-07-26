package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract class gl {
    /* renamed from: a */
    public abstract gg mo4586a();

    /* renamed from: a */
    public abstract void mo4587a(io ioVar) throws IOException;

    /* renamed from: b */
    public long mo4588b() throws IOException {
        return -1;
    }

    /* renamed from: a */
    public static gl m19807a(final gg ggVar, final byte[] bArr) {
        final int length = bArr.length;
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        gy.m20789a((long) bArr.length, (long) length);
        return new gl() {
            /* renamed from: d */
            final /* synthetic */ int f23961d = 0;

            /* renamed from: a */
            public final gg mo4586a() {
                return ggVar;
            }

            /* renamed from: b */
            public final long mo4588b() {
                return (long) length;
            }

            /* renamed from: a */
            public final void mo4587a(io ioVar) throws IOException {
                ioVar.b(bArr, this.f23961d, length);
            }
        };
    }
}
