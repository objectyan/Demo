package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.Web2NativeLoginResult;

public abstract class Web2NativeLoginCallback implements LoginStatusAware<Web2NativeLoginResult> {
    public abstract void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult);
}
