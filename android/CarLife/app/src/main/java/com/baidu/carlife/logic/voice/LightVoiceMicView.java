package com.baidu.carlife.logic.voice;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.carlife.b;
import com.baidu.carlife.c;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.che.codriver.widget.a;

public class LightVoiceMicView
  extends ImageView
  implements c
{
  private static final int a = 0;
  private static final int b = 1;
  private j c;
  private a d;
  private a e;
  private a f;
  private AnimationDrawable g;
  private AnimationDrawable h;
  private AnimationDrawable i;
  private int j = 0;
  
  public LightVoiceMicView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LightVoiceMicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
    i();
    b.a().a(this);
  }
  
  private void h()
  {
    this.c = new a(Looper.getMainLooper());
    k.a(this.c);
  }
  
  private void i()
  {
    this.g = ((AnimationDrawable)getResources().getDrawable(2130837527));
    this.d = new a(this.g)
    {
      public void a()
      {
        LightVoiceMicView.a(LightVoiceMicView.this).stop();
      }
    };
    this.h = ((AnimationDrawable)getResources().getDrawable(2130837540));
    this.e = new a(this.h)
    {
      public void a()
      {
        LightVoiceMicView.b(LightVoiceMicView.this).stop();
      }
    };
    this.i = ((AnimationDrawable)getResources().getDrawable(2130837547));
    this.f = new a(this.i)
    {
      public void a()
      {
        LightVoiceMicView.c(LightVoiceMicView.this).stop();
      }
    };
  }
  
  private void j()
  {
    if (this.j == 0) {
      return;
    }
    setImageResource(0);
    setBackgroundResource(0);
    setBackground(this.d);
    this.d.setOneShot(false);
    this.d.start();
  }
  
  private void k()
  {
    if (this.j == 0) {
      return;
    }
    this.d.setOneShot(true);
    setBackgroundResource(0);
    setBackground(this.f);
    this.f.setOneShot(false);
    this.f.start();
  }
  
  private void l()
  {
    m();
    setBackgroundResource(2130838232);
    setImageResource(2130838348);
    setEnabled(true);
  }
  
  private void m()
  {
    this.f.setOneShot(true);
    this.e.stop();
    this.d.stop();
    this.f.stop();
  }
  
  private void n()
  {
    m();
    setBackgroundResource(0);
    setImageResource(2130838342);
    setEnabled(false);
  }
  
  public void a() {}
  
  public void a(Intent paramIntent) {}
  
  public void b()
  {
    if (n.a().m()) {
      return;
    }
    m.a().b();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    g();
  }
  
  public void g()
  {
    k.a(4101);
    k.a(4100);
    k.a(4159);
    k.b(this.c);
    this.c.removeCallbacksAndMessages(null);
    this.c = null;
    b.a().b(this);
    this.j = 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  private class a
    extends l
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    void a()
    {
      m.a().b();
      LightVoiceMicView.d(LightVoiceMicView.this);
    }
    
    void b()
    {
      LightVoiceMicView.e(LightVoiceMicView.this);
    }
    
    void c()
    {
      super.c();
      LightVoiceMicView.a(LightVoiceMicView.this, 1);
    }
    
    void d()
    {
      super.d();
      LightVoiceMicView.f(LightVoiceMicView.this);
    }
    
    void e()
    {
      super.e();
      LightVoiceMicView.g(LightVoiceMicView.this);
    }
    
    void f()
    {
      super.f();
      if (LightVoiceMicView.h(LightVoiceMicView.this) != 0) {
        LightVoiceMicView.e(LightVoiceMicView.this);
      }
      LightVoiceMicView.a(LightVoiceMicView.this, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/voice/LightVoiceMicView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */