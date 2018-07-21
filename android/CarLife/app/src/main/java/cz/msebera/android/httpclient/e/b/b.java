package cz.msebera.android.httpclient.e.b;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Immutable
public final class b
  implements e, Cloneable
{
  private final r a;
  private final InetAddress b;
  private final List<r> c;
  private final e.b d;
  private final e.a e;
  private final boolean f;
  
  public b(r paramr)
  {
    this(paramr, null, Collections.emptyList(), false, e.b.a, e.a.a);
  }
  
  public b(r paramr1, r paramr2)
  {
    this(paramr1, null, paramr2, false);
  }
  
  public b(r paramr1, InetAddress paramInetAddress, r paramr2, boolean paramBoolean) {}
  
  public b(r paramr1, InetAddress paramInetAddress, r paramr2, boolean paramBoolean, e.b paramb, e.a parama) {}
  
  private b(r paramr, InetAddress paramInetAddress, List<r> paramList, boolean paramBoolean, e.b paramb, e.a parama)
  {
    a.a(paramr, "Target host");
    this.a = paramr;
    this.b = paramInetAddress;
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.c = new ArrayList(paramList);
      if (paramb == e.b.b)
      {
        if (this.c == null) {
          break label108;
        }
        bool = true;
        label64:
        a.a(bool, "Proxy required if tunnelled");
      }
      this.f = paramBoolean;
      if (paramb == null) {
        break label114;
      }
      label82:
      this.d = paramb;
      if (parama == null) {
        break label122;
      }
    }
    for (;;)
    {
      this.e = parama;
      return;
      this.c = null;
      break;
      label108:
      bool = false;
      break label64;
      label114:
      paramb = e.b.a;
      break label82;
      label122:
      parama = e.a.a;
    }
  }
  
  public b(r paramr, InetAddress paramInetAddress, boolean paramBoolean)
  {
    this(paramr, paramInetAddress, Collections.emptyList(), paramBoolean, e.b.a, e.a.a);
  }
  
  public b(r paramr, InetAddress paramInetAddress, r[] paramArrayOfr, boolean paramBoolean, e.b paramb, e.a parama) {}
  
  public final r a()
  {
    return this.a;
  }
  
  public final r a(int paramInt)
  {
    a.b(paramInt, "Hop index");
    int i = d();
    if (paramInt < i) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(bool, "Hop index exceeds tracked route length");
      if (paramInt >= i - 1) {
        break;
      }
      return (r)this.c.get(paramInt);
    }
    return this.a;
  }
  
  public final InetAddress b()
  {
    return this.b;
  }
  
  public final InetSocketAddress c()
  {
    if (this.b != null) {
      return new InetSocketAddress(this.b, 0);
    }
    return null;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public final int d()
  {
    if (this.c != null) {
      return this.c.size() + 1;
    }
    return 1;
  }
  
  public final r e()
  {
    if ((this.c != null) && (!this.c.isEmpty())) {
      return (r)this.c.get(0);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        break;
      }
      paramObject = (b)paramObject;
    } while ((this.f == ((b)paramObject).f) && (this.d == ((b)paramObject).d) && (this.e == ((b)paramObject).e) && (i.a(this.a, ((b)paramObject).a)) && (i.a(this.b, ((b)paramObject).b)) && (i.a(this.c, ((b)paramObject).c)));
    return false;
    return false;
  }
  
  public final e.b f()
  {
    return this.d;
  }
  
  public final boolean g()
  {
    return this.d == e.b.b;
  }
  
  public final e.a h()
  {
    return this.e;
  }
  
  public final int hashCode()
  {
    int i = i.a(i.a(17, this.a), this.b);
    int j = i;
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i.a(i, (r)localIterator.next());
      }
    }
    return i.a(i.a(i.a(j, this.f), this.d), this.e);
  }
  
  public final boolean i()
  {
    return this.e == e.a.b;
  }
  
  public final boolean j()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(d() * 30 + 50);
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.d == e.b.b) {
      localStringBuilder.append('t');
    }
    if (this.e == e.a.b) {
      localStringBuilder.append('l');
    }
    if (this.f) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append("}->");
    if (this.c != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((r)localIterator.next());
        localStringBuilder.append("->");
      }
    }
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */