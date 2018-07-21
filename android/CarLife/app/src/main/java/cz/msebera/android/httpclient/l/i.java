package cz.msebera.android.httpclient.l;

import cz.msebera.android.httpclient.d.a;
import cz.msebera.android.httpclient.d.a.a;
import cz.msebera.android.httpclient.d.c;
import cz.msebera.android.httpclient.d.c.a;
import cz.msebera.android.httpclient.d.f;
import cz.msebera.android.httpclient.d.f.a;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

@Deprecated
public final class i
{
  public static f a(j paramj)
  {
    return f.g().a(paramj.a("http.socket.timeout", 0)).a(paramj.a("http.socket.reuseaddr", false)).b(paramj.a("http.socket.keepalive", false)).b(paramj.a("http.socket.linger", -1)).c(paramj.a("http.tcp.nodelay", true)).a();
  }
  
  public static c b(j paramj)
  {
    return c.d().b(paramj.a("http.connection.max-header-count", -1)).a(paramj.a("http.connection.max-line-length", -1)).a();
  }
  
  public static a c(j paramj)
  {
    c localc = b(paramj);
    Object localObject = (String)paramj.a("http.protocol.element-charset");
    a.a locala = a.h();
    if (localObject != null) {}
    for (localObject = Charset.forName((String)localObject);; localObject = null) {
      return locala.a((Charset)localObject).a((CodingErrorAction)paramj.a("http.malformed.input.action")).a((CodingErrorAction)paramj.a("http.unmappable.input.action")).a(localc).a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */