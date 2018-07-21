package com.indooratlas.android.sdk._internal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ga
{
  private int a = 64;
  private int b = 5;
  private ExecutorService c;
  private final Deque<gj.b> d = new ArrayDeque();
  private final Deque<gj.b> e = new ArrayDeque();
  private final Deque<gj> f = new ArrayDeque();
  
  private ExecutorService b()
  {
    try
    {
      if (this.c == null) {
        this.c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), gy.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.c;
      return localExecutorService;
    }
    finally {}
  }
  
  private int c(gj.b paramb)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((gj.b)localIterator.next()).a().equals(paramb.a())) {
        break label52;
      }
      i += 1;
    }
    label52:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c()
  {
    if (this.e.size() >= this.a) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.d.isEmpty()) {}
        localIterator = this.d.iterator();
      } while (!localIterator.hasNext());
      gj.b localb = (gj.b)localIterator.next();
      if (c(localb) < this.b)
      {
        localIterator.remove();
        this.e.add(localb);
        b().execute(localb);
      }
    } while (this.e.size() < this.a);
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator1 = this.d.iterator();
      while (localIterator1.hasNext()) {
        ((gj.b)localIterator1.next()).a.c();
      }
      localIterator2 = this.e.iterator();
    }
    finally {}
    while (localIterator2.hasNext()) {
      ((gj.b)localIterator2.next()).a.c();
    }
    Iterator localIterator2 = this.f.iterator();
    while (localIterator2.hasNext()) {
      ((gj)localIterator2.next()).c();
    }
  }
  
  final void a(fr paramfr)
  {
    try
    {
      if (!this.f.remove(paramfr)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
  }
  
  /* Error */
  final void a(gj.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/indooratlas/android/sdk/_internal/ga:e	Ljava/util/Deque;
    //   6: invokeinterface 92 1 0
    //   11: aload_0
    //   12: getfield 21	com/indooratlas/android/sdk/_internal/ga:a	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 97	com/indooratlas/android/sdk/_internal/ga:c	(Lcom/indooratlas/android/sdk/_internal/gj$b;)I
    //   23: aload_0
    //   24: getfield 23	com/indooratlas/android/sdk/_internal/ga:b	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 30	com/indooratlas/android/sdk/_internal/ga:e	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 103 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 105	com/indooratlas/android/sdk/_internal/ga:b	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 111 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 28	com/indooratlas/android/sdk/_internal/ga:d	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 103 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ga
    //   0	73	1	paramb	gj.b
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  final void a(gj paramgj)
  {
    try
    {
      this.f.add(paramgj);
      return;
    }
    finally
    {
      paramgj = finally;
      throw paramgj;
    }
  }
  
  final void b(gj.b paramb)
  {
    try
    {
      if (!this.e.remove(paramb)) {
        throw new AssertionError("AsyncCall wasn't running!");
      }
    }
    finally {}
    c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */