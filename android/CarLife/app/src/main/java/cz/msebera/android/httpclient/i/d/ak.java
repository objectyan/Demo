package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.f.o;

@Immutable
public class ak
  implements c
{
  public void a(b paramb, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    if (((paramb instanceof o)) && ((paramb instanceof cz.msebera.android.httpclient.f.a)) && (!((cz.msebera.android.httpclient.f.a)paramb).b("version"))) {
      throw new g("Violates RFC 2965. Version attribute is required.");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for version attribute");
    }
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new l("Invalid cookie version.");
      }
    }
    catch (NumberFormatException paramString)
    {
      int i;
      for (;;)
      {
        i = -1;
      }
      paramn.a(i);
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */