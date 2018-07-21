package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.o.a;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Deprecated
public class r
  extends InetSocketAddress
{
  private static final long a = -6650701828361907957L;
  private final cz.msebera.android.httpclient.r b;
  
  public r(cz.msebera.android.httpclient.r paramr, InetAddress paramInetAddress, int paramInt)
  {
    super(paramInetAddress, paramInt);
    a.a(paramr, "HTTP host");
    this.b = paramr;
  }
  
  public cz.msebera.android.httpclient.r a()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.b.a() + ":" + getPort();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */