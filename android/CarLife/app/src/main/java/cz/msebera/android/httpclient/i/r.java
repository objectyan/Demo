package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.i.g.aa;
import cz.msebera.android.httpclient.i.g.z;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

@Deprecated
public class r
  extends b
  implements s
{
  private volatile boolean a;
  private volatile Socket b = null;
  
  private static void a(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress)
  {
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      if (localInetSocketAddress.getAddress() != null) {}
      for (paramSocketAddress = localInetSocketAddress.getAddress().getHostAddress();; paramSocketAddress = localInetSocketAddress.getAddress())
      {
        paramStringBuilder.append(paramSocketAddress).append(':').append(localInetSocketAddress.getPort());
        return;
      }
    }
    paramStringBuilder.append(paramSocketAddress);
  }
  
  protected h a(Socket paramSocket, int paramInt, j paramj)
    throws IOException
  {
    return new z(paramSocket, paramInt, paramj);
  }
  
  protected void a(Socket paramSocket, j paramj)
    throws IOException
  {
    a.a(paramSocket, "Socket");
    a.a(paramj, "HTTP parameters");
    this.b = paramSocket;
    int i = paramj.a("http.socket.buffer-size", -1);
    a(a(paramSocket, i, paramj), b(paramSocket, i, paramj), paramj);
    this.a = true;
  }
  
  protected i b(Socket paramSocket, int paramInt, j paramj)
    throws IOException
  {
    return new aa(paramSocket, paramInt, paramj);
  }
  
  public void b(int paramInt)
  {
    l();
    if (this.b != null) {}
    try
    {
      this.b.setSoTimeout(paramInt);
      return;
    }
    catch (SocketException localSocketException) {}
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	cz/msebera/android/httpclient/i/r:a	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 83	cz/msebera/android/httpclient/i/r:a	Z
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield 83	cz/msebera/android/httpclient/i/r:a	Z
    //   18: aload_0
    //   19: getfield 17	cz/msebera/android/httpclient/i/r:b	Ljava/net/Socket;
    //   22: astore_1
    //   23: aload_0
    //   24: invokevirtual 105	cz/msebera/android/httpclient/i/r:p	()V
    //   27: aload_1
    //   28: invokevirtual 108	java/net/Socket:shutdownOutput	()V
    //   31: aload_1
    //   32: invokevirtual 111	java/net/Socket:shutdownInput	()V
    //   35: aload_1
    //   36: invokevirtual 113	java/net/Socket:close	()V
    //   39: return
    //   40: astore_2
    //   41: aload_1
    //   42: invokevirtual 113	java/net/Socket:close	()V
    //   45: aload_2
    //   46: athrow
    //   47: astore_2
    //   48: goto -17 -> 31
    //   51: astore_2
    //   52: goto -17 -> 35
    //   55: astore_2
    //   56: goto -21 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	r
    //   22	20	1	localSocket	Socket
    //   40	6	2	localObject	Object
    //   47	1	2	localIOException1	IOException
    //   51	1	2	localIOException2	IOException
    //   55	1	2	localUnsupportedOperationException	UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   23	27	40	finally
    //   27	31	40	finally
    //   31	35	40	finally
    //   27	31	47	java/io/IOException
    //   31	35	51	java/io/IOException
    //   27	31	55	java/lang/UnsupportedOperationException
    //   31	35	55	java/lang/UnsupportedOperationException
  }
  
  public int e()
  {
    int i = -1;
    if (this.b != null) {}
    try
    {
      i = this.b.getSoTimeout();
      return i;
    }
    catch (SocketException localSocketException) {}
    return -1;
  }
  
  public void f()
    throws IOException
  {
    this.a = false;
    Socket localSocket = this.b;
    if (localSocket != null) {
      localSocket.close();
    }
  }
  
  public InetAddress h()
  {
    if (this.b != null) {
      return this.b.getLocalAddress();
    }
    return null;
  }
  
  public int i()
  {
    if (this.b != null) {
      return this.b.getLocalPort();
    }
    return -1;
  }
  
  public InetAddress j()
  {
    if (this.b != null) {
      return this.b.getInetAddress();
    }
    return null;
  }
  
  public int k()
  {
    if (this.b != null) {
      return this.b.getPort();
    }
    return -1;
  }
  
  protected void l()
  {
    cz.msebera.android.httpclient.o.b.a(this.a, "Connection is not open");
  }
  
  protected void r()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Connection is already open");
      return;
    }
  }
  
  protected Socket s()
  {
    return this.b;
  }
  
  public String toString()
  {
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      SocketAddress localSocketAddress1 = this.b.getRemoteSocketAddress();
      SocketAddress localSocketAddress2 = this.b.getLocalSocketAddress();
      if ((localSocketAddress1 != null) && (localSocketAddress2 != null))
      {
        a(localStringBuilder, localSocketAddress2);
        localStringBuilder.append("<->");
        a(localStringBuilder, localSocketAddress1);
      }
      return localStringBuilder.toString();
    }
    return super.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */