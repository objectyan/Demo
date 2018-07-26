package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import java.util.List;

public class LoggerProxy {
    /* renamed from: a */
    private static C5041d f20814a = C5041d.m17013a();

    /* renamed from: v */
    public static void m17004v(String tag, String message) {
        log(2, tag, message);
    }

    /* renamed from: i */
    public static void m17003i(String tag, String message) {
        log(4, tag, message);
    }

    /* renamed from: d */
    public static void m17001d(String tag, String message) {
        log(3, tag, message);
    }

    /* renamed from: w */
    public static void m17005w(String tag, String message) {
        log(5, tag, message);
    }

    /* renamed from: e */
    public static void m17002e(String tag, String message) {
        log(6, tag, message);
    }

    /* renamed from: a */
    public static void m17000a(String tag, String message) {
        log(7, tag, message);
    }

    public static void log(int level, String tag, String message) {
        try {
            f20814a.m17019a(level, tag, message);
        } catch (Exception e) {
            Log.e("LoggerProxy", "log exception=" + e.toString());
        }
    }

    public static void printable(boolean isPrint) {
        f20814a.m17023a(isPrint);
    }

    public static void setModeRelease() {
        f20814a.m17027d();
    }

    public static void clearHandler() {
        f20814a.m17024b();
    }

    public static boolean isModeRelease() {
        return f20814a.m17028e();
    }

    public static void addPrintString(String specify) {
        f20814a.m17021a(specify);
    }

    public static void addPrintStrings(List<String> specify) {
        f20814a.m17022a((List) specify);
    }

    public static void addUnPrintString(String specify) {
        f20814a.m17025b(specify);
    }

    public static void clearSpecifyStrings() {
        f20814a.m17026c();
    }
}
