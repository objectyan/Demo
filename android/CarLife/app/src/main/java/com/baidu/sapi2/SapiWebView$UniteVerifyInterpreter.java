package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.C4913L;
import org.json.JSONException;
import org.json.JSONObject;

class SapiWebView$UniteVerifyInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20152a;

    SapiWebView$UniteVerifyInterpreter(SapiWebView sapiWebView) {
        this.f20152a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        String data = (String) command.getActionParams().get(0);
        if (!(SapiWebView.B(this.f20152a) == null || TextUtils.isEmpty(data))) {
            try {
                JSONObject obj = new JSONObject(data);
                SapiWebView.B(this.f20152a).handleUniteVerify(obj.optString("token"), obj.optString("adtext"));
            } catch (JSONException e) {
                C4913L.m16374e(e);
            }
        }
        return null;
    }
}
