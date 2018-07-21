package com.indooratlas.android.sdk._internal;

public final class gm
{
  public final gk a;
  final gi b;
  public final int c;
  final String d;
  public final gc e;
  public final gd f;
  public final gn g;
  gm h;
  gm i;
  final gm j;
  private volatile fq k;
  
  private gm(a parama)
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
  }
  
  public final gk a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    paramString = this.f.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final boolean c()
  {
    return (this.c >= 200) && (this.c < 300);
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final gd e()
  {
    return this.f;
  }
  
  public final gn f()
  {
    return this.g;
  }
  
  public final a g()
  {
    return new a(this, (byte)0);
  }
  
  public final fq h()
  {
    fq localfq = this.k;
    if (localfq != null) {
      return localfq;
    }
    localfq = fq.a(this.f);
    this.k = localfq;
    return localfq;
  }
  
  public final String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a + '}';
  }
  
  public static final class a
  {
    public gk a;
    public gi b;
    public int c = -1;
    public String d;
    public gc e;
    gd.a f;
    public gn g;
    gm h;
    gm i;
    gm j;
    
    public a()
    {
      this.f = new gd.a();
    }
    
    private a(gm paramgm)
    {
      this.a = paramgm.a;
      this.b = paramgm.b;
      this.c = paramgm.c;
      this.d = paramgm.d;
      this.e = paramgm.e;
      this.f = paramgm.f.a();
      this.g = paramgm.g;
      this.h = paramgm.h;
      this.i = paramgm.i;
      this.j = paramgm.j;
    }
    
    private static void a(String paramString, gm paramgm)
    {
      if (paramgm.g != null) {
        throw new IllegalArgumentException(paramString + ".body != null");
      }
      if (paramgm.h != null) {
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      }
      if (paramgm.i != null) {
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      }
      if (paramgm.j != null) {
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
      }
    }
    
    public final a a(gd paramgd)
    {
      this.f = paramgd.a();
      return this;
    }
    
    public final a a(gm paramgm)
    {
      if (paramgm != null) {
        a("networkResponse", paramgm);
      }
      this.h = paramgm;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      this.f.c(paramString1, paramString2);
      return this;
    }
    
    public final gm a()
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
      return new gm(this, (byte)0);
    }
    
    public final a b(gm paramgm)
    {
      if (paramgm != null) {
        a("cacheResponse", paramgm);
      }
      this.i = paramgm;
      return this;
    }
    
    public final a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }
    
    public final a c(gm paramgm)
    {
      if ((paramgm != null) && (paramgm.g != null)) {
        throw new IllegalArgumentException("priorResponse.body != null");
      }
      this.j = paramgm;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */