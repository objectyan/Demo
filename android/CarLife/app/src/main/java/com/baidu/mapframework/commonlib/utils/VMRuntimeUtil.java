package com.baidu.mapframework.commonlib.utils;

import java.lang.reflect.Method;

public class VMRuntimeUtil
{
  public static long getMinimumHeapSize()
  {
    try
    {
      Class localClass1 = Class.forName("dalvik.system.VMRuntime");
      Method localMethod = localClass1.getMethod("getRuntime", new Class[0]);
      Class localClass2 = Long.TYPE;
      long l = ((Long)localClass1.getMethod("getMinimumHeapSize", new Class[0]).invoke(localMethod.invoke(null, new Object[0]), new Object[0])).longValue();
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public static float getTargetHeapUtilization()
  {
    try
    {
      Class localClass1 = Class.forName("dalvik.system.VMRuntime");
      Method localMethod = localClass1.getMethod("getRuntime", new Class[0]);
      Class localClass2 = Long.TYPE;
      float f = ((Float)localClass1.getMethod("getTargetHeapUtilization", new Class[0]).invoke(localMethod.invoke(null, new Object[0]), new Object[0])).floatValue();
      return f;
    }
    catch (Throwable localThrowable) {}
    return 0.0F;
  }
  
  public static void setMinimumHeapSize(long paramLong)
  {
    try
    {
      Class localClass = Class.forName("dalvik.system.VMRuntime");
      Method localMethod = localClass.getMethod("getRuntime", new Class[0]);
      localClass.getMethod("setMinimumHeapSize", new Class[] { Long.TYPE }).invoke(localMethod.invoke(null, new Object[0]), new Object[] { Long.valueOf(paramLong) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void setTargetHeapUtilization(float paramFloat)
  {
    try
    {
      Class localClass = Class.forName("dalvik.system.VMRuntime");
      Method localMethod = localClass.getMethod("getRuntime", new Class[0]);
      localClass.getMethod("setTargetHeapUtilization", new Class[] { Float.TYPE }).invoke(localMethod.invoke(null, new Object[0]), new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/utils/VMRuntimeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */