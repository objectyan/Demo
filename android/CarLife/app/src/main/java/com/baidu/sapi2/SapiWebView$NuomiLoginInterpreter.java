package com.baidu.sapi2;

class SapiWebView$NuomiLoginInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20136a;

    SapiWebView$NuomiLoginInterpreter(SapiWebView sapiWebView) {
        this.f20136a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.y(this.f20136a) != null) {
            SapiWebView.y(this.f20136a).handleNMLogin();
        }
        return null;
    }
}
