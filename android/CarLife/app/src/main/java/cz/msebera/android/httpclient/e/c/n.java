package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.e.g;
import cz.msebera.android.httpclient.l.b;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class n
  implements m
{
  private final k a;
  
  n(k paramk)
  {
    this.a = paramk;
  }
  
  public k a()
  {
    return this.a;
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, j paramj)
    throws IOException, UnknownHostException, g
  {
    InetSocketAddress localInetSocketAddress = null;
    if ((paramInetAddress != null) || (paramInt2 > 0)) {
      if (paramInt2 <= 0) {
        break label60;
      }
    }
    for (;;)
    {
      localInetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt2);
      paramString = new InetSocketAddress(InetAddress.getByName(paramString), paramInt1);
      return this.a.connectSocket(paramSocket, paramString, localInetSocketAddress, paramj);
      label60:
      paramInt2 = 0;
    }
  }
  
  public Socket createSocket()
    throws IOException
  {
    b localb = new b();
    return this.a.createSocket(localb);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof n)) {
      return this.a.equals(((n)paramObject).a);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */