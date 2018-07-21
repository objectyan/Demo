package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.nirvana.b.a;
import com.baidu.mapframework.nirvana.looper.LooperBuffer;
import com.baidu.mapframework.nirvana.schedule.LifecycleManager;

public class e
{
  private static boolean a = false;
  private static c b;
  private static a c = new a(false);
  private static LooperBuffer d = new LooperBuffer(true);
  private static LifecycleManager e = new LifecycleManager();
  
  public static void a(c paramc)
  {
    b = paramc;
  }
  
  public static void a(String paramString, Exception paramException)
  {
    if (b != null) {
      b.a(paramString, paramException);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static a b()
  {
    return c;
  }
  
  public static LooperBuffer c()
  {
    return d;
  }
  
  public static LifecycleManager d()
  {
    return e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */