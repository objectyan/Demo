package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.g.aa;
import cz.msebera.android.httpclient.i.g.z;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.b;
import cz.msebera.android.httpclient.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

@Deprecated
@NotThreadSafe
public class q
  extends a
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
    cz.msebera.android.httpclient.o.a.a(paramSocket, "Socket");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
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
    o();
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
    //   1: getfield 84	cz/msebera/android/httpclient/i/q:a	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 84	cz/msebera/android/httpclient/i/q:a	Z
    //   13: aload_0
    //   14: getfield 18	cz/msebera/android/httpclient/i/q:b	Ljava/net/Socket;
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 106	cz/msebera/android/httpclient/i/q:u	()V
    //   22: aload_1
    //   23: invokevirtual 109	java/net/Socket:shutdownOutput	()V
    //   26: aload_1
    //   27: invokevirtual 112	java/net/Socket:shutdownInput	()V
    //   30: aload_1
    //   31: invokevirtual 114	java/net/Socket:close	()V
    //   34: return
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 114	java/net/Socket:close	()V
    //   40: aload_2
    //   41: athrow
    //   42: astore_2
    //   43: goto -17 -> 26
    //   46: astore_2
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: goto -21 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	q
    //   17	20	1	localSocket	Socket
    //   35	6	2	localObject	Object
    //   42	1	2	localIOException1	IOException
    //   46	1	2	localIOException2	IOException
    //   50	1	2	localUnsupportedOperationException	UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   18	22	35	finally
    //   22	26	35	finally
    //   26	30	35	finally
    //   22	26	42	java/io/IOException
    //   26	30	46	java/io/IOException
    //   22	26	50	java/lang/UnsupportedOperationException
    //   26	30	50	java/lang/UnsupportedOperationException
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
  
  protected void o()
  {
    b.a(this.a, "Connection is not open");
  }
  
  protected Socket t()
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
  
  protected void w()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(bool, "Connection is already open");
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */