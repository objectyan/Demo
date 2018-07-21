package com.baidu.che.codriver.sdk.a;

import com.baidu.che.codriver.util.h;

public class e
{
  private a a;
  
  public static e a()
  {
    return b.a();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.b("CdMediaManager", "param:" + paramString1 + ";data:" + paramString2);
    l.a().a("media.tool", paramString1, paramString2);
  }
  
  public a b()
  {
    return this.a;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void b(String paramString);
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
    
    public abstract void g();
    
    public abstract void h();
    
    public abstract void i();
    
    public abstract void j();
  }
  
  private static class b
  {
    private static e a = new e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */