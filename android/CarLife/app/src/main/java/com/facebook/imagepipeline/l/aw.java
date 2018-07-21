package com.facebook.imagepipeline.l;

public final class aw
{
  public static final float a = 1.3333334F;
  private static final int b = 90;
  private static final int c = 270;
  
  public static int a(int paramInt)
  {
    return (int)(paramInt * 1.3333334F);
  }
  
  public static boolean a(int paramInt1, int paramInt2, com.facebook.imagepipeline.e.d paramd)
  {
    if (paramd == null) {
      if ((a(paramInt1) < 2048.0F) || (a(paramInt2) < 2048)) {}
    }
    while ((a(paramInt1) >= paramd.a) && (a(paramInt2) >= paramd.b))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(com.facebook.imagepipeline.i.d paramd, com.facebook.imagepipeline.e.d paramd1)
  {
    if (paramd == null) {
      return false;
    }
    switch (paramd.f())
    {
    default: 
      return a(paramd.g(), paramd.h(), paramd1);
    }
    return a(paramd.h(), paramd.g(), paramd1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */