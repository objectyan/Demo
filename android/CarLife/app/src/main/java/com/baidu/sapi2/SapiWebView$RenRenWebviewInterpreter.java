package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$RenRenWebviewInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20139a;

    SapiWebView$RenRenWebviewInterpreter(SapiWebView sapiWebView) {
        this.f20139a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20139a) != null) {
            Message msg = new Message();
            msg.what = SocialType.RENREN.getType();
            SapiWebView.v(this.f20139a).sendMessage(msg);
        }
        return null;
    }
}
