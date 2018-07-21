package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@ThreadSafe
public class h
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final b b;
  private final cz.msebera.android.httpclient.b.p c;
  private final cz.msebera.android.httpclient.e.b.d d;
  
  public h(b paramb, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.b.p paramp)
  {
    a.a(paramb, "HTTP client request executor");
    a.a(paramd, "HTTP route planner");
    a.a(paramp, "HTTP redirect strategy");
    this.b = paramb;
    this.d = paramd;
    this.c = paramp;
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.b.d.o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, cz.msebera.android.httpclient.p
  {
    a.a(paramb, "HTTP route");
    a.a(paramo, "HTTP request");
    a.a(paramc, "HTTP context");
    Object localObject = paramc.e();
    if (localObject != null) {
      ((List)localObject).clear();
    }
    cz.msebera.android.httpclient.b.b.c localc1 = paramc.p();
    int i;
    if (localc1.i() > 0) {
      i = localc1.i();
    }
    cz.msebera.android.httpclient.b.d.c localc;
    for (;;)
    {
      localObject = paramo;
      int j = 0;
      localc = this.b.a(paramb, (cz.msebera.android.httpclient.b.d.o)localObject, paramc, paramg);
      try
      {
        if ((localc1.f()) && (this.c.a((u)localObject, localc, paramc))) {
          if (j >= i) {
            throw new n("Maximum redirects (" + i + ") exceeded");
          }
        }
      }
      catch (RuntimeException paramb)
      {
        localc.close();
        throw paramb;
        i = 50;
        continue;
        j += 1;
        localObject = this.c.b((u)localObject, localc, paramc);
        if (!((u)localObject).headerIterator().hasNext()) {
          ((u)localObject).setHeaders(paramo.a().getAllHeaders());
        }
        localObject = cz.msebera.android.httpclient.b.d.o.a((u)localObject);
        if ((localObject instanceof cz.msebera.android.httpclient.o)) {
          j.a((cz.msebera.android.httpclient.o)localObject);
        }
        localURI = ((cz.msebera.android.httpclient.b.d.o)localObject).getURI();
        localr = cz.msebera.android.httpclient.b.g.i.b(localURI);
        if (localr == null) {
          throw new aj("Redirect URI does not specify a valid host name: " + localURI);
        }
      }
      catch (IOException paramb)
      {
        URI localURI;
        r localr;
        localc.close();
        throw paramb;
        if (!paramb.a().equals(localr))
        {
          paramb = paramc.m();
          if (paramb != null)
          {
            this.a.a("Resetting target auth state");
            paramb.a();
          }
          paramb = paramc.n();
          if (paramb != null)
          {
            cz.msebera.android.httpclient.a.d locald = paramb.c();
            if ((locald != null) && (locald.c()))
            {
              this.a.a("Resetting proxy auth state");
              paramb.a();
            }
          }
        }
        paramb = this.d.a(localr, (u)localObject, paramc);
        if (this.a.a()) {
          this.a.a("Redirecting to '" + localURI + "' via " + paramb);
        }
        cz.msebera.android.httpclient.o.g.b(localc.b());
        localc.close();
      }
      catch (cz.msebera.android.httpclient.p paramb)
      {
        try
        {
          cz.msebera.android.httpclient.o.g.b(localc.b());
        }
        catch (IOException paramo)
        {
          for (;;)
          {
            this.a.a("I/O error while releasing connection", paramo);
            localc.close();
          }
        }
        finally
        {
          localc.close();
        }
        throw paramb;
      }
    }
    return localc;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */