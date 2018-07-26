package com.baidu.sapi2;

class SapiWebView$9 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20093a;

    SapiWebView$9(SapiWebView sapiWebView) {
        this.f20093a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.q(this.f20093a) != null) {
            SapiWebView.q(this.f20093a).handleFastReg();
        } else {
            this.f20093a.loadFastReg();
        }
        return null;
    }
}
