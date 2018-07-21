package com.facebook.imagepipeline.l;

import com.facebook.common.internal.k;
import com.facebook.imagepipeline.m.c;

public class au
  implements ai<com.facebook.imagepipeline.i.d>
{
  private final av<com.facebook.imagepipeline.i.d>[] a;
  
  public au(av<com.facebook.imagepipeline.i.d>... paramVarArgs)
  {
    this.a = ((av[])k.a(paramVarArgs));
    k.a(0, this.a.length);
  }
  
  private int a(int paramInt, com.facebook.imagepipeline.e.d paramd)
  {
    while (paramInt < this.a.length)
    {
      if (this.a[paramInt].a(paramd)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private boolean a(int paramInt, j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    paramInt = a(paramInt, paramaj.a().e());
    if (paramInt == -1) {
      return false;
    }
    this.a[paramInt].a(new a(paramj, paramaj, paramInt), paramaj);
    return true;
  }
  
  public void a(j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    if (paramaj.a().e() == null) {
      paramj.b(null, true);
    }
    while (a(0, paramj, paramaj)) {
      return;
    }
    paramj.b(null, true);
  }
  
  private class a
    extends m<com.facebook.imagepipeline.i.d, com.facebook.imagepipeline.i.d>
  {
    private final aj b;
    private final int c;
    private final com.facebook.imagepipeline.e.d d;
    
    public a(aj paramaj, int paramInt)
    {
      super();
      this.b = paramInt;
      int i;
      this.c = i;
      this.d = this.b.a().e();
    }
    
    protected void a(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      if ((paramd != null) && ((!paramBoolean) || (aw.a(paramd, this.d)))) {
        d().b(paramd, paramBoolean);
      }
      do
      {
        do
        {
          return;
        } while (!paramBoolean);
        com.facebook.imagepipeline.i.d.d(paramd);
      } while (au.a(au.this, this.c + 1, d(), this.b));
      d().b(null, true);
    }
    
    protected void a(Throwable paramThrowable)
    {
      if (!au.a(au.this, this.c + 1, d(), this.b)) {
        d().b(paramThrowable);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */