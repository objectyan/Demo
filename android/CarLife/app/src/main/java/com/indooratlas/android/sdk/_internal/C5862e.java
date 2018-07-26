package com.indooratlas.android.sdk._internal;

/* renamed from: com.indooratlas.android.sdk._internal.e */
public final class C5862e implements Cloneable {
    /* renamed from: a */
    static final C5881f f23494a = new C5881f();
    /* renamed from: b */
    boolean f23495b;
    /* renamed from: c */
    int[] f23496c;
    /* renamed from: d */
    C5881f[] f23497d;
    /* renamed from: e */
    int f23498e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m20384c();
    }

    C5862e() {
        this(10);
    }

    private C5862e(int i) {
        this.f23495b = false;
        int b = C5862e.m20379b(i);
        this.f23496c = new int[b];
        this.f23497d = new C5881f[b];
        this.f23498e = 0;
    }

    /* renamed from: a */
    final void m20381a() {
        int i = this.f23498e;
        int[] iArr = this.f23496c;
        C5881f[] c5881fArr = this.f23497d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            C5881f c5881f = c5881fArr[i3];
            if (c5881f != f23494a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    c5881fArr[i2] = c5881f;
                    c5881fArr[i3] = null;
                }
                i2++;
            }
        }
        this.f23495b = false;
        this.f23498e = i2;
    }

    /* renamed from: b */
    final int m20382b() {
        if (this.f23495b) {
            m20381a();
        }
        return this.f23498e;
    }

    /* renamed from: a */
    final C5881f m20380a(int i) {
        if (this.f23495b) {
            m20381a();
        }
        return this.f23497d[i];
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C5862e)) {
            return false;
        }
        C5862e c5862e = (C5862e) o;
        if (m20382b() != c5862e.m20382b()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.f23496c;
        int[] iArr2 = c5862e.f23496c;
        int i2 = this.f23498e;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            C5881f[] c5881fArr = this.f23497d;
            C5881f[] c5881fArr2 = c5862e.f23497d;
            i2 = this.f23498e;
            for (i = 0; i < i2; i++) {
                if (!c5881fArr[i].equals(c5881fArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f23495b) {
            m20381a();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.f23498e; i2++) {
            i = (((i * 31) + this.f23496c[i2]) * 31) + this.f23497d[i2].hashCode();
        }
        return i;
    }

    /* renamed from: b */
    static int m20379b(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    /* renamed from: c */
    final int m20383c(int i) {
        int i2 = 0;
        int i3 = this.f23498e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f23496c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    /* renamed from: c */
    public final C5862e m20384c() {
        int i = 0;
        int b = m20382b();
        C5862e c5862e = new C5862e(b);
        System.arraycopy(this.f23496c, 0, c5862e.f23496c, 0, b);
        while (i < b) {
            if (this.f23497d[i] != null) {
                c5862e.f23497d[i] = this.f23497d[i].m20467b();
            }
            i++;
        }
        c5862e.f23498e = b;
        return c5862e;
    }
}
