package com.baidu.platform.comapi.util;

import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: MLog */
/* renamed from: com.baidu.platform.comapi.util.f */
public class C2911f {
    /* renamed from: a */
    public static boolean f12743a = false;
    /* renamed from: b */
    private static final String f12744b = "BaiduMapLog";

    /* renamed from: a */
    public static void m11011a(boolean debug) {
        f12743a = debug;
    }

    /* renamed from: a */
    public static void m11007a(String msg) {
        C2911f.m11008a(f12744b, msg);
    }

    /* renamed from: a */
    public static void m11008a(String tag, String msg) {
        if (f12743a) {
            Log.v(tag, "" + msg);
        }
    }

    /* renamed from: b */
    public static void m11014b(String msg) {
        C2911f.m11015b(f12744b, msg);
    }

    /* renamed from: b */
    public static void m11015b(String tag, String msg) {
        if (f12743a) {
            Log.d(tag, "" + msg);
        }
    }

    /* renamed from: a */
    public static void m11009a(String tag, String msg, Throwable tr) {
        if (f12743a) {
            Log.d(tag, "" + msg, tr);
        }
    }

    /* renamed from: a */
    public static void m11010a(String tag, String... msgs) {
        if (f12743a) {
            Log.d(tag, C2911f.m11006a(msgs, " "));
        }
    }

    /* renamed from: c */
    public static void m11017c(String msg) {
        C2911f.m11018c(f12744b, msg);
    }

    /* renamed from: c */
    public static void m11018c(String tag, String msg) {
        if (f12743a) {
            Log.i(tag, "" + msg);
        }
    }

    /* renamed from: d */
    public static void m11020d(String msg) {
        C2911f.m11021d(f12744b, msg);
    }

    /* renamed from: d */
    public static void m11021d(String tag, String msg) {
        if (f12743a) {
            Log.w(tag, "" + msg);
        }
    }

    /* renamed from: b */
    public static void m11016b(String tag, String msg, Throwable tr) {
        if (f12743a) {
            Log.w(tag, "" + msg, tr);
        }
    }

    /* renamed from: e */
    public static void m11022e(String msg) {
        C2911f.m11023e(f12744b, msg);
    }

    /* renamed from: e */
    public static void m11023e(String tag, String msg) {
        if (f12743a) {
            Log.e(tag, "" + msg);
        }
    }

    /* renamed from: c */
    public static void m11019c(String tag, String msg, Throwable tr) {
        if (f12743a) {
            Log.e(tag, "" + msg, tr);
        }
    }

    /* renamed from: a */
    public static boolean m11012a(int level) {
        return C2911f.m11013a(f12744b, level);
    }

    /* renamed from: a */
    public static boolean m11013a(String tag, int level) {
        if (f12743a) {
            return Log.isLoggable(tag, level);
        }
        return false;
    }

    /* renamed from: f */
    public static void m11024f(String msg) {
        C2911f.m11025f(f12744b, msg);
    }

    /* renamed from: f */
    public static void m11025f(String tag, String msg) {
        if (f12743a && VERSION.SDK_INT >= 8) {
            Log.wtf(tag, "" + msg);
        }
    }

    /* renamed from: a */
    private static String m11006a(String[] msgs, String splitter) {
        if (msgs == null || splitter == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String msg : msgs) {
            sb.append(msg);
            sb.append(splitter);
        }
        return sb.toString();
    }
}
