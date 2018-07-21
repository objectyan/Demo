package cz.msebera.android.httpclient.m;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.c.c;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ThreadSafe
abstract class g<T>
  implements Future<T>
{
  private final Lock a;
  private final c<T> b;
  private final Condition c;
  private volatile boolean d;
  private volatile boolean e;
  private T f;
  
  g(Lock paramLock, c<T> paramc)
  {
    this.a = paramLock;
    this.c = paramLock.newCondition();
    this.b = paramc;
  }
  
  public void a()
  {
    this.a.lock();
    try
    {
      this.c.signalAll();
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public boolean a(Date paramDate)
    throws InterruptedException
  {
    this.a.lock();
    try
    {
      if (this.d) {
        throw new InterruptedException("Operation interrupted");
      }
    }
    finally
    {
      this.a.unlock();
    }
    if (paramDate != null) {}
    for (boolean bool = this.c.awaitUntil(paramDate); this.d; bool = true)
    {
      throw new InterruptedException("Operation interrupted");
      this.c.await();
    }
    this.a.unlock();
    return bool;
  }
  
  protected abstract T b(long paramLong, TimeUnit paramTimeUnit)
    throws IOException, InterruptedException, TimeoutException;
  
  public boolean cancel(boolean paramBoolean)
  {
    this.a.lock();
    try
    {
      paramBoolean = this.e;
      if (paramBoolean) {
        return false;
      }
      this.e = true;
      this.d = true;
      if (this.b != null) {
        this.b.a();
      }
      this.c.signalAll();
      return true;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = get(0L, TimeUnit.MILLISECONDS);
      return (T)localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new ExecutionException(localTimeoutException);
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    a.a(paramTimeUnit, "Time unit");
    this.a.lock();
    try
    {
      if (this.e)
      {
        paramTimeUnit = this.f;
        return paramTimeUnit;
      }
      this.f = b(paramLong, paramTimeUnit);
      this.e = true;
      if (this.b != null) {
        this.b.a(this.f);
      }
      paramTimeUnit = this.f;
      return paramTimeUnit;
    }
    catch (IOException paramTimeUnit)
    {
      this.e = true;
      this.f = null;
      if (this.b != null) {
        this.b.a(paramTimeUnit);
      }
      throw new ExecutionException(paramTimeUnit);
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public boolean isCancelled()
  {
    return this.d;
  }
  
  public boolean isDone()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/m/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */