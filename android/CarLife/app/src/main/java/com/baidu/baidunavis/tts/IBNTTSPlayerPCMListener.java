package com.baidu.baidunavis.tts;

public abstract interface IBNTTSPlayerPCMListener
{
  public abstract void handlePCMStream(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public abstract void notifyTTSEnd();
  
  public abstract void notifyTTSStart();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/IBNTTSPlayerPCMListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */