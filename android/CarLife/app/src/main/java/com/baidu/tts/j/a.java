package com.baidu.tts.j;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class a
  implements b
{
  protected final Lock d = new ReentrantLock();
  protected final Condition e = this.d.newCondition();
  
  public void A()
  {
    try
    {
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void B()
  {
    Thread.currentThread().interrupt();
  }
  
  public boolean C()
  {
    try
    {
      a(null);
      if (n()) {
        return false;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        B();
      }
    }
    return true;
  }
  
  public void a(a parama)
    throws InterruptedException
  {
    while (m()) {
      b(parama);
    }
  }
  
  public TtsError b()
  {
    try
    {
      TtsError localTtsError = g();
      return localTtsError;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(a parama)
    throws InterruptedException
  {
    try
    {
      this.d.lock();
      if (parama != null) {
        parama.a();
      }
      LoggerProxy.d("ASafeLife", "before await");
      this.e.await();
      LoggerProxy.d("ASafeLife", "after await");
      return;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 98	com/baidu/tts/j/a:i	()V
    //   6: aload_0
    //   7: getfield 22	com/baidu/tts/j/a:d	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 71 1 0
    //   15: aload_0
    //   16: getfield 30	com/baidu/tts/j/a:e	Ljava/util/concurrent/locks/Condition;
    //   19: invokeinterface 101 1 0
    //   24: aload_0
    //   25: getfield 22	com/baidu/tts/j/a:d	Ljava/util/concurrent/locks/Lock;
    //   28: invokeinterface 92 1 0
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   41: aload_0
    //   42: getfield 22	com/baidu/tts/j/a:d	Ljava/util/concurrent/locks/Lock;
    //   45: invokeinterface 92 1 0
    //   50: goto -17 -> 33
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 22	com/baidu/tts/j/a:d	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 92 1 0
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	a
    //   36	2	1	localException	Exception
    //   53	4	1	localObject1	Object
    //   58	11	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	24	36	java/lang/Exception
    //   2	6	53	finally
    //   24	33	53	finally
    //   41	50	53	finally
    //   59	70	53	finally
    //   6	24	58	finally
    //   37	41	58	finally
  }
  
  public void d()
  {
    try
    {
      j();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e()
  {
    try
    {
      k();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void f()
  {
    try
    {
      l();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected abstract TtsError g();
  
  protected abstract void h();
  
  protected abstract void i();
  
  protected abstract void j();
  
  protected abstract void k();
  
  protected abstract void l();
  
  public abstract boolean m();
  
  public abstract boolean n();
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */