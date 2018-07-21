package cz.msebera.android.httpclient.e.d;

import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public abstract interface a
{
  public abstract Socket connectSocket(int paramInt, Socket paramSocket, r paramr, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, g paramg)
    throws IOException;
  
  public abstract Socket createSocket(g paramg)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */