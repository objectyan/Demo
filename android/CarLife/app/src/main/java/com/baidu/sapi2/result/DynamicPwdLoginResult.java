package com.baidu.sapi2.result;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccount;

public class DynamicPwdLoginResult
  extends SapiResult
{
  public static final int ERROR_CODE_EMPTY_DYNAMIC_PWD = -102;
  public static final int ERROR_CODE_EMPTY_PHONE_NUMBER = -101;
  public static final String ERROR_MSG_EMPTY_DYNAMIC_PWD = "请输入动态密码";
  public static final String ERROR_MSG_EMPTY_PHONE_NUMBER = "请输入手机号";
  public static final String RESULT_MSG_SUCCESS = "登录成功";
  public SapiAccount session;
  
  public DynamicPwdLoginResult()
  {
    this.msgMap.put(0, "登录成功");
    this.msgMap.put(-101, "请输入手机号");
    this.msgMap.put(-102, "请输入动态密码");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/DynamicPwdLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */