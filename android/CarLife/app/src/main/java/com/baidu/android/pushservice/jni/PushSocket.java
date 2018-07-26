package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.message.C0622h;
import com.baidu.android.pushservice.p031j.C0578p;

public class PushSocket {
    /* renamed from: a */
    public static boolean f1876a;
    /* renamed from: b */
    private static byte[] f1877b = null;
    /* renamed from: c */
    private static int f1878c = 0;
    /* renamed from: d */
    private static String f1879d = "PushSocket";
    /* renamed from: e */
    private static int f1880e = 36;
    /* renamed from: f */
    private static int f1881f = 32;

    static {
        f1876a = false;
        try {
            System.loadLibrary("bdpush_V2_9");
            f1876a = true;
        } catch (UnsatisfiedLinkError e) {
        }
    }

    /* renamed from: a */
    public static short m2621a(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] << 8) | (bArr[i + 0] & 255));
    }

    /* renamed from: a */
    public static void m2622a(int i) {
        f1877b = null;
        f1878c = 0;
        closeSocket(i);
    }

    /* renamed from: a */
    public static boolean m2623a(Context context) {
        if (!f1876a) {
            try {
                System.loadLibrary("bdpush_V2_9");
                f1876a = true;
            } catch (UnsatisfiedLinkError e) {
                Log.e("BDPushSDK-" + f1879d, "Native library not found! Please copy libbdpush_V2_9.so into your project!");
            }
        }
        return f1876a;
    }

    /* renamed from: a */
    public static byte[] m2624a(Context context, int i) {
        short a;
        Object obj;
        while (true) {
            if (f1877b != null) {
                int length = f1877b.length;
                if (length == f1878c) {
                    f1877b = null;
                    f1878c = 0;
                } else if (length - f1878c > 1) {
                    a = m2621a(f1877b, f1878c);
                    if (a == C0622h.MSG_ID_TINY_HEARTBEAT_CLIENT.m2744a() || a == C0622h.MSG_ID_TINY_HEARTBEAT_SERVER.m2744a()) {
                        obj = new byte[2];
                        System.arraycopy(f1877b, f1878c, obj, 0, obj.length);
                    } else if (length - f1878c < f1880e && !m2626b(i)) {
                        return null;
                    } else {
                        int b = m2625b(f1877b, f1878c + f1881f);
                        if ((f1878c + b) + f1880e <= length - f1878c) {
                            obj = new byte[(f1880e + b)];
                            System.arraycopy(f1877b, f1878c, obj, 0, obj.length);
                            f1878c += b + f1880e;
                            return obj;
                        } else if (!m2626b(i)) {
                            return null;
                        }
                    }
                } else if (!m2626b(i)) {
                    return null;
                }
            } else if (!m2626b(i)) {
                return null;
            }
        }
        obj = new byte[2];
        System.arraycopy(f1877b, f1878c, obj, 0, obj.length);
        if (a == C0622h.MSG_ID_TINY_HEARTBEAT_SERVER.m2744a()) {
            C0578p.m2546b("MSG_ID_TINY_HEARTBEAT_SERVER", context);
        }
        f1878c += 2;
        return obj;
    }

    /* renamed from: b */
    public static int m2625b(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 0] & 255) << 0);
    }

    /* renamed from: b */
    private static boolean m2626b(int i) {
        Object rcvMsg = rcvMsg(i);
        if (rcvMsg == null || rcvMsg.length == 0) {
            return false;
        }
        if (f1877b == null) {
            f1877b = rcvMsg;
        } else {
            Object obj = new byte[(f1877b.length + rcvMsg.length)];
            System.arraycopy(f1877b, f1878c, obj, 0, f1877b.length - f1878c);
            System.arraycopy(rcvMsg, 0, obj, f1877b.length, rcvMsg.length);
            f1877b = obj;
        }
        return true;
    }

    public static native int closeSocket(int i);

    public static native int createSocket(String str, int i);

    public static native int getLastSocketError();

    private static native byte[] rcvMsg(int i);

    public static native int sendMsg(int i, byte[] bArr, int i2);
}
