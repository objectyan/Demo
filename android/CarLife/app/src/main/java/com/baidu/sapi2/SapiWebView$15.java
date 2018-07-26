package com.baidu.sapi2;

class SapiWebView$15 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20045a;

    SapiWebView$15(SapiWebView sapiWebView) {
        this.f20045a = sapiWebView;
    }

    public void run() {
        SapiWebView.q(this.f20045a).handleFastReg();
    }
}
