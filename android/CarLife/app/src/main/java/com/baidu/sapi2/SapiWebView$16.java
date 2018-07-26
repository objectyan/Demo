package com.baidu.sapi2;

import android.os.Build.VERSION;

class SapiWebView$16 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f20046a;
    /* renamed from: b */
    final /* synthetic */ String f20047b;
    /* renamed from: c */
    final /* synthetic */ String f20048c;
    /* renamed from: d */
    final /* synthetic */ String f20049d;
    /* renamed from: e */
    final /* synthetic */ String f20050e;
    /* renamed from: f */
    final /* synthetic */ SapiWebView f20051f;

    SapiWebView$16(SapiWebView sapiWebView, String str, String str2, String str3, String str4, String str5) {
        this.f20051f = sapiWebView;
        this.f20046a = str;
        this.f20047b = str2;
        this.f20048c = str3;
        this.f20049d = str4;
        this.f20050e = str5;
    }

    public void run() {
        if (VERSION.SDK_INT > 7) {
            this.f20051f.getSettings().setBlockNetworkLoads(true);
        }
        SapiWebView.a(this.f20051f, this.f20046a, this.f20047b, this.f20048c, this.f20049d, this.f20050e);
    }
}
