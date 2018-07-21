package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.g.c;
import com.facebook.common.internal.k;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class d
  extends a<Bitmap>
{
  public d(c paramc, v paramv, w paramw)
  {
    super(paramc, paramv, paramw);
    a();
  }
  
  protected void a(Bitmap paramBitmap)
  {
    k.a(paramBitmap);
    paramBitmap.recycle();
  }
  
  protected int b(Bitmap paramBitmap)
  {
    k.a(paramBitmap);
    return paramBitmap.getAllocationByteCount();
  }
  
  protected int c(int paramInt)
  {
    return paramInt;
  }
  
  protected boolean c(Bitmap paramBitmap)
  {
    k.a(paramBitmap);
    return (!paramBitmap.isRecycled()) && (paramBitmap.isMutable());
  }
  
  protected int d(int paramInt)
  {
    return paramInt;
  }
  
  protected Bitmap i(int paramInt)
  {
    return Bitmap.createBitmap(1, (int)Math.ceil(paramInt / 2.0D), Bitmap.Config.RGB_565);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */