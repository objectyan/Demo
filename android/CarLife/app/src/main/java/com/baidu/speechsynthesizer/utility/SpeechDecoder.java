package com.baidu.speechsynthesizer.utility;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

public class SpeechDecoder
{
  private static final String TAG = "SpeechDecoder";
  private static OnDecodedDataListener mDecodedDataListener = null;
  
  static
  {
    try
    {
      LoggerProxy.d("SpeechDecoder", "before load gnustl_shared");
      System.loadLibrary("gnustl_shared");
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          LoggerProxy.d("SpeechDecoder", "before load BDSpeechDecoder_V1");
          System.loadLibrary("BDSpeechDecoder_V1");
          LoggerProxy.d("SpeechDecoder", "after load BDSpeechDecoder_V1");
          return;
        }
        catch (Throwable localThrowable2)
        {
          LoggerProxy.e("SpeechDecoder", "so file BDSpeechDecoder_V1 load fail");
        }
        localThrowable1 = localThrowable1;
        LoggerProxy.e("SpeechDecoder", "so file gnustl_shared load fail");
      }
    }
  }
  
  public static native int decodeWithCallback(byte[] paramArrayOfByte, Object paramObject);
  
  public static void setOnDecodedDataListener(OnDecodedDataListener paramOnDecodedDataListener)
  {
    mDecodedDataListener = paramOnDecodedDataListener;
  }
  
  public native int decode(byte[] paramArrayOfByte, int paramInt1, short[] paramArrayOfShort, int[] paramArrayOfInt, int paramInt2, int paramInt3);
  
  public int decodeWithCallback(byte[] paramArrayOfByte)
  {
    return decodeWithCallback(paramArrayOfByte, this);
  }
  
  public void decode_audio_callback(byte[] paramArrayOfByte)
  {
    mDecodedDataListener.onDecodedData(paramArrayOfByte);
  }
  
  public static abstract interface OnDecodedDataListener
  {
    public abstract void onDecodedData(byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speechsynthesizer/utility/SpeechDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */