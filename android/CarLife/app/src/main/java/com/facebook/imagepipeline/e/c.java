package com.facebook.imagepipeline.e;

import javax.annotation.Nullable;

public enum c
{
  private c() {}
  
  public static c a(@Nullable c paramc1, @Nullable c paramc2)
  {
    if (paramc1 == null) {}
    do
    {
      return paramc2;
      if (paramc2 == null) {
        return paramc1;
      }
    } while (paramc1.ordinal() <= paramc2.ordinal());
    return paramc1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */