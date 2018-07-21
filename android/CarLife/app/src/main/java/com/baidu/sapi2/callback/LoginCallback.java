package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.LoginResult;

public abstract class LoginCallback
  implements CaptchaAware<LoginResult>
{
  public abstract void onLoginTypeConflict(LoginResult paramLoginResult);
  
  public abstract void onProxyActionRequired(LoginResult paramLoginResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/LoginCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */