package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.b.c;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.k.b;
import cz.msebera.android.httpclient.k.s;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@NotThreadSafe
public class r
{
  private String a;
  private ak b;
  private URI c;
  private s d;
  private cz.msebera.android.httpclient.n e;
  private LinkedList<ag> f;
  private c g;
  
  r()
  {
    this(null);
  }
  
  r(String paramString)
  {
    this.a = paramString;
  }
  
  public static r a()
  {
    return new r("GET");
  }
  
  public static r a(u paramu)
  {
    a.a(paramu, "HTTP request");
    return new r().b(paramu);
  }
  
  public static r a(String paramString)
  {
    a.b(paramString, "HTTP method");
    return new r(paramString);
  }
  
  public static r b()
  {
    return new r("HEAD");
  }
  
  private r b(u paramu)
  {
    if (paramu == null) {
      return this;
    }
    this.a = paramu.getRequestLine().a();
    this.b = paramu.getRequestLine().b();
    if ((paramu instanceof q))
    {
      this.c = ((q)paramu).getURI();
      if (this.d == null) {
        this.d = new s();
      }
      this.d.a();
      this.d.a(paramu.getAllHeaders());
      if (!(paramu instanceof o)) {
        break label162;
      }
      this.e = ((o)paramu).getEntity();
      label114:
      if (!(paramu instanceof d)) {
        break label170;
      }
    }
    label162:
    label170:
    for (this.g = ((d)paramu).getConfig();; this.g = null)
    {
      this.f = null;
      return this;
      this.c = URI.create(paramu.getRequestLine().c());
      break;
      this.e = null;
      break label114;
    }
  }
  
  public static r c()
  {
    return new r("POST");
  }
  
  public static r d()
  {
    return new r("PUT");
  }
  
  public static r e()
  {
    return new r("DELETE");
  }
  
  public static r f()
  {
    return new r("TRACE");
  }
  
  public static r g()
  {
    return new r("OPTIONS");
  }
  
  public r a(ag paramag)
  {
    a.a(paramag, "Name value pair");
    if (this.f == null) {
      this.f = new LinkedList();
    }
    this.f.add(paramag);
    return this;
  }
  
  public r a(ak paramak)
  {
    this.b = paramak;
    return this;
  }
  
  public r a(c paramc)
  {
    this.g = paramc;
    return this;
  }
  
  public r a(cz.msebera.android.httpclient.f paramf)
  {
    if (this.d == null) {
      this.d = new s();
    }
    this.d.a(paramf);
    return this;
  }
  
  public r a(cz.msebera.android.httpclient.n paramn)
  {
    this.e = paramn;
    return this;
  }
  
  public r a(String paramString1, String paramString2)
  {
    if (this.d == null) {
      this.d = new s();
    }
    this.d.a(new b(paramString1, paramString2));
    return this;
  }
  
  public r a(URI paramURI)
  {
    this.c = paramURI;
    return this;
  }
  
  public r a(ag... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      a(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public r b(cz.msebera.android.httpclient.f paramf)
  {
    if (this.d == null) {
      this.d = new s();
    }
    this.d.b(paramf);
    return this;
  }
  
  public r b(String paramString)
  {
    if (paramString != null) {}
    for (paramString = URI.create(paramString);; paramString = null)
    {
      this.c = paramString;
      return this;
    }
  }
  
  public r b(String paramString1, String paramString2)
  {
    if (this.d == null) {
      this.d = new s();
    }
    this.d.c(new b(paramString1, paramString2));
    return this;
  }
  
  public r c(cz.msebera.android.httpclient.f paramf)
  {
    if (this.d == null) {
      this.d = new s();
    }
    this.d.c(paramf);
    return this;
  }
  
  public r c(String paramString1, String paramString2)
  {
    return a(new cz.msebera.android.httpclient.k.n(paramString1, paramString2));
  }
  
  public cz.msebera.android.httpclient.f c(String paramString)
  {
    if (this.d != null) {
      return this.d.c(paramString);
    }
    return null;
  }
  
  public cz.msebera.android.httpclient.f d(String paramString)
  {
    if (this.d != null) {
      return this.d.d(paramString);
    }
    return null;
  }
  
  public cz.msebera.android.httpclient.f[] e(String paramString)
  {
    if (this.d != null) {
      return this.d.b(paramString);
    }
    return null;
  }
  
  public r f(String paramString)
  {
    if ((paramString == null) || (this.d == null)) {}
    for (;;)
    {
      return this;
      i locali = this.d.c();
      while (locali.hasNext()) {
        if (paramString.equalsIgnoreCase(locali.a().c())) {
          locali.remove();
        }
      }
    }
  }
  
  public String h()
  {
    return this.a;
  }
  
  public ak i()
  {
    return this.b;
  }
  
  public URI j()
  {
    return this.c;
  }
  
  public cz.msebera.android.httpclient.n k()
  {
    return this.e;
  }
  
  public List<ag> l()
  {
    if (this.f != null) {
      return new ArrayList(this.f);
    }
    return new ArrayList();
  }
  
  public c m()
  {
    return this.g;
  }
  
  public q n()
  {
    Object localObject1;
    cz.msebera.android.httpclient.n localn;
    Object localObject4;
    Object localObject2;
    if (this.c != null)
    {
      localObject1 = this.c;
      localn = this.e;
      localObject4 = localn;
      localObject2 = localObject1;
      if (this.f != null)
      {
        localObject4 = localn;
        localObject2 = localObject1;
        if (!this.f.isEmpty())
        {
          if ((localn != null) || ((!"POST".equalsIgnoreCase(this.a)) && (!"PUT".equalsIgnoreCase(this.a)))) {
            break label157;
          }
          localObject4 = new cz.msebera.android.httpclient.b.c.h(this.f, cz.msebera.android.httpclient.n.f.t);
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      if (localObject4 == null) {
        localObject1 = new b(this.a);
      }
      for (;;)
      {
        ((n)localObject1).setProtocolVersion(this.b);
        ((n)localObject1).setURI((URI)localObject2);
        if (this.d != null) {
          ((n)localObject1).setHeaders(this.d.b());
        }
        ((n)localObject1).setConfig(this.g);
        return (q)localObject1;
        localObject1 = URI.create("/");
        break;
        try
        {
          label157:
          localObject2 = new cz.msebera.android.httpclient.b.g.h((URI)localObject1).b(this.f).a();
          localObject4 = localn;
        }
        catch (URISyntaxException localURISyntaxException)
        {
          localObject4 = localn;
          Object localObject3 = localObject1;
        }
        localObject1 = new a(this.a);
        ((a)localObject1).setEntity((cz.msebera.android.httpclient.n)localObject4);
      }
    }
  }
  
  static class a
    extends f
  {
    private final String a;
    
    a(String paramString)
    {
      this.a = paramString;
    }
    
    public String getMethod()
    {
      return this.a;
    }
  }
  
  static class b
    extends n
  {
    private final String a;
    
    b(String paramString)
    {
      this.a = paramString;
    }
    
    public String getMethod()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */