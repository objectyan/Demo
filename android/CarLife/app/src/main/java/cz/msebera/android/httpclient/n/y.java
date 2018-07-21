package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class y
  implements w
{
  private final boolean a;
  
  @Deprecated
  public y()
  {
    this(false);
  }
  
  public y(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if ((!paramu.containsHeader("Expect")) && ((paramu instanceof o)))
    {
      paramg = paramu.getRequestLine().b();
      n localn = ((o)paramu).getEntity();
      if ((localn != null) && (localn.getContentLength() != 0L) && (!paramg.d(ac.c)) && (paramu.getParams().a("http.protocol.expect-continue", this.a))) {
        paramu.addHeader("Expect", "100-continue");
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */