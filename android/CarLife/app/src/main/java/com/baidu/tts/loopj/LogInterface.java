package com.baidu.tts.loopj;

public interface LogInterface {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    /* renamed from: d */
    void mo3894d(String str, String str2);

    /* renamed from: d */
    void mo3895d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo3896e(String str, String str2);

    /* renamed from: e */
    void mo3897e(String str, String str2, Throwable th);

    int getLoggingLevel();

    /* renamed from: i */
    void mo3899i(String str, String str2);

    /* renamed from: i */
    void mo3900i(String str, String str2, Throwable th);

    boolean isLoggingEnabled();

    void setLoggingEnabled(boolean z);

    void setLoggingLevel(int i);

    boolean shouldLog(int i);

    /* renamed from: v */
    void mo3905v(String str, String str2);

    /* renamed from: v */
    void mo3906v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo3907w(String str, String str2);

    /* renamed from: w */
    void mo3908w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
