package com.facebook.imagepipeline.l;

import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.m.c;

public class i
  implements ai<d>
{
  private final ai<d> a;
  private final ai<d> b;
  
  public i(ai<d> paramai1, ai<d> paramai2)
  {
    this.a = paramai1;
    this.b = paramai2;
  }
  
  public void a(j<d> paramj, aj paramaj)
  {
    paramj = new a(paramj, paramaj, null);
    this.a.a(paramj, paramaj);
  }
  
  private class a
    extends m<d, d>
  {
    private aj b;
    
    private a(aj paramaj)
    {
      super();
      aj localaj;
      this.b = localaj;
    }
    
    protected void a(d paramd, boolean paramBoolean)
    {
      Object localObject = this.b.a();
      boolean bool2 = aw.a(paramd, ((c)localObject).e());
      if ((paramd != null) && ((bool2) || (((c)localObject).i())))
      {
        localObject = d();
        if ((!paramBoolean) || (!bool2)) {
          break label99;
        }
      }
      label99:
      for (boolean bool1 = true;; bool1 = false)
      {
        ((j)localObject).b(paramd, bool1);
        if ((paramBoolean) && (!bool2))
        {
          d.d(paramd);
          i.a(i.this).a(d(), this.b);
        }
        return;
      }
    }
    
    protected void a(Throwable paramThrowable)
    {
      i.a(i.this).a(d(), this.b);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */