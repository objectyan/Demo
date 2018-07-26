package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.GetUserInfoResponse;

@Deprecated
public abstract class GetUserInfoCallBack implements SapiCallBack<GetUserInfoResponse> {
    public abstract void onBdussInvalid();

    public abstract void onFinish();
}
