package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.C2912a;

public final class URLEncodeUtils extends C2912a {

    /* renamed from: com.baidu.platform.comapi.util.URLEncodeUtils$a */
    public static class C4791a {
        /* renamed from: a */
        public static final int f19875a = 1;
        /* renamed from: b */
        public static final int f19876b = 2;
        /* renamed from: c */
        public static final int f19877c = 3;
    }

    private static native String nativeMD5Sign(String str);

    private static native String nativeOperSign(String str);

    private static native String nativeUrlEncode(String str);

    private static native String nativeWebSign(String str);

    public static String urlEncode(String str) {
        return nativeUrlEncode(str);
    }

    public static String generateSign(int type, String str) {
        if (type == 1) {
            return nativeMD5Sign(str);
        }
        if (type == 2) {
            return nativeWebSign(str);
        }
        if (type == 3) {
            return nativeOperSign(str);
        }
        return "";
    }

    public static String getMD5String(String param) {
        return MD5.getMD5String(param);
    }
}
