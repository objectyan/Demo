package com.baidu.navisdk.comapi.tts;

public abstract interface IBNTTSPlayerListener
{
  public static final int PLAYER_STATE_ERROR = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_NOT_INIT = 0;
  public static final int PLAYER_STATE_PAUSE = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  
  public abstract int cancelAudio();
  
  public abstract int getTTSState();
  
  public abstract void initTTSPlayer();
  
  public abstract boolean isNaviMuteState();
  
  public abstract void pauseTTS();
  
  public abstract void phoneCalling();
  
  public abstract void phoneHangUp();
  
  public abstract int playAudio(String paramString, AudioPlayerListener paramAudioPlayerListener);
  
  public abstract int playTTSText(String paramString1, String paramString2, int paramInt);
  
  public abstract int playXDTTSText(String paramString1, String paramString2, int paramInt);
  
  public abstract void releaseTTSPlayer();
  
  public abstract void resumeTTS();
  
  public abstract void setNaviMuteState(boolean paramBoolean);
  
  public abstract void stopTTS();
  
  public static abstract interface AudioPlayerListener
  {
    public abstract void playCompletion();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/tts/IBNTTSPlayerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */