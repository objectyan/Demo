package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d;
import cz.msebera.android.httpclient.b.d.o;
import cz.msebera.android.httpclient.p;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

@Immutable
public class a
  implements b
{
  private final b a;
  private final cz.msebera.android.httpclient.b.g b;
  private final d c;
  
  public a(b paramb, cz.msebera.android.httpclient.b.g paramg, d paramd)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP client request executor");
    cz.msebera.android.httpclient.o.a.a(paramg, "Connection backoff strategy");
    cz.msebera.android.httpclient.o.a.a(paramd, "Backoff manager");
    this.a = paramb;
    this.b = paramg;
    this.c = paramd;
  }
  
  public cz.msebera.android.httpclient.b.d.c a(cz.msebera.android.httpclient.e.b.b paramb, o paramo, cz.msebera.android.httpclient.b.f.c paramc, cz.msebera.android.httpclient.b.d.g paramg)
    throws IOException, p
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "HTTP route");
    cz.msebera.android.httpclient.o.a.a(paramo, "HTTP request");
    cz.msebera.android.httpclient.o.a.a(paramc, "HTTP context");
    try
    {
      paramo = this.a.a(paramb, paramo, paramc, paramg);
      if (this.b.a(paramo))
      {
        this.c.a(paramb);
        return paramo;
      }
    }
    catch (Exception paramo)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      if (this.b.a(paramo)) {
        this.c.a(paramb);
      }
      if ((paramo instanceof RuntimeException)) {
        throw ((RuntimeException)paramo);
      }
      if ((paramo instanceof p)) {
        throw ((p)paramo);
      }
      if ((paramo instanceof IOException)) {
        throw ((IOException)paramo);
      }
      throw new UndeclaredThrowableException(paramo);
    }
    this.c.b(paramb);
    return paramo;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */