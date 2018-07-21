package com.baidu.carlife.util;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.baidu.carlife.BaiduNaviApplication;

public class r
{
  private static final int a = -1;
  private static final int b = 0;
  private static SparseIntArray c = new SparseIntArray();
  private static Resources d = BaiduNaviApplication.getInstance().getResources();
  private static Resources e;
  
  public static int a(int paramInt)
  {
    if (e != null) {
      try
      {
        int j = c.get(paramInt, -1);
        int i = j;
        if (j == -1)
        {
          i = e.getIdentifier(c(paramInt), "color", "com.baidu.carlife.skin");
          c.put(paramInt, i);
        }
        if (i != 0)
        {
          i = e.getColor(i);
          return i;
        }
      }
      catch (Exception localException) {}
    }
    return d.getColor(paramInt);
  }
  
  public static SparseIntArray a()
  {
    return c;
  }
  
  public static void a(Resources paramResources)
  {
    e = paramResources;
  }
  
  public static Drawable b(int paramInt)
  {
    if (e != null) {
      try
      {
        int j = c.get(paramInt, -1);
        int i = j;
        if (j == -1)
        {
          i = e.getIdentifier(c(paramInt), d(paramInt), "com.baidu.carlife.skin");
          c.put(paramInt, i);
        }
        if (i != 0)
        {
          Drawable localDrawable = e.getDrawable(i);
          return localDrawable;
        }
      }
      catch (Resources.NotFoundException localNotFoundException) {}
    }
    return d.getDrawable(paramInt);
  }
  
  public static void b()
  {
    c.clear();
    e = null;
  }
  
  private static String c(int paramInt)
  {
    String str = "";
    if (d != null) {}
    try
    {
      str = d.getResourceEntryName(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
  
  private static String d(int paramInt)
  {
    String str = "";
    if (d != null) {}
    try
    {
      str = d.getResourceTypeName(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */