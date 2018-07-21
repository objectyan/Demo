package com.facebook.imagepipeline.nativecode;

public class c
{
  public static boolean a = false;
  private static b b;
  
  static
  {
    try
    {
      b = (b)Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
      a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      a = false;
    }
  }
  
  public static b a()
  {
    return b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/nativecode/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */