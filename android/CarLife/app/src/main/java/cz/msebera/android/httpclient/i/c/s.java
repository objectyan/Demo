package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.e.y;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;

@Immutable
public class s
  implements x
{
  public static final s a = new s();
  
  public int a(r paramr)
    throws y
  {
    a.a(paramr, "HTTP host");
    int i = paramr.b();
    if (i > 0) {
      return i;
    }
    paramr = paramr.c();
    if (paramr.equalsIgnoreCase("http")) {
      return 80;
    }
    if (paramr.equalsIgnoreCase("https")) {
      return 443;
    }
    throw new y(paramr + " protocol is not supported");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */