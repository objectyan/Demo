package com.tencent.mm.sdk.p287b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

/* renamed from: com.tencent.mm.sdk.b.b */
public final class C6094b {
    private static C6093a aG;
    private static C6093a aH;
    private static final String aI;
    private static int level = 6;

    /* renamed from: com.tencent.mm.sdk.b.b$a */
    public interface C6093a {
        /* renamed from: f */
        void mo4976f(String str, String str2);

        /* renamed from: g */
        void mo4977g(String str, String str2);

        int getLogLevel();

        /* renamed from: h */
        void mo4979h(String str, String str2);

        /* renamed from: i */
        void mo4980i(String str, String str2);
    }

    static {
        C6093a c6095c = new C6095c();
        aG = c6095c;
        aH = c6095c;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aI = stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m21681a(String str, String str2, Object... objArr) {
        if (aH != null && aH.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            C6093a c6093a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6093a.mo4980i(str, format);
        }
    }

    /* renamed from: b */
    public static void m21682b(String str, String str2) {
        C6094b.m21681a(str, str2, null);
    }

    /* renamed from: c */
    public static void m21683c(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 3) {
            C6093a c6093a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6093a.mo4979h(str, str2);
        }
    }

    /* renamed from: d */
    public static void m21684d(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 2) {
            C6093a c6093a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6093a.mo4976f(str, str2);
        }
    }

    /* renamed from: e */
    public static void m21685e(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            C6093a c6093a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c6093a.mo4977g(str, str2);
        }
    }
}
