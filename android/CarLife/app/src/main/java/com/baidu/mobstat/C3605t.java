package com.baidu.mobstat;

import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.t */
class C3605t {
    /* renamed from: a */
    private String f19658a;
    /* renamed from: b */
    private String f19659b;
    /* renamed from: c */
    private String f19660c;

    public C3605t(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        this.f19658a = str;
        if (str2 == null) {
            str2 = "";
        }
        this.f19659b = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.f19660c = str3;
    }

    /* renamed from: a */
    public JSONObject m15778a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", this.f19658a);
            jSONObject.put("v", this.f19659b);
            jSONObject.put(Config.DEVICE_WIDTH, this.f19660c);
            return jSONObject;
        } catch (Throwable e) {
            bd.m15432b(e);
            return null;
        }
    }

    /* renamed from: b */
    public String m15779b() {
        return this.f19658a;
    }
}
