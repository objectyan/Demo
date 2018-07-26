package com.baidu.sapi2;

import com.baidu.sapi2.share.C4908a;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.C4913L;

class SapiWebView$27 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiAccount f20073a;
    /* renamed from: b */
    final /* synthetic */ SapiAccountResponse f20074b;
    /* renamed from: c */
    final /* synthetic */ SapiWebView f20075c;

    SapiWebView$27(SapiWebView sapiWebView, SapiAccount sapiAccount, SapiAccountResponse sapiAccountResponse) {
        this.f20075c = sapiWebView;
        this.f20073a = sapiAccount;
        this.f20074b = sapiAccountResponse;
    }

    public void run() {
        try {
            SapiWebView.k(this.f20075c).beforeSuccess(this.f20073a);
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        C4908a.m16342a().m16350a(this.f20073a);
        SapiWebView.a(this.f20075c, this.f20074b.accountType);
    }
}
