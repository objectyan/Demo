package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.f.j;
import cz.msebera.android.httpclient.f.o;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.k;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Immutable
public class e
  implements w
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    a.a(paramg, "HTTP context");
    if (paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) {
      return;
    }
    Object localObject5 = c.b(paramg);
    Object localObject4 = ((c)localObject5).f();
    if (localObject4 == null)
    {
      this.a.a("Cookie store not specified in HTTP context");
      return;
    }
    Object localObject6 = ((c)localObject5).i();
    if (localObject6 == null)
    {
      this.a.a("CookieSpec registry not specified in HTTP context");
      return;
    }
    r localr = ((c)localObject5).v();
    if (localr == null)
    {
      this.a.a("Target host not set in the context");
      return;
    }
    cz.msebera.android.httpclient.e.b.e locale = ((c)localObject5).d();
    if (locale == null)
    {
      this.a.a("Connection route not set in the context");
      return;
    }
    Object localObject1 = ((c)localObject5).p().e();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "best-match";
    }
    if (this.a.a()) {
      this.a.a("CookieSpec selected: " + (String)localObject2);
    }
    localObject1 = null;
    if ((paramu instanceof q)) {
      localObject1 = ((q)paramu).getURI();
    }
    for (;;)
    {
      label221:
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((URI)localObject1).getPath();
        localObject3 = localr.a();
        j = localr.b();
        i = j;
        if (j < 0) {
          i = locale.a().b();
        }
        if (i < 0) {
          break label367;
        }
        label258:
        if (k.a((CharSequence)localObject1)) {
          break label372;
        }
      }
      for (;;)
      {
        localObject1 = new cz.msebera.android.httpclient.f.e((String)localObject3, i, (String)localObject1, locale.j());
        localObject3 = (j)((cz.msebera.android.httpclient.d.b)localObject6).c((String)localObject2);
        if (localObject3 != null) {
          break label379;
        }
        throw new p("Unsupported cookie policy: " + (String)localObject2);
        label367:
        label372:
        try
        {
          localObject3 = new URI(paramu.getRequestLine().c());
          localObject1 = localObject3;
        }
        catch (URISyntaxException localURISyntaxException) {}
        localObject1 = null;
        break label221;
        i = 0;
        break label258;
        localObject1 = "/";
      }
      label379:
      localObject2 = ((j)localObject3).a((g)localObject5);
      localObject5 = new ArrayList(((cz.msebera.android.httpclient.b.h)localObject4).getCookies());
      Object localObject3 = new ArrayList();
      localObject4 = new Date();
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (cz.msebera.android.httpclient.f.b)((Iterator)localObject5).next();
        if (!((cz.msebera.android.httpclient.f.b)localObject6).a((Date)localObject4))
        {
          if (((cz.msebera.android.httpclient.f.h)localObject2).b((cz.msebera.android.httpclient.f.b)localObject6, (cz.msebera.android.httpclient.f.e)localObject1))
          {
            if (this.a.a()) {
              this.a.a("Cookie " + localObject6 + " match " + localObject1);
            }
            ((List)localObject3).add(localObject6);
          }
        }
        else if (this.a.a()) {
          this.a.a("Cookie " + localObject6 + " expired");
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        localObject4 = ((cz.msebera.android.httpclient.f.h)localObject2).a((List)localObject3).iterator();
        while (((Iterator)localObject4).hasNext()) {
          paramu.addHeader((f)((Iterator)localObject4).next());
        }
      }
      int j = ((cz.msebera.android.httpclient.f.h)localObject2).a();
      if (j > 0)
      {
        i = 0;
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (cz.msebera.android.httpclient.f.b)((Iterator)localObject3).next();
          if ((j != ((cz.msebera.android.httpclient.f.b)localObject4).k()) || (!(localObject4 instanceof o))) {
            i = 1;
          }
        }
        if (i != 0)
        {
          localObject3 = ((cz.msebera.android.httpclient.f.h)localObject2).b();
          if (localObject3 != null) {
            paramu.addHeader((f)localObject3);
          }
        }
      }
      paramg.a("http.cookie-spec", localObject2);
      paramg.a("http.cookie-origin", localObject1);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */