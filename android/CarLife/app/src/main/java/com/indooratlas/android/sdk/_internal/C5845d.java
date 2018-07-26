package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.reflect.Array;

/* renamed from: com.indooratlas.android.sdk._internal.d */
public final class C5845d<M extends C5832c<M>, T> {
    /* renamed from: a */
    protected final int f23365a;
    /* renamed from: b */
    protected final Class<T> f23366b;
    /* renamed from: c */
    public final int f23367c;
    /* renamed from: d */
    protected final boolean f23368d;

    /* renamed from: a */
    final void m20291a(Object obj, C5787b c5787b) throws IOException {
        if (this.f23368d) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    m20289b(obj2, c5787b);
                }
            }
            return;
        }
        m20289b(obj, c5787b);
    }

    /* renamed from: b */
    private void m20289b(Object obj, C5787b c5787b) {
        try {
            c5787b.m19974e(this.f23367c);
            switch (this.f23365a) {
                case 10:
                    C6001m c6001m = (C6001m) obj;
                    int b = C6007s.b(this.f23367c);
                    c6001m.a(c5787b);
                    c5787b.m19975g(b, 4);
                    return;
                case 11:
                    c5787b.m19968a((C6001m) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f23365a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* renamed from: a */
    final int m20290a(Object obj) {
        int i = 0;
        if (!this.f23368d) {
            return m20288b(obj);
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m20288b(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* renamed from: b */
    private int m20288b(Object obj) {
        int b = C6007s.b(this.f23367c);
        switch (this.f23365a) {
            case 10:
                return C5787b.m19940b(b, (C6001m) obj);
            case 11:
                return C5787b.m19946c(b, (C6001m) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f23365a);
        }
    }
}
