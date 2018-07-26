package com.baidu.android.pushservice.p029h;

import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.f */
public class C0539f extends C0535n {
    /* renamed from: a */
    public String f1783a;

    public C0539f(C0535n c0535n) {
        super(c0535n);
    }

    /* renamed from: a */
    public JSONObject m2304a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(C2125n.f6748P, this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("crash_stack", this.f1783a);
        return jSONObject;
    }
}
