package com.baidu.mobstat;

import org.json.JSONObject;

public class be {
    /* renamed from: a */
    public boolean f19439a = false;
    /* renamed from: b */
    public String f19440b = "";
    /* renamed from: c */
    public boolean f19441c = false;

    public be(JSONObject jSONObject) {
        try {
            this.f19439a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Throwable e) {
            bd.m15432b(e);
        }
        try {
            this.f19440b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Throwable e2) {
            bd.m15432b(e2);
        }
        try {
            this.f19441c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Throwable e22) {
            bd.m15432b(e22);
        }
    }

    /* renamed from: a */
    public JSONObject m15436a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f19439a);
        } catch (Throwable e) {
            bd.m15432b(e);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f19440b);
        } catch (Throwable e2) {
            bd.m15432b(e2);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.f19441c);
        } catch (Throwable e22) {
            bd.m15432b(e22);
        }
        return jSONObject;
    }
}
