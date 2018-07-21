package com.baidu.carlife.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public static final String a = "PushDemoActivity";
  public static String b = "";
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("log_text", "");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    localObject1 = null;
    localObject2 = null;
    if ((paramContext == null) || (paramString == null)) {
      return null;
    }
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = (Context)localObject1;
      if (localApplicationInfo != null) {
        paramContext = localApplicationInfo.metaData;
      }
      localObject1 = localObject2;
      if (paramContext != null) {
        localObject1 = paramContext.getString(paramString);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.e("PushDemoActivity", "error " + paramContext.getMessage());
        localObject1 = localObject2;
      }
    }
    return (String)localObject1;
  }
  
  public static List<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (int i = paramString.indexOf(','); i != -1; i = paramString.indexOf(','))
    {
      localArrayList.add(paramString.substring(0, i));
      paramString = paramString.substring(i + 1);
    }
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("log_text", paramString);
    paramContext.commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/push/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */