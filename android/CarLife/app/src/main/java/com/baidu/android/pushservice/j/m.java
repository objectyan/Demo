package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class m
{
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pst", 0).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pst", 0).edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.apply();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pst", 0).edit();
      paramContext.putLong(paramString, paramLong);
      paramContext.apply();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt, long paramLong, String paramString5, String paramString6)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
      if (paramLong != 0L) {
        localEditor.putLong("currbindtime", paramLong);
      }
      if (!TextUtils.isEmpty(paramString5)) {
        localEditor.putString("access_token", paramString5);
      }
      if (!TextUtils.isEmpty(paramString6)) {
        localEditor.putString("secret_key", paramString6);
      }
      localEditor.putString("appid", paramString1);
      localEditor.putString("channel_id", paramString2);
      localEditor.putString("request_id", paramString3);
      localEditor.putString("user_id", paramString4);
      localEditor.putBoolean("bind_status", true);
      localEditor.putLong("version_code", p.d(paramContext, paramContext.getPackageName()));
      localEditor.apply();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() > 20)) {
      return;
    }
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.baidu.pushservice.app_stat", 0).edit();
      localEditor.putString("pkg_list", TextUtils.join(":", paramList));
      localEditor.putLong("last_save", System.currentTimeMillis());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        PackageInfo localPackageInfo = p.a(paramContext, str);
        if (localPackageInfo != null) {
          localEditor.putString(str, localPackageInfo.versionCode + ":" + localPackageInfo.versionName);
        }
      }
      localEditor.apply();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pst", 4).edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.apply();
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static int b(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("pst", 0).getInt(paramString, paramInt);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pst", 4).getString(paramString, "");
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pst", 4).edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.apply();
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static long c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("pst", 0).getLong(paramString, 0L);
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("pst", 4).edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.apply();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int d(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("pst", 4).getInt(paramString, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */