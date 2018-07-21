package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class h
  extends l
  implements g
{
  private final c a;
  
  h(c paramc)
  {
    super(paramc);
    this.a = paramc;
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, j paramj)
    throws IOException, UnknownHostException
  {
    return this.a.createSocket(paramSocket, paramString, paramInt, true);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */