package com.facebook.drawee.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.h.a;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.i.e;
import java.util.Set;
import javax.annotation.Nullable;

public class d
  extends com.facebook.drawee.c.b<d, com.facebook.imagepipeline.m.c, a<com.facebook.imagepipeline.i.b>, e>
{
  private final g a;
  private final f b;
  
  public d(Context paramContext, f paramf, g paramg, Set<com.facebook.drawee.c.d> paramSet)
  {
    super(paramContext, paramSet);
    this.a = paramg;
    this.b = paramf;
  }
  
  private com.facebook.b.a.d x()
  {
    com.facebook.imagepipeline.m.c localc = (com.facebook.imagepipeline.m.c)g();
    com.facebook.imagepipeline.d.f localf = this.a.h();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localf != null)
    {
      localObject1 = localObject2;
      if (localc != null)
      {
        if (localc.n() == null) {
          break label54;
        }
        localObject1 = localf.b(localc, f());
      }
    }
    return (com.facebook.b.a.d)localObject1;
    label54:
    return localf.a(localc, f());
  }
  
  protected com.facebook.c.d<a<com.facebook.imagepipeline.i.b>> a(com.facebook.imagepipeline.m.c paramc, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.a.b(paramc, paramObject);
    }
    return this.a.c(paramc, paramObject);
  }
  
  protected c a()
  {
    Object localObject = p();
    if ((localObject instanceof c))
    {
      localObject = (c)localObject;
      ((c)localObject).a(u(), t(), x(), f());
      return (c)localObject;
    }
    return this.b.a(u(), t(), x(), f());
  }
  
  public d a(Uri paramUri)
  {
    return (d)super.b(com.facebook.imagepipeline.m.c.a(paramUri));
  }
  
  public d a(@Nullable String paramString)
  {
    return (d)super.b(com.facebook.imagepipeline.m.c.a(paramString));
  }
  
  protected d b()
  {
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/drawee/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */