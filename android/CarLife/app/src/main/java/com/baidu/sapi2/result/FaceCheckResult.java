package com.baidu.sapi2.result;

import android.util.SparseArray;

public class FaceCheckResult
  extends SapiResult
{
  public static final int RESULT_CODE_ACCOUNT_TYPE_CONFLICT = 3;
  public static final int RESULT_CODE_BDUSS_EXPIRED = 1;
  public static final String RESULT_MSG_ACCOUNT_TYPE_CONFLICT = "请选择帐号类型";
  public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
  public String authId;
  public String authToken;
  public String faceId;
  public boolean hasFace;
  public boolean isTrusted;
  public String uid;
  
  public FaceCheckResult()
  {
    this.msgMap.put(1, "用户登录状态失效，请重新登录");
    this.msgMap.put(3, "请选择帐号类型");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/FaceCheckResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */