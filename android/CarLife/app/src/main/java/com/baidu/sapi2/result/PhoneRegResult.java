package com.baidu.sapi2.result;

import android.util.SparseArray;

public class PhoneRegResult
  extends SapiResult
{
  public static final int ERROR_CODE_EMPTY_PASSWORD = -102;
  public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
  public static final int ERROR_CODE_EMPTY_REG_CODE = -103;
  public static final String ERROR_MSG_EMPTY_PASSWORD = "请输入密码";
  public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
  public static final String ERROR_MSG_EMPTY_REG_CODE = "请输入激活码";
  public static final String RESULT_MSG_SUCCESS = "注册成功";
  
  public PhoneRegResult()
  {
    this.msgMap.put(0, "注册成功");
    this.msgMap.put(-101, "请输入手机号");
    this.msgMap.put(-102, "请输入密码");
    this.msgMap.put(-103, "请输入激活码");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/PhoneRegResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */