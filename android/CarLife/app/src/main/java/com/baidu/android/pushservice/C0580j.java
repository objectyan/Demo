package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.android.pushservice.p026e.C0485a.C0484a;
import com.baidu.android.pushservice.p026e.C0508x;
import com.baidu.android.pushservice.p031j.C0574m;

/* renamed from: com.baidu.android.pushservice.j */
public final class C0580j {
    /* renamed from: a */
    private static C0580j f1870a;
    /* renamed from: b */
    private String f1871b = null;
    /* renamed from: c */
    private String f1872c = null;
    /* renamed from: d */
    private Thread f1873d = null;
    /* renamed from: e */
    private boolean f1874e;
    /* renamed from: f */
    private Context f1875f;

    private C0580j(Context context) {
        this.f1872c = C0574m.m2465a(context, "com.baidu.pushservice.channel_token");
        this.f1871b = PushSettings.m1816a(context);
        this.f1874e = false;
        this.f1875f = context;
    }

    /* renamed from: a */
    public static synchronized C0580j m2614a(Context context) {
        C0580j c0580j;
        synchronized (C0580j.class) {
            if (f1870a == null) {
                f1870a = new C0580j(context);
            }
            c0580j = f1870a;
        }
        return c0580j;
    }

    /* renamed from: a */
    public String m2615a() {
        return this.f1871b;
    }

    /* renamed from: a */
    public void m2616a(Context context, boolean z, C0484a c0484a) {
        if (this.f1873d == null || !this.f1873d.isAlive()) {
            Runnable c0508x = new C0508x(context, c0484a);
            if (!z) {
                c0508x.m2110a(0);
            }
            this.f1873d = new Thread(c0508x);
            this.f1873d.start();
        }
    }

    /* renamed from: a */
    public synchronized void m2617a(String str, String str2) {
        this.f1871b = str;
        this.f1872c = str2;
        PushSettings.m1819a(this.f1875f, str);
        C0574m.m2470a(this.f1875f, "com.baidu.pushservice.channel_token", str2);
    }

    /* renamed from: b */
    public String m2618b() {
        return this.f1872c;
    }

    /* renamed from: c */
    public boolean m2619c() {
        return (TextUtils.isEmpty(this.f1871b) || TextUtils.isEmpty(this.f1872c)) ? false : true;
    }

    /* renamed from: d */
    public boolean m2620d() {
        try {
            SharedPreferences sharedPreferences = this.f1875f.getSharedPreferences("pushclient", 0);
            if (sharedPreferences.getInt("isFirstReqChannelIDVcode", 0) == C0430a.m1854a()) {
                return false;
            }
            Editor edit = sharedPreferences.edit();
            edit.putInt("isFirstReqChannelIDVcode", C0430a.m1854a());
            edit.commit();
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
