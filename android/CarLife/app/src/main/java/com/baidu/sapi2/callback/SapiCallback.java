package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public interface SapiCallback<R extends SapiResult> {
    void onFailure(R r);

    void onFinish();

    void onStart();

    void onSuccess(R r);
}
