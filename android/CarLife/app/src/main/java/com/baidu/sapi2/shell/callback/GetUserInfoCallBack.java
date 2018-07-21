package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.GetUserInfoResponse;

@Deprecated
public abstract class GetUserInfoCallBack
  implements SapiCallBack<GetUserInfoResponse>
{
  public abstract void onBdussInvalid();
  
  public abstract void onFinish();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/sapi2/shell/callback/GetUserInfoCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */