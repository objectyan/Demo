package com.baidu.sapi2;

class SapiWebView$10 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20040a;

    SapiWebView$10(SapiWebView sapiWebView) {
        this.f20040a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        boolean result = false;
        if (SapiWebView.k(this.f20040a) != null) {
            result = SapiWebView.k(this.f20040a).onForgetPwd();
        }
        return result ? "1" : "0";
    }
}
