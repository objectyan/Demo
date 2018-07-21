package com.baidu.carlife.c.d.a;

import android.app.Application;
import android.support.annotation.NonNull;
import com.baidu.carlife.c.d.a;
import com.baidu.carlife.c.d.c;
import com.baidu.carlife.c.f;
import java.util.List;

public abstract class a<T>
  extends com.baidu.carlife.c.d.a
{
  private c<List<T>> a = new c();
  
  public a(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private boolean f()
  {
    return (this.a == null) || (this.a.b() == null) || (((List)this.a.b()).isEmpty());
  }
  
  public T a(int paramInt)
  {
    if (f()) {
      throw new IllegalStateException("data unavailable");
    }
    return (T)((List)this.a.b()).get(paramInt);
  }
  
  public void a(com.baidu.carlife.c.d.d<List<T>> paramd)
  {
    this.a.a(paramd);
  }
  
  public void a(T paramT)
  {
    if (f()) {
      return;
    }
    List localList = (List)this.a.b();
    localList.remove(paramT);
    this.a.b(localList);
  }
  
  public void a(T paramT, int paramInt)
  {
    if (f()) {}
    List localList;
    do
    {
      return;
      localList = (List)this.a.b();
    } while (paramInt >= localList.size());
    localList.set(paramInt, paramT);
    this.a.b(localList);
  }
  
  public void b(int paramInt)
  {
    if (f()) {}
    List localList;
    do
    {
      return;
      localList = (List)this.a.b();
    } while (paramInt >= localList.size());
    localList.remove(paramInt);
    this.a.b(localList);
  }
  
  public void b(com.baidu.carlife.c.d.d<List<T>> paramd)
  {
    this.a.b(paramd);
  }
  
  public void c()
  {
    f.a().a(new com.baidu.carlife.c.d()
    {
      public void a(Void paramAnonymousVoid)
      {
        paramAnonymousVoid = a.this.e();
        if (paramAnonymousVoid == null)
        {
          a().a();
          return;
        }
        a().a(paramAnonymousVoid);
      }
    }, null, new d.a()
    {
      public void a() {}
      
      public void a(List<T> paramAnonymousList)
      {
        a.a(a.this).b(paramAnonymousList);
      }
      
      public void b() {}
    });
  }
  
  public int d()
  {
    if (f()) {
      return 0;
    }
    return ((List)this.a.b()).size();
  }
  
  protected abstract List<T> e();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */