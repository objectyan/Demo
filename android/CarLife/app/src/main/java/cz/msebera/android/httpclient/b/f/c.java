package cz.msebera.android.httpclient.b.f;

import cz.msebera.android.httpclient.a.f;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.j;
import cz.msebera.android.httpclient.n.g;
import java.net.URI;
import java.util.List;

@NotThreadSafe
public class c
  extends cz.msebera.android.httpclient.n.h
{
  public static final String b = "http.route";
  public static final String c = "http.protocol.redirect-locations";
  public static final String d = "http.cookiespec-registry";
  public static final String e = "http.cookie-spec";
  public static final String f = "http.cookie-origin";
  public static final String g = "http.cookie-store";
  public static final String h = "http.auth.credentials-provider";
  public static final String i = "http.auth.auth-cache";
  public static final String j = "http.auth.target-scope";
  public static final String k = "http.auth.proxy-scope";
  public static final String l = "http.user-token";
  public static final String m = "http.authscheme-registry";
  public static final String n = "http.request-config";
  
  public c() {}
  
  public c(g paramg)
  {
    super(paramg);
  }
  
  public static c b(g paramg)
  {
    if ((paramg instanceof c)) {
      return (c)paramg;
    }
    return new c(paramg);
  }
  
  private <T> cz.msebera.android.httpclient.d.b<T> b(String paramString, Class<T> paramClass)
  {
    return (cz.msebera.android.httpclient.d.b)a(paramString, cz.msebera.android.httpclient.d.b.class);
  }
  
  public static c c()
  {
    return new c(new cz.msebera.android.httpclient.n.a());
  }
  
  public <T> T a(Class<T> paramClass)
  {
    return (T)a("http.user-token", paramClass);
  }
  
  public void a(cz.msebera.android.httpclient.b.a parama)
  {
    a("http.auth.auth-cache", parama);
  }
  
  public void a(cz.msebera.android.httpclient.b.b.c paramc)
  {
    a("http.request-config", paramc);
  }
  
  public void a(cz.msebera.android.httpclient.b.h paramh)
  {
    a("http.cookie-store", paramh);
  }
  
  public void a(cz.msebera.android.httpclient.b.i parami)
  {
    a("http.auth.credentials-provider", parami);
  }
  
  public void a(cz.msebera.android.httpclient.d.b<j> paramb)
  {
    a("http.cookiespec-registry", paramb);
  }
  
  public void a(Object paramObject)
  {
    a("http.user-token", paramObject);
  }
  
  public void b(cz.msebera.android.httpclient.d.b<f> paramb)
  {
    a("http.authscheme-registry", paramb);
  }
  
  public cz.msebera.android.httpclient.e.b.e d()
  {
    return (cz.msebera.android.httpclient.e.b.e)a("http.route", cz.msebera.android.httpclient.e.b.b.class);
  }
  
  public List<URI> e()
  {
    return (List)a("http.protocol.redirect-locations", List.class);
  }
  
  public cz.msebera.android.httpclient.b.h f()
  {
    return (cz.msebera.android.httpclient.b.h)a("http.cookie-store", cz.msebera.android.httpclient.b.h.class);
  }
  
  public cz.msebera.android.httpclient.f.h g()
  {
    return (cz.msebera.android.httpclient.f.h)a("http.cookie-spec", cz.msebera.android.httpclient.f.h.class);
  }
  
  public cz.msebera.android.httpclient.f.e h()
  {
    return (cz.msebera.android.httpclient.f.e)a("http.cookie-origin", cz.msebera.android.httpclient.f.e.class);
  }
  
  public cz.msebera.android.httpclient.d.b<j> i()
  {
    return b("http.cookiespec-registry", j.class);
  }
  
  public cz.msebera.android.httpclient.d.b<f> j()
  {
    return b("http.authscheme-registry", f.class);
  }
  
  public cz.msebera.android.httpclient.b.i k()
  {
    return (cz.msebera.android.httpclient.b.i)a("http.auth.credentials-provider", cz.msebera.android.httpclient.b.i.class);
  }
  
  public cz.msebera.android.httpclient.b.a l()
  {
    return (cz.msebera.android.httpclient.b.a)a("http.auth.auth-cache", cz.msebera.android.httpclient.b.a.class);
  }
  
  public cz.msebera.android.httpclient.a.i m()
  {
    return (cz.msebera.android.httpclient.a.i)a("http.auth.target-scope", cz.msebera.android.httpclient.a.i.class);
  }
  
  public cz.msebera.android.httpclient.a.i n()
  {
    return (cz.msebera.android.httpclient.a.i)a("http.auth.proxy-scope", cz.msebera.android.httpclient.a.i.class);
  }
  
  public Object o()
  {
    return a("http.user-token");
  }
  
  public cz.msebera.android.httpclient.b.b.c p()
  {
    cz.msebera.android.httpclient.b.b.c localc = (cz.msebera.android.httpclient.b.b.c)a("http.request-config", cz.msebera.android.httpclient.b.b.c.class);
    if (localc != null) {
      return localc;
    }
    return cz.msebera.android.httpclient.b.b.c.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */