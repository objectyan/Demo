package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.h;
import cz.msebera.android.httpclient.b.d.i;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.o;
import cz.msebera.android.httpclient.b.p;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.u;

@Deprecated
@Immutable
class x
  implements p
{
  private final o a;
  
  public x(o paramo)
  {
    this.a = paramo;
  }
  
  public o a()
  {
    return this.a;
  }
  
  public boolean a(u paramu, cz.msebera.android.httpclient.x paramx, g paramg)
    throws aj
  {
    return this.a.isRedirectRequested(paramx, paramg);
  }
  
  public q b(u paramu, cz.msebera.android.httpclient.x paramx, g paramg)
    throws aj
  {
    paramx = this.a.getLocationURI(paramx, paramg);
    if (paramu.getRequestLine().a().equalsIgnoreCase("HEAD")) {
      return new i(paramx);
    }
    return new h(paramx);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */