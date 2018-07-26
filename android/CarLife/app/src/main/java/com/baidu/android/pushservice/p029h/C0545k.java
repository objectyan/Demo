package com.baidu.android.pushservice.p029h;

import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.k */
public class C0545k extends C0535n {
    /* renamed from: a */
    public String f1803a = "";
    /* renamed from: b */
    public int f1804b = -1;
    /* renamed from: c */
    public int f1805c = -1;
    /* renamed from: k */
    public String f1806k;

    public C0545k(C0535n c0535n) {
        super(c0535n);
    }

    /* renamed from: a */
    public JSONObject m2330a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(C2125n.f6748P, this.e);
        jSONObject.put("network_status", this.f);
        if (this.f1805c != -1) {
            jSONObject.put("msg_type", this.f1805c);
        }
        if (!TextUtils.isEmpty(this.f1803a)) {
            jSONObject.put("msg_id", this.f1803a);
        }
        if (this.f1804b > 0) {
            jSONObject.put("msg_len", this.f1804b);
        }
        if (this.f1806k != null) {
            jSONObject.put("msg_open_by", this.f1806k);
        }
        jSONObject.put("err_code", this.g);
        return jSONObject;
    }
}
