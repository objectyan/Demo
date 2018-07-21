package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.j.e;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.k.k;
import cz.msebera.android.httpclient.k.v;
import cz.msebera.android.httpclient.x;

@Immutable
public class p
  implements f<x>
{
  public static final p a = new p();
  private final v b;
  
  public p()
  {
    this(null);
  }
  
  public p(v paramv)
  {
    if (paramv != null) {}
    for (;;)
    {
      this.b = paramv;
      return;
      paramv = k.b;
    }
  }
  
  public e<x> a(i parami)
  {
    return new o(parami, this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */