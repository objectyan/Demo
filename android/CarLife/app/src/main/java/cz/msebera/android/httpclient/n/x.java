package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@ThreadSafe
public class x
  implements w
{
  private static final i a = new i();
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if (((paramu instanceof o)) && (!paramu.containsHeader("Date"))) {
      paramu.setHeader("Date", a.a());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */