package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;

public class SoundUtils
{
  private AssetFileDescriptor afd = null;
  private boolean loadSuccess = false;
  private int soundID = -1;
  private SoundPool sp = null;
  
  public SoundUtils(int paramInt)
  {
    initSoundPool(paramInt);
  }
  
  private void initSoundPool(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.loadSuccess = false;
      return;
    }
    try
    {
      this.afd = JarUtils.getResources().openRawResourceFd(paramInt);
      if (this.afd == null)
      {
        this.loadSuccess = false;
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        this.afd = null;
      }
    }
    for (;;)
    {
      try
      {
        this.sp = new SoundPool(3, 3, 0);
        if (Build.VERSION.SDK_INT >= 8)
        {
          this.sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
          {
            public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              if (paramAnonymousInt2 == 0)
              {
                SoundUtils.access$002(SoundUtils.this, true);
                try
                {
                  if (SoundUtils.this.afd != null) {
                    SoundUtils.this.afd.close();
                  }
                  return;
                }
                catch (IOException paramAnonymousSoundPool)
                {
                  LogUtil.e("initSoundPool", "close afd failed, " + paramAnonymousSoundPool);
                  return;
                }
              }
              SoundUtils.access$002(SoundUtils.this, false);
            }
          });
          this.soundID = this.sp.load(this.afd, 1);
          if ((Build.VERSION.SDK_INT >= 8) || (this.afd == null)) {
            break;
          }
          try
          {
            this.afd.close();
            return;
          }
          catch (Exception localException2)
          {
            LogUtil.e("initSoundPool", "close afd failed, " + localException2);
            return;
          }
        }
        this.loadSuccess = true;
      }
      catch (Exception localException3)
      {
        LogUtil.e("initSoundPool", "new SoundPool err, " + localException3);
        this.loadSuccess = false;
        return;
      }
    }
  }
  
  public static boolean isCalling(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getCallState())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean play()
  {
    if (BNSettingManager.getVoiceMode() == 2) {
      LogUtil.e("SoundUtils", "voice mode is Quite, return");
    }
    do
    {
      return false;
      localObject = BNaviModuleManager.getContext();
    } while ((isCalling((Context)localObject)) || (localObject == null) || (!this.loadSuccess) || (this.sp == null));
    Object localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    float f = ((AudioManager)localObject).getStreamMaxVolume(3);
    f = ((AudioManager)localObject).getStreamVolume(3) / f;
    this.sp.play(this.soundID, f, f, 1, 0, 1.0F);
    return true;
  }
  
  public void release()
  {
    if (this.sp != null)
    {
      if (this.loadSuccess) {
        this.sp.unload(this.soundID);
      }
      this.sp.release();
      this.sp = null;
    }
  }
  
  public void stop()
  {
    if (this.sp != null) {
      this.sp.stop(3);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SoundUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */