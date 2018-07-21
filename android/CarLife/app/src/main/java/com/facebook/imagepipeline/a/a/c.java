package com.facebook.imagepipeline.a.a;

import java.lang.reflect.Constructor;

public class c
{
  private static boolean a;
  private static b b = null;
  
  public static b a(com.facebook.imagepipeline.c.e parame, com.facebook.imagepipeline.f.e parame1)
  {
    if (!a) {}
    try
    {
      b = (b)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(new Class[] { com.facebook.imagepipeline.c.e.class, com.facebook.imagepipeline.f.e.class }).newInstance(new Object[] { parame, parame1 });
      if (b != null)
      {
        a = true;
        return b;
      }
      try
      {
        b = (b)Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(new Class[] { com.facebook.imagepipeline.c.e.class, com.facebook.imagepipeline.f.e.class }).newInstance(new Object[] { parame, parame1 });
        a = true;
        return b;
      }
      catch (Throwable parame)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */