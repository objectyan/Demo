package com.baidu.sapi2.result;

import android.util.SparseArray;

public class VoiceRegResult
  extends SapiResult
{
  public static final String ERROR_MSG_UNKNOWN = "很遗憾，语音密码创建失败";
  public static final int RESULT_CODE_AUTH_EXPIRED = 62004;
  public static final String RESULT_MSG_AUTH_EXPIRED = "验证信息已过期";
  
  public VoiceRegResult()
  {
    this.msgMap.put(62004, "验证信息已过期");
    this.msgMap.put(65334, "很遗憾，语音密码创建失败");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/VoiceRegResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */