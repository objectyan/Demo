package com.baidu.tts.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class CommonUtility {
    public static String generateSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public static byte[] shortArrayToByteArray(short[] shortArray) {
        int length = shortArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(shortArray.length * 2);
        allocate.clear();
        allocate.order(ByteOrder.nativeOrder());
        for (int i = 0; i < length; i++) {
            allocate.putShort(i * 2, shortArray[i]);
        }
        return allocate.array();
    }

    public static int indexOf(byte[] data, byte[] pattern, int start) {
        try {
            int[] a = m17514a(pattern);
            int i = 0;
            if (data.length == 0 || start >= data.length) {
                return -1;
            }
            while (start < data.length) {
                while (i > 0 && pattern[i] != data[start]) {
                    i = a[i - 1];
                }
                if (pattern[i] == data[start]) {
                    i++;
                }
                if (i == pattern.length) {
                    return (start - pattern.length) + 1;
                }
                start++;
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: a */
    private static int[] m17514a(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i = 0;
        int i2 = 1;
        while (i2 < bArr.length) {
            while (i > 0 && bArr[i] != bArr[i2]) {
                i = iArr[i - 1];
            }
            if (bArr[i] == bArr[i2]) {
                i++;
            }
            iArr[i2] = i;
            i2++;
        }
        return iArr;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public static byte[] copyBytesOfRange(byte[] source, int start, int end) {
        if (start > end || start < 0 || end < 0 || end > source.length) {
            return null;
        }
        byte[] bArr = new byte[(end - start)];
        for (int i = start; i < end; i++) {
            bArr[i - start] = source[i];
        }
        return bArr;
    }

    public static byte[] addCAFHeaderForPCMData(byte[] pcmData) {
        if (pcmData == null || pcmData.length == 0) {
            return null;
        }
        long length = ((16 * (44 + ((long) pcmData.length))) * ((long) 1)) / 8;
        Object obj = new byte[]{(byte) 82, (byte) 73, (byte) 70, (byte) 70, (byte) ((int) (255 & r4)), (byte) ((int) ((r4 >> 8) & 255)), (byte) ((int) ((r4 >> 16) & 255)), (byte) ((int) ((r4 >> 24) & 255)), (byte) 87, (byte) 65, (byte) 86, (byte) 69, (byte) 102, (byte) 109, (byte) 116, (byte) 32, (byte) 16, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) ((int) (255 & 16000)), (byte) ((int) ((16000 >> 8) & 255)), (byte) ((int) ((16000 >> 16) & 255)), (byte) ((int) ((16000 >> 24) & 255)), (byte) ((int) (255 & length)), (byte) ((int) ((length >> 8) & 255)), (byte) ((int) ((length >> 16) & 255)), (byte) ((int) ((length >> 24) & 255)), (byte) 2, (byte) 0, (byte) 16, (byte) 0, (byte) 100, (byte) 97, (byte) 116, (byte) 97, (byte) ((int) (255 & r2)), (byte) ((int) ((r2 >> 8) & 255)), (byte) ((int) ((r2 >> 16) & 255)), (byte) ((int) ((((long) pcmData.length) >> 24) & 255))};
        byte[] bArr = new byte[(obj.length + pcmData.length)];
        System.arraycopy(obj, 0, bArr, 0, obj.length);
        System.arraycopy(pcmData, 0, bArr, obj.length, pcmData.length);
        return bArr;
    }
}
