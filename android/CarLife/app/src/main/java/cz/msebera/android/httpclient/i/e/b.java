package cz.msebera.android.httpclient.i.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.i.g.g;
import cz.msebera.android.httpclient.i.g.v;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import java.io.IOException;

@Deprecated
@Immutable
public class b
{
  private final cz.msebera.android.httpclient.g.e a;
  
  public b(cz.msebera.android.httpclient.g.e parame)
  {
    this.a = ((cz.msebera.android.httpclient.g.e)a.a(parame, "Content length strategy"));
  }
  
  protected cz.msebera.android.httpclient.g.b a(h paramh, t paramt)
    throws p, IOException
  {
    cz.msebera.android.httpclient.g.b localb = new cz.msebera.android.httpclient.g.b();
    long l = this.a.a(paramt);
    if (l == -2L)
    {
      localb.a(true);
      localb.a(-1L);
      localb.a(new cz.msebera.android.httpclient.i.g.e(paramh));
    }
    for (;;)
    {
      paramh = paramt.getFirstHeader("Content-Type");
      if (paramh != null) {
        localb.a(paramh);
      }
      paramh = paramt.getFirstHeader("Content-Encoding");
      if (paramh != null) {
        localb.b(paramh);
      }
      return localb;
      if (l == -1L)
      {
        localb.a(false);
        localb.a(-1L);
        localb.a(new v(paramh));
      }
      else
      {
        localb.a(false);
        localb.a(l);
        localb.a(new g(paramh, l));
      }
    }
  }
  
  public n b(h paramh, t paramt)
    throws p, IOException
  {
    a.a(paramh, "Session input buffer");
    a.a(paramt, "HTTP message");
    return a(paramh, paramt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */