package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$SinaWeiboWebviewInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20145a;

    SapiWebView$SinaWeiboWebviewInterpreter(SapiWebView sapiWebView) {
        this.f20145a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20145a) != null) {
            Message msg = new Message();
            msg.what = SocialType.SINA_WEIBO.getType();
            SapiWebView.v(this.f20145a).sendMessage(msg);
        }
        return null;
    }
}
