package com.tencent.wxop.stat.p291b;

/* renamed from: com.tencent.wxop.stat.b.i */
public class C6140i {
    /* renamed from: a */
    static final /* synthetic */ boolean f24922a = (!C6140i.class.desiredAssertionStatus());

    private C6140i() {
    }

    /* renamed from: a */
    public static byte[] m21850a(byte[] bArr, int i) {
        return C6140i.m21851a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m21851a(byte[] bArr, int i, int i2, int i3) {
        C6142k c6142k = new C6142k(i3, new byte[((i2 * 3) / 4)]);
        if (!c6142k.m21854a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c6142k.b == c6142k.a.length) {
            return c6142k.a;
        } else {
            Object obj = new byte[c6142k.b];
            System.arraycopy(c6142k.a, 0, obj, 0, c6142k.b);
            return obj;
        }
    }

    /* renamed from: b */
    public static byte[] m21852b(byte[] bArr, int i) {
        return C6140i.m21853b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m21853b(byte[] bArr, int i, int i2, int i3) {
        C6143l c6143l = new C6143l(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c6143l.f24934d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c6143l.f24935e && i2 > 0) {
            i4 += (c6143l.f24936f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c6143l.a = new byte[i4];
        c6143l.m21855a(bArr, i, i2, true);
        if (f24922a || c6143l.b == i4) {
            return c6143l.a;
        }
        throw new AssertionError();
    }
}
