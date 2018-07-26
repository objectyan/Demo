package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$TXWeiboWebviewInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20149a;

    SapiWebView$TXWeiboWebviewInterpreter(SapiWebView sapiWebView) {
        this.f20149a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20149a) != null) {
            Message msg = new Message();
            msg.what = SocialType.TENCENT_WEIBO.getType();
            SapiWebView.v(this.f20149a).sendMessage(msg);
        }
        return null;
    }
}
