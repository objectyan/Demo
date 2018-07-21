package cz.msebera.android.httpclient.e.d;

import cz.msebera.android.httpclient.n.g;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract interface b
  extends a
{
  public abstract Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, g paramg)
    throws IOException, UnknownHostException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */