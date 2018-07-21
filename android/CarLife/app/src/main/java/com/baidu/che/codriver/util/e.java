package com.baidu.che.codriver.util;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private static ScheduledThreadPoolExecutor a;
  private static Object b = new Object();
  private static b c;
  private static Object d = new Object();
  private static final int e = 5;
  
  public static ScheduledThreadPoolExecutor a()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new ScheduledThreadPoolExecutor(5, new a());
      }
      return a;
    }
  }
  
  public static b b()
  {
    if (c == null) {}
    synchronized (d)
    {
      if (c == null) {
        c = new b();
      }
      return c;
    }
  }
  
  static class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a()
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = ("pool-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      paramRunnable.setPriority(1);
      return paramRunnable;
    }
  }
  
  public static class b
    implements Executor
  {
    private final LinkedList<Runnable> a = new LinkedList();
    private Runnable b;
    
    protected void a()
    {
      try
      {
        this.b = ((Runnable)this.a.poll());
        if (this.b != null) {
          e.a().execute(this.b);
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void execute(final Runnable paramRunnable)
    {
      try
      {
        this.a.add(new Runnable()
        {
          public void run()
          {
            try
            {
              paramRunnable.run();
              return;
            }
            finally
            {
              e.b.this.a();
            }
          }
        });
        if (this.b == null) {
          a();
        }
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */