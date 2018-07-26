package com.indooratlas.android.sdk._internal;

import java.io.IOException;

/* renamed from: com.indooratlas.android.sdk._internal.c */
public abstract class C5832c<M extends C5832c<M>> extends C6001m {
    /* renamed from: a */
    public C5862e f23282a;

    /* renamed from: b */
    public final /* synthetic */ C6001m m20199b() throws CloneNotSupportedException {
        return m20195d();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m20195d();
    }

    /* renamed from: a */
    public int mo4674a() {
        int i = 0;
        if (this.f23282a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f23282a.m20382b()) {
            i2 += this.f23282a.m20380a(i).m20465a();
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public void mo4675a(C5787b c5787b) throws IOException {
        if (this.f23282a != null) {
            for (int i = 0; i < this.f23282a.m20382b(); i++) {
                this.f23282a.m20380a(i).m20466a(c5787b);
            }
        }
    }

    /* renamed from: a */
    public final boolean m20198a(C5757a c5757a, int i) throws IOException {
        int k = c5757a.m19780k();
        if (!c5757a.m19768b(i)) {
            return false;
        }
        byte[] bArr;
        C5881f c5881f;
        int b = C6007s.b(i);
        int k2 = c5757a.m19780k() - k;
        if (k2 == 0) {
            bArr = C6007s.f24583h;
        } else {
            bArr = new byte[k2];
            System.arraycopy(c5757a.f22909a, k + c5757a.f22910b, bArr, 0, k2);
        }
        C6005q c6005q = new C6005q(i, bArr);
        if (this.f23282a == null) {
            this.f23282a = new C5862e();
            c5881f = null;
        } else {
            C5862e c5862e = this.f23282a;
            k2 = c5862e.m20383c(b);
            if (k2 < 0 || c5862e.f23497d[k2] == C5862e.f23494a) {
                c5881f = null;
            } else {
                c5881f = c5862e.f23497d[k2];
            }
        }
        if (c5881f == null) {
            C5881f c5881f2 = new C5881f();
            C5862e c5862e2 = this.f23282a;
            int c = c5862e2.m20383c(b);
            if (c >= 0) {
                c5862e2.f23497d[c] = c5881f2;
                c5881f = c5881f2;
            } else {
                c ^= -1;
                if (c >= c5862e2.f23498e || c5862e2.f23497d[c] != C5862e.f23494a) {
                    if (c5862e2.f23495b && c5862e2.f23498e >= c5862e2.f23496c.length) {
                        c5862e2.m20381a();
                        c = c5862e2.m20383c(b) ^ -1;
                    }
                    if (c5862e2.f23498e >= c5862e2.f23496c.length) {
                        int b2 = C5862e.m20379b(c5862e2.f23498e + 1);
                        Object obj = new int[b2];
                        Object obj2 = new C5881f[b2];
                        System.arraycopy(c5862e2.f23496c, 0, obj, 0, c5862e2.f23496c.length);
                        System.arraycopy(c5862e2.f23497d, 0, obj2, 0, c5862e2.f23497d.length);
                        c5862e2.f23496c = obj;
                        c5862e2.f23497d = obj2;
                    }
                    if (c5862e2.f23498e - c != 0) {
                        System.arraycopy(c5862e2.f23496c, c, c5862e2.f23496c, c + 1, c5862e2.f23498e - c);
                        System.arraycopy(c5862e2.f23497d, c, c5862e2.f23497d, c + 1, c5862e2.f23498e - c);
                    }
                    c5862e2.f23496c[c] = b;
                    c5862e2.f23497d[c] = c5881f2;
                    c5862e2.f23498e++;
                    c5881f = c5881f2;
                } else {
                    c5862e2.f23496c[c] = b;
                    c5862e2.f23497d[c] = c5881f2;
                    c5881f = c5881f2;
                }
            }
        }
        c5881f.f23598a.add(c6005q);
        return true;
    }

    /* renamed from: d */
    private M m20195d() throws CloneNotSupportedException {
        C5832c c5832c = (C5832c) super.b();
        C5978i.a(this, c5832c);
        return c5832c;
    }
}
