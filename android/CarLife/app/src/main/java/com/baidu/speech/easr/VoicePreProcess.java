package com.baidu.speech.easr;

public class VoicePreProcess
{
  static
  {
    try
    {
      try
      {
        System.loadLibrary("FPALG");
        return;
      }
      finally {}
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static synchronized native int initJni(int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2);
  
  public static synchronized native int process(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, short[] paramArrayOfShort);
  
  public static synchronized native int releaseJni(int paramInt);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/easr/VoicePreProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */