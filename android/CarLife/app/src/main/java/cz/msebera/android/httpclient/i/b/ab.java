package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.f.c;
import cz.msebera.android.httpclient.b.t;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.k;
import cz.msebera.android.httpclient.n.g;
import java.security.Principal;
import javax.net.ssl.SSLSession;

@Immutable
public class ab
  implements t
{
  public static final ab a = new ab();
  
  private static Principal a(i parami)
  {
    d locald = parami.c();
    if ((locald != null) && (locald.d()) && (locald.c()))
    {
      parami = parami.d();
      if (parami != null) {
        return parami.a();
      }
    }
    return null;
  }
  
  public Object a(g paramg)
  {
    Object localObject2 = c.b(paramg);
    paramg = null;
    Object localObject1 = ((c)localObject2).m();
    if (localObject1 != null)
    {
      localObject1 = a((i)localObject1);
      paramg = (g)localObject1;
      if (localObject1 == null) {
        paramg = a(((c)localObject2).n());
      }
    }
    localObject1 = paramg;
    if (paramg == null)
    {
      localObject2 = ((c)localObject2).r();
      localObject1 = paramg;
      if (((k)localObject2).c())
      {
        localObject1 = paramg;
        if ((localObject2 instanceof u))
        {
          localObject2 = ((u)localObject2).n();
          localObject1 = paramg;
          if (localObject2 != null) {
            localObject1 = ((SSLSession)localObject2).getLocalPrincipal();
          }
        }
      }
    }
    return localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */