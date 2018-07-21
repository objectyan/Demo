package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.g;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.b.k;
import cz.msebera.android.httpclient.b.m;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import java.io.IOException;

@Immutable
public class l
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final b b;
  private final k c;
  
  public l(b paramb, k paramk)
  {
    a.a(paramb, "HTTP request executor");
    a.a(paramk, "HTTP request retry handler");
    this.b = paramb;
    this.c = paramk;
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, o paramo, cz.msebera.android.httpclient.b.f.c paramc, g paramg)
    throws IOException, p
  {
    a.a(paramb, "HTTP route");
    a.a(paramo, "HTTP request");
    a.a(paramc, "HTTP context");
    f[] arrayOff = paramo.getAllHeaders();
    int i = 1;
    try
    {
      cz.msebera.android.httpclient.b.d.c localc = this.b.a(paramb, paramo, paramc, paramg);
      return localc;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if ((paramg != null) && (paramg.isAborted()))
        {
          this.a.a("Request has been aborted");
          throw localIOException;
        }
        if (!this.c.retryRequest(localIOException, i, paramc)) {
          break;
        }
        if (this.a.d()) {
          this.a.d("I/O exception (" + localIOException.getClass().getName() + ") caught when processing request to " + paramb + ": " + localIOException.getMessage());
        }
        if (this.a.a()) {
          this.a.a(localIOException.getMessage(), localIOException);
        }
        if (!j.a(paramo))
        {
          this.a.a("Cannot retry non-repeatable request");
          throw new m("Cannot retry request with a non-repeatable request entity", localIOException);
        }
        paramo.setHeaders(arrayOff);
        if (this.a.d()) {
          this.a.d("Retrying request to " + paramb);
        }
        i += 1;
      }
      if ((localIOException instanceof ah))
      {
        paramb = new ah(paramb.a().f() + " failed to respond");
        paramb.setStackTrace(localIOException.getStackTrace());
        throw paramb;
      }
      throw localIOException;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */