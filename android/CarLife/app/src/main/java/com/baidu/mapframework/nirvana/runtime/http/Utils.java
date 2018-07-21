package com.baidu.mapframework.nirvana.runtime.http;

import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

class Utils
{
  public static void assertNotOnUiThread()
  {
    if (isOnUiThread()) {
      throw new RuntimeException("Expected to run on UI thread!");
    }
  }
  
  public static void assertOnUiThread()
  {
    if (!isOnUiThread()) {
      throw new RuntimeException("Expected to run on UI thread!");
    }
  }
  
  public static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static boolean isUrlLegal(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getProtocol();
        if (!"http".equals(paramString))
        {
          boolean bool = "https".equals(paramString);
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public static Object reflectionInvokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    try
    {
      Class localClass = Class.forName(paramString1);
      paramString1 = (String)localObject;
      if (localClass != null)
      {
        paramString2 = localClass.getMethod(paramString2, paramArrayOfClass);
        paramString1 = (String)localObject;
        if (paramString2 != null) {
          paramString1 = paramString2.invoke(null, paramArrayOfObject);
        }
      }
      return paramString1;
    }
    catch (InvocationTargetException paramString1)
    {
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      return null;
    }
    catch (ClassNotFoundException paramString1) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/runtime/http/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */