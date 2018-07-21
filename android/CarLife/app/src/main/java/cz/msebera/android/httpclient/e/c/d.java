package cz.msebera.android.httpclient.e.c;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class d
  extends n
  implements c
{
  private final b a;
  
  d(b paramb)
  {
    super(paramb);
    this.a = paramb;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.a.createLayeredSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */