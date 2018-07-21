package cz.msebera.android.httpclient.o;

import java.util.Collection;

public class a
{
  public static int a(int paramInt, String paramString)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException(paramString + " may not be negative or zero");
    }
    return paramInt;
  }
  
  public static long a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException(paramString + " may not be negative or zero");
    }
    return paramLong;
  }
  
  public static <T extends CharSequence> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " may not be null");
    }
    if (k.a(paramT)) {
      throw new IllegalArgumentException(paramString + " may not be empty");
    }
    return paramT;
  }
  
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " may not be null");
    }
    return paramT;
  }
  
  public static <E, T extends Collection<E>> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " may not be null");
    }
    if (paramT.isEmpty()) {
      throw new IllegalArgumentException(paramString + " may not be empty");
    }
    return paramT;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static int b(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(paramString + " may not be negative");
    }
    return paramInt;
  }
  
  public static long b(long paramLong, String paramString)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(paramString + " may not be negative");
    }
    return paramLong;
  }
  
  public static <T extends CharSequence> T b(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " may not be null");
    }
    if (k.b(paramT)) {
      throw new IllegalArgumentException(paramString + " may not be blank");
    }
    return paramT;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/o/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */