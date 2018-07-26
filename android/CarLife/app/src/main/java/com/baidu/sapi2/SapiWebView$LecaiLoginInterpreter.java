package com.baidu.sapi2;

class SapiWebView$LecaiLoginInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20135a;

    SapiWebView$LecaiLoginInterpreter(SapiWebView sapiWebView) {
        this.f20135a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.z(this.f20135a) != null) {
            SapiWebView.z(this.f20135a).handleLCLogin();
        }
        return null;
    }
}
