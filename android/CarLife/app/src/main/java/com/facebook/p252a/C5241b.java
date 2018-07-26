package com.facebook.p252a;

import com.facebook.common.internal.C5350k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ByteArrayBinaryResource */
/* renamed from: com.facebook.a.b */
public class C5241b implements C5240a {
    /* renamed from: a */
    private final byte[] f21736a;

    public C5241b(byte[] bytes) {
        this.f21736a = (byte[]) C5350k.m18310a((Object) bytes);
    }

    /* renamed from: c */
    public long mo3932c() {
        return (long) this.f21736a.length;
    }

    /* renamed from: a */
    public InputStream mo3930a() throws IOException {
        return new ByteArrayInputStream(this.f21736a);
    }

    /* renamed from: b */
    public byte[] mo3931b() {
        return this.f21736a;
    }
}
