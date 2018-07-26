package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$HuaweiSSOintrpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20134a;

    SapiWebView$HuaweiSSOintrpreter(SapiWebView sapiWebView) {
        this.f20134a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20134a) != null) {
            Message msg = new Message();
            msg.what = SocialType.HUAWEI.getType();
            SapiWebView.v(this.f20134a).sendMessage(msg);
        }
        return null;
    }
}
