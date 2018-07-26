package com.indooratlas.android.sdk._internal;

import com.baidu.navi.fragment.NaviFragmentManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.indooratlas.android.sdk._internal.f */
final class C5881f implements Cloneable {
    /* renamed from: a */
    List<C6005q> f23598a = new ArrayList();
    /* renamed from: b */
    private C5845d<?, ?> f23599b;
    /* renamed from: c */
    private Object f23600c;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m20467b();
    }

    C5881f() {
    }

    /* renamed from: a */
    final int m20465a() {
        if (this.f23600c != null) {
            return this.f23599b.m20290a(this.f23600c);
        }
        int i = 0;
        for (C6005q c6005q : this.f23598a) {
            i = (c6005q.f24572b.length + (C5787b.m19952f(c6005q.f24571a) + 0)) + i;
        }
        return i;
    }

    /* renamed from: a */
    final void m20466a(C5787b c5787b) throws IOException {
        if (this.f23600c != null) {
            this.f23599b.m20291a(this.f23600c, c5787b);
            return;
        }
        for (C6005q c6005q : this.f23598a) {
            c5787b.m19974e(c6005q.f24571a);
            c5787b.m19972b(c6005q.f24572b);
        }
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C5881f)) {
            return false;
        }
        C5881f c5881f = (C5881f) o;
        if (this.f23600c == null || c5881f.f23600c == null) {
            if (this.f23598a != null && c5881f.f23598a != null) {
                return this.f23598a.equals(c5881f.f23598a);
            }
            try {
                return Arrays.equals(m20464c(), c5881f.m20464c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } else if (this.f23599b != c5881f.f23599b) {
            return false;
        } else {
            if (!this.f23599b.f23366b.isArray()) {
                return this.f23600c.equals(c5881f.f23600c);
            }
            if (this.f23600c instanceof byte[]) {
                return Arrays.equals((byte[]) this.f23600c, (byte[]) c5881f.f23600c);
            }
            if (this.f23600c instanceof int[]) {
                return Arrays.equals((int[]) this.f23600c, (int[]) c5881f.f23600c);
            }
            if (this.f23600c instanceof long[]) {
                return Arrays.equals((long[]) this.f23600c, (long[]) c5881f.f23600c);
            }
            if (this.f23600c instanceof float[]) {
                return Arrays.equals((float[]) this.f23600c, (float[]) c5881f.f23600c);
            }
            if (this.f23600c instanceof double[]) {
                return Arrays.equals((double[]) this.f23600c, (double[]) c5881f.f23600c);
            }
            if (this.f23600c instanceof boolean[]) {
                return Arrays.equals((boolean[]) this.f23600c, (boolean[]) c5881f.f23600c);
            }
            return Arrays.deepEquals((Object[]) this.f23600c, (Object[]) c5881f.f23600c);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m20464c()) + NaviFragmentManager.TYPE_PHONE_END;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: c */
    private byte[] m20464c() throws IOException {
        byte[] bArr = new byte[m20465a()];
        m20466a(C5787b.m19936a(bArr, bArr.length));
        return bArr;
    }

    /* renamed from: b */
    public final C5881f m20467b() {
        int i = 0;
        C5881f c5881f = new C5881f();
        try {
            c5881f.f23599b = this.f23599b;
            if (this.f23598a == null) {
                c5881f.f23598a = null;
            } else {
                c5881f.f23598a.addAll(this.f23598a);
            }
            if (this.f23600c != null) {
                if (this.f23600c instanceof C6001m) {
                    c5881f.f23600c = ((C6001m) this.f23600c).b();
                } else if (this.f23600c instanceof byte[]) {
                    c5881f.f23600c = ((byte[]) this.f23600c).clone();
                } else if (this.f23600c instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f23600c;
                    Object obj = new byte[bArr.length][];
                    c5881f.f23600c = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.f23600c instanceof boolean[]) {
                    c5881f.f23600c = ((boolean[]) this.f23600c).clone();
                } else if (this.f23600c instanceof int[]) {
                    c5881f.f23600c = ((int[]) this.f23600c).clone();
                } else if (this.f23600c instanceof long[]) {
                    c5881f.f23600c = ((long[]) this.f23600c).clone();
                } else if (this.f23600c instanceof float[]) {
                    c5881f.f23600c = ((float[]) this.f23600c).clone();
                } else if (this.f23600c instanceof double[]) {
                    c5881f.f23600c = ((double[]) this.f23600c).clone();
                } else if (this.f23600c instanceof C6001m[]) {
                    C6001m[] c6001mArr = (C6001m[]) this.f23600c;
                    Object obj2 = new C6001m[c6001mArr.length];
                    c5881f.f23600c = obj2;
                    while (i < c6001mArr.length) {
                        obj2[i] = c6001mArr[i].b();
                        i++;
                    }
                }
            }
            return c5881f;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
