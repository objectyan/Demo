package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.b.d;
import cz.msebera.android.httpclient.e.c.f;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;

@Deprecated
@ThreadSafe
public class n
  implements d
{
  protected final cz.msebera.android.httpclient.e.c.j a;
  
  public n(cz.msebera.android.httpclient.e.c.j paramj)
  {
    a.a(paramj, "Scheme registry");
    this.a = paramj;
  }
  
  public cz.msebera.android.httpclient.e.b.b a(r paramr, u paramu, g paramg)
    throws p
  {
    a.a(paramu, "HTTP request");
    paramg = cz.msebera.android.httpclient.e.a.j.b(paramu.getParams());
    if (paramg != null) {
      return paramg;
    }
    cz.msebera.android.httpclient.o.b.a(paramr, "Target host");
    paramg = cz.msebera.android.httpclient.e.a.j.c(paramu.getParams());
    paramu = cz.msebera.android.httpclient.e.a.j.a(paramu.getParams());
    for (;;)
    {
      boolean bool;
      try
      {
        f localf = this.a.a(paramr.c());
        bool = localf.e();
        if (paramu == null)
        {
          paramr = new cz.msebera.android.httpclient.e.b.b(paramr, paramg, bool);
          return paramr;
        }
      }
      catch (IllegalStateException paramr)
      {
        throw new p(paramr.getMessage());
      }
      paramr = new cz.msebera.android.httpclient.e.b.b(paramr, paramg, paramu, bool);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */