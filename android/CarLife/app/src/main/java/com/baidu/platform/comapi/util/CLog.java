package com.baidu.platform.comapi.util;

public class CLog {
    public static final boolean DEBUG = false;
    /* renamed from: a */
    private static CLog f19869a = null;

    public static synchronized CLog getInstance() {
        CLog cLog;
        synchronized (CLog.class) {
            if (f19869a == null && f19869a == null) {
                f19869a = new CLog();
            }
            cLog = f19869a;
        }
        return cLog;
    }

    /* renamed from: v */
    public void m15871v(String tag, String msg) {
    }

    /* renamed from: v */
    public void m15872v(String tag, String msg, Throwable tr) {
    }

    /* renamed from: d */
    public void m15865d(String tag, String msg) {
    }

    /* renamed from: d */
    public void m15866d(String tag, String msg, Throwable tr) {
    }

    /* renamed from: i */
    public void m15869i(String tag, String msg) {
    }

    /* renamed from: i */
    public void m15870i(String tag, String msg, Throwable tr) {
    }

    /* renamed from: w */
    public void m15873w(String tag, String msg) {
    }

    /* renamed from: w */
    public void m15874w(String tag, String msg, Throwable tr) {
    }

    /* renamed from: w */
    public void m15875w(String tag, Throwable tr) {
    }

    /* renamed from: e */
    public void m15867e(String tag, String msg) {
    }

    /* renamed from: e */
    public void m15868e(String tag, String msg, Throwable tr) {
    }
}
