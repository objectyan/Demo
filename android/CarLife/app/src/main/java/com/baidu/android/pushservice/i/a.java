package com.baidu.android.pushservice.i;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a
  extends ThreadPoolExecutor
{
  public a(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, b<Runnable> paramb)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramb);
  }
  
  /* Error */
  public void execute(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 21	com/baidu/android/pushservice/i/a:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   8: invokeinterface 27 1 0
    //   13: bipush 19
    //   15: if_icmplt +25 -> 40
    //   18: aload_0
    //   19: invokevirtual 30	com/baidu/android/pushservice/i/a:getPoolSize	()I
    //   22: aload_0
    //   23: invokevirtual 33	com/baidu/android/pushservice/i/a:getMaximumPoolSize	()I
    //   26: if_icmplt +22 -> 48
    //   29: aload_0
    //   30: invokevirtual 21	com/baidu/android/pushservice/i/a:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   33: invokeinterface 37 1 0
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 39	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: invokevirtual 21	com/baidu/android/pushservice/i/a:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   52: invokeinterface 43 1 0
    //   57: checkcast 45	java/lang/Runnable
    //   60: astore_2
    //   61: aload_0
    //   62: invokevirtual 21	com/baidu/android/pushservice/i/a:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   65: aload_1
    //   66: invokeinterface 49 2 0
    //   71: pop
    //   72: goto -32 -> 40
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   0	80	1	paramRunnable	Runnable
    //   3	58	2	localRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   4	38	75	finally
    //   40	45	75	finally
    //   48	72	75	finally
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
  {
    return new a(paramRunnable, paramT);
  }
  
  protected <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable)
  {
    return new a(paramCallable);
  }
  
  protected class a<V>
    extends FutureTask<V>
    implements Comparable<a<V>>
  {
    private Object b;
    
    public a(V paramV)
    {
      super(localObject);
      this.b = paramV;
    }
    
    public a()
    {
      super();
      this.b = localCallable;
    }
    
    public int a(a<V> parama)
    {
      if (this == parama) {}
      do
      {
        return 0;
        if (parama == null) {
          return -1;
        }
      } while ((this.b == null) || (parama.b == null) || (!(this.b instanceof c)) || (!(parama.b instanceof c)));
      return ((c)parama.b).d() - ((c)this.b).d();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */