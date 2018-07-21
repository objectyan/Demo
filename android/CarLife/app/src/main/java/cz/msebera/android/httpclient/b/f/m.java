package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.c.f;
import cz.msebera.android.httpclient.e.c.j;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@Deprecated
@Immutable
public class m
  implements z
{
  public b a = new b(getClass());
  
  private void a(cz.msebera.android.httpclient.b.a parama, r paramr, d paramd)
  {
    if (this.a.a()) {
      this.a.a("Caching '" + paramd.a() + "' auth scheme for " + paramr);
    }
    parama.a(paramr, paramd);
  }
  
  private boolean a(i parami)
  {
    parami = parami.c();
    if ((parami == null) || (!parami.d())) {}
    do
    {
      return false;
      parami = parami.a();
    } while ((!parami.equalsIgnoreCase("Basic")) && (!parami.equalsIgnoreCase("Digest")));
    return true;
  }
  
  private void b(cz.msebera.android.httpclient.b.a parama, r paramr, d paramd)
  {
    if (this.a.a()) {
      this.a.a("Removing from cache '" + paramd.a() + "' auth scheme for " + paramr);
    }
    parama.b(paramr);
  }
  
  public void process(x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramx, "HTTP request");
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    Object localObject1 = (cz.msebera.android.httpclient.b.a)paramg.a("http.auth.auth-cache");
    Object localObject3 = (r)paramg.a("http.target_host");
    i locali = (i)paramg.a("http.auth.target-scope");
    paramx = (x)localObject1;
    Object localObject2;
    if (localObject3 != null)
    {
      paramx = (x)localObject1;
      if (locali != null)
      {
        if (this.a.a()) {
          this.a.a("Target auth state: " + locali.b());
        }
        paramx = (x)localObject1;
        if (a(locali))
        {
          paramx = (j)paramg.a("http.scheme-registry");
          localObject2 = localObject3;
          if (((r)localObject3).b() < 0)
          {
            paramx = paramx.a((r)localObject3);
            localObject2 = new r(((r)localObject3).a(), paramx.a(((r)localObject3).b()), ((r)localObject3).c());
          }
          paramx = (x)localObject1;
          if (localObject1 == null)
          {
            paramx = new cz.msebera.android.httpclient.i.b.g();
            paramg.a("http.auth.auth-cache", paramx);
          }
          switch (m.1.a[locali.b().ordinal()])
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = (r)paramg.a("http.proxy_host");
      localObject3 = (i)paramg.a("http.auth.proxy-scope");
      if ((localObject2 != null) && (localObject3 != null))
      {
        if (this.a.a()) {
          this.a.a("Proxy auth state: " + ((i)localObject3).b());
        }
        if (a((i)localObject3))
        {
          localObject1 = paramx;
          if (paramx == null)
          {
            localObject1 = new cz.msebera.android.httpclient.i.b.g();
            paramg.a("http.auth.auth-cache", localObject1);
          }
        }
      }
      switch (m.1.a[localObject3.b().ordinal()])
      {
      default: 
        return;
        a(paramx, (r)localObject2, locali.c());
        continue;
        b(paramx, (r)localObject2, locali.c());
      }
    }
    a((cz.msebera.android.httpclient.b.a)localObject1, (r)localObject2, ((i)localObject3).c());
    return;
    b((cz.msebera.android.httpclient.b.a)localObject1, (r)localObject2, ((i)localObject3).c());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */