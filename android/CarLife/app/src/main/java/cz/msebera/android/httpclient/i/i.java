package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.ao;
import cz.msebera.android.httpclient.b;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.q;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;

@Immutable
public class i
  implements b
{
  public static final i a = new i();
  
  private boolean a(x paramx)
  {
    int i = paramx.a().b();
    return (i >= 200) && (i != 204) && (i != 304) && (i != 205);
  }
  
  protected ao a(cz.msebera.android.httpclient.i parami)
  {
    return new q(parami);
  }
  
  public boolean a(x paramx, g paramg)
  {
    a.a(paramx, "HTTP response");
    a.a(paramg, "HTTP context");
    ak localak = paramx.a().a();
    paramg = paramx.getFirstHeader("Transfer-Encoding");
    int i;
    if (paramg != null)
    {
      if (!"chunked".equalsIgnoreCase(paramg.d())) {
        return false;
      }
    }
    else if (a(paramx))
    {
      paramg = paramx.getHeaders("Content-Length");
      if (paramg.length == 1)
      {
        paramg = paramg[0];
        try
        {
          i = Integer.parseInt(paramg.d());
          if (i >= 0) {
            break label104;
          }
          return false;
        }
        catch (NumberFormatException paramx)
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    label104:
    cz.msebera.android.httpclient.i locali = paramx.headerIterator("Connection");
    paramg = locali;
    if (!locali.hasNext()) {
      paramg = paramx.headerIterator("Proxy-Connection");
    }
    if (paramg.hasNext()) {
      try
      {
        paramx = a(paramg);
        i = 0;
        while (paramx.hasNext())
        {
          paramg = paramx.a();
          if ("Close".equalsIgnoreCase(paramg)) {
            return false;
          }
          boolean bool = "Keep-Alive".equalsIgnoreCase(paramg);
          if (bool) {
            i = 1;
          }
        }
        if (i != 0) {
          return true;
        }
      }
      catch (ai paramx)
      {
        return false;
      }
    }
    return !localak.d(ac.c);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */