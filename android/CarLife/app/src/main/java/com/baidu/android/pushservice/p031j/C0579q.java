package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/* renamed from: com.baidu.android.pushservice.j.q */
public class C0579q {
    /* renamed from: a */
    public static String m2612a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getSharedPreferences(str, 5).getString(str2, "");
        } catch (Exception e) {
        }
        return str3;
    }

    /* renamed from: a */
    public static void m2613a(Context context, String str, String str2, String str3) {
        try {
            Editor edit = context.getSharedPreferences(str, 5).edit();
            edit.putString(str2, str3);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
