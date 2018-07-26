package com.baidu.sapi2;

class SapiWebView$18 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20053a;

    SapiWebView$18(SapiWebView sapiWebView) {
        this.f20053a = sapiWebView;
    }

    public void run() {
        if (SapiWebView.l(this.f20053a) != null) {
            SapiWebView.l(this.f20053a).setVisibility(8);
        }
        if (SapiWebView.F(this.f20053a) != null) {
            SapiWebView.F(this.f20053a).setVisibility(0);
        }
    }
}
