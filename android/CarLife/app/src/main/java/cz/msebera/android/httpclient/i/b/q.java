package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.g;
import cz.msebera.android.httpclient.x;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class q
  implements g
{
  public boolean a(x paramx)
  {
    return paramx.a().b() == 503;
  }
  
  public boolean a(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof SocketTimeoutException)) || ((paramThrowable instanceof ConnectException));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */