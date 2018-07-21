package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.h;
import cz.msebera.android.httpclient.b.i;
import cz.msebera.android.httpclient.f.k;

@Deprecated
@NotThreadSafe
public class b
  implements a
{
  private final cz.msebera.android.httpclient.n.g p;
  
  public b(cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    this.p = paramg;
  }
  
  public void a(cz.msebera.android.httpclient.a.g paramg)
  {
    this.p.a("http.authscheme-registry", paramg);
  }
  
  public void a(h paramh)
  {
    this.p.a("http.cookie-store", paramh);
  }
  
  public void a(i parami)
  {
    this.p.a("http.auth.credentials-provider", parami);
  }
  
  public void a(k paramk)
  {
    this.p.a("http.cookiespec-registry", paramk);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */