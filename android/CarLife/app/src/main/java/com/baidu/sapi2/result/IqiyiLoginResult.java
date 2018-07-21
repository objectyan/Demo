package com.baidu.sapi2.result;

import android.util.SparseArray;

public class IqiyiLoginResult
  extends SapiResult
{
  public static final int ERROR_CODE_ACCESSTOKEN_NULL_FAILURE = -101;
  public static final String ERROR_MSG_ACCESSTOKEN_NULL_FAILURE = "无权限（accesstoken == null)";
  public String nextUrl;
  
  public IqiyiLoginResult()
  {
    this.msgMap.put(-101, "无权限（accesstoken == null)");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/IqiyiLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */