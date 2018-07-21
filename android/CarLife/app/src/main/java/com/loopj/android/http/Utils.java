package com.loopj.android.http;

class Utils
{
  public static void asserts(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
  
  public static <T> T notNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " should not be null!");
    }
    return paramT;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */