package com.baidu.sapi2.result;

import android.util.SparseArray;

public class OAuthResult
  extends SapiResult
{
  public static final String ERROR_MSG_UNKNOWN = "授权失败";
  public static final String RESULT_MSG_SUCCESS = "授权成功";
  public String accessToken;
  public int expiresIn;
  public String extra;
  public String refreshToken;
  public String scope;
  public String sessionKey;
  public String sessionSecret;
  
  public OAuthResult()
  {
    this.msgMap.put(0, "授权成功");
    this.msgMap.put(65334, "授权失败");
  }
  
  public String toString()
  {
    return "OAuthResult{accessToken='" + this.accessToken + '\'' + ", expiresIn=" + this.expiresIn + ", refreshToken='" + this.refreshToken + '\'' + ", scope='" + this.scope + '\'' + ", sessionKey='" + this.sessionKey + '\'' + ", sessionSecret='" + this.sessionSecret + '\'' + ", extra='" + this.extra + '\'' + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/result/OAuthResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */