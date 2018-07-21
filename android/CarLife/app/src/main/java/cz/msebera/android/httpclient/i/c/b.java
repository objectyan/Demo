package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.e.b.f;
import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.io.InterruptedIOException;

@Deprecated
public abstract class b
{
  protected final e a;
  protected final w b;
  protected volatile cz.msebera.android.httpclient.e.b.b c;
  protected volatile Object d;
  protected volatile f e;
  
  protected b(e parame, cz.msebera.android.httpclient.e.b.b paramb)
  {
    a.a(parame, "Connection operator");
    this.a = parame;
    this.b = parame.a();
    this.c = paramb;
    this.e = null;
  }
  
  public Object a()
  {
    return this.d;
  }
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, g paramg, j paramj)
    throws IOException
  {
    a.a(paramb, "Route");
    a.a(paramj, "HTTP parameters");
    boolean bool;
    r localr2;
    e locale;
    w localw;
    if (this.e != null)
    {
      if (!this.e.k())
      {
        bool = true;
        cz.msebera.android.httpclient.o.b.a(bool, "Connection already open");
      }
    }
    else
    {
      this.e = new f(paramb);
      localr2 = paramb.e();
      locale = this.a;
      localw = this.b;
      if (localr2 == null) {
        break label122;
      }
    }
    label122:
    for (r localr1 = localr2;; localr1 = paramb.a())
    {
      locale.a(localw, localr1, paramb.b(), paramg, paramj);
      paramb = this.e;
      if (paramb != null) {
        break label131;
      }
      throw new InterruptedIOException("Request aborted");
      bool = false;
      break;
    }
    label131:
    if (localr2 == null)
    {
      paramb.a(this.b.m());
      return;
    }
    paramb.a(localr2, this.b.m());
  }
  
  public void a(g paramg, j paramj)
    throws IOException
  {
    a.a(paramj, "HTTP parameters");
    cz.msebera.android.httpclient.o.b.a(this.e, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(this.e.k(), "Connection not open");
    cz.msebera.android.httpclient.o.b.a(this.e.g(), "Protocol layering without a tunnel not supported");
    if (!this.e.i()) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Multiple protocol layering not supported");
      r localr = this.e.a();
      this.a.a(this.b, localr, paramg, paramj);
      this.e.c(this.b.m());
      return;
    }
  }
  
  public void a(r paramr, boolean paramBoolean, j paramj)
    throws IOException
  {
    a.a(paramr, "Next proxy");
    a.a(paramj, "Parameters");
    cz.msebera.android.httpclient.o.b.a(this.e, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(this.e.k(), "Connection not open");
    this.b.a(null, paramr, paramBoolean, paramj);
    this.e.b(paramr, paramBoolean);
  }
  
  public void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public void a(boolean paramBoolean, j paramj)
    throws IOException
  {
    a.a(paramj, "HTTP parameters");
    cz.msebera.android.httpclient.o.b.a(this.e, "Route tracker");
    cz.msebera.android.httpclient.o.b.a(this.e.k(), "Connection not open");
    if (!this.e.g()) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection is already tunnelled");
      this.b.a(null, this.e.a(), paramBoolean, paramj);
      this.e.b(paramBoolean);
      return;
    }
  }
  
  protected void b()
  {
    this.e = null;
    this.d = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */