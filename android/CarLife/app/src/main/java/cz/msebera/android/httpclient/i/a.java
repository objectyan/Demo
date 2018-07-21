package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.e.d;
import cz.msebera.android.httpclient.i.g.r;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.y;
import java.io.IOException;
import java.net.SocketTimeoutException;

@Deprecated
@NotThreadSafe
public abstract class a
  implements cz.msebera.android.httpclient.j
{
  private final cz.msebera.android.httpclient.i.e.c a = q();
  private final cz.msebera.android.httpclient.i.e.b b = p();
  private h c = null;
  private i d = null;
  private cz.msebera.android.httpclient.j.b e = null;
  private cz.msebera.android.httpclient.j.c<x> f = null;
  private cz.msebera.android.httpclient.j.e<u> g = null;
  private o h = null;
  
  protected o a(g paramg1, g paramg2)
  {
    return new o(paramg1, paramg2);
  }
  
  protected cz.msebera.android.httpclient.j.c<x> a(h paramh, y paramy, cz.msebera.android.httpclient.l.j paramj)
  {
    return new cz.msebera.android.httpclient.i.g.m(paramh, null, paramy, paramj);
  }
  
  protected cz.msebera.android.httpclient.j.e<u> a(i parami, cz.msebera.android.httpclient.l.j paramj)
  {
    return new r(parami, null, paramj);
  }
  
  public x a()
    throws p, IOException
  {
    o();
    x localx = (x)this.f.a();
    if (localx.a().b() >= 200) {
      this.h.g();
    }
    return localx;
  }
  
  protected void a(h paramh, i parami, cz.msebera.android.httpclient.l.j paramj)
  {
    this.c = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Input session buffer"));
    this.d = ((i)cz.msebera.android.httpclient.o.a.a(parami, "Output session buffer"));
    if ((paramh instanceof cz.msebera.android.httpclient.j.b)) {
      this.e = ((cz.msebera.android.httpclient.j.b)paramh);
    }
    this.f = a(paramh, r(), paramj);
    this.g = a(parami, paramj);
    this.h = a(paramh.c(), parami.b());
  }
  
  public void a(cz.msebera.android.httpclient.o paramo)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramo, "HTTP request");
    o();
    if (paramo.getEntity() == null) {
      return;
    }
    this.a.a(this.d, paramo, paramo.getEntity());
  }
  
  public void a(u paramu)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    o();
    this.g.b(paramu);
    this.h.f();
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP response");
    o();
    paramx.a(this.b.b(this.c, paramx));
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    o();
    try
    {
      boolean bool = this.c.a(paramInt);
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
    return false;
  }
  
  public boolean d()
  {
    if (!c()) {}
    while (v()) {
      return true;
    }
    try
    {
      this.c.a(1);
      boolean bool = v();
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return false;
    }
    catch (IOException localIOException) {}
    return true;
  }
  
  public cz.msebera.android.httpclient.m g()
  {
    return this.h;
  }
  
  public void h_()
    throws IOException
  {
    o();
    u();
  }
  
  protected abstract void o()
    throws IllegalStateException;
  
  protected cz.msebera.android.httpclient.i.e.b p()
  {
    return new cz.msebera.android.httpclient.i.e.b(new d());
  }
  
  protected cz.msebera.android.httpclient.i.e.c q()
  {
    return new cz.msebera.android.httpclient.i.e.c(new cz.msebera.android.httpclient.i.e.e());
  }
  
  protected y r()
  {
    return l.a;
  }
  
  protected void u()
    throws IOException
  {
    this.d.a();
  }
  
  protected boolean v()
  {
    return (this.e != null) && (this.e.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */