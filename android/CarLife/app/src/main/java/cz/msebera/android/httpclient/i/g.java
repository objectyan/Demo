package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.aa;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

@NotThreadSafe
public class g
  extends c
  implements aa
{
  private final cz.msebera.android.httpclient.j.c<u> a;
  private final cz.msebera.android.httpclient.j.e<x> b;
  
  public g(int paramInt)
  {
    this(paramInt, paramInt, null, null, null, null, null, null, null);
  }
  
  public g(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, cz.msebera.android.httpclient.d.c paramc, cz.msebera.android.httpclient.g.e parame1, cz.msebera.android.httpclient.g.e parame2, d<u> paramd, f<x> paramf) {}
  
  public g(int paramInt, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, cz.msebera.android.httpclient.d.c paramc)
  {
    this(paramInt, paramInt, paramCharsetDecoder, paramCharsetEncoder, paramc, null, null, null, null);
  }
  
  public u a()
    throws p, IOException
  {
    l();
    u localu = (u)this.a.a();
    a(localu);
    q();
    return localu;
  }
  
  public void a(o paramo)
    throws p, IOException
  {
    a.a(paramo, "HTTP request");
    l();
    paramo.setEntity(b(paramo));
  }
  
  protected void a(u paramu) {}
  
  public void a(x paramx)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    l();
    this.b.b(paramx);
    c(paramx);
    if (paramx.a().b() >= 200) {
      r();
    }
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    super.a(paramSocket);
  }
  
  public void b()
    throws IOException
  {
    l();
    p();
  }
  
  public void b(x paramx)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    l();
    n localn = paramx.b();
    if (localn == null) {
      return;
    }
    paramx = a(paramx);
    localn.writeTo(paramx);
    paramx.close();
  }
  
  protected void c(x paramx) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */