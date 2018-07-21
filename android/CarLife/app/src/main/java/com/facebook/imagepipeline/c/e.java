package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.h.a;

public abstract class e
{
  public a<Bitmap> a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public abstract a<Bitmap> a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */