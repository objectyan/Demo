package com.baidu.che.codriver.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/* compiled from: SharePreferenceUtil */
/* renamed from: com.baidu.che.codriver.util.l */
public class C2731l {
    /* renamed from: a */
    public static final String f8944a = "codriver_setting";

    /* renamed from: a */
    public static boolean m10228a(Context context, String key, boolean dValue) {
        return context.getSharedPreferences(f8944a, 0).getBoolean(key, dValue);
    }

    /* renamed from: b */
    public static void m10231b(Context context, String key, boolean value) {
        Editor editor = context.getSharedPreferences(f8944a, 0).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /* renamed from: a */
    public static String m10227a(Context context, String key, String dValue) {
        return context.getSharedPreferences(f8944a, 0).getString(key, dValue);
    }

    /* renamed from: b */
    public static void m10230b(Context context, String key, String value) {
        Editor editor = context.getSharedPreferences(f8944a, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }

    /* renamed from: a */
    public static long m10226a(Context context, String key, long dValue) {
        return context.getSharedPreferences(f8944a, 0).getLong(key, dValue);
    }

    /* renamed from: b */
    public static void m10229b(Context context, String key, long value) {
        Editor editor = context.getSharedPreferences(f8944a, 0).edit();
        editor.putLong(key, value);
        editor.commit();
    }
}
