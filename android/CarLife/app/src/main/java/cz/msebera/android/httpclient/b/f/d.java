package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class d
  implements w
{
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    if (!paramu.containsHeader("Accept-Encoding")) {
      paramu.addHeader("Accept-Encoding", "gzip,deflate");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */