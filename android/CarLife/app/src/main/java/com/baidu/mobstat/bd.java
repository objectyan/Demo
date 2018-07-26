package com.baidu.mobstat;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;

public final class bd {
    /* renamed from: a */
    public static int f19438a = 7;

    /* renamed from: a */
    public static void m15428a(String str) {
        m15427a(3, str);
    }

    /* renamed from: a */
    public static void m15429a(Throwable th) {
        m15427a(3, m15435d(th));
    }

    /* renamed from: b */
    public static void m15431b(String str) {
        m15427a(5, str);
    }

    /* renamed from: b */
    public static void m15432b(Throwable th) {
        m15427a(5, m15435d(th));
    }

    /* renamed from: c */
    public static void m15433c(String str) {
        m15427a(6, str);
    }

    /* renamed from: c */
    public static void m15434c(Throwable th) {
        m15427a(6, m15435d(th));
    }

    /* renamed from: d */
    private static String m15435d(Throwable th) {
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
    private static void m15427a(int i, String str) {
        if (m15430a(i)) {
            Log.println(i, m15426a(), str);
        }
    }

    /* renamed from: a */
    private static boolean m15430a(int i) {
        return i >= f19438a;
    }

    /* renamed from: a */
    private static String m15426a() {
        return "Bottom";
    }
}
