package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.s;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;
import java.net.InetAddress;

@Immutable
public class z
  implements w
{
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    paramg = h.c(paramg);
    ak localak = paramu.getRequestLine().b();
    if ((paramu.getRequestLine().a().equalsIgnoreCase("CONNECT")) && (localak.d(ac.c))) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while (paramu.containsHeader("Host"));
      r localr = paramg.v();
      localObject = localr;
      if (localr != null) {
        break;
      }
      localObject = paramg.r();
      paramg = localr;
      if ((localObject instanceof s))
      {
        InetAddress localInetAddress = ((s)localObject).j();
        int i = ((s)localObject).k();
        paramg = localr;
        if (localInetAddress != null) {
          paramg = new r(localInetAddress.getHostName(), i);
        }
      }
      localObject = paramg;
      if (paramg != null) {
        break;
      }
    } while (localak.d(ac.c));
    throw new aj("Target host missing");
    paramu.addHeader("Host", ((r)localObject).f());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */