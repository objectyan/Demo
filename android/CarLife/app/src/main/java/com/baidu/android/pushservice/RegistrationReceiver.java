package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.pushservice.b.b;
import com.baidu.android.pushservice.b.f;
import com.baidu.android.pushservice.b.h;
import com.baidu.android.pushservice.i.c;
import com.baidu.android.pushservice.i.d;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;

public class RegistrationReceiver
  extends BroadcastReceiver
{
  static void a(Context paramContext, f paramf)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.baidu.android.pushservice.action.METHOD");
    localIntent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
    localIntent.putExtra("package_name", paramf.c());
    localIntent.putExtra("app_id", paramf.a());
    localIntent.putExtra("user_id", paramf.f);
    o.a(paramContext, localIntent);
  }
  
  private static void c(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("r_sync_from");
    if (paramContext.getPackageName().equals(str)) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("r_sync_rdata_v2");
    } while (TextUtils.isEmpty(paramIntent));
    b.a(paramContext).a("r_v2", paramIntent);
  }
  
  private static void d(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("r_sync_sdk_from");
    if (paramContext.getPackageName().equals(str)) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("r_sync_rdata_v2");
    } while (TextUtils.isEmpty(paramIntent));
    h.a(paramContext).a("com.baidu.push.sdkr", paramIntent);
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    String str = paramIntent.getAction();
    try
    {
      paramIntent.getByteArrayExtra("baidu_message_secur_info");
      if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
        try
        {
          str = p.u(paramContext);
          if ((!TextUtils.isEmpty(str)) && (!paramContext.getPackageName().equals(str))) {
            return;
          }
          str = paramIntent.getData().getSchemeSpecificPart();
          boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
          if (!bool) {
            PushSettings.c(paramContext, str);
          }
          paramIntent = b.a(paramContext).c(str);
          if ((bool) || (paramIntent == null) || (paramContext.getPackageName().equals(paramIntent.c()))) {
            return;
          }
          a(paramContext, paramIntent);
          return;
        }
        catch (Exception paramContext)
        {
          return;
        }
      }
      if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(str))
      {
        d.a().a(new c("register_sync", (short)99)
        {
          public void a()
          {
            if (paramIntent.hasExtra("r_sync_type"))
            {
              switch (paramIntent.getIntExtra("r_sync_type", 0))
              {
              case 1: 
              case 2: 
              default: 
                return;
              case 0: 
                RegistrationReceiver.a(paramContext, paramIntent);
                return;
              }
              RegistrationReceiver.b(paramContext, paramIntent);
              return;
            }
            RegistrationReceiver.a(paramContext, paramIntent);
          }
        });
        return;
      }
      o.b(paramContext, paramIntent);
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/RegistrationReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */