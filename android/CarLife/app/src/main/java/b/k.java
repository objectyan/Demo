package b;

import b.a.c.d;
import b.a.c.g;
import b.a.c.g.a;
import b.a.h.e;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class k
{
  private static final Executor d;
  final d a = new d();
  boolean b;
  private final int e;
  private final long f;
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      long l1;
      do
      {
        l1 = k.this.a(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
      } while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      try
      {
        synchronized (k.this)
        {
          k.this.wait(l2, (int)(l1 - l2 * 1000000L));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  };
  private final Deque<b.a.c.c> h = new ArrayDeque();
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), b.a.c.a("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public k()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public k(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.e = paramInt;
    this.f = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  private int a(b.a.c.c paramc, long paramLong)
  {
    List localList = paramc.g;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = (Reference)localList.get(i);
      if (((Reference)localObject).get() != null)
      {
        i += 1;
      }
      else
      {
        localObject = (g.a)localObject;
        String str = "A connection to " + paramc.a().a().a() + " was leaked. Did you forget to close a response body?";
        e.b().a(str, ((g.a)localObject).a);
        localList.remove(i);
        paramc.h = true;
        if (localList.isEmpty())
        {
          paramc.i = (paramLong - this.f);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  public int a()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((b.a.c.c)localIterator.next()).g.isEmpty();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  long a(long paramLong)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        b.a.c.c localc = (b.a.c.c)localIterator.next();
        if (a(localc, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localc.i;
          i = k;
          if (l2 > l1)
          {
            l1 = l2;
            localObject1 = localc;
            i = k;
          }
        }
      }
      if ((l1 >= this.f) || (i > this.e))
      {
        this.h.remove(localObject1);
        b.a.c.a(((b.a.c.c)localObject1).b());
        return 0L;
      }
      if (i > 0)
      {
        paramLong = this.f;
        return paramLong - l1;
      }
    }
    finally {}
    if (j > 0)
    {
      paramLong = this.f;
      return paramLong;
    }
    this.b = false;
    return -1L;
  }
  
  b.a.c.c a(a parama, g paramg)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      b.a.c.c localc = (b.a.c.c)localIterator.next();
      if ((localc.g.size() < localc.f) && (parama.equals(localc.a().a)) && (!localc.h))
      {
        paramg.a(localc);
        return localc;
      }
    }
    return null;
  }
  
  void a(b.a.c.c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if (!this.b)
    {
      this.b = true;
      d.execute(this.g);
    }
    this.h.add(paramc);
  }
  
  public int b()
  {
    try
    {
      int i = this.h.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean b(b.a.c.c paramc)
  {
    if ((!c) && (!Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    if ((paramc.h) || (this.e == 0))
    {
      this.h.remove(paramc);
      return true;
    }
    notifyAll();
    return false;
  }
  
  public void c()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.h.iterator();
      while (localIterator2.hasNext())
      {
        b.a.c.c localc = (b.a.c.c)localIterator2.next();
        if (localc.g.isEmpty())
        {
          localc.h = true;
          localArrayList.add(localc);
          localIterator2.remove();
        }
      }
    }
    finally {}
    Iterator localIterator1 = ((List)localObject).iterator();
    while (localIterator1.hasNext()) {
      b.a.c.a(((b.a.c.c)localIterator1.next()).b());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */