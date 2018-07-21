package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class v
  implements w
{
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if (paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) {}
    while (paramu.containsHeader("Connection")) {
      return;
    }
    paramu.addHeader("Connection", "Keep-Alive");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */