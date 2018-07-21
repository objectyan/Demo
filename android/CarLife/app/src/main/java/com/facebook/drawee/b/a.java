package com.facebook.drawee.b;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private static a a = null;
  private final Set<a> b = new HashSet();
  private final Handler c = new Handler(Looper.getMainLooper());
  private final Runnable d = new Runnable()
  {
    public void run()
    {
      a.b();
      Iterator localIterator = a.a(a.this).iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).f();
      }
      a.a(a.this).clear();
    }
  };
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private static void c()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      return;
    }
  }
  
  public void a(a parama)
  {
    
    if (!this.b.add(parama)) {}
    while (this.b.size() != 1) {
      return;
    }
    this.c.post(this.d);
  }
  
  public void b(a parama)
  {
    c();
    this.b.remove(parama);
  }
  
  public static abstract interface a
  {
    public abstract void f();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */