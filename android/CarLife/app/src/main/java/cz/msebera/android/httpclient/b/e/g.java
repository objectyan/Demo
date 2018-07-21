package cz.msebera.android.httpclient.b.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.h;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;

@Deprecated
@Immutable
public class g
{
  public static void a(j paramj, long paramLong)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.conn-manager.timeout", paramLong);
  }
  
  public static void a(j paramj, String paramString)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.protocol.cookie-policy", paramString);
  }
  
  public static void a(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.protocol.handle-redirects", paramBoolean);
  }
  
  public static boolean a(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.protocol.handle-redirects", true);
  }
  
  public static void b(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.protocol.handle-authentication", paramBoolean);
  }
  
  public static boolean b(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.protocol.handle-authentication", true);
  }
  
  public static String c(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    String str = (String)paramj.a("http.protocol.cookie-policy");
    paramj = str;
    if (str == null) {
      paramj = "best-match";
    }
    return paramj;
  }
  
  public static long d(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    Long localLong = (Long)paramj.a("http.conn-manager.timeout");
    if (localLong != null) {
      return localLong.longValue();
    }
    return h.f(paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */