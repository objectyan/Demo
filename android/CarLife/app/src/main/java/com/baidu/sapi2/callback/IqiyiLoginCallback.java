package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.IqiyiLoginResult;

public abstract class IqiyiLoginCallback
  implements SapiCallback<IqiyiLoginResult>
{
  public abstract void onBindWebview(IqiyiLoginResult paramIqiyiLoginResult);
  
  public abstract void onLogin(IqiyiLoginResult paramIqiyiLoginResult);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/callback/IqiyiLoginCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */