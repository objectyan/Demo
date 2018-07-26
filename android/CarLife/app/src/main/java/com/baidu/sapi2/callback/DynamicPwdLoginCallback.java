package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.DynamicPwdLoginResult;

public abstract class DynamicPwdLoginCallback implements SapiCallbackInterceptor<DynamicPwdLoginResult> {
    public void beforeSuccess(DynamicPwdLoginResult result) {
    }
}
