package com.baidu.android.pushservice.jni;

import android.content.Context;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0581a;
import com.baidu.android.pushservice.p032k.C0582b;

public class BaiduAppSSOJni {
    private static final String TAG = "BaiduAppSSOJni";

    static {
        try {
            System.loadLibrary("bdpush_V2_9");
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    public static native byte[] decryptR(byte[] bArr, int i);

    public static native byte[] encryptAES(String str, int i);

    public static native byte[] encryptR(byte[] bArr, int i);

    public static String getDecrypted(Context context, String str, String str2) {
        try {
            byte[] decrypted = getDecrypted(context, str, C0582b.m2630a(str2.getBytes()));
            if (decrypted != null && decrypted.length > 0) {
                return new String(decrypted, "utf-8");
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static byte[] getDecrypted(Context context, String str, byte[] bArr) {
        byte[] bArr2 = null;
        if (str == null) {
            try {
                str = "";
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
                C0578p.m2546b("UnsatisfiedLinkError getDecrypted ", context);
            }
        }
        byte[] key = getKey(str);
        if (key != null) {
            String str2 = new String(key, "utf-8");
            if (str2.length() > 0) {
                bArr2 = C0581a.m2628b(str2.substring(16), str2.substring(0, 16), bArr);
            }
        }
        return bArr2;
    }

    public static String getEncrypted(Context context, String str, String str2) {
        try {
            return C0582b.m2629a(getEncrypted(context, str, str2.getBytes()), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] getEncrypted(Context context, String str, byte[] bArr) {
        byte[] bArr2 = null;
        if (str == null) {
            try {
                str = "";
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
                C0578p.m2546b("UnsatisfiedLinkError getEncrypted " + bArr, context);
            }
        }
        byte[] key = getKey(str);
        if (key != null) {
            String str2 = new String(key, "utf-8");
            if (str2.length() > 0) {
                bArr2 = C0581a.m2627a(str2.substring(16), str2.substring(0, 16), bArr);
            }
        }
        return bArr2;
    }

    private static native byte[] getKey(String str);

    public static native boolean verify(byte[] bArr, String str, int i);
}
