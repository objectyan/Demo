package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.f;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class c
  extends ThreadPoolExecutor
{
  public static final String a = "BMThreadPoolExecutor";
  private final ThreadLocal<Long> b = new ThreadLocal();
  private final AtomicLong c = new AtomicLong();
  private final AtomicLong d = new AtomicLong();
  
  public c(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    try
    {
      long l = System.nanoTime() - ((Long)this.b.get()).longValue();
      this.c.incrementAndGet();
      this.d.addAndGet(l);
      f.c("BMThreadPoolExecutor", String.format(Locale.getDefault(), "Thread %s : end %s,time=%dns", new Object[] { Thread.currentThread(), paramRunnable, Long.valueOf(l) }));
      return;
    }
    finally
    {
      super.afterExecute(paramRunnable, paramThrowable);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    f.c("BMThreadPoolExecutor", String.format("Thread %s : start %s", new Object[] { paramThread, paramRunnable }));
    this.b.set(Long.valueOf(System.nanoTime()));
  }
  
  protected void terminated()
  {
    try
    {
      if ((this.c != null) && (this.c.get() != 0L)) {
        f.c("BMThreadPoolExecutor", String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[] { Long.valueOf(this.d.get()), Long.valueOf(this.d.get() / this.c.get()) }));
      }
      return;
    }
    finally
    {
      super.terminated();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/basic/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */