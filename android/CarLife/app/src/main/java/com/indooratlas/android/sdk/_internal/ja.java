package com.indooratlas.android.sdk._internal;

final class ja {
    /* renamed from: a */
    final byte[] f24429a;
    /* renamed from: b */
    int f24430b;
    /* renamed from: c */
    int f24431c;
    /* renamed from: d */
    boolean f24432d;
    /* renamed from: e */
    boolean f24433e;
    /* renamed from: f */
    ja f24434f;
    /* renamed from: g */
    ja f24435g;

    ja() {
        this.f24429a = new byte[2048];
        this.f24433e = true;
        this.f24432d = false;
    }

    ja(ja jaVar) {
        this(jaVar.f24429a, jaVar.f24430b, jaVar.f24431c);
        jaVar.f24432d = true;
    }

    private ja(byte[] bArr, int i, int i2) {
        this.f24429a = bArr;
        this.f24430b = i;
        this.f24431c = i2;
        this.f24433e = false;
        this.f24432d = true;
    }

    /* renamed from: a */
    public final ja m21304a() {
        ja jaVar = this.f24434f != this ? this.f24434f : null;
        this.f24435g.f24434f = this.f24434f;
        this.f24434f.f24435g = this.f24435g;
        this.f24434f = null;
        this.f24435g = null;
        return jaVar;
    }

    /* renamed from: a */
    public final ja m21305a(ja jaVar) {
        jaVar.f24435g = this;
        jaVar.f24434f = this.f24434f;
        this.f24434f.f24435g = jaVar;
        this.f24434f = jaVar;
        return jaVar;
    }

    /* renamed from: a */
    public final void m21306a(ja jaVar, int i) {
        if (jaVar.f24433e) {
            if (jaVar.f24431c + i > 2048) {
                if (jaVar.f24432d) {
                    throw new IllegalArgumentException();
                } else if ((jaVar.f24431c + i) - jaVar.f24430b > 2048) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(jaVar.f24429a, jaVar.f24430b, jaVar.f24429a, 0, jaVar.f24431c - jaVar.f24430b);
                    jaVar.f24431c -= jaVar.f24430b;
                    jaVar.f24430b = 0;
                }
            }
            System.arraycopy(this.f24429a, this.f24430b, jaVar.f24429a, jaVar.f24431c, i);
            jaVar.f24431c += i;
            this.f24430b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
