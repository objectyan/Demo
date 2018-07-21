package com.facebook.imagepipeline.c;

import android.graphics.Bitmap;
import com.facebook.common.h.c;

public class f
  implements c<Bitmap>
{
  private static f a;
  
  public static f a()
  {
    if (a == null) {
      a = new f();
    }
    return a;
  }
  
  public void a(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */