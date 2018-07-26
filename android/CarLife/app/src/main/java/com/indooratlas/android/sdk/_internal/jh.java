package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.ji.C5989a;
import java.nio.charset.Charset;

public final class jh extends ji {
    /* renamed from: a */
    static final byte[] f24450a = new byte[]{(byte) 13, (byte) 10};
    /* renamed from: d */
    private static final byte[] f24451d = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    /* renamed from: e */
    private static final byte[] f24452e = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    /* renamed from: f */
    private static final byte[] f24453f = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    /* renamed from: g */
    private final byte[] f24454g;
    /* renamed from: h */
    private final byte[] f24455h;
    /* renamed from: i */
    private final byte[] f24456i;
    /* renamed from: j */
    private final int f24457j;
    /* renamed from: k */
    private final int f24458k;

    public jh() {
        this((byte) 0);
    }

    private jh(byte b) {
        this(f24450a);
    }

    private jh(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private jh(byte[] bArr, byte b) {
        int i;
        if (bArr == null) {
            i = 0;
        } else {
            i = bArr.length;
        }
        super(i);
        this.f24455h = f24453f;
        if (bArr == null) {
            this.f24458k = 4;
            this.f24456i = null;
        } else if (m21320b(bArr)) {
            String str;
            Charset charset = jg.f24444f;
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr, charset);
            }
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + str + "]");
        } else {
            this.f24458k = 4;
            this.f24456i = null;
        }
        this.f24457j = this.f24458k - 1;
        this.f24454g = f24451d;
    }

    /* renamed from: a */
    final void mo4776a(byte[] bArr, int i, int i2, C5989a c5989a) {
        if (!c5989a.f24464f) {
            int i3;
            int i4;
            if (i2 < 0) {
                c5989a.f24464f = true;
                if (c5989a.f24466h != 0 || this.c != 0) {
                    Object a = ji.m21317a(this.f24458k, c5989a);
                    i3 = c5989a.f24462d;
                    switch (c5989a.f24466h) {
                        case 0:
                            break;
                        case 1:
                            i4 = c5989a.f24462d;
                            c5989a.f24462d = i4 + 1;
                            a[i4] = this.f24454g[(c5989a.f24459a >> 2) & 63];
                            i4 = c5989a.f24462d;
                            c5989a.f24462d = i4 + 1;
                            a[i4] = this.f24454g[(c5989a.f24459a << 4) & 63];
                            if (this.f24454g == f24451d) {
                                i4 = c5989a.f24462d;
                                c5989a.f24462d = i4 + 1;
                                a[i4] = 61;
                                i4 = c5989a.f24462d;
                                c5989a.f24462d = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        case 2:
                            i4 = c5989a.f24462d;
                            c5989a.f24462d = i4 + 1;
                            a[i4] = this.f24454g[(c5989a.f24459a >> 10) & 63];
                            i4 = c5989a.f24462d;
                            c5989a.f24462d = i4 + 1;
                            a[i4] = this.f24454g[(c5989a.f24459a >> 4) & 63];
                            i4 = c5989a.f24462d;
                            c5989a.f24462d = i4 + 1;
                            a[i4] = this.f24454g[(c5989a.f24459a << 2) & 63];
                            if (this.f24454g == f24451d) {
                                i4 = c5989a.f24462d;
                                c5989a.f24462d = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + c5989a.f24466h);
                    }
                    c5989a.f24465g = (c5989a.f24462d - i3) + c5989a.f24465g;
                    if (this.c > 0 && c5989a.f24465g > 0) {
                        System.arraycopy(this.f24456i, 0, a, c5989a.f24462d, this.f24456i.length);
                        c5989a.f24462d += this.f24456i.length;
                        return;
                    }
                    return;
                }
                return;
            }
            i3 = 0;
            while (i3 < i2) {
                Object a2 = ji.m21317a(this.f24458k, c5989a);
                c5989a.f24466h = (c5989a.f24466h + 1) % 3;
                i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                c5989a.f24459a = i5 + (c5989a.f24459a << 8);
                if (c5989a.f24466h == 0) {
                    i5 = c5989a.f24462d;
                    c5989a.f24462d = i5 + 1;
                    a2[i5] = this.f24454g[(c5989a.f24459a >> 18) & 63];
                    i5 = c5989a.f24462d;
                    c5989a.f24462d = i5 + 1;
                    a2[i5] = this.f24454g[(c5989a.f24459a >> 12) & 63];
                    i5 = c5989a.f24462d;
                    c5989a.f24462d = i5 + 1;
                    a2[i5] = this.f24454g[(c5989a.f24459a >> 6) & 63];
                    i5 = c5989a.f24462d;
                    c5989a.f24462d = i5 + 1;
                    a2[i5] = this.f24454g[c5989a.f24459a & 63];
                    c5989a.f24465g += 4;
                    if (this.c > 0 && this.c <= c5989a.f24465g) {
                        System.arraycopy(this.f24456i, 0, a2, c5989a.f24462d, this.f24456i.length);
                        c5989a.f24462d += this.f24456i.length;
                        c5989a.f24465g = 0;
                    }
                }
                i3++;
                i = i4;
            }
        }
    }

    /* renamed from: a */
    public static byte[] m21322a(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            ji jhVar = new jh(f24450a, (byte) 0);
            long c = jhVar.m21321c(bArr);
            if (c > 2147483647L) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + c + ") than the specified maximum size of 2147483647");
            } else if (!(bArr == null || bArr.length == 0)) {
                C5989a c5989a = new C5989a();
                jhVar.mo4776a(bArr, 0, bArr.length, c5989a);
                jhVar.mo4776a(bArr, 0, -1, c5989a);
                bArr = new byte[(c5989a.f24462d - c5989a.f24463e)];
                int length = bArr.length;
                if (c5989a.f24461c != null) {
                    int i;
                    if (c5989a.f24461c != null) {
                        i = c5989a.f24462d - c5989a.f24463e;
                    } else {
                        i = 0;
                    }
                    i = Math.min(i, length);
                    System.arraycopy(c5989a.f24461c, c5989a.f24463e, bArr, 0, i);
                    c5989a.f24463e = i + c5989a.f24463e;
                    if (c5989a.f24463e >= c5989a.f24462d) {
                        c5989a.f24461c = null;
                    }
                }
            }
        }
        return bArr;
    }

    /* renamed from: a */
    protected final boolean mo4777a(byte b) {
        return b >= (byte) 0 && b < this.f24455h.length && this.f24455h[b] != (byte) -1;
    }
}
