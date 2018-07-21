package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@NotThreadSafe
public class s
  implements Serializable, Cloneable
{
  private static final long a = 2608834160639271617L;
  private final List<f> b = new ArrayList(16);
  
  public f a(String paramString)
  {
    f[] arrayOff = b(paramString);
    if (arrayOff.length == 0) {
      return null;
    }
    if (arrayOff.length == 1) {
      return arrayOff[0];
    }
    d locald = new d(128);
    locald.a(arrayOff[0].d());
    int i = 1;
    while (i < arrayOff.length)
    {
      locald.a(", ");
      locald.a(arrayOff[i].d());
      i += 1;
    }
    return new b(paramString.toLowerCase(Locale.ENGLISH), locald.toString());
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(f paramf)
  {
    if (paramf == null) {
      return;
    }
    this.b.add(paramf);
  }
  
  public void a(f[] paramArrayOff)
  {
    a();
    if (paramArrayOff == null) {
      return;
    }
    Collections.addAll(this.b, paramArrayOff);
  }
  
  public void b(f paramf)
  {
    if (paramf == null) {
      return;
    }
    this.b.remove(paramf);
  }
  
  public f[] b()
  {
    return (f[])this.b.toArray(new f[this.b.size()]);
  }
  
  public f[] b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.b.size())
    {
      f localf = (f)this.b.get(i);
      if (localf.c().equalsIgnoreCase(paramString)) {
        localArrayList.add(localf);
      }
      i += 1;
    }
    return (f[])localArrayList.toArray(new f[localArrayList.size()]);
  }
  
  public f c(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      f localf = (f)this.b.get(i);
      if (localf.c().equalsIgnoreCase(paramString)) {
        return localf;
      }
      i += 1;
    }
    return null;
  }
  
  public i c()
  {
    return new m(this.b, null);
  }
  
  public void c(f paramf)
  {
    if (paramf == null) {
      return;
    }
    int i = 0;
    while (i < this.b.size())
    {
      if (((f)this.b.get(i)).c().equalsIgnoreCase(paramf.c()))
      {
        this.b.set(i, paramf);
        return;
      }
      i += 1;
    }
    this.b.add(paramf);
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public f d(String paramString)
  {
    int i = this.b.size() - 1;
    while (i >= 0)
    {
      f localf = (f)this.b.get(i);
      if (localf.c().equalsIgnoreCase(paramString)) {
        return localf;
      }
      i -= 1;
    }
    return null;
  }
  
  public s d()
  {
    s locals = new s();
    locals.b.addAll(this.b);
    return locals;
  }
  
  public boolean e(String paramString)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((f)this.b.get(i)).c().equalsIgnoreCase(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public i f(String paramString)
  {
    return new m(this.b, paramString);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */