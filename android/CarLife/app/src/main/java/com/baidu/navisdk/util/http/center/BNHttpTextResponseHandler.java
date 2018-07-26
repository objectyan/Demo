package com.baidu.navisdk.util.http.center;

public abstract class BNHttpTextResponseHandler implements IBNHttpResponseHandler {
    public abstract void onFailure(int i, String str, Throwable th);

    public abstract void onSuccess(int i, String str);
}
