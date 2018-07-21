package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.f;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.b.j;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;

@ThreadSafe
public abstract class m
  implements j, Closeable
{
  public b b = new b(getClass());
  
  private static cz.msebera.android.httpclient.r c(q paramq)
    throws f
  {
    cz.msebera.android.httpclient.r localr = null;
    URI localURI = paramq.getURI();
    paramq = localr;
    if (localURI.isAbsolute())
    {
      localr = i.b(localURI);
      paramq = localr;
      if (localr == null) {
        throw new f("URI does not specify a valid host name: " + localURI);
      }
    }
    return paramq;
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr)
    throws IOException, f
  {
    return (T)a(paramq, paramr, null);
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    return (T)a(c(paramq), paramq, paramr, paramg);
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1)
    throws IOException, f
  {
    return (T)a(paramr, paramu, paramr1, null);
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    a.a(paramr1, "Response handler");
    paramr = c(paramr, paramu, paramg);
    try
    {
      paramu = paramr1.a(paramr);
      cz.msebera.android.httpclient.o.g.b(paramr.b());
      return paramu;
    }
    catch (Exception paramu)
    {
      paramr = paramr.b();
      try
      {
        cz.msebera.android.httpclient.o.g.b(paramr);
        if ((paramu instanceof RuntimeException)) {
          throw ((RuntimeException)paramu);
        }
      }
      catch (Exception paramr)
      {
        for (;;)
        {
          this.b.c("Error consuming content after an exception.", paramr);
        }
        if ((paramu instanceof IOException)) {
          throw ((IOException)paramu);
        }
        throw new UndeclaredThrowableException(paramu);
      }
    }
  }
  
  public c b(q paramq)
    throws IOException, f
  {
    return b(paramq, (cz.msebera.android.httpclient.n.g)null);
  }
  
  public c b(q paramq, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    a.a(paramq, "HTTP request");
    return b(c(paramq), paramq, paramg);
  }
  
  public c b(cz.msebera.android.httpclient.r paramr, u paramu)
    throws IOException, f
  {
    return b(paramr, paramu, (cz.msebera.android.httpclient.n.g)null);
  }
  
  protected abstract c b(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f;
  
  public c c(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws IOException, f
  {
    return b(paramr, paramu, paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */