package com.baidu.speech.asr;

public class ErrorCode
{
  public static final int RECOGNIZER_OK = 0;
  public static final int RECORDING_EXCEPTION = 1001;
  public static final int RECORDING_FILE_OPEN_FAIL = 1005;
  public static final int RECORDING_INTERRUPT = 1003;
  public static final int RECORDING_NO_PERMISSION = 1002;
  public static final int RECORDING_OPEN_FAIL = 1004;
  
  public String getDesc(int paramInt)
  {
    return "";
  }
  
  public String getMessage(int paramInt)
  {
    String str = getDesc(paramInt);
    if (str != null) {
      return str;
    }
    return "错误:" + paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */