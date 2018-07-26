package com.baidu.sapi2;

import com.baidu.sapi2.shell.response.SocialResponse;

class SapiWebView$29 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SocialResponse f20078a;
    /* renamed from: b */
    final /* synthetic */ SapiWebView f20079b;

    SapiWebView$29(SapiWebView sapiWebView, SocialResponse socialResponse) {
        this.f20079b = sapiWebView;
        this.f20078a = socialResponse;
    }

    public void run() {
        SapiWebView.k(this.f20079b).onFailed(this.f20078a.errorCode, this.f20078a.errorMsg);
        SapiWebView.b(this.f20079b, null);
    }
}
