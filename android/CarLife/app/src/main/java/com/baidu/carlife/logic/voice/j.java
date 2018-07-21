package com.baidu.carlife.logic.voice;

import android.widget.TextView;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;
import com.baidu.carlife.view.h;

public class j
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  protected int e = 2;
  protected int f;
  protected h g;
  protected TextView h;
  protected int i;
  protected IBNTTSVoiceHintListener j = new IBNTTSVoiceHintListener()
  {
    public void notifyTTSEnd()
    {
      j.this.h.post(new Runnable()
      {
        public void run()
        {
          n.a().i();
        }
      });
    }
    
    @Deprecated
    public void notifyTTSStart() {}
  };
  private IBNTTSVoiceHintListener k = new IBNTTSVoiceHintListener()
  {
    public void notifyTTSEnd()
    {
      j.this.h.post(new Runnable()
      {
        public void run() {}
      });
    }
    
    @Deprecated
    public void notifyTTSStart() {}
  };
  
  public j(h paramh)
  {
    this.g = paramh;
    this.h = paramh.d();
  }
  
  private void c(String paramString)
  {
    com.baidu.carlife.m.a.a().a(this.k);
    com.baidu.carlife.m.a.a().b(paramString, 1);
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void a(int paramInt)
  {
    b(com.baidu.carlife.core.a.a().getString(paramInt));
  }
  
  protected void a(String paramString)
  {
    b();
    com.baidu.carlife.m.a.a().a(this.j);
    com.baidu.carlife.m.a.a().b(paramString, 1);
  }
  
  public void b()
  {
    this.f = 0;
  }
  
  public void b(String paramString)
  {
    this.h.setText(paramString);
    this.h.setVisibility(0);
    int m = this.f + 1;
    this.f = m;
    if (m >= this.e)
    {
      a(paramString);
      return;
    }
    c(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */