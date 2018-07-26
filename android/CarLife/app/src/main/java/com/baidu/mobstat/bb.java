package com.baidu.mobstat;

import android.os.Build.VERSION;

public final class bb {
    /* renamed from: a */
    public static boolean f19430a = true;
    /* renamed from: b */
    public static final String f19431b = (VERSION.SDK_INT < 9 ? "http://datax.baidu.com/xs.gif" : "https://datax.baidu.com/xs.gif");
    /* renamed from: c */
    public static final String f19432c;

    static {
        String str;
        if (VERSION.SDK_INT < 9) {
            str = "http://dxp.baidu.com/upgrade";
        } else {
            str = "https://dxp.baidu.com/upgrade";
        }
        f19432c = str;
    }
}
