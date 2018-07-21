package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class i
  implements g
{
  private final b a;
  
  i(b paramb)
  {
    this.a = paramb;
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, j paramj)
    throws IOException, UnknownHostException, cz.msebera.android.httpclient.e.g
  {
    return this.a.connectSocket(paramSocket, paramInetSocketAddress1, paramInetSocketAddress2, paramj);
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, j paramj)
    throws IOException, UnknownHostException
  {
    return this.a.createLayeredSocket(paramSocket, paramString, paramInt, true);
  }
  
  public Socket createSocket(j paramj)
    throws IOException
  {
    return this.a.createSocket(paramj);
  }
  
  public boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    return this.a.isSecure(paramSocket);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */