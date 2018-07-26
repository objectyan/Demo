package com.baidu.sapi2.utils;

import android.util.Log;

/* renamed from: com.baidu.sapi2.utils.L */
public final class C4913L {
    /* renamed from: a */
    private static final String f20510a = "SAPI";
    /* renamed from: b */
    private static final String f20511b = "%1$s\n%2$s";
    /* renamed from: c */
    private static boolean f20512c = false;

    private C4913L() {
    }

    public static void enable(boolean debug) {
        f20512c = debug;
    }

    /* renamed from: d */
    public static void m16372d(String message, Object... args) {
        C4913L.m16371a(3, null, message, args);
    }

    /* renamed from: i */
    public static void m16376i(String message, Object... args) {
        C4913L.m16371a(4, null, message, args);
    }

    /* renamed from: w */
    public static void m16377w(String message, Object... args) {
        C4913L.m16371a(5, null, message, args);
    }

    /* renamed from: e */
    public static void m16374e(Throwable ex) {
        C4913L.m16371a(6, ex, null, new Object[0]);
    }

    /* renamed from: e */
    public static void m16373e(String message, Object... args) {
        C4913L.m16371a(6, null, message, args);
    }

    /* renamed from: e */
    public static void m16375e(Throwable ex, String message, Object... args) {
        C4913L.m16371a(6, ex, message, args);
    }

    /* renamed from: a */
    private static void m16371a(int priority, Throwable ex, String message, Object... args) {
        if (f20512c) {
            String log;
            if (args.length > 0) {
                message = String.format(message, args);
            }
            if (ex == null) {
                log = message;
            } else {
                String logMessage;
                if (message == null) {
                    logMessage = ex.getMessage();
                } else {
                    logMessage = message;
                }
                String logBody = Log.getStackTraceString(ex);
                log = String.format(f20511b, new Object[]{logMessage, logBody});
            }
            Log.println(priority, f20510a, log);
        }
    }
}
