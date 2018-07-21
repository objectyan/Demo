package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.e;
import cz.msebera.android.httpclient.a.f;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import java.nio.charset.Charset;

@Immutable
public class c
  implements e, f
{
  private final Charset a;
  
  public c()
  {
    this(null);
  }
  
  public c(Charset paramCharset)
  {
    this.a = paramCharset;
  }
  
  public d a(j paramj)
  {
    return new b();
  }
  
  public d a(g paramg)
  {
    return new b(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */