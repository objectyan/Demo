package com.baidu.sapi2.result;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccount;

public class ReloginResult
  extends SapiResult
{
  public static final int ERROR_CODE_EMPTY_BDUSS = -101;
  public static final int ERROR_CODE_EMPTY_PASSWORD = -102;
  public static final String ERROR_MSG_EMPTY_BDUSS = "BDUSS不能为空";
  public static final String ERROR_MSG_EMPTY_PASSWORD = "密码不能为空";
  public SapiAccount session;
  
  public ReloginResult()
  {
    this.msgMap.put(-101, "BDUSS不能为空");
    this.msgMap.put(-102, "密码不能为空");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/ReloginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */