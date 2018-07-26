package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.sapi2.utils.C4913L;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SapiWebView$Command {
    /* renamed from: a */
    private String f20099a;
    /* renamed from: b */
    private List<String> f20100b = new ArrayList();
    /* renamed from: c */
    private String f20101c;

    SapiWebView$Command() {
    }

    public String getActionName() {
        return this.f20099a;
    }

    public List<String> getActionParams() {
        return this.f20100b;
    }

    public String getCallbackName() {
        return this.f20101c;
    }

    public static SapiWebView$Command parse(String command) {
        if (TextUtils.isEmpty(command)) {
            return null;
        }
        try {
            JSONObject object = new JSONObject(command.toString());
            SapiWebView$Command context = new SapiWebView$Command();
            JSONObject action = object.optJSONObject(VoiceKey.ACTION);
            if (action != null) {
                context.f20099a = action.optString("name");
                JSONArray params = action.optJSONArray("params");
                if (params != null) {
                    for (int i = 0; i < params.length(); i++) {
                        context.f20100b.add(params.optString(i));
                    }
                }
            }
            JSONObject callback = object.optJSONObject("callback");
            if (callback == null) {
                return context;
            }
            context.f20101c = callback.optString("name");
            return context;
        } catch (JSONException e) {
            C4913L.m16374e(e);
            return null;
        }
    }
}
