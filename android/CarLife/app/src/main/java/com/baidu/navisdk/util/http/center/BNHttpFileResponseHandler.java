package com.baidu.navisdk.util.http.center;

import java.io.File;

public abstract class BNHttpFileResponseHandler implements IBNHttpResponseHandler {
    public abstract void onFailure(int i, Throwable th, File file);

    public abstract void onSuccess(int i, File file);
}
