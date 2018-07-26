package com.baidu.mapframework.commonlib.asynchttp;

public interface LogInterface {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    /* renamed from: d */
    void mo2623d(String str, String str2);

    /* renamed from: d */
    void mo2624d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo2625e(String str, String str2);

    /* renamed from: e */
    void mo2626e(String str, String str2, Throwable th);

    int getLoggingLevel();

    /* renamed from: i */
    void mo2628i(String str, String str2);

    /* renamed from: i */
    void mo2629i(String str, String str2, Throwable th);

    boolean isLoggingEnabled();

    void setLoggingEnabled(boolean z);

    void setLoggingLevel(int i);

    boolean shouldLog(int i);

    /* renamed from: v */
    void mo2634v(String str, String str2);

    /* renamed from: v */
    void mo2635v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo2636w(String str, String str2);

    /* renamed from: w */
    void mo2637w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
