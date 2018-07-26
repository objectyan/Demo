package com.baidu.android.pushservice.p025d;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.d.b */
public class C0464b {
    /* renamed from: a */
    public long f1515a = 0;
    /* renamed from: b */
    public long f1516b = 0;
    /* renamed from: c */
    public String f1517c = "";
    /* renamed from: d */
    public String f1518d = "";
    /* renamed from: e */
    public String f1519e = "";
    /* renamed from: f */
    public String f1520f = "";
    /* renamed from: g */
    public String f1521g = "";
    /* renamed from: h */
    public String f1522h = "";
    /* renamed from: i */
    public String f1523i = "";

    /* renamed from: a */
    public JSONObject m2016a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.f1515a > -1) {
            jSONObject.put("push_priority", this.f1515a);
        }
        if (this.f1516b > -1) {
            jSONObject.put("push_version", this.f1516b);
        }
        jSONObject.put("push_channelid", this.f1517c);
        jSONObject.put("push_curpkgname", this.f1518d);
        jSONObject.put("push_webappbindinfo", this.f1519e);
        jSONObject.put("push_lightappbindinfo", this.f1520f);
        jSONObject.put("push_sdkclientbindinfo", this.f1521g);
        jSONObject.put("push_clientsbindinfo", this.f1522h);
        jSONObject.put("push_selfbindinfo", this.f1523i);
        return jSONObject;
    }
}
