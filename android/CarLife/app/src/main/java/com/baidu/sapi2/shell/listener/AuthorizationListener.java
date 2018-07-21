package com.baidu.sapi2.shell.listener;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.AccountType;

public abstract class AuthorizationListener
{
  public void beforeSuccess(SapiAccount paramSapiAccount) {}
  
  public abstract void onFailed(int paramInt, String paramString);
  
  public boolean onForgetPwd()
  {
    return false;
  }
  
  public void onSuccess() {}
  
  public void onSuccess(AccountType paramAccountType) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/shell/listener/AuthorizationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */