package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;

class cq extends bk {
    /* renamed from: a */
    static cq f19623a = new cq();

    private cq() {
    }

    /* renamed from: a */
    public static cq m15605a() {
        return f19623a;
    }

    /* renamed from: a */
    public SharedPreferences mo2732a(Context context) {
        if (VERSION.SDK_INT >= 11) {
            return context.getSharedPreferences("baidu_mtj_sdk_record", 4);
        }
        return context.getSharedPreferences("baidu_mtj_sdk_record", 0);
    }

    /* renamed from: a */
    protected void m15607a(Context context, long j) {
        m15460b(context, "session_first_visit_time", j);
    }

    /* renamed from: b */
    protected Long m15609b(Context context) {
        return Long.valueOf(m15455a(context, "session_first_visit_time", 0));
    }

    /* renamed from: b */
    protected void m15610b(Context context, long j) {
        m15460b(context, "session_last_visit_time", j);
    }

    /* renamed from: c */
    protected Long m15612c(Context context) {
        return Long.valueOf(m15455a(context, "session_last_visit_time", 0));
    }

    /* renamed from: c */
    protected void m15613c(Context context, long j) {
        m15460b(context, "session_visit_interval", j);
    }

    /* renamed from: d */
    protected Long m15614d(Context context) {
        return Long.valueOf(m15455a(context, "session_visit_interval", 0));
    }

    /* renamed from: a */
    protected void m15608a(Context context, String str) {
        m15461b(context, "session_today_visit_count", str);
    }

    /* renamed from: e */
    protected String m15615e(Context context) {
        return m15457a(context, "session_today_visit_count", "");
    }

    /* renamed from: b */
    protected void m15611b(Context context, String str) {
        m15461b(context, "session_recent_visit", str);
    }

    /* renamed from: f */
    protected String m15616f(Context context) {
        return m15457a(context, "session_recent_visit", "");
    }
}
