package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.QrPCLoginResponse;

@Deprecated
public abstract class QrPCLoginCallBack implements SapiCallBack<QrPCLoginResponse> {
    public abstract void onBdussInvalid();

    public abstract void onQrCodeInvalid();

    public abstract void onUserNotNormalized();

    public void onFinish() {
    }

    public void onNetworkFailed() {
    }
}
