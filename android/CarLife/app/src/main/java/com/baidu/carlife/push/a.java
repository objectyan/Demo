package com.baidu.carlife.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.baidu.android.pushservice.BasicPushNotificationBuilder;
import com.baidu.android.pushservice.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.PushNotificationBuilder;
import com.baidu.carlife.core.i;
import com.baidu.carlife.util.p;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static final String a = "CarLifePushManager";
  private static a b = null;
  private static final String d = "sNSt3EBpSKeOTqnvN7LZjKGW";
  private static String e = null;
  private Context c = null;
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public static void a(String paramString)
  {
    e = paramString;
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = paramString1.length() + 13;
    int j = paramString2.length();
    paramString1 = new SpannableString("设置成功，免打扰时段为：\\n%1$s - %2$s");
    paramString1.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131558748)), 13, i, 17);
    paramString1.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(2131558748)), i + 3, i + 3 + j, 17);
    Toast.makeText(this.c, paramString1, 1).show();
  }
  
  public static String b()
  {
    return e;
  }
  
  private void d()
  {
    PushManager.startWork(this.c.getApplicationContext(), 0, b.a(this.c, "api_key"));
  }
  
  private void e()
  {
    PushManager.listTags(this.c.getApplicationContext());
  }
  
  private void f()
  {
    if ((0 == 0) && (0 == 0) && (0 == 0) && (0 == 0)) {
      Toast.makeText(this.c, "已取消 免打扰时段功能", 0).show();
    }
    for (;;)
    {
      PushManager.setNoDisturbMode(this.c, 0, 0, 0, 0);
      return;
      if ((0 > 0) || ((0 == 0) && (0 > 0))) {
        a("第一天的" + 0 + ":" + 0, "第二天的" + 0 + ":" + 0);
      } else {
        a(0 + ":" + 0, 0 + ":" + 0);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    i.b("CarLifePushManager", "Start push work");
    this.c = paramContext;
    PushManager.startWork(com.baidu.carlife.core.a.a().getApplicationContext(), 0, "sNSt3EBpSKeOTqnvN7LZjKGW");
    i.b("CarLifePushManager", "End push work");
    Object localObject = new BasicPushNotificationBuilder();
    ((BasicPushNotificationBuilder)localObject).setChannelId("testDefaultChannelId");
    ((BasicPushNotificationBuilder)localObject).setChannelName("testDefaultChannelName");
    localObject = new CustomPushNotificationBuilder(2130968964, 2131625857, 2131625858, 2131625859);
    ((CustomPushNotificationBuilder)localObject).setNotificationFlags(16);
    ((CustomPushNotificationBuilder)localObject).setNotificationDefaults(2);
    ((CustomPushNotificationBuilder)localObject).setStatusbarIcon(paramContext.getApplicationInfo().icon);
    ((CustomPushNotificationBuilder)localObject).setNotificationSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "6").toString());
    ((CustomPushNotificationBuilder)localObject).setChannelId("testId");
    ((CustomPushNotificationBuilder)localObject).setChannelName("testName");
    PushManager.setNotificationBuilder(paramContext, 1, (PushNotificationBuilder)localObject);
    paramContext = new ArrayList();
    paramContext.add(p.a().a("carlifevehicle_channel", "20022100"));
    PushManager.setTags(this.c, paramContext);
  }
  
  public void c()
  {
    PushManager.stopWork(this.c.getApplicationContext());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/push/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */