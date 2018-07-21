package com.baidu.carlife.c.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class a<T extends com.baidu.carlife.c.c.a>
  extends Observable
  implements b<T>
{
  private List<T> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public T a(int paramInt)
  {
    return (com.baidu.carlife.c.c.a)this.a.get(paramInt);
  }
  
  public void a(int paramInt, T paramT)
  {
    this.a.set(paramInt, paramT);
    notifyObservers(paramT);
  }
  
  public void b()
  {
    com.baidu.carlife.c.g.b.a().c(new Runnable()
    {
      public void run()
      {
        a.a(a.this, a.this.c());
        com.baidu.carlife.c.g.b.a().a(new Runnable()
        {
          public void run()
          {
            a.this.notifyObservers();
          }
        });
      }
    });
  }
  
  public abstract List<T> c();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */