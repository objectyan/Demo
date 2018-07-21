package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.k;
import com.baidu.mapframework.nirvana.k.a;
import java.util.concurrent.ExecutorService;

class ConcurrentQueueRunner
{
  private final k a;
  
  ConcurrentQueueRunner(final ExecutorService paramExecutorService)
  {
    this.a = new k(new k.a()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramExecutorService.execute(paramAnonymousRunnable);
      }
    });
  }
  
  void a(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/concurrent/ConcurrentQueueRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */