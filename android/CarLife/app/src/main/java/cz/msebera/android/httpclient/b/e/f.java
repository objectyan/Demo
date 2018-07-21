package cz.msebera.android.httpclient.b.e;

import cz.msebera.android.httpclient.b.b.c;
import cz.msebera.android.httpclient.b.b.c.a;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;
import java.util.Collection;

@Deprecated
public final class f
{
  public static c a(j paramj)
  {
    c.a locala = c.q().d(paramj.a("http.socket.timeout", 0)).b(paramj.a("http.connection.stalecheck", true)).c(paramj.a("http.connection.timeout", 0)).a(paramj.a("http.protocol.expect-continue", false)).a((r)paramj.a("http.route.default-proxy")).a((InetAddress)paramj.a("http.route.local-address")).b((Collection)paramj.a("http.auth.proxy-scheme-pref")).a((Collection)paramj.a("http.auth.target-scheme-pref")).f(paramj.a("http.protocol.handle-authentication", true)).e(paramj.a("http.protocol.allow-circular-redirects", false)).b((int)paramj.a("http.conn-manager.timeout", 0L)).a((String)paramj.a("http.protocol.cookie-policy")).a(paramj.a("http.protocol.max-redirects", 50)).c(paramj.a("http.protocol.handle-redirects", true));
    if (!paramj.a("http.protocol.reject-relative-redirect", false)) {}
    for (boolean bool = true;; bool = false) {
      return locala.d(bool).a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */