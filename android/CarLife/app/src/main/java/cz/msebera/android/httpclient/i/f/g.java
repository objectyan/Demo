package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.a.s;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.k;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Immutable
public class g
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final b b;
  private final k c;
  
  public g(b paramb, k paramk)
  {
    a.a(paramb, "HTTP client request executor");
    a.a(paramk, "HTTP protocol processor");
    this.b = paramb;
    this.c = paramk;
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, p
  {
    a.a(paramb, "HTTP route");
    a.a(paramo, "HTTP request");
    a.a(paramc, "HTTP context");
    Object localObject2 = paramo.a();
    Object localObject1 = null;
    Object localObject4;
    Object localObject3;
    if ((localObject2 instanceof q))
    {
      localObject2 = ((q)localObject2).getURI();
      paramo.a((URI)localObject2);
      a(paramo, paramb);
      localObject4 = (r)paramo.getParams().a("http.virtual-host");
      localObject1 = localObject4;
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        if (((r)localObject4).b() == -1)
        {
          int i = paramb.a().b();
          localObject3 = localObject4;
          if (i != -1) {
            localObject3 = new r(((r)localObject4).a(), i, ((r)localObject4).c());
          }
          localObject1 = localObject3;
          if (this.a.a())
          {
            this.a.a("Using virtual host" + localObject3);
            localObject1 = localObject3;
          }
        }
      }
      localObject3 = null;
      if (localObject1 == null) {
        break label434;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramb.a();
      }
      if (localObject2 != null)
      {
        localObject4 = ((URI)localObject2).getUserInfo();
        if (localObject4 != null)
        {
          localObject2 = paramc.k();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new cz.msebera.android.httpclient.i.b.i();
            paramc.a((cz.msebera.android.httpclient.b.i)localObject1);
          }
          ((cz.msebera.android.httpclient.b.i)localObject1).a(new h((r)localObject3), new s((String)localObject4));
        }
      }
      paramc.a("http.target_host", localObject3);
      paramc.a("http.route", paramb);
      paramc.a("http.request", paramo);
      this.c.process(paramo, paramc);
      paramb = this.b.a(paramb, paramo, paramc, paramg);
      try
      {
        paramc.a("http.response", paramb);
        this.c.process(paramb, paramc);
        return paramb;
      }
      catch (RuntimeException paramo)
      {
        paramb.close();
        throw paramo;
      }
      catch (IOException paramo)
      {
        paramb.close();
        throw paramo;
      }
      catch (p paramo)
      {
        label434:
        paramb.close();
        throw paramo;
      }
      localObject3 = ((u)localObject2).getRequestLine().c();
      try
      {
        localObject2 = URI.create((String)localObject3);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject2 = localObject1;
      }
      if (!this.a.a()) {
        break;
      }
      this.a.a("Unable to parse '" + (String)localObject3 + "' as a valid URI; " + "request URI and Host header may be inconsistent", localIllegalArgumentException);
      localObject2 = localObject1;
      break;
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((URI)localObject2).isAbsolute())
        {
          localObject1 = localObject3;
          if (((URI)localObject2).getHost() != null) {
            localObject1 = new r(((URI)localObject2).getHost(), ((URI)localObject2).getPort(), ((URI)localObject2).getScheme());
          }
        }
      }
    }
  }
  
  void a(o paramo, cz.msebera.android.httpclient.e.b.b paramb)
    throws aj
  {
    try
    {
      URI localURI = paramo.getURI();
      if (localURI != null)
      {
        if ((paramb.e() != null) && (!paramb.g())) {
          if (!localURI.isAbsolute()) {
            paramb = cz.msebera.android.httpclient.b.g.i.a(localURI, paramb.a(), true);
          }
        }
        for (;;)
        {
          paramo.a(paramb);
          return;
          paramb = cz.msebera.android.httpclient.b.g.i.a(localURI);
          continue;
          if (localURI.isAbsolute()) {
            paramb = cz.msebera.android.httpclient.b.g.i.a(localURI, null, true);
          } else {
            paramb = cz.msebera.android.httpclient.b.g.i.a(localURI);
          }
        }
      }
      return;
    }
    catch (URISyntaxException paramb)
    {
      throw new aj("Invalid URI: " + paramo.getRequestLine().c(), paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */