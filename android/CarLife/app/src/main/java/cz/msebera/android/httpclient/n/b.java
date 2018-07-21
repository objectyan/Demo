package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
@NotThreadSafe
public final class b
  implements k, r, s, Cloneable
{
  protected final List<w> a = new ArrayList();
  protected final List<z> b = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public w a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return (w)this.a.get(paramInt);
  }
  
  protected void a(b paramb)
  {
    paramb.a.clear();
    paramb.a.addAll(this.a);
    paramb.b.clear();
    paramb.b.addAll(this.b);
  }
  
  public void a(w paramw)
  {
    if (paramw == null) {
      return;
    }
    this.a.add(paramw);
  }
  
  public void a(w paramw, int paramInt)
  {
    if (paramw == null) {
      return;
    }
    this.a.add(paramInt, paramw);
  }
  
  public void a(z paramz)
  {
    if (paramz == null) {
      return;
    }
    this.b.add(paramz);
  }
  
  public void a(z paramz, int paramInt)
  {
    if (paramz == null) {
      return;
    }
    this.b.add(paramInt, paramz);
  }
  
  public void a(Class<? extends w> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next().getClass().equals(paramClass)) {
        localIterator.remove();
      }
    }
  }
  
  public void a(List<?> paramList)
  {
    a.a(paramList, "Inteceptor list");
    this.a.clear();
    this.b.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof w)) {
        b((w)localObject);
      }
      if ((localObject instanceof z)) {
        b((z)localObject);
      }
    }
  }
  
  public z b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.b.size())) {
      return null;
    }
    return (z)this.b.get(paramInt);
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public final void b(w paramw)
  {
    a(paramw);
  }
  
  public final void b(w paramw, int paramInt)
  {
    a(paramw, paramInt);
  }
  
  public final void b(z paramz)
  {
    a(paramz);
  }
  
  public final void b(z paramz, int paramInt)
  {
    a(paramz, paramInt);
  }
  
  public void b(Class<? extends z> paramClass)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next().getClass().equals(paramClass)) {
        localIterator.remove();
      }
    }
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    b localb = (b)super.clone();
    a(localb);
    return localb;
  }
  
  public void d()
  {
    this.b.clear();
  }
  
  public void e()
  {
    b();
    d();
  }
  
  public b f()
  {
    b localb = new b();
    a(localb);
    return localb;
  }
  
  public void process(u paramu, g paramg)
    throws IOException, p
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((w)localIterator.next()).process(paramu, paramg);
    }
  }
  
  public void process(x paramx, g paramg)
    throws IOException, p
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((z)localIterator.next()).process(paramx, paramg);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */