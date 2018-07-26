package com.baidu.android.pushservice.p026e;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.e.u */
public class C0505u extends C0488d {
    /* renamed from: e */
    protected String f1625e = null;

    public C0505u(C0496l c0496l, Context context, String str) {
        super(c0496l, context);
        this.f1625e = str;
    }

    /* renamed from: a */
    protected void mo1286a(HashMap<String, String> hashMap) {
        super.mo1286a((HashMap) hashMap);
        hashMap.put("method", "sendmsgtoserver");
        if (this.f1625e != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f1625e);
                if (jSONObject.has("to")) {
                    hashMap.put("cb_url", jSONObject.getString("to"));
                }
                if (jSONObject.has("data")) {
                    hashMap.put("cb_data", jSONObject.getString("data"));
                }
            } catch (JSONException e) {
            }
        }
    }
}
