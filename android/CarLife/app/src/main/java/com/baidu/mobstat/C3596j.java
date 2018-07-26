package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.j */
class C3596j {
    /* renamed from: a */
    public String f19645a;
    /* renamed from: b */
    public String f19646b;
    /* renamed from: c */
    public int f19647c;

    private C3596j() {
        this.f19647c = 2;
    }

    /* renamed from: a */
    public static C3596j m15747a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Object string = jSONObject.getString("deviceid");
            String string2 = jSONObject.getString("imei");
            int i = jSONObject.getInt("ver");
            if (TextUtils.isEmpty(string) || string2 == null) {
                return null;
            }
            C3596j c3596j = new C3596j();
            c3596j.f19645a = string;
            c3596j.f19646b = string2;
            c3596j.f19647c = i;
            return c3596j;
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return null;
        }
    }

    /* renamed from: a */
    public String m15748a() {
        try {
            return new JSONObject().put("deviceid", this.f19645a).put("imei", this.f19646b).put("ver", this.f19647c).toString();
        } catch (Throwable e) {
            C3593g.m15734b(e);
            return null;
        }
    }

    /* renamed from: b */
    public String m15749b() {
        String str = this.f19646b;
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.f19645a + "|" + new StringBuffer(str).reverse().toString();
    }
}
