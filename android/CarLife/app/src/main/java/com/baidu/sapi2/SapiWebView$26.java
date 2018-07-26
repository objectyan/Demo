package com.baidu.sapi2;

class SapiWebView$26 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f20071a;
    /* renamed from: b */
    final /* synthetic */ SapiWebView f20072b;

    SapiWebView$26(SapiWebView sapiWebView, String str) {
        this.f20072b = sapiWebView;
        this.f20071a = str;
    }

    public void run() {
        SapiWebView.b(this.f20072b, this.f20071a);
    }
}
