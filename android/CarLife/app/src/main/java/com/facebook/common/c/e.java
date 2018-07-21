package com.facebook.common.c;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class e
  extends AbstractExecutorService
  implements d
{
  private final Handler a;
  
  public e(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  protected <T> f<T> a(Runnable paramRunnable, T paramT)
  {
    return new f(this.a, paramRunnable, paramT);
  }
  
  protected <T> f<T> a(Callable<T> paramCallable)
  {
    return new f(this.a, paramCallable);
  }
  
  public ScheduledFuture<?> a(Runnable paramRunnable)
  {
    return b(paramRunnable, (Void)null);
  }
  
  public void a()
  {
    this.a.getLooper().quit();
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> ScheduledFuture<T> b(Runnable paramRunnable, @Nullable T paramT)
  {
    if (paramRunnable == null) {
      throw new NullPointerException();
    }
    paramRunnable = a(paramRunnable, paramT);
    execute(paramRunnable);
    return paramRunnable;
  }
  
  public <T> ScheduledFuture<T> b(Callable<T> paramCallable)
  {
    if (paramCallable == null) {
      throw new NullPointerException();
    }
    paramCallable = a(paramCallable);
    execute(paramCallable);
    return paramCallable;
  }
  
  public boolean b()
  {
    return Thread.currentThread() == this.a.getLooper().getThread();
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramRunnable = a(paramRunnable, null);
    this.a.postDelayed(paramRunnable, paramTimeUnit.toMillis(paramLong));
    return paramRunnable;
  }
  
  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    paramCallable = a(paramCallable);
    this.a.postDelayed(paramCallable, paramTimeUnit.toMillis(paramLong));
    return paramCallable;
  }
  
  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */