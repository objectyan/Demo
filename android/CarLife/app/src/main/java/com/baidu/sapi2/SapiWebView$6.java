package com.baidu.sapi2;

class SapiWebView$6 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20090a;

    SapiWebView$6(SapiWebView sapiWebView) {
        this.f20090a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        String phoneNumber = (String) command.getActionParams().get(0);
        if (SapiWebView.p(this.f20090a) != null) {
            SapiWebView.p(this.f20090a).onPhoneNumberExist(phoneNumber);
        }
        return null;
    }
}
