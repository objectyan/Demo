package com.facebook.common.c;

import com.facebook.common.e.a;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends AbstractExecutorService
{
  private static final Class<?> a = b.class;
  private final String b;
  private final Executor c;
  private volatile int d;
  private final BlockingQueue<Runnable> e;
  private final a f;
  private final AtomicInteger g;
  private final AtomicInteger h;
  
  public b(String paramString, int paramInt, Executor paramExecutor, BlockingQueue<Runnable> paramBlockingQueue)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("max concurrency must be > 0");
    }
    this.b = paramString;
    this.c = paramExecutor;
    this.d = paramInt;
    this.e = paramBlockingQueue;
    this.f = new a(null);
    this.g = new AtomicInteger(0);
    this.h = new AtomicInteger(0);
  }
  
  public static b a(String paramString, int paramInt1, int paramInt2, Executor paramExecutor)
  {
    return new b(paramString, paramInt1, paramExecutor, new LinkedBlockingQueue(paramInt2));
  }
  
  private void c()
  {
    for (int i = this.g.get();; i = this.g.get())
    {
      if (i < this.d)
      {
        int j = i + 1;
        if (this.g.compareAndSet(i, j))
        {
          a.a(a, "%s: starting worker %d of %d", this.b, Integer.valueOf(j), Integer.valueOf(this.d));
          this.c.execute(this.f);
        }
      }
      else
      {
        return;
      }
      a.a(a, "%s: race in startWorkerIfNeeded; retrying", this.b);
    }
  }
  
  public boolean a()
  {
    return (this.e.isEmpty()) && (this.g.get() == 0);
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    throw new UnsupportedOperationException();
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new NullPointerException("runnable parameter is null");
    }
    if (!this.e.offer(paramRunnable)) {
      throw new RejectedExecutionException(this.b + " queue is full, size=" + this.e.size());
    }
    int i = this.e.size();
    int j = this.h.get();
    if ((i > j) && (this.h.compareAndSet(j, i))) {
      a.a(a, "%s: max pending work in queue = %d", this.b, Integer.valueOf(i));
    }
    c();
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      int i;
      try
      {
        Runnable localRunnable = (Runnable)b.a(b.this).poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
        for (;;)
        {
          i = b.c(b.this).decrementAndGet();
          if (b.a(b.this).isEmpty()) {
            break;
          }
          b.d(b.this);
          return;
          a.a(b.b(), "%s: Worker has nothing to run", b.b(b.this));
        }
        b.d(b.this);
      }
      finally
      {
        i = b.c(b.this).decrementAndGet();
        if (b.a(b.this).isEmpty()) {}
      }
      for (;;)
      {
        throw ((Throwable)localObject);
        a.a(b.b(), "%s: worker finished; %d workers left", b.b(b.this), Integer.valueOf(i));
        return;
        a.a(b.b(), "%s: worker finished; %d workers left", b.b(b.this), Integer.valueOf(i));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */