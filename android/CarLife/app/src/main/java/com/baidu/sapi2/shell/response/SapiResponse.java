package com.baidu.sapi2.shell.response;

public class SapiResponse
{
  public int errorCode;
  public String errorMsg;
  
  public SapiResponse()
  {
    this.errorCode = -100;
    this.errorMsg = "";
  }
  
  public SapiResponse(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.errorMsg = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/shell/response/SapiResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */