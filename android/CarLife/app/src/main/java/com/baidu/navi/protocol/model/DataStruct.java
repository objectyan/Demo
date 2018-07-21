package com.baidu.navi.protocol.model;

import android.os.Bundle;
import java.util.Map;

public class DataStruct
{
  public static String KEY_ERROR_CODE = "errCode";
  public static String KEY_ERROR_STRING = "errString";
  public static String KEY_METHOD_NAME = "methodName";
  public CommandResult commandResult = new CommandResult();
  public String mCmd;
  public Map<String, Object> mParams;
  
  public class CommandResult
  {
    public int errCode;
    public String errString = "";
    public Bundle params;
    
    public CommandResult() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/protocol/model/DataStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */