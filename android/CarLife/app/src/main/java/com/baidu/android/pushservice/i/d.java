package com.baidu.android.pushservice.i;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class d
{
  private static a a;
  private static d b;
  
  public d()
  {
    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run()
      {
        d.this.b();
      }
    });
    a = new a(3, 100, 1L, TimeUnit.MINUTES, new b());
  }
  
  public static d a()
  {
    if ((b == null) || (a == null) || (a.isShutdown()) || (a.isTerminated())) {
      b = new d();
    }
    return b;
  }
  
  public boolean a(c paramc)
  {
    try
    {
      a.submit(paramc);
      return true;
    }
    catch (Exception paramc)
    {
      if ((a == null) || (a.getCorePoolSize() == 0) || (a.getPoolSize() == 0)) {
        a = new a(3, 100, 1L, TimeUnit.MINUTES, new b());
      }
    }
    return false;
  }
  
  public void b()
  {
    if (a != null) {}
    try
    {
      a.getQueue().clear();
      a.shutdown();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */