package com.baidu.android.pushservice.p023b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.b.d */
public class C0434d {
    /* renamed from: a */
    public C0437f f1368a;
    /* renamed from: b */
    public C0438g f1369b;
    /* renamed from: c */
    private C0433c f1370c;

    public C0434d(C0433c c0433c) {
        this.f1370c = c0433c;
    }

    /* renamed from: a */
    public static C0434d m1889a(Context context, String str) {
        C0432b.m1870a(context).m1883b(context);
        C0437f d = C0432b.m1870a(context).m1886d(str);
        if (d == null || TextUtils.isEmpty(d.c)) {
            C0578p.m2546b("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
            C0438g e = C0439h.m1902a(context).m1906e(str);
            if (e == null || e.m1867c() == null) {
                return new C0434d(C0433c.UNKNOWN_CLIENT);
            }
            C0434d c0434d = new C0434d(C0433c.SDK_CLIENT);
            c0434d.f1369b = e;
            return c0434d;
        }
        c0434d = new C0434d(C0433c.PUSH_CLIENT);
        c0434d.f1368a = d;
        return c0434d;
    }

    /* renamed from: a */
    public C0433c m1890a() {
        return this.f1370c;
    }
}
