package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;

abstract class bk {
    /* renamed from: a */
    public abstract SharedPreferences mo2732a(Context context);

    bk() {
    }

    /* renamed from: a */
    public boolean m15458a(Context context, String str, boolean z) {
        return mo2732a(context).getBoolean(str, z);
    }

    /* renamed from: b */
    public void m15462b(Context context, String str, boolean z) {
        mo2732a(context).edit().putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public int m15454a(Context context, String str, int i) {
        return mo2732a(context).getInt(str, i);
    }

    /* renamed from: b */
    public void m15459b(Context context, String str, int i) {
        mo2732a(context).edit().putInt(str, i).commit();
    }

    /* renamed from: a */
    public long m15455a(Context context, String str, long j) {
        return mo2732a(context).getLong(str, j);
    }

    /* renamed from: b */
    public void m15460b(Context context, String str, long j) {
        mo2732a(context).edit().putLong(str, j).commit();
    }

    /* renamed from: a */
    public String m15457a(Context context, String str, String str2) {
        return mo2732a(context).getString(str, str2);
    }

    /* renamed from: b */
    public void m15461b(Context context, String str, String str2) {
        mo2732a(context).edit().putString(str, str2).commit();
    }

    /* renamed from: g */
    public void m15463g(Context context, String str) {
        mo2732a(context).edit().remove(str).commit();
    }
}
