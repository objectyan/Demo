package com.baidu.baidunavis.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class AudioUtils
{
  public static final int STREAM_NAVI_TTS = 3;
  private static final String TAG = AudioUtils.class.getSimpleName();
  public static boolean sIsPaused;
  public static AudioManager.OnAudioFocusChangeListener sOnAudioFocusChange = new AudioManager.OnAudioFocusChangeListener()
  {
    public void onAudioFocusChange(int paramAnonymousInt)
    {
      NavLogUtils.e(AudioUtils.TAG, "baidunavis onAudioFocusChange focusChange = " + paramAnonymousInt);
      switch (paramAnonymousInt)
      {
      case -3: 
      case -1: 
      case 0: 
      case 1: 
      default: 
        return;
      }
      BaseTTSPlayer.getInstance().stopTTS();
      AudioUtils.releaseAudioFocus(NavMapAdapter.getInstance().getContainerActivity());
    }
  };
  public static int sVolumeBeforePause = 0;
  
  public static AudioManager getAudioManager(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public static int getCurrentVolume(Context paramContext)
  {
    int i = 11;
    if (paramContext != null) {}
    try
    {
      i = getAudioManager(paramContext).getStreamVolume(getStreamType());
      return i;
    }
    catch (Exception paramContext) {}
    return 11;
  }
  
  public static int getStreamType()
  {
    try
    {
      getAudioManager(NavMapAdapter.getInstance().getContainerActivity()).getStreamVolume(3);
      return 3;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 3;
  }
  
  public static void pauseTTS(Context paramContext)
  {
    int i = getCurrentVolume(paramContext);
    if (i != 0)
    {
      sVolumeBeforePause = i;
      sIsPaused = true;
      setVolume(paramContext, 0);
    }
  }
  
  public static boolean releaseAudioFocus(Context paramContext)
  {
    NavLogUtils.e(TAG, "baidunavis releaseAudioFocus");
    if (paramContext == null)
    {
      NavLogUtils.e(TAG, "baidunavis releaseAudioFocus context is null");
      return false;
    }
    getAudioManager(paramContext).abandonAudioFocus(sOnAudioFocusChange);
    return true;
  }
  
  public static boolean requestAudioFocus(Context paramContext)
  {
    NavLogUtils.e(TAG, "baidunavis requestAudioFocus");
    if (paramContext == null) {
      NavLogUtils.e(TAG, "baidunavis requestAudioFocus context is null");
    }
    for (;;)
    {
      return false;
      try
      {
        paramContext = getAudioManager(paramContext);
        if (paramContext != null)
        {
          int i = paramContext.requestAudioFocus(sOnAudioFocusChange, getStreamType(), 3);
          if (i == 1) {
            return true;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
  
  public static boolean requestAudioFocusToStopMusic(Context paramContext)
  {
    NavLogUtils.e(TAG, "baidunavis requestAudioFocus");
    if (paramContext == null) {
      NavLogUtils.e(TAG, "baidunavis requestAudioFocus context is null");
    }
    for (;;)
    {
      return false;
      try
      {
        paramContext = getAudioManager(paramContext);
        if (paramContext != null)
        {
          int i = paramContext.requestAudioFocus(sOnAudioFocusChange, getStreamType(), 2);
          if (i == 1) {
            return true;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
  
  public static void resumeTTS(final Context paramContext)
  {
    if (!sIsPaused) {
      return;
    }
    sIsPaused = false;
    BNWorkerCenter.getInstance().submitNormalTaskDelay(new BNWorkerNormalTask("AudioUtils.resumeTTS", null)new BNWorkerConfig
    {
      protected String execute()
      {
        AudioUtils.setVolume(paramContext, AudioUtils.sVolumeBeforePause);
        return null;
      }
    }, new BNWorkerConfig(100, 0), 2000L);
  }
  
  public static void setVolume(Context paramContext, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      getAudioManager(paramContext).setStreamVolume(getStreamType(), paramInt, 0);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void volumeDown(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      int i = getCurrentVolume(paramContext);
      if (i > 0) {
        setVolume(paramContext, i - 1);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void volumeUp(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      AudioManager localAudioManager = getAudioManager(paramContext);
      int i = localAudioManager.getStreamMaxVolume(getStreamType());
      int j = localAudioManager.getStreamVolume(getStreamType());
      if (j < i) {
        setVolume(paramContext, j + 1);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/AudioUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */