package com.baidu.sapi2.result;

import android.util.SparseArray;

public class VoiceLoginResult
  extends SapiResult
{
  public static final String ERROR_MSG_UNKNOWN = "登录失败";
  public static final int RESULT_CODE_PWD_VERIFY_FAILURE = 71042;
  public static final String RESULT_MSG_PWD_VERIFY_FAILURE = "再试一次";
  
  public VoiceLoginResult()
  {
    this.msgMap.put(71042, "再试一次");
    this.msgMap.put(65334, "登录失败");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/VoiceLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */