package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{
  private static int a = 1;
  
  public static short a()
  {
    return 65;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    int i = 65;
    if (paramBoolean) {
      i = 0;
    }
    paramContext = paramContext.getSharedPreferences("pst", 4).edit();
    paramContext.putInt("com.baidu.push.nd_restart", i);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return PushSettings.c(paramContext);
  }
  
  public static int b()
  {
    if (a != 0) {}
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-12-07 19:05:47").getTime();
      if (new Date().getTime() - l > 0L) {
        a = 0;
      }
      return a;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = 0;
      }
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    Object localObject = paramContext.getSharedPreferences("pst", 4);
    if (paramBoolean) {
      if ("disabled".equals(c(paramContext))) {
        a(paramContext, true);
      }
    }
    for (paramContext = "enabled";; paramContext = "disabled")
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("s_e", paramContext);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    if (65 > paramContext.getSharedPreferences("pst", 4).getInt("com.baidu.push.nd_restart", 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static String c(Context paramContext)
  {
    return paramContext.getSharedPreferences("pst", 4).getString("s_e", "default");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */