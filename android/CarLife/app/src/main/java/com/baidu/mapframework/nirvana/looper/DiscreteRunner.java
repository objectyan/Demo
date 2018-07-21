package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import com.baidu.mapframework.nirvana.k;
import com.baidu.mapframework.nirvana.k.a;

public class DiscreteRunner
{
  private static final int b = 16;
  private final k a;
  
  DiscreteRunner(final Handler paramHandler)
  {
    this.a = new k(new k.a()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.postDelayed(paramAnonymousRunnable, 16L);
      }
    });
  }
  
  void a()
  {
    this.a.a();
  }
  
  void a(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/looper/DiscreteRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */