package com.baidu.che.codriver.h;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.baidu.che.codriver.sdk.a.k;
import com.baidu.che.codriver.util.h;

public class a
  implements AudioManager.OnAudioFocusChangeListener
{
  public static final String a = "AudioFocusManager";
  private static final Object b = new Object();
  private static a c;
  private AudioManager d;
  private boolean e = false;
  private Handler f;
  
  public static a a()
  {
    if (c == null) {}
    synchronized (b)
    {
      if (c == null) {
        c = new a();
      }
      return c;
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.d == null) {
      this.d = ((AudioManager)paramContext.getSystemService("audio"));
    }
    if (this.f == null) {
      this.f = new Handler();
    }
  }
  
  public int b()
  {
    h.b("AudioFocusManager", "AudioFocusManager.requestVrAudioFocus() mHasFocus=" + this.e);
    if (1 == this.d.requestAudioFocus(this, 3, 2))
    {
      h.b("AudioFocusManager", "requestVrAudioFocus succeed!");
      return 1;
    }
    return 0;
  }
  
  public int c()
  {
    h.b("AudioFocusManager", "AudioFocusManager.abandonVrAudioFocus() mHasFocus=" + this.e);
    if (1 == this.d.abandonAudioFocus(this))
    {
      h.b("AudioFocusManager", "abandonVrAudioFocus succeed!");
      return 1;
    }
    return 0;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    h.b("AudioFocusManager", "onAudioFocusChange focusChange=" + paramInt);
    k.a().b();
    switch (paramInt)
    {
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */