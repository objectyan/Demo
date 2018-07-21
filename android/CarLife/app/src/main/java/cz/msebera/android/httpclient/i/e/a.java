package cz.msebera.android.httpclient.i.e;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.g.e;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;

@Immutable
public class a
  implements e
{
  public static final a c = new a(new d(0));
  private final e d;
  
  public a(e parame)
  {
    this.d = parame;
  }
  
  public long a(t paramt)
    throws p
  {
    long l = this.d.a(paramt);
    if (l == -1L) {
      throw new aj("Identity transfer encoding cannot be used");
    }
    return l;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */