package com.baidu.baidunavis.control;

import com.baidu.navisdk.util.common.LogUtil;

public class NavLogUtils {
    public static boolean LOGGABLE = false;

    /* renamed from: e */
    public static void m3003e(String moduleName, String str) {
        try {
            LogUtil.e(moduleName, str);
        } catch (Exception e) {
        }
    }

    public static String getCallStack() {
        return LogUtil.getCallStack();
    }
}
