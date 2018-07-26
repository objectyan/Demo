package com.baidu.che.codriver.util;

import android.content.Intent;
import android.os.SystemClock;

/* compiled from: VRTestUtils */
/* renamed from: com.baidu.che.codriver.util.n */
public class C2734n {
    /* renamed from: a */
    public static final boolean f8952a = false;
    /* renamed from: b */
    private static final String f8953b = "VRTestUtils";
    /* renamed from: c */
    private static long f8954c = 0;
    /* renamed from: d */
    private static long f8955d = 0;
    /* renamed from: e */
    private static long f8956e = 0;
    /* renamed from: f */
    private static long f8957f = 0;
    /* renamed from: g */
    private static long f8958g = 0;
    /* renamed from: h */
    private static long f8959h = 0;
    /* renamed from: i */
    private static long f8960i = 0;
    /* renamed from: j */
    private static long f8961j = 0;
    /* renamed from: k */
    private static long f8962k = 0;
    /* renamed from: l */
    private static long f8963l = 0;
    /* renamed from: m */
    private static long f8964m = 0;

    /* renamed from: a */
    public static void m10239a() {
        if (C2716c.m10169o()) {
            f8954c = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onVrReady:start_recording");
        }
    }

    /* renamed from: a */
    public static void m10240a(String params) {
        if (C2716c.m10169o()) {
            f8955d = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onVrFinish-time:" + (f8955d - f8957f) + "ms");
            C2725h.m10207b(f8953b, "onVrFinish--Result:" + params);
        }
    }

    /* renamed from: b */
    public static void m10242b(String params) {
        if (C2716c.m10169o()) {
            f8956e = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onNlpFinish-time:" + (f8956e - f8955d) + "ms");
            C2725h.m10207b(f8953b, "onNlpFinish--Result:" + params);
        }
    }

    /* renamed from: b */
    public static void m10241b() {
        if (C2716c.m10169o()) {
            f8964m = (SystemClock.elapsedRealtime() - f8957f) + f8963l;
            C2725h.m10207b(f8953b, "onCommandExcuteComplete-time:" + f8964m + "ms");
        }
    }

    /* renamed from: c */
    public static void m10243c() {
        if (C2716c.m10169o()) {
            f8957f = SystemClock.elapsedRealtime();
            f8963l = f8957f - f8958g;
            C2725h.m10207b(f8953b, "onSpeechEnd VAD time:" + f8963l + "ms");
        }
    }

    /* renamed from: d */
    public static void m10244d() {
        if (C2716c.m10169o()) {
            f8958g = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onSpeechEndManually");
        }
    }

    /* renamed from: e */
    public static void m10245e() {
        if (C2716c.m10169o()) {
            f8959h = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onSpeechBegin:" + (f8959h - f8954c) + "ms");
        }
    }

    /* renamed from: f */
    public static void m10246f() {
        if (C2716c.m10169o()) {
            C2725h.m10207b(f8953b, "onRecognizeCorrect");
        }
    }

    /* renamed from: g */
    public static void m10247g() {
        if (C2716c.m10169o()) {
            C2725h.m10207b(f8953b, "onRecognizeWrong");
        }
    }

    /* renamed from: h */
    public static void m10248h() {
        if (C2716c.m10169o()) {
            f8961j = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onWakeUpSpeakEnd");
        }
    }

    /* renamed from: i */
    public static void m10249i() {
        if (C2716c.m10169o()) {
            f8962k = SystemClock.elapsedRealtime();
            C2725h.m10207b(f8953b, "onWakeUp:" + (f8962k - f8961j) + "ms");
        }
    }

    /* renamed from: j */
    public static void m10250j() {
        if (C2716c.m10169o()) {
            C2725h.m10207b(f8953b, "onWakeUpViewDisplay:" + (SystemClock.elapsedRealtime() - f8962k) + "ms");
        }
    }

    /* renamed from: k */
    public static void m10251k() {
        Intent intent = new Intent("com.baidu.che.codrivercustom.START");
        intent.addFlags(32);
        C2716c.m10141a().sendBroadcast(intent);
    }
}
