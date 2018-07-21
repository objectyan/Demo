package com.baidu.location.d;

import android.os.Handler;
import com.baidu.location.a.m;
import com.baidu.location.b.c;
import com.baidu.location.f.f;

public class b
{
  private static b a = null;
  private Handler b = null;
  private boolean c = false;
  private boolean d = false;
  
  public static b a()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  private void d()
  {
    this.c = true;
    if (this.d) {
      return;
    }
    this.b.postDelayed(new Runnable()
    {
      public void run()
      {
        b.a(b.this, false);
        if (!b.b(b.this)) {}
        while (!c.a().e()) {
          return;
        }
        m.a().d();
        if (f.j()) {
          g.a().f();
        }
        b.c(b.this).postDelayed(this, com.baidu.location.h.g.Y);
        b.a(b.this, true);
      }
    }, 2000L);
    this.d = true;
  }
  
  public void b()
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        b.a(b.this);
      }
    });
  }
  
  public void c()
  {
    this.c = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */