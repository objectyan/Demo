package com.baidu.lbsapi.auth;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.lbsapi.auth.c */
class C3155c {
    /* renamed from: a */
    static String m13200a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            jSONObject.put(PushConstants.EXTRA_PUSH_MESSAGE, str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    static String m13201a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", -1);
            jSONObject.put(PushConstants.EXTRA_PUSH_MESSAGE, str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
