package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.c.m;
import cz.msebera.android.httpclient.l.h;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Deprecated
@Immutable
public final class v
  implements m
{
  private static final v a = new v();
  
  public static v a()
  {
    return a;
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, j paramj)
    throws IOException
  {
    a.a(paramString, "Target host");
    a.a(paramj, "HTTP parameters");
    Socket localSocket = paramSocket;
    paramSocket = localSocket;
    if (localSocket == null) {
      paramSocket = createSocket();
    }
    if ((paramInetAddress != null) || (paramInt2 > 0))
    {
      if (paramInt2 > 0) {
        paramSocket.bind(new InetSocketAddress(paramInetAddress, paramInt2));
      }
    }
    else
    {
      paramInt2 = h.f(paramj);
      paramInetAddress = InetAddress.getAllByName(paramString);
      paramString = new ArrayList(paramInetAddress.length);
      paramString.addAll(Arrays.asList(paramInetAddress));
      Collections.shuffle(paramString);
      paramInetAddress = null;
      paramj = paramString.iterator();
      paramString = paramSocket;
      paramSocket = paramInetAddress;
    }
    for (;;)
    {
      if (paramj.hasNext()) {
        paramInetAddress = (InetAddress)paramj.next();
      }
      try
      {
        paramString.connect(new InetSocketAddress(paramInetAddress, paramInt1), paramInt2);
        if (paramSocket == null) {
          return paramString;
        }
        throw paramSocket;
      }
      catch (SocketTimeoutException paramSocket)
      {
        throw new g("Connect to " + paramInetAddress + " timed out");
      }
      catch (IOException paramSocket)
      {
        paramString = new Socket();
      }
      paramInt2 = 0;
      break;
    }
    return paramString;
  }
  
  public Socket createSocket()
  {
    return new Socket();
  }
  
  public final boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    a.a(paramSocket, "Socket");
    if (!paramSocket.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(bool, "Socket is closed");
      return false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */