package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.f;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import java.nio.charset.Charset;

@Immutable
public class e
  implements cz.msebera.android.httpclient.a.e, f
{
  private final Charset a;
  
  public e()
  {
    this(null);
  }
  
  public e(Charset paramCharset)
  {
    this.a = paramCharset;
  }
  
  public cz.msebera.android.httpclient.a.d a(j paramj)
  {
    return new d();
  }
  
  public cz.msebera.android.httpclient.a.d a(g paramg)
  {
    return new d(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */