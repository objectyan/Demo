package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.C5354o;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: PooledByteBufferOutputStream */
public abstract class ab extends OutputStream {
    /* renamed from: b */
    public abstract int mo4166b();

    /* renamed from: c */
    public abstract C5640y mo4167c();

    public void close() {
        try {
            super.close();
        } catch (IOException ioe) {
            C5354o.m18340b(ioe);
        }
    }
}
