package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FillUserProfileResult;

public abstract class FillUserProfileCallback implements LoginStatusAware<FillUserProfileResult> {
    public abstract void onCompleteUser(FillUserProfileResult fillUserProfileResult);
}
