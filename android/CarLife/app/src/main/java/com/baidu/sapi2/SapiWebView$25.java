package com.baidu.sapi2;

import android.widget.Toast;

class SapiWebView$25 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20070a;

    SapiWebView$25(SapiWebView sapiWebView) {
        this.f20070a = sapiWebView;
    }

    public void run() {
        Toast.makeText(this.f20070a.getContext(), "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式", 0).show();
    }
}
