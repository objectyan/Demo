package b;

import b.a.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class p
{
  private int a = 64;
  private int b = 5;
  private Runnable c;
  private ExecutorService d;
  private final Deque<aa.a> e = new ArrayDeque();
  private final Deque<aa.a> f = new ArrayDeque();
  private final Deque<aa> g = new ArrayDeque();
  
  public p() {}
  
  public p(ExecutorService paramExecutorService)
  {
    this.d = paramExecutorService;
  }
  
  private <T> void a(Deque<T> paramDeque, T paramT, boolean paramBoolean)
  {
    try
    {
      if (!paramDeque.remove(paramT)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
    if (paramBoolean) {
      i();
    }
    int i = h();
    paramDeque = this.c;
    if ((i == 0) && (paramDeque != null)) {
      paramDeque.run();
    }
  }
  
  private int c(aa.a parama)
  {
    int i = 0;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (((aa.a)localIterator.next()).a().equals(parama.a())) {
        i += 1;
      }
    }
    return i;
  }
  
  private void i()
  {
    if (this.f.size() >= this.a) {}
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while (this.e.isEmpty()) {}
        localIterator = this.e.iterator();
      } while (!localIterator.hasNext());
      aa.a locala = (aa.a)localIterator.next();
      if (c(locala) < this.b)
      {
        localIterator.remove();
        this.f.add(locala);
        a().execute(locala);
      }
    } while (this.f.size() < this.a);
  }
  
  public ExecutorService a()
  {
    try
    {
      if (this.d == null) {
        this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.d;
      return localExecutorService;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 1) {
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally {}
    }
    this.a = paramInt;
    i();
  }
  
  /* Error */
  void a(aa.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	b/p:f	Ljava/util/Deque;
    //   6: invokeinterface 96 1 0
    //   11: aload_0
    //   12: getfield 23	b/p:a	I
    //   15: if_icmpge +39 -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 101	b/p:c	(Lb/aa$a;)I
    //   23: aload_0
    //   24: getfield 25	b/p:b	I
    //   27: if_icmpge +27 -> 54
    //   30: aload_0
    //   31: getfield 32	b/p:f	Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface 106 2 0
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 109	b/p:a	()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface 115 2 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 30	b/p:e	Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface 106 2 0
    //   64: pop
    //   65: goto -14 -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	p
    //   0	73	1	parama	aa.a
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void a(aa paramaa)
  {
    try
    {
      this.g.add(paramaa);
      return;
    }
    finally
    {
      paramaa = finally;
      throw paramaa;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      this.c = paramRunnable;
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt < 1) {
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally {}
    }
    this.b = paramInt;
    i();
  }
  
  void b(aa.a parama)
  {
    a(this.f, parama, true);
  }
  
  void b(aa paramaa)
  {
    a(this.g, paramaa, false);
  }
  
  public int c()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    try
    {
      Iterator localIterator1 = this.e.iterator();
      while (localIterator1.hasNext()) {
        ((aa.a)localIterator1.next()).c().c();
      }
      localIterator2 = this.f.iterator();
    }
    finally {}
    while (localIterator2.hasNext()) {
      ((aa.a)localIterator2.next()).c().c();
    }
    Iterator localIterator2 = this.g.iterator();
    while (localIterator2.hasNext()) {
      ((aa)localIterator2.next()).c();
    }
  }
  
  public List<e> e()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((aa.a)localIterator.next()).c());
      }
      localList2 = Collections.unmodifiableList(localList1);
    }
    finally {}
    List localList2;
    return localList2;
  }
  
  public List<e> f()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.g);
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((aa.a)localIterator.next()).c());
      }
      localList2 = Collections.unmodifiableList(localList1);
    }
    finally {}
    List localList2;
    return localList2;
  }
  
  public int g()
  {
    try
    {
      int i = this.e.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int h()
  {
    try
    {
      int i = this.f.size();
      int j = this.g.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */