package com.baidu.sapi2;

class SapiWebView$VoiceLoginInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20154a;

    SapiWebView$VoiceLoginInterpreter(SapiWebView sapiWebView) {
        this.f20154a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.A(this.f20154a) != null) {
            SapiWebView.A(this.f20154a).handleVoiceLogin();
        }
        return null;
    }
}
