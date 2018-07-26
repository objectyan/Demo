package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;

public class ExtraInfo {
    /* renamed from: a */
    String f19361a = "";
    /* renamed from: b */
    String f19362b = "";
    /* renamed from: c */
    String f19363c = "";
    /* renamed from: d */
    String f19364d = "";
    /* renamed from: e */
    String f19365e = "";
    /* renamed from: f */
    String f19366f = "";
    /* renamed from: g */
    String f19367g = "";
    /* renamed from: h */
    String f19368h = "";
    /* renamed from: i */
    String f19369i = "";
    /* renamed from: j */
    String f19370j = "";

    /* renamed from: a */
    private static boolean m15284a(String str, int i) {
        if (str == null) {
            return false;
        }
        int length;
        try {
            length = str.getBytes().length;
        } catch (Exception e) {
            length = 0;
        }
        if (length > i) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static String m15283a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (m15284a(str, 1024)) {
            return "";
        }
        return str;
    }

    public String getV1() {
        return this.f19361a;
    }

    public void setV1(String str) {
        this.f19361a = m15283a(str);
    }

    public String getV2() {
        return this.f19362b;
    }

    public void setV2(String str) {
        this.f19362b = m15283a(str);
    }

    public String getV3() {
        return this.f19363c;
    }

    public void setV3(String str) {
        this.f19363c = m15283a(str);
    }

    public String getV4() {
        return this.f19364d;
    }

    public void setV4(String str) {
        this.f19364d = m15283a(str);
    }

    public String getV5() {
        return this.f19365e;
    }

    public void setV5(String str) {
        this.f19365e = m15283a(str);
    }

    public String getV6() {
        return this.f19366f;
    }

    public void setV6(String str) {
        this.f19366f = m15283a(str);
    }

    public String getV7() {
        return this.f19367g;
    }

    public void setV7(String str) {
        this.f19367g = m15283a(str);
    }

    public String getV8() {
        return this.f19368h;
    }

    public void setV8(String str) {
        this.f19368h = m15283a(str);
    }

    public String getV9() {
        return this.f19369i;
    }

    public void setV9(String str) {
        this.f19369i = m15283a(str);
    }

    public String getV10() {
        return this.f19370j;
    }

    public void setV10(String str) {
        this.f19370j = m15283a(str);
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f19361a)) {
                jSONObject.put("v1", this.f19361a);
            }
            if (!TextUtils.isEmpty(this.f19362b)) {
                jSONObject.put("v2", this.f19362b);
            }
            if (!TextUtils.isEmpty(this.f19363c)) {
                jSONObject.put("v3", this.f19363c);
            }
            if (!TextUtils.isEmpty(this.f19364d)) {
                jSONObject.put("v4", this.f19364d);
            }
            if (!TextUtils.isEmpty(this.f19365e)) {
                jSONObject.put("v5", this.f19365e);
            }
            if (!TextUtils.isEmpty(this.f19366f)) {
                jSONObject.put("v6", this.f19366f);
            }
            if (!TextUtils.isEmpty(this.f19367g)) {
                jSONObject.put("v7", this.f19367g);
            }
            if (!TextUtils.isEmpty(this.f19368h)) {
                jSONObject.put("v8", this.f19368h);
            }
            if (!TextUtils.isEmpty(this.f19369i)) {
                jSONObject.put("v9", this.f19369i);
            }
            if (!TextUtils.isEmpty(this.f19370j)) {
                jSONObject.put("v10", this.f19370j);
            }
        } catch (Throwable e) {
            db.m15664c(e);
        }
        return jSONObject;
    }
}
