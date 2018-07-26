package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public interface LoginStatusAware<R extends SapiResult> extends SapiCallback<R> {
    void onBdussExpired(R r);
}
