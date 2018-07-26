package com.baidu.sapi2;

class SapiWebView$8 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20092a;

    SapiWebView$8(SapiWebView sapiWebView) {
        this.f20092a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        this.f20092a.back();
        return null;
    }
}
