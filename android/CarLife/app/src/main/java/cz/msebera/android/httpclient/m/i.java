package cz.msebera.android.httpclient.m;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@NotThreadSafe
abstract class i<T, C, E extends e<T, C>>
{
  private final T a;
  private final Set<E> b;
  private final LinkedList<E> c;
  private final LinkedList<g<E>> d;
  
  i(T paramT)
  {
    this.a = paramT;
    this.b = new HashSet();
    this.c = new LinkedList();
    this.d = new LinkedList();
  }
  
  protected abstract E a(C paramC);
  
  public final T a()
  {
    return (T)this.a;
  }
  
  public void a(E paramE, boolean paramBoolean)
  {
    a.a(paramE, "Pool entry");
    b.a(this.b.remove(paramE), "Entry %s has not been leased from this pool", new Object[] { paramE });
    if (paramBoolean) {
      this.c.addFirst(paramE);
    }
  }
  
  public void a(g<E> paramg)
  {
    if (paramg == null) {
      return;
    }
    this.d.add(paramg);
  }
  
  public boolean a(E paramE)
  {
    a.a(paramE, "Pool entry");
    return (this.c.remove(paramE)) || (this.b.remove(paramE));
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public E b(Object paramObject)
  {
    if (!this.c.isEmpty())
    {
      Object localObject;
      if (paramObject != null)
      {
        localObject = this.c.iterator();
        while (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          if (paramObject.equals(locale.l()))
          {
            ((Iterator)localObject).remove();
            this.b.add(locale);
            return locale;
          }
        }
      }
      paramObject = this.c.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localObject = (e)((Iterator)paramObject).next();
        if (((e)localObject).l() == null)
        {
          ((Iterator)paramObject).remove();
          this.b.add(localObject);
          return (E)localObject;
        }
      }
    }
    return null;
  }
  
  public void b(g<E> paramg)
  {
    if (paramg == null) {
      return;
    }
    this.d.remove(paramg);
  }
  
  public int c()
  {
    return this.d.size();
  }
  
  public E c(C paramC)
  {
    paramC = a(paramC);
    this.b.add(paramC);
    return paramC;
  }
  
  public int d()
  {
    return this.c.size();
  }
  
  public int e()
  {
    return this.c.size() + this.b.size();
  }
  
  public E f()
  {
    if (!this.c.isEmpty()) {
      return (e)this.c.getLast();
    }
    return null;
  }
  
  public g<E> g()
  {
    return (g)this.d.poll();
  }
  
  public void h()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cancel(true);
    }
    this.d.clear();
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).f();
    }
    this.c.clear();
    localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).f();
    }
    this.b.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/m/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */