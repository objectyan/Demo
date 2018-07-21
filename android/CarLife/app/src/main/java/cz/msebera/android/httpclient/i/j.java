package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.net.Socket;

@Deprecated
@NotThreadSafe
public class j
  extends q
{
  public void a(Socket paramSocket, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    boolean bool = true;
    a.a(paramSocket, "Socket");
    a.a(paramj, "HTTP parameters");
    w();
    paramSocket.setTcpNoDelay(paramj.a("http.tcp.nodelay", true));
    paramSocket.setSoTimeout(paramj.a("http.socket.timeout", 0));
    paramSocket.setKeepAlive(paramj.a("http.socket.keepalive", false));
    int i = paramj.a("http.socket.linger", -1);
    if (i >= 0) {
      if (i <= 0) {
        break label92;
      }
    }
    for (;;)
    {
      paramSocket.setSoLinger(bool, i);
      super.a(paramSocket, paramj);
      return;
      label92:
      bool = false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */