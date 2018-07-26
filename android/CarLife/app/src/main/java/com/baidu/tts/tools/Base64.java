package com.baidu.tts.tools;

import java.io.UnsupportedEncodingException;

public final class Base64 {
    /* renamed from: a */
    private static final byte[] f21300a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    public static byte[] decode(byte[] paramArrayOfByte) {
        return decode(paramArrayOfByte, paramArrayOfByte.length);
    }

    public static byte[] decode(byte[] paramArrayOfByte, int paramInt) {
        int i = (paramInt / 4) * 3;
        if (i == 0) {
            return new byte[0];
        }
        int i2;
        Object obj = new byte[i];
        i = 0;
        while (true) {
            byte b = paramArrayOfByte[paramInt - 1];
            if (!(b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9)) {
                if (b != (byte) 61) {
                    break;
                }
                i++;
            }
            paramInt--;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < paramInt) {
            b = paramArrayOfByte[i3];
            if (b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9) {
                i2 = i4;
                i4 = i6;
                i6 = i5;
            } else {
                if (b >= (byte) 65 && b <= (byte) 90) {
                    i2 = b - 65;
                } else if (b >= (byte) 97 && b <= (byte) 122) {
                    i2 = b - 71;
                } else if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b + 4;
                } else if (b == (byte) 43) {
                    i2 = 62;
                } else if (b != (byte) 47) {
                    return null;
                } else {
                    i2 = 63;
                }
                i4 = (i4 << 6) | ((byte) i2);
                if (i5 % 4 == 3) {
                    i2 = i6 + 1;
                    obj[i6] = (byte) ((16711680 & i4) >> 16);
                    i6 = i2 + 1;
                    obj[i2] = (byte) ((65280 & i4) >> 8);
                    i2 = i6 + 1;
                    obj[i6] = (byte) (i4 & 255);
                } else {
                    i2 = i6;
                }
                i6 = i5 + 1;
                int i7 = i4;
                i4 = i2;
                i2 = i7;
            }
            i3++;
            i5 = i6;
            i6 = i4;
            i4 = i2;
        }
        if (i > 0) {
            i4 <<= i * 6;
            i2 = i6 + 1;
            obj[i6] = (byte) ((16711680 & i4) >> 16);
            if (i == 1) {
                i6 = i2 + 1;
                obj[i2] = (byte) ((65280 & i4) >> 8);
            } else {
                i6 = i2;
            }
        }
        byte[] bArr = new byte[i6];
        System.arraycopy(obj, 0, bArr, 0, i6);
        return bArr;
    }

    public static String encode(byte[] paramArrayOfByte, String paramString) throws UnsupportedEncodingException {
        int length = (paramArrayOfByte.length * 4) / 3;
        byte[] bArr = new byte[(length + ((length / 76) + 3))];
        int length2 = paramArrayOfByte.length - (paramArrayOfByte.length % 3);
        length = 0;
        int i = 0;
        for (int i2 = 0; i2 < length2; i2 += 3) {
            int i3 = i + 1;
            bArr[i] = f21300a[(paramArrayOfByte[i2] & 255) >> 2];
            i = i3 + 1;
            bArr[i3] = f21300a[((paramArrayOfByte[i2] & 3) << 4) | ((paramArrayOfByte[i2 + 1] & 255) >> 4)];
            int i4 = i + 1;
            bArr[i] = f21300a[((paramArrayOfByte[i2 + 1] & 15) << 2) | ((paramArrayOfByte[i2 + 2] & 255) >> 6)];
            i3 = i4 + 1;
            bArr[i4] = f21300a[paramArrayOfByte[i2 + 2] & 63];
            if ((i3 - length) % 76 != 0 || i3 == 0) {
                i = i3;
            } else {
                i = i3 + 1;
                bArr[i3] = (byte) 10;
                length++;
            }
        }
        switch (paramArrayOfByte.length % 3) {
            case 1:
                length = i + 1;
                bArr[i] = f21300a[(paramArrayOfByte[length2] & 255) >> 2];
                i = length + 1;
                bArr[length] = f21300a[(paramArrayOfByte[length2] & 3) << 4];
                i3 = i + 1;
                bArr[i] = (byte) 61;
                length = i3 + 1;
                bArr[i3] = (byte) 61;
                break;
            case 2:
                length = i + 1;
                bArr[i] = f21300a[(paramArrayOfByte[length2] & 255) >> 2];
                i = length + 1;
                bArr[length] = f21300a[((paramArrayOfByte[length2] & 3) << 4) | ((paramArrayOfByte[length2 + 1] & 255) >> 4)];
                i3 = i + 1;
                bArr[i] = f21300a[(paramArrayOfByte[length2 + 1] & 15) << 2];
                length = i3 + 1;
                bArr[i3] = (byte) 61;
                break;
            default:
                length = i;
                break;
        }
        return new String(bArr, 0, length, paramString);
    }
}
