package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import org.json.JSONException;
import org.json.JSONObject;

class SapiWebView$UniteVerifyResultInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20153a;

    SapiWebView$UniteVerifyResultInterpreter(SapiWebView sapiWebView) {
        this.f20153a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        try {
            JSONObject resultJSON = new JSONObject((String) command.getActionParams().get(0));
            String verifyInfo = resultJSON.optString("info");
            String redirectUrl = resultJSON.optString("u");
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = resultJSON.optString("passuid");
            sapiAccount.username = resultJSON.optString("username");
            sapiAccount.displayname = resultJSON.optString(SapiAccountManager.SESSION_DISPLAYNAME);
            sapiAccount.bduss = resultJSON.optString("bduss");
            sapiAccount.ptoken = resultJSON.optString(SapiAccountManager.SESSION_PTOKEN);
            sapiAccount.stoken = resultJSON.optString(SapiAccountManager.SESSION_STOKEN);
            if (!(TextUtils.isEmpty(verifyInfo) || !SapiUtils.isValidAccount(sapiAccount) || SapiWebView.D(this.f20153a) == null)) {
                SapiWebView.D(this.f20153a).onSuccess(verifyInfo, redirectUrl, sapiAccount);
            }
        } catch (JSONException e) {
            C4913L.m16374e(e);
        }
        return null;
    }
}
