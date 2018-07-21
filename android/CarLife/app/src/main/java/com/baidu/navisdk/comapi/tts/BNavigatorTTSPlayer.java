package com.baidu.navisdk.comapi.tts;

import com.baidu.navisdk.jni.nativeif.JNITTSPlayer;

public class BNavigatorTTSPlayer
{
  private static int mHandle = 0;
  private static BNavigatorTTSPlayer mInstance;
  private static JNITTSPlayer mJNIPlayer;
  
  public static BNavigatorTTSPlayer getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNavigatorTTSPlayer();
    }
    return mInstance;
  }
  
  public int getTTSState()
  {
    return TTSPlayerControl.getTTSState();
  }
  
  public void init() {}
  
  public void init(IBNTTSPlayerListener paramIBNTTSPlayerListener) {}
  
  public void pauseVoiceTTSOutput() {}
  
  public int playOver()
  {
    return -1;
  }
  
  public int playTTSText(String paramString, boolean paramBoolean)
  {
    return 0;
  }
  
  public void resumeVoiceTTSOutput() {}
  
  public void setPhoneIn(boolean paramBoolean) {}
  
  public void setTTSPlayerListener(IBNTTSPlayerListener paramIBNTTSPlayerListener)
  {
    init(paramIBNTTSPlayerListener);
  }
  
  public void stopVoiceTTSOutput() {}
  
  public void unInit() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/tts/BNavigatorTTSPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */