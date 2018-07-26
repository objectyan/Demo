package com.baidu.sapi2;

import android.os.Message;

class SapiWebView$QRcodeLoginInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20137a;

    SapiWebView$QRcodeLoginInterpreter(SapiWebView sapiWebView) {
        this.f20137a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.w(this.f20137a) != null) {
            SapiWebView.w(this.f20137a).sendMessage(new Message());
        }
        return null;
    }
}
