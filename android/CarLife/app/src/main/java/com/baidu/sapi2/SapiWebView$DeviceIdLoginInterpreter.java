package com.baidu.sapi2;

import android.os.Message;

class SapiWebView$DeviceIdLoginInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20106a;

    SapiWebView$DeviceIdLoginInterpreter(SapiWebView sapiWebView) {
        this.f20106a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.x(this.f20106a) != null) {
            SapiWebView.x(this.f20106a).sendMessage(new Message());
        }
        return null;
    }
}
