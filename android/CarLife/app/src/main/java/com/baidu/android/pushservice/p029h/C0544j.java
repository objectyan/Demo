package com.baidu.android.pushservice.p029h;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.j */
public class C0544j extends C0537c {
    /* renamed from: a */
    public static int f1797a = 0;
    /* renamed from: b */
    public static int f1798b = 10;
    /* renamed from: c */
    public static int f1799c = 11;
    /* renamed from: d */
    public static int f1800d = 12;
    /* renamed from: e */
    public static int f1801e = 13;
    /* renamed from: f */
    private int f1802f = 0;

    public C0544j(String str) {
        super(str);
    }

    /* renamed from: a */
    public JSONObject m2327a(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_type", this.f1802f);
        if (!TextUtils.isEmpty(m2267b())) {
            jSONObject.put("app_package_name", m2267b());
        }
        if (!TextUtils.isEmpty(m2270c())) {
            jSONObject.put("app_name", m2270c());
        }
        if (!TextUtils.isEmpty(m2272d())) {
            jSONObject.put("app_cfrom", m2272d());
        }
        if (m2274e() != -1) {
            jSONObject.put("app_vercode", m2274e());
        }
        if (!TextUtils.isEmpty(m2276f())) {
            jSONObject.put("app_vername", m2276f());
        }
        if (m2277g() != -1) {
            jSONObject.put("app_push_version", m2277g());
        }
        jSONObject.put("app_appid", m2264a());
        return jSONObject;
    }

    /* renamed from: c */
    public void m2328c(int i) {
        this.f1802f = i;
    }

    /* renamed from: h */
    public int m2329h() {
        return this.f1802f;
    }
}
