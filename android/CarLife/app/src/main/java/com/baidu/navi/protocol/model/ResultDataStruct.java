package com.baidu.navi.protocol.model;

public class ResultDataStruct
  extends DataStruct
{
  public static final String KEY_ERROR_CODE = "errCode";
  public static final String KEY_ERROR_STRING = "errString";
  public int errCode;
  public String errString;
  
  public ResultDataStruct()
  {
    this.mCmd = "result";
  }
  
  public String toString()
  {
    return "errCode=" + this.errCode + " errString=" + this.errString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/ResultDataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */