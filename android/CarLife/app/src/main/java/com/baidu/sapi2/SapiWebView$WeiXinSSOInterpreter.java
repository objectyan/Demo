package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$WeiXinSSOInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20155a;

    SapiWebView$WeiXinSSOInterpreter(SapiWebView sapiWebView) {
        this.f20155a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20155a) != null) {
            Message msg = new Message();
            msg.what = SocialType.WEIXIN.getType();
            SapiWebView.v(this.f20155a).sendMessage(msg);
        }
        return null;
    }
}
