package com.facebook.imagepipeline.d;

import android.os.Build.VERSION;

public class d
  implements h.a
{
  private static final String a = "BitmapMemoryCacheTrimStrategy";
  
  public double a(com.facebook.common.g.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      com.facebook.common.e.a.f("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] { parama });
    case 1: 
      do
      {
        return 0.0D;
      } while (Build.VERSION.SDK_INT < 21);
      return com.facebook.common.g.a.a.a();
    }
    return 1.0D;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */