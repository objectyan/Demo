package com.baidu.carlife.util;

import java.io.UnsupportedEncodingException;

/* compiled from: FileMD5Util */
/* renamed from: com.baidu.carlife.util.g */
public class C2176g {
    /* renamed from: a */
    static final int f6946a = 7;
    /* renamed from: b */
    static final int f6947b = 12;
    /* renamed from: c */
    static final int f6948c = 17;
    /* renamed from: d */
    static final int f6949d = 22;
    /* renamed from: e */
    static final int f6950e = 5;
    /* renamed from: f */
    static final int f6951f = 9;
    /* renamed from: g */
    static final int f6952g = 14;
    /* renamed from: h */
    static final int f6953h = 20;
    /* renamed from: i */
    static final int f6954i = 4;
    /* renamed from: j */
    static final int f6955j = 11;
    /* renamed from: k */
    static final int f6956k = 16;
    /* renamed from: l */
    static final int f6957l = 23;
    /* renamed from: m */
    static final int f6958m = 6;
    /* renamed from: n */
    static final int f6959n = 10;
    /* renamed from: o */
    static final int f6960o = 15;
    /* renamed from: p */
    static final int f6961p = 21;
    /* renamed from: q */
    static final byte[] f6962q = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: r */
    public String f6963r;
    /* renamed from: s */
    private long[] f6964s = new long[4];
    /* renamed from: t */
    private long[] f6965t = new long[2];
    /* renamed from: u */
    private byte[] f6966u = new byte[64];
    /* renamed from: v */
    private byte[] f6967v = new byte[16];

    /* renamed from: a */
    public byte[] m8265a(byte[] inbuf) {
        m8266b();
        m8263a(inbuf, inbuf.length);
        m8267c();
        return this.f6967v;
    }

    /* renamed from: a */
    public byte[] m8264a() {
        return this.f6967v;
    }

    public C2176g() {
        m8266b();
    }

    /* renamed from: b */
    public void m8266b() {
        this.f6965t[0] = 0;
        this.f6965t[1] = 0;
        this.f6964s[0] = 1732584193;
        this.f6964s[1] = 4023233417L;
        this.f6964s[2] = 2562383102L;
        this.f6964s[3] = 271733878;
    }

    /* renamed from: a */
    private long m8244a(long x, long y, long z) {
        return (x & y) | ((-1 ^ x) & z);
    }

    /* renamed from: b */
    private long m8250b(long x, long y, long z) {
        return (x & z) | ((-1 ^ z) & y);
    }

    /* renamed from: c */
    private long m8255c(long x, long y, long z) {
        return (x ^ y) ^ z;
    }

    /* renamed from: d */
    private long m8260d(long x, long y, long z) {
        return ((-1 ^ z) | x) ^ y;
    }

    /* renamed from: a */
    private long m8245a(long a, long b, long c, long d, long x, long s, long ac) {
        a += (m8244a(b, c, d) + x) + ac;
        return ((long) ((((int) a) << ((int) s)) | (((int) a) >>> ((int) (32 - s))))) + b;
    }

    /* renamed from: b */
    private long m8251b(long a, long b, long c, long d, long x, long s, long ac) {
        a += (m8250b(b, c, d) + x) + ac;
        return ((long) ((((int) a) << ((int) s)) | (((int) a) >>> ((int) (32 - s))))) + b;
    }

    /* renamed from: c */
    private long m8256c(long a, long b, long c, long d, long x, long s, long ac) {
        a += (m8255c(b, c, d) + x) + ac;
        return ((long) ((((int) a) << ((int) s)) | (((int) a) >>> ((int) (32 - s))))) + b;
    }

    /* renamed from: d */
    private long m8261d(long a, long b, long c, long d, long x, long s, long ac) {
        a += (m8260d(b, c, d) + x) + ac;
        return ((long) ((((int) a) << ((int) s)) | (((int) a) >>> ((int) (32 - s))))) + b;
    }

    /* renamed from: a */
    public void m8263a(byte[] inbuf, int inputLen) {
        int i;
        byte[] block = new byte[64];
        int index = ((int) (this.f6965t[0] >>> 3)) & 63;
        long[] jArr = this.f6965t;
        long j = jArr[0] + ((long) (inputLen << 3));
        jArr[0] = j;
        if (j < ((long) (inputLen << 3))) {
            jArr = this.f6965t;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.f6965t;
        jArr[1] = jArr[1] + ((long) (inputLen >>> 29));
        int partLen = 64 - index;
        if (inputLen >= partLen) {
            m8246a(this.f6966u, inbuf, index, 0, partLen);
            m8262d(this.f6966u);
            i = partLen;
            while (i + 63 < inputLen) {
                m8246a(block, inbuf, 0, i, 64);
                m8262d(block);
                i += 64;
            }
            index = 0;
        } else {
            i = 0;
        }
        m8246a(this.f6966u, inbuf, index, i, inputLen - i);
    }

    /* renamed from: c */
    public void m8267c() {
        byte[] bits = new byte[8];
        m8247a(bits, this.f6965t, 8);
        int index = ((int) (this.f6965t[0] >>> 3)) & 63;
        m8263a(f6962q, index < 56 ? 56 - index : 120 - index);
        m8263a(bits, 8);
        m8247a(this.f6967v, this.f6964s, 16);
    }

    /* renamed from: a */
    private void m8246a(byte[] output, byte[] input, int outpos, int inpos, int len) {
        for (int i = 0; i < len; i++) {
            output[outpos + i] = input[inpos + i];
        }
    }

    /* renamed from: d */
    private void m8262d(byte[] block) {
        long a = this.f6964s[0];
        long b = this.f6964s[1];
        long c = this.f6964s[2];
        long d = this.f6964s[3];
        long[] x = new long[16];
        m8248a(x, block, 64);
        a = m8245a(a, b, c, d, x[0], 7, 3614090360L);
        d = m8245a(d, a, b, c, x[1], 12, 3905402710L);
        c = m8245a(c, d, a, b, x[2], 17, 606105819);
        b = m8245a(b, c, d, a, x[3], 22, 3250441966L);
        a = m8245a(a, b, c, d, x[4], 7, 4118548399L);
        d = m8245a(d, a, b, c, x[5], 12, 1200080426);
        c = m8245a(c, d, a, b, x[6], 17, 2821735955L);
        b = m8245a(b, c, d, a, x[7], 22, 4249261313L);
        a = m8245a(a, b, c, d, x[8], 7, 1770035416);
        d = m8245a(d, a, b, c, x[9], 12, 2336552879L);
        c = m8245a(c, d, a, b, x[10], 17, 4294925233L);
        b = m8245a(b, c, d, a, x[11], 22, 2304563134L);
        a = m8245a(a, b, c, d, x[12], 7, 1804603682);
        d = m8245a(d, a, b, c, x[13], 12, 4254626195L);
        c = m8245a(c, d, a, b, x[14], 17, 2792965006L);
        b = m8245a(b, c, d, a, x[15], 22, 1236535329);
        a = m8251b(a, b, c, d, x[1], 5, 4129170786L);
        d = m8251b(d, a, b, c, x[6], 9, 3225465664L);
        c = m8251b(c, d, a, b, x[11], 14, 643717713);
        b = m8251b(b, c, d, a, x[0], 20, 3921069994L);
        a = m8251b(a, b, c, d, x[5], 5, 3593408605L);
        d = m8251b(d, a, b, c, x[10], 9, 38016083);
        c = m8251b(c, d, a, b, x[15], 14, 3634488961L);
        b = m8251b(b, c, d, a, x[4], 20, 3889429448L);
        a = m8251b(a, b, c, d, x[9], 5, 568446438);
        d = m8251b(d, a, b, c, x[14], 9, 3275163606L);
        c = m8251b(c, d, a, b, x[3], 14, 4107603335L);
        b = m8251b(b, c, d, a, x[8], 20, 1163531501);
        a = m8251b(a, b, c, d, x[13], 5, 2850285829L);
        d = m8251b(d, a, b, c, x[2], 9, 4243563512L);
        c = m8251b(c, d, a, b, x[7], 14, 1735328473);
        b = m8251b(b, c, d, a, x[12], 20, 2368359562L);
        a = m8256c(a, b, c, d, x[5], 4, 4294588738L);
        d = m8256c(d, a, b, c, x[8], 11, 2272392833L);
        c = m8256c(c, d, a, b, x[11], 16, 1839030562);
        b = m8256c(b, c, d, a, x[14], 23, 4259657740L);
        a = m8256c(a, b, c, d, x[1], 4, 2763975236L);
        d = m8256c(d, a, b, c, x[4], 11, 1272893353);
        c = m8256c(c, d, a, b, x[7], 16, 4139469664L);
        b = m8256c(b, c, d, a, x[10], 23, 3200236656L);
        a = m8256c(a, b, c, d, x[13], 4, 681279174);
        d = m8256c(d, a, b, c, x[0], 11, 3936430074L);
        c = m8256c(c, d, a, b, x[3], 16, 3572445317L);
        b = m8256c(b, c, d, a, x[6], 23, 76029189);
        a = m8256c(a, b, c, d, x[9], 4, 3654602809L);
        d = m8256c(d, a, b, c, x[12], 11, 3873151461L);
        c = m8256c(c, d, a, b, x[15], 16, 530742520);
        b = m8256c(b, c, d, a, x[2], 23, 3299628645L);
        a = m8261d(a, b, c, d, x[0], 6, 4096336452L);
        d = m8261d(d, a, b, c, x[7], 10, 1126891415);
        c = m8261d(c, d, a, b, x[14], 15, 2878612391L);
        b = m8261d(b, c, d, a, x[5], 21, 4237533241L);
        a = m8261d(a, b, c, d, x[12], 6, 1700485571);
        d = m8261d(d, a, b, c, x[3], 10, 2399980690L);
        c = m8261d(c, d, a, b, x[10], 15, 4293915773L);
        b = m8261d(b, c, d, a, x[1], 21, 2240044497L);
        a = m8261d(a, b, c, d, x[8], 6, 1873313359);
        d = m8261d(d, a, b, c, x[15], 10, 4264355552L);
        c = m8261d(c, d, a, b, x[6], 15, 2734768916L);
        b = m8261d(b, c, d, a, x[13], 21, 1309151649);
        a = m8261d(a, b, c, d, x[4], 6, 4149444226L);
        d = m8261d(d, a, b, c, x[11], 10, 3174756917L);
        c = m8261d(c, d, a, b, x[2], 15, 718787259);
        b = m8261d(b, c, d, a, x[9], 21, 3951481745L);
        long[] jArr = this.f6964s;
        jArr[0] = jArr[0] + a;
        jArr = this.f6964s;
        jArr[1] = jArr[1] + b;
        jArr = this.f6964s;
        jArr[2] = jArr[2] + c;
        jArr = this.f6964s;
        jArr[3] = jArr[3] + d;
    }

    /* renamed from: a */
    private void m8247a(byte[] output, long[] input, int len) {
        int i = 0;
        for (int j = 0; j < len; j += 4) {
            output[j] = (byte) ((int) (input[i] & 255));
            output[j + 1] = (byte) ((int) ((input[i] >>> 8) & 255));
            output[j + 2] = (byte) ((int) ((input[i] >>> 16) & 255));
            output[j + 3] = (byte) ((int) ((input[i] >>> 24) & 255));
            i++;
        }
    }

    /* renamed from: a */
    private void m8248a(long[] output, byte[] input, int len) {
        int i = 0;
        for (int j = 0; j < len; j += 4) {
            output[i] = ((C2176g.m8243a(input[j]) | (C2176g.m8243a(input[j + 1]) << 8)) | (C2176g.m8243a(input[j + 2]) << 16)) | (C2176g.m8243a(input[j + 3]) << 24);
            i++;
        }
    }

    /* renamed from: a */
    public static long m8243a(byte b) {
        return b < (byte) 0 ? (long) (b & 255) : (long) b;
    }

    /* renamed from: b */
    public static String m8252b(byte ib) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{Digit[(ib >>> 4) & 15], Digit[ib & 15]});
    }

    /* renamed from: c */
    public static String m8257c(byte ib) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return new String(new char[]{Digit[(ib >>> 4) & 15], Digit[ib & 15]});
    }

    /* renamed from: b */
    public static byte[] m8254b(byte[] src) {
        return new C2176g().m8265a(src);
    }

    /* renamed from: a */
    public static byte[] m8249a(String source) {
        byte[] src;
        try {
            src = source.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            src = source.getBytes();
        }
        return new C2176g().m8265a(src);
    }

    /* renamed from: c */
    public static String m8259c(byte[] src) {
        byte[] dst = new C2176g().m8265a(src);
        String result = "";
        for (int i = 0; i < 16; i++) {
            result = result + C2176g.m8252b(dst[i]);
        }
        return result;
    }

    /* renamed from: b */
    public static String m8253b(String source) {
        byte[] src;
        try {
            src = source.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            src = source.getBytes();
        }
        byte[] dst = new C2176g().m8265a(src);
        String result = "";
        for (int i = 0; i < 16; i++) {
            result = result + C2176g.m8252b(dst[i]);
        }
        return result;
    }

    /* renamed from: c */
    public static String m8258c(String source) {
        byte[] src;
        try {
            src = source.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            src = source.getBytes();
        }
        byte[] dst = new C2176g().m8265a(src);
        String result = "";
        for (int i = 0; i < 16; i++) {
            result = result + C2176g.m8257c(dst[i]);
        }
        return result;
    }
}
