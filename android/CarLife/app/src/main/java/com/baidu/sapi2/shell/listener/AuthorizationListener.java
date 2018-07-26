package com.baidu.sapi2.shell.listener;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.AccountType;

public abstract class AuthorizationListener {
    public abstract void onFailed(int i, String str);

    public void onSuccess() {
    }

    public void onSuccess(AccountType accountType) {
    }

    public void beforeSuccess(SapiAccount session) {
    }

    public boolean onForgetPwd() {
        return false;
    }
}
