package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;
import java.lang.reflect.Proxy;

@NotThreadSafe
class aj
{
  public static c a(x paramx)
  {
    a.a(paramx, "HTTP response");
    if ((paramx instanceof c)) {
      return (c)paramx;
    }
    ClassLoader localClassLoader = ap.class.getClassLoader();
    paramx = new ap(paramx);
    return (c)Proxy.newProxyInstance(localClassLoader, new Class[] { c.class }, paramx);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */