package com.baidu.sapi2;

class SapiWebView$7 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20091a;

    SapiWebView$7(SapiWebView sapiWebView) {
        this.f20091a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        SapiWebView.a(this.f20091a, SapiWebView.j(this.f20091a));
        this.f20091a.finish();
        return null;
    }
}
