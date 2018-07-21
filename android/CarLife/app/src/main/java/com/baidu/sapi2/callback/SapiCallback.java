package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public abstract interface SapiCallback<R extends SapiResult>
{
  public abstract void onFailure(R paramR);
  
  public abstract void onFinish();
  
  public abstract void onStart();
  
  public abstract void onSuccess(R paramR);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/SapiCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */