package com.facebook.common.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Closeables */
/* renamed from: com.facebook.common.internal.c */
public final class C5342c {
    @VisibleForTesting
    /* renamed from: a */
    static final Logger f21917a = Logger.getLogger(C5342c.class.getName());

    private C5342c() {
    }

    /* renamed from: a */
    public static void m18273a(@Nullable Closeable closeable, boolean swallowIOException) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (swallowIOException) {
                    f21917a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
                    return;
                }
                throw e;
            }
        }
    }

    /* renamed from: a */
    public static void m18274a(@Nullable InputStream inputStream) {
        try {
            C5342c.m18273a(inputStream, true);
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    /* renamed from: a */
    public static void m18275a(@Nullable Reader reader) {
        try {
            C5342c.m18273a(reader, true);
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }
}
