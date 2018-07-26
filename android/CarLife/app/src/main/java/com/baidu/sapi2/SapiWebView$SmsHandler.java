package com.baidu.sapi2;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

class SapiWebView$SmsHandler extends Handler {
    /* renamed from: a */
    String f20146a;
    /* renamed from: b */
    String f20147b;
    /* renamed from: c */
    final /* synthetic */ SapiWebView f20148c;

    private SapiWebView$SmsHandler(SapiWebView sapiWebView) {
        this.f20148c = sapiWebView;
    }

    public void handleMessage(Message msg) {
        if (msg.obj != null) {
            String code = msg.obj;
            if (!(TextUtils.isEmpty(this.f20146a) || TextUtils.isEmpty(this.f20147b))) {
                this.f20148c.loadUrl(String.format("javascript:%s('%s','%s');", new Object[]{this.f20146a, code, this.f20147b}));
            }
            SapiWebView.n(this.f20148c);
            removeCallbacks(SapiWebView.s(this.f20148c));
        }
    }
}
