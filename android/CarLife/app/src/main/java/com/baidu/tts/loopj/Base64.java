package com.baidu.tts.loopj;

import java.io.UnsupportedEncodingException;

public class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    static class Decoder extends Coder {
        private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int flags, byte[] output) {
            this.output = output;
            this.alphabet = (flags & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        public int maxOutputSize(int len) {
            return ((len * 3) / 4) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r10, int r11, int r12, boolean r13) {
            /*
            r9 = this;
            r0 = r9.state;
            r1 = 6;
            if (r0 != r1) goto L_0x0007;
        L_0x0005:
            r0 = 0;
        L_0x0006:
            return r0;
        L_0x0007:
            r12 = r12 + r11;
            r3 = r9.state;
            r1 = r9.value;
            r0 = 0;
            r4 = r9.output;
            r5 = r9.alphabet;
            r2 = r11;
        L_0x0012:
            if (r2 >= r12) goto L_0x0132;
        L_0x0014:
            if (r3 != 0) goto L_0x0066;
        L_0x0016:
            r6 = r2 + 4;
            if (r6 > r12) goto L_0x0059;
        L_0x001a:
            r1 = r10[r2];
            r1 = r1 & 255;
            r1 = r5[r1];
            r1 = r1 << 18;
            r6 = r2 + 1;
            r6 = r10[r6];
            r6 = r6 & 255;
            r6 = r5[r6];
            r6 = r6 << 12;
            r1 = r1 | r6;
            r6 = r2 + 2;
            r6 = r10[r6];
            r6 = r6 & 255;
            r6 = r5[r6];
            r6 = r6 << 6;
            r1 = r1 | r6;
            r6 = r2 + 3;
            r6 = r10[r6];
            r6 = r6 & 255;
            r6 = r5[r6];
            r1 = r1 | r6;
            if (r1 < 0) goto L_0x0059;
        L_0x0043:
            r6 = r0 + 2;
            r7 = (byte) r1;
            r4[r6] = r7;
            r6 = r0 + 1;
            r7 = r1 >> 8;
            r7 = (byte) r7;
            r4[r6] = r7;
            r6 = r1 >> 16;
            r6 = (byte) r6;
            r4[r0] = r6;
            r0 = r0 + 3;
            r2 = r2 + 4;
            goto L_0x0016;
        L_0x0059:
            if (r2 < r12) goto L_0x0066;
        L_0x005b:
            r2 = r1;
        L_0x005c:
            if (r13 != 0) goto L_0x0104;
        L_0x005e:
            r9.state = r3;
            r9.value = r2;
            r9.op = r0;
            r0 = 1;
            goto L_0x0006;
        L_0x0066:
            r11 = r2 + 1;
            r2 = r10[r2];
            r2 = r2 & 255;
            r2 = r5[r2];
            switch(r3) {
                case 0: goto L_0x0075;
                case 1: goto L_0x0085;
                case 2: goto L_0x0096;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00ec;
                case 5: goto L_0x00fb;
                default: goto L_0x0071;
            };
        L_0x0071:
            r2 = r3;
        L_0x0072:
            r3 = r2;
            r2 = r11;
            goto L_0x0012;
        L_0x0075:
            if (r2 < 0) goto L_0x007d;
        L_0x0077:
            r1 = r3 + 1;
            r8 = r2;
            r2 = r1;
            r1 = r8;
            goto L_0x0072;
        L_0x007d:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x0080:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0085:
            if (r2 < 0) goto L_0x008d;
        L_0x0087:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r3 + 1;
            goto L_0x0072;
        L_0x008d:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x0090:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0096:
            if (r2 < 0) goto L_0x009e;
        L_0x0098:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r3 + 1;
            goto L_0x0072;
        L_0x009e:
            r6 = -2;
            if (r2 != r6) goto L_0x00ad;
        L_0x00a1:
            r2 = r0 + 1;
            r3 = r1 >> 4;
            r3 = (byte) r3;
            r4[r0] = r3;
            r0 = 4;
            r8 = r2;
            r2 = r0;
            r0 = r8;
            goto L_0x0072;
        L_0x00ad:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x00b0:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00b6:
            if (r2 < 0) goto L_0x00d0;
        L_0x00b8:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r0 + 2;
            r3 = (byte) r1;
            r4[r2] = r3;
            r2 = r0 + 1;
            r3 = r1 >> 8;
            r3 = (byte) r3;
            r4[r2] = r3;
            r2 = r1 >> 16;
            r2 = (byte) r2;
            r4[r0] = r2;
            r0 = r0 + 3;
            r2 = 0;
            goto L_0x0072;
        L_0x00d0:
            r6 = -2;
            if (r2 != r6) goto L_0x00e3;
        L_0x00d3:
            r2 = r0 + 1;
            r3 = r1 >> 2;
            r3 = (byte) r3;
            r4[r2] = r3;
            r2 = r1 >> 10;
            r2 = (byte) r2;
            r4[r0] = r2;
            r0 = r0 + 2;
            r2 = 5;
            goto L_0x0072;
        L_0x00e3:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x00e6:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00ec:
            r6 = -2;
            if (r2 != r6) goto L_0x00f2;
        L_0x00ef:
            r2 = r3 + 1;
            goto L_0x0072;
        L_0x00f2:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x00f5:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x00fb:
            r6 = -1;
            if (r2 == r6) goto L_0x0071;
        L_0x00fe:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0104:
            switch(r3) {
                case 0: goto L_0x0107;
                case 1: goto L_0x010e;
                case 2: goto L_0x0114;
                case 3: goto L_0x011d;
                case 4: goto L_0x012c;
                default: goto L_0x0107;
            };
        L_0x0107:
            r9.state = r3;
            r9.op = r0;
            r0 = 1;
            goto L_0x0006;
        L_0x010e:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0114:
            r1 = r0 + 1;
            r2 = r2 >> 4;
            r2 = (byte) r2;
            r4[r0] = r2;
            r0 = r1;
            goto L_0x0107;
        L_0x011d:
            r1 = r0 + 1;
            r5 = r2 >> 10;
            r5 = (byte) r5;
            r4[r0] = r5;
            r0 = r1 + 1;
            r2 = r2 >> 2;
            r2 = (byte) r2;
            r4[r1] = r2;
            goto L_0x0107;
        L_0x012c:
            r0 = 6;
            r9.state = r0;
            r0 = 0;
            goto L_0x0006;
        L_0x0132:
            r2 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.loopj.Base64.Decoder.process(byte[], int, int, boolean):boolean");
        }
    }

    static class Encoder extends Coder {
        private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int flags, byte[] output) {
            boolean z;
            boolean z2 = true;
            this.output = output;
            this.do_padding = (flags & 1) == 0;
            if ((flags & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.do_newline = z;
            if ((flags & 4) == 0) {
                z2 = false;
            }
            this.do_cr = z2;
            this.alphabet = (flags & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        public int maxOutputSize(int len) {
            return ((len * 8) / 5) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r10, int r11, int r12, boolean r13) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
            /*
            r9 = this;
            r6 = r9.alphabet;
            r7 = r9.output;
            r1 = 0;
            r0 = r9.count;
            r12 = r12 + r11;
            r2 = -1;
            r3 = r9.tailLen;
            switch(r3) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x00a9;
                case 2: goto L_0x00cc;
                default: goto L_0x000e;
            };
        L_0x000e:
            r3 = r11;
        L_0x000f:
            r4 = -1;
            if (r2 == r4) goto L_0x021f;
        L_0x0012:
            r4 = 1;
            r5 = r2 >> 18;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r1] = r5;
            r1 = 2;
            r5 = r2 >> 12;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r4] = r5;
            r4 = 3;
            r5 = r2 >> 6;
            r5 = r5 & 63;
            r5 = r6[r5];
            r7[r1] = r5;
            r1 = 4;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r4] = r2;
            r0 = r0 + -1;
            if (r0 != 0) goto L_0x021f;
        L_0x0038:
            r0 = r9.do_cr;
            if (r0 == 0) goto L_0x0223;
        L_0x003c:
            r0 = 5;
            r2 = 13;
            r7[r1] = r2;
        L_0x0041:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = 19;
            r5 = r0;
            r4 = r1;
        L_0x004b:
            r0 = r3 + 3;
            if (r0 > r12) goto L_0x00ef;
        L_0x004f:
            r0 = r10[r3];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r3 + 1;
            r1 = r10[r1];
            r1 = r1 & 255;
            r1 = r1 << 8;
            r0 = r0 | r1;
            r1 = r3 + 2;
            r1 = r10[r1];
            r1 = r1 & 255;
            r0 = r0 | r1;
            r1 = r0 >> 18;
            r1 = r1 & 63;
            r1 = r6[r1];
            r7[r4] = r1;
            r1 = r4 + 1;
            r2 = r0 >> 12;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r1] = r2;
            r1 = r4 + 2;
            r2 = r0 >> 6;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r1] = r2;
            r1 = r4 + 3;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r1] = r0;
            r3 = r3 + 3;
            r1 = r4 + 4;
            r0 = r5 + -1;
            if (r0 != 0) goto L_0x021f;
        L_0x0091:
            r0 = r9.do_cr;
            if (r0 == 0) goto L_0x021c;
        L_0x0095:
            r0 = r1 + 1;
            r2 = 13;
            r7[r1] = r2;
        L_0x009b:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = 19;
            r5 = r0;
            r4 = r1;
            goto L_0x004b;
        L_0x00a6:
            r3 = r11;
            goto L_0x000f;
        L_0x00a9:
            r3 = r11 + 2;
            if (r3 > r12) goto L_0x000e;
        L_0x00ad:
            r2 = r9.tail;
            r3 = 0;
            r2 = r2[r3];
            r2 = r2 & 255;
            r2 = r2 << 16;
            r3 = r11 + 1;
            r4 = r10[r11];
            r4 = r4 & 255;
            r4 = r4 << 8;
            r2 = r2 | r4;
            r11 = r3 + 1;
            r3 = r10[r3];
            r3 = r3 & 255;
            r2 = r2 | r3;
            r3 = 0;
            r9.tailLen = r3;
            r3 = r11;
            goto L_0x000f;
        L_0x00cc:
            r3 = r11 + 1;
            if (r3 > r12) goto L_0x000e;
        L_0x00d0:
            r2 = r9.tail;
            r3 = 0;
            r2 = r2[r3];
            r2 = r2 & 255;
            r2 = r2 << 16;
            r3 = r9.tail;
            r4 = 1;
            r3 = r3[r4];
            r3 = r3 & 255;
            r3 = r3 << 8;
            r2 = r2 | r3;
            r3 = r11 + 1;
            r4 = r10[r11];
            r4 = r4 & 255;
            r2 = r2 | r4;
            r4 = 0;
            r9.tailLen = r4;
            goto L_0x000f;
        L_0x00ef:
            if (r13 == 0) goto L_0x01e6;
        L_0x00f1:
            r0 = r9.tailLen;
            r0 = r3 - r0;
            r1 = r12 + -1;
            if (r0 != r1) goto L_0x0151;
        L_0x00f9:
            r2 = 0;
            r0 = r9.tailLen;
            if (r0 <= 0) goto L_0x014b;
        L_0x00fe:
            r0 = r9.tail;
            r1 = 1;
            r0 = r0[r2];
        L_0x0103:
            r0 = r0 & 255;
            r2 = r0 << 4;
            r0 = r9.tailLen;
            r0 = r0 - r1;
            r9.tailLen = r0;
            r1 = r4 + 1;
            r0 = r2 >> 6;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r4] = r0;
            r0 = r1 + 1;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r1] = r2;
            r1 = r9.do_padding;
            if (r1 == 0) goto L_0x012e;
        L_0x0122:
            r1 = r0 + 1;
            r2 = 61;
            r7[r0] = r2;
            r0 = r1 + 1;
            r2 = 61;
            r7[r1] = r2;
        L_0x012e:
            r1 = r9.do_newline;
            if (r1 == 0) goto L_0x0144;
        L_0x0132:
            r1 = r9.do_cr;
            if (r1 == 0) goto L_0x013d;
        L_0x0136:
            r1 = r0 + 1;
            r2 = 13;
            r7[r0] = r2;
            r0 = r1;
        L_0x013d:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = r1;
        L_0x0144:
            r4 = r0;
        L_0x0145:
            r9.op = r4;
            r9.count = r5;
            r0 = 1;
            return r0;
        L_0x014b:
            r0 = r3 + 1;
            r0 = r10[r3];
            r1 = r2;
            goto L_0x0103;
        L_0x0151:
            r0 = r9.tailLen;
            r0 = r3 - r0;
            r1 = r12 + -2;
            if (r0 != r1) goto L_0x01ca;
        L_0x0159:
            r2 = 0;
            r0 = r9.tailLen;
            r1 = 1;
            if (r0 <= r1) goto L_0x01bd;
        L_0x015f:
            r0 = r9.tail;
            r1 = 1;
            r0 = r0[r2];
            r2 = r3;
        L_0x0165:
            r0 = r0 & 255;
            r3 = r0 << 10;
            r0 = r9.tailLen;
            if (r0 <= 0) goto L_0x01c5;
        L_0x016d:
            r0 = r9.tail;
            r2 = r1 + 1;
            r0 = r0[r1];
            r1 = r2;
        L_0x0174:
            r0 = r0 & 255;
            r0 = r0 << 2;
            r0 = r0 | r3;
            r2 = r9.tailLen;
            r1 = r2 - r1;
            r9.tailLen = r1;
            r1 = r4 + 1;
            r2 = r0 >> 12;
            r2 = r2 & 63;
            r2 = r6[r2];
            r7[r4] = r2;
            r2 = r1 + 1;
            r3 = r0 >> 6;
            r3 = r3 & 63;
            r3 = r6[r3];
            r7[r1] = r3;
            r1 = r2 + 1;
            r0 = r0 & 63;
            r0 = r6[r0];
            r7[r2] = r0;
            r0 = r9.do_padding;
            if (r0 == 0) goto L_0x021a;
        L_0x019f:
            r0 = r1 + 1;
            r2 = 61;
            r7[r1] = r2;
        L_0x01a5:
            r1 = r9.do_newline;
            if (r1 == 0) goto L_0x01bb;
        L_0x01a9:
            r1 = r9.do_cr;
            if (r1 == 0) goto L_0x01b4;
        L_0x01ad:
            r1 = r0 + 1;
            r2 = 13;
            r7[r0] = r2;
            r0 = r1;
        L_0x01b4:
            r1 = r0 + 1;
            r2 = 10;
            r7[r0] = r2;
            r0 = r1;
        L_0x01bb:
            r4 = r0;
            goto L_0x0145;
        L_0x01bd:
            r1 = r3 + 1;
            r0 = r10[r3];
            r8 = r2;
            r2 = r1;
            r1 = r8;
            goto L_0x0165;
        L_0x01c5:
            r0 = r2 + 1;
            r0 = r10[r2];
            goto L_0x0174;
        L_0x01ca:
            r0 = r9.do_newline;
            if (r0 == 0) goto L_0x0145;
        L_0x01ce:
            if (r4 <= 0) goto L_0x0145;
        L_0x01d0:
            r0 = 19;
            if (r5 == r0) goto L_0x0145;
        L_0x01d4:
            r0 = r9.do_cr;
            if (r0 == 0) goto L_0x0218;
        L_0x01d8:
            r0 = r4 + 1;
            r1 = 13;
            r7[r4] = r1;
        L_0x01de:
            r4 = r0 + 1;
            r1 = 10;
            r7[r0] = r1;
            goto L_0x0145;
        L_0x01e6:
            r0 = r12 + -1;
            if (r3 != r0) goto L_0x01f8;
        L_0x01ea:
            r0 = r9.tail;
            r1 = r9.tailLen;
            r2 = r1 + 1;
            r9.tailLen = r2;
            r2 = r10[r3];
            r0[r1] = r2;
            goto L_0x0145;
        L_0x01f8:
            r0 = r12 + -2;
            if (r3 != r0) goto L_0x0145;
        L_0x01fc:
            r0 = r9.tail;
            r1 = r9.tailLen;
            r2 = r1 + 1;
            r9.tailLen = r2;
            r2 = r10[r3];
            r0[r1] = r2;
            r0 = r9.tail;
            r1 = r9.tailLen;
            r2 = r1 + 1;
            r9.tailLen = r2;
            r2 = r3 + 1;
            r2 = r10[r2];
            r0[r1] = r2;
            goto L_0x0145;
        L_0x0218:
            r0 = r4;
            goto L_0x01de;
        L_0x021a:
            r0 = r1;
            goto L_0x01a5;
        L_0x021c:
            r0 = r1;
            goto L_0x009b;
        L_0x021f:
            r5 = r0;
            r4 = r1;
            goto L_0x004b;
        L_0x0223:
            r0 = r1;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.loopj.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(), flags);
    }

    public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder decoder = new Decoder(flags, new byte[((len * 3) / 4)]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (decoder.op == decoder.output.length) {
            return decoder.output;
        } else {
            byte[] bArr = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
            return bArr;
        }
    }

    public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);
        int i = (len / 3) * 4;
        if (!encoder.do_padding) {
            switch (len % 3) {
                case 0:
                    break;
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 3;
                    break;
                default:
                    break;
            }
        } else if (len % 3 > 0) {
            i += 4;
        }
        if (encoder.do_newline && len > 0) {
            int i2;
            int i3 = ((len - 1) / 57) + 1;
            if (encoder.do_cr) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            i += i2 * i3;
        }
        encoder.output = new byte[i];
        encoder.process(input, offset, len, true);
        return encoder.output;
    }

    private Base64() {
    }
}
