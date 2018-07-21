package cz.msebera.android.httpclient.b.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.n.g;

@NotThreadSafe
public class c
  extends cz.msebera.android.httpclient.b.f.c
{
  public static final String a = "http.cache.response.status";
  
  public c() {}
  
  public c(g paramg)
  {
    super(paramg);
  }
  
  public static c a()
  {
    return new c(new cz.msebera.android.httpclient.n.a());
  }
  
  public static c a(g paramg)
  {
    if ((paramg instanceof c)) {
      return (c)paramg;
    }
    return new c(paramg);
  }
  
  public a b()
  {
    return (a)a("http.cache.response.status", a.class);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */