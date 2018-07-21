package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FillUsernameResult;

public abstract class FillUsernameCallback
  implements LoginStatusAware<FillUsernameResult>
{
  public abstract void onUserHaveUsername(FillUsernameResult paramFillUsernameResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/FillUsernameCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */