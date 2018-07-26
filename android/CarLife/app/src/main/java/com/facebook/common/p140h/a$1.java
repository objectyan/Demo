package com.facebook.common.p140h;

import com.facebook.common.internal.C5342c;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: CloseableReference */
/* renamed from: com.facebook.common.h.a$1 */
class a$1 implements C5329c<Closeable> {
    a$1() {
    }

    /* renamed from: a */
    public void m18247a(Closeable value) {
        try {
            C5342c.m18273a(value, true);
        } catch (IOException e) {
        }
    }
}
