package com.indooratlas.android.sdk._internal;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class fw
{
  static final Executor a;
  final int b = 5;
  final Runnable c = new Runnable()
  {
    public final void run()
    {
      long l1;
      do
      {
        l1 = fw.this.a(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
      } while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      try
      {
        synchronized (fw.this)
        {
          fw.this.wait(l2, (int)(l1 - l2 * 1000000L));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  };
  final Deque<ii> d = new ArrayDeque();
  final gx e = new gx();
  boolean f;
  private final long h;
  
  static
  {
    if (!fw.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), gy.a("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public fw()
  {
    this(TimeUnit.MINUTES);
  }
  
  private fw(TimeUnit paramTimeUnit)
  {
    this.h = paramTimeUnit.toNanos(5L);
    if (5L <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: 5");
    }
  }
  
  final long a(long paramLong)
  {
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Iterator localIterator = this.d.iterator();
        j = 0;
        i = 0;
        if (localIterator.hasNext())
        {
          ii localii = (ii)localIterator.next();
          List localList = localii.i;
          k = 0;
          if (k < localList.size())
          {
            if (((Reference)localList.get(k)).get() != null)
            {
              k += 1;
              continue;
            }
            gs.a.warning("A connection to " + localii.a.a.a + " was leaked. Did you forget to close a response body?");
            localList.remove(k);
            localii.j = true;
            if (!localList.isEmpty()) {
              continue;
            }
            localii.k = (paramLong - this.h);
            k = 0;
            break label311;
          }
          k = localList.size();
          break label311;
          long l2 = paramLong - localii.k;
          if (l2 <= l1) {
            break label308;
          }
          localObject1 = localii;
          l1 = l2;
          break label323;
        }
        if ((l1 >= this.h) || (j > this.b))
        {
          this.d.remove(localObject1);
          gy.a(((ii)localObject1).c);
          return 0L;
        }
        if (j > 0)
        {
          paramLong = this.h;
          return paramLong - l1;
        }
      }
      finally {}
      if (i > 0)
      {
        paramLong = this.h;
        return paramLong;
      }
      this.f = false;
      return -1L;
      label308:
      label311:
      if (k > 0)
      {
        i += 1;
        continue;
        label323:
        j += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */