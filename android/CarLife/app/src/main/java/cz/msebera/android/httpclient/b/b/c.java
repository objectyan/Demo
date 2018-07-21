package cz.msebera.android.httpclient.b.b;

import cz.msebera.android.httpclient.r;
import java.net.InetAddress;
import java.util.Collection;

public class c
  implements Cloneable
{
  public static final c a = new a().a();
  private final boolean b;
  private final r c;
  private final InetAddress d;
  private final boolean e;
  private final String f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final int j;
  private final boolean k;
  private final Collection<String> l;
  private final Collection<String> m;
  private final int n;
  private final int o;
  private final int p;
  
  c(boolean paramBoolean1, r paramr, InetAddress paramInetAddress, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, boolean paramBoolean6, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramBoolean1;
    this.c = paramr;
    this.d = paramInetAddress;
    this.e = paramBoolean2;
    this.f = paramString;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
    this.i = paramBoolean5;
    this.j = paramInt1;
    this.k = paramBoolean6;
    this.l = paramCollection1;
    this.m = paramCollection2;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
  }
  
  public static a a(c paramc)
  {
    return new a().a(paramc.a()).a(paramc.b()).a(paramc.c()).b(paramc.d()).a(paramc.e()).c(paramc.f()).d(paramc.g()).e(paramc.h()).a(paramc.i()).f(paramc.j()).a(paramc.k()).b(paramc.l()).b(paramc.m()).c(paramc.n()).d(paramc.o());
  }
  
  public static a q()
  {
    return new a();
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public r b()
  {
    return this.c;
  }
  
  public InetAddress c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public Collection<String> k()
  {
    return this.l;
  }
  
  public Collection<String> l()
  {
    return this.m;
  }
  
  public int m()
  {
    return this.n;
  }
  
  public int n()
  {
    return this.o;
  }
  
  public int o()
  {
    return this.p;
  }
  
  protected c p()
    throws CloneNotSupportedException
  {
    return (c)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", expectContinueEnabled=").append(this.b);
    localStringBuilder.append(", proxy=").append(this.c);
    localStringBuilder.append(", localAddress=").append(this.d);
    localStringBuilder.append(", staleConnectionCheckEnabled=").append(this.e);
    localStringBuilder.append(", cookieSpec=").append(this.f);
    localStringBuilder.append(", redirectsEnabled=").append(this.g);
    localStringBuilder.append(", relativeRedirectsAllowed=").append(this.h);
    localStringBuilder.append(", maxRedirects=").append(this.j);
    localStringBuilder.append(", circularRedirectsAllowed=").append(this.i);
    localStringBuilder.append(", authenticationEnabled=").append(this.k);
    localStringBuilder.append(", targetPreferredAuthSchemes=").append(this.l);
    localStringBuilder.append(", proxyPreferredAuthSchemes=").append(this.m);
    localStringBuilder.append(", connectionRequestTimeout=").append(this.n);
    localStringBuilder.append(", connectTimeout=").append(this.o);
    localStringBuilder.append(", socketTimeout=").append(this.p);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private boolean a;
    private r b;
    private InetAddress c;
    private boolean d = true;
    private String e;
    private boolean f = true;
    private boolean g = true;
    private boolean h;
    private int i = 50;
    private boolean j = true;
    private Collection<String> k;
    private Collection<String> l;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    
    public a a(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
    
    public a a(r paramr)
    {
      this.b = paramr;
      return this;
    }
    
    public a a(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a a(InetAddress paramInetAddress)
    {
      this.c = paramInetAddress;
      return this;
    }
    
    public a a(Collection<String> paramCollection)
    {
      this.k = paramCollection;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }
    
    public c a()
    {
      return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
    
    public a b(int paramInt)
    {
      this.m = paramInt;
      return this;
    }
    
    public a b(Collection<String> paramCollection)
    {
      this.l = paramCollection;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.n = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.o = paramInt;
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
    
    public a f(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */