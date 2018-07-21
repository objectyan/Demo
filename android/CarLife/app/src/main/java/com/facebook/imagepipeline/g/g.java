package com.facebook.imagepipeline.g;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class g<T>
  extends com.facebook.c.a<com.facebook.common.h.a<T>>
{
  public static <V> g<V> j()
  {
    return new g();
  }
  
  public boolean a(float paramFloat)
  {
    return super.a(paramFloat);
  }
  
  public boolean a(@Nullable com.facebook.common.h.a<T> parama)
  {
    return super.a(com.facebook.common.h.a.b(parama), true);
  }
  
  protected void b(@Nullable com.facebook.common.h.a<T> parama)
  {
    com.facebook.common.h.a.c(parama);
  }
  
  public boolean b(Throwable paramThrowable)
  {
    return super.a(paramThrowable);
  }
  
  @Nullable
  public com.facebook.common.h.a<T> k()
  {
    return com.facebook.common.h.a.b((com.facebook.common.h.a)super.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */