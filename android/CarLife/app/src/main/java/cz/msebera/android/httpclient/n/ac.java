package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@Immutable
public class ac
  implements z
{
  private final boolean a;
  
  public ac()
  {
    this(false);
  }
  
  public ac(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void process(x paramx, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    n localn;
    long l;
    if (this.a)
    {
      paramx.removeHeaders("Transfer-Encoding");
      paramx.removeHeaders("Content-Length");
      paramg = paramx.a().a();
      localn = paramx.b();
      if (localn == null) {
        break label233;
      }
      l = localn.getContentLength();
      if ((!localn.isChunked()) || (paramg.d(cz.msebera.android.httpclient.ac.c))) {
        break label205;
      }
      paramx.addHeader("Transfer-Encoding", "chunked");
      label94:
      if ((localn.getContentType() != null) && (!paramx.containsHeader("Content-Type"))) {
        paramx.addHeader(localn.getContentType());
      }
      if ((localn.getContentEncoding() != null) && (!paramx.containsHeader("Content-Encoding"))) {
        paramx.addHeader(localn.getContentEncoding());
      }
    }
    label205:
    label233:
    int i;
    do
    {
      return;
      if (paramx.containsHeader("Transfer-Encoding")) {
        throw new aj("Transfer-encoding header already present");
      }
      if (!paramx.containsHeader("Content-Length")) {
        break;
      }
      throw new aj("Content-Length header already present");
      if (l < 0L) {
        break label94;
      }
      paramx.addHeader("Content-Length", Long.toString(localn.getContentLength()));
      break label94;
      i = paramx.a().b();
    } while ((i == 204) || (i == 304) || (i == 205));
    paramx.addHeader("Content-Length", "0");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */