package cz.msebera.android.httpclient.m;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
public abstract class a<T, C, E extends e<T, C>>
  implements c<T, E>, d<T>
{
  private final Lock a;
  private final b<T, C> b;
  private final Map<T, i<T, C, E>> c;
  private final Set<E> d;
  private final LinkedList<E> e;
  private final LinkedList<g<E>> f;
  private final Map<T, Integer> g;
  private volatile boolean h;
  private volatile int i;
  private volatile int j;
  
  public a(b<T, C> paramb, int paramInt1, int paramInt2)
  {
    this.b = ((b)cz.msebera.android.httpclient.o.a.a(paramb, "Connection factory"));
    this.i = cz.msebera.android.httpclient.o.a.b(paramInt1, "Max per route value");
    this.j = cz.msebera.android.httpclient.o.a.b(paramInt2, "Max total value");
    this.a = new ReentrantLock();
    this.c = new HashMap();
    this.d = new HashSet();
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = new HashMap();
  }
  
  private E a(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, g<E> paramg)
    throws IOException, InterruptedException, TimeoutException
  {
    Date localDate = null;
    if (paramLong > 0L) {
      localDate = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
    }
    this.a.lock();
    for (;;)
    {
      i locali;
      boolean bool;
      e locale;
      try
      {
        locali = c(paramT);
        paramTimeUnit = null;
        if (paramTimeUnit != null) {
          break label472;
        }
        if (!this.h)
        {
          bool = true;
          cz.msebera.android.httpclient.o.b.a(bool, "Connection pool shut down");
          locale = locali.b(paramObject);
          if (locale == null)
          {
            if (locale == null) {
              break label184;
            }
            this.e.remove(locale);
            this.d.add(locale);
            return locale;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if ((!locale.e()) && (!locale.a(System.currentTimeMillis()))) {
          continue;
        }
        locale.f();
        this.e.remove(locale);
        locali.a(locale, false);
        continue;
        m = d(paramT);
      }
      finally
      {
        this.a.unlock();
      }
      label184:
      int m;
      int n = Math.max(0, locali.e() + 1 - m);
      int k;
      if (n > 0) {
        k = 0;
      }
      for (;;)
      {
        if (k < n)
        {
          paramTimeUnit = locali.f();
          if (paramTimeUnit != null) {}
        }
        else
        {
          if (locali.e() >= m) {
            break;
          }
          k = this.d.size();
          k = Math.max(this.j - k, 0);
          if (k <= 0) {
            break;
          }
          if ((this.e.size() > k - 1) && (!this.e.isEmpty()))
          {
            paramObject = (e)this.e.removeLast();
            ((e)paramObject).f();
            c(((e)paramObject).h()).a((e)paramObject);
          }
          paramT = locali.c(this.b.a(paramT));
          this.d.add(paramT);
          this.a.unlock();
          return paramT;
        }
        paramTimeUnit.f();
        this.e.remove(paramTimeUnit);
        locali.a(paramTimeUnit);
        k += 1;
      }
      try
      {
        locali.a(paramg);
        this.f.add(paramg);
        bool = paramg.a(localDate);
        locali.b(paramg);
        this.f.remove(paramg);
        paramTimeUnit = locale;
        if (bool) {
          continue;
        }
        paramTimeUnit = locale;
        if (localDate == null) {
          continue;
        }
        paramTimeUnit = locale;
        if (localDate.getTime() > System.currentTimeMillis()) {
          continue;
        }
        label472:
        throw new TimeoutException("Timeout waiting for connection");
      }
      finally
      {
        locali.b(paramg);
        this.f.remove(paramg);
      }
    }
  }
  
  private i<T, C, E> c(final T paramT)
  {
    i locali = (i)this.c.get(paramT);
    Object localObject = locali;
    if (locali == null)
    {
      localObject = new i(paramT)
      {
        protected E a(C paramAnonymousC)
        {
          return a.this.a(paramT, paramAnonymousC);
        }
      };
      this.c.put(paramT, localObject);
    }
    return (i<T, C, E>)localObject;
  }
  
  private int d(T paramT)
  {
    paramT = (Integer)this.g.get(paramT);
    if (paramT != null) {
      return paramT.intValue();
    }
    return this.i;
  }
  
  private void g()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)((Map.Entry)localIterator.next()).getValue();
      if (locali.c() + locali.e() == 0) {
        localIterator.remove();
      }
    }
  }
  
  protected abstract E a(T paramT, C paramC);
  
  public h a(T paramT)
  {
    cz.msebera.android.httpclient.o.a.a(paramT, "Route");
    this.a.lock();
    try
    {
      i locali = c(paramT);
      paramT = new h(locali.b(), locali.c(), locali.d(), d(paramT));
      return paramT;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public Future<E> a(final T paramT, final Object paramObject, cz.msebera.android.httpclient.c.c<E> paramc)
  {
    cz.msebera.android.httpclient.o.a.a(paramT, "Route");
    if (!this.h) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection pool shut down");
      new g(this.a, paramc)
      {
        public E a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
          throws InterruptedException, TimeoutException, IOException
        {
          paramAnonymousTimeUnit = a.a(a.this, paramT, paramObject, paramAnonymousLong, paramAnonymousTimeUnit, this);
          a.this.a(paramAnonymousTimeUnit);
          return paramAnonymousTimeUnit;
        }
      };
    }
  }
  
  public void a(int paramInt)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Max value");
    this.a.lock();
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    cz.msebera.android.httpclient.o.a.a(paramTimeUnit, "Time unit");
    long l = paramTimeUnit.toMillis(paramLong);
    paramLong = l;
    if (l < 0L) {
      paramLong = 0L;
    }
    a(new f()
    {
      public void a(e<T, C> paramAnonymouse)
      {
        if (paramAnonymouse.m() <= this.a) {
          paramAnonymouse.f();
        }
      }
    });
  }
  
  protected void a(E paramE) {}
  
  public void a(E paramE, boolean paramBoolean)
  {
    this.a.lock();
    label116:
    for (;;)
    {
      try
      {
        if (this.d.remove(paramE))
        {
          i locali = c(paramE.h());
          locali.a(paramE, paramBoolean);
          if ((!paramBoolean) || (this.h)) {
            continue;
          }
          this.e.addFirst(paramE);
          b(paramE);
          paramE = locali.g();
          if (paramE == null) {
            break label116;
          }
          this.f.remove(paramE);
          if (paramE != null) {
            paramE.a();
          }
        }
        return;
        paramE.f();
        continue;
        paramE = (g)this.f.poll();
      }
      finally
      {
        this.a.unlock();
      }
    }
  }
  
  protected void a(f<T, C> paramf)
  {
    this.a.lock();
    try
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        paramf.a(locale);
        if (locale.e())
        {
          c(locale.h()).a(locale);
          localIterator.remove();
        }
      }
      g();
    }
    finally
    {
      this.a.unlock();
    }
    this.a.unlock();
  }
  
  public void a(T paramT, int paramInt)
  {
    cz.msebera.android.httpclient.o.a.a(paramT, "Route");
    cz.msebera.android.httpclient.o.a.b(paramInt, "Max per route value");
    this.a.lock();
    try
    {
      this.g.put(paramT, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public int b(T paramT)
  {
    cz.msebera.android.httpclient.o.a.a(paramT, "Route");
    this.a.lock();
    try
    {
      int k = d(paramT);
      return k;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public Future<E> b(T paramT, Object paramObject)
  {
    return a(paramT, paramObject, null);
  }
  
  public void b()
    throws IOException
  {
    if (this.h) {
      return;
    }
    this.h = true;
    this.a.lock();
    try
    {
      Iterator localIterator1 = this.e.iterator();
      while (localIterator1.hasNext()) {
        ((e)localIterator1.next()).f();
      }
      localIterator2 = this.d.iterator();
    }
    finally
    {
      this.a.unlock();
    }
    while (localIterator2.hasNext()) {
      ((e)localIterator2.next()).f();
    }
    Iterator localIterator2 = this.c.values().iterator();
    while (localIterator2.hasNext()) {
      ((i)localIterator2.next()).h();
    }
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.a.unlock();
  }
  
  public void b(int paramInt)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Max per route value");
    this.a.lock();
    try
    {
      this.i = paramInt;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  protected void b(E paramE) {}
  
  protected void b(f<T, C> paramf)
  {
    this.a.lock();
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        paramf.a((e)localIterator.next());
      }
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public void c()
  {
    a(new f()
    {
      public void a(e<T, C> paramAnonymouse)
      {
        if (paramAnonymouse.a(this.a)) {
          paramAnonymouse.f();
        }
      }
    });
  }
  
  public int d()
  {
    this.a.lock();
    try
    {
      int k = this.j;
      return k;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public int e()
  {
    this.a.lock();
    try
    {
      int k = this.i;
      return k;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public h f()
  {
    this.a.lock();
    try
    {
      h localh = new h(this.d.size(), this.f.size(), this.e.size(), this.j);
      return localh;
    }
    finally
    {
      this.a.unlock();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */