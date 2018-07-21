package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;

@Deprecated
@ThreadSafe
public class f
  implements cz.msebera.android.httpclient.b.j
{
  public b a = new b(getClass());
  private final cz.msebera.android.httpclient.b.j b;
  private final cz.msebera.android.httpclient.b.s c;
  
  public f()
  {
    this(new s(), new z());
  }
  
  public f(cz.msebera.android.httpclient.b.j paramj)
  {
    this(paramj, new z());
  }
  
  public f(cz.msebera.android.httpclient.b.j paramj, cz.msebera.android.httpclient.b.s params)
  {
    a.a(paramj, "HttpClient");
    a.a(params, "ServiceUnavailableRetryStrategy");
    this.b = paramj;
    this.c = params;
  }
  
  public f(cz.msebera.android.httpclient.b.s params)
  {
    this(new s(), params);
  }
  
  public cz.msebera.android.httpclient.l.j a()
  {
    return this.b.a();
  }
  
  public x a(q paramq)
    throws IOException
  {
    return a(paramq, null);
  }
  
  public x a(q paramq, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    URI localURI = paramq.getURI();
    return a(new cz.msebera.android.httpclient.r(localURI.getHost(), localURI.getPort(), localURI.getScheme()), paramq, paramg);
  }
  
  public x a(cz.msebera.android.httpclient.r paramr, u paramu)
    throws IOException
  {
    return a(paramr, paramu, null);
  }
  
  public x a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    int i = 1;
    for (;;)
    {
      localx = this.b.a(paramr, paramu, paramg);
      try
      {
        if (this.c.a(localx, i, paramg))
        {
          cz.msebera.android.httpclient.o.g.b(localx.b());
          long l = this.c.a();
          try
          {
            this.a.e("Wait for " + l);
            Thread.sleep(l);
            i += 1;
          }
          catch (InterruptedException paramr)
          {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
          }
        }
        return localx;
      }
      catch (RuntimeException paramr)
      {
        try
        {
          cz.msebera.android.httpclient.o.g.b(localx.b());
          throw paramr;
        }
        catch (IOException paramu)
        {
          for (;;)
          {
            this.a.c("I/O error consuming response content", paramu);
          }
        }
      }
    }
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr)
    throws IOException
  {
    return (T)a(paramq, paramr, null);
  }
  
  public <T> T a(q paramq, cz.msebera.android.httpclient.b.r<? extends T> paramr, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    return (T)paramr.a(a(paramq, paramg));
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1)
    throws IOException
  {
    return (T)a(paramr, paramu, paramr1, null);
  }
  
  public <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, cz.msebera.android.httpclient.b.r<? extends T> paramr1, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    return (T)paramr1.a(a(paramr, paramu, paramg));
  }
  
  public c b()
  {
    return this.b.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */