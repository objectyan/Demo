package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.net.Socket;

@Deprecated
@NotThreadSafe
public class aa
  extends d
{
  public aa(Socket paramSocket, int paramInt, j paramj)
    throws IOException
  {
    a.a(paramSocket, "Socket");
    int i = paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = paramSocket.getSendBufferSize();
    }
    i = paramInt;
    if (paramInt < 1024) {
      i = 1024;
    }
    a(paramSocket.getOutputStream(), i, paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */