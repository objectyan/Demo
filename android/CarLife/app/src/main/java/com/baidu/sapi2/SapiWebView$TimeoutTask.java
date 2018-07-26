package com.baidu.sapi2;

import android.os.Message;

class SapiWebView$TimeoutTask implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20150a;
    /* renamed from: b */
    private String f20151b;

    private SapiWebView$TimeoutTask(SapiWebView sapiWebView) {
        this.f20150a = sapiWebView;
    }

    public void run() {
        if (this.f20150a.getProgress() < 100) {
            Message msg = new Message();
            msg.what = 1;
            msg.obj = this.f20151b;
            SapiWebView.b(this.f20150a).sendMessage(msg);
            SapiWebView.b(this.f20150a).removeCallbacks(this);
        }
    }

    public void setUrl(String url) {
        this.f20151b = url;
    }
}
