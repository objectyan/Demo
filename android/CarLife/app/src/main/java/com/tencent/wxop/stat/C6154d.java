package com.tencent.wxop.stat;

import com.baidu.mobstat.Config;
import com.tencent.wxop.stat.p291b.C6144m;
import com.tencent.wxop.stat.p291b.C6150s;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.d */
public class C6154d {
    /* renamed from: a */
    public static final int f25008a = 0;
    /* renamed from: b */
    public static final int f25009b = 1;
    /* renamed from: c */
    public static final int f25010c = 2;
    /* renamed from: d */
    public static final int f25011d = 3;
    /* renamed from: e */
    public static final int f25012e = 4;
    /* renamed from: f */
    public static final int f25013f = 5;
    /* renamed from: g */
    public static final int f25014g = 6;
    /* renamed from: h */
    public static final int f25015h = 7;
    /* renamed from: i */
    private String f25016i = "";
    /* renamed from: j */
    private int f25017j = 0;
    /* renamed from: k */
    private String f25018k = "";
    /* renamed from: l */
    private String f25019l = "";

    public C6154d(String str) {
        this.f25016i = str;
    }

    public C6154d(String str, int i) {
        this.f25016i = str;
        this.f25017j = i;
    }

    /* renamed from: a */
    public String m21942a() {
        JSONObject jSONObject = new JSONObject();
        if (C6144m.m21876c(this.f25016i)) {
            try {
                C6150s.m21920a(jSONObject, Config.APP_VERSION_CODE, this.f25016i);
                jSONObject.put("t", this.f25017j);
                C6150s.m21920a(jSONObject, Config.SESSTION_END_TIME, this.f25018k);
                C6150s.m21920a(jSONObject, "e1", this.f25019l);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public void m21943a(int i) {
        this.f25017j = i;
    }

    /* renamed from: a */
    public void m21944a(String str) {
        this.f25016i = str;
    }

    /* renamed from: b */
    public String m21945b() {
        return this.f25016i;
    }

    /* renamed from: b */
    public void m21946b(String str) {
        this.f25018k = str;
    }

    /* renamed from: c */
    public int m21947c() {
        return this.f25017j;
    }

    /* renamed from: c */
    public void m21948c(String str) {
        this.f25019l = str;
    }

    /* renamed from: d */
    public String m21949d() {
        return this.f25018k;
    }

    /* renamed from: e */
    public String m21950e() {
        return this.f25019l;
    }

    public String toString() {
        return "StatAccount [account=" + this.f25016i + ", accountType=" + this.f25017j + ", ext=" + this.f25018k + ", ext1=" + this.f25019l + "]";
    }
}
