package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.QrAppLoginResponse;

@Deprecated
public abstract class QrAppLoginCallBack implements SapiCallBack<QrAppLoginResponse> {
    public abstract void onBdussInvalid();

    public abstract void onQrCodeInvalid();

    public abstract void onUserNotNormalized();

    public void onFinish() {
    }

    public void onNetworkFailed() {
    }
}
