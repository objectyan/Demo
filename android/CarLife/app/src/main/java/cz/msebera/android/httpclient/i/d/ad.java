package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;

@Immutable
public class ad
  extends a
{
  public void a(b paramb, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    if (paramb.k() < 0) {
      throw new g("Cookie version may not be negative");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for version attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for version attribute");
    }
    try
    {
      paramn.a(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException paramn)
    {
      throw new l("Invalid version: " + paramn.getMessage());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */