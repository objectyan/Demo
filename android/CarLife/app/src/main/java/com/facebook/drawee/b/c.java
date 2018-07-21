package com.facebook.drawee.b;

public class c
{
  private static final int a = 4;
  private boolean b;
  private int c;
  private int d;
  
  public c()
  {
    b();
  }
  
  public static c a()
  {
    return new c();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    this.b = false;
    this.c = 4;
    c();
  }
  
  public void c()
  {
    this.d = 0;
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return (this.b) && (this.d < this.c);
  }
  
  public void f()
  {
    this.d += 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */