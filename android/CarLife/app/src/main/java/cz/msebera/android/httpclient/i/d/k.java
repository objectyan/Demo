package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.h;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.o;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.util.Iterator;
import java.util.List;

@NotThreadSafe
public class k
  implements h
{
  private final String[] a;
  private final boolean b;
  private ai c;
  private ab d;
  private m e;
  
  public k()
  {
    this(null, false);
  }
  
  public k(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = null;; paramArrayOfString = (String[])paramArrayOfString.clone())
    {
      this.a = paramArrayOfString;
      this.b = paramBoolean;
      return;
    }
  }
  
  private ai c()
  {
    if (this.c == null) {
      this.c = new ai(this.a, this.b);
    }
    return this.c;
  }
  
  private ab d()
  {
    if (this.d == null) {
      this.d = new ab(this.a, this.b);
    }
    return this.d;
  }
  
  private m e()
  {
    if (this.e == null) {
      this.e = new m(this.a);
    }
    return this.e;
  }
  
  public int a()
  {
    return c().a();
  }
  
  public List<b> a(f paramf, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    a.a(paramf, "Header");
    a.a(parame, "Cookie origin");
    Object localObject = paramf.e();
    int k = 0;
    int j = 0;
    int m = localObject.length;
    int i = 0;
    d locald;
    while (i < m)
    {
      locald = localObject[i];
      if (locald.a("version") != null) {
        k = 1;
      }
      if (locald.a("expires") != null) {
        j = 1;
      }
      i += 1;
    }
    if ((j != 0) || (k == 0))
    {
      v localv = v.a;
      if ((paramf instanceof cz.msebera.android.httpclient.e))
      {
        locald = ((cz.msebera.android.httpclient.e)paramf).a();
        localObject = new x(((cz.msebera.android.httpclient.e)paramf).b(), locald.e());
        paramf = locald;
      }
      for (;;)
      {
        paramf = localv.a(paramf, (x)localObject);
        return e().a(new g[] { paramf }, parame);
        localObject = paramf.d();
        if (localObject == null) {
          throw new l("Header value is null");
        }
        paramf = new d(((String)localObject).length());
        paramf.a((String)localObject);
        localObject = new x(0, paramf.e());
      }
    }
    if ("Set-Cookie2".equals(paramf.c())) {
      return c().a((g[])localObject, parame);
    }
    return d().a((g[])localObject, parame);
  }
  
  public List<f> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    int i = Integer.MAX_VALUE;
    int j = 1;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int k = j;
      if (!(localb instanceof o)) {
        k = 0;
      }
      j = k;
      if (localb.k() < i)
      {
        i = localb.k();
        j = k;
      }
    }
    if (i > 0)
    {
      if (j != 0) {
        return c().a(paramList);
      }
      return d().a(paramList);
    }
    return e().a(paramList);
  }
  
  public void a(b paramb, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    if (paramb.k() > 0)
    {
      if ((paramb instanceof o))
      {
        c().a(paramb, parame);
        return;
      }
      d().a(paramb, parame);
      return;
    }
    e().a(paramb, parame);
  }
  
  public f b()
  {
    return c().b();
  }
  
  public boolean b(b paramb, cz.msebera.android.httpclient.f.e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    if (paramb.k() > 0)
    {
      if ((paramb instanceof o)) {
        return c().b(paramb, parame);
      }
      return d().b(paramb, parame);
    }
    return e().b(paramb, parame);
  }
  
  public String toString()
  {
    return "best-match";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */