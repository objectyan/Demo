package com.baidu.sapi2.result;

import android.util.SparseArray;

public class LoginResult
  extends SapiResult
{
  public static final int ERROR_CODE_EMPTY_ACCOUNT = -101;
  public static final int ERROR_CODE_EMPTY_PASSWORD = -102;
  public static final String ERROR_MSG_EMPTY_ACCOUNT = "请输入帐号";
  public static final String ERROR_MSG_EMPTY_PASSWORD = "请输入密码";
  public static final int RESULT_CODE_CAPTCHA_ERROR = 10;
  public static final int RESULT_CODE_LOGIN_TYPE_CONFLICT = 18;
  public static final int RESULT_CODE_PWD_ERROR = 12;
  public static final String RESULT_MSG_SUCCESS = "登录成功";
  public SapiResult.Action action;
  
  public LoginResult()
  {
    this.msgMap.put(0, "登录成功");
    this.msgMap.put(-101, "请输入帐号");
    this.msgMap.put(-102, "请输入密码");
    this.action = new SapiResult.Action();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/LoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */