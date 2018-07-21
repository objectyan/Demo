package com.facebook.drawee.a.a;

import android.content.Context;
import com.facebook.common.c.i;
import com.facebook.common.internal.m;
import com.facebook.drawee.b.a;
import com.facebook.imagepipeline.a.a.b;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.j;
import java.util.Set;

public class e
  implements m<d>
{
  private final Context a;
  private final g b;
  private final f c;
  private final Set<com.facebook.drawee.c.d> d;
  
  public e(Context paramContext)
  {
    this(paramContext, j.a());
  }
  
  public e(Context paramContext, j paramj)
  {
    this(paramContext, paramj, null);
  }
  
  public e(Context paramContext, j paramj, Set<com.facebook.drawee.c.d> paramSet)
  {
    this.a = paramContext;
    this.b = paramj.j();
    b localb = paramj.c();
    paramj = null;
    if (localb != null) {
      paramj = localb.a(paramContext);
    }
    this.c = new f(paramContext.getResources(), a.a(), paramj, i.c(), this.b.d());
    this.d = paramSet;
  }
  
  public d a()
  {
    return new d(this.a, this.c, this.b, this.d);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */