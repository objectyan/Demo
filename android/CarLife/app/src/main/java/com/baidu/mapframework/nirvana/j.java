package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.common.a.f;
import com.baidu.mapframework.common.a.l;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class j
  extends ThreadPoolExecutor
{
  public static final String a = "NirvanaThreadPool";
  private static final ConcurrentMap<String, m> e = new ConcurrentHashMap();
  private final ThreadLocal<Long> b = new ThreadLocal();
  private final AtomicLong c = new AtomicLong();
  private final AtomicLong d = new AtomicLong();
  
  public j(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
  }
  
  public static void a()
  {
    l locall = com.baidu.mapframework.common.a.j.a(f.a, "Profile");
    Iterator localIterator = e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      locall.a(String.valueOf(localEntry.getKey()) + ":" + localEntry.getValue() + "\n");
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    try
    {
      long l1 = System.nanoTime();
      long l2 = l1 - ((Long)this.b.get()).longValue();
      this.c.incrementAndGet();
      this.d.addAndGet(l2);
      n.a("NirvanaThreadPool", String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", new Object[] { Thread.currentThread(), paramRunnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(l2)), Long.valueOf(this.c.get()) }));
      m localm = (m)e.get(Thread.currentThread().getName());
      if (localm != null)
      {
        m.a locala = new m.a();
        locala.a = paramRunnable.toString();
        locala.b = ((Long)this.b.get()).longValue();
        locala.c = l1;
        localm.a.add(locala);
      }
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
    n.a("NirvanaThreadPool", String.format("Thread %s : start task %s at: %s", new Object[] { paramThread, paramRunnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(((Long)this.b.get()).longValue())) }) + "");
    if ((m)e.get(paramThread.getName()) == null)
    {
      paramRunnable = new m();
      e.put(paramThread.getName(), paramRunnable);
    }
  }
  
  protected void terminated()
  {
    try
    {
      if (this.c.get() != 0L) {
        n.a("NirvanaThreadPool", String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", new Object[] { Long.valueOf(this.d.get()), Long.valueOf(this.d.get() / this.c.get()) }));
      }
      return;
    }
    finally
    {
      super.terminated();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */