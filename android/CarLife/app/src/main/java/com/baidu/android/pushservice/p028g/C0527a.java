package com.baidu.android.pushservice.p028g;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.PushSettings;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: com.baidu.android.pushservice.g.a */
public class C0527a {
    /* renamed from: a */
    public static String m2215a(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static void m2216a(String str, String str2, Context context) {
        if (PushSettings.m1827c(context) && str2 != null) {
            Log.d("BDPushSDK-" + str, str2);
        }
    }

    /* renamed from: a */
    public static void m2217a(String str, Throwable th, Context context) {
        C0527a.m2218b(str, C0527a.m2215a(th), context);
    }

    /* renamed from: b */
    public static void m2218b(String str, String str2, Context context) {
        if (PushSettings.m1827c(context) && str2 != null) {
            Log.e("BDPushSDK-" + str, str2);
        }
    }

    /* renamed from: c */
    public static void m2219c(String str, String str2, Context context) {
        if (PushSettings.m1827c(context) && str2 != null) {
            Log.i("BDPushSDK-" + str, str2);
        }
    }

    /* renamed from: d */
    public static void m2220d(String str, String str2, Context context) {
        if (PushSettings.m1827c(context) && str2 != null) {
            Log.w("BDPushSDK-" + str, str2);
        }
    }
}
