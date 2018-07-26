package com.tencent.wxop.stat.p291b;

import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.b.c */
public class C6134c {
    /* renamed from: a */
    private String f24890a = null;
    /* renamed from: b */
    private String f24891b = null;
    /* renamed from: c */
    private String f24892c = null;
    /* renamed from: d */
    private String f24893d = "0";
    /* renamed from: e */
    private int f24894e;
    /* renamed from: f */
    private int f24895f = 0;
    /* renamed from: g */
    private long f24896g = 0;

    public C6134c(String str, String str2, int i) {
        this.f24890a = str;
        this.f24891b = str2;
        this.f24894e = i;
    }

    /* renamed from: a */
    JSONObject m21835a() {
        JSONObject jSONObject = new JSONObject();
        try {
            C6150s.m21920a(jSONObject, "ui", this.f24890a);
            C6150s.m21920a(jSONObject, Config.DEVICE_MAC_ID, this.f24891b);
            C6150s.m21920a(jSONObject, "mid", this.f24893d);
            C6150s.m21920a(jSONObject, "aid", this.f24892c);
            jSONObject.put(MapObjKey.OBJ_SL_TIME, this.f24896g);
            jSONObject.put("ver", this.f24895f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m21836a(int i) {
        this.f24894e = i;
    }

    /* renamed from: b */
    public String m21837b() {
        return this.f24890a;
    }

    /* renamed from: c */
    public String m21838c() {
        return this.f24891b;
    }

    /* renamed from: d */
    public int m21839d() {
        return this.f24894e;
    }

    public String toString() {
        return m21835a().toString();
    }
}
