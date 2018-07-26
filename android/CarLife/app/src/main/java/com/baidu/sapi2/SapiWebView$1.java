package com.baidu.sapi2;

import android.os.Handler;
import android.os.Message;

class SapiWebView$1 extends Handler {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20056a;

    SapiWebView$1(SapiWebView sapiWebView) {
        this.f20056a = sapiWebView;
    }

    public void handleMessage(Message msg) {
        if (msg.what == 1) {
            SapiWebView.a(this.f20056a);
        }
    }
}
