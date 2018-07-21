package com.tencent.wxop.stat;

public class g
  implements Cloneable
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public g() {}
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.c = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public g d()
  {
    try
    {
      g localg = (g)super.clone();
      return localg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    return "StatGameUser [worldName=" + this.a + ", account=" + this.b + ", level=" + this.c + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */