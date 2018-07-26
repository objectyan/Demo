package com.baidu.sapi2;

import com.baidu.sapi2.shell.listener.AuthorizationListener;

public class SapiWebView$DefaultAuthorizationListener extends AuthorizationListener {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20103a;

    public SapiWebView$DefaultAuthorizationListener(SapiWebView sapiWebView) {
        this.f20103a = sapiWebView;
    }

    public void onSuccess() {
        this.f20103a.finish();
    }

    public void onFailed(int errorNo, String errorMsg) {
        this.f20103a.finish();
    }
}
