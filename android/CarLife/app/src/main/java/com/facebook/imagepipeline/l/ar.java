package com.facebook.imagepipeline.l;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;

public class ar<T>
  implements ai<T>
{
  @VisibleForTesting
  protected static final String a = "BackgroundThreadHandoffProducer";
  private final ai<T> b;
  private final as c;
  
  public ar(ai<T> paramai, as paramas)
  {
    this.b = ((ai)k.a(paramai));
    this.c = paramas;
  }
  
  public void a(final j<T> paramj, final aj paramaj)
  {
    final al localal = paramaj.c();
    final String str = paramaj.b();
    paramj = new ap(paramj, localal, "BackgroundThreadHandoffProducer", str)
    {
      protected void a(T paramAnonymousT)
      {
        localal.a(str, "BackgroundThreadHandoffProducer", null);
        ar.a(ar.this).a(paramj, paramaj);
      }
      
      protected void b(T paramAnonymousT) {}
      
      protected T c()
        throws Exception
      {
        return null;
      }
    };
    paramaj.a(new e()
    {
      public void a()
      {
        paramj.a();
        ar.b(ar.this).b(paramj);
      }
    });
    this.c.a(paramj);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */