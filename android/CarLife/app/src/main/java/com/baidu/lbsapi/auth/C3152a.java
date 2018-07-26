package com.baidu.lbsapi.auth;

import android.util.Log;

/* renamed from: com.baidu.lbsapi.auth.a */
class C3152a {
    /* renamed from: a */
    public static boolean f17205a = false;
    /* renamed from: b */
    private static String f17206b = "BaiduApiAuth";

    /* renamed from: a */
    public static String m13185a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    /* renamed from: a */
    public static void m13186a(String str) {
        if (f17205a && Thread.currentThread().getStackTrace().length != 0) {
            Log.d(f17206b, C3152a.m13185a() + ";" + str);
        }
    }

    /* renamed from: b */
    public static void m13187b(String str) {
        if (Thread.currentThread().getStackTrace().length != 0) {
            Log.i(f17206b, str);
        }
    }

    /* renamed from: c */
    public static void m13188c(String str) {
        if (f17205a && Thread.currentThread().getStackTrace().length != 0) {
            Log.e(f17206b, C3152a.m13185a() + ";" + str);
        }
    }
}
