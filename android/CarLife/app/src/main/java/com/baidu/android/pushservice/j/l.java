package com.baidu.android.pushservice.j;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class l
{
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
      if (i == 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramContext) {}
    return 2;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new NotificationChannel(paramString1, paramString2, 3);
    paramString1.setShowBadge(true);
    paramString1.setLockscreenVisibility(1);
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    if (paramContext != null) {
      paramContext.createNotificationChannel(paramString1);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */