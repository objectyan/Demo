package com.baidu.mapframework.commonlib.date;

import java.lang.reflect.Array;
import java.util.logging.Logger;

final class Util
{
  private static final String a = "'";
  
  static String a(Object paramObject)
  {
    return "'" + String.valueOf(paramObject) + "'";
  }
  
  static Logger a(Class<?> paramClass)
  {
    return Logger.getLogger(paramClass.getPackage().getName());
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2 - 1;
  }
  
  static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() > 0);
  }
  
  static String b(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    d(paramObject);
    StringBuilder localStringBuilder = new StringBuilder("[");
    int j = Array.getLength(paramObject);
    int i = 0;
    if (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (c(localObject)) {
        localStringBuilder.append(b(localObject));
      }
      for (;;)
      {
        if (!a(i, j)) {
          localStringBuilder.append(", ");
        }
        i += 1;
        break;
        localStringBuilder.append(localObject);
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private static boolean c(Object paramObject)
  {
    return (paramObject != null) && (paramObject.getClass().isArray());
  }
  
  private static void d(Object paramObject)
  {
    if (!paramObject.getClass().isArray()) {
      throw new IllegalArgumentException("Object is not an array.");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/date/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */