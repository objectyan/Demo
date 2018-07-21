package com.facebook.imagepipeline.f;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class k
  implements ThreadFactory
{
  private final int a;
  
  public k(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Thread newThread(final Runnable paramRunnable)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Process.setThreadPriority(k.a(k.this));
          paramRunnable.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */