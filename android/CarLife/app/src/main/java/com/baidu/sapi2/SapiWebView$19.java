package com.baidu.sapi2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.enums.SocialType;

class SapiWebView$19 implements SSOListener {
    /* renamed from: a */
    final /* synthetic */ boolean f20054a;
    /* renamed from: b */
    final /* synthetic */ SapiWebView f20055b;

    SapiWebView$19(SapiWebView sapiWebView, boolean z) {
        this.f20055b = sapiWebView;
        this.f20054a = z;
    }

    public void onComplete(Bundle values) {
        this.f20055b.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, values.getString("access_token"), values.getString("uid")));
    }

    public void onJumpNormal() {
        if (SapiWebView.v(this.f20055b) != null) {
            Message msg = new Message();
            msg.what = SocialType.SINA_WEIBO.getType();
            SapiWebView.v(this.f20055b).sendMessage(msg);
        }
    }

    public void onError(SSOError e) {
        C4913L.m16374e(e);
        Toast.makeText(this.f20055b.getContext(), e.getMessage(), 0).show();
    }

    public void onCancel() {
        if (this.f20054a && (this.f20055b.getContext() instanceof Activity)) {
            ((Activity) this.f20055b.getContext()).finish();
        }
    }
}
