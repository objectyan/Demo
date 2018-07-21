package com.baidu.sapi2.result;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccount;

public class FillUserProfileResult
  extends SapiResult
{
  public static final int ERROR_CODE_SIM_UNAVAILABLE = -101;
  public static final String ERROR_MSG_SIM_UNAVAILABLE = "SIM卡不可用，请使用其他绑定方式";
  public static final String ERROR_MSG_UNKNOWN = "绑定失败";
  public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
  public static final int RESULT_CODE_COMPLETE_USER = 61002;
  public static final int RESULT_CODE_PHONE_UNAVAILABLE = 8;
  public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
  public static final String RESULT_MSG_COMPLETE_USER = "用户已绑定手机或邮箱";
  public static final String RESULT_MSG_PHONE_UNAVAILABLE = "手机号被占用，请使用其他绑定方式";
  public static final String RESULT_MSG_SUCCESS = "绑定成功";
  public SapiAccount session;
  
  public FillUserProfileResult()
  {
    this.msgMap.put(0, "绑定成功");
    this.msgMap.put(1, "用户登录状态失效，请重新登录");
    this.msgMap.put(8, "手机号被占用，请使用其他绑定方式");
    this.msgMap.put(61002, "用户已绑定手机或邮箱");
    this.msgMap.put(-101, "SIM卡不可用，请使用其他绑定方式");
    this.msgMap.put(65334, "绑定失败");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/FillUserProfileResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */