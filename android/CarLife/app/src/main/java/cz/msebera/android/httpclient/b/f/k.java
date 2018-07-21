package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.s;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import java.io.IOException;

@Deprecated
@Immutable
public class k
  extends g
{
  public void process(u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    a.a(paramg, "HTTP context");
    if (paramu.containsHeader("Proxy-Authorization")) {}
    do
    {
      return;
      localObject = (s)paramg.a("http.connection");
      if (localObject == null)
      {
        this.a.a("HTTP connection not set in the context");
        return;
      }
    } while (((s)localObject).m().g());
    Object localObject = (i)paramg.a("http.auth.proxy-scope");
    if (localObject == null)
    {
      this.a.a("Proxy auth state not set in the context");
      return;
    }
    if (this.a.a()) {
      this.a.a("Proxy auth state: " + ((i)localObject).b());
    }
    a((i)localObject, paramu, paramg);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */