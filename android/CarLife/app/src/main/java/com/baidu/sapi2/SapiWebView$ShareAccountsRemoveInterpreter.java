package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.share.C4908a;

class SapiWebView$ShareAccountsRemoveInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20142a;

    SapiWebView$ShareAccountsRemoveInterpreter(SapiWebView sapiWebView) {
        this.f20142a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        String uid = (String) command.getActionParams().get(0);
        if (!TextUtils.isEmpty(uid)) {
            for (SapiAccount account : SapiAccountManager.getInstance().getShareAccounts()) {
                if (uid.equals(account.uid)) {
                    C4908a.m16342a().m16351b(account);
                    break;
                }
            }
        }
        return null;
    }
}
