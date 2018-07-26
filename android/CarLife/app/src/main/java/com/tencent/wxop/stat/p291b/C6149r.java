package com.tencent.wxop.stat.p291b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/* renamed from: com.tencent.wxop.stat.b.r */
public class C6149r {
    /* renamed from: a */
    private static SharedPreferences f24965a = null;

    /* renamed from: a */
    public static int m21910a(Context context, String str, int i) {
        return C6149r.m21912a(context).getInt(C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString()), i);
    }

    /* renamed from: a */
    public static long m21911a(Context context, String str, long j) {
        return C6149r.m21912a(context).getLong(C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString()), j);
    }

    /* renamed from: a */
    static synchronized SharedPreferences m21912a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C6149r.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            f24965a = sharedPreferences;
            if (sharedPreferences == null) {
                f24965a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = f24965a;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static String m21913a(Context context, String str, String str2) {
        return C6149r.m21912a(context).getString(C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString()), str2);
    }

    /* renamed from: b */
    public static void m21914b(Context context, String str, int i) {
        String a = C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString());
        Editor edit = C6149r.m21912a(context).edit();
        edit.putInt(a, i);
        edit.commit();
    }

    /* renamed from: b */
    public static void m21915b(Context context, String str, long j) {
        String a = C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString());
        Editor edit = C6149r.m21912a(context).edit();
        edit.putLong(a, j);
        edit.commit();
    }

    /* renamed from: b */
    public static void m21916b(Context context, String str, String str2) {
        String a = C6144m.m21865a(context, new StringBuilder(C6132a.f24879g).append(str).toString());
        Editor edit = C6149r.m21912a(context).edit();
        edit.putString(a, str2);
        edit.commit();
    }
}
