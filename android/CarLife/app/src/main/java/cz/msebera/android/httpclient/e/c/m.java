package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.e.g;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface m
{
  public abstract Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, j paramj)
    throws IOException, UnknownHostException, g;
  
  public abstract Socket createSocket()
    throws IOException;
  
  public abstract boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */