package com.baidu.android.pushservice.message.a;

import android.annotation.SuppressLint;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.RingtoneManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.j.k;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import java.util.Locale;

public class f
{
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, PublicMsg paramPublicMsg, String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    Object localObject2 = new Intent(paramContext, PushService.class);
    ((Intent)localObject2).setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
    ((Intent)localObject2).setData(Uri.parse("content://" + paramString));
    ((Intent)localObject2).putExtra("public_msg", paramPublicMsg);
    Object localObject1 = new Intent(paramContext, PushService.class);
    ((Intent)localObject1).setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
    ((Intent)localObject1).setData(Uri.parse("content://" + paramString));
    ((Intent)localObject1).putExtra("public_msg", paramPublicMsg);
    ((Intent)localObject2).setClass(paramContext, PushService.class);
    ((Intent)localObject1).setClass(paramContext, PushService.class);
    localObject2 = PendingIntent.getService(paramContext, 0, (Intent)localObject2, 0);
    localObject1 = PendingIntent.getService(paramContext, 0, (Intent)localObject1, 0);
    paramContext = new Notification.Builder(paramContext).setContentTitle(paramPublicMsg.mTitle).setContentText(paramPublicMsg.mDescription).setSmallIcon(17301569).setTicker(paramPublicMsg.mTitle).setSound(RingtoneManager.getDefaultUri(2)).setDeleteIntent((PendingIntent)localObject1).setContentIntent((PendingIntent)localObject2).setAutoCancel(true);
    if (Build.VERSION.SDK_INT >= 16) {}
    for (paramContext = paramContext.build();; paramContext = paramContext.getNotification())
    {
      localNotificationManager.notify(p.b(paramString), paramContext);
      return;
    }
  }
  
  public static void a(Context paramContext, PublicMsg paramPublicMsg, String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_msg", paramPublicMsg);
    localIntent.putExtra("pushService_package_name", paramContext.getPackageName());
    localIntent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
    localIntent.putExtra("notify_type", "private");
    localIntent.putExtra("message_id", paramString1);
    localIntent.putExtra("app_id", paramString2);
    localIntent.putExtra("baidu_message_type", paramInt);
    if (p.m(paramContext, paramPublicMsg.mPkgName) > 45)
    {
      localIntent.putExtra("baidu_message_body", paramArrayOfByte2);
      localIntent.putExtra("baidu_message_secur_info", paramArrayOfByte1);
    }
    p.b(paramContext, localIntent, "com.baidu.android.pushservice.action.notification.SHOW", paramPublicMsg.mPkgName);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("com.baidu.android.pushservice.action.METHOD");
      localIntent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
      localIntent.putExtra("app_id", paramString);
      o.a(paramContext, localIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, PublicMsg paramPublicMsg, String paramString2, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_msg", paramPublicMsg);
    localIntent.putExtra("notify_type", "rich_media");
    localIntent.putExtra("app_id", paramString1);
    localIntent.putExtra("message_id", paramString2);
    localIntent.putExtra("pushService_package_name", paramContext.getPackageName());
    localIntent.putExtra("baidu_message_type", paramInt);
    localIntent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
    if (p.m(paramContext, paramPublicMsg.mPkgName) > 45)
    {
      localIntent.putExtra("baidu_message_body", paramArrayOfByte2);
      localIntent.putExtra("baidu_message_secur_info", paramArrayOfByte1);
    }
    p.b(paramContext, localIntent, "com.baidu.android.pushservice.action.notification.SHOW", paramPublicMsg.mPkgName);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString4));
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    paramString4 = PendingIntent.getActivity(paramContext, 0, localIntent, 0);
    paramString3 = new c(paramString3);
    paramString3.b(16);
    paramString3.c(3);
    paramString3.a(paramString1);
    paramString3.b(paramString2);
    paramString3.a(p.q(paramContext, localIntent.getPackage()));
    paramString3.a(paramContext, paramString4, paramString5);
  }
  
  public static boolean a(Context paramContext, PublicMsg paramPublicMsg)
  {
    if (paramPublicMsg.mNetType == 1)
    {
      NetworkInfo localNetworkInfo = k.c(paramContext);
      if ((localNetworkInfo == null) || (!"wifi".equals(localNetworkInfo.getTypeName().toLowerCase(Locale.getDefault())))) {
        break label112;
      }
    }
    label112:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {}
      do
      {
        return false;
        if (TextUtils.isEmpty(paramPublicMsg.mSupportAppname)) {
          return true;
        }
        paramContext = paramContext.getPackageManager();
        try
        {
          paramContext = paramContext.getPackageInfo(paramPublicMsg.mSupportAppname, 0);
          if (paramContext == null) {
            break;
          }
          i = 1;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          for (;;)
          {
            i = 0;
            continue;
            i = 0;
          }
        }
      } while (((!paramPublicMsg.mIsSupportApp) || (i == 0)) && ((paramPublicMsg.mIsSupportApp) || (i != 0)));
      return true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/message/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */