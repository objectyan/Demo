package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public interface IncompleteUserAware<R extends SapiResult> extends LoginStatusAware<R> {
    void onIncompleteUser(R r);
}
