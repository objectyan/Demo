package com.indooratlas.android.sdk._internal;

import java.lang.reflect.Field;

public final class eh
{
  public static String a(Class paramClass, Object paramObject)
  {
    paramClass = paramClass.getDeclaredFields();
    try
    {
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        String str = paramClass[i];
        try
        {
          Object localObject = str.get(null);
          if (((paramObject == null) && (localObject == null)) || (paramObject.equals(localObject)))
          {
            str = str.getName();
            return str;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          i += 1;
        }
      }
      return String.valueOf(paramObject);
    }
    catch (IllegalAccessException paramClass) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */