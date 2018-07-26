package com.baidu.sapi2;

class SapiWebView$5 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20089a;

    SapiWebView$5(SapiWebView sapiWebView) {
        this.f20089a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.o(this.f20089a) != null) {
            SapiWebView.o(this.f20089a).handleOtherLogin();
        }
        return null;
    }
}
