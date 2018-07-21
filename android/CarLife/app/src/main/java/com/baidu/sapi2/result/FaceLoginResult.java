package com.baidu.sapi2.result;

import android.util.SparseArray;

public class FaceLoginResult
  extends SapiResult
{
  public static final int RESULT_CODE_PWD_VERIFY_FAILURE = 4;
  public static final String RESULT_MSG_PWD_VERIFY_FAILURE = "密码验证错误";
  
  public FaceLoginResult()
  {
    this.msgMap.put(4, "密码验证错误");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/FaceLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */