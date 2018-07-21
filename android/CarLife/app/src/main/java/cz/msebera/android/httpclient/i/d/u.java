package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.o.a;
import java.util.Locale;
import java.util.StringTokenizer;

@Immutable
public class u
  extends f
{
  private static boolean a(String paramString)
  {
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    return (paramString.endsWith(".COM")) || (paramString.endsWith(".EDU")) || (paramString.endsWith(".NET")) || (paramString.endsWith(".GOV")) || (paramString.endsWith(".MIL")) || (paramString.endsWith(".ORG")) || (paramString.endsWith(".INT"));
  }
  
  public void a(b paramb, e parame)
    throws l
  {
    super.a(paramb, parame);
    parame = parame.a();
    paramb = paramb.g();
    if (parame.contains("."))
    {
      int i = new StringTokenizer(paramb, ".").countTokens();
      if (a(paramb))
      {
        if (i < 2) {
          throw new g("Domain attribute \"" + paramb + "\" violates the Netscape cookie specification for " + "special domains");
        }
      }
      else if (i < 3) {
        throw new g("Domain attribute \"" + paramb + "\" violates the Netscape cookie specification");
      }
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    parame = parame.a();
    paramb = paramb.g();
    if (paramb == null) {
      return false;
    }
    return parame.endsWith(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */