package com.baidu.mobstat;

import org.json.JSONObject;

/* renamed from: com.baidu.mobstat.p */
class C3601p {
    /* renamed from: a */
    private String f19650a;
    /* renamed from: b */
    private String f19651b;
    /* renamed from: c */
    private String f19652c;
    /* renamed from: d */
    private String f19653d;

    public C3601p(String str, String str2, String str3, String str4) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        this.f19650a = str;
        this.f19651b = str2;
        this.f19652c = str3;
        this.f19653d = str4;
    }

    /* renamed from: a */
    public JSONObject m15762a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", this.f19650a);
            jSONObject.put("v", this.f19651b);
            jSONObject.put("c", this.f19652c);
            jSONObject.put(Config.APP_VERSION_CODE, this.f19653d);
            return jSONObject;
        } catch (Throwable e) {
            bd.m15432b(e);
            return null;
        }
    }
}
