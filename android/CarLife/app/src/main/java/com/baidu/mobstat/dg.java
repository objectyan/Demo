package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class dg
{
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    return localSimpleDateFormat.format(localDate);
  }
  
  public static String a(Context paramContext)
  {
    return e.a(paramContext);
  }
  
  public static HashMap<String, String> a(Map<String, String> paramMap)
  {
    HashMap localHashMap = null;
    if (paramMap != null) {
      localHashMap = new HashMap(paramMap);
    }
    return localHashMap;
  }
  
  public static boolean a(Class<?> paramClass, String paramString)
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    boolean bool1 = bool2;
    if (i < arrayOfStackTraceElement.length)
    {
      Object localObject1 = arrayOfStackTraceElement[i];
      Object localObject2 = ((StackTraceElement)localObject1).getMethodName();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (paramClass == null) || (!((String)localObject2).equals(paramString))) {}
      do
      {
        i += 1;
        break;
        localObject2 = ((StackTraceElement)localObject1).getClassName();
        localObject1 = null;
        try
        {
          localObject2 = Class.forName((String)localObject2);
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      } while ((localObject1 == null) || (!paramClass.isAssignableFrom((Class)localObject1)));
      bool1 = true;
    }
    else
    {
      return bool1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */