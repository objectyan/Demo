package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import com.facebook.c.c;
import com.facebook.c.d;
import javax.annotation.Nullable;

public abstract class b
  extends c<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>>
{
  protected abstract void a(@Nullable Bitmap paramBitmap);
  
  public void e(d<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramd)
  {
    if (!paramd.b()) {
      return;
    }
    com.facebook.common.h.a locala = (com.facebook.common.h.a)paramd.d();
    Object localObject = null;
    paramd = (d<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>>)localObject;
    if (locala != null)
    {
      paramd = (d<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>>)localObject;
      if ((locala.a() instanceof com.facebook.imagepipeline.i.a)) {
        paramd = ((com.facebook.imagepipeline.i.a)locala.a()).a();
      }
    }
    try
    {
      a(paramd);
      return;
    }
    finally
    {
      com.facebook.common.h.a.c(locala);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */