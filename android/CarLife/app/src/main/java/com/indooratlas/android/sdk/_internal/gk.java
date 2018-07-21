package com.indooratlas.android.sdk._internal;

import java.net.URL;

public final class gk
{
  public final ge a;
  public final String b;
  public final gd c;
  public final gl d;
  final Object e;
  private volatile fq f;
  
  private gk(a parama)
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
  
  public final ge a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final gd c()
  {
    return this.c;
  }
  
  public final gl d()
  {
    return this.d;
  }
  
  public final a e()
  {
    return new a(this, (byte)0);
  }
  
  public final fq f()
  {
    fq localfq = this.f;
    if (localfq != null) {
      return localfq;
    }
    localfq = fq.a(this.c);
    this.f = localfq;
    return localfq;
  }
  
  public final boolean g()
  {
    return this.a.a.equals("https");
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public static final class a
  {
    ge a;
    String b;
    gd.a c;
    gl d;
    Object e;
    
    public a()
    {
      this.b = "GET";
      this.c = new gd.a();
    }
    
    private a(gk paramgk)
    {
      this.a = paramgk.a;
      this.b = paramgk.b;
      this.d = paramgk.d;
      this.e = paramgk.e;
      this.c = paramgk.c.a();
    }
    
    public final a a(ge paramge)
    {
      if (paramge == null) {
        throw new IllegalArgumentException("url == null");
      }
      this.a = paramge;
      return this;
    }
    
    public final a a(gl paramgl)
    {
      return a("PUT", paramgl);
    }
    
    public final a a(Object paramObject)
    {
      this.e = paramObject;
      return this;
    }
    
    public final a a(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = ge.d(str);
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
    
    public final a a(String paramString, gl paramgl)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((paramgl != null) && (!hw.b(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramgl == null) && (hw.a(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.b = paramString;
      this.d = paramgl;
      return this;
    }
    
    public final a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public final a a(URL paramURL)
    {
      ge localge = ge.a(paramURL);
      if (localge == null) {
        throw new IllegalArgumentException("unexpected url: " + paramURL);
      }
      return a(localge);
    }
    
    public final gk a()
    {
      if (this.a == null) {
        throw new IllegalStateException("url == null");
      }
      return new gk(this, (byte)0);
    }
    
    public final a b(String paramString)
    {
      this.c.a(paramString);
      return this;
    }
    
    public final a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */