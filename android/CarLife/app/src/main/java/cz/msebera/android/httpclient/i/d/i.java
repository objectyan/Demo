package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.k;

@Immutable
public class i
  implements c
{
  public void a(b paramb, e parame)
    throws l
  {
    if (!b(paramb, parame)) {
      throw new g("Illegal path attribute \"" + paramb.h() + "\". Path of origin: \"" + parame.b() + "\"");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    a.a(paramn, "Cookie");
    if (!k.b(paramString)) {}
    for (;;)
    {
      paramn.f(paramString);
      return;
      paramString = "/";
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    String str = parame.b();
    parame = paramb.h();
    paramb = parame;
    if (parame == null) {
      paramb = "/";
    }
    parame = paramb;
    if (paramb.length() > 1)
    {
      parame = paramb;
      if (paramb.endsWith("/")) {
        parame = paramb.substring(0, paramb.length() - 1);
      }
    }
    boolean bool2 = str.startsWith(parame);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (str.length() != parame.length())
      {
        bool1 = bool2;
        if (!parame.endsWith("/"))
        {
          if (str.charAt(parame.length()) != '/') {
            break label130;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
    label130:
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */