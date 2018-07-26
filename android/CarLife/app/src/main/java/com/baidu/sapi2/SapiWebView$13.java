package com.baidu.sapi2;

import com.baidu.sapi2.utils.SapiUtils;

class SapiWebView$13 extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20043a;

    SapiWebView$13(SapiWebView sapiWebView) {
        this.f20043a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiUtils.isValidPhoneNumber(SapiWebView.d(this.f20043a).presetPhoneNumber)) {
            return SapiWebView.d(this.f20043a).presetPhoneNumber;
        }
        String localPhoneNumber = SapiWebView.u(this.f20043a);
        return !SapiUtils.isValidPhoneNumber(localPhoneNumber) ? "" : localPhoneNumber;
    }
}
