package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.af;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.k.h;
import cz.msebera.android.httpclient.k.i;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.v;

@Immutable
public class k
  implements v
{
  public static final k a = new k();
  private static final String[] b = { "GET" };
  private static final String[] c = { "POST", "PUT" };
  private static final String[] d = { "HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT" };
  
  private static boolean a(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public u a(am paramam)
    throws af
  {
    a.a(paramam, "Request line");
    String str = paramam.a();
    if (a(b, str)) {
      return new i(paramam);
    }
    if (a(c, str)) {
      return new h(paramam);
    }
    if (a(d, str)) {
      return new i(paramam);
    }
    throw new af(str + " method not supported");
  }
  
  public u a(String paramString1, String paramString2)
    throws af
  {
    if (a(b, paramString1)) {
      return new i(paramString1, paramString2);
    }
    if (a(c, paramString1)) {
      return new h(paramString1, paramString2);
    }
    if (a(d, paramString1)) {
      return new i(paramString1, paramString2);
    }
    throw new af(paramString1 + " method not supported");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */