package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.o.a;

@Immutable
public class f
  implements c
{
  public void a(b paramb, e parame)
    throws l
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    String str = parame.a();
    parame = paramb.g();
    if (parame == null) {
      throw new g("Cookie domain may not be null");
    }
    if (str.contains("."))
    {
      if (!str.endsWith(parame))
      {
        paramb = parame;
        if (parame.startsWith(".")) {
          paramb = parame.substring(1, parame.length());
        }
        if (!str.equals(paramb)) {
          throw new g("Illegal domain attribute \"" + paramb + "\". Domain of origin: \"" + str + "\"");
        }
      }
    }
    else if (!str.equals(parame)) {
      throw new g("Illegal domain attribute \"" + parame + "\". Domain of origin: \"" + str + "\"");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for domain attribute");
    }
    paramn.e(paramString);
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    String str = parame.a();
    parame = paramb.g();
    if (parame == null) {}
    do
    {
      return false;
      if (str.equals(parame)) {
        return true;
      }
      paramb = parame;
      if (!parame.startsWith(".")) {
        paramb = '.' + parame;
      }
    } while ((!str.endsWith(paramb)) && (!str.equals(paramb.substring(1))));
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */