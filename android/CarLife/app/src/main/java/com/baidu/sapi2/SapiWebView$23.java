package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.enums.SocialType;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

class SapiWebView$23 implements IHwIDCallBack {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20068a;

    SapiWebView$23(SapiWebView sapiWebView) {
        this.f20068a = sapiWebView;
    }

    public void onUserInfo(HashMap userInfo) {
        try {
            String accessToken = (String) userInfo.get("accesstoken");
            String uid = (String) userInfo.get("userID");
            if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(uid)) {
                if (SapiWebView.H(this.f20068a) == null) {
                    SapiWebView.a(this.f20068a, new SapiWebView$DefaultHuaweiHandler(this.f20068a));
                }
                SapiWebView.H(this.f20068a).handleHuaweiLoginFailure();
                return;
            }
            this.f20068a.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(accessToken, "UTF-8"), URLEncoder.encode(uid, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            C4913L.m16374e(e);
        }
    }
}
