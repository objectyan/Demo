package com.baidu.sapi2;

import com.baidu.sapi2.share.C4908a;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.enums.AccountType;

class SapiWebView$28 implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SapiAccount f20076a;
    /* renamed from: b */
    final /* synthetic */ SapiWebView f20077b;

    SapiWebView$28(SapiWebView sapiWebView, SapiAccount sapiAccount) {
        this.f20077b = sapiWebView;
        this.f20076a = sapiAccount;
    }

    public void run() {
        try {
            SapiWebView.k(this.f20077b).beforeSuccess(this.f20076a);
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
        C4908a.m16342a().m16350a(this.f20076a);
        SapiWebView.a(this.f20077b, AccountType.UNKNOWN);
        SapiWebView.b(this.f20077b, null);
    }
}
