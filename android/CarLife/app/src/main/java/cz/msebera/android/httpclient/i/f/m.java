package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.g;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.b.s;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import java.io.IOException;
import java.io.InterruptedIOException;

@Immutable
public class m
  implements b
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final b b;
  private final s c;
  
  public m(b paramb, s params)
  {
    a.a(paramb, "HTTP request executor");
    a.a(params, "Retry strategy");
    this.b = paramb;
    this.c = params;
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, o paramo, cz.msebera.android.httpclient.b.f.c paramc, g paramg)
    throws IOException, p
  {
    f[] arrayOff = paramo.getAllHeaders();
    int i = 1;
    for (;;)
    {
      localc = this.b.a(paramb, paramo, paramc, paramg);
      try
      {
        if (this.c.a(localc, i, paramc))
        {
          localc.close();
          long l = this.c.a();
          if (l > 0L) {}
          try
          {
            this.a.e("Wait for " + l);
            Thread.sleep(l);
            paramo.setHeaders(arrayOff);
            i += 1;
          }
          catch (InterruptedException paramb)
          {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
          }
        }
        return localc;
      }
      catch (RuntimeException paramb)
      {
        localc.close();
        throw paramb;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */