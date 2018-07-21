package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.Web2NativeLoginResult;

public abstract class Web2NativeLoginCallback
  implements LoginStatusAware<Web2NativeLoginResult>
{
  public abstract void onBdussEmpty(Web2NativeLoginResult paramWeb2NativeLoginResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/Web2NativeLoginCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */