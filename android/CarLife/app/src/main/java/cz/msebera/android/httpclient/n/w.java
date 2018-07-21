package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import java.io.IOException;

@Immutable
public class w
  implements cz.msebera.android.httpclient.w
{
  private final boolean a;
  
  public w()
  {
    this(false);
  }
  
  public w(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if ((paramu instanceof o))
    {
      if (!this.a) {
        break label74;
      }
      paramu.removeHeaders("Transfer-Encoding");
      paramu.removeHeaders("Content-Length");
    }
    n localn;
    label74:
    do
    {
      paramg = paramu.getRequestLine().b();
      localn = ((o)paramu).getEntity();
      if (localn != null) {
        break;
      }
      paramu.addHeader("Content-Length", "0");
      return;
      if (paramu.containsHeader("Transfer-Encoding")) {
        throw new aj("Transfer-encoding header already present");
      }
    } while (!paramu.containsHeader("Content-Length"));
    throw new aj("Content-Length header already present");
    if ((localn.isChunked()) || (localn.getContentLength() < 0L))
    {
      if (paramg.d(ac.c)) {
        throw new aj("Chunked transfer encoding not allowed for " + paramg);
      }
      paramu.addHeader("Transfer-Encoding", "chunked");
    }
    for (;;)
    {
      if ((localn.getContentType() != null) && (!paramu.containsHeader("Content-Type"))) {
        paramu.addHeader(localn.getContentType());
      }
      if ((localn.getContentEncoding() == null) || (paramu.containsHeader("Content-Encoding"))) {
        break;
      }
      paramu.addHeader(localn.getContentEncoding());
      return;
      paramu.addHeader("Content-Length", Long.toString(localn.getContentLength()));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */