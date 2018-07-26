package com.baidu.mobstat;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;

public final class db {
    /* renamed from: a */
    public static int f19628a = 7;

    /* renamed from: a */
    public static void m15657a(String str) {
        m15656a(3, str);
    }

    /* renamed from: a */
    public static void m15659a(Throwable th) {
        m15656a(3, m15665d(th));
    }

    /* renamed from: a */
    public static void m15658a(String str, Throwable th) {
        m15656a(3, str + '\n' + m15665d(th));
    }

    /* renamed from: b */
    public static void m15661b(String str) {
        m15656a(5, str);
    }

    /* renamed from: b */
    public static void m15662b(Throwable th) {
        m15656a(5, m15665d(th));
    }

    /* renamed from: c */
    public static void m15663c(String str) {
        m15656a(6, str);
    }

    /* renamed from: c */
    public static void m15664c(Throwable th) {
        m15656a(6, m15665d(th));
    }

    /* renamed from: d */
    private static String m15665d(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    private static void m15656a(int i, String str) {
        if (m15660a(i)) {
            Log.println(i, m15655a(), str);
        }
    }

    /* renamed from: a */
    private static boolean m15660a(int i) {
        return i >= f19628a;
    }

    /* renamed from: a */
    private static String m15655a() {
        return "sdkstat";
    }
}
