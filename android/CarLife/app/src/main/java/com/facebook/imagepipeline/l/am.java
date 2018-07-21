package com.facebook.imagepipeline.l;

import com.facebook.common.h.a;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.memory.y;

public class am
  implements ai<a<y>>
{
  private final ai<d> a;
  
  public am(ai<d> paramai)
  {
    this.a = paramai;
  }
  
  public void a(j<a<y>> paramj, aj paramaj)
  {
    this.a.a(new a(paramj, null), paramaj);
  }
  
  private class a
    extends m<d, a<y>>
  {
    private a()
    {
      super();
    }
    
    protected void a(d paramd, boolean paramBoolean)
    {
      Object localObject2 = null;
      a locala = null;
      Object localObject1 = localObject2;
      try
      {
        if (d.e(paramd))
        {
          localObject1 = localObject2;
          locala = paramd.c();
        }
        localObject1 = locala;
        d().b(locala, paramBoolean);
        a.c(locala);
        return;
      }
      finally
      {
        a.c((a)localObject1);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */