package com.baidu.android.pushservice.p029h;

import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.b */
public class C0536b extends C0535n {
    /* renamed from: a */
    public String f1755a;
    /* renamed from: b */
    public String f1756b;
    /* renamed from: c */
    public String f1757c;

    public C0536b(C0535n c0535n) {
        super(c0535n);
    }

    /* renamed from: a */
    public JSONObject m2263a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(C2125n.f6748P, this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("msg_result", this.f1755a);
        jSONObject.put("request_id", this.f1756b);
        jSONObject.put("err_code", this.g);
        if (!TextUtils.isEmpty(this.f1757c)) {
            jSONObject.put("channel", this.f1757c);
        }
        return jSONObject;
    }
}
