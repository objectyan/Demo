package com.facebook.imagepipeline.p152i;

import com.facebook.common.p257e.C5320a;
import java.io.Closeable;

/* compiled from: CloseableImage */
/* renamed from: com.facebook.imagepipeline.i.b */
public abstract class C5534b implements C5533e, Closeable {
    /* renamed from: a */
    private static final String f22452a = "CloseableImage";

    /* renamed from: b */
    public abstract int mo4099b();

    /* renamed from: c */
    public abstract boolean mo4100c();

    public abstract void close();

    /* renamed from: d */
    public C5537g mo4097d() {
        return C5538f.f22457a;
    }

    /* renamed from: e */
    public boolean m19050e() {
        return false;
    }

    protected void finalize() throws Throwable {
        if (!mo4100c()) {
            C5320a.m18178d(f22452a, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
