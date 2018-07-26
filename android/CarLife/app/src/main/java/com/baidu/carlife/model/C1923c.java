package com.baidu.carlife.model;

import com.baidu.carlife.core.C1260i;
import org.json.JSONObject;

/* compiled from: AppUpdateModel */
/* renamed from: com.baidu.carlife.model.c */
public class C1923c {
    /* renamed from: a */
    public static final int f5939a = 0;
    /* renamed from: b */
    public static final int f5940b = 1;
    /* renamed from: c */
    public static final int f5941c = 0;
    /* renamed from: d */
    public static final int f5942d = 1;
    /* renamed from: e */
    public static final int f5943e = 0;
    /* renamed from: f */
    public static final int f5944f = 1;
    /* renamed from: g */
    public int f5945g;
    /* renamed from: h */
    public int f5946h;
    /* renamed from: i */
    public int f5947i;
    /* renamed from: j */
    public int f5948j;
    /* renamed from: k */
    public String f5949k;
    /* renamed from: l */
    public String f5950l;
    /* renamed from: m */
    public String f5951m;
    /* renamed from: n */
    public String f5952n;

    /* renamed from: a */
    public static C1923c m7383a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        C1260i.m4435b("AppModel", jsonObject.toString());
        C1923c model = new C1923c();
        model.f5945g = jsonObject.optInt("hasNewVersion");
        model.f5946h = jsonObject.optInt("updateType");
        model.f5947i = jsonObject.optInt("downloadType");
        model.f5948j = jsonObject.optInt("newAppSize");
        model.f5949k = jsonObject.optString("newAppDescription");
        model.f5950l = jsonObject.optString("newAppVersionName");
        model.f5951m = jsonObject.optString("url");
        model.f5952n = jsonObject.optString("checkSum");
        return model;
    }

    public String toString() {
        return "hasNewVersion:" + this.f5945g + ", updateType:" + this.f5946h + ", downloadType:" + this.f5947i + ", newAppSize:" + this.f5948j + ", newAppDescription:" + this.f5949k + ", newAppVersionName:" + this.f5950l + ", url:" + this.f5951m + ", checkSum:" + this.f5952n;
    }
}
