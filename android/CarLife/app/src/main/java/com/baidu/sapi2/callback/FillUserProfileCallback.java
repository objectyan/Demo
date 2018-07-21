package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FillUserProfileResult;

public abstract class FillUserProfileCallback
  implements LoginStatusAware<FillUserProfileResult>
{
  public abstract void onCompleteUser(FillUserProfileResult paramFillUserProfileResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/FillUserProfileCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */