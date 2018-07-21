package com.baidu.carlife.c.e;

import com.baidu.carlife.c.f.a.a;

public abstract class a<T>
  implements a.a<T>
{
  private com.baidu.carlife.c.b.a a;
  private com.baidu.carlife.c.f.b.a b;
  private int c;
  private T d;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(com.baidu.carlife.c.b.a parama)
  {
    this.a = parama;
  }
  
  public void a(com.baidu.carlife.c.f.b.a parama)
  {
    this.b = parama;
  }
  
  public void a(T paramT)
  {
    this.d = paramT;
    b(paramT);
  }
  
  public com.baidu.carlife.c.b.a b()
  {
    return this.a;
  }
  
  protected abstract void b(T paramT);
  
  public com.baidu.carlife.c.f.b.a c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public T e()
  {
    return (T)this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */