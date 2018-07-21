package cz.msebera.android.httpclient.e.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Immutable
public class c
  implements a
{
  public static final c a = new c();
  
  public static c a()
  {
    return a;
  }
  
  public Socket connectSocket(int paramInt, Socket paramSocket, r paramr, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, g paramg)
    throws IOException
  {
    if (paramSocket != null) {}
    for (;;)
    {
      if (paramInetSocketAddress2 != null) {
        paramSocket.bind(paramInetSocketAddress2);
      }
      try
      {
        paramSocket.connect(paramInetSocketAddress1, paramInt);
        return paramSocket;
      }
      catch (IOException paramr) {}
      paramSocket = createSocket(paramg);
    }
    try
    {
      paramSocket.close();
      throw paramr;
    }
    catch (IOException paramSocket)
    {
      for (;;) {}
    }
  }
  
  public Socket createSocket(g paramg)
    throws IOException
  {
    return new Socket();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */