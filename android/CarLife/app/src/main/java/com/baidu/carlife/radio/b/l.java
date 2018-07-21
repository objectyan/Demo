package com.baidu.carlife.radio.b;

public class l
{
  private String a;
  private String b;
  private u c;
  private String d;
  private String e;
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public u d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public static final class a
  {
    private String a;
    private String b;
    private u c;
    private String d;
    private String e;
    
    public static a a()
    {
      return new a();
    }
    
    public a a(u paramu)
    {
      this.c = paramu;
      return this;
    }
    
    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public a b()
    {
      return a().b(this.b).a(this.c).c(this.d).d(this.e);
    }
    
    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public l c()
    {
      l locall = new l(null);
      l.a(locall, this.a);
      l.b(locall, this.e);
      l.a(locall, this.c);
      l.c(locall, this.d);
      l.d(locall, this.b);
      return locall;
    }
    
    public a d(String paramString)
    {
      this.e = paramString;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */