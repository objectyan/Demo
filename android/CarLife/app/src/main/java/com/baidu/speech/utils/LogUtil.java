package com.baidu.speech.utils;

import android.util.Log;

public class LogUtil {
    public static final int DEBUG = 3;
    private static final boolean DEBUG_MODE = false;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int OFF = 7;
    private static final String PREFIX = "[BDASR_LOG] ";
    private static final String TAG = "LogUtil";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static int logLevel = 7;

    static {
        setLogLevel(7);
    }

    public static void Test(String str) {
        if (3 >= logLevel) {
            Log.d(TAG, str);
        }
    }

    private static String argsToString(String... strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : strArr) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public static void m16418d(String str, String str2, Object... objArr) {
        if (3 >= logLevel) {
            Log.d(PREFIX + str, String.format(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m16419d(String str, Throwable th, String... strArr) {
        if (3 >= logLevel) {
            Log.d(PREFIX + str, argsToString(strArr), th);
        }
    }

    /* renamed from: d */
    public static void m16420d(String str, String... strArr) {
        if (3 >= logLevel) {
            Log.d(PREFIX + str, argsToString(strArr));
        }
    }

    /* renamed from: e */
    public static void m16421e(String str, String str2, Object... objArr) {
        if (6 >= logLevel) {
            Log.e(PREFIX + str, String.format(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m16422e(String str, Throwable th, String... strArr) {
        if (6 >= logLevel) {
            Log.e(PREFIX + str, argsToString(strArr), th);
        }
    }

    /* renamed from: e */
    public static void m16423e(String str, String... strArr) {
        if (6 >= logLevel) {
            Log.e(PREFIX + str, argsToString(strArr));
        }
    }

    /* renamed from: e */
    public static void m16424e(Throwable th) {
        if (6 >= logLevel) {
            printStrackTrace(th);
        }
    }

    /* renamed from: i */
    public static void m16425i(String str, String str2, Object... objArr) {
        if (4 >= logLevel) {
            Log.i(PREFIX + str, String.format(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m16426i(String str, Throwable th, String... strArr) {
        if (4 >= logLevel) {
            Log.i(PREFIX + str, argsToString(strArr), th);
        }
    }

    /* renamed from: i */
    public static void m16427i(String str, String... strArr) {
        if (4 >= logLevel) {
            Log.i(PREFIX + str, argsToString(strArr));
        }
    }

    private static boolean isFilteredLog(int i, String str) {
        return str.contains("") && i == 3;
    }

    public static boolean isLoggable(int i) {
        return logLevel >= i;
    }

    private static void printStrackTrace(Throwable th) {
        if (th != null && th.getStackTrace() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\n").append(th.getLocalizedMessage());
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                stringBuffer.append("\n").append(stackTraceElement.toString());
            }
        }
    }

    public static void setLogLevel(int i) {
        logLevel = i;
        Log.i("[BDASR_LOG] LogUtil", "Changing log level to " + i);
    }

    public static void setLogLevel(String str) {
        if ("VERBOSE".equals(str)) {
            logLevel = 2;
        } else if ("DEBUG".equals(str)) {
            logLevel = 3;
        } else if ("INFO".equals(str)) {
            logLevel = 4;
        } else if ("WARN".equals(str)) {
            logLevel = 5;
        } else if ("ERROR".equals(str)) {
            logLevel = 6;
        } else if ("OFF".equals(str)) {
            logLevel = 7;
        }
        Log.i(TAG, "Changing log level to " + logLevel + "(" + str + ")");
    }

    /* renamed from: v */
    public static void m16428v(String str, String str2, Object... objArr) {
        if (2 >= logLevel) {
            Log.v(PREFIX + str, String.format(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m16429v(String str, Throwable th, String... strArr) {
        if (2 >= logLevel) {
            Log.v(PREFIX + str, argsToString(strArr), th);
        }
    }

    /* renamed from: v */
    public static void m16430v(String str, String... strArr) {
        if (2 >= logLevel) {
            Log.v(PREFIX + str, argsToString(strArr));
        }
    }

    /* renamed from: w */
    public static void m16431w(String str, String str2, Object... objArr) {
        if (5 >= logLevel) {
            Log.w(PREFIX + str, String.format(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m16432w(String str, Throwable th, String... strArr) {
        if (5 >= logLevel) {
            Log.w(PREFIX + str, argsToString(strArr), th);
        }
    }

    /* renamed from: w */
    public static void m16433w(String str, String... strArr) {
        if (5 >= logLevel) {
            Log.w(PREFIX + str, argsToString(strArr));
        }
    }
}
