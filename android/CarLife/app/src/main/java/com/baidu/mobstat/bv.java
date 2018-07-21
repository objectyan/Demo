package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

class bv
{
  private static final bv a = new bv();
  private Context b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private HandlerThread f;
  private Handler g;
  
  public static bv a()
  {
    return a;
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      bx localbx = new bx(this, paramBoolean);
      localbx.setPriority(10);
      localbx.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void b(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while (this.c) {
      return;
    }
    this.b = paramContext.getApplicationContext();
    a(paramBoolean);
    this.c = true;
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, false);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      a().b(paramContext.getApplicationContext());
      b(paramContext.getApplicationContext(), paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d) {
      return;
    }
    PrefOperate.loadMetaDataConfig(paramContext);
    DataCore.instance().loadStatData(paramContext);
    DataCore.instance().loadLastSession(paramContext);
    DataCore.instance().installHeader(paramContext);
    if (paramBoolean1) {
      DataCore.instance().saveLogDataToSend(paramContext, true, paramBoolean2);
    }
    this.d = true;
  }
  
  public void b(Context paramContext)
  {
    if (this.e) {}
    do
    {
      do
      {
        return;
      } while (paramContext == null);
      if ((this.f == null) || (!this.f.isAlive()))
      {
        this.f = new HandlerThread("dataAnalyzeThread");
        this.f.start();
        Looper localLooper = this.f.getLooper();
        if (localLooper != null) {
          this.g = new Handler(localLooper);
        }
      }
    } while (this.g == null);
    this.g.postDelayed(new bw(this, paramContext), 5000L);
    this.e = true;
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    if (!this.d) {
      try
      {
        for (;;)
        {
          boolean bool = this.d;
          if (bool) {
            break;
          }
          try
          {
            wait(50L);
          }
          catch (InterruptedException localInterruptedException)
          {
            db.b(localInterruptedException.getMessage());
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */