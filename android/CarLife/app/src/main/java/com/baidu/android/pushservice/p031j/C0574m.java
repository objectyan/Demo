package com.baidu.android.pushservice.p031j;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.speech.asr.SpeechConstant;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.j.m */
public class C0574m {
    /* renamed from: a */
    public static String m2465a(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getString(str, "");
    }

    /* renamed from: a */
    public static void m2466a(Context context, String str, int i) {
        try {
            Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2467a(Context context, String str, long j) {
        try {
            Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2468a(Context context, String str, String str2, String str3, String str4, boolean z, int i, long j, String str5, String str6) {
        try {
            Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            if (j != 0) {
                edit.putLong("currbindtime", j);
            }
            if (!TextUtils.isEmpty(str5)) {
                edit.putString("access_token", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                edit.putString("secret_key", str6);
            }
            edit.putString(SpeechConstant.APP_ID, str);
            edit.putString("channel_id", str2);
            edit.putString("request_id", str3);
            edit.putString("user_id", str4);
            edit.putBoolean("bind_status", true);
            edit.putLong("version_code", (long) C0578p.m2559d(context, context.getPackageName()));
            edit.apply();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2469a(Context context, List<String> list) {
        if (list != null && list.size() != 0 && list.size() <= 20) {
            try {
                Editor edit = context.getSharedPreferences("com.baidu.pushservice.app_stat", 0).edit();
                edit.putString("pkg_list", TextUtils.join(Config.TRACE_TODAY_VISIT_SPLIT, list));
                edit.putLong("last_save", System.currentTimeMillis());
                for (String str : list) {
                    PackageInfo a = C0578p.m2516a(context, str);
                    if (a != null) {
                        edit.putString(str, a.versionCode + Config.TRACE_TODAY_VISIT_SPLIT + a.versionName);
                    }
                }
                edit.apply();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m2470a(Context context, String str, String str2) {
        try {
            Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putString(str, str2);
            edit.apply();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static int m2471b(Context context, String str, int i) {
        return context.getSharedPreferences("pst", 0).getInt(str, i);
    }

    /* renamed from: b */
    public static String m2472b(Context context, String str) {
        return context.getSharedPreferences("pst", 4).getString(str, "");
    }

    /* renamed from: b */
    public static boolean m2473b(Context context, String str, String str2) {
        try {
            Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putString(str, str2);
            edit.apply();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    public static long m2474c(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getLong(str, 0);
    }

    /* renamed from: c */
    public static void m2475c(Context context, String str, int i) {
        try {
            Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    public static int m2476d(Context context, String str, int i) {
        return context.getSharedPreferences("pst", 4).getInt(str, i);
    }
}
