package com.baidu.sapi2;

class SapiWebView$11 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20041a;

    SapiWebView$11(SapiWebView sapiWebView) {
        this.f20041a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        SapiWebView.a(this.f20041a, SapiWebView.r(this.f20041a));
        SapiWebView.r(this.f20041a).f20146a = (String) command.getActionParams().get(0);
        SapiWebView.r(this.f20041a).f20147b = (String) command.getActionParams().get(1);
        SapiWebView.r(this.f20041a).postDelayed(SapiWebView.s(this.f20041a), 15000);
        return null;
    }
}
