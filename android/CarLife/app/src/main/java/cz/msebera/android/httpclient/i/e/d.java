package cz.msebera.android.httpclient.i.e;

import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.g.e;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;

@Immutable
public class d
  implements e
{
  public static final d c = new d();
  private final int d;
  
  public d()
  {
    this(-1);
  }
  
  public d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public long a(t paramt)
    throws p
  {
    a.a(paramt, "HTTP message");
    f localf = paramt.getFirstHeader("Transfer-Encoding");
    int i;
    long l2;
    if (localf != null)
    {
      try
      {
        paramt = localf.e();
        i = paramt.length;
        if ("identity".equalsIgnoreCase(localf.d()))
        {
          l2 = -1L;
          return l2;
        }
      }
      catch (ai paramt)
      {
        throw new aj("Invalid Transfer-Encoding header value: " + localf, paramt);
      }
      if ((i > 0) && ("chunked".equalsIgnoreCase(paramt[(i - 1)].a()))) {
        return -2L;
      }
      return -1L;
    }
    if (paramt.getFirstHeader("Content-Length") != null)
    {
      l2 = -1L;
      paramt = paramt.getHeaders("Content-Length");
      i = paramt.length - 1;
      for (;;)
      {
        long l1 = l2;
        if (i >= 0) {
          localf = paramt[i];
        }
        try
        {
          l1 = Long.parseLong(localf.d());
          l2 = l1;
          if (l1 >= 0L) {
            break;
          }
          return -1L;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i -= 1;
        }
      }
    }
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */