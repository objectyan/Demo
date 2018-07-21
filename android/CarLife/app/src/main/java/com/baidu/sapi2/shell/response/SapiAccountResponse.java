package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.SapiAccount.ReloginCredentials;
import com.baidu.sapi2.utils.enums.AccountType;

public class SapiAccountResponse
  extends SapiResponse
{
  public AccountType accountType = AccountType.UNKNOWN;
  public String authSid;
  public String bduss = "";
  public String displayname = "";
  public String email = "";
  public boolean newReg;
  public String ptoken = "";
  public SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
  public String stoken = "";
  public String uid = "";
  public String username = "";
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/shell/response/SapiAccountResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */