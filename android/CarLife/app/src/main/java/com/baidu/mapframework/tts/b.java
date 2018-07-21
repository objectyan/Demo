package com.baidu.mapframework.tts;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build.VERSION;

public class b
{
  public static final int a = 3;
  public static final int b = 8;
  private Context c = null;
  private SoundPool d = null;
  private int e = -1;
  private boolean f = false;
  
  public b(Context paramContext, int paramInt)
  {
    this.c = paramContext;
    a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (paramInt <= 0))
    {
      this.f = false;
      return;
    }
    this.d = new SoundPool(3, 4, 0);
    if (Build.VERSION.SDK_INT >= 8) {
      this.d.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
      {
        public void onLoadComplete(SoundPool paramAnonymousSoundPool, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          paramAnonymousSoundPool = b.this;
          if (paramAnonymousInt2 == 0) {}
          for (boolean bool = true;; bool = false)
          {
            b.a(paramAnonymousSoundPool, bool);
            return;
          }
        }
      });
    }
    for (;;)
    {
      this.e = this.d.load(paramContext, paramInt, 1);
      return;
      this.f = true;
    }
  }
  
  public boolean a()
  {
    if ((this.c != null) && (this.f) && (this.d != null))
    {
      AudioManager localAudioManager = (AudioManager)this.c.getSystemService("audio");
      float f1 = localAudioManager.getStreamMaxVolume(3);
      f1 = localAudioManager.getStreamVolume(3) / f1;
      this.d.play(this.e, f1, f1, 1, 0, 1.0F);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.d != null)
    {
      if (this.f) {
        this.d.unload(this.e);
      }
      this.d.release();
      this.d = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/tts/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */