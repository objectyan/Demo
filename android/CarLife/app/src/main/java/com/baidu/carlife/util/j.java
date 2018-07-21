package com.baidu.carlife.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class j
{
  private static final int a = 200;
  private static final int b = 20;
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    int m = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int n = Math.max(m, k);
    int j = k;
    int i = m;
    if (n > 200)
    {
      float f = n * 1.0F / 200.0F;
      i = (int)(m / f);
      j = (int)(k / f);
    }
    Object localObject1 = Bitmap.createScaledBitmap(paramBitmap, i, j, false);
    paramBitmap = Bitmap.createBitmap((Bitmap)localObject1);
    Object localObject2 = RenderScript.create(paramContext);
    paramContext = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
    localObject1 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
    localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, paramBitmap);
    paramContext.setRadius(20.0F);
    paramContext.setInput((Allocation)localObject1);
    paramContext.forEach((Allocation)localObject2);
    ((Allocation)localObject2).copyTo(paramBitmap);
    return paramBitmap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */