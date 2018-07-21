package cz.msebera.android.httpclient.e.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;

@Deprecated
@Immutable
public class j
  implements h
{
  public static final r d = new r("127.0.0.255", 0, "no-host");
  public static final b e = new b(d);
  
  public static r a(cz.msebera.android.httpclient.l.j paramj)
  {
    a.a(paramj, "Parameters");
    r localr = (r)paramj.a("http.route.default-proxy");
    paramj = localr;
    if (localr != null)
    {
      paramj = localr;
      if (d.equals(localr)) {
        paramj = null;
      }
    }
    return paramj;
  }
  
  public static void a(cz.msebera.android.httpclient.l.j paramj, b paramb)
  {
    a.a(paramj, "Parameters");
    paramj.a("http.route.forced-route", paramb);
  }
  
  public static void a(cz.msebera.android.httpclient.l.j paramj, r paramr)
  {
    a.a(paramj, "Parameters");
    paramj.a("http.route.default-proxy", paramr);
  }
  
  public static void a(cz.msebera.android.httpclient.l.j paramj, InetAddress paramInetAddress)
  {
    a.a(paramj, "Parameters");
    paramj.a("http.route.local-address", paramInetAddress);
  }
  
  public static b b(cz.msebera.android.httpclient.l.j paramj)
  {
    a.a(paramj, "Parameters");
    b localb = (b)paramj.a("http.route.forced-route");
    paramj = localb;
    if (localb != null)
    {
      paramj = localb;
      if (e.equals(localb)) {
        paramj = null;
      }
    }
    return paramj;
  }
  
  public static InetAddress c(cz.msebera.android.httpclient.l.j paramj)
  {
    a.a(paramj, "Parameters");
    return (InetAddress)paramj.a("http.route.local-address");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */