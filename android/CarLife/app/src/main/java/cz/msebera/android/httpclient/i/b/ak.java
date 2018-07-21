package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.h;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.l.k;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ThreadSafe
class ak
  extends m
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final cz.msebera.android.httpclient.i.f.b c;
  private final cz.msebera.android.httpclient.e.o d;
  private final cz.msebera.android.httpclient.e.b.d e;
  private final cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.f.j> f;
  private final cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.a.f> g;
  private final h h;
  private final cz.msebera.android.httpclient.b.i i;
  private final cz.msebera.android.httpclient.b.b.c j;
  private final List<Closeable> k;
  
  public ak(cz.msebera.android.httpclient.i.f.b paramb, cz.msebera.android.httpclient.e.o paramo, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.f.j> paramb1, cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.a.f> paramb2, h paramh, cz.msebera.android.httpclient.b.i parami, cz.msebera.android.httpclient.b.b.c paramc, List<Closeable> paramList)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP client exec chain");
    cz.msebera.android.httpclient.o.a.a(paramo, "HTTP connection manager");
    cz.msebera.android.httpclient.o.a.a(paramd, "HTTP route planner");
    this.c = paramb;
    this.d = paramo;
    this.e = paramd;
    this.f = paramb1;
    this.g = paramb2;
    this.h = paramh;
    this.i = parami;
    this.j = paramc;
    this.k = paramList;
  }
  
  private void a(cz.msebera.android.httpclient.b.f.c paramc)
  {
    if (paramc.a("http.auth.target-scope") == null) {
      paramc.a("http.auth.target-scope", new cz.msebera.android.httpclient.a.i());
    }
    if (paramc.a("http.auth.proxy-scope") == null) {
      paramc.a("http.auth.proxy-scope", new cz.msebera.android.httpclient.a.i());
    }
    if (paramc.a("http.authscheme-registry") == null) {
      paramc.a("http.authscheme-registry", this.g);
    }
    if (paramc.a("http.cookiespec-registry") == null) {
      paramc.a("http.cookiespec-registry", this.f);
    }
    if (paramc.a("http.cookie-store") == null) {
      paramc.a("http.cookie-store", this.h);
    }
    if (paramc.a("http.auth.credentials-provider") == null) {
      paramc.a("http.auth.credentials-provider", this.i);
    }
    if (paramc.a("http.request-config") == null) {
      paramc.a("http.request-config", this.j);
    }
  }
  
  private cz.msebera.android.httpclient.e.b.b d(r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws p
  {
    r localr = paramr;
    if (paramr == null) {
      localr = (r)paramu.getParams().a("http.default-host");
    }
    return this.e.a(localr, paramu, paramg);
  }
  
  public cz.msebera.android.httpclient.l.j a()
  {
    throw new UnsupportedOperationException();
  }
  
  protected cz.msebera.android.httpclient.b.d.c b(r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, cz.msebera.android.httpclient.b.f
  {
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    cz.msebera.android.httpclient.b.d.g localg = null;
    if ((paramu instanceof cz.msebera.android.httpclient.b.d.g)) {
      localg = (cz.msebera.android.httpclient.b.d.g)paramu;
    }
    label171:
    for (;;)
    {
      try
      {
        cz.msebera.android.httpclient.b.d.o localo = cz.msebera.android.httpclient.b.d.o.a(paramu);
        if (paramg != null)
        {
          cz.msebera.android.httpclient.b.f.c localc = cz.msebera.android.httpclient.b.f.c.b(paramg);
          paramg = null;
          if ((paramu instanceof cz.msebera.android.httpclient.b.d.d)) {
            paramg = ((cz.msebera.android.httpclient.b.d.d)paramu).getConfig();
          }
          localObject = paramg;
          if (paramg == null)
          {
            paramu = paramu.getParams();
            if (!(paramu instanceof k)) {
              break label171;
            }
            localObject = paramg;
            if (!((k)paramu).f().isEmpty()) {
              localObject = cz.msebera.android.httpclient.b.e.f.a(paramu);
            }
          }
          if (localObject != null) {
            localc.a((cz.msebera.android.httpclient.b.b.c)localObject);
          }
          a(localc);
          paramr = d(paramr, localo, localc);
          return this.c.a(paramr, localo, localc, localg);
        }
        else
        {
          paramg = new cz.msebera.android.httpclient.n.a();
          continue;
        }
        Object localObject = cz.msebera.android.httpclient.b.e.f.a(paramu);
      }
      catch (p paramr)
      {
        throw new cz.msebera.android.httpclient.b.f(paramr);
      }
    }
  }
  
  public cz.msebera.android.httpclient.e.c b()
  {
    new cz.msebera.android.httpclient.e.c()
    {
      public cz.msebera.android.httpclient.e.c.j a()
      {
        throw new UnsupportedOperationException();
      }
      
      public cz.msebera.android.httpclient.e.f a(cz.msebera.android.httpclient.e.b.b paramAnonymousb, Object paramAnonymousObject)
      {
        throw new UnsupportedOperationException();
      }
      
      public void a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        ak.a(ak.this).a(paramAnonymousLong, paramAnonymousTimeUnit);
      }
      
      public void a(t paramAnonymoust, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        throw new UnsupportedOperationException();
      }
      
      public void b()
      {
        ak.a(ak.this).a();
      }
      
      public void c()
      {
        ak.a(ak.this).b();
      }
    };
  }
  
  public void close()
  {
    this.d.b();
    if (this.k != null)
    {
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        Closeable localCloseable = (Closeable)localIterator.next();
        try
        {
          localCloseable.close();
        }
        catch (IOException localIOException)
        {
          this.a.b(localIOException.getMessage(), localIOException);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */