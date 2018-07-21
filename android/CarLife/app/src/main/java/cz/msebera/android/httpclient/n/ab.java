package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;

@Immutable
public class ab
  implements z
{
  public void process(x paramx, g paramg)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    paramg = h.c(paramg);
    int i = paramx.a().b();
    if ((i == 400) || (i == 408) || (i == 411) || (i == 413) || (i == 414) || (i == 503) || (i == 501)) {
      paramx.setHeader("Connection", "Close");
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramx.getFirstHeader("Connection");
        } while ((localObject != null) && ("Close".equalsIgnoreCase(((f)localObject).d())));
        localObject = paramx.b();
        if (localObject != null)
        {
          ak localak = paramx.a().a();
          if ((((n)localObject).getContentLength() < 0L) && ((!((n)localObject).isChunked()) || (localak.d(ac.c))))
          {
            paramx.setHeader("Connection", "Close");
            return;
          }
        }
        paramg = paramg.s();
      } while (paramg == null);
      Object localObject = paramg.getFirstHeader("Connection");
      if (localObject != null)
      {
        paramx.setHeader("Connection", ((f)localObject).d());
        return;
      }
    } while (!paramg.getProtocolVersion().d(ac.c));
    paramx.setHeader("Connection", "Close");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */