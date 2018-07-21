package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.o.a;
import java.util.Locale;

@Immutable
public class aa
  implements c
{
  public void a(b paramb, e parame)
    throws l
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    parame = parame.a();
    paramb = paramb.g();
    if (paramb == null) {
      throw new g("Cookie domain may not be null");
    }
    if (!paramb.equals(parame))
    {
      if (paramb.indexOf('.') == -1) {
        throw new g("Domain attribute \"" + paramb + "\" does not match the host \"" + parame + "\"");
      }
      if (!paramb.startsWith(".")) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = paramb.indexOf('.', 1);
      if ((i < 0) || (i == paramb.length() - 1)) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: domain must contain an embedded dot");
      }
      parame = parame.toLowerCase(Locale.ENGLISH);
      if (!parame.endsWith(paramb)) {
        throw new g("Illegal domain attribute \"" + paramb + "\". Domain of origin: \"" + parame + "\"");
      }
      if (parame.substring(0, parame.length() - paramb.length()).indexOf('.') != -1) {
        throw new g("Domain attribute \"" + paramb + "\" violates RFC 2109: host minus domain may not contain any dots");
      }
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
    parame = parame.a();
    paramb = paramb.g();
    if (paramb == null) {}
    while ((!parame.equals(paramb)) && ((!paramb.startsWith(".")) || (!parame.endsWith(paramb)))) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */