package cz.msebera.android.httpclient.a.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.f;
import cz.msebera.android.httpclient.o.a;
import java.nio.charset.Charset;

@Deprecated
@Immutable
public final class c
{
  public static String a(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    String str = (String)paramj.a("http.auth.credential-charset");
    paramj = str;
    if (str == null) {
      paramj = f.u.name();
    }
    return paramj;
  }
  
  public static void a(j paramj, String paramString)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.auth.credential-charset", paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */