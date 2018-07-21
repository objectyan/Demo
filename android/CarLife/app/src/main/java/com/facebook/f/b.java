package com.facebook.f;

public enum b
{
  private b() {}
  
  public static boolean a(b paramb)
  {
    return (paramb == a) || (paramb == b) || (paramb == c) || (paramb == d) || (paramb == e);
  }
  
  public static String b(b paramb)
    throws UnsupportedOperationException
  {
    switch (1.a[paramb.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("Unknown image format " + paramb.name());
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return "webp";
    case 6: 
      return "jpeg";
    case 7: 
      return "png";
    case 8: 
      return "gif";
    }
    return "bmp";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */