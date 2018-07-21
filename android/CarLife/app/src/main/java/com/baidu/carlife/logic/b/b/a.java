package com.baidu.carlife.logic.b.b;

import com.baidu.carlife.c.d.c;

public class a
  implements com.baidu.carlife.c.c.a
{
  private c<Integer> a;
  private c<String> b;
  private c<String> c;
  private c<Boolean> d;
  private c<Boolean> e;
  
  public c<Integer> a()
  {
    return this.a;
  }
  
  public void a(c<Integer> paramc)
  {
    this.a = paramc;
  }
  
  public c<Boolean> b()
  {
    return this.d;
  }
  
  public void b(c<Boolean> paramc)
  {
    this.d = paramc;
  }
  
  public c<Boolean> c()
  {
    return this.e;
  }
  
  public void c(c<Boolean> paramc)
  {
    this.e = paramc;
  }
  
  public c<String> d()
  {
    return this.b;
  }
  
  public void d(c<String> paramc)
  {
    this.b = paramc;
  }
  
  public c<String> e()
  {
    return this.c;
  }
  
  public void e(c<String> paramc)
  {
    this.c = paramc;
  }
  
  public static final class a
  {
    private c<Integer> a;
    private c<String> b;
    private c<String> c;
    private c<Boolean> d;
    private c<Boolean> e;
    
    public static a a()
    {
      return new a();
    }
    
    public a a(c<Integer> paramc)
    {
      this.a = paramc;
      return this;
    }
    
    public a b()
    {
      return a().a(this.a).b(this.b).c(this.c).d(this.d).e(this.e);
    }
    
    public a b(c<String> paramc)
    {
      this.b = paramc;
      return this;
    }
    
    public a c(c<String> paramc)
    {
      this.c = paramc;
      return this;
    }
    
    public a c()
    {
      a locala = new a();
      locala.a(this.a);
      locala.d(this.b);
      locala.e(this.c);
      locala.b(this.d);
      locala.c(this.e);
      return locala;
    }
    
    public a d(c<Boolean> paramc)
    {
      this.d = paramc;
      return this;
    }
    
    public a e(c<Boolean> paramc)
    {
      this.e = paramc;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */