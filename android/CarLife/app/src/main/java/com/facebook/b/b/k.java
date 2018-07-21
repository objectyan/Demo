package com.facebook.b.b;

import com.facebook.common.internal.VisibleForTesting;

public class k
  implements i
{
  private final float a;
  private final float b;
  
  public k(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  @VisibleForTesting
  float a(d.c paramc, long paramLong)
  {
    long l1 = paramc.b();
    long l2 = paramc.d();
    return this.a * (float)(paramLong - l1) + this.b * (float)l2;
  }
  
  public h a()
  {
    new h()
    {
      long a = System.currentTimeMillis();
      
      public int a(d.c paramAnonymousc1, d.c paramAnonymousc2)
      {
        float f1 = k.this.a(paramAnonymousc1, this.a);
        float f2 = k.this.a(paramAnonymousc2, this.a);
        if (f1 < f2) {
          return 1;
        }
        if (f2 == f1) {
          return 0;
        }
        return -1;
      }
    };
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/b/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */