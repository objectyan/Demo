package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.f;

public abstract class d
  implements Runnable
{
  public abstract void a();
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      f.c("SafeRunnable", "SafeRunnable run exception", localThrowable);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/basic/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */