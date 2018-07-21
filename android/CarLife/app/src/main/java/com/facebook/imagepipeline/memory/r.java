package com.facebook.imagepipeline.memory;

import com.facebook.common.h.b;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class r<V>
  extends e<V>
{
  private LinkedList<b<V>> d = new LinkedList();
  
  public r(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  void b(V paramV)
  {
    b localb2 = (b)this.d.poll();
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new b();
    }
    localb1.a(paramV);
    this.c.add(localb1);
  }
  
  public V d()
  {
    b localb = (b)this.c.poll();
    Object localObject = localb.a();
    localb.b();
    this.d.add(localb);
    return (V)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */