package com.baidu.sapi2;

class SapiWebView$17 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20052a;

    SapiWebView$17(SapiWebView sapiWebView) {
        this.f20052a = sapiWebView;
    }

    public void run() {
        if (SapiWebView.l(this.f20052a) != null) {
            SapiWebView.l(this.f20052a).setVisibility(8);
        }
        if (SapiWebView.E(this.f20052a) != null) {
            SapiWebView.E(this.f20052a).setVisibility(0);
        }
    }
}
