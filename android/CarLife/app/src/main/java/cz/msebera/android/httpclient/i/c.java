package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.e.d;
import cz.msebera.android.httpclient.i.g.g;
import cz.msebera.android.httpclient.i.g.u;
import cz.msebera.android.httpclient.i.g.v;
import cz.msebera.android.httpclient.i.g.w;
import cz.msebera.android.httpclient.i.g.x;
import cz.msebera.android.httpclient.i.g.y;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.k;
import cz.msebera.android.httpclient.m;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.j;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.s;
import cz.msebera.android.httpclient.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;

@NotThreadSafe
public class c
  implements k, s
{
  private final x a;
  private final y b;
  private final o c;
  private final cz.msebera.android.httpclient.g.e d;
  private final cz.msebera.android.httpclient.g.e e;
  private final AtomicReference<Socket> f;
  
  protected c(int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, cz.msebera.android.httpclient.d.c paramc, cz.msebera.android.httpclient.g.e parame1, cz.msebera.android.httpclient.g.e parame2)
  {
    a.a(paramInt1, "Buffer size");
    u localu1 = new u();
    u localu2 = new u();
    if (paramc != null)
    {
      this.a = new x(localu1, paramInt1, -1, paramc, paramCharsetDecoder);
      this.b = new y(localu2, paramInt1, paramInt2, paramCharsetEncoder);
      this.c = new o(localu1, localu2);
      if (parame1 == null) {
        break label126;
      }
      label89:
      this.d = parame1;
      if (parame2 == null) {
        break label134;
      }
    }
    for (;;)
    {
      this.e = parame2;
      this.f = new AtomicReference();
      return;
      paramc = cz.msebera.android.httpclient.d.c.a;
      break;
      label126:
      parame1 = d.c;
      break label89;
      label134:
      parame2 = cz.msebera.android.httpclient.i.e.e.c;
    }
  }
  
  private int a(int paramInt)
    throws IOException
  {
    Socket localSocket = (Socket)this.f.get();
    int i = localSocket.getSoTimeout();
    try
    {
      localSocket.setSoTimeout(paramInt);
      paramInt = this.a.e();
      return paramInt;
    }
    finally
    {
      localSocket.setSoTimeout(i);
    }
  }
  
  protected InputStream a(long paramLong, cz.msebera.android.httpclient.j.h paramh)
  {
    if (paramLong == -2L) {
      return new cz.msebera.android.httpclient.i.g.e(paramh);
    }
    if (paramLong == -1L) {
      return new v(paramh);
    }
    return new g(paramh, paramLong);
  }
  
  protected OutputStream a(long paramLong, i parami)
  {
    if (paramLong == -2L) {
      return new cz.msebera.android.httpclient.i.g.f(2048, parami);
    }
    if (paramLong == -1L) {
      return new w(parami);
    }
    return new cz.msebera.android.httpclient.i.g.h(parami, paramLong);
  }
  
  protected OutputStream a(t paramt)
    throws p
  {
    return a(this.e.a(paramt), this.b);
  }
  
  protected void a(Socket paramSocket)
    throws IOException
  {
    a.a(paramSocket, "Socket");
    this.f.set(paramSocket);
    this.a.a(null);
    this.b.a(null);
  }
  
  protected n b(t paramt)
    throws p
  {
    cz.msebera.android.httpclient.g.b localb = new cz.msebera.android.httpclient.g.b();
    long l = this.d.a(paramt);
    Object localObject = a(l, this.a);
    if (l == -2L)
    {
      localb.a(true);
      localb.a(-1L);
      localb.a((InputStream)localObject);
    }
    for (;;)
    {
      localObject = paramt.getFirstHeader("Content-Type");
      if (localObject != null) {
        localb.a((cz.msebera.android.httpclient.f)localObject);
      }
      paramt = paramt.getFirstHeader("Content-Encoding");
      if (paramt != null) {
        localb.b(paramt);
      }
      return localb;
      if (l == -1L)
      {
        localb.a(false);
        localb.a(-1L);
        localb.a((InputStream)localObject);
      }
      else
      {
        localb.a(false);
        localb.a(l);
        localb.a((InputStream)localObject);
      }
    }
  }
  
  protected InputStream b(Socket paramSocket)
    throws IOException
  {
    return paramSocket.getInputStream();
  }
  
  public void b(int paramInt)
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {}
    try
    {
      localSocket.setSoTimeout(paramInt);
      return;
    }
    catch (SocketException localSocketException) {}
  }
  
  protected OutputStream c(Socket paramSocket)
    throws IOException
  {
    return paramSocket.getOutputStream();
  }
  
  public boolean c()
  {
    return this.f.get() != null;
  }
  
  protected boolean c(int paramInt)
    throws IOException
  {
    if (this.a.i()) {
      return true;
    }
    a(paramInt);
    return this.a.i();
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	cz/msebera/android/httpclient/i/c:f	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: aconst_null
    //   5: invokevirtual 216	java/util/concurrent/atomic/AtomicReference:getAndSet	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 91	java/net/Socket
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +29 -> 42
    //   16: aload_0
    //   17: getfield 43	cz/msebera/android/httpclient/i/c:a	Lcz/msebera/android/httpclient/i/g/x;
    //   20: invokevirtual 219	cz/msebera/android/httpclient/i/g/x:j	()V
    //   23: aload_0
    //   24: getfield 50	cz/msebera/android/httpclient/i/c:b	Lcz/msebera/android/httpclient/i/g/y;
    //   27: invokevirtual 221	cz/msebera/android/httpclient/i/g/y:a	()V
    //   30: aload_1
    //   31: invokevirtual 224	java/net/Socket:shutdownOutput	()V
    //   34: aload_1
    //   35: invokevirtual 227	java/net/Socket:shutdownInput	()V
    //   38: aload_1
    //   39: invokevirtual 229	java/net/Socket:close	()V
    //   42: return
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 229	java/net/Socket:close	()V
    //   48: aload_2
    //   49: athrow
    //   50: astore_2
    //   51: goto -17 -> 34
    //   54: astore_2
    //   55: goto -17 -> 38
    //   58: astore_2
    //   59: goto -21 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	c
    //   11	34	1	localSocket	Socket
    //   43	6	2	localObject	Object
    //   50	1	2	localIOException1	IOException
    //   54	1	2	localIOException2	IOException
    //   58	1	2	localUnsupportedOperationException	UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   16	30	43	finally
    //   30	34	43	finally
    //   34	38	43	finally
    //   30	34	50	java/io/IOException
    //   34	38	54	java/io/IOException
    //   30	34	58	java/lang/UnsupportedOperationException
    //   34	38	58	java/lang/UnsupportedOperationException
  }
  
  public boolean d()
  {
    if (!c()) {}
    for (;;)
    {
      return true;
      try
      {
        int i = a(1);
        if (i >= 0) {
          return false;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        return false;
      }
      catch (IOException localIOException) {}
    }
    return true;
  }
  
  public int e()
  {
    int i = -1;
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {}
    try
    {
      i = localSocket.getSoTimeout();
      return i;
    }
    catch (SocketException localSocketException) {}
    return -1;
  }
  
  public void f()
    throws IOException
  {
    Socket localSocket = (Socket)this.f.getAndSet(null);
    if (localSocket != null) {
      localSocket.close();
    }
  }
  
  public m g()
  {
    return this.c;
  }
  
  public InetAddress h()
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {
      return localSocket.getLocalAddress();
    }
    return null;
  }
  
  public int i()
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {
      return localSocket.getLocalPort();
    }
    return -1;
  }
  
  public InetAddress j()
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {
      return localSocket.getInetAddress();
    }
    return null;
  }
  
  public int k()
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {
      return localSocket.getPort();
    }
    return -1;
  }
  
  protected void l()
    throws IOException
  {
    Socket localSocket = (Socket)this.f.get();
    if (localSocket != null) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection is not open");
      if (!this.a.d()) {
        this.a.a(b(localSocket));
      }
      if (!this.b.c()) {
        this.b.a(c(localSocket));
      }
      return;
    }
  }
  
  protected cz.msebera.android.httpclient.j.h m()
  {
    return this.a;
  }
  
  protected i o()
  {
    return this.b;
  }
  
  protected void p()
    throws IOException
  {
    this.b.a();
  }
  
  protected void q()
  {
    this.c.f();
  }
  
  protected void r()
  {
    this.c.g();
  }
  
  protected Socket t()
  {
    return (Socket)this.f.get();
  }
  
  public String toString()
  {
    Object localObject = (Socket)this.f.get();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      SocketAddress localSocketAddress = ((Socket)localObject).getRemoteSocketAddress();
      localObject = ((Socket)localObject).getLocalSocketAddress();
      if ((localSocketAddress != null) && (localObject != null))
      {
        j.a(localStringBuilder, (SocketAddress)localObject);
        localStringBuilder.append("<->");
        j.a(localStringBuilder, localSocketAddress);
      }
      return localStringBuilder.toString();
    }
    return "[Not bound]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */