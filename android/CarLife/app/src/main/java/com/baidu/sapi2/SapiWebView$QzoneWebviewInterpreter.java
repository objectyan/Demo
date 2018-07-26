package com.baidu.sapi2;

import android.os.Message;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$QzoneWebviewInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20138a;

    SapiWebView$QzoneWebviewInterpreter(SapiWebView sapiWebView) {
        this.f20138a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        if (SapiWebView.v(this.f20138a) != null) {
            Message msg = new Message();
            msg.what = SocialType.QZONE.getType();
            SapiWebView.v(this.f20138a).sendMessage(msg);
        }
        return null;
    }
}
