package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiAccountResponse;

@Deprecated
public abstract class FillUsernameCallBack implements SapiCallBack<SapiAccountResponse> {
    public abstract void onInvalidBduss();

    public abstract void onUserHaveUsername();

    public abstract void onUsernameAlreadyExist();

    public abstract void onUsernameFormatError();
}
