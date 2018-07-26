package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.baidu.android.pushservice.j.n */
public class C0575n {
    /* renamed from: a */
    public static String m2477a(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
    }

    /* renamed from: a */
    public static synchronized void m2478a(Context context, int i, String str) {
        synchronized (C0575n.class) {
            int i2 = 5;
            try {
                Editor edit;
                SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
                do {
                    edit = sharedPreferences.edit();
                    i2--;
                    if (edit != null) {
                        break;
                    }
                } while (i2 > 0);
                if (edit != null) {
                    switch (i) {
                        case 5:
                            edit.putString("bd_use_huawei_token", str).commit();
                            break;
                        case 6:
                            edit.putString("bd_use_xiaomi_regid", str).commit();
                            break;
                        case 7:
                            edit.putString("bd_use_meizu_pushid", str).commit();
                            break;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m2479a(Context context, String str, boolean z) {
        int i = 20;
        try {
            Editor edit;
            SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
            do {
                edit = sharedPreferences.edit();
                i--;
                if (edit != null) {
                    break;
                }
            } while (i > 0);
            edit.putBoolean(str, z).commit();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static String m2480b(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
    }

    /* renamed from: c */
    public static String m2481c(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
    }
}
