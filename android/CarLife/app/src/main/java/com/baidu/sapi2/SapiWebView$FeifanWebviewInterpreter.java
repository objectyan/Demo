package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$FeifanWebviewInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20133a;

    SapiWebView$FeifanWebviewInterpreter(SapiWebView sapiWebView) {
        this.f20133a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20133a) != null) {
            Message msg = new Message();
            msg.what = SocialType.WANDA_FEIFAN.getType();
            SapiWebView.v(this.f20133a).sendMessage(msg);
        }
        return null;
    }
}
