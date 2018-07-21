package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
class e<V>
{
  public final int a;
  public final int b;
  final Queue c;
  private int d;
  
  public e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      k.b(bool1);
      if (paramInt2 < 0) {
        break label77;
      }
      bool1 = true;
      label26:
      k.b(bool1);
      if (paramInt3 < 0) {
        break label83;
      }
    }
    label77:
    label83:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k.b(bool1);
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new LinkedList();
      this.d = paramInt3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
    }
  }
  
  public void a(V paramV)
  {
    k.a(paramV);
    if (this.d > 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      this.d -= 1;
      b(paramV);
      return;
    }
  }
  
  public boolean a()
  {
    return this.d + b() > this.b;
  }
  
  int b()
  {
    return this.c.size();
  }
  
  void b(V paramV)
  {
    this.c.add(paramV);
  }
  
  @Nullable
  public V c()
  {
    Object localObject = d();
    if (localObject != null) {
      this.d += 1;
    }
    return (V)localObject;
  }
  
  @Nullable
  public V d()
  {
    return (V)this.c.poll();
  }
  
  public void e()
  {
    this.d += 1;
  }
  
  public void f()
  {
    if (this.d > 0) {}
    for (boolean bool = true;; bool = false)
    {
      k.b(bool);
      this.d -= 1;
      return;
    }
  }
  
  public int g()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */