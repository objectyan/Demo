package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.sapi2.C4891b;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: SapiDeviceUtils */
/* renamed from: com.baidu.sapi2.utils.e */
public class C4922e {

    /* compiled from: SapiDeviceUtils */
    /* renamed from: com.baidu.sapi2.utils.e$a */
    public static class C4921a {
        /* renamed from: a */
        private static final String f20546a = "MD5";
        /* renamed from: b */
        private static final String f20547b = "AES";
        /* renamed from: c */
        private static final String f20548c = "UTF-8";
        /* renamed from: d */
        private static final int f20549d = 16;
        /* renamed from: e */
        private static final int f20550e = 16;

        /* renamed from: b */
        private static byte[] m16408b(String payload) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(f20546a);
                messageDigest.update(payload.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                C4913L.m16374e(e);
                return null;
            }
        }

        /* renamed from: a */
        public static String m16405a(byte[] b) {
            StringBuilder sb = new StringBuilder();
            for (byte aB : b) {
                sb.append(Integer.toString((aB & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        }

        /* renamed from: b */
        public static String m16407b(byte[] bytes) {
            int remainBitCount;
            StringBuilder result = new StringBuilder();
            String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
            int prevByteBitCount = 0;
            int nextByteBitCount = 6;
            int i = 0;
            int n = 0;
            int byteCount = bytes.length * 8;
            byte b = (byte) 0;
            do {
                if (prevByteBitCount > 0 && nextByteBitCount > 0) {
                    b = (byte) (((byte) (((bytes[i] & 255) << nextByteBitCount) | ((bytes[i + 1] & 255) >> (8 - nextByteBitCount)))) & 63);
                    prevByteBitCount = 8 - nextByteBitCount;
                    nextByteBitCount = 6 - prevByteBitCount;
                } else if (prevByteBitCount == 0) {
                    b = (byte) ((bytes[i] & 255) >> (8 - nextByteBitCount));
                    prevByteBitCount = 2;
                    nextByteBitCount = 4;
                } else if (nextByteBitCount == 0) {
                    b = (byte) (bytes[i] & 63);
                    prevByteBitCount = 0;
                    nextByteBitCount = 6;
                }
                result.append(base64.charAt(b));
                n += 6;
                i = n / 8;
                remainBitCount = byteCount - n;
            } while (remainBitCount >= 6);
            if (remainBitCount > 0) {
                result.append(base64.charAt((byte) ((bytes[bytes.length - 1] << (6 - remainBitCount)) & 63)));
            }
            n = byteCount % 3;
            for (i = 0; i < n; i++) {
                result.append("=");
            }
            return result.toString();
        }

        /* renamed from: a */
        public static String m16403a(String deviceId) {
            if (TextUtils.isEmpty(deviceId)) {
                return null;
            }
            String cipher = null;
            String secretKey = C4923f.f20620y;
            try {
                String deviceIdBase64 = C4921a.m16407b(deviceId.getBytes("UTF-8"));
                return C4921a.m16404a(deviceIdBase64 + "." + C4921a.m16405a(C4921a.m16408b(deviceIdBase64 + secretKey)), secretKey);
            } catch (Exception e) {
                C4913L.m16374e(e);
                return cipher;
            }
        }

        /* renamed from: a */
        public static String m16404a(String content, String secretKey) {
            try {
                String secretStr = C4921a.m16405a(C4921a.m16408b(secretKey.trim()));
                String key = secretStr.substring(0, 16);
                String ivs = new StringBuffer(secretStr.substring(0, 16)).reverse().toString();
                Cipher cipher = Cipher.getInstance(C4923f.f20621z);
                cipher.init(1, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), new IvParameterSpec(ivs.getBytes("UTF-8")));
                return C4921a.m16407b(cipher.doFinal(C4921a.m16409c(content.getBytes("UTF-8"))));
            } catch (Exception e) {
                C4913L.m16374e(e);
                return null;
            }
        }

        /* renamed from: b */
        public static String m16406b(String content, String secretKey) {
            try {
                String secretStr = C4921a.m16405a(C4921a.m16408b(secretKey.trim()));
                String key = secretStr.substring(0, 16);
                String ivs = new StringBuffer(secretStr.substring(0, 16)).reverse().toString();
                Cipher cipher = Cipher.getInstance(C4923f.f20621z);
                cipher.init(2, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), new IvParameterSpec(ivs.getBytes("UTF-8")));
                return C4921a.m16407b(cipher.doFinal(C4921a.m16409c(content.getBytes("UTF-8"))));
            } catch (Exception e) {
                C4913L.m16374e(e);
                return null;
            }
        }

        /* renamed from: c */
        private static byte[] m16409c(byte[] data) {
            if (data.length % 16 == 0) {
                return data;
            }
            byte[] bArr = new byte[(((data.length / 16) + 1) * 16)];
            System.arraycopy(data, 0, bArr, 0, data.length);
            for (int i = data.length; i < bArr.length; i++) {
                bArr[i] = (byte) 0;
            }
            return bArr;
        }
    }

    /* renamed from: a */
    public static void m16411a(Context context) {
        if (context != null) {
            try {
                InputStream inputStream = new FileInputStream("/system/etc/hosts");
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                String hosts = new String(buffer);
                if (TextUtils.isEmpty(hosts) || !hosts.contains("passport.baidu.com")) {
                    C4891b.m16250a(context).m16273b(false);
                } else {
                    C4891b.m16250a(context).m16273b(true);
                }
                inputStream.close();
            } catch (Throwable e) {
                C4891b.m16250a(context).m16273b(false);
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: b */
    public static String m16413b(Context context) {
        if (context == null) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    /* renamed from: c */
    public static String m16415c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            WifiInfo info = ((WifiManager) context.getSystemService(C1981b.f6365e)).getConnectionInfo();
            return TextUtils.isEmpty(info.getMacAddress()) ? "" : info.getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m16410a() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(VERSION.RELEASE) ? "" : VERSION.RELEASE, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m16412b() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m16414c() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m16417d(Context context) {
        return MD5Util.toMd5((C4922e.m16413b(context) + C4922e.m16415c(context)).getBytes(), false).replace("\n", "");
    }

    /* renamed from: d */
    public static String m16416d() {
        return "os_version=" + C4922e.m16410a() + "&brand_name=" + C4922e.m16412b() + "&brand_model=" + C4922e.m16414c() + "&os_type=" + C1253f.jb;
    }
}
