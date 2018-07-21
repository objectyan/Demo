package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;

@Immutable
public class q
  extends ConnectException
{
  private static final long a = -3194482710275220224L;
  private final r b;
  
  @Deprecated
  public q(r paramr, ConnectException paramConnectException)
  {
    this(paramConnectException, paramr, null);
  }
  
  public q(IOException paramIOException, r paramr, InetAddress... paramVarArgs) {}
  
  public r a()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */