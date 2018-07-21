package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.GetRegCodeResult;

public abstract class GetRegCodeCallback
  implements SapiCallback<GetRegCodeResult>
{
  public abstract void onPhoneNumberExist(GetRegCodeResult paramGetRegCodeResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/GetRegCodeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */