package com.baidu.che.codriver.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class l
{
  public static final String a = "codriver_setting";
  
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences("codriver_setting", 0).getLong(paramString, paramLong);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("codriver_setting", 0).getString(paramString1, paramString2);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("codriver_setting", 0).getBoolean(paramString, paramBoolean);
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("codriver_setting", 0).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("codriver_setting", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("codriver_setting", 0).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */