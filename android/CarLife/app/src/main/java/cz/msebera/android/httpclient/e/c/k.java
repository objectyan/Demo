package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.e.g;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface k
{
  public abstract Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, j paramj)
    throws IOException, UnknownHostException, g;
  
  public abstract Socket createSocket(j paramj)
    throws IOException;
  
  public abstract boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */