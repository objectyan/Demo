package com.baidu.mapframework.commonlib.asynchttp;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;

public class LogHandler implements LogInterface {
    /* renamed from: a */
    boolean f18885a = true;
    /* renamed from: b */
    int f18886b = 2;

    public boolean isLoggingEnabled() {
        return this.f18885a;
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        this.f18885a = loggingEnabled;
    }

    public int getLoggingLevel() {
        return this.f18886b;
    }

    public void setLoggingLevel(int loggingLevel) {
        this.f18886b = loggingLevel;
    }

    public boolean shouldLog(int logLevel) {
        return logLevel >= this.f18886b;
    }

    public void log(int logLevel, String tag, String msg) {
        logWithThrowable(logLevel, tag, msg, null);
    }

    public void logWithThrowable(int logLevel, String tag, String msg, Throwable t) {
        if (isLoggingEnabled() && shouldLog(logLevel)) {
            switch (logLevel) {
                case 2:
                    Log.v(tag, msg, t);
                    return;
                case 3:
                    Log.d(tag, msg, t);
                    return;
                case 4:
                    Log.i(tag, msg, t);
                    return;
                case 5:
                    Log.w(tag, msg, t);
                    return;
                case 6:
                    Log.e(tag, msg, t);
                    return;
                case 8:
                    if (Integer.valueOf(VERSION.SDK).intValue() > 8) {
                        m14952a(tag, msg, t);
                        return;
                    } else {
                        Log.e(tag, msg, t);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @TargetApi(8)
    /* renamed from: a */
    private void m14952a(String tag, String msg, Throwable t) {
        Log.wtf(tag, msg, t);
    }

    /* renamed from: v */
    public void mo2634v(String tag, String msg) {
        log(2, tag, msg);
    }

    /* renamed from: v */
    public void mo2635v(String tag, String msg, Throwable t) {
        logWithThrowable(2, tag, msg, t);
    }

    /* renamed from: d */
    public void mo2623d(String tag, String msg) {
        log(2, tag, msg);
    }

    /* renamed from: d */
    public void mo2624d(String tag, String msg, Throwable t) {
        logWithThrowable(3, tag, msg, t);
    }

    /* renamed from: i */
    public void mo2628i(String tag, String msg) {
        log(4, tag, msg);
    }

    /* renamed from: i */
    public void mo2629i(String tag, String msg, Throwable t) {
        logWithThrowable(4, tag, msg, t);
    }

    /* renamed from: w */
    public void mo2636w(String tag, String msg) {
        log(5, tag, msg);
    }

    /* renamed from: w */
    public void mo2637w(String tag, String msg, Throwable t) {
        logWithThrowable(5, tag, msg, t);
    }

    /* renamed from: e */
    public void mo2625e(String tag, String msg) {
        log(6, tag, msg);
    }

    /* renamed from: e */
    public void mo2626e(String tag, String msg, Throwable t) {
        logWithThrowable(6, tag, msg, t);
    }

    public void wtf(String tag, String msg) {
        log(8, tag, msg);
    }

    public void wtf(String tag, String msg, Throwable t) {
        logWithThrowable(8, tag, msg, t);
    }
}
