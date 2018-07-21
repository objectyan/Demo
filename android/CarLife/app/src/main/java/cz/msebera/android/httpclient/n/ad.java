package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@ThreadSafe
public class ad
  implements z
{
  private static final i a = new i();
  
  public void process(x paramx, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    if ((paramx.a().b() >= 200) && (!paramx.containsHeader("Date"))) {
      paramx.setHeader("Date", a.a());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */