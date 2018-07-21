package com.facebook.imagepipeline.g;

import com.facebook.c.d;
import com.facebook.imagepipeline.j.c;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.ao;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class f<T>
  extends a<T>
{
  private f(ai<T> paramai, ao paramao, c paramc)
  {
    super(paramai, paramao, paramc);
  }
  
  public static <T> d<T> a(ai<T> paramai, ao paramao, c paramc)
  {
    return new f(paramai, paramao, paramc);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */