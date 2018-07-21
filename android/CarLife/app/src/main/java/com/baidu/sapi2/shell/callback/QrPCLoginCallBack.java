package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.QrPCLoginResponse;

@Deprecated
public abstract class QrPCLoginCallBack
  implements SapiCallBack<QrPCLoginResponse>
{
  public abstract void onBdussInvalid();
  
  public void onFinish() {}
  
  public void onNetworkFailed() {}
  
  public abstract void onQrCodeInvalid();
  
  public abstract void onUserNotNormalized();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/sapi2/shell/callback/QrPCLoginCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */