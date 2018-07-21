package com.facebook.imagepipeline.l;

import com.facebook.imagepipeline.i.d;

public class a
  implements ai<d>
{
  private final ai<d> a;
  
  public a(ai<d> paramai)
  {
    this.a = paramai;
  }
  
  public void a(j<d> paramj, aj paramaj)
  {
    this.a.a(new a(paramj, null), paramaj);
  }
  
  private static class a
    extends m<d, d>
  {
    private a(j<d> paramj)
    {
      super();
    }
    
    protected void a(d paramd, boolean paramBoolean)
    {
      if (paramd == null)
      {
        d().b(null, paramBoolean);
        return;
      }
      if (!d.c(paramd)) {
        paramd.k();
      }
      d().b(paramd, paramBoolean);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */