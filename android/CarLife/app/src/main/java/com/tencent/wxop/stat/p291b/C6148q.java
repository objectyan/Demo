package com.tencent.wxop.stat.p291b;

import java.io.File;

/* renamed from: com.tencent.wxop.stat.b.q */
class C6148q {
    /* renamed from: a */
    private static int f24964a = -1;

    /* renamed from: a */
    public static boolean m21909a() {
        if (f24964a == 1) {
            return true;
        }
        if (f24964a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 6) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    f24964a = 1;
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        f24964a = 0;
        return false;
    }
}
