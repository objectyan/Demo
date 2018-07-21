package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b;
import cz.msebera.android.httpclient.e.b.d;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.i.c.af;
import cz.msebera.android.httpclient.i.c.ah;
import cz.msebera.android.httpclient.i.c.ai;
import cz.msebera.android.httpclient.i.i;
import cz.msebera.android.httpclient.i.p;
import cz.msebera.android.httpclient.l.j;
import java.net.ProxySelector;

@Deprecated
@ThreadSafe
public class ax
  extends s
{
  public ax()
  {
    super(null, null);
  }
  
  public ax(j paramj)
  {
    super(null, paramj);
  }
  
  protected c f()
  {
    af localaf = new af(ai.b());
    if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")))
    {
      int i = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
      localaf.b(i);
      localaf.a(i * 2);
    }
    return localaf;
  }
  
  protected b j()
  {
    if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
      return new i();
    }
    return new p();
  }
  
  protected d t()
  {
    return new ah(b().a(), ProxySelector.getDefault());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */