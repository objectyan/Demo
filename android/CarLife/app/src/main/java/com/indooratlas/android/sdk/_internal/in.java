package com.indooratlas.android.sdk._internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class in implements io, ip, Cloneable {
    /* renamed from: c */
    private static final byte[] f24390c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    /* renamed from: a */
    ja f24391a;
    /* renamed from: b */
    public long f24392b;

    /* renamed from: b */
    public final /* synthetic */ io mo4742b(iq iqVar) throws IOException {
        return m21182a(iqVar);
    }

    /* renamed from: b */
    public final /* synthetic */ io mo4743b(String str) throws IOException {
        return m21183a(str);
    }

    /* renamed from: b */
    public final /* synthetic */ io mo4744b(byte[] bArr) throws IOException {
        return m21185a(bArr);
    }

    /* renamed from: b */
    public final /* synthetic */ io mo4745b(byte[] bArr, int i, int i2) throws IOException {
        return m21186a(bArr, i, i2);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m21175q();
    }

    /* renamed from: g */
    public final /* synthetic */ io mo4754g(int i) throws IOException {
        return m21203e(i);
    }

    /* renamed from: h */
    public final /* synthetic */ io mo4755h(int i) throws IOException {
        return m21199d(i);
    }

    /* renamed from: i */
    public final /* synthetic */ io mo4758i(int i) throws IOException {
        return m21196c(i);
    }

    /* renamed from: i */
    public final /* synthetic */ io mo4759i(long j) throws IOException {
        return m21211h(j);
    }

    /* renamed from: j */
    public final /* synthetic */ io mo4761j(int i) throws IOException {
        return m21191b(i);
    }

    /* renamed from: j */
    public final /* synthetic */ io mo4762j(long j) throws IOException {
        return m21209g(j);
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ io mo4765p() throws IOException {
        return this;
    }

    /* renamed from: b */
    public final in mo4741b() {
        return this;
    }

    /* renamed from: c */
    public final io mo4746c() {
        return this;
    }

    /* renamed from: d */
    public final boolean mo4748d() {
        return this.f24392b == 0;
    }

    /* renamed from: a */
    public final void mo4740a(long j) throws EOFException {
        if (this.f24392b < j) {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public final in m21181a(in inVar, long j, long j2) {
        if (inVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        jf.m21314a(this.f24392b, j, j2);
        if (j2 != 0) {
            inVar.f24392b += j2;
            ja jaVar = this.f24391a;
            while (j >= ((long) (jaVar.f24431c - jaVar.f24430b))) {
                j -= (long) (jaVar.f24431c - jaVar.f24430b);
                jaVar = jaVar.f24434f;
            }
            while (j2 > 0) {
                ja jaVar2 = new ja(jaVar);
                jaVar2.f24430b = (int) (((long) jaVar2.f24430b) + j);
                jaVar2.f24431c = Math.min(jaVar2.f24430b + ((int) j2), jaVar2.f24431c);
                if (inVar.f24391a == null) {
                    jaVar2.f24435g = jaVar2;
                    jaVar2.f24434f = jaVar2;
                    inVar.f24391a = jaVar2;
                } else {
                    inVar.f24391a.f24435g.m21305a(jaVar2);
                }
                j2 -= (long) (jaVar2.f24431c - jaVar2.f24430b);
                jaVar = jaVar.f24434f;
                j = 0;
            }
        }
        return this;
    }

    /* renamed from: e */
    public final byte mo4749e() {
        if (this.f24392b == 0) {
            throw new IllegalStateException("size == 0");
        }
        ja jaVar = this.f24391a;
        int i = jaVar.f24430b;
        int i2 = jaVar.f24431c;
        int i3 = i + 1;
        byte b = jaVar.f24429a[i];
        this.f24392b--;
        if (i3 == i2) {
            this.f24391a = jaVar.m21304a();
            jb.m21308a(jaVar);
        } else {
            jaVar.f24430b = i3;
        }
        return b;
    }

    /* renamed from: b */
    public final byte m21189b(long j) {
        jf.m21314a(this.f24392b, j, 1);
        ja jaVar = this.f24391a;
        while (true) {
            int i = jaVar.f24431c - jaVar.f24430b;
            if (j < ((long) i)) {
                return jaVar.f24429a[jaVar.f24430b + ((int) j)];
            }
            j -= (long) i;
            jaVar = jaVar.f24434f;
        }
    }

    /* renamed from: f */
    public final short mo4751f() {
        if (this.f24392b < 2) {
            throw new IllegalStateException("size < 2: " + this.f24392b);
        }
        ja jaVar = this.f24391a;
        int i = jaVar.f24430b;
        int i2 = jaVar.f24431c;
        if (i2 - i < 2) {
            return (short) (((mo4749e() & 255) << 8) | (mo4749e() & 255));
        }
        byte[] bArr = jaVar.f24429a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f24392b -= 2;
        if (i4 == i2) {
            this.f24391a = jaVar.m21304a();
            jb.m21308a(jaVar);
        } else {
            jaVar.f24430b = i4;
        }
        return (short) i;
    }

    /* renamed from: g */
    public final int mo4753g() {
        if (this.f24392b < 4) {
            throw new IllegalStateException("size < 4: " + this.f24392b);
        }
        ja jaVar = this.f24391a;
        int i = jaVar.f24430b;
        int i2 = jaVar.f24431c;
        if (i2 - i < 4) {
            return ((((mo4749e() & 255) << 24) | ((mo4749e() & 255) << 16)) | ((mo4749e() & 255) << 8)) | (mo4749e() & 255);
        }
        byte[] bArr = jaVar.f24429a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.f24392b -= 4;
        if (i4 == i2) {
            this.f24391a = jaVar.m21304a();
            jb.m21308a(jaVar);
            return i;
        }
        jaVar.f24430b = i4;
        return i;
    }

    /* renamed from: h */
    public final short mo4756h() {
        return jf.m21313a(mo4751f());
    }

    /* renamed from: i */
    public final int mo4757i() {
        return jf.m21312a(mo4753g());
    }

    /* renamed from: j */
    public final long mo4760j() {
        if (this.f24392b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            ja jaVar = this.f24391a;
            byte[] bArr = jaVar.f24429a;
            int i2 = jaVar.f24430b;
            int i3 = jaVar.f24431c;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.f24391a = jaVar.m21304a();
                            jb.m21308a(jaVar);
                        } else {
                            jaVar.f24430b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new in().m21211h(j).m21191b((int) b).m21221l());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                jaVar.f24430b = i4;
            } else {
                this.f24391a = jaVar.m21304a();
                jb.m21308a(jaVar);
            }
            if (obj == null) {
                break;
            }
        } while (this.f24391a != null);
        this.f24392b -= (long) i;
        return j;
    }

    /* renamed from: k */
    public final iq m21220k() {
        return new iq(mo4764n());
    }

    /* renamed from: c */
    public final iq mo4747c(long j) throws EOFException {
        return new iq(mo4750e(j));
    }

    /* renamed from: l */
    public final String m21221l() {
        try {
            return m21172a(this.f24392b, jf.f24438a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: k */
    private String m21174k(long j) throws EOFException {
        return m21172a(j, jf.f24438a);
    }

    /* renamed from: a */
    private String m21172a(long j, Charset charset) throws EOFException {
        jf.m21314a(this.f24392b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            ja jaVar = this.f24391a;
            if (((long) jaVar.f24430b) + j > ((long) jaVar.f24431c)) {
                return new String(mo4750e(j), charset);
            }
            String str = new String(jaVar.f24429a, jaVar.f24430b, (int) j, charset);
            jaVar.f24430b = (int) (((long) jaVar.f24430b) + j);
            this.f24392b -= j;
            if (jaVar.f24430b != jaVar.f24431c) {
                return str;
            }
            this.f24391a = jaVar.m21304a();
            jb.m21308a(jaVar);
            return str;
        }
    }

    /* renamed from: m */
    public final String mo4763m() throws EOFException {
        long a = m21177a((byte) 10, 0);
        if (a != -1) {
            return m21200d(a);
        }
        in inVar = new in();
        m21181a(inVar, 0, Math.min(32, this.f24392b));
        throw new EOFException("\\n not found: size=" + this.f24392b + " content=" + inVar.m21220k().m21230b() + "...");
    }

    /* renamed from: d */
    final String m21200d(long j) throws EOFException {
        if (j <= 0 || m21189b(j - 1) != (byte) 13) {
            String k = m21174k(j);
            mo4752f(1);
            return k;
        }
        k = m21174k(j - 1);
        mo4752f(2);
        return k;
    }

    /* renamed from: n */
    public final byte[] mo4764n() {
        try {
            return mo4750e(this.f24392b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: e */
    public final byte[] mo4750e(long j) throws EOFException {
        jf.m21314a(this.f24392b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        m21173c(bArr);
        return bArr;
    }

    /* renamed from: c */
    private void m21173c(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2;
            int length = bArr.length - i;
            jf.m21314a((long) bArr.length, (long) i, (long) length);
            ja jaVar = this.f24391a;
            if (jaVar == null) {
                i2 = -1;
            } else {
                i2 = Math.min(length, jaVar.f24431c - jaVar.f24430b);
                System.arraycopy(jaVar.f24429a, jaVar.f24430b, bArr, i, i2);
                jaVar.f24430b += i2;
                this.f24392b -= (long) i2;
                if (jaVar.f24430b == jaVar.f24431c) {
                    this.f24391a = jaVar.m21304a();
                    jb.m21308a(jaVar);
                }
            }
            if (i2 == -1) {
                throw new EOFException();
            }
            i = i2 + i;
        }
    }

    /* renamed from: o */
    public final void m21224o() {
        try {
            mo4752f(this.f24392b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: f */
    public final void mo4752f(long j) throws EOFException {
        while (j > 0) {
            if (this.f24391a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.f24391a.f24431c - this.f24391a.f24430b));
            this.f24392b -= (long) min;
            j -= (long) min;
            ja jaVar = this.f24391a;
            jaVar.f24430b = min + jaVar.f24430b;
            if (this.f24391a.f24430b == this.f24391a.f24431c) {
                ja jaVar2 = this.f24391a;
                this.f24391a = jaVar2.m21304a();
                jb.m21308a(jaVar2);
            }
        }
    }

    /* renamed from: a */
    public final in m21182a(iq iqVar) {
        if (iqVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        m21186a(iqVar.f24395c, 0, iqVar.f24395c.length);
        return this;
    }

    /* renamed from: a */
    public final in m21183a(String str) {
        return m21184a(str, 0, str.length());
    }

    /* renamed from: a */
    public final in m21184a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                char charAt = str.charAt(i);
                int i3;
                if (charAt < '') {
                    int i4;
                    ja f = m21205f(1);
                    byte[] bArr = f.f24429a;
                    int i5 = f.f24431c - i;
                    int min = Math.min(i2, 2048 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - f.f24431c;
                    f.f24431c += i4;
                    this.f24392b += (long) i4;
                    i = i3;
                } else if (charAt < 'ࠀ') {
                    m21191b((charAt >> 6) | 192);
                    m21191b((charAt & 63) | 128);
                    i++;
                } else if (charAt < '?' || charAt > '?') {
                    m21191b((charAt >> 12) | C1253f.dE);
                    m21191b(((charAt >> 6) & 63) | 128);
                    m21191b((charAt & 63) | 128);
                    i++;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        m21191b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        m21191b((i3 >> 18) | RGHUDDataModel.MAX_CAR_SPEED);
                        m21191b(((i3 >> 12) & 63) | 128);
                        m21191b(((i3 >> 6) & 63) | 128);
                        m21191b((i3 & 63) | 128);
                        i += 2;
                    }
                }
            }
            return this;
        }
    }

    /* renamed from: a */
    public final in m21180a(int i) {
        if (i < 128) {
            m21191b(i);
        } else if (i < 2048) {
            m21191b((i >> 6) | 192);
            m21191b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m21191b((i >> 12) | C1253f.dE);
                m21191b(((i >> 6) & 63) | 128);
                m21191b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            m21191b((i >> 18) | RGHUDDataModel.MAX_CAR_SPEED);
            m21191b(((i >> 12) & 63) | 128);
            m21191b(((i >> 6) & 63) | 128);
            m21191b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: a */
    public final in m21185a(byte[] bArr) {
        if (bArr != null) {
            return m21186a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final in m21186a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        jf.m21314a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            ja f = m21205f(1);
            int min = Math.min(i3 - i, 2048 - f.f24431c);
            System.arraycopy(bArr, i, f.f24429a, f.f24431c, min);
            i += min;
            f.f24431c = min + f.f24431c;
        }
        this.f24392b += (long) i2;
        return this;
    }

    /* renamed from: a */
    public final long mo4739a(jd jdVar) throws IOException {
        if (jdVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = jdVar.mo4730a(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
            if (a == -1) {
                return j;
            }
            j += a;
        }
    }

    /* renamed from: b */
    public final in m21191b(int i) {
        ja f = m21205f(1);
        byte[] bArr = f.f24429a;
        int i2 = f.f24431c;
        f.f24431c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f24392b++;
        return this;
    }

    /* renamed from: c */
    public final in m21196c(int i) {
        ja f = m21205f(2);
        byte[] bArr = f.f24429a;
        int i2 = f.f24431c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        f.f24431c = i2;
        this.f24392b += 2;
        return this;
    }

    /* renamed from: d */
    public final in m21199d(int i) {
        ja f = m21205f(4);
        byte[] bArr = f.f24429a;
        int i2 = f.f24431c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        f.f24431c = i2;
        this.f24392b += 4;
        return this;
    }

    /* renamed from: e */
    public final in m21203e(int i) {
        return m21199d(jf.m21312a(i));
    }

    /* renamed from: g */
    public final in m21209g(long j) {
        if (j == 0) {
            return m21191b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return m21183a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < BNOffScreenParams.MIN_ENTER_INTERVAL ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        ja f = m21205f(i);
        byte[] bArr = f.f24429a;
        int i2 = f.f24431c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f24390c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        f.f24431c += i;
        this.f24392b = ((long) i) + this.f24392b;
        return this;
    }

    /* renamed from: h */
    public final in m21211h(long j) {
        if (j == 0) {
            return m21191b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ja f = m21205f(numberOfTrailingZeros);
        byte[] bArr = f.f24429a;
        int i = f.f24431c;
        for (int i2 = (f.f24431c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f24390c[(int) (15 & j)];
            j >>>= 4;
        }
        f.f24431c += numberOfTrailingZeros;
        this.f24392b = ((long) numberOfTrailingZeros) + this.f24392b;
        return this;
    }

    /* renamed from: f */
    final ja m21205f(int i) {
        if (i <= 0 || i > 2048) {
            throw new IllegalArgumentException();
        } else if (this.f24391a == null) {
            this.f24391a = jb.m21307a();
            ja jaVar = this.f24391a;
            ja jaVar2 = this.f24391a;
            r0 = this.f24391a;
            jaVar2.f24435g = r0;
            jaVar.f24434f = r0;
            return r0;
        } else {
            r0 = this.f24391a.f24435g;
            if (r0.f24431c + i > 2048 || !r0.f24433e) {
                return r0.m21305a(jb.m21307a());
            }
            return r0;
        }
    }

    public final void a_(in inVar, long j) {
        if (inVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            jf.m21314a(inVar.f24392b, 0, j);
            while (j > 0) {
                ja jaVar;
                ja jaVar2;
                if (j < ((long) (inVar.f24391a.f24431c - inVar.f24391a.f24430b))) {
                    jaVar = this.f24391a != null ? this.f24391a.f24435g : null;
                    if (jaVar != null && jaVar.f24433e) {
                        if ((((long) jaVar.f24431c) + j) - ((long) (jaVar.f24432d ? 0 : jaVar.f24430b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            inVar.f24391a.m21306a(jaVar, (int) j);
                            inVar.f24392b -= j;
                            this.f24392b += j;
                            return;
                        }
                    }
                    jaVar2 = inVar.f24391a;
                    int i = (int) j;
                    if (i <= 0 || i > jaVar2.f24431c - jaVar2.f24430b) {
                        throw new IllegalArgumentException();
                    }
                    ja jaVar3 = new ja(jaVar2);
                    jaVar3.f24431c = jaVar3.f24430b + i;
                    jaVar2.f24430b = i + jaVar2.f24430b;
                    jaVar2.f24435g.m21305a(jaVar3);
                    inVar.f24391a = jaVar3;
                }
                jaVar2 = inVar.f24391a;
                long j2 = (long) (jaVar2.f24431c - jaVar2.f24430b);
                inVar.f24391a = jaVar2.m21304a();
                if (this.f24391a == null) {
                    this.f24391a = jaVar2;
                    jaVar2 = this.f24391a;
                    jaVar = this.f24391a;
                    ja jaVar4 = this.f24391a;
                    jaVar.f24435g = jaVar4;
                    jaVar2.f24434f = jaVar4;
                } else {
                    jaVar = this.f24391a.f24435g.m21305a(jaVar2);
                    if (jaVar.f24435g == jaVar) {
                        throw new IllegalStateException();
                    } else if (jaVar.f24435g.f24433e) {
                        int i2 = jaVar.f24431c - jaVar.f24430b;
                        if (i2 <= (jaVar.f24435g.f24432d ? 0 : jaVar.f24435g.f24430b) + (2048 - jaVar.f24435g.f24431c)) {
                            jaVar.m21306a(jaVar.f24435g, i2);
                            jaVar.m21304a();
                            jb.m21308a(jaVar);
                        }
                    }
                }
                inVar.f24392b -= j2;
                this.f24392b += j2;
                j -= j2;
            }
        }
    }

    /* renamed from: a */
    public final long mo4730a(in inVar, long j) {
        if (inVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f24392b == 0) {
            return -1;
        } else {
            if (j > this.f24392b) {
                j = this.f24392b;
            }
            inVar.a_(this, j);
            return j;
        }
    }

    /* renamed from: a */
    public final long mo4738a(byte b) {
        return m21177a(b, 0);
    }

    /* renamed from: a */
    public final long m21177a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        ja jaVar = this.f24391a;
        if (jaVar == null) {
            return -1;
        }
        ja jaVar2 = jaVar;
        long j2 = 0;
        do {
            int i = jaVar2.f24431c - jaVar2.f24430b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = jaVar2.f24429a;
                int i2 = jaVar2.f24431c;
                for (int i3 = (int) (((long) jaVar2.f24430b) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b) {
                        return (j2 + ((long) i3)) - ((long) jaVar2.f24430b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            jaVar2 = jaVar2.f24434f;
        } while (jaVar2 != this.f24391a);
        return -1;
    }

    public final void flush() {
    }

    public final void close() {
    }

    /* renamed from: a */
    public final je mo4733a() {
        return je.f24380b;
    }

    public final boolean equals(Object o) {
        long j = 0;
        if (this == o) {
            return true;
        }
        if (!(o instanceof in)) {
            return false;
        }
        in inVar = (in) o;
        if (this.f24392b != inVar.f24392b) {
            return false;
        }
        if (this.f24392b == 0) {
            return true;
        }
        ja jaVar = this.f24391a;
        ja jaVar2 = inVar.f24391a;
        int i = jaVar.f24430b;
        int i2 = jaVar2.f24430b;
        while (j < this.f24392b) {
            long min = (long) Math.min(jaVar.f24431c - i, jaVar2.f24431c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = jaVar.f24429a[i];
                i = i2 + 1;
                if (b != jaVar2.f24429a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == jaVar.f24431c) {
                jaVar = jaVar.f24434f;
                i = jaVar.f24430b;
            }
            if (i2 == jaVar2.f24431c) {
                jaVar2 = jaVar2.f24434f;
                i2 = jaVar2.f24430b;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        ja jaVar = this.f24391a;
        if (jaVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jaVar.f24430b;
            while (i2 < jaVar.f24431c) {
                int i3 = jaVar.f24429a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            jaVar = jaVar.f24434f;
        } while (jaVar != this.f24391a);
        return i;
    }

    public final String toString() {
        if (this.f24392b == 0) {
            return "Buffer[size=0]";
        }
        if (this.f24392b <= 16) {
            iq k = m21175q().m21220k();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.f24392b), k.m21230b()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.f24391a.f24429a, this.f24391a.f24430b, this.f24391a.f24431c - this.f24391a.f24430b);
            for (ja jaVar = this.f24391a.f24434f; jaVar != this.f24391a; jaVar = jaVar.f24434f) {
                instance.update(jaVar.f24429a, jaVar.f24430b, jaVar.f24431c - jaVar.f24430b);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.f24392b), iq.m21227a(instance.digest()).m21230b()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: q */
    private in m21175q() {
        in inVar = new in();
        if (this.f24392b == 0) {
            return inVar;
        }
        inVar.f24391a = new ja(this.f24391a);
        ja jaVar = inVar.f24391a;
        ja jaVar2 = inVar.f24391a;
        ja jaVar3 = inVar.f24391a;
        jaVar2.f24435g = jaVar3;
        jaVar.f24434f = jaVar3;
        for (jaVar = this.f24391a.f24434f; jaVar != this.f24391a; jaVar = jaVar.f24434f) {
            inVar.f24391a.f24435g.m21305a(new ja(jaVar));
        }
        inVar.f24392b = this.f24392b;
        return inVar;
    }
}
