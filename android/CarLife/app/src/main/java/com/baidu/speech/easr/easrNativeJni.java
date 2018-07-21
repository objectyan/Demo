package com.baidu.speech.easr;

public class easrNativeJni
{
  static
  {
    try
    {
      try
      {
        System.loadLibrary("bdEASRAndroid");
        return;
      }
      finally {}
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static synchronized native int AECExit();
  
  public static synchronized native int AECGetVolume();
  
  public static synchronized native int AECInit();
  
  public static synchronized native int AECProcess(short[] paramArrayOfShort1, short[] paramArrayOfShort2, short[] paramArrayOfShort3, int paramInt);
  
  public static synchronized native int AECReset();
  
  public static synchronized native int SetLogLevel(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/easr/easrNativeJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */