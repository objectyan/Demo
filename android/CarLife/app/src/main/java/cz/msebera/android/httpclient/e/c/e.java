package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.g;
import cz.msebera.android.httpclient.l.h;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@Deprecated
@Immutable
public class e
  implements k, m
{
  private final a a;
  
  public e()
  {
    this.a = null;
  }
  
  @Deprecated
  public e(a parama)
  {
    this.a = parama;
  }
  
  public static e a()
  {
    return new e();
  }
  
  @Deprecated
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, j paramj)
    throws IOException, UnknownHostException, g
  {
    InetSocketAddress localInetSocketAddress = null;
    if ((paramInetAddress != null) || (paramInt2 > 0))
    {
      if (paramInt2 > 0) {
        localInetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt2);
      }
    }
    else {
      if (this.a == null) {
        break label74;
      }
    }
    label74:
    for (paramString = this.a.a(paramString);; paramString = InetAddress.getByName(paramString))
    {
      return connectSocket(paramSocket, new InetSocketAddress(paramString, paramInt1), localInetSocketAddress, paramj);
      paramInt2 = 0;
      break;
    }
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, j paramj)
    throws IOException, g
  {
    cz.msebera.android.httpclient.o.a.a(paramInetSocketAddress1, "Remote address");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    Socket localSocket = paramSocket;
    if (paramSocket == null) {
      localSocket = createSocket();
    }
    if (paramInetSocketAddress2 != null)
    {
      localSocket.setReuseAddress(h.b(paramj));
      localSocket.bind(paramInetSocketAddress2);
    }
    int i = h.f(paramj);
    int j = h.a(paramj);
    try
    {
      localSocket.setSoTimeout(j);
      localSocket.connect(paramInetSocketAddress1, i);
      return localSocket;
    }
    catch (SocketTimeoutException paramSocket)
    {
      throw new g("Connect to " + paramInetSocketAddress1 + " timed out");
    }
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public Socket createSocket(j paramj)
  {
    return new Socket();
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */