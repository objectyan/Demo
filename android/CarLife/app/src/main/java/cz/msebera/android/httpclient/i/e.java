package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.g.l;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

@NotThreadSafe
public class e
  extends c
  implements j
{
  private final cz.msebera.android.httpclient.j.c<x> a;
  private final cz.msebera.android.httpclient.j.e<u> b;
  
  public e(int paramInt)
  {
    this(paramInt, paramInt, null, null, null, null, null, null, null);
  }
  
  public e(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, cz.msebera.android.httpclient.d.c paramc, cz.msebera.android.httpclient.g.e parame1, cz.msebera.android.httpclient.g.e parame2, f<u> paramf, d<x> paramd)
  {
    super(paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramc, parame1, parame2);
    if (paramf != null)
    {
      this.b = paramf.a(o());
      if (paramd == null) {
        break label66;
      }
    }
    for (;;)
    {
      this.a = paramd.a(m(), paramc);
      return;
      paramf = l.a;
      break;
      label66:
      paramd = cz.msebera.android.httpclient.i.g.n.a;
    }
  }
  
  public e(int paramInt, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, cz.msebera.android.httpclient.d.c paramc)
  {
    this(paramInt, paramInt, paramCharsetDecoder, paramCharsetEncoder, paramc, null, null, null, null);
  }
  
  public x a()
    throws p, IOException
  {
    l();
    x localx = (x)this.a.a();
    b(localx);
    if (localx.a().b() >= 200) {
      r();
    }
    return localx;
  }
  
  public void a(o paramo)
    throws p, IOException
  {
    a.a(paramo, "HTTP request");
    l();
    cz.msebera.android.httpclient.n localn = paramo.getEntity();
    if (localn == null) {
      return;
    }
    paramo = a(paramo);
    localn.writeTo(paramo);
    paramo.close();
  }
  
  public void a(u paramu)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    l();
    this.b.b(paramu);
    b(paramu);
    q();
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    a.a(paramx, "HTTP response");
    l();
    paramx.a(b(paramx));
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    super.a(paramSocket);
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    l();
    try
    {
      boolean bool = c(paramInt);
      return bool;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
    return false;
  }
  
  protected void b(u paramu) {}
  
  protected void b(x paramx) {}
  
  public void h_()
    throws IOException
  {
    l();
    p();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */