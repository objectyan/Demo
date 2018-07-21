package com.baidu.che.codriver.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.che.codriver.util.h;

public class DuerOSMicImageView
  extends ImageView
  implements b
{
  private static final String a = "DuerOSMicImageView";
  private b.a b = b.a.a;
  private a c;
  private a d;
  private a e;
  private AnimationDrawable f;
  private AnimationDrawable g;
  private AnimationDrawable h;
  private boolean i = false;
  
  public DuerOSMicImageView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public DuerOSMicImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void d()
  {
    this.f = ((AnimationDrawable)getResources().getDrawable(2130837527));
    this.c = new a(this.f)
    {
      public void a()
      {
        h.b("DuerOSMicImageView", "asr animation finished");
        DuerOSMicImageView.a(DuerOSMicImageView.this).stop();
        DuerOSMicImageView.b(DuerOSMicImageView.this);
      }
    };
    this.g = ((AnimationDrawable)getResources().getDrawable(2130837540));
    this.d = new a(this.g)
    {
      public void a()
      {
        h.b("DuerOSMicImageView", "asrtonlu animation finished");
        DuerOSMicImageView.c(DuerOSMicImageView.this).stop();
        DuerOSMicImageView.d(DuerOSMicImageView.this);
      }
    };
    this.h = ((AnimationDrawable)getResources().getDrawable(2130837547));
    this.e = new a(this.h)
    {
      public void a()
      {
        h.b("DuerOSMicImageView", "nlu animation finished--state:" + DuerOSMicImageView.e(DuerOSMicImageView.this));
        if (DuerOSMicImageView.e(DuerOSMicImageView.this) != b.a.b)
        {
          DuerOSMicImageView.f(DuerOSMicImageView.this).stop();
          DuerOSMicImageView.g(DuerOSMicImageView.this);
        }
      }
    };
  }
  
  private void e()
  {
    if (this.i)
    {
      setBackgroundResource(0);
      setBackgroundResource(2130837577);
    }
    this.i = false;
  }
  
  private void f()
  {
    if (!this.i)
    {
      setBackgroundResource(0);
      setBackground(this.c);
      this.c.setOneShot(false);
      this.c.start();
      this.i = true;
    }
  }
  
  private void g()
  {
    if (this.c != null) {
      this.c.setOneShot(true);
    }
  }
  
  private void h()
  {
    if (this.i)
    {
      setBackgroundResource(0);
      setBackground(this.d);
      this.d.setOneShot(true);
      this.d.start();
    }
  }
  
  private void i()
  {
    if (this.d != null) {
      this.d.stop();
    }
  }
  
  private void j()
  {
    if (this.i)
    {
      setBackgroundResource(0);
      setBackground(this.e);
      this.e.setOneShot(false);
      this.e.start();
    }
  }
  
  private void k()
  {
    if (this.e != null) {
      this.e.setOneShot(true);
    }
  }
  
  private void setState(b.a parama)
  {
    h.b("DuerOSMicImageView", "setState---state = " + parama);
    if (this.b == parama)
    {
      h.b("DuerOSMicImageView", "mCurrentState == state");
      return;
    }
    this.b = parama;
    switch (4.a[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      h.b("DuerOSMicImageView", "state = STATE_NORMAL");
      g();
      i();
      k();
      e();
      return;
    case 2: 
      h.b("DuerOSMicImageView", "state = STATE_RECORD");
      f();
      return;
    }
    h.b("DuerOSMicImageView", "state = STATE_REQUEST");
    g();
  }
  
  public void a()
  {
    setState(b.a.a);
  }
  
  public void b()
  {
    setState(b.a.b);
  }
  
  public void c()
  {
    setState(b.a.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/DuerOSMicImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */