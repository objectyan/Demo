package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.k;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;

@NotThreadSafe
public class h
  implements g
{
  public static final String p = "http.connection";
  public static final String q = "http.request";
  public static final String r = "http.response";
  public static final String s = "http.target_host";
  public static final String t = "http.request_sent";
  private final g a;
  
  public h()
  {
    this.a = new a();
  }
  
  public h(g paramg)
  {
    this.a = paramg;
  }
  
  public static h c(g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramg, "HTTP context");
    if ((paramg instanceof h)) {
      return (h)paramg;
    }
    return new h(paramg);
  }
  
  public static h q()
  {
    return new h(new a());
  }
  
  public Object a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    cz.msebera.android.httpclient.o.a.a(paramClass, "Attribute class");
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    return (T)paramClass.cast(paramString);
  }
  
  public void a(r paramr)
  {
    a("http.target_host", paramr);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
  }
  
  public <T extends k> T b(Class<T> paramClass)
  {
    return (k)a("http.connection", paramClass);
  }
  
  public Object b(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public k r()
  {
    return (k)a("http.connection", k.class);
  }
  
  public u s()
  {
    return (u)a("http.request", u.class);
  }
  
  public boolean t()
  {
    Boolean localBoolean = (Boolean)a("http.request_sent", Boolean.class);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public x u()
  {
    return (x)a("http.response", x.class);
  }
  
  public r v()
  {
    return (r)a("http.target_host", r.class);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */