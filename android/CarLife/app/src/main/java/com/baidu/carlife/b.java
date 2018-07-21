package com.baidu.carlife;

import android.content.Intent;
import android.content.res.Configuration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b
{
  private static b c = new b();
  private boolean a;
  private List<c> b = new CopyOnWriteArrayList();
  
  public static b a()
  {
    return c;
  }
  
  public void a(Intent paramIntent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void a(c paramc)
  {
    if (paramc == null) {}
    while (this.b.contains(paramc)) {
      return;
    }
    this.b.add(paramc);
  }
  
  public void b()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).e();
    }
  }
  
  public void b(c paramc)
  {
    if (this.b.contains(paramc)) {
      this.b.remove(paramc);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).c();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).b();
    }
  }
  
  public void g()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).f();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */