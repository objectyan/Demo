package com.indooratlas.android.sdk._internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface jc extends Closeable, Flushable {
    /* renamed from: a */
    je mo4733a();

    void a_(in inVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
