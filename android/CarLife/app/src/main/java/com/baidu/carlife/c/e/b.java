package com.baidu.carlife.c.e;

import com.baidu.carlife.c.c.a;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.c.f.b.a;
import com.baidu.carlife.c.f.b.b;
import java.util.Observable;
import java.util.Observer;

public abstract class b<T extends a>
  implements b.a<T>, Observer
{
  private com.baidu.carlife.c.b.b<T> a;
  private b.b b;
  
  public T a(int paramInt)
  {
    return (a)this.a.b(paramInt);
  }
  
  public void a()
  {
    this.a.b();
  }
  
  public void a(int paramInt, T paramT)
  {
    this.a.a(paramInt, paramT);
  }
  
  public void a(com.baidu.carlife.c.b.b<T> paramb)
  {
    this.a = paramb;
  }
  
  public void a(b.b paramb)
  {
    this.b = paramb;
  }
  
  public int b(int paramInt)
  {
    return ((Integer)((a)this.a.b(paramInt)).a().b()).intValue();
  }
  
  public com.baidu.carlife.c.b.b<T> b()
  {
    return this.a;
  }
  
  public b.b c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.a.a();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.b.a(paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */