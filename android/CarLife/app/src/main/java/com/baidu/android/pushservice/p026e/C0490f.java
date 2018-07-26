package com.baidu.android.pushservice.p026e;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.C0430a;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.p023b.C0432b;
import com.baidu.android.pushservice.p024c.C0448d;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager.AppSourceDefine;
import java.util.HashMap;

/* renamed from: com.baidu.android.pushservice.e.f */
public class C0490f extends C0488d {
    /* renamed from: e */
    protected int f1594e = 0;
    /* renamed from: f */
    private int f1595f;
    /* renamed from: g */
    private String f1596g;
    /* renamed from: h */
    private String f1597h;

    public C0490f(C0496l c0496l, Context context, int i, int i2) {
        super(c0496l, context);
        this.f1594e = i;
        this.f1595f = i2;
        if (this.f1594e == 0) {
            this.d = true;
        }
    }

    public C0490f(C0496l c0496l, Context context, int i, int i2, String str) {
        super(c0496l, context);
        this.f1594e = i;
        this.f1595f = i2;
        this.f1596g = str;
        this.f1597h = c0496l.f1612j;
        if (this.f1594e == 0) {
            this.d = true;
        }
    }

    /* renamed from: a */
    protected void mo1285a(Intent intent) {
        intent.putExtra("bind_status", this.f1594e);
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "bind");
        hashMap.put("bind_name", Build.MODEL);
        hashMap.put("bind_status", this.f1594e + "");
        hashMap.put("push_sdk_version", this.f1595f + "");
        if (!TextUtils.isEmpty(this.f1597h) && this.f1597h.equalsIgnoreCase("true")) {
            hashMap.put("is_baidu_internal_bind", "true");
        }
        if (!TextUtils.isEmpty(this.f1596g)) {
            hashMap.put("bind_notify_status", this.f1596g);
        }
        if (!TextUtils.isEmpty(this.b.f1614l) && C0448d.m1945g(this.a)) {
            hashMap.put("push_proxy", this.b.f1614l);
        }
        try {
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (Build.MANUFACTURER.toLowerCase().contains(AppSourceDefine.HUAWEI_SOURCE) || Build.MANUFACTURER.toLowerCase().contains("xiaomi") || Build.MANUFACTURER.toLowerCase().contains("oppo")) {
                hashMap.put(Config.ROM, C0578p.m2497C(this.a));
            }
        } catch (Exception e) {
        }
        if (C0578p.m2502F(this.a)) {
            hashMap.put("connect_version", "3");
        } else {
            hashMap.put("connect_version", "2");
        }
        hashMap.put("sdk_int", VERSION.SDK_INT + "");
        Object obj = this.b.f1607e;
        if (!TextUtils.isEmpty(obj) && obj.length() <= 128) {
            hashMap.put("package_name", obj);
        }
        if (!PushSettings.m1827c(this.a)) {
            hashMap.put("check_sdk", C0574m.m2465a(this.a, "com.baidu.android.pushservice.CHECK_SDK"));
        }
        if (C0430a.m1857b() > 0) {
            C0553q.m2357a(this.a, "039903", 0, this.b.f1611i);
        }
    }

    /* renamed from: b */
    protected String mo1284b(String str) {
        String b = super.mo1284b(str);
        if (!TextUtils.isEmpty(this.b.f1607e)) {
            C0432b.m1870a(this.a).m1888g(this.b.f1607e);
            if (!TextUtils.isEmpty(this.b.f1611i)) {
                C0432b.m1870a(this.a).m1880a(this.b.f1607e, new C0491g(this.b.f1611i, b));
            }
        }
        return b;
    }
}
