package com.baidu.speech.asr;

public abstract interface ASRListener
{
  public abstract void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void onEvent(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/asr/ASRListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */