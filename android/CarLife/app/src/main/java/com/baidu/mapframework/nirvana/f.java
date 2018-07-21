package com.baidu.mapframework.nirvana;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class f
  extends ScheduledThreadPoolExecutor
{
  public static final String a = "NirvanaScheduledThreadPool";
  private final ThreadLocal<Long> b = new ThreadLocal();
  private final AtomicLong c = new AtomicLong();
  private final AtomicLong d = new AtomicLong();
  
  public f(int paramInt, ThreadFactory paramThreadFactory)
  {
    super(paramInt, paramThreadFactory);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    try
    {
      long l = System.nanoTime() - ((Long)this.b.get()).longValue();
      this.c.incrementAndGet();
      this.d.addAndGet(l);
      n.a("NirvanaScheduledThreadPool", String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", new Object[] { Thread.currentThread(), paramRunnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(l)), Long.valueOf(this.c.get()) }));
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
    this.b.set(Long.valueOf(System.nanoTime()));
    n.a("NirvanaScheduledThreadPool", String.format("Thread %s : start task %s at: %s", new Object[] { paramThread, paramRunnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(((Long)this.b.get()).longValue())) }) + "");
  }
  
  protected void terminated()
  {
    try
    {
      if (this.c.get() != 0L) {
        n.a("NirvanaScheduledThreadPool", String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[] { Long.valueOf(this.d.get()), Long.valueOf(this.d.get() / this.c.get()) }));
      }
      return;
    }
    finally
    {
      super.terminated();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */