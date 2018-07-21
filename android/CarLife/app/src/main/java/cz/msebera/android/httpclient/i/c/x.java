package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.o.a;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class x
  implements l
{
  public b a = new b(x.class);
  private final Map<String, InetAddress[]> b = new ConcurrentHashMap();
  
  public void a(String paramString, InetAddress... paramVarArgs)
  {
    a.a(paramString, "Host name");
    a.a(paramVarArgs, "Array of IP addresses");
    this.b.put(paramString, paramVarArgs);
  }
  
  public InetAddress[] a(String paramString)
    throws UnknownHostException
  {
    InetAddress[] arrayOfInetAddress = (InetAddress[])this.b.get(paramString);
    if (this.a.d()) {
      this.a.d("Resolving " + paramString + " to " + Arrays.deepToString(arrayOfInetAddress));
    }
    if (arrayOfInetAddress == null) {
      throw new UnknownHostException(paramString + " cannot be resolved");
    }
    return arrayOfInetAddress;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */