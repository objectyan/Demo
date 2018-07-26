package com.baidu.sapi2;

import android.widget.Toast;

public class SapiWebView$DefaultHuaweiHandler implements SapiWebView$HuaweiHandler {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20104a;

    public SapiWebView$DefaultHuaweiHandler(SapiWebView sapiWebView) {
        this.f20104a = sapiWebView;
    }

    public void handleHuaweiLoginFailure() {
        Toast.makeText(this.f20104a.getContext(), "未登录华为帐号", 1).show();
        this.f20104a.finish();
    }
}
