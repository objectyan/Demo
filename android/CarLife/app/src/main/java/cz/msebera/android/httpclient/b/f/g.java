package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.m;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.util.Queue;

@Deprecated
abstract class g
  implements w
{
  final cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  
  private f a(d paramd, n paramn, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws j
  {
    cz.msebera.android.httpclient.o.b.a(paramd, "Auth scheme");
    if ((paramd instanceof m)) {
      return ((m)paramd).a(paramn, paramu, paramg);
    }
    return paramd.a(paramn, paramu);
  }
  
  private void a(d paramd)
  {
    cz.msebera.android.httpclient.o.b.a(paramd, "Auth scheme");
  }
  
  void a(i parami, u paramu, cz.msebera.android.httpclient.n.g paramg)
  {
    d locald = parami.c();
    Object localObject = parami.d();
    switch (g.1.a[parami.b().ordinal()])
    {
    }
    for (;;)
    {
      if (locald != null) {}
      try
      {
        paramu.addHeader(a(locald, (n)localObject, paramu, paramg));
        for (;;)
        {
          return;
          a(locald);
          if (!locald.c()) {
            break;
          }
          return;
          Queue localQueue = parami.e();
          if (localQueue == null) {
            break label256;
          }
          while (!localQueue.isEmpty())
          {
            localObject = (cz.msebera.android.httpclient.a.b)localQueue.remove();
            locald = ((cz.msebera.android.httpclient.a.b)localObject).a();
            localObject = ((cz.msebera.android.httpclient.a.b)localObject).b();
            parami.a(locald, (n)localObject);
            if (this.a.a()) {
              this.a.a("Generating response to an authentication challenge using " + locald.a() + " scheme");
            }
            try
            {
              paramu.addHeader(a(locald, (n)localObject, paramu, paramg));
              return;
            }
            catch (j localj) {}
            if (this.a.c()) {
              this.a.c(locald + " authentication error: " + localj.getMessage());
            }
          }
        }
        label256:
        a(locald);
      }
      catch (j parami)
      {
        while (!this.a.b()) {}
        this.a.b(locald + " authentication error: " + parami.getMessage());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */