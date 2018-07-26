package com.tencent.wxop.stat;

import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.c */
public class C6153c {
    /* renamed from: a */
    private long f25003a = 0;
    /* renamed from: b */
    private int f25004b = 0;
    /* renamed from: c */
    private String f25005c = "";
    /* renamed from: d */
    private int f25006d = 0;
    /* renamed from: e */
    private String f25007e = "";

    /* renamed from: a */
    public long m21931a() {
        return this.f25003a;
    }

    /* renamed from: a */
    public void m21932a(int i) {
        this.f25004b = i;
    }

    /* renamed from: a */
    public void m21933a(long j) {
        this.f25003a = j;
    }

    /* renamed from: a */
    public void m21934a(String str) {
        this.f25005c = str;
    }

    /* renamed from: b */
    public int m21935b() {
        return this.f25004b;
    }

    /* renamed from: b */
    public void m21936b(int i) {
        this.f25006d = i;
    }

    /* renamed from: b */
    public void m21937b(String str) {
        this.f25007e = str;
    }

    /* renamed from: c */
    public String m21938c() {
        return this.f25005c;
    }

    /* renamed from: d */
    public int m21939d() {
        return this.f25006d;
    }

    /* renamed from: e */
    public String m21940e() {
        return this.f25007e;
    }

    /* renamed from: f */
    public JSONObject m21941f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f25003a);
            jSONObject.put("st", this.f25004b);
            if (this.f25005c != null) {
                jSONObject.put("dm", this.f25005c);
            }
            jSONObject.put("pt", this.f25006d);
            if (this.f25007e != null) {
                jSONObject.put("rip", this.f25007e);
            }
            jSONObject.put(MapObjKey.OBJ_SL_TIME, System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
