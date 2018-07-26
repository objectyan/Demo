package com.baidu.sapi2;

class SapiWebView$ShareStrategyConfigInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20143a;

    SapiWebView$ShareStrategyConfigInterpreter(SapiWebView sapiWebView) {
        this.f20143a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        return SapiWebView.d(this.f20143a).loginShareStrategy().getStrValue();
    }
}
