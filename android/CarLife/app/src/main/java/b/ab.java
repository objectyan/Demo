package b;

import b.a.c;
import b.a.d.f;
import java.net.URL;
import java.util.List;

public final class ab
{
  final u a;
  final String b;
  final t c;
  final ac d;
  final Object e;
  private volatile d f;
  
  ab(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    if (parama.e != null) {}
    for (parama = parama.e;; parama = this)
    {
      this.e = parama;
      return;
    }
  }
  
  public u a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public List<String> b(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public t c()
  {
    return this.c;
  }
  
  public ac d()
  {
    return this.d;
  }
  
  public Object e()
  {
    return this.e;
  }
  
  public a f()
  {
    return new a(this);
  }
  
  public d g()
  {
    d locald = this.f;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.c);
    this.f = locald;
    return locald;
  }
  
  public boolean h()
  {
    return this.a.d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public static class a
  {
    u a;
    String b;
    t.a c;
    ac d;
    Object e;
    
    public a()
    {
      this.b = "GET";
      this.c = new t.a();
    }
    
    a(ab paramab)
    {
      this.a = paramab.a;
      this.b = paramab.b;
      this.d = paramab.d;
      this.e = paramab.e;
      this.c = paramab.c.c();
    }
    
    public a a()
    {
      return a("GET", null);
    }
    
    public a a(ac paramac)
    {
      return a("POST", paramac);
    }
    
    public a a(d paramd)
    {
      paramd = paramd.toString();
      if (paramd.isEmpty()) {
        return b("Cache-Control");
      }
      return a("Cache-Control", paramd);
    }
    
    public a a(t paramt)
    {
      this.c = paramt.c();
      return this;
    }
    
    public a a(u paramu)
    {
      if (paramu == null) {
        throw new NullPointerException("url == null");
      }
      this.a = paramu;
      return this;
    }
    
    public a a(Object paramObject)
    {
      this.e = paramObject;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = u.g(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return a(paramString);
    }
    
    public a a(String paramString, ac paramac)
    {
      if (paramString == null) {
        throw new NullPointerException("method == null");
      }
      if (paramString.length() == 0) {
        throw new IllegalArgumentException("method.length() == 0");
      }
      if ((paramac != null) && (!f.c(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramac == null) && (f.b(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.b = paramString;
      this.d = paramac;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public a a(URL paramURL)
    {
      if (paramURL == null) {
        throw new NullPointerException("url == null");
      }
      u localu = u.a(paramURL);
      if (localu == null) {
        throw new IllegalArgumentException("unexpected url: " + paramURL);
      }
      return a(localu);
    }
    
    public a b()
    {
      return a("HEAD", null);
    }
    
    public a b(ac paramac)
    {
      return a("DELETE", paramac);
    }
    
    public a b(String paramString)
    {
      this.c.c(paramString);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }
    
    public a c()
    {
      return b(c.d);
    }
    
    public a c(ac paramac)
    {
      return a("PUT", paramac);
    }
    
    public a d(ac paramac)
    {
      return a("PATCH", paramac);
    }
    
    public ab d()
    {
      if (this.a == null) {
        throw new IllegalStateException("url == null");
      }
      return new ab(this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */