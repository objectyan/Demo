package com.indooratlas.android.sdk._internal;

public final class eg
{
  public static <T> T a(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(a(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static String a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((paramString1 == null) || ("".equals(paramString1.trim()))) {
      throw new IllegalArgumentException(a(paramString2, paramVarArgs));
    }
    return paramString1;
  }
  
  private static String a(String paramString, Object... paramVarArgs)
  {
    String str = String.valueOf(paramString);
    paramString = str;
    if (paramVarArgs != null) {
      paramString = String.format(str, paramVarArgs);
    }
    return paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */