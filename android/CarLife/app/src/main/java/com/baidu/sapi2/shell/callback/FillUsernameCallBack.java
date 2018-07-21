package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiAccountResponse;

@Deprecated
public abstract class FillUsernameCallBack
  implements SapiCallBack<SapiAccountResponse>
{
  public abstract void onInvalidBduss();
  
  public abstract void onUserHaveUsername();
  
  public abstract void onUsernameAlreadyExist();
  
  public abstract void onUsernameFormatError();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/sapi2/shell/callback/FillUsernameCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */