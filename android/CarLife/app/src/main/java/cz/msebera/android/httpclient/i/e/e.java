package cz.msebera.android.httpclient.i.e;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;

@Immutable
public class e
  implements cz.msebera.android.httpclient.g.e
{
  public static final e c = new e();
  private final int d;
  
  public e()
  {
    this(-1);
  }
  
  public e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public long a(t paramt)
    throws p
  {
    a.a(paramt, "HTTP message");
    Object localObject = paramt.getFirstHeader("Transfer-Encoding");
    long l1;
    if (localObject != null)
    {
      localObject = ((f)localObject).d();
      if ("chunked".equalsIgnoreCase((String)localObject))
      {
        if (paramt.getProtocolVersion().d(ac.c)) {
          throw new aj("Chunked transfer encoding not allowed for " + paramt.getProtocolVersion());
        }
        l1 = -2L;
      }
    }
    for (;;)
    {
      return l1;
      if ("identity".equalsIgnoreCase((String)localObject)) {
        return -1L;
      }
      throw new aj("Unsupported transfer encoding: " + (String)localObject);
      paramt = paramt.getFirstHeader("Content-Length");
      if (paramt != null)
      {
        paramt = paramt.d();
        try
        {
          long l2 = Long.parseLong(paramt);
          l1 = l2;
          if (l2 < 0L) {
            throw new aj("Negative content length: " + paramt);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new aj("Invalid content length: " + paramt);
        }
      }
    }
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */