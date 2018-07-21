package com.baidu.android.pushservice.h;

import android.text.TextUtils;

public class e
{
  public String a;
  public int b;
  public int c;
  private int d;
  private String e;
  private long f;
  private String g;
  private int h;
  private String i;
  private int j;
  private String k;
  private String l;
  private int m;
  private int n;
  private String o;
  private String p;
  private String q;
  private String r;
  
  public String a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.f = paramLong;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.r;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public n c()
  {
    return new n(this.e, this.f, this.g, this.n, this.o);
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void c(String paramString)
  {
    this.i = paramString;
  }
  
  public i d()
  {
    i locali = new i(c());
    locali.a = this.m;
    locali.i = this.k;
    locali.b = this.i;
    locali.c = this.q;
    return locali;
  }
  
  public void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public k e()
  {
    k localk = new k(c());
    localk.c = this.h;
    localk.a = this.i;
    localk.b = this.j;
    String str = this.q;
    if (!TextUtils.isEmpty(str)) {
      localk.k = str;
    }
    return localk;
  }
  
  public void e(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void e(String paramString)
  {
    this.l = paramString;
  }
  
  public b f()
  {
    b localb = new b(c());
    localb.a = this.k;
    localb.b = this.l;
    localb.c = this.p;
    return localb;
  }
  
  public void f(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void f(String paramString)
  {
    this.o = paramString;
  }
  
  public f g()
  {
    f localf = new f(c());
    localf.a = this.k;
    return localf;
  }
  
  public void g(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void g(String paramString)
  {
    this.p = paramString;
  }
  
  public h h()
  {
    h localh = new h(c());
    localh.j = this.r;
    localh.a = this.a;
    localh.b = this.b;
    localh.c = this.c;
    return localh;
  }
  
  public void h(String paramString)
  {
    this.r = paramString;
  }
  
  public void i(String paramString)
  {
    this.q = paramString;
  }
  
  public void j(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */