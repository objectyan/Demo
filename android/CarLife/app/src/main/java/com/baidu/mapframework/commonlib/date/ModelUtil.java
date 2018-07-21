package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.Array;

final class ModelUtil
{
  static final int a = 23;
  private static final int b = 37;
  
  private static int a(int paramInt)
  {
    return paramInt * 37;
  }
  
  static int a(int paramInt, char paramChar)
  {
    return a(paramInt) + paramChar;
  }
  
  static int a(int paramInt, double paramDouble)
  {
    return a(paramInt, Double.doubleToLongBits(paramDouble));
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return a(paramInt, Float.floatToIntBits(paramFloat));
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return a(paramInt1) + paramInt2;
  }
  
  static int a(int paramInt, long paramLong)
  {
    return a(paramInt) + (int)(paramLong >>> 32 ^ paramLong);
  }
  
  static int a(int paramInt, Object paramObject)
  {
    int j;
    if (paramObject == null)
    {
      j = a(paramInt, 0);
      return j;
    }
    if (!b(paramObject)) {
      return a(paramInt, paramObject.hashCode());
    }
    int k = Array.getLength(paramObject);
    int i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= k) {
        break;
      }
      paramInt = a(paramInt, Array.get(paramObject, i));
      i += 1;
    }
  }
  
  static int a(int paramInt, boolean paramBoolean)
  {
    int i = a(paramInt);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0) {
      return paramInt + i;
    }
  }
  
  static <T extends Comparable<T>> int a(T paramT1, T paramT2, NullsGo paramNullsGo)
  {
    int j = 0;
    if ((paramT1 != null) && (paramT2 != null))
    {
      j = paramT1.compareTo(paramT2);
      return j;
    }
    int i;
    if ((paramT1 == null) && (paramT2 != null)) {
      i = -1;
    }
    for (;;)
    {
      j = i;
      if (NullsGo.LAST != paramNullsGo) {
        break;
      }
      return i * -1;
      i = j;
      if (paramT1 != null)
      {
        i = j;
        if (paramT2 == null) {
          i = 1;
        }
      }
    }
  }
  
  static final int a(Object... paramVarArgs)
  {
    int j = 23;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j = a(j, paramVarArgs[i]);
      i += 1;
    }
    return j;
  }
  
  static Boolean a(Object paramObject1, Object paramObject2)
  {
    Boolean localBoolean = null;
    if (paramObject1 == paramObject2) {
      localBoolean = Boolean.TRUE;
    }
    while (paramObject1.getClass().isInstance(paramObject2)) {
      return localBoolean;
    }
    return Boolean.FALSE;
  }
  
  static String a(Object paramObject)
  {
    return ToStringUtil.a(paramObject);
  }
  
  static String a(Object paramObject, Class paramClass, String paramString)
  {
    return ToStringUtil.a(paramObject, paramClass, paramString);
  }
  
  static boolean a(char paramChar1, char paramChar2)
  {
    return paramChar1 == paramChar2;
  }
  
  static boolean a(double paramDouble1, double paramDouble2)
  {
    return Double.doubleToLongBits(paramDouble1) == Double.doubleToLongBits(paramDouble2);
  }
  
  static boolean a(float paramFloat1, float paramFloat2)
  {
    return Float.floatToIntBits(paramFloat1) == Float.floatToIntBits(paramFloat2);
  }
  
  static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 == paramBoolean2;
  }
  
  static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
      throw new IllegalArgumentException("Array lengths do not match. 'This' length is " + paramArrayOfObject1.length + ", while 'That' length is " + paramArrayOfObject2.length + ".");
    }
    boolean bool2 = true;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramArrayOfObject1.length)
      {
        if (!b(paramArrayOfObject1[i], paramArrayOfObject2[i])) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean b(Object paramObject)
  {
    return (paramObject != null) && (paramObject.getClass().isArray());
  }
  
  static boolean b(Object paramObject1, Object paramObject2)
  {
    if ((b(paramObject1)) || (b(paramObject2))) {
      throw new IllegalArgumentException("This method does not currently support arrays.");
    }
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  static enum NullsGo
  {
    private NullsGo() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/ModelUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */