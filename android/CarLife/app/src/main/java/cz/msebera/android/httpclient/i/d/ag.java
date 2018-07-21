package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import java.util.Locale;

@Immutable
public class ag
  implements c
{
  public void a(b paramb, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    parame = parame.a().toLowerCase(Locale.ENGLISH);
    if (paramb.g() == null) {
      throw new g("Invalid cookie state: domain not specified");
    }
    String str = paramb.g().toLowerCase(Locale.ENGLISH);
    if (((paramb instanceof cz.msebera.android.httpclient.f.a)) && (((cz.msebera.android.httpclient.f.a)paramb).b("domain")))
    {
      if (!str.startsWith(".")) {
        throw new g("Domain attribute \"" + paramb.g() + "\" violates RFC 2109: domain must start with a dot");
      }
      int i = str.indexOf('.', 1);
      if (((i < 0) || (i == str.length() - 1)) && (!str.equals(".local"))) {
        throw new g("Domain attribute \"" + paramb.g() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
      }
      if (!a(parame, str)) {
        throw new g("Domain attribute \"" + paramb.g() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
      }
      if (parame.substring(0, parame.length() - str.length()).indexOf('.') != -1) {
        throw new g("Domain attribute \"" + paramb.g() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
      }
    }
    else if (!paramb.g().equals(parame))
    {
      throw new g("Illegal domain attribute: \"" + paramb.g() + "\"." + "Domain of origin: \"" + parame + "\"");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if (paramString == null) {
      throw new l("Missing value for domain attribute");
    }
    if (paramString.trim().length() == 0) {
      throw new l("Blank value for domain attribute");
    }
    String str2 = paramString.toLowerCase(Locale.ENGLISH);
    String str1 = str2;
    if (!paramString.startsWith(".")) {
      str1 = '.' + str2;
    }
    paramn.e(str1);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || ((paramString2.startsWith(".")) && (paramString1.endsWith(paramString2)));
  }
  
  public boolean b(b paramb, e parame)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    parame = parame.a().toLowerCase(Locale.ENGLISH);
    paramb = paramb.g();
    if (!a(parame, paramb)) {}
    while (parame.substring(0, parame.length() - paramb.length()).indexOf('.') != -1) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */