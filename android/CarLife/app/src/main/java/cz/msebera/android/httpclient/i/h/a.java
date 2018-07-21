package cz.msebera.android.httpclient.i.h;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.i.e;
import cz.msebera.android.httpclient.l;
import cz.msebera.android.httpclient.l.i;
import cz.msebera.android.httpclient.m.b;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

@Immutable
public class a
  implements b<r, cz.msebera.android.httpclient.j>
{
  private final SocketFactory a;
  private final SSLSocketFactory b;
  private final int c;
  private final cz.msebera.android.httpclient.d.f d;
  private final l<? extends cz.msebera.android.httpclient.j> e;
  
  public a()
  {
    this(null, null, 0, cz.msebera.android.httpclient.d.f.a, cz.msebera.android.httpclient.d.a.a);
  }
  
  public a(int paramInt, cz.msebera.android.httpclient.d.f paramf, cz.msebera.android.httpclient.d.a parama)
  {
    this(null, null, paramInt, paramf, parama);
  }
  
  public a(cz.msebera.android.httpclient.d.f paramf, cz.msebera.android.httpclient.d.a parama)
  {
    this(null, null, 0, paramf, parama);
  }
  
  @Deprecated
  public a(cz.msebera.android.httpclient.l.j paramj)
  {
    this(null, paramj);
  }
  
  public a(SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, int paramInt, cz.msebera.android.httpclient.d.f paramf, cz.msebera.android.httpclient.d.a parama)
  {
    this.a = paramSocketFactory;
    this.b = paramSSLSocketFactory;
    this.c = paramInt;
    if (paramf != null)
    {
      this.d = paramf;
      if (parama == null) {
        break label57;
      }
    }
    for (;;)
    {
      this.e = new cz.msebera.android.httpclient.i.f(parama);
      return;
      paramf = cz.msebera.android.httpclient.d.f.a;
      break;
      label57:
      parama = cz.msebera.android.httpclient.d.a.a;
    }
  }
  
  @Deprecated
  public a(SSLSocketFactory paramSSLSocketFactory, cz.msebera.android.httpclient.l.j paramj)
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP params");
    this.a = null;
    this.b = paramSSLSocketFactory;
    this.c = paramj.a("http.connection.timeout", 0);
    this.d = i.a(paramj);
    this.e = new cz.msebera.android.httpclient.i.f(i.c(paramj));
  }
  
  public cz.msebera.android.httpclient.j a(r paramr)
    throws IOException
  {
    String str = paramr.c();
    Object localObject = null;
    if ("http".equalsIgnoreCase(str))
    {
      if (this.a != null) {
        localObject = this.a.createSocket();
      }
    }
    else if ("https".equalsIgnoreCase(str)) {
      if (this.b == null) {
        break label110;
      }
    }
    label110:
    for (localObject = this.b;; localObject = SSLSocketFactory.getDefault())
    {
      localObject = ((SocketFactory)localObject).createSocket();
      if (localObject != null) {
        break label118;
      }
      throw new IOException(str + " scheme is not supported");
      localObject = new Socket();
      break;
    }
    label118:
    str = paramr.a();
    int j = paramr.b();
    int i = j;
    if (j == -1)
    {
      if (paramr.c().equalsIgnoreCase("http")) {
        i = 80;
      }
    }
    else
    {
      ((Socket)localObject).setSoTimeout(this.d.a());
      ((Socket)localObject).setTcpNoDelay(this.d.e());
      j = this.d.c();
      if (j >= 0) {
        if (j <= 0) {
          break label269;
        }
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((Socket)localObject).setSoLinger(bool, j);
      ((Socket)localObject).setKeepAlive(this.d.d());
      ((Socket)localObject).connect(new InetSocketAddress(str, i), this.c);
      return (cz.msebera.android.httpclient.j)this.e.a((Socket)localObject);
      i = j;
      if (!paramr.c().equalsIgnoreCase("https")) {
        break;
      }
      i = 443;
      break;
    }
  }
  
  @Deprecated
  protected cz.msebera.android.httpclient.j a(Socket paramSocket, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    paramj = new e(paramj.a("http.socket.buffer-size", 8192));
    paramj.a(paramSocket);
    return paramj;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */