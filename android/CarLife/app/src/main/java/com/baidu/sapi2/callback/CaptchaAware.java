package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public interface CaptchaAware<R extends SapiResult> extends SapiCallback<R> {
    void onCaptchaRequired(R r);
}
