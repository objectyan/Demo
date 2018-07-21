package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.s;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSession;

public abstract interface u
  extends j, s
{
  public abstract void a(Socket paramSocket)
    throws IOException;
  
  public abstract SSLSession n();
  
  public abstract String s();
  
  public abstract Socket t();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */