package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import java.util.Date;

@Immutable
public class h
  extends a
{
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for max-age attribute");
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        throw new l("Negative max-age attribute: " + paramString);
      }
    }
    catch (NumberFormatException paramn)
    {
      throw new l("Invalid max-age attribute: " + paramString);
    }
    paramn.b(new Date(System.currentTimeMillis() + i * 1000L));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */