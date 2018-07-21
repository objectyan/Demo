package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.b.e;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class f
  implements w
{
  public b a = new b(getClass());
  
  private void a(r paramr, d paramd, cz.msebera.android.httpclient.a.i parami, cz.msebera.android.httpclient.b.i parami1)
  {
    String str = paramd.a();
    if (this.a.a()) {
      this.a.a("Re-using cached '" + str + "' auth scheme for " + paramr);
    }
    paramr = parami1.a(new h(paramr, h.c, str));
    if (paramr != null)
    {
      if ("BASIC".equalsIgnoreCase(paramd.a())) {
        parami.a(cz.msebera.android.httpclient.a.c.b);
      }
      for (;;)
      {
        parami.a(paramd, paramr);
        return;
        parami.a(cz.msebera.android.httpclient.a.c.e);
      }
    }
    this.a.a("No credentials for preemptive authentication");
  }
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    c localc = c.b(paramg);
    Object localObject = localc.l();
    if (localObject == null) {
      this.a.a("Auth cache not set in the context");
    }
    cz.msebera.android.httpclient.b.i locali;
    do
    {
      do
      {
        return;
        locali = localc.k();
        if (locali == null)
        {
          this.a.a("Credentials provider not set in the context");
          return;
        }
        e locale = localc.d();
        if (locale == null)
        {
          this.a.a("Route info not set in the context");
          return;
        }
        paramg = localc.v();
        if (paramg == null)
        {
          this.a.a("Target host not set in the context");
          return;
        }
        paramu = paramg;
        if (paramg.b() < 0) {
          paramu = new r(paramg.a(), locale.a().b(), paramg.c());
        }
        paramg = localc.m();
        if ((paramg != null) && (paramg.b() == cz.msebera.android.httpclient.a.c.a))
        {
          d locald = ((cz.msebera.android.httpclient.b.a)localObject).a(paramu);
          if (locald != null) {
            a(paramu, locald, paramg, locali);
          }
        }
        paramu = locale.e();
        paramg = localc.n();
      } while ((paramu == null) || (paramg == null) || (paramg.b() != cz.msebera.android.httpclient.a.c.a));
      localObject = ((cz.msebera.android.httpclient.b.a)localObject).a(paramu);
    } while (localObject == null);
    a(paramu, (d)localObject, paramg, locali);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */