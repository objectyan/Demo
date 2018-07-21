package com.facebook.imagepipeline.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.memory.d;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class a
  extends e
{
  private final d a;
  
  public a(d paramd)
  {
    this.a = paramd;
  }
  
  public com.facebook.common.h.a<Bitmap> a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = com.facebook.h.a.a(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)this.a.a(i);
    Bitmaps.a(localBitmap, paramInt1, paramInt2, paramConfig);
    return com.facebook.common.h.a.a(localBitmap, this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */