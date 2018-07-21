package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;

@Immutable
public class p
  extends r
{
  private final cz.msebera.android.httpclient.r a;
  
  public p(cz.msebera.android.httpclient.r paramr)
  {
    this(paramr, null);
  }
  
  public p(cz.msebera.android.httpclient.r paramr, x paramx)
  {
    super(paramx);
    this.a = ((cz.msebera.android.httpclient.r)a.a(paramr, "Proxy host"));
  }
  
  protected cz.msebera.android.httpclient.r b(cz.msebera.android.httpclient.r paramr, u paramu, g paramg)
    throws cz.msebera.android.httpclient.p
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */