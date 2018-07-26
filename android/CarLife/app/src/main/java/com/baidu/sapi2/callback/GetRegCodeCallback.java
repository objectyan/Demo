package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.GetRegCodeResult;

public abstract class GetRegCodeCallback implements SapiCallback<GetRegCodeResult> {
    public abstract void onPhoneNumberExist(GetRegCodeResult getRegCodeResult);
}
