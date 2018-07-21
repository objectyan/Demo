package com.baidu.mapframework.nirvana;

import java.util.LinkedList;

public class k
{
  private final a a;
  private final LinkedList<Runnable> b;
  private Runnable c;
  
  public k(a parama)
  {
    this.a = parama;
    this.b = new LinkedList();
  }
  
  private Runnable b(final Runnable paramRunnable)
  {
    new Runnable()
    {
      public void run()
      {
        paramRunnable.run();
        synchronized (k.this)
        {
          if (k.a(k.this).isEmpty())
          {
            k.a(k.this, null);
            return;
          }
          k.a(k.this, (Runnable)k.a(k.this).removeFirst());
          k.c(k.this).execute(k.b(k.this, k.b(k.this)));
        }
      }
    };
  }
  
  public void a()
  {
    try
    {
      this.c = null;
      this.b.clear();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/baidu/mapframework/nirvana/k:c	Ljava/lang/Runnable;
    //   6: ifnonnull +25 -> 31
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 31	com/baidu/mapframework/nirvana/k:c	Ljava/lang/Runnable;
    //   14: aload_0
    //   15: getfield 22	com/baidu/mapframework/nirvana/k:a	Lcom/baidu/mapframework/nirvana/k$a;
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 36	com/baidu/mapframework/nirvana/k:b	(Ljava/lang/Runnable;)Ljava/lang/Runnable;
    //   23: invokeinterface 47 2 0
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield 27	com/baidu/mapframework/nirvana/k:b	Ljava/util/LinkedList;
    //   35: aload_1
    //   36: invokevirtual 51	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   39: goto -11 -> 28
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	k
    //   0	47	1	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	28	42	finally
    //   28	30	42	finally
    //   31	39	42	finally
    //   43	45	42	finally
  }
  
  public static abstract interface a
  {
    public abstract void execute(Runnable paramRunnable);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */