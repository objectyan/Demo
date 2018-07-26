package com.baidu.platform.comapi.util;

import android.text.TextUtils;
import java.io.File;

/* compiled from: ComSecureUtils */
/* renamed from: com.baidu.platform.comapi.util.c */
public class C4819c {
    /* renamed from: a */
    private static byte[] f19954a = new byte[]{(byte) 52, (byte) 77, (byte) 55, (byte) 32, (byte) 126, (byte) 67, (byte) 51, (byte) 30, (byte) 120, (byte) 98, (byte) 25, (byte) 37, (byte) 65, (byte) 113, (byte) 68, (byte) 116};

    /* renamed from: a */
    public static String m16000a(String filePath) throws Exception {
        if (TextUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("com file path empty!");
        }
        File tmpFile = new File(filePath);
        if (!tmpFile.exists()) {
            return null;
        }
        String str1 = MD5.getFileMD5String(tmpFile);
        if (TextUtils.isEmpty(str1)) {
            return null;
        }
        C2911f.e("ComSecure", "file md5>>" + str1);
        byte[] encData = C4794a.m15887a(new String(f19954a), str1.getBytes());
        if (encData == null) {
            return null;
        }
        String resultStr = C4799b.m15938a(encData);
        C2911f.e("ComSecure", "md5 aes>>" + new String(encData));
        C2911f.e("ComSecure", "aes b64>>" + resultStr);
        return resultStr;
    }
}
