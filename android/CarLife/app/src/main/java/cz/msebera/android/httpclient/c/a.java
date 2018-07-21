package cz.msebera.android.httpclient.c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a<T>
  implements b, Future<T>
{
  private final c<T> a;
  private volatile boolean b;
  private volatile boolean c;
  private volatile T d;
  private volatile Exception e;
  
  public a(c<T> paramc)
  {
    this.a = paramc;
  }
  
  private T b()
    throws ExecutionException
  {
    if (this.e != null) {
      throw new ExecutionException(this.e);
    }
    return (T)this.d;
  }
  
  public boolean a()
  {
    return cancel(true);
  }
  
  public boolean a(Exception paramException)
  {
    try
    {
      if (this.b) {
        return false;
      }
      this.b = true;
      this.e = paramException;
      notifyAll();
      if (this.a != null)
      {
        this.a.a(paramException);
        return true;
      }
    }
    finally {}
    return true;
  }
  
  public boolean a(T paramT)
  {
    try
    {
      if (this.b) {
        return false;
      }
      this.b = true;
      this.d = paramT;
      notifyAll();
      if (this.a != null)
      {
        this.a.a(paramT);
        return true;
      }
    }
    finally {}
    return true;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      if (this.b) {
        return false;
      }
      this.b = true;
      this.c = true;
      notifyAll();
      if (this.a != null)
      {
        this.a.a();
        return true;
      }
    }
    finally {}
    return true;
  }
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      while (!this.b) {
        wait();
      }
      localObject2 = b();
    }
    finally {}
    Object localObject2;
    return (T)localObject2;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    long l3;
    long l2;
    long l1;
    try
    {
      cz.msebera.android.httpclient.o.a.a(paramTimeUnit, "Time unit");
      l3 = paramTimeUnit.toMillis(paramLong);
      if (l3 <= 0L) {}
      for (paramLong = 0L;; paramLong = System.currentTimeMillis())
      {
        l2 = l3;
        if (!this.b) {
          break;
        }
        paramTimeUnit = b();
        return paramTimeUnit;
      }
      l1 = l2;
      if (l2 <= 0L) {
        throw new TimeoutException();
      }
    }
    finally {}
    do
    {
      wait(l1);
      if (this.b)
      {
        paramTimeUnit = b();
        break;
      }
      l2 = l3 - (System.currentTimeMillis() - paramLong);
      l1 = l2;
    } while (l2 > 0L);
    throw new TimeoutException();
  }
  
  public boolean isCancelled()
  {
    return this.c;
  }
  
  public boolean isDone()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */