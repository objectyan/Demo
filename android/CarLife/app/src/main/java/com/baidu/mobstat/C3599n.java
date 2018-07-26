package com.baidu.mobstat;

import android.content.Context;

/* renamed from: com.baidu.mobstat.n */
public class C3599n {
    /* renamed from: a */
    public static void m15752a(Context context) {
        C3598m.f19648a.m15751a(context);
        az.m15388a(context).m15392a(C3606u.AP_LIST, System.currentTimeMillis());
    }

    /* renamed from: a */
    public static void m15753a(Context context, String str, String str2) {
        C3602q.f19654a.m15763a(context, str, str2);
        az.m15388a(context).m15392a(C3606u.APP_CHANGE, System.currentTimeMillis());
    }

    /* renamed from: a */
    public static void m15754a(Context context, boolean z) {
        C3603r.f19655a.m15767a(context, z);
        az.m15388a(context).m15392a(z ? C3606u.APP_SYS_LIST : C3606u.APP_USER_LIST, System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m15756b(Context context, boolean z) {
        C3604s.f19656a.m15777a(context, z);
        az.m15388a(context).m15392a(z ? C3606u.APP_TRACE_CURRENT : C3606u.APP_TRACE_HIS, System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m15755b(Context context) {
        C3600o.f19649a.m15761a(context);
        az.m15388a(context).m15392a(C3606u.APP_APK, System.currentTimeMillis());
    }
}
