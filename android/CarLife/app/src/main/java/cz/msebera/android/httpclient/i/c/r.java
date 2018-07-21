package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.e.b.d;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.e.y;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import java.net.InetAddress;

@Immutable
public class r
  implements d
{
  private final x a;
  
  public r(x paramx)
  {
    if (paramx != null) {}
    for (;;)
    {
      this.a = paramx;
      return;
      paramx = s.a;
    }
  }
  
  public b a(cz.msebera.android.httpclient.r paramr, u paramu, g paramg)
    throws p
  {
    a.a(paramu, "Request");
    if (paramr == null) {
      throw new aj("Target host is not specified");
    }
    Object localObject = cz.msebera.android.httpclient.b.f.c.b(paramg).p();
    InetAddress localInetAddress = ((cz.msebera.android.httpclient.b.b.c)localObject).c();
    cz.msebera.android.httpclient.r localr = ((cz.msebera.android.httpclient.b.b.c)localObject).b();
    localObject = localr;
    if (localr == null) {
      localObject = b(paramr, paramu, paramg);
    }
    if (paramr.b() <= 0) {}
    boolean bool;
    for (;;)
    {
      try
      {
        paramr = new cz.msebera.android.httpclient.r(paramr.a(), this.a.a(paramr), paramr.c());
        bool = paramr.c().equalsIgnoreCase("https");
        if (localObject != null) {
          break;
        }
        return new b(paramr, localInetAddress, bool);
      }
      catch (y paramr)
      {
        throw new p(paramr.getMessage());
      }
    }
    return new b(paramr, localInetAddress, (cz.msebera.android.httpclient.r)localObject, bool);
  }
  
  protected cz.msebera.android.httpclient.r b(cz.msebera.android.httpclient.r paramr, u paramu, g paramg)
    throws p
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */