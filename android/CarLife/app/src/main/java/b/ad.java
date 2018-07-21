package b;

import b.a.d.e;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;

public final class ad
  implements Closeable
{
  final ab a;
  final z b;
  final int c;
  final String d;
  final s e;
  final t f;
  final ae g;
  final ad h;
  final ad i;
  final ad j;
  final long k;
  final long l;
  private volatile d m;
  
  ad(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f.a();
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    this.l = parama.l;
  }
  
  public ab a()
  {
    return this.a;
  }
  
  public ae a(long paramLong)
    throws IOException
  {
    Object localObject = this.g.c();
    ((BufferedSource)localObject).request(paramLong);
    localObject = ((BufferedSource)localObject).buffer().clone();
    if (((Buffer)localObject).size() > paramLong)
    {
      Buffer localBuffer = new Buffer();
      localBuffer.write((Buffer)localObject, paramLong);
      ((Buffer)localObject).clear();
      localObject = localBuffer;
    }
    for (;;)
    {
      return ae.a(this.g.a(), ((Buffer)localObject).size(), (BufferedSource)localObject);
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = this.f.a(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public List<String> a(String paramString)
  {
    return this.f.c(paramString);
  }
  
  public z b()
  {
    return this.b;
  }
  
  public String b(String paramString)
  {
    return a(paramString, null);
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void close()
  {
    this.g.close();
  }
  
  public boolean d()
  {
    return (this.c >= 200) && (this.c < 300);
  }
  
  public String e()
  {
    return this.d;
  }
  
  public s f()
  {
    return this.e;
  }
  
  public t g()
  {
    return this.f;
  }
  
  public ae h()
  {
    return this.g;
  }
  
  public a i()
  {
    return new a(this);
  }
  
  public boolean j()
  {
    switch (this.c)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
  
  public ad k()
  {
    return this.h;
  }
  
  public ad l()
  {
    return this.i;
  }
  
  public ad m()
  {
    return this.j;
  }
  
  public List<h> n()
  {
    if (this.c == 401) {}
    for (String str = "WWW-Authenticate";; str = "Proxy-Authenticate")
    {
      return e.a(g(), str);
      if (this.c != 407) {
        break;
      }
    }
    return Collections.emptyList();
  }
  
  public d o()
  {
    d locald = this.m;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.f);
    this.m = locald;
    return locald;
  }
  
  public long p()
  {
    return this.k;
  }
  
  public long q()
  {
    return this.l;
  }
  
  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
  }
  
  public static class a
  {
    ab a;
    z b;
    int c = -1;
    String d;
    s e;
    t.a f;
    ae g;
    ad h;
    ad i;
    ad j;
    long k;
    long l;
    
    public a()
    {
      this.f = new t.a();
    }
    
    a(ad paramad)
    {
      this.a = paramad.a;
      this.b = paramad.b;
      this.c = paramad.c;
      this.d = paramad.d;
      this.e = paramad.e;
      this.f = paramad.f.c();
      this.g = paramad.g;
      this.h = paramad.h;
      this.i = paramad.i;
      this.j = paramad.j;
      this.k = paramad.k;
      this.l = paramad.l;
    }
    
    private void a(String paramString, ad paramad)
    {
      if (paramad.g != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (paramad.h != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (paramad.i != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (paramad.j != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    private void d(ad paramad)
    {
      if (paramad.g != null) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.k = paramLong;
      return this;
    }
    
    public a a(ab paramab)
    {
      this.a = paramab;
      return this;
    }
    
    public a a(ad paramad)
    {
      if (paramad != null) {
        a("networkResponse", paramad);
      }
      this.h = paramad;
      return this;
    }
    
    public a a(ae paramae)
    {
      this.g = paramae;
      return this;
    }
    
    public a a(s params)
    {
      this.e = params;
      return this;
    }
    
    public a a(t paramt)
    {
      this.f = paramt.c();
      return this;
    }
    
    public a a(z paramz)
    {
      this.b = paramz;
      return this;
    }
    
    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.f.c(paramString1, paramString2);
      return this;
    }
    
    public ad a()
    {
      if (this.a == null) {
        throw new IllegalStateException("request == null");
      }
      if (this.b == null) {
        throw new IllegalStateException("protocol == null");
      }
      if (this.c < 0) {
        throw new IllegalStateException("code < 0: " + this.c);
      }
      return new ad(this);
    }
    
    public a b(long paramLong)
    {
      this.l = paramLong;
      return this;
    }
    
    public a b(ad paramad)
    {
      if (paramad != null) {
        a("cacheResponse", paramad);
      }
      this.i = paramad;
      return this;
    }
    
    public a b(String paramString)
    {
      this.f.c(paramString);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public a c(ad paramad)
    {
      if (paramad != null) {
        d(paramad);
      }
      this.j = paramad;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */