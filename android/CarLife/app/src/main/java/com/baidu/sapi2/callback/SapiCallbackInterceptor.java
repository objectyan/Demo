package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public abstract interface SapiCallbackInterceptor<R extends SapiResult>
  extends SapiCallback<R>
{
  public abstract void beforeSuccess(R paramR);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/SapiCallbackInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */