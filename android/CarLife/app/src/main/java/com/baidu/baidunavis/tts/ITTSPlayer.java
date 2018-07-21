package com.baidu.baidunavis.tts;

public abstract interface ITTSPlayer
{
  public abstract void changeTTSPlayerVolume(boolean paramBoolean);
  
  public abstract int getState();
  
  public abstract int init();
  
  public abstract int playText(String paramString, boolean paramBoolean);
  
  public abstract void release();
  
  public abstract void setPlayModeAsync();
  
  public abstract void setPlayModeSync();
  
  public abstract void stop();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/ITTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */