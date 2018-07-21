package com.facebook.imagepipeline.l;

import android.net.Uri;
import com.facebook.common.e.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.f.b;
import com.facebook.imagepipeline.m.c;

public class o
{
  private static final float a = 2048.0F;
  private static final float b = 0.33333334F;
  private static final int c = 1;
  
  @VisibleForTesting
  static int a(float paramFloat)
  {
    if (paramFloat > 0.6666667F) {
      return 1;
    }
    int i = 2;
    for (;;)
    {
      double d = 1.0D / (Math.pow(i, 2.0D) - i);
      if (1.0D / i + 0.3333333432674408D * d <= paramFloat) {
        return i - 1;
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  static int a(int paramInt)
  {
    int i = 1;
    for (;;)
    {
      if (i >= paramInt) {
        return i;
      }
      i *= 2;
    }
  }
  
  public static int a(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    int j;
    if (!com.facebook.imagepipeline.i.d.c(paramd))
    {
      j = 1;
      return j;
    }
    float f = b(paramc, paramd);
    int i;
    label34:
    int k;
    if (paramd.e() == b.f)
    {
      i = b(f);
      k = Math.max(paramd.h(), paramd.g());
    }
    for (;;)
    {
      j = i;
      if (k / i <= 2048.0F) {
        break;
      }
      if (paramd.e() == b.f)
      {
        i *= 2;
        continue;
        i = a(f);
        break label34;
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  static float b(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    k.a(com.facebook.imagepipeline.i.d.c(paramd));
    com.facebook.imagepipeline.e.d locald = paramc.e();
    if ((locald == null) || (locald.b <= 0) || (locald.a <= 0) || (paramd.g() == 0) || (paramd.h() == 0)) {
      return 1.0F;
    }
    int i = c(paramc, paramd);
    if ((i == 90) || (i == 270))
    {
      j = 1;
      if (j == 0) {
        break label219;
      }
      i = paramd.h();
      label86:
      if (j == 0) {
        break label228;
      }
    }
    label219:
    label228:
    for (int j = paramd.g();; j = paramd.h())
    {
      float f1 = locald.a / i;
      float f2 = locald.b / j;
      float f3 = Math.max(f1, f2);
      a.a("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", new Object[] { Integer.valueOf(locald.a), Integer.valueOf(locald.b), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), paramc.b().toString() });
      return f3;
      j = 0;
      break;
      i = paramd.g();
      break label86;
    }
  }
  
  @VisibleForTesting
  static int b(float paramFloat)
  {
    int j;
    if (paramFloat > 0.6666667F)
    {
      j = 1;
      return j;
    }
    int i = 2;
    for (;;)
    {
      double d = 1.0D / (i * 2);
      j = i;
      if (1.0D / (i * 2) + 0.3333333432674408D * d <= paramFloat) {
        break;
      }
      i *= 2;
    }
  }
  
  private static int c(c paramc, com.facebook.imagepipeline.i.d paramd)
  {
    boolean bool = false;
    if (!paramc.g()) {
      return 0;
    }
    int i = paramd.f();
    if ((i == 0) || (i == 90) || (i == 180) || (i == 270)) {
      bool = true;
    }
    k.a(bool);
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */