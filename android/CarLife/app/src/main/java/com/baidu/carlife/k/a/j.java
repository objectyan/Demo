package com.baidu.carlife.k.a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class j
{
  public static final String a = j.class.getSimpleName();
  public static final int b = 3;
  public static j c;
  private static Queue<i> d = new LinkedList();
  private static Queue<i> e = new PriorityBlockingQueue();
  
  public static j a()
  {
    if (c == null) {
      c = new j();
    }
    return c;
  }
  
  /* Error */
  public void a(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 32	com/baidu/carlife/k/a/j:d	Ljava/util/Queue;
    //   5: invokeinterface 50 1 0
    //   10: iconst_3
    //   11: if_icmpge +27 -> 38
    //   14: aload_1
    //   15: invokevirtual 55	com/baidu/carlife/k/a/i:d	()Z
    //   18: ifne +17 -> 35
    //   21: getstatic 32	com/baidu/carlife/k/a/j:d	Ljava/util/Queue;
    //   24: aload_1
    //   25: invokeinterface 59 2 0
    //   30: pop
    //   31: aload_1
    //   32: invokevirtual 62	com/baidu/carlife/k/a/i:start	()V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: getstatic 37	com/baidu/carlife/k/a/j:e	Ljava/util/Queue;
    //   41: aload_1
    //   42: invokeinterface 59 2 0
    //   47: pop
    //   48: goto -13 -> 35
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	j
    //   0	56	1	parami	i
    // Exception table:
    //   from	to	target	type
    //   2	35	51	finally
    //   38	48	51	finally
  }
  
  public void b(i parami)
  {
    try
    {
      if (d.contains(parami)) {
        d.remove(parami);
      }
      if (e.contains(parami)) {
        e.remove(parami);
      }
      if ((e.size() > 0) && (d.size() < 3))
      {
        parami = (i)e.poll();
        if (!parami.d())
        {
          d.add(parami);
          parami.start();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/k/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */