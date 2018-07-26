package com.indooratlas.android.sdk._internal;

import android.support.v4.media.TransportMediator;
import com.baidu.navi.protocol.util.BNaviProtocolDef;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.indooratlas.android.sdk._internal.b */
public final class C5787b {
    /* renamed from: a */
    final ByteBuffer f23069a;

    /* renamed from: com.indooratlas.android.sdk._internal.b$a */
    public static class C5786a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        C5786a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private C5787b(byte[] bArr, int i) {
        this(ByteBuffer.wrap(bArr, 0, i));
    }

    private C5787b(ByteBuffer byteBuffer) {
        this.f23069a = byteBuffer;
        this.f23069a.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    public static C5787b m19936a(byte[] bArr, int i) {
        return new C5787b(bArr, i);
    }

    /* renamed from: a */
    public final void m19960a(int i, double d) throws IOException {
        m19975g(i, 1);
        m19957a(d);
    }

    /* renamed from: a */
    public final void m19961a(int i, float f) throws IOException {
        m19975g(i, 5);
        m19958a(f);
    }

    /* renamed from: a */
    public final void m19963a(int i, long j) throws IOException {
        m19975g(i, 0);
        m19937a(j);
    }

    /* renamed from: a */
    public final void m19962a(int i, int i2) throws IOException {
        m19975g(i, 0);
        m19959a(i2);
    }

    /* renamed from: a */
    public final void m19966a(int i, boolean z) throws IOException {
        int i2 = 0;
        m19975g(i, 0);
        if (z) {
            i2 = 1;
        }
        m19955h(i2);
    }

    /* renamed from: a */
    public final void m19965a(int i, String str) throws IOException {
        m19975g(i, 2);
        try {
            int f = C5787b.m19952f(str.length());
            if (f == C5787b.m19952f(str.length() * 3)) {
                int position = this.f23069a.position();
                if (this.f23069a.remaining() < f) {
                    throw new C5786a(f + position, this.f23069a.limit());
                }
                this.f23069a.position(position + f);
                C5787b.m19938a((CharSequence) str, this.f23069a);
                int position2 = this.f23069a.position();
                this.f23069a.position(position);
                m19974e((position2 - position) - f);
                this.f23069a.position(position2);
                return;
            }
            m19974e(C5787b.m19933a((CharSequence) str));
            C5787b.m19938a((CharSequence) str, this.f23069a);
        } catch (Throwable e) {
            C5786a c5786a = new C5786a(this.f23069a.position(), this.f23069a.limit());
            c5786a.initCause(e);
            throw c5786a;
        }
    }

    /* renamed from: a */
    public final void m19964a(int i, C6001m c6001m) throws IOException {
        m19975g(i, 2);
        m19968a(c6001m);
    }

    /* renamed from: a */
    public final void m19967a(int i, byte[] bArr) throws IOException {
        m19975g(i, 2);
        m19974e(bArr.length);
        m19972b(bArr);
    }

    /* renamed from: b */
    public final void m19970b(int i, int i2) throws IOException {
        m19975g(i, 0);
        m19974e(i2);
    }

    /* renamed from: c */
    public final void m19973c(int i, int i2) throws IOException {
        m19975g(i, 0);
        m19974e(i2);
    }

    /* renamed from: a */
    public final void m19957a(double d) throws IOException {
        m19947c(Double.doubleToLongBits(d));
    }

    /* renamed from: a */
    public final void m19958a(float f) throws IOException {
        m19956i(Float.floatToIntBits(f));
    }

    /* renamed from: a */
    public final void m19959a(int i) throws IOException {
        if (i >= 0) {
            m19974e(i);
        } else {
            m19937a((long) i);
        }
    }

    /* renamed from: a */
    private static int m19933a(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i += i3;
                if (i < length) {
                    return i;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
            }
        }
        i = i3;
        if (i < length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    /* renamed from: a */
    private static void m19938a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(C5787b.m19934a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            C5787b.m19944b(charSequence, byteBuffer);
        }
    }

    /* renamed from: b */
    private static void m19944b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | RGHUDDataModel.MAX_CAR_SPEED));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    /* renamed from: a */
    private static int m19934a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | BNaviProtocolDef.DEFAULT_IMAGE_HEIGHT);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | RGHUDDataModel.MAX_CAR_SPEED);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    /* renamed from: b */
    public final void m19969b(int i) throws IOException {
        m19974e(C5787b.m19954g(i));
    }

    /* renamed from: b */
    public static int m19939b(int i, long j) {
        return C5787b.m19948d(i) + C5787b.m19943b(j);
    }

    /* renamed from: d */
    public static int m19949d(int i, int i2) {
        return C5787b.m19948d(i) + C5787b.m19945c(i2);
    }

    /* renamed from: b */
    public static int m19941b(int i, String str) {
        int d = C5787b.m19948d(i);
        int a = C5787b.m19933a((CharSequence) str);
        return d + (a + C5787b.m19952f(a));
    }

    /* renamed from: b */
    public static int m19940b(int i, C6001m c6001m) {
        return (C5787b.m19948d(i) * 2) + c6001m.c();
    }

    /* renamed from: c */
    public static int m19946c(int i, C6001m c6001m) {
        int d = C5787b.m19948d(i);
        int c = c6001m.c();
        return d + (c + C5787b.m19952f(c));
    }

    /* renamed from: b */
    public static int m19942b(int i, byte[] bArr) {
        return C5787b.m19948d(i) + C5787b.m19935a(bArr);
    }

    /* renamed from: e */
    public static int m19951e(int i, int i2) {
        return C5787b.m19948d(i) + C5787b.m19952f(i2);
    }

    /* renamed from: f */
    public static int m19953f(int i, int i2) {
        return C5787b.m19948d(i) + C5787b.m19952f(i2);
    }

    /* renamed from: c */
    public static int m19945c(int i) {
        if (i >= 0) {
            return C5787b.m19952f(i);
        }
        return 10;
    }

    /* renamed from: a */
    public static int m19935a(byte[] bArr) {
        return C5787b.m19952f(bArr.length) + bArr.length;
    }

    /* renamed from: h */
    private void m19955h(int i) throws IOException {
        byte b = (byte) i;
        if (this.f23069a.hasRemaining()) {
            this.f23069a.put(b);
            return;
        }
        throw new C5786a(this.f23069a.position(), this.f23069a.limit());
    }

    /* renamed from: b */
    public final void m19972b(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f23069a.remaining() >= length) {
            this.f23069a.put(bArr, 0, length);
            return;
        }
        throw new C5786a(this.f23069a.position(), this.f23069a.limit());
    }

    /* renamed from: g */
    public final void m19975g(int i, int i2) throws IOException {
        m19974e(C6007s.a(i, i2));
    }

    /* renamed from: d */
    public static int m19948d(int i) {
        return C5787b.m19952f(C6007s.a(i, 0));
    }

    /* renamed from: e */
    public final void m19974e(int i) throws IOException {
        while ((i & -128) != 0) {
            m19955h((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        m19955h(i);
    }

    /* renamed from: f */
    public static int m19952f(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    /* renamed from: a */
    private void m19937a(long j) throws IOException {
        while ((-128 & j) != 0) {
            m19955h((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        m19955h((int) j);
    }

    /* renamed from: b */
    private static int m19943b(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    /* renamed from: i */
    private void m19956i(int i) throws IOException {
        if (this.f23069a.remaining() < 4) {
            throw new C5786a(this.f23069a.position(), this.f23069a.limit());
        }
        this.f23069a.putInt(i);
    }

    /* renamed from: c */
    private void m19947c(long j) throws IOException {
        if (this.f23069a.remaining() < 8) {
            throw new C5786a(this.f23069a.position(), this.f23069a.limit());
        }
        this.f23069a.putLong(j);
    }

    /* renamed from: g */
    public static int m19954g(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: d */
    private static long m19950d(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: a */
    static int m19932a(int i, int i2, Object obj) {
        long longValue;
        switch (i2) {
            case 1:
                ((Double) obj).doubleValue();
                return C5787b.m19948d(i) + 8;
            case 2:
                ((Float) obj).floatValue();
                return C5787b.m19948d(i) + 4;
            case 3:
                longValue = ((Long) obj).longValue();
                return C5787b.m19943b(longValue) + C5787b.m19948d(i);
            case 4:
                return C5787b.m19939b(i, ((Long) obj).longValue());
            case 5:
                return C5787b.m19949d(i, ((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return C5787b.m19948d(i) + 8;
            case 7:
                ((Integer) obj).intValue();
                return C5787b.m19948d(i) + 4;
            case 8:
                ((Boolean) obj).booleanValue();
                return C5787b.m19948d(i) + 1;
            case 9:
                return C5787b.m19941b(i, (String) obj);
            case 10:
                return C5787b.m19940b(i, (C6001m) obj);
            case 11:
                return C5787b.m19946c(i, (C6001m) obj);
            case 12:
                return C5787b.m19942b(i, (byte[]) obj);
            case 13:
                return C5787b.m19951e(i, ((Integer) obj).intValue());
            case 14:
                return C5787b.m19953f(i, ((Integer) obj).intValue());
            case 15:
                ((Integer) obj).intValue();
                return C5787b.m19948d(i) + 4;
            case 16:
                ((Long) obj).longValue();
                return C5787b.m19948d(i) + 8;
            case 17:
                int intValue = ((Integer) obj).intValue();
                return C5787b.m19952f(C5787b.m19954g(intValue)) + C5787b.m19948d(i);
            case 18:
                longValue = ((Long) obj).longValue();
                return C5787b.m19943b(C5787b.m19950d(longValue)) + C5787b.m19948d(i);
            default:
                throw new IllegalArgumentException("Unknown type: " + i2);
        }
    }

    /* renamed from: b */
    final void m19971b(int i, int i2, Object obj) throws IOException {
        long longValue;
        int intValue;
        switch (i2) {
            case 1:
                m19960a(i, ((Double) obj).doubleValue());
                return;
            case 2:
                m19961a(i, ((Float) obj).floatValue());
                return;
            case 3:
                longValue = ((Long) obj).longValue();
                m19975g(i, 0);
                m19937a(longValue);
                return;
            case 4:
                m19963a(i, ((Long) obj).longValue());
                return;
            case 5:
                m19962a(i, ((Integer) obj).intValue());
                return;
            case 6:
                longValue = ((Long) obj).longValue();
                m19975g(i, 1);
                m19947c(longValue);
                return;
            case 7:
                intValue = ((Integer) obj).intValue();
                m19975g(i, 5);
                m19956i(intValue);
                return;
            case 8:
                m19966a(i, ((Boolean) obj).booleanValue());
                return;
            case 9:
                m19965a(i, (String) obj);
                return;
            case 10:
                C6001m c6001m = (C6001m) obj;
                m19975g(i, 3);
                c6001m.a(this);
                m19975g(i, 4);
                return;
            case 11:
                m19964a(i, (C6001m) obj);
                return;
            case 12:
                m19967a(i, (byte[]) obj);
                return;
            case 13:
                m19970b(i, ((Integer) obj).intValue());
                return;
            case 14:
                m19973c(i, ((Integer) obj).intValue());
                return;
            case 15:
                intValue = ((Integer) obj).intValue();
                m19975g(i, 5);
                m19956i(intValue);
                return;
            case 16:
                longValue = ((Long) obj).longValue();
                m19975g(i, 1);
                m19947c(longValue);
                return;
            case 17:
                intValue = ((Integer) obj).intValue();
                m19975g(i, 0);
                m19969b(intValue);
                return;
            case 18:
                longValue = ((Long) obj).longValue();
                m19975g(i, 0);
                m19937a(C5787b.m19950d(longValue));
                return;
            default:
                throw new IOException("Unknown type: " + i2);
        }
    }

    /* renamed from: a */
    public final void m19968a(C6001m c6001m) throws IOException {
        if (c6001m.f24568c < 0) {
            c6001m.c();
        }
        m19974e(c6001m.f24568c);
        c6001m.a(this);
    }
}
