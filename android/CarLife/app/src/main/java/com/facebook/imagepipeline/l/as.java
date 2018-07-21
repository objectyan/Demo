package com.facebook.imagepipeline.l;

import com.facebook.common.internal.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class as
{
  private boolean a = false;
  private final Deque<Runnable> b;
  private final Executor c;
  
  public as(Executor paramExecutor)
  {
    this.c = ((Executor)k.a(paramExecutor));
    this.b = new ArrayDeque();
  }
  
  private void d()
  {
    while (!this.b.isEmpty()) {
      this.c.execute((Runnable)this.b.pop());
    }
    this.b.clear();
  }
  
  public void a()
  {
    try
    {
      this.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/facebook/imagepipeline/l/as:a	Z
    //   6: ifeq +17 -> 23
    //   9: aload_0
    //   10: getfield 32	com/facebook/imagepipeline/l/as:b	Ljava/util/Deque;
    //   13: aload_1
    //   14: invokeinterface 57 2 0
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 27	com/facebook/imagepipeline/l/as:c	Ljava/util/concurrent/Executor;
    //   27: aload_1
    //   28: invokeinterface 50 2 0
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	as
    //   0	41	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	20	36	finally
    //   23	33	36	finally
  }
  
  public void b()
  {
    try
    {
      this.a = false;
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    try
    {
      this.b.remove(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */