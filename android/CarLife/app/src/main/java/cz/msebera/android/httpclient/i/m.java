package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.net.Socket;

@Deprecated
@NotThreadSafe
public class m
  extends r
{
  public void a(Socket paramSocket, j paramj)
    throws IOException
  {
    boolean bool2 = true;
    a.a(paramSocket, "Socket");
    a.a(paramj, "HTTP parameters");
    r();
    paramSocket.setTcpNoDelay(paramj.a("http.tcp.nodelay", true));
    paramSocket.setSoTimeout(paramj.a("http.socket.timeout", 0));
    paramSocket.setKeepAlive(paramj.a("http.socket.keepalive", false));
    int i = paramj.a("http.socket.linger", -1);
    if (i >= 0)
    {
      if (i > 0)
      {
        bool1 = true;
        paramSocket.setSoLinger(bool1, i);
      }
    }
    else if (i >= 0) {
      if (i <= 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSocket.setSoLinger(bool1, i);
      super.a(paramSocket, paramj);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */