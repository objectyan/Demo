package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.l;
import cz.msebera.android.httpclient.a.m;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.u;
import java.util.Locale;

@NotThreadSafe
public abstract class a
  implements m
{
  private l a;
  
  public a() {}
  
  @Deprecated
  public a(l paraml)
  {
    this.a = paraml;
  }
  
  public cz.msebera.android.httpclient.f a(n paramn, u paramu, g paramg)
    throws j
  {
    return a(paramn, paramu);
  }
  
  public void a(cz.msebera.android.httpclient.f paramf)
    throws p
  {
    cz.msebera.android.httpclient.o.a.a(paramf, "Header");
    Object localObject = paramf.c();
    int i;
    if (((String)localObject).equalsIgnoreCase("WWW-Authenticate"))
    {
      this.a = l.a;
      if (!(paramf instanceof e)) {
        break label137;
      }
      localObject = ((e)paramf).a();
      i = ((e)paramf).b();
      paramf = (cz.msebera.android.httpclient.f)localObject;
    }
    for (;;)
    {
      if ((i >= paramf.e()) || (!cz.msebera.android.httpclient.n.f.a(paramf.a(i)))) {
        break label184;
      }
      i += 1;
      continue;
      if (((String)localObject).equalsIgnoreCase("Proxy-Authenticate"))
      {
        this.a = l.b;
        break;
      }
      throw new p("Unexpected header name: " + (String)localObject);
      label137:
      localObject = paramf.d();
      if (localObject == null) {
        throw new p("Header value is null");
      }
      paramf = new d(((String)localObject).length());
      paramf.a((String)localObject);
      i = 0;
    }
    label184:
    int j = i;
    while ((j < paramf.e()) && (!cz.msebera.android.httpclient.n.f.a(paramf.a(j)))) {
      j += 1;
    }
    localObject = paramf.a(i, j);
    if (!((String)localObject).equalsIgnoreCase(a())) {
      throw new p("Invalid scheme identifier: " + (String)localObject);
    }
    a(paramf, j, paramf.e());
  }
  
  protected abstract void a(d paramd, int paramInt1, int paramInt2)
    throws p;
  
  public boolean e()
  {
    return (this.a != null) && (this.a == l.b);
  }
  
  public l f()
  {
    return this.a;
  }
  
  public String toString()
  {
    String str = a();
    if (str != null) {
      return str.toUpperCase(Locale.ENGLISH);
    }
    return super.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */