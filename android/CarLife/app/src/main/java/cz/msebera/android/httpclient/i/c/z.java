package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.d.c;
import cz.msebera.android.httpclient.g.e;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

@NotThreadSafe
class z
  extends o
{
  public b a;
  private final b b;
  private final am c;
  
  public z(String paramString, b paramb1, b paramb2, b paramb3, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, c paramc, e parame1, e parame2, f<u> paramf, d<x> paramd)
  {
    super(paramString, paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramc, parame1, parame2, paramf, paramd);
    this.a = paramb1;
    this.b = paramb2;
    this.c = new am(paramb3, paramString);
  }
  
  protected InputStream b(Socket paramSocket)
    throws IOException
  {
    InputStream localInputStream = super.b(paramSocket);
    paramSocket = localInputStream;
    if (this.c.a()) {
      paramSocket = new y(localInputStream, this.c);
    }
    return paramSocket;
  }
  
  protected void b(u paramu)
  {
    if ((paramu != null) && (this.b.a()))
    {
      this.b.a(s() + " >> " + paramu.getRequestLine().toString());
      paramu = paramu.getAllHeaders();
      int j = paramu.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramu[i];
        this.b.a(s() + " >> " + localObject.toString());
        i += 1;
      }
    }
  }
  
  protected void b(x paramx)
  {
    if ((paramx != null) && (this.b.a()))
    {
      this.b.a(s() + " << " + paramx.a().toString());
      paramx = paramx.getAllHeaders();
      int j = paramx.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramx[i];
        this.b.a(s() + " << " + localObject.toString());
        i += 1;
      }
    }
  }
  
  protected OutputStream c(Socket paramSocket)
    throws IOException
  {
    OutputStream localOutputStream = super.c(paramSocket);
    paramSocket = localOutputStream;
    if (this.c.a()) {
      paramSocket = new aa(localOutputStream, this.c);
    }
    return paramSocket;
  }
  
  public void close()
    throws IOException
  {
    if (this.a.a()) {
      this.a.a(s() + ": Close connection");
    }
    super.close();
  }
  
  public void f()
    throws IOException
  {
    if (this.a.a()) {
      this.a.a(s() + ": Shutdown connection");
    }
    super.f();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */