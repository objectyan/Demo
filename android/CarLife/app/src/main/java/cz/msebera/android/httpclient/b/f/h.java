package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.b.e;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class h
  implements w
{
  private static final String b = "Proxy-Connection";
  public b a = new b(getClass());
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if (paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) {
      paramu.setHeader("Proxy-Connection", "Keep-Alive");
    }
    do
    {
      return;
      paramg = c.b(paramg).d();
      if (paramg == null)
      {
        this.a.a("Connection route not set in the context");
        return;
      }
      if (((paramg.d() == 1) || (paramg.g())) && (!paramu.containsHeader("Connection"))) {
        paramu.addHeader("Connection", "Keep-Alive");
      }
    } while ((paramg.d() != 2) || (paramg.g()) || (paramu.containsHeader("Proxy-Connection")));
    paramu.addHeader("Proxy-Connection", "Keep-Alive");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */