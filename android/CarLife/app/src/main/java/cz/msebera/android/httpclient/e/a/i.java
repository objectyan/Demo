package cz.msebera.android.httpclient.e.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.l.f;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.r;
import java.net.InetAddress;

@Deprecated
@NotThreadSafe
public class i
  extends f
{
  public i(j paramj)
  {
    super(paramj);
  }
  
  public void a(b paramb)
  {
    this.a.a("http.route.forced-route", paramb);
  }
  
  public void a(r paramr)
  {
    this.a.a("http.route.default-proxy", paramr);
  }
  
  public void a(InetAddress paramInetAddress)
  {
    this.a.a("http.route.local-address", paramInetAddress);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */