package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import java.io.IOException;

@Deprecated
@Immutable
public class l
  extends g
{
  public void process(u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    a.a(paramg, "HTTP context");
    if (paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) {}
    while (paramu.containsHeader("Authorization")) {
      return;
    }
    i locali = (i)paramg.a("http.auth.target-scope");
    if (locali == null)
    {
      this.a.a("Target auth state not set in the context");
      return;
    }
    if (this.a.a()) {
      this.a.a("Target auth state: " + locali.b());
    }
    a(locali, paramu, paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */