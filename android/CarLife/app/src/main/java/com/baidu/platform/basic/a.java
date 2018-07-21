package com.baidu.platform.basic;

import com.baidu.platform.comapi.util.f;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class a
  extends ScheduledThreadPoolExecutor
{
  public static final String a = "BMScheduledThreadPoolExecutor";
  private final ThreadLocal<Long> b = new ThreadLocal();
  private final AtomicLong c = new AtomicLong();
  private final AtomicLong d = new AtomicLong();
  
  public a(int paramInt, ThreadFactory paramThreadFactory)
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
      f.c("BMScheduledThreadPoolExecutor", String.format(Locale.getDefault(), "Thread %s : end %s,time=%dns", new Object[] { paramThrowable, paramRunnable, Long.valueOf(l) }));
      super.afterExecute(paramRunnable, paramThrowable);
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      super.afterExecute(paramRunnable, paramThrowable);
      return;
    }
    finally
    {
      localObject = finally;
      super.afterExecute(paramRunnable, paramThrowable);
      throw ((Throwable)localObject);
    }
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    try
    {
      f.c("BMScheduledThreadPoolExecutor", String.format("Thread %s : start %s", new Object[] { paramRunnable, paramThread }));
      this.b.set(Long.valueOf(System.nanoTime()));
      return;
    }
    catch (Exception paramThread)
    {
      for (;;) {}
    }
  }
  
  protected void terminated()
  {
    int i = 0;
    try
    {
      if (this.c.get() != 0L) {
        i = (int)(this.d.get() / this.c.get());
      }
      f.c("BMScheduledThreadPoolExecutor", String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[] { Long.valueOf(this.d.get()), Integer.valueOf(i) }));
      return;
    }
    catch (Exception localException) {}finally
    {
      super.terminated();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/basic/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */