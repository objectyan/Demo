package com.baidu.platform.a;

import android.content.Context;
import java.lang.reflect.Method;

class a
{
  private Context a;
  
  private a()
  {
    try
    {
      Object localObject = Class.forName("com.baidu.baidumaps.BaiduMapApplication").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      if (localObject != null)
      {
        this.a = ((Context)localObject);
        return;
      }
      throw new RuntimeException("BaiduMapApplication.getInstance() return null!");
    }
    catch (Exception localException) {}
  }
  
  public static a a()
  {
    return a.a;
  }
  
  public Context b()
  {
    return this.a;
  }
  
  private static class a
  {
    public static final a a = new a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */