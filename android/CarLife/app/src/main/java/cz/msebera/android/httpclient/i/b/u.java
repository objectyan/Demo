package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;
import java.util.List;
import java.util.Map;

@Deprecated
@Immutable
public class u
  extends b
{
  public boolean a(x paramx, g paramg)
  {
    a.a(paramx, "HTTP response");
    return paramx.a().b() == 407;
  }
  
  public Map<String, f> b(x paramx, g paramg)
    throws p
  {
    a.a(paramx, "HTTP response");
    return a(paramx.getHeaders("Proxy-Authenticate"));
  }
  
  protected List<String> c(x paramx, g paramg)
  {
    List localList = (List)paramx.getParams().a("http.auth.proxy-scheme-pref");
    if (localList != null) {
      return localList;
    }
    return super.c(paramx, paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */