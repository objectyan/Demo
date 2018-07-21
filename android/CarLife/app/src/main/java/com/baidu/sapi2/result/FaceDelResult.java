package com.baidu.sapi2.result;

import android.util.SparseArray;

public class FaceDelResult
  extends SapiResult
{
  public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
  public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
  
  public FaceDelResult()
  {
    this.msgMap.put(1, "用户登录状态失效，请重新登录");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/FaceDelResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */