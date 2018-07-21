package com.baidu.platform.comapi.util;

import java.lang.reflect.Method;

public class m
{
  private static final Class<?> a = ;
  
  private m()
  {
    throw new AssertionError();
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = ((Integer)a.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = ((Long)a.getMethod("getLong", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { paramString, Long.valueOf(paramLong) })).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  private static Class<?> a()
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = (String)a.getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)a.getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = ((Boolean)a.getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE }).invoke(null, new Object[] { paramString, Boolean.valueOf(paramBoolean) })).booleanValue();
      return bool;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    try
    {
      a.getMethod("set", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */