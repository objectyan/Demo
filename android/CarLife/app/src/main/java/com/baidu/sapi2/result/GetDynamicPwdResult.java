package com.baidu.sapi2.result;

import android.util.SparseArray;

public class GetDynamicPwdResult
  extends SapiResult
{
  public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
  public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
  public static final int RESULT_CODE_CAPTCHA_REQUIRED = 5;
  public static final String RESULT_MSG_SUCCESS = "动态密码发送成功";
  
  public GetDynamicPwdResult()
  {
    this.msgMap.put(0, "动态密码发送成功");
    this.msgMap.put(-101, "请输入手机号");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/GetDynamicPwdResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */