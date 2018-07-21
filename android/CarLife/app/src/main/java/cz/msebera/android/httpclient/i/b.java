package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.aa;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.e.d;
import cz.msebera.android.httpclient.i.g.t;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.m;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.v;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

@Deprecated
@NotThreadSafe
public abstract class b
  implements aa
{
  private final cz.msebera.android.httpclient.i.e.c a = n();
  private final cz.msebera.android.httpclient.i.e.b b = m();
  private h c = null;
  private cz.msebera.android.httpclient.j.i d = null;
  private cz.msebera.android.httpclient.j.b e = null;
  private cz.msebera.android.httpclient.j.c<u> f = null;
  private cz.msebera.android.httpclient.j.e<x> g = null;
  private o h = null;
  
  protected o a(g paramg1, g paramg2)
  {
    return new o(paramg1, paramg2);
  }
  
  protected cz.msebera.android.httpclient.j.c<u> a(h paramh, v paramv, j paramj)
  {
    return new cz.msebera.android.httpclient.i.g.i(paramh, null, paramv, paramj);
  }
  
  protected cz.msebera.android.httpclient.j.e<x> a(cz.msebera.android.httpclient.j.i parami, j paramj)
  {
    return new t(parami, null, paramj);
  }
  
  public u a()
    throws p, IOException
  {
    l();
    u localu = (u)this.f.a();
    this.h.f();
    return localu;
  }
  
  protected void a(h paramh, cz.msebera.android.httpclient.j.i parami, j paramj)
  {
    this.c = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Input session buffer"));
    this.d = ((cz.msebera.android.httpclient.j.i)cz.msebera.android.httpclient.o.a.a(parami, "Output session buffer"));
    if ((paramh instanceof cz.msebera.android.httpclient.j.b)) {
      this.e = ((cz.msebera.android.httpclient.j.b)paramh);
    }
    this.f = a(paramh, o(), paramj);
    this.g = a(parami, paramj);
    this.h = a(paramh.c(), parami.b());
  }
  
  public void a(cz.msebera.android.httpclient.o paramo)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramo, "HTTP request");
    l();
    paramo.setEntity(this.b.b(this.c, paramo));
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    l();
    this.g.b(paramx);
    if (paramx.a().b() >= 200) {
      this.h.g();
    }
  }
  
  public void b()
    throws IOException
  {
    l();
    p();
  }
  
  public void b(x paramx)
    throws p, IOException
  {
    if (paramx.b() == null) {
      return;
    }
    this.a.a(this.d, paramx, paramx.b());
  }
  
  public boolean d()
  {
    if (!c()) {}
    while (q()) {
      return true;
    }
    try
    {
      this.c.a(1);
      boolean bool = q();
      return bool;
    }
    catch (IOException localIOException) {}
    return true;
  }
  
  public m g()
  {
    return this.h;
  }
  
  protected abstract void l()
    throws IllegalStateException;
  
  protected cz.msebera.android.httpclient.i.e.b m()
  {
    return new cz.msebera.android.httpclient.i.e.b(new cz.msebera.android.httpclient.i.e.a(new d(0)));
  }
  
  protected cz.msebera.android.httpclient.i.e.c n()
  {
    return new cz.msebera.android.httpclient.i.e.c(new cz.msebera.android.httpclient.i.e.e());
  }
  
  protected v o()
  {
    return k.a;
  }
  
  protected void p()
    throws IOException
  {
    this.d.a();
  }
  
  protected boolean q()
  {
    return (this.e != null) && (this.e.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */