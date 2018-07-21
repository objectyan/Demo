package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class q
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 5).getString(paramString2, "");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(paramString1, 5).edit();
      paramContext.putString(paramString2, paramString3);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */