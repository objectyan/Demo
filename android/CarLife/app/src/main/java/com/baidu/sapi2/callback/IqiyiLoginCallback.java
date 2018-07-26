package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.IqiyiLoginResult;

public abstract class IqiyiLoginCallback implements SapiCallback<IqiyiLoginResult> {
    public abstract void onBindWebview(IqiyiLoginResult iqiyiLoginResult);

    public abstract void onLogin(IqiyiLoginResult iqiyiLoginResult);
}
