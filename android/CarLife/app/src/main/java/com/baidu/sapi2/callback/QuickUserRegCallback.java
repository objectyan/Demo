package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.QuickUserRegResult;

public abstract class QuickUserRegCallback implements CaptchaAware<QuickUserRegResult> {
    public abstract void onUsernameExist(QuickUserRegResult quickUserRegResult);
}
