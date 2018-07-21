package com.baidu.baidunavis.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;

public class SoundUtils
{
  private static final int MSG_TYPE_RELOAD_SOUND_RES = 1;
  private static final String TAG = SoundUtils.class.getSimpleName();
  private boolean loadSuccess = false;
  private Context mContext = null;
  private Handler mHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData())
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        NavLogUtils.e(SoundUtils.TAG, "handleMessage loadSuccess = " + SoundUtils.this.loadSuccess + ", sp = " + SoundUtils.this.sp);
      } while ((SoundUtils.this.loadSuccess) || (SoundUtils.this.sp == null));
      try
      {
        if (Build.VERSION.SDK_INT >= 8) {
          SoundUtils.this.sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
          {
            public void onLoadComplete(SoundPool paramAnonymous2SoundPool, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              NavLogUtils.e(SoundUtils.TAG, "handleMessage onLoadComplete soundPool = " + paramAnonymous2SoundPool + ", status = " + paramAnonymous2Int2 + ", sampleId = " + paramAnonymous2Int1);
              paramAnonymous2SoundPool = SoundUtils.this;
              if (paramAnonymous2Int2 == 0) {}
              for (boolean bool = true;; bool = false)
              {
                SoundUtils.access$102(paramAnonymous2SoundPool, bool);
                return;
              }
            }
          });
        }
        for (;;)
        {
          Context localContext = (Context)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          SoundUtils.access$302(SoundUtils.this, SoundUtils.this.sp.load(localContext, i, 1));
          return;
          SoundUtils.access$102(SoundUtils.this, true);
        }
        return;
      }
      catch (Exception paramAnonymousMessage) {}
    }
  };
  private int soundID = -1;
  private SoundPool sp = null;
  
  public SoundUtils(int paramInt)
  {
    initSoundPool(paramInt);
  }
  
  public SoundUtils(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    initSoundPool(paramContext, paramInt);
  }
  
  private void initSoundPool(int paramInt)
  {
    Context localContext = NavMapAdapter.getInstance().getJNIInitializerContext();
    if ((localContext == null) || (paramInt <= 0)) {
      this.loadSuccess = false;
    }
    for (;;)
    {
      return;
      try
      {
        this.sp = new SoundPool(3, 3, 0);
        if (this.sp == null) {
          continue;
        }
        if (Build.VERSION.SDK_INT >= 8) {
          this.sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
          {
            public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              boolean bool = true;
              if (SoundUtils.this.mHandler != null) {
                SoundUtils.this.mHandler.removeMessages(1);
              }
              paramAnonymousSoundPool = SoundUtils.this;
              if (paramAnonymousInt2 == 0) {}
              for (;;)
              {
                SoundUtils.access$102(paramAnonymousSoundPool, bool);
                return;
                bool = false;
              }
            }
          });
        }
        for (;;)
        {
          this.soundID = this.sp.load(localContext, paramInt, 1);
          if ((this.mHandler == null) || (this.loadSuccess)) {
            break;
          }
          Message localMessage = this.mHandler.obtainMessage(1);
          localMessage.obj = localContext;
          localMessage.arg1 = paramInt;
          this.mHandler.sendMessageDelayed(localMessage, 3000L);
          return;
          this.loadSuccess = true;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void initSoundPool(Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (paramInt <= 0)) {
      this.loadSuccess = false;
    }
    for (;;)
    {
      return;
      try
      {
        this.sp = new SoundPool(3, 4, 0);
        if (this.sp == null) {
          continue;
        }
        if (Build.VERSION.SDK_INT >= 8) {
          this.sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
          {
            public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              paramAnonymousSoundPool = SoundUtils.this;
              if (paramAnonymousInt2 == 0) {}
              for (boolean bool = true;; bool = false)
              {
                SoundUtils.access$102(paramAnonymousSoundPool, bool);
                return;
              }
            }
          });
        }
        for (;;)
        {
          this.soundID = this.sp.load(paramContext, paramInt, 1);
          return;
          this.loadSuccess = true;
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean play()
  {
    if (BNSettingManager.getVoiceMode() == 2) {
      NavLogUtils.e("SoundUtils", "voice mode is Quite, return");
    }
    while (BdTTSPlayer.isCalling(BNaviModuleManager.getContext())) {
      return false;
    }
    AudioManager localAudioManager = null;
    Context localContext;
    if (this.mContext == null)
    {
      localContext = NavMapAdapter.getInstance().getJNIInitializerContext();
      if (localContext == null) {}
    }
    for (localAudioManager = (AudioManager)localContext.getSystemService("audio");; localAudioManager = (AudioManager)this.mContext.getSystemService("audio"))
    {
      NavLogUtils.e(TAG, "play loadSuccess = " + this.loadSuccess + ", sp = " + this.sp + ", am = " + localAudioManager);
      if ((!this.loadSuccess) || (this.sp == null) || (localAudioManager == null)) {
        break;
      }
      float f = localAudioManager.getStreamMaxVolume(3);
      f = localAudioManager.getStreamVolume(3) / f;
      this.sp.play(this.soundID, f, f, 1, 0, 1.0F);
      return true;
    }
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/tts/SoundUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */