package com.facebook.imagepipeline.memory;

import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class k
{
  @VisibleForTesting
  final a a;
  private final com.facebook.common.h.c<byte[]> b;
  
  public k(com.facebook.common.g.c paramc, v paramv)
  {
    if (paramv.g > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.facebook.common.internal.k.a(bool);
      this.a = new a(paramc, paramv, q.a());
      this.b = new com.facebook.common.h.c()
      {
        public void a(byte[] paramAnonymousArrayOfByte)
        {
          k.this.a(paramAnonymousArrayOfByte);
        }
      };
      return;
    }
  }
  
  public a<byte[]> a(int paramInt)
  {
    return a.a(this.a.a(paramInt), this.b);
  }
  
  public Map<String, Integer> a()
  {
    return this.a.f();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte);
  }
  
  public int b()
  {
    return this.a.g();
  }
  
  @VisibleForTesting
  static class a
    extends l
  {
    public a(com.facebook.common.g.c paramc, v paramv, w paramw)
    {
      super(paramv, paramw);
    }
    
    e<byte[]> g(int paramInt)
    {
      return new r(d(paramInt), this.b.g, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */