package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.e.g;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class l
  implements k
{
  private final m a;
  
  l(m paramm)
  {
    this.a = paramm;
  }
  
  public m a()
  {
    return this.a;
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, j paramj)
    throws IOException, UnknownHostException, g
  {
    String str = paramInetSocketAddress1.getHostName();
    int j = paramInetSocketAddress1.getPort();
    paramInetSocketAddress1 = null;
    int i = 0;
    if (paramInetSocketAddress2 != null)
    {
      paramInetSocketAddress1 = paramInetSocketAddress2.getAddress();
      i = paramInetSocketAddress2.getPort();
    }
    return this.a.connectSocket(paramSocket, str, j, paramInetSocketAddress1, i, paramj);
  }
  
  public Socket createSocket(j paramj)
    throws IOException
  {
    return this.a.createSocket();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof l)) {
      return this.a.equals(((l)paramObject).a);
    }
    return this.a.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    return this.a.isSecure(paramSocket);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */