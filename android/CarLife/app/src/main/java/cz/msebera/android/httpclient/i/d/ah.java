package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.g;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.f.o;
import java.util.StringTokenizer;

@Immutable
public class ah
  implements c
{
  private static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == paramArrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static int[] a(String paramString)
    throws l
  {
    paramString = new StringTokenizer(paramString, ",");
    int[] arrayOfInt = new int[paramString.countTokens()];
    int i = 0;
    for (;;)
    {
      try
      {
        if (!paramString.hasMoreTokens()) {
          break;
        }
        arrayOfInt[i] = Integer.parseInt(paramString.nextToken().trim());
        if (arrayOfInt[i] < 0) {
          throw new l("Invalid Port attribute.");
        }
      }
      catch (NumberFormatException paramString)
      {
        throw new l("Invalid Port attribute: " + paramString.getMessage());
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void a(b paramb, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    int i = parame.c();
    if (((paramb instanceof cz.msebera.android.httpclient.f.a)) && (((cz.msebera.android.httpclient.f.a)paramb).b("port")) && (!a(i, paramb.i()))) {
      throw new g("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
    }
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Cookie");
    if ((paramn instanceof o))
    {
      paramn = (o)paramn;
      if ((paramString != null) && (paramString.trim().length() > 0)) {
        paramn.a(a(paramString));
      }
    }
  }
  
  public boolean b(b paramb, e parame)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    int i = parame.c();
    if (((paramb instanceof cz.msebera.android.httpclient.f.a)) && (((cz.msebera.android.httpclient.f.a)paramb).b("port")))
    {
      if (paramb.i() == null) {
        return false;
      }
      if (!a(i, paramb.i())) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */