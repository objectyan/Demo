package com.facebook.imagepipeline.memory;

import java.io.Closeable;

/* compiled from: PooledByteBuffer */
/* renamed from: com.facebook.imagepipeline.memory.y */
public interface C5640y extends Closeable {

    /* compiled from: PooledByteBuffer */
    /* renamed from: com.facebook.imagepipeline.memory.y$a */
    public static class C5655a extends RuntimeException {
        public C5655a() {
            super("Invalid bytebuf. Already closed");
        }
    }

    /* renamed from: a */
    byte mo4154a(int i);

    /* renamed from: a */
    int mo4155a();

    /* renamed from: a */
    void mo4156a(int i, byte[] bArr, int i2, int i3);

    /* renamed from: b */
    long mo4157b();

    /* renamed from: c */
    boolean mo4158c();

    void close();
}
