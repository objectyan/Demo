package cz.msebera.android.httpclient.i.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g.e;
import cz.msebera.android.httpclient.i.g.f;
import cz.msebera.android.httpclient.i.g.h;
import cz.msebera.android.httpclient.i.g.w;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import java.io.IOException;
import java.io.OutputStream;

@Deprecated
@Immutable
public class c
{
  private final e a;
  
  public c(e parame)
  {
    this.a = ((e)a.a(parame, "Content length strategy"));
  }
  
  protected OutputStream a(i parami, t paramt)
    throws p, IOException
  {
    long l = this.a.a(paramt);
    if (l == -2L) {
      return new f(parami);
    }
    if (l == -1L) {
      return new w(parami);
    }
    return new h(parami, l);
  }
  
  public void a(i parami, t paramt, n paramn)
    throws p, IOException
  {
    a.a(parami, "Session output buffer");
    a.a(paramt, "HTTP message");
    a.a(paramn, "HTTP entity");
    parami = a(parami, paramt);
    paramn.writeTo(parami);
    parami.close();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */