package com.baidu.navisdk.util.http.center;

public abstract class BNHttpBinaryResponseHandler implements IBNHttpResponseHandler {
    public abstract void onFailure(int i, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, byte[] bArr);
}
