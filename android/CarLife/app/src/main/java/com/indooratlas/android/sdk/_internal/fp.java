package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class fp implements Closeable, Flushable {
    /* renamed from: a */
    final gt f23719a;
    /* renamed from: b */
    private final gr f23720b;

    public final void flush() throws IOException {
        this.f23720b.flush();
    }

    public final void close() throws IOException {
        this.f23720b.close();
    }
}
