package com.facebook.imagepipeline.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.h.a;
import com.facebook.common.internal.k;
import com.facebook.common.internal.o;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.memory.c;
import com.facebook.imagepipeline.memory.y;
import com.facebook.imagepipeline.nativecode.Bitmaps;

abstract class b
  implements e
{
  protected static final byte[] a = { -1, -39 };
  private final com.facebook.imagepipeline.memory.b b = c.a();
  
  private static BitmapFactory.Options a(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    return localOptions;
  }
  
  protected static boolean a(a<y> parama, int paramInt)
  {
    parama = (y)parama.a();
    return (paramInt >= 2) && (parama.a(paramInt - 2) == -1) && (parama.a(paramInt - 1) == -39);
  }
  
  abstract Bitmap a(a<y> parama, int paramInt, BitmapFactory.Options paramOptions);
  
  abstract Bitmap a(a<y> parama, BitmapFactory.Options paramOptions);
  
  public a<Bitmap> a(Bitmap paramBitmap)
  {
    try
    {
      Bitmaps.a(paramBitmap);
      if (!this.b.a(paramBitmap))
      {
        paramBitmap.recycle();
        throw new com.facebook.imagepipeline.e.e();
      }
    }
    catch (Exception localException)
    {
      paramBitmap.recycle();
      throw o.b(localException);
    }
    return a.a(paramBitmap, this.b.c());
  }
  
  public a<Bitmap> a(d paramd, Bitmap.Config paramConfig)
  {
    paramConfig = a(paramd.i(), paramConfig);
    paramd = paramd.c();
    k.a(paramd);
    try
    {
      paramConfig = a(a(paramd, paramConfig));
      return paramConfig;
    }
    finally
    {
      a.c(paramd);
    }
  }
  
  public a<Bitmap> a(d paramd, Bitmap.Config paramConfig, int paramInt)
  {
    paramConfig = a(paramd.i(), paramConfig);
    paramd = paramd.c();
    k.a(paramd);
    try
    {
      paramConfig = a(a(paramd, paramInt, paramConfig));
      return paramConfig;
    }
    finally
    {
      a.c(paramd);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/k/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */