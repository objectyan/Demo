package com.baidu.carlife.core.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.util.Timer;
import java.util.TimerTask;

public class b
{
  private static final String a = "Audio-" + b.class.getSimpleName();
  private static b b;
  private boolean c = false;
  private boolean d = false;
  private AudioManager e;
  private Timer f;
  private TimerTask g;
  private boolean h = false;
  private Context i;
  private AudioManager.OnAudioFocusChangeListener j = new AudioManager.OnAudioFocusChangeListener()
  {
    public void onAudioFocusChange(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      case 0: 
      default: 
        return;
      case -1: 
        if (!a.h())
        {
          i.b(b.d(), "music AUDIOFOCUS_LOSS");
          k.b(270, -1);
          return;
        }
        i.b(b.d(), "AUDIOFOCUS_LOSS is triggered");
        b.a(b.this);
        return;
      case -2: 
        i.b(b.d(), "music AUDIOFOCUS_LOSS_TRANSIENT");
        k.b(270, -2);
        return;
      case -3: 
        i.b(b.d(), "music AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
        k.b(270, -3);
        return;
      }
      i.b(b.d(), "music AUDIOFOCUS_GAIN");
      k.b(270, 1);
    }
  };
  
  public static b a()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  private void e()
  {
    try
    {
      i.e(a, "Timer Start");
      this.f = new Timer();
      this.g = new TimerTask()
      {
        public void run()
        {
          if (b.b(b.this) != null)
          {
            if (b.c(b.this)) {
              break label51;
            }
            i.b(b.d(), "delay to send AUDIOFOCUS_LOSS");
            k.b(270, -1);
            b.this.a(false);
          }
          for (;;)
          {
            b.d(b.this);
            return;
            label51:
            b.this.b();
            b.this.a(false);
          }
        }
      };
      this.f.schedule(this.g, 100L);
      return;
    }
    catch (Exception localException)
    {
      i.b(a, "startTimer get exception");
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    i.e(a, "Timer Stop");
    if (this.f != null)
    {
      this.f.cancel();
      this.f = null;
    }
  }
  
  private boolean g()
  {
    return this.h;
  }
  
  public void a(Context paramContext)
  {
    this.i = paramContext;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int b()
  {
    i.b(a, "music request Audio Focus");
    if (this.i == null)
    {
      i.e(a, "mContext is not initialized!");
      return 1;
    }
    this.e = ((AudioManager)this.i.getSystemService("audio"));
    if (this.e.requestAudioFocus(this.j, 3, 1) == 1) {
      return 0;
    }
    return -1;
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */