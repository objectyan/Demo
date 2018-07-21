package com.baidu.che.codriver.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

public abstract class a
  extends AnimationDrawable
{
  private Handler a;
  private int b;
  
  public a(AnimationDrawable paramAnimationDrawable)
  {
    int i = 0;
    while (i < paramAnimationDrawable.getNumberOfFrames())
    {
      addFrame(paramAnimationDrawable.getFrame(i), paramAnimationDrawable.getDuration(i));
      i += 1;
    }
    this.b = b();
  }
  
  public abstract void a();
  
  public int b()
  {
    int j = 0;
    int i = 0;
    while (i < getNumberOfFrames())
    {
      j += getDuration(i);
      i += 1;
    }
    return j;
  }
  
  public void start()
  {
    super.start();
    this.a = new Handler();
    this.a.postDelayed(new Runnable()
    {
      public void run()
      {
        if (a.this.isOneShot())
        {
          a.this.a();
          return;
        }
        a.b(a.this).postDelayed(this, a.a(a.this));
      }
    }, this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */