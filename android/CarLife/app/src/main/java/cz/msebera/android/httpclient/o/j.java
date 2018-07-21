package cz.msebera.android.httpclient.o;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class j
{
  public static void a(StringBuilder paramStringBuilder, SocketAddress paramSocketAddress)
  {
    a.a(paramStringBuilder, "Buffer");
    a.a(paramSocketAddress, "Socket address");
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      InetAddress localInetAddress = localInetSocketAddress.getAddress();
      paramSocketAddress = localInetAddress;
      if (localInetAddress != null) {
        paramSocketAddress = localInetAddress.getHostAddress();
      }
      paramStringBuilder.append(paramSocketAddress).append(':').append(localInetSocketAddress.getPort());
      return;
    }
    paramStringBuilder.append(paramSocketAddress);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */