package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressLint({"WorldReadableFiles"})
public class PushManager
{
  private static final String TAG = "PushManager";
  
  public static void delTags(Context paramContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = f.a(paramContext);
    } while (localIntent == null);
    Object localObject = paramList.iterator();
    for (paramList = "["; ((Iterator)localObject).hasNext(); paramList = paramList + "\",")
    {
      String str = (String)((Iterator)localObject).next();
      paramList = paramList + "\"";
      paramList = paramList + str;
    }
    localObject = paramList;
    if (paramList.length() > 0) {
      localObject = paramList.substring(0, paramList.length() - 1);
    }
    paramList = (String)localObject + "]";
    localIntent.putExtra("method", "method_del_tags");
    localIntent.putExtra("tags", paramList);
    com.baidu.android.pushservice.g.a.a("PushManager", "a delTags intent send", paramContext.getApplicationContext());
    f.b(paramContext, localIntent);
  }
  
  public static void disableLbs(Context paramContext)
  {
    if (f.l(paramContext)) {
      return;
    }
    PushSettings.a(paramContext, false);
  }
  
  public static void enableHuaweiProxy(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      m.a(paramContext, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 1);
      return;
    }
    m.a(paramContext, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", 0);
  }
  
  public static void enableLbs(Context paramContext)
  {
    if (f.l(paramContext)) {
      return;
    }
    PushSettings.a(paramContext, true);
  }
  
  public static void enableMeizuProxy(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    f.f = paramString1;
    m.a(paramContext, "BD_MEIZU_PROXY_APPID_KEY", paramString1);
    f.g = paramString2;
    m.a(paramContext, "BD_MEIZU_PROXY_APPKEY_KEY", paramString2);
    if (paramBoolean)
    {
      m.a(paramContext, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 1);
      return;
    }
    m.a(paramContext, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", 0);
  }
  
  public static void enableOppoProxy(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    f.h = paramString1;
    m.a(paramContext, "BD_OPPO_PROXY_APPKEY_KEY", paramString1);
    f.i = paramString2;
    m.a(paramContext, "BD_OPPO_PROXY_APPSECRET_KEY", paramString2);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      m.a(paramContext, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", i);
      return;
    }
  }
  
  public static void enableXiaomiProxy(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        break label41;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label56;
      }
      m.a(paramContext, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 1);
      return;
      f.d = paramString1;
      m.a(paramContext, "BD_PROXY_APPID_KEY", paramString1);
      break;
      label41:
      f.e = paramString2;
      m.a(paramContext, "BD_PROXY_APPKEY_KEY", paramString2);
    }
    label56:
    m.a(paramContext, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", 0);
  }
  
  public static int getBindType(Context paramContext)
  {
    if (!paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).getBoolean("bind_status", false)) {
      return 0;
    }
    if (com.baidu.android.pushservice.c.d.d(paramContext)) {
      return 2;
    }
    if (com.baidu.android.pushservice.c.d.c(paramContext)) {
      return 3;
    }
    if (com.baidu.android.pushservice.c.d.b(paramContext)) {
      return 4;
    }
    if (com.baidu.android.pushservice.c.d.e(paramContext)) {
      return 5;
    }
    return 1;
  }
  
  public static String getHWNotifyCheckInfo(Context paramContext, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {}
    try
    {
      str = f.d(paramContext, paramIntent);
      return str;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getHWNotifySignInfo(Context paramContext, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {}
    try
    {
      str = f.c(paramContext, paramIntent);
      return str;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean hwMessageVerify(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        bool1 = bool2;
        if (paramString2 != null) {
          bool1 = f.a(paramContext, paramString1, paramString2);
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static void insertPassThroughMessageClick(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        Intent localIntent = new Intent();
        if (localIntent != null)
        {
          if (com.baidu.android.pushservice.c.d.g(paramContext)) {}
          for (String str = paramContext.getPackageName(); str != null; str = p.v(paramContext))
          {
            com.baidu.android.pushservice.g.a.a("PushManager", "PassThroughMessageClick  : " + str, paramContext.getApplicationContext());
            localIntent.putExtra("app_id", paramString2);
            localIntent.putExtra("msg_id", paramString1);
            localIntent.setAction("com.baidu.android.pushservice.action.passthrough.notification.CLICK");
            localIntent.setClassName(str, "com.baidu.android.pushservice.CommandService");
            paramContext.startService(localIntent);
            return;
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        com.baidu.android.pushservice.g.a.b("PushManager", "error " + paramString1.getMessage(), paramContext.getApplicationContext());
      }
    }
  }
  
  public static void insertPassThroughMessageDelete(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        Intent localIntent = new Intent();
        if (localIntent != null)
        {
          if (com.baidu.android.pushservice.c.d.g(paramContext)) {}
          for (String str = paramContext.getPackageName(); str != null; str = p.v(paramContext))
          {
            com.baidu.android.pushservice.g.a.a("PushManager", "PassThroughMessageDelete  : " + str, paramContext.getApplicationContext());
            localIntent.putExtra("app_id", paramString2);
            localIntent.putExtra("msg_id", paramString1);
            localIntent.setAction("com.baidu.android.pushservice.action.passthrough.notification.DELETE");
            localIntent.setClassName(str, "com.baidu.android.pushservice.CommandService");
            paramContext.startService(localIntent);
            return;
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        com.baidu.android.pushservice.g.a.b("PushManager", "error " + paramString1.getMessage(), paramContext.getApplicationContext());
      }
    }
  }
  
  public static void insertPassThroughMessageNotified(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        Intent localIntent = new Intent();
        if (com.baidu.android.pushservice.c.d.g(paramContext)) {}
        for (String str = paramContext.getPackageName(); str != null; str = p.v(paramContext))
        {
          com.baidu.android.pushservice.g.a.a("PushManager", "PassThroughMessageNotified  : " + str, paramContext.getApplicationContext());
          localIntent.putExtra("app_id", paramString2);
          localIntent.putExtra("msg_id", paramString1);
          localIntent.setAction("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED");
          localIntent.setClassName(str, "com.baidu.android.pushservice.CommandService");
          paramContext.startService(localIntent);
          if (str.equals(paramContext.getPackageName())) {
            break;
          }
          localIntent.putExtra("self_insert", true);
          localIntent.setClassName(paramContext.getPackageName(), "com.baidu.android.pushservice.CommandService");
          paramContext.startService(localIntent);
          return;
        }
        return;
      }
      catch (Exception paramString1)
      {
        com.baidu.android.pushservice.g.a.b("PushManager", "error " + paramString1.getMessage(), paramContext.getApplicationContext());
      }
    }
  }
  
  public static boolean isPushEnabled(Context paramContext)
  {
    if (f.l(paramContext)) {}
    while (p.c(paramContext)) {
      return false;
    }
    return true;
  }
  
  public static void listTags(Context paramContext)
  {
    Intent localIntent = f.a(paramContext);
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("method", "method_listtags");
    com.baidu.android.pushservice.g.a.a("PushManager", "a listTags intent send", paramContext.getApplicationContext());
    f.b(paramContext, localIntent);
  }
  
  public static void resumeWork(Context paramContext)
  {
    if (f.l(paramContext)) {
      return;
    }
    a.b(paramContext, true);
    p.a(paramContext, true, true);
    a.a(paramContext, true);
    o.a(paramContext);
    f.b(paramContext, 0);
  }
  
  public static void setDefaultNotificationBuilder(Context paramContext, PushNotificationBuilder paramPushNotificationBuilder)
  {
    if (f.l(paramContext)) {
      return;
    }
    d.a(paramContext, paramPushNotificationBuilder);
  }
  
  public static void setMediaNotificationBuilder(Context paramContext, PushNotificationBuilder paramPushNotificationBuilder)
  {
    if (f.l(paramContext)) {
      return;
    }
    d.b(paramContext, paramPushNotificationBuilder);
  }
  
  public static void setNoDisturbMode(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (f.l(paramContext)) {
      return;
    }
    if ((paramInt1 < 0) || (paramInt1 > 23) || (paramInt3 < 0) || (paramInt3 > 23))
    {
      com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode hour parameters illegal!", paramContext.getApplicationContext());
      return;
    }
    if ((paramInt2 < 0) || (paramInt2 > 59) || (paramInt4 < 0) || (paramInt4 > 59))
    {
      com.baidu.android.pushservice.g.a.a("PushManager", "setNoDisturbMode minute parameters illegal!", paramContext.getApplicationContext());
      return;
    }
    String str = paramContext.getPackageName();
    com.baidu.android.pushservice.g.a.a("PushManager", "PushManager setNoDisturbMode package name: " + str, paramContext.getApplicationContext());
    com.baidu.android.pushservice.d.a.a(paramContext, str, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setNotificationBuilder(Context paramContext, int paramInt, PushNotificationBuilder paramPushNotificationBuilder)
  {
    if (f.l(paramContext)) {
      return;
    }
    if ((paramInt >= 1) && (paramInt <= 1000))
    {
      d.a(paramContext, paramInt, paramPushNotificationBuilder);
      return;
    }
    com.baidu.android.pushservice.g.a.b("PushManager", "set notification builder error, id is illegal !", paramContext.getApplicationContext());
  }
  
  public static void setTags(Context paramContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = f.a(paramContext);
    } while (localIntent == null);
    Object localObject = paramList.iterator();
    for (paramList = "["; ((Iterator)localObject).hasNext(); paramList = paramList + "\",")
    {
      String str = (String)((Iterator)localObject).next();
      paramList = paramList + "\"";
      paramList = paramList + str;
    }
    localObject = paramList;
    if (paramList.length() > 0) {
      localObject = paramList.substring(0, paramList.length() - 1);
    }
    paramList = (String)localObject + "]";
    localIntent.putExtra("method", "method_set_tags");
    localIntent.putExtra("tags", paramList);
    com.baidu.android.pushservice.g.a.a("PushManager", "a setTags intent send ", paramContext.getApplicationContext());
    f.b(paramContext, localIntent);
  }
  
  public static void startWork(Context paramContext, int paramInt, String paramString)
  {
    if (f.l(paramContext)) {
      return;
    }
    f.a = paramInt;
    f.b = paramString;
    h.b(paramContext);
    paramString = p.l(paramContext, paramString);
    m.a(paramContext, "com.baidu.android.pushservice.CHECK_SDK", paramString);
    com.baidu.android.pushservice.g.a.a("PushManager", "startWork from " + paramContext.getPackageName() + " checkResult: " + paramString, paramContext.getApplicationContext());
    p.b("startWork from " + paramContext.getPackageName() + " checkResult: " + paramString, paramContext);
    if (((TextUtils.equals("com.baidu.android.pushservice.CHECK_SDK_RESULT_OK", paramString)) || (!PushSettings.c(paramContext))) && (paramInt == 0)) {
      f.a(paramContext, paramInt, f.b, true);
    }
    for (;;)
    {
      p.A(paramContext);
      return;
      if (paramInt != 0) {
        Log.e("BDPushSDK-PushManager", "Wrong LOGIN TYPE, Please use LOGIN_TYPE_API_KEY !");
      }
      f.d(paramContext, 10101, paramString);
    }
  }
  
  public static void stopWork(Context paramContext)
  {
    if (f.l(paramContext)) {
      return;
    }
    p.b("stopWork from" + paramContext.getPackageName() + " at time of " + System.currentTimeMillis(), paramContext);
    if ((p.y(paramContext)) || (com.baidu.android.pushservice.c.d.g(paramContext)))
    {
      f.f(paramContext);
      a.b(paramContext, false);
      p.a(paramContext, true, true);
      a.a(paramContext, true);
      p.f(paramContext, paramContext.getPackageName());
      paramContext = paramContext.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
      paramContext.putBoolean("bind_status", false);
      paramContext.commit();
      return;
    }
    f.h(paramContext);
  }
  
  public static void syncPushEnabled(Context paramContext, String paramString, boolean paramBoolean, int paramInt, SyncCallback paramSyncCallback)
  {
    if ((f.l(paramContext)) || (!paramContext.getPackageName().startsWith("com.baidu")) || (TextUtils.isEmpty(paramString))) {
      if (paramSyncCallback != null) {
        paramSyncCallback.onSyncResult(-1);
      }
    }
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        f.a(paramContext, paramString, paramBoolean, paramInt, paramSyncCallback);
        return;
      case 1: 
        int i = new Random().nextInt(30);
        f.a(paramContext, paramString, paramBoolean, paramInt, System.currentTimeMillis() + (i + 1) * 24 * 3600 * 1000);
        return;
      }
    } while (com.baidu.android.pushservice.c.d.g(paramContext));
    f.a(paramContext, paramString, paramBoolean, paramInt, System.currentTimeMillis() + 21600000L);
  }
  
  public static abstract interface SyncCallback
  {
    public abstract void onSyncResult(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */