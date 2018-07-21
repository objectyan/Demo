package com.baidu.navisdk.util.listener;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.navisdk.util.common.LogUtil;

public class MediaFocuseChangeListener
{
  private static final String TAG = MediaFocuseChangeListener.class.getSimpleName();
  public static AudioManager.OnAudioFocusChangeListener sOnAudioFocusChange = new AudioManager.OnAudioFocusChangeListener()
  {
    public void onAudioFocusChange(int paramAnonymousInt)
    {
      LogUtil.e(MediaFocuseChangeListener.TAG, "sdk onAudioFocusChange focusChange = " + paramAnonymousInt);
      if (paramAnonymousInt == 1) {}
      while ((paramAnonymousInt == -2) || (paramAnonymousInt != -1)) {
        return;
      }
    }
  };
  
  public static AudioManager getAudioManager(Context paramContext)
  {
    return (AudioManager)paramContext.getSystemService("audio");
  }
  
  public static boolean releaseAudioFocus(Context paramContext)
  {
    LogUtil.e(TAG, "sdk releaseAudioFocus");
    if (paramContext == null) {
      LogUtil.e(TAG, "sdk releaseAudioFocus context is null");
    }
    do
    {
      return false;
      paramContext = getAudioManager(paramContext);
    } while (paramContext == null);
    paramContext.abandonAudioFocus(sOnAudioFocusChange);
    return true;
  }
  
  public static boolean requestAudioFocus(Context paramContext)
  {
    LogUtil.e(TAG, "sdk requestAudioFocus");
    if (paramContext == null) {
      LogUtil.e(TAG, "sdk requestAudioFocus context is null");
    }
    do
    {
      return false;
      paramContext = getAudioManager(paramContext);
    } while ((paramContext == null) || (paramContext.requestAudioFocus(sOnAudioFocusChange, 3, 2) != 1));
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/listener/MediaFocuseChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */