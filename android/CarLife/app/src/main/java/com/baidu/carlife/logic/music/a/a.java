package com.baidu.carlife.logic.music.a;

import com.baidu.carlife.c.d.c;

public class a
  implements com.baidu.carlife.c.c.a
{
  private c<Integer> a;
  private c<String> b;
  private c<String> c;
  private c<Integer> d;
  private c<Integer> e;
  
  public c<Integer> a()
  {
    return this.a;
  }
  
  public void a(c<Integer> paramc)
  {
    this.a = paramc;
  }
  
  public c<String> b()
  {
    return this.b;
  }
  
  public void b(c<String> paramc)
  {
    this.b = paramc;
  }
  
  public c<String> c()
  {
    return this.c;
  }
  
  public void c(c<String> paramc)
  {
    this.c = paramc;
  }
  
  public c<Integer> d()
  {
    return this.d;
  }
  
  public void d(c<Integer> paramc)
  {
    this.d = paramc;
  }
  
  public c<Integer> e()
  {
    return this.e;
  }
  
  public void e(c<Integer> paramc)
  {
    this.e = paramc;
  }
  
  public static final class a
  {
    private c<Integer> a;
    private c<String> b;
    private c<String> c;
    private c<Integer> d;
    private c<Integer> e;
    
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
      locala.b(this.b);
      locala.c(this.c);
      locala.d(this.d);
      locala.e(this.e);
      return locala;
    }
    
    public a d(c<Integer> paramc)
    {
      this.d = paramc;
      return this;
    }
    
    public a e(c<Integer> paramc)
    {
      this.e = paramc;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/music/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */