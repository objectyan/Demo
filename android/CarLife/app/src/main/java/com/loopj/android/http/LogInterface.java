package com.loopj.android.http;

public interface LogInterface {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    /* renamed from: d */
    void mo4878d(String str, String str2);

    /* renamed from: d */
    void mo4879d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo4880e(String str, String str2);

    /* renamed from: e */
    void mo4881e(String str, String str2, Throwable th);

    int getLoggingLevel();

    /* renamed from: i */
    void mo4883i(String str, String str2);

    /* renamed from: i */
    void mo4884i(String str, String str2, Throwable th);

    boolean isLoggingEnabled();

    void setLoggingEnabled(boolean z);

    void setLoggingLevel(int i);

    boolean shouldLog(int i);

    /* renamed from: v */
    void mo4889v(String str, String str2);

    /* renamed from: v */
    void mo4890v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo4891w(String str, String str2);

    /* renamed from: w */
    void mo4892w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
