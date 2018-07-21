package com.facebook.imagepipeline.m;

import android.graphics.Bitmap;
import com.facebook.b.a.d;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;

public abstract class a
  implements e
{
  public com.facebook.common.h.a<Bitmap> a(Bitmap paramBitmap, com.facebook.imagepipeline.c.e parame)
  {
    parame = parame.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    try
    {
      a((Bitmap)parame.a(), paramBitmap);
      paramBitmap = com.facebook.common.h.a.b(parame);
      return paramBitmap;
    }
    finally
    {
      com.facebook.common.h.a.c(parame);
    }
  }
  
  public String a()
  {
    return "Unknown postprocessor";
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Bitmaps.a(paramBitmap1, paramBitmap2);
    a(paramBitmap1);
  }
  
  @Nullable
  public d b()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */