package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;

@Immutable
public class j
  extends a
{
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    paramn.a(true);
  }
  
  public boolean b(b paramb, e parame)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    return (!paramb.j()) || (parame.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */