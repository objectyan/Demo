package com.baidu.mapframework.tts;

import android.os.Handler;

public class MapTTSPlayer
{
  private ITTSPlayer a = null;
  
  public static MapTTSPlayer getInstance()
  {
    return a.a();
  }
  
  public void addOnTTSPlayerStateListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    if (this.a != null) {
      this.a.addOnTTSStateChangeListener(paramOnTTSStateChangedListener);
    }
  }
  
  public int getCurrentProgress()
  {
    if (this.a != null) {
      return this.a.getCurrentProgress();
    }
    return -1;
  }
  
  public int getInitState()
  {
    return this.a.getInitState();
  }
  
  public int getTTSState()
  {
    if (this.a != null) {
      return this.a.getState();
    }
    return 0;
  }
  
  public String getVoicePath(String paramString)
  {
    if (this.a != null) {
      return this.a.getVoicePath(paramString);
    }
    return "";
  }
  
  public void initPlayer()
  {
    if (this.a == null) {
      this.a = new a();
    }
  }
  
  public boolean pauseAllDownload()
  {
    if (this.a != null) {
      return this.a.pauseAllDownload();
    }
    return false;
  }
  
  public boolean pauseDownload(String paramString)
  {
    if (this.a != null) {
      return this.a.pauseDownload(paramString);
    }
    return false;
  }
  
  public int pauseTTS()
  {
    if (this.a != null) {
      return this.a.pause();
    }
    return -1;
  }
  
  public int playTTSText(String paramString, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.playText(paramString, paramBoolean);
    }
    return 0;
  }
  
  public boolean recoveryToNavVoice()
  {
    if (this.a != null) {
      return this.a.recoveryToNavVoice();
    }
    return false;
  }
  
  public void registCallbackHandler(Handler paramHandler)
  {
    if (this.a != null) {
      this.a.registCallbackHandler(paramHandler);
    }
  }
  
  public void releaseTTSPlayer()
  {
    if (this.a != null) {
      this.a.release();
    }
  }
  
  public void removeOnTTSPlayerStateListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    if (this.a != null) {
      this.a.removeOnTTSStateChangeListener(paramOnTTSStateChangedListener);
    }
  }
  
  public int resumeTTS()
  {
    if (this.a != null) {
      return this.a.resume();
    }
    return -1;
  }
  
  public void setOnTTSPlayCompleteListener(OnTTSPlayCompleteListener paramOnTTSPlayCompleteListener)
  {
    if (paramOnTTSPlayCompleteListener != null) {
      this.a.setOnTTSPlayCompleteListener(paramOnTTSPlayCompleteListener);
    }
  }
  
  public void setOnTTSPlayStartListener(OnTTSPlayStartListener paramOnTTSPlayStartListener)
  {
    if (paramOnTTSPlayStartListener != null) {
      this.a.setOnTTSPlayStartListener(paramOnTTSPlayStartListener);
    }
  }
  
  public void setPlayModeAsync()
  {
    if (this.a != null) {
      this.a.setPlayModeAsync();
    }
  }
  
  public void setPlayModeSync()
  {
    if (this.a != null) {
      this.a.setPlayModeSync();
    }
  }
  
  public int setTTSPlaySpeed(int paramInt)
  {
    if (this.a != null) {
      return this.a.setTTSPlaySpeed(paramInt);
    }
    return -1;
  }
  
  public boolean startDownload(String paramString)
  {
    if (this.a != null) {
      return this.a.startDownload(paramString);
    }
    return false;
  }
  
  public void stopTTS()
  {
    if (this.a != null) {
      this.a.stop();
    }
  }
  
  public boolean switchVoice(String paramString1, String paramString2)
  {
    if (this.a != null) {
      return this.a.switchVoice(paramString1, paramString2);
    }
    return false;
  }
  
  public void unregistCallbackHandler(Handler paramHandler)
  {
    if (this.a != null) {
      this.a.unregistCallbackHandler(paramHandler);
    }
  }
  
  public int xdPlayTTSText(String paramString, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.xdPlayText(paramString, paramBoolean);
    }
    return 0;
  }
  
  private static final class a
  {
    private static final MapTTSPlayer a = new MapTTSPlayer(null);
  }
  
  public static class b
  {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
  }
  
  public static class c
  {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/MapTTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */