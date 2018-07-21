package a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class f
  implements Closeable
{
  private final Object a = new Object();
  private final List<e> b = new ArrayList();
  private final ScheduledExecutorService c = c.b();
  private ScheduledFuture<?> d;
  private boolean e;
  private boolean f;
  
  private void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < -1L) {
      throw new IllegalArgumentException("Delay must be >= -1");
    }
    if (paramLong == 0L)
    {
      c();
      return;
    }
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
    }
    f();
    if (paramLong != -1L) {
      this.d = this.c.schedule(new Runnable()
      {
        public void run()
        {
          synchronized (f.a(f.this))
          {
            f.a(f.this, null);
            f.this.c();
            return;
          }
        }
      }, paramLong, paramTimeUnit);
    }
  }
  
  private void a(List<e> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((e)paramList.next()).a();
    }
  }
  
  private void e()
  {
    if (this.f) {
      throw new IllegalStateException("Object already closed");
    }
  }
  
  private void f()
  {
    if (this.d != null)
    {
      this.d.cancel(true);
      this.d = null;
    }
  }
  
  e a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      e();
      paramRunnable = new e(this, paramRunnable);
      if (this.e)
      {
        paramRunnable.a();
        return paramRunnable;
      }
      this.b.add(paramRunnable);
    }
  }
  
  public void a(long paramLong)
  {
    a(paramLong, TimeUnit.MILLISECONDS);
  }
  
  void a(e parame)
  {
    synchronized (this.a)
    {
      e();
      this.b.remove(parame);
      return;
    }
  }
  
  public boolean a()
  {
    synchronized (this.a)
    {
      e();
      boolean bool = this.e;
      return bool;
    }
  }
  
  public d b()
  {
    synchronized (this.a)
    {
      e();
      d locald = new d(this);
      return locald;
    }
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      e();
      if (this.e) {
        return;
      }
      f();
      this.e = true;
      ArrayList localArrayList = new ArrayList(this.b);
      a(localArrayList);
      return;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.f) {
        return;
      }
      f();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext()) {
        ((e)localIterator.next()).close();
      }
    }
    this.b.clear();
    this.f = true;
  }
  
  void d()
    throws CancellationException
  {
    synchronized (this.a)
    {
      e();
      if (this.e) {
        throw new CancellationException();
      }
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a()) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */