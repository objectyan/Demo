package com.baidu.sapi2;

import android.widget.Toast;

public class SapiWebView$DefaultWeixinHandler implements SapiWebView$WeixinHandler {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20105a;

    public SapiWebView$DefaultWeixinHandler(SapiWebView sapiWebView) {
        this.f20105a = sapiWebView;
    }

    public void handleNotInstall() {
        Toast.makeText(this.f20105a.getContext(), "微信未安装", 1).show();
    }

    public void handleServerError(String errorCode) {
        Toast.makeText(this.f20105a.getContext(), "服务错误，请稍后重试", 1).show();
    }
}
