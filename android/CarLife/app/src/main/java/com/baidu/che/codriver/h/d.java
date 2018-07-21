package com.baidu.che.codriver.h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;
import com.baidu.carlife.m.a;
import com.baidu.che.codriver.util.h;
import java.util.Random;

public class d
{
  public static d a;
  private static final String c = d.class.getSimpleName();
  private static final int g = 3;
  protected IBNTTSVoiceHintListener b = new IBNTTSVoiceHintListener()
  {
    public void notifyTTSEnd()
    {
      h.b(d.f(), "---TTS--onSpeechEnd-----");
      if (d.a(d.this) != null) {
        d.a(d.this).onSpeechFinish(null);
      }
    }
    
    @Deprecated
    public void notifyTTSStart()
    {
      h.b(d.f(), "---TTS--onSpeechStart-----");
      if (d.a(d.this) != null) {
        d.a(d.this).onSpeechStart(null);
      }
    }
  };
  private Context d;
  private b e;
  private String[] f;
  private int h = 0;
  
  private d()
  {
    a.a().a(this.b);
  }
  
  public static d a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    return a(paramString, null);
  }
  
  public int a(final String paramString, b paramb)
  {
    int i = 1;
    this.e = paramb;
    if (TextUtils.isEmpty(paramString))
    {
      if (this.e != null) {
        this.e.onSpeechFinish(paramString);
      }
      return -1;
    }
    int j = a.a().b(paramString, 1);
    if (j == 0) {}
    while (i == 0)
    {
      i = this.h;
      this.h = (i + 1);
      if (i >= 3) {
        break;
      }
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          d.this.a(paramString);
        }
      }, 1000L);
      return j;
      i = 0;
    }
    this.h = 0;
    return j;
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
    this.f = this.d.getResources().getStringArray(2131230789);
  }
  
  public void a(a parama) {}
  
  public void a(com.baidu.che.codriver.ui.d.b paramb, b paramb1)
  {
    a(paramb.g, paramb1);
  }
  
  public void b() {}
  
  public void c()
  {
    a.a().d();
  }
  
  public void d()
  {
    a(this.d.getString(2131298630));
  }
  
  public void e()
  {
    if (this.f == null) {
      return;
    }
    int i = new Random().nextInt(this.f.length);
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.g = this.f[i];
    localb.j = 1;
    com.baidu.che.codriver.ui.b.b.b().b(localb);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */