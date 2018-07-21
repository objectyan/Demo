package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.e.i;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class a
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  protected final Lock b = new ReentrantLock();
  @GuardedBy("poolLock")
  protected Set<b> c = new HashSet();
  @GuardedBy("poolLock")
  protected int d;
  protected volatile boolean e;
  protected Set<c> f;
  protected ReferenceQueue<Object> g;
  protected cz.msebera.android.httpclient.i.c.w h = new cz.msebera.android.httpclient.i.c.w();
  
  public final b a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject, long paramLong, TimeUnit paramTimeUnit)
    throws i, InterruptedException
  {
    return a(paramb, paramObject).a(paramLong, paramTimeUnit);
  }
  
  public abstract f a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject);
  
  public void a()
    throws IllegalStateException
  {}
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    cz.msebera.android.httpclient.o.a.a(paramTimeUnit, "Time unit");
    this.b.lock();
    try
    {
      this.h.a(paramTimeUnit.toMillis(paramLong));
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  protected abstract void a(cz.msebera.android.httpclient.e.b.b paramb);
  
  protected void a(cz.msebera.android.httpclient.e.w paramw)
  {
    if (paramw != null) {}
    try
    {
      paramw.close();
      return;
    }
    catch (IOException paramw)
    {
      this.a.a("I/O error closing connection", paramw);
    }
  }
  
  public abstract void a(b paramb, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit);
  
  public void a(Reference<?> paramReference) {}
  
  public void b()
  {
    this.b.lock();
    try
    {
      this.h.b();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public abstract void c();
  
  public void d()
  {
    this.b.lock();
    try
    {
      boolean bool = this.e;
      if (bool) {
        return;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localIterator.remove();
        a(localb.c());
      }
      this.h.a();
    }
    finally
    {
      this.b.unlock();
    }
    this.e = true;
    this.b.unlock();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */