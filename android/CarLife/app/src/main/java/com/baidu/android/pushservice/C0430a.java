package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.baidu.android.pushservice.a */
public final class C0430a {
    /* renamed from: a */
    private static int f1353a = 1;

    /* renamed from: a */
    public static short m1854a() {
        return (short) 65;
    }

    /* renamed from: a */
    public static void m1855a(Context context, boolean z) {
        int i = 65;
        if (z) {
            i = 0;
        }
        Editor edit = context.getSharedPreferences("pst", 4).edit();
        edit.putInt("com.baidu.push.nd_restart", i);
        edit.commit();
    }

    /* renamed from: a */
    public static boolean m1856a(Context context) {
        return PushSettings.m1827c(context);
    }

    /* renamed from: b */
    public static int m1857b() {
        if (f1353a != 0) {
            try {
                if (new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-12-07 19:05:47").getTime() > 0) {
                    f1353a = 0;
                }
            } catch (Exception e) {
                f1353a = 0;
            }
        }
        return f1353a;
    }

    /* renamed from: b */
    public static void m1858b(Context context, boolean z) {
        String str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
        if (z) {
            if ("disabled".equals(C0430a.m1860c(context))) {
                C0430a.m1855a(context, true);
            }
            str = UpdateDeviceStatusDataStruct.KEY_ENABLED;
        } else {
            str = "disabled";
        }
        Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    /* renamed from: b */
    public static boolean m1859b(Context context) {
        return 65 > context.getSharedPreferences("pst", 4).getInt("com.baidu.push.nd_restart", 0);
    }

    /* renamed from: c */
    public static String m1860c(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", "default");
    }
}
