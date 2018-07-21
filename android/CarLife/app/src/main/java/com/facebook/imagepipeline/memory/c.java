package com.facebook.imagepipeline.memory;

public class c
{
  public static final int a = ;
  public static final int b = 384;
  private static final long c = 1024L;
  private static final long d = 1048576L;
  private static b e;
  
  public static b a()
  {
    if (e == null) {
      e = new b(384, a);
    }
    return e;
  }
  
  private static int b()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216L) {
      return i / 4 * 3;
    }
    return i / 2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */