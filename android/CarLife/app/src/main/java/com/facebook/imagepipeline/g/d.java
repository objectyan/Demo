package com.facebook.imagepipeline.g;

import com.facebook.imagepipeline.j.c;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.ao;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class d<T>
  extends a<com.facebook.common.h.a<T>>
{
  private d(ai<com.facebook.common.h.a<T>> paramai, ao paramao, c paramc)
  {
    super(paramai, paramao, paramc);
  }
  
  public static <T> com.facebook.c.d<com.facebook.common.h.a<T>> a(ai<com.facebook.common.h.a<T>> paramai, ao paramao, c paramc)
  {
    return new d(paramai, paramao, paramc);
  }
  
  protected void a(com.facebook.common.h.a<T> parama)
  {
    com.facebook.common.h.a.c(parama);
  }
  
  protected void a(com.facebook.common.h.a<T> parama, boolean paramBoolean)
  {
    super.b(com.facebook.common.h.a.b(parama), paramBoolean);
  }
  
  @Nullable
  public com.facebook.common.h.a<T> j()
  {
    return com.facebook.common.h.a.b((com.facebook.common.h.a)super.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */