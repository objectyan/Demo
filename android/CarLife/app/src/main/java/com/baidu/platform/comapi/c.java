package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.baidu.platform.comapi.dataengine.MapDataEngine;
import com.baidu.platform.comapi.f.f;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.vi.VIContext;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final AtomicBoolean a = new AtomicBoolean(false);
  private static final AtomicBoolean b = new AtomicBoolean(false);
  private static Context c;
  private static b d;
  
  public static void a(Application paramApplication)
  {
    if (paramApplication == null) {
      throw new RuntimeException();
    }
    if (c == null) {
      c = paramApplication;
    }
    VIContext.init(paramApplication);
  }
  
  public static boolean a()
  {
    return a.get();
  }
  
  public static void b(Application paramApplication)
  {
    if (paramApplication == null) {
      throw new RuntimeException();
    }
    if (c == null) {
      c = paramApplication;
    }
  }
  
  public static boolean b()
  {
    return b.get();
  }
  
  public static void c()
  {
    for (;;)
    {
      boolean bool = a.get();
      if (bool) {
        return;
      }
      if (a.compareAndSet(bool, true))
      {
        d = new b();
        if (!d.a(c)) {
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
  
  public static void d()
  {
    for (;;)
    {
      boolean bool = b.get();
      if (bool) {
        return;
      }
      if (b.compareAndSet(bool, true)) {
        com.baidu.platform.comapi.d.b.a.a();
      }
    }
  }
  
  public static void e()
  {
    MapDataEngine.destroy();
    f.c();
    com.baidu.platform.comapi.b.c localc = com.baidu.platform.comapi.b.c.a();
    if (localc != null) {
      localc.b();
    }
    SysOSAPIv2.getInstance().destroy();
    d.d();
  }
  
  public static Context f()
  {
    return c;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */