package com.baidu.android.pushservice.p029h;

import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.h */
public class C0542h extends C0535n {
    /* renamed from: a */
    public String f1791a;
    /* renamed from: b */
    public int f1792b;
    /* renamed from: c */
    public int f1793c;

    public C0542h(C0535n c0535n) {
        super(c0535n);
    }

    public C0542h(String str, int i, String str2, int i2) {
        this.j = str;
        this.f1792b = i;
        this.f1791a = str2;
        this.f1793c = i2;
        this.d = "050101";
        this.e = System.currentTimeMillis();
    }

    /* renamed from: a */
    public JSONObject m2325a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(C2125n.f6748P, this.e);
        jSONObject.put("msg_type", this.f1793c);
        return jSONObject;
    }
}
