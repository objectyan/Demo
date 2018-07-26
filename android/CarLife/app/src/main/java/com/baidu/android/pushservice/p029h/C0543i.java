package com.baidu.android.pushservice.p029h;

import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.i */
public class C0543i extends C0535n {
    /* renamed from: a */
    public int f1794a;
    /* renamed from: b */
    public String f1795b;
    /* renamed from: c */
    public String f1796c;

    public C0543i(C0535n c0535n) {
        super(c0535n);
    }

    /* renamed from: a */
    public JSONObject m2326a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(C2125n.f6748P, this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("heart", this.f1794a);
        jSONObject.put("err_code", this.g);
        jSONObject.put("msg_result", this.i);
        if (!TextUtils.isEmpty(this.f1795b)) {
            jSONObject.put("msg_id", this.f1795b);
        }
        if (!TextUtils.isEmpty(this.f1796c)) {
            jSONObject.put("msg_open_by", this.f1796c);
        }
        return jSONObject;
    }
}
