package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;

public abstract interface IncompleteUserAware<R extends SapiResult>
  extends LoginStatusAware<R>
{
  public abstract void onIncompleteUser(R paramR);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/IncompleteUserAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */