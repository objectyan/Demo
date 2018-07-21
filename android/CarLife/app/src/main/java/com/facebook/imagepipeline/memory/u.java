package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class u
{
  private final t a;
  private d b;
  private k c;
  private m d;
  private z e;
  private ac f;
  private ad g;
  private f h;
  
  public u(t paramt)
  {
    this.a = ((t)com.facebook.common.internal.k.a(paramt));
  }
  
  public d a()
  {
    if (this.b == null) {
      this.b = new d(this.a.c(), this.a.a(), this.a.b());
    }
    return this.b;
  }
  
  public k b()
  {
    if (this.c == null) {
      this.c = new k(this.a.c(), this.a.f());
    }
    return this.c;
  }
  
  public int c()
  {
    return this.a.f().g;
  }
  
  public m d()
  {
    if (this.d == null) {
      this.d = new m(this.a.c(), this.a.d(), this.a.e());
    }
    return this.d;
  }
  
  public z e()
  {
    if (this.e == null) {
      this.e = new o(d(), f());
    }
    return this.e;
  }
  
  public ac f()
  {
    if (this.f == null) {
      this.f = new ac(h());
    }
    return this.f;
  }
  
  public ad g()
  {
    if (this.g == null) {
      this.g = new ad(this.a.c(), this.a.f());
    }
    return this.g;
  }
  
  public f h()
  {
    if (this.h == null) {
      this.h = new l(this.a.c(), this.a.g(), this.a.h());
    }
    return this.h;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */