package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@Immutable
public class i
  implements w
{
  private final Collection<? extends f> a;
  
  public i()
  {
    this(null);
  }
  
  public i(Collection<? extends f> paramCollection)
  {
    this.a = paramCollection;
  }
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if (paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) {}
    for (;;)
    {
      return;
      Collection localCollection = (Collection)paramu.getParams().a("http.default-headers");
      paramg = localCollection;
      if (localCollection == null) {
        paramg = this.a;
      }
      if (paramg != null)
      {
        paramg = paramg.iterator();
        while (paramg.hasNext()) {
          paramu.addHeader((f)paramg.next());
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */