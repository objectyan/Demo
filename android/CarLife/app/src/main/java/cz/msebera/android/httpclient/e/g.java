package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;

@Immutable
public class g
  extends InterruptedIOException
{
  private static final long a = -4816682903149535989L;
  private final r b = null;
  
  public g() {}
  
  public g(IOException paramIOException, r paramr, InetAddress... paramVarArgs) {}
  
  public g(String paramString)
  {
    super(paramString);
  }
  
  public r a()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */