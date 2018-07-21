package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
public abstract interface g
  extends k
{
  public abstract Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, j paramj)
    throws IOException, UnknownHostException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */