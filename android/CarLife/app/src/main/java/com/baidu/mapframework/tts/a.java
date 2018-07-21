package com.baidu.mapframework.tts;

import android.os.Handler;
import com.baidu.baidunavis.control.NavTTSController;
import com.baidu.baidunavis.tts.BaseTTSPlayer;

public class a
  implements ITTSPlayer
{
  public void addOnTTSStateChangeListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    BaseTTSPlayer.getInstance().addOnTTSStateChangedListener(paramOnTTSStateChangedListener);
  }
  
  public void changeTTSPlayerVolume(boolean paramBoolean)
  {
    BaseTTSPlayer.getInstance().changeTTSPlayerVolume(paramBoolean);
  }
  
  public int getCurrentProgress()
  {
    return BaseTTSPlayer.getInstance().getCurrentProgress();
  }
  
  public int getInitState()
  {
    return BaseTTSPlayer.getInstance().getInitState();
  }
  
  public int getState()
  {
    return BaseTTSPlayer.getInstance().getTTSState();
  }
  
  public String getVoicePath(String paramString)
  {
    return NavTTSController.getInstant().getVoicePath(paramString);
  }
  
  public int init()
  {
    c.a(com.baidu.platform.comapi.c.f());
    return 0;
  }
  
  public int pause()
  {
    return BaseTTSPlayer.getInstance().pauseTTS();
  }
  
  public boolean pauseAllDownload()
  {
    return NavTTSController.getInstant().pauseAllDownload();
  }
  
  public boolean pauseDownload(String paramString)
  {
    return NavTTSController.getInstant().pauseDownload(paramString);
  }
  
  public int playText(String paramString, boolean paramBoolean)
  {
    return BaseTTSPlayer.getInstance().playTTSText(paramString, paramBoolean);
  }
  
  public boolean recoveryToNavVoice()
  {
    return NavTTSController.getInstant().recoveryToNavVoice();
  }
  
  public void registCallbackHandler(Handler paramHandler)
  {
    NavTTSController.getInstant().registCallbackHandler(paramHandler);
  }
  
  public void release()
  {
    BaseTTSPlayer.getInstance().releaseTTSPlayer();
  }
  
  public void removeOnTTSStateChangeListener(OnTTSStateChangedListener paramOnTTSStateChangedListener)
  {
    BaseTTSPlayer.getInstance().removeOnTTSStateChangedListener(paramOnTTSStateChangedListener);
  }
  
  public int resume()
  {
    return BaseTTSPlayer.getInstance().resumeTTS();
  }
  
  public void setOnTTSPlayCompleteListener(final OnTTSPlayCompleteListener paramOnTTSPlayCompleteListener)
  {
    paramOnTTSPlayCompleteListener = new OnTTSStateChangedListener()
    {
      public void onPlayEnd()
      {
        paramOnTTSPlayCompleteListener.onPlayComplete();
      }
      
      public void onPlayError(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onPlayStart() {}
    };
    BaseTTSPlayer.getInstance().setOnTTSStateChangedListener(paramOnTTSPlayCompleteListener);
  }
  
  public void setOnTTSPlayErrorListener(OnTTSPlayErrorListener paramOnTTSPlayErrorListener) {}
  
  public void setOnTTSPlayStartListener(OnTTSPlayStartListener paramOnTTSPlayStartListener) {}
  
  public void setPlayModeAsync()
  {
    BaseTTSPlayer.getInstance().setPlayModeAsync();
  }
  
  public void setPlayModeSync()
  {
    BaseTTSPlayer.getInstance().setPlayModeSync();
  }
  
  public int setTTSPlaySpeed(int paramInt)
  {
    return BaseTTSPlayer.getInstance().setPlaySpeed(paramInt);
  }
  
  public boolean startDownload(String paramString)
  {
    return NavTTSController.getInstant().startDownload(paramString);
  }
  
  public void stop()
  {
    BaseTTSPlayer.getInstance().stopTTS();
  }
  
  public boolean switchVoice(String paramString1, String paramString2)
  {
    return NavTTSController.getInstant().switchVoice(paramString1, paramString2);
  }
  
  public void unregistCallbackHandler(Handler paramHandler)
  {
    NavTTSController.getInstant().unregistCallbackHandler(paramHandler);
  }
  
  public int xdPlayText(String paramString, boolean paramBoolean)
  {
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */