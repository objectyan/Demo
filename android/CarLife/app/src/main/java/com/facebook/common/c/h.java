package com.facebook.common.c;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class h<T>
  implements Runnable
{
  protected static final int a = 0;
  protected static final int b = 1;
  protected static final int c = 2;
  protected static final int d = 3;
  protected static final int e = 4;
  protected final AtomicInteger f = new AtomicInteger(0);
  
  public void a()
  {
    if (this.f.compareAndSet(0, 2)) {
      b();
    }
  }
  
  protected void a(Exception paramException) {}
  
  protected void a(T paramT) {}
  
  protected void b() {}
  
  protected void b(T paramT) {}
  
  protected abstract T c()
    throws Exception;
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/facebook/common/c/h:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_0
    //   5: iconst_1
    //   6: invokevirtual 36	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 48	com/facebook/common/c/h:c	()Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 31	com/facebook/common/c/h:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: iconst_3
    //   23: invokevirtual 51	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 53	com/facebook/common/c/h:a	(Ljava/lang/Object;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 55	com/facebook/common/c/h:b	(Ljava/lang/Object;)V
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 31	com/facebook/common/c/h:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   42: iconst_4
    //   43: invokevirtual 51	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 57	com/facebook/common/c/h:a	(Ljava/lang/Exception;)V
    //   51: return
    //   52: astore_2
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 55	com/facebook/common/c/h:b	(Ljava/lang/Object;)V
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	h
    //   17	16	1	localObject1	Object
    //   37	18	1	localException	Exception
    //   52	7	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	37	java/lang/Exception
    //   26	31	52	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */