package com.baidu.che.codriver.util;

import android.util.Log;
import com.baidu.carlife.core.C1260i;
import com.baidu.che.codriver.C2510a;

/* compiled from: LogUtil */
/* renamed from: com.baidu.che.codriver.util.h */
public class C2725h {
    /* renamed from: a */
    public static final String f8938a = "CoDriver_TAG";

    /* renamed from: a */
    public static void m10204a(Throwable t) {
        if (C2725h.m10205a(5)) {
            StringBuilder err = new StringBuilder(256);
            err.append("Got exception: ");
            err.append(t.toString());
            err.append("\n");
            System.out.println(err.toString());
            t.printStackTrace(System.out);
        }
    }

    /* renamed from: a */
    public static void m10202a(String aTag, String aMsg) {
        C2725h.m10200a(2, aTag, aMsg);
    }

    /* renamed from: a */
    public static void m10203a(String aTag, String aMsg, Throwable aThrowable) {
        C2725h.m10201a(2, aTag, aMsg, aThrowable);
    }

    /* renamed from: b */
    public static void m10207b(String aTag, String aMsg) {
        C2725h.m10200a(3, aTag, aMsg);
    }

    /* renamed from: b */
    public static void m10208b(String aTag, String aMsg, Throwable aThrowable) {
        C2725h.m10201a(3, aTag, aMsg, aThrowable);
    }

    /* renamed from: c */
    public static void m10210c(String aTag, String aMsg) {
        C2725h.m10200a(4, aTag, aMsg);
    }

    /* renamed from: c */
    public static void m10211c(String aTag, String aMsg, Throwable aThrowable) {
        C2725h.m10201a(4, aTag, aMsg, aThrowable);
    }

    /* renamed from: d */
    public static void m10212d(String aTag, String aMsg) {
        C2725h.m10200a(5, aTag, aMsg);
    }

    /* renamed from: d */
    public static void m10213d(String aTag, String aMsg, Throwable aThrowable) {
        C2725h.m10201a(5, aTag, aMsg, aThrowable);
    }

    /* renamed from: e */
    public static void m10214e(String aTag, String aMsg) {
        C2725h.m10200a(6, aTag, aMsg);
    }

    /* renamed from: e */
    public static void m10215e(String aTag, String aMsg, Throwable aThrowable) {
        C2725h.m10201a(6, aTag, aMsg, aThrowable);
    }

    /* renamed from: a */
    public static void m10200a(int aLogLevel, String aTag, String aMessage) {
        C2725h.m10201a(aLogLevel, aTag, aMessage, null);
    }

    /* renamed from: a */
    public static void m10201a(int aLogLevel, String aTag, String aMessage, Throwable aThrowable) {
        if (C2725h.m10205a(aLogLevel)) {
            switch (aLogLevel) {
                case 2:
                    Log.v(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
                case 3:
                    Log.d(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
                case 4:
                    Log.i(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
                case 5:
                    Log.w(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
                case 6:
                    Log.e(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
                default:
                    Log.e(f8938a, aTag + ": " + aMessage, aThrowable);
                    break;
            }
        }
        C1260i.m4430a(f8938a, aTag, aMessage);
    }

    /* renamed from: a */
    public static void m10199a() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        if (stack != null && 2 <= stack.length) {
            StackTraceElement s = stack[1];
            if (s != null) {
                C2725h.m10207b(s.getClassName(), "+++++" + s.getMethodName());
            }
        }
    }

    /* renamed from: b */
    public static void m10206b() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        if (stack != null && 2 <= stack.length) {
            StackTraceElement s = stack[1];
            if (s != null) {
                C2725h.m10207b(s.getClassName(), "====>" + s.getMethodName());
            }
        }
    }

    /* renamed from: c */
    public static void m10209c() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        if (stack != null && 2 <= stack.length) {
            StackTraceElement s = stack[1];
            if (s != null) {
                C2725h.m10207b(s.getClassName(), "<====" + s.getMethodName());
            }
        }
    }

    /* renamed from: a */
    public static boolean m10205a(int aLevel) {
        if (aLevel >= C2510a.f8193j) {
            return true;
        }
        return false;
    }
}
