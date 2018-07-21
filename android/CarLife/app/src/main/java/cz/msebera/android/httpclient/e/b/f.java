package cz.msebera.android.httpclient.e.b;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;

@NotThreadSafe
public final class f
  implements e, Cloneable
{
  private final r a;
  private final InetAddress b;
  private boolean c;
  private r[] d;
  private e.b e;
  private e.a f;
  private boolean g;
  
  public f(b paramb)
  {
    this(paramb.a(), paramb.b());
  }
  
  public f(r paramr, InetAddress paramInetAddress)
  {
    a.a(paramr, "Target host");
    this.a = paramr;
    this.b = paramInetAddress;
    this.e = e.b.a;
    this.f = e.a.a;
  }
  
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
      return this.d[paramInt];
    }
    return this.a;
  }
  
  public final void a(r paramr, boolean paramBoolean)
  {
    a.a(paramr, "Proxy host");
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Already connected");
      this.c = true;
      this.d = new r[] { paramr };
      this.g = paramBoolean;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Already connected");
      this.c = true;
      this.g = paramBoolean;
      return;
    }
  }
  
  public final InetAddress b()
  {
    return this.b;
  }
  
  public final void b(r paramr, boolean paramBoolean)
  {
    a.a(paramr, "Proxy host");
    cz.msebera.android.httpclient.o.b.a(this.c, "No tunnel unless connected");
    cz.msebera.android.httpclient.o.b.a(this.d, "No tunnel without proxy");
    r[] arrayOfr = new r[this.d.length + 1];
    System.arraycopy(this.d, 0, arrayOfr, 0, this.d.length);
    arrayOfr[(arrayOfr.length - 1)] = paramr;
    this.d = arrayOfr;
    this.g = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    cz.msebera.android.httpclient.o.b.a(this.c, "No tunnel unless connected");
    cz.msebera.android.httpclient.o.b.a(this.d, "No tunnel without proxy");
    this.e = e.b.b;
    this.g = paramBoolean;
  }
  
  public void c()
  {
    this.c = false;
    this.d = null;
    this.e = e.b.a;
    this.f = e.a.a;
    this.g = false;
  }
  
  public final void c(boolean paramBoolean)
  {
    cz.msebera.android.httpclient.o.b.a(this.c, "No layered protocol unless connected");
    this.f = e.a.b;
    this.g = paramBoolean;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public final int d()
  {
    int i = 0;
    if (this.c)
    {
      if (this.d == null) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return this.d.length + 1;
  }
  
  public final r e()
  {
    if (this.d == null) {
      return null;
    }
    return this.d[0];
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while ((this.c == ((f)paramObject).c) && (this.g == ((f)paramObject).g) && (this.e == ((f)paramObject).e) && (this.f == ((f)paramObject).f) && (i.a(this.a, ((f)paramObject).a)) && (i.a(this.b, ((f)paramObject).b)) && (i.a(this.d, ((f)paramObject).d)));
    return false;
  }
  
  public final e.b f()
  {
    return this.e;
  }
  
  public final boolean g()
  {
    return this.e == e.b.b;
  }
  
  public final e.a h()
  {
    return this.f;
  }
  
  public final int hashCode()
  {
    int i = i.a(i.a(17, this.a), this.b);
    int k = i;
    if (this.d != null)
    {
      r[] arrayOfr = this.d;
      int m = arrayOfr.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i = i.a(i, arrayOfr[j]);
        j += 1;
      }
    }
    return i.a(i.a(i.a(i.a(k, this.c), this.g), this.e), this.f);
  }
  
  public final boolean i()
  {
    return this.f == e.a.b;
  }
  
  public final boolean j()
  {
    return this.g;
  }
  
  public final boolean k()
  {
    return this.c;
  }
  
  public final b l()
  {
    if (!this.c) {
      return null;
    }
    return new b(this.a, this.b, this.d, this.g, this.e, this.f);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(d() * 30 + 50);
    localStringBuilder.append("RouteTracker[");
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
    }
    localStringBuilder.append('{');
    if (this.c) {
      localStringBuilder.append('c');
    }
    if (this.e == e.b.b) {
      localStringBuilder.append('t');
    }
    if (this.f == e.a.b) {
      localStringBuilder.append('l');
    }
    if (this.g) {
      localStringBuilder.append('s');
    }
    localStringBuilder.append("}->");
    if (this.d != null)
    {
      r[] arrayOfr = this.d;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfr[i]);
        localStringBuilder.append("->");
        i += 1;
      }
    }
    localStringBuilder.append(this.a);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */