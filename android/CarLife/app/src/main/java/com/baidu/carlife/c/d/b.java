package com.baidu.carlife.c.d;

import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class b<T>
{
  static final int a = -1;
  private static final Object c = new Object();
  private final Object b = new Object();
  private e<d<T>, b<T>.a> d = new e();
  private volatile Object e = c;
  private volatile Object f = c;
  private int g = -1;
  private boolean h;
  private boolean i;
  private final Runnable j = new Runnable()
  {
    public void run()
    {
      synchronized (b.a(b.this))
      {
        Object localObject2 = b.b(b.this);
        b.a(b.this, b.e());
        b.this.b(localObject2);
        return;
      }
    }
  };
  
  private void a(b<T>.a paramb)
  {
    if (paramb.a >= this.g) {
      return;
    }
    paramb.a = this.g;
    paramb.b.a(this.e);
  }
  
  private void a(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable b<T>.a paramb)
  {
    if (this.h)
    {
      this.i = true;
      return;
    }
    this.h = true;
    this.i = false;
    b<T>.a localb;
    if (paramb != null)
    {
      a(paramb);
      localb = null;
    }
    for (;;)
    {
      paramb = localb;
      if (this.i) {
        break;
      }
      this.h = false;
      return;
      e.d locald = this.d.c();
      do
      {
        localb = paramb;
        if (!locald.hasNext()) {
          break;
        }
        a((a)((Map.Entry)locald.next()).getValue());
      } while (!this.i);
      localb = paramb;
    }
  }
  
  @MainThread
  public void a()
  {
    a("removeObservers");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      b((d)((Map.Entry)localIterator.next()).getKey());
    }
  }
  
  @MainThread
  public void a(@NonNull d<T> paramd)
  {
    a locala = new a(paramd);
    this.d.a(paramd, locala);
  }
  
  protected void a(T paramT)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.f != c) {
          break label47;
        }
        k = 1;
        this.f = paramT;
        if (k == 0) {
          return;
        }
      }
      com.baidu.carlife.c.g.b.a().a(this.j);
      return;
      label47:
      int k = 0;
    }
  }
  
  @Nullable
  public T b()
  {
    Object localObject = this.e;
    if (localObject != c) {
      return (T)localObject;
    }
    return null;
  }
  
  @MainThread
  public void b(@NonNull d<T> paramd)
  {
    a("removeObserver");
    this.d.b(paramd);
  }
  
  protected void b(T paramT)
  {
    this.g += 1;
    this.e = paramT;
    com.baidu.carlife.c.g.b.a().a(new Runnable()
    {
      public void run()
      {
        b.a(b.this, null);
      }
    });
  }
  
  int c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.d.a() > 0;
  }
  
  private final class a
  {
    public int a = -1;
    public final d<T> b;
    
    a()
    {
      d locald;
      this.b = locald;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */