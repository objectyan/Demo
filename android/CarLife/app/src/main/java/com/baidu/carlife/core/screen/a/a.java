package com.baidu.carlife.core.screen.a;

import android.app.Activity;
import android.os.Message;
import android.provider.Settings.System;
import com.baidu.carlife.core.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;

public class a
  implements com.baidu.carlife.core.h
{
  public static final int a = 255;
  public static final int b = 1;
  public static final int c = 10000;
  public static final int d = 30000;
  public static final int e = 1000;
  private static a f;
  private static final String g = "LightnessControlManager";
  private static final Object h = new Object();
  private a i = null;
  private boolean j = true;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private int o = -10;
  private com.baidu.carlife.core.screen.h p;
  private b q;
  
  public a()
  {
    k.a(this.i);
  }
  
  private int a(Activity paramActivity)
  {
    int i1 = 0;
    paramActivity = paramActivity.getContentResolver();
    try
    {
      int i2 = Settings.System.getInt(paramActivity, "screen_brightness");
      i1 = i2;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
    i.b("LightnessControlManager", "brightnessValue is %d", new Object[] { Integer.valueOf(i1) });
    return i1;
  }
  
  public static a b()
  {
    if (f == null) {}
    synchronized (h)
    {
      if (f == null) {
        f = new a();
      }
      return f;
    }
  }
  
  public void a()
  {
    i.b("LightnessControlManager", "Access to the brightness of the screen");
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        i.b("LightnessControlManager", "change screen brightness value = %d", new Object[] { Integer.valueOf(paramInt) });
        if ((1 == paramInt) && (!this.n))
        {
          i.b("LightnessControlManager", "usb is disconnect, the phone will not change");
          return;
        }
        f1 = paramInt / 255.0F;
        bool = false;
        if (1 != paramInt) {
          break label93;
        }
        a(false);
      }
      catch (Exception localException)
      {
        float f1;
        i.b("LightnessControlManager", "Can not change bright");
        localException.printStackTrace();
        return;
      }
      if (this.q != null)
      {
        this.q.a(f1, bool);
        return;
        label93:
        a(true);
      }
      else
      {
        return;
      }
      if (paramInt != 0.0F) {
        bool = true;
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    i.b("LightnessControlManager", "sendMessageDelayed msgType = %d delayTime = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (true == paramBoolean)
    {
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          return;
          this.i.sendEmptyMessageDelayed(paramInt1, paramInt2);
        } while (this.k);
        b(true);
        return;
        this.i.sendEmptyMessageDelayed(paramInt1, paramInt2);
      } while (this.m);
      c(true);
      return;
    }
    this.i.sendEmptyMessage(paramInt1);
  }
  
  public void a(b paramb)
  {
    this.q = paramb;
  }
  
  public void a(com.baidu.carlife.core.screen.h paramh)
  {
    this.p = paramh;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    i.b("LightnessControlManager", "cancleMsgBrightOff msgType = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 4201: 
      i.b("LightnessControlManager", "Cancle messge bright off");
      this.i.removeMessages(paramInt);
      b(false);
      return;
    }
    this.i.removeMessages(paramInt);
    c(false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public void d(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean d()
  {
    return this.k;
  }
  
  public void e(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean e()
  {
    return this.l;
  }
  
  public boolean f()
  {
    return this.m;
  }
  
  public boolean g()
  {
    return this.n;
  }
  
  public int h()
  {
    return this.o;
  }
  
  public void i()
  {
    i.b("LightnessControlManager", "====vehicleTouchmanage====");
    if (true == this.l) {
      b(4202);
    }
    a(4202, true, 1000);
    c(true);
  }
  
  public void j()
  {
    i.b("LightnessControlManager", "====brightTouchEvent====");
    if (true == this.k) {
      b(4201);
    }
    if (!this.j) {
      a(this.o);
    }
    a(4201, true, 30000);
  }
  
  public void k()
  {
    this.i.removeMessages(4250);
  }
  
  public void l()
  {
    this.i.sendEmptyMessageDelayed(4250, 30000L);
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(4200);
      addMsg(4201);
      addMsg(4202);
      addMsg(4250);
      addMsg(4252);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
          a.this.a(a.a(a.this));
          return;
          if (true == a.b(a.this)) {
            a.this.b(false);
          }
          a.this.a(1);
          return;
          a.this.c(false);
          return;
        } while ((a.c(a.this) == null) || (!c.a().m()));
        a.c(a.this).b();
        return;
      } while (a.c(a.this) == null);
      a.c(a.this).a(false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */