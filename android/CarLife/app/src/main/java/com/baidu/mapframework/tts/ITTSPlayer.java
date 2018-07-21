package com.baidu.mapframework.tts;

import android.os.Handler;

public abstract interface ITTSPlayer
{
  public abstract void addOnTTSStateChangeListener(OnTTSStateChangedListener paramOnTTSStateChangedListener);
  
  public abstract void changeTTSPlayerVolume(boolean paramBoolean);
  
  public abstract int getCurrentProgress();
  
  public abstract int getInitState();
  
  public abstract int getState();
  
  public abstract String getVoicePath(String paramString);
  
  public abstract int init();
  
  public abstract int pause();
  
  public abstract boolean pauseAllDownload();
  
  public abstract boolean pauseDownload(String paramString);
  
  public abstract int playText(String paramString, boolean paramBoolean);
  
  public abstract boolean recoveryToNavVoice();
  
  public abstract void registCallbackHandler(Handler paramHandler);
  
  public abstract void release();
  
  public abstract void removeOnTTSStateChangeListener(OnTTSStateChangedListener paramOnTTSStateChangedListener);
  
  public abstract int resume();
  
  public abstract void setOnTTSPlayCompleteListener(OnTTSPlayCompleteListener paramOnTTSPlayCompleteListener);
  
  public abstract void setOnTTSPlayErrorListener(OnTTSPlayErrorListener paramOnTTSPlayErrorListener);
  
  public abstract void setOnTTSPlayStartListener(OnTTSPlayStartListener paramOnTTSPlayStartListener);
  
  public abstract void setPlayModeAsync();
  
  public abstract void setPlayModeSync();
  
  public abstract int setTTSPlaySpeed(int paramInt);
  
  public abstract boolean startDownload(String paramString);
  
  public abstract void stop();
  
  public abstract boolean switchVoice(String paramString1, String paramString2);
  
  public abstract void unregistCallbackHandler(Handler paramHandler);
  
  public abstract int xdPlayText(String paramString, boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/ITTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */