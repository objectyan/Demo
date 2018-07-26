package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.m */
public abstract class C6001m {
    /* renamed from: c */
    public volatile int f24568c = -1;

    /* renamed from: a */
    public abstract C6001m m21507a(C5757a c5757a) throws IOException;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m21509b();
    }

    /* renamed from: c */
    public final int m21510c() {
        int a = m21506a();
        this.f24568c = a;
        return a;
    }

    /* renamed from: a */
    public int m21506a() {
        return 0;
    }

    /* renamed from: a */
    public void m21508a(C5787b c5787b) throws IOException {
    }

    /* renamed from: a */
    public static final byte[] m21505a(C6001m c6001m) {
        byte[] bArr = new byte[c6001m.m21510c()];
        try {
            C5787b a = C5787b.a(bArr, bArr.length);
            c6001m.m21508a(a);
            if (a.f23069a.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return C6002n.m21511a(this);
    }

    /* renamed from: b */
    public C6001m m21509b() throws CloneNotSupportedException {
        return (C6001m) super.clone();
    }

    /* renamed from: a */
    public static <T extends C6001m> T m21504a(T t, byte[] bArr, int i) throws C5987j {
        try {
            C5757a c5757a = new C5757a(bArr, i);
            t.m21507a(c5757a);
            c5757a.a(0);
            return t;
        } catch (C5987j e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
}
