package com.baidu.sapi2;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.utils.C4913L;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

class SapiWebView$22 implements IUiListener {
    /* renamed from: a */
    final /* synthetic */ Tencent f20066a;
    /* renamed from: b */
    final /* synthetic */ SapiWebView f20067b;

    SapiWebView$22(SapiWebView sapiWebView, Tencent tencent) {
        this.f20067b = sapiWebView;
        this.f20066a = tencent;
    }

    public void onComplete(Object response) {
        if (response == null) {
            this.f20067b.finish();
            return;
        }
        JSONObject jsonResponse = (JSONObject) response;
        if (jsonResponse == null || jsonResponse.length() != 0) {
            try {
                String token = jsonResponse.getString("access_token");
                String expires = jsonResponse.getString("expires_in");
                String openId = jsonResponse.getString("openid");
                if (!(TextUtils.isEmpty(token) || TextUtils.isEmpty(expires) || TextUtils.isEmpty(openId))) {
                    this.f20066a.setAccessToken(token, expires);
                    this.f20066a.setOpenId(openId);
                }
            } catch (Exception e) {
                C4913L.m16374e(e);
            }
            this.f20067b.loadUrl(SapiAccountManager.getInstance().getAccountService().a(this.f20066a.getAccessToken(), this.f20066a.getOpenId()));
            return;
        }
        this.f20067b.finish();
    }

    public void onError(UiError uiError) {
        this.f20067b.finish();
        Toast.makeText(this.f20067b.getContext(), uiError.errorMessage, 1).show();
    }

    public void onCancel() {
        this.f20067b.finish();
    }
}
