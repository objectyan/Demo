package com.baidu.sapi2;

import org.json.JSONArray;

class SapiWebView$ShareAccountsConfigInterpreter extends SapiWebView$AbstractInterpreter {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20141a;

    SapiWebView$ShareAccountsConfigInterpreter(SapiWebView sapiWebView) {
        this.f20141a = sapiWebView;
        super(sapiWebView);
    }

    public String interpret(SapiWebView$Command command) {
        JSONArray jsonArray = SapiAccount.toJSONArray(SapiAccountManager.getInstance().getShareAccounts());
        if (jsonArray == null) {
            return null;
        }
        return jsonArray.toString();
    }
}
