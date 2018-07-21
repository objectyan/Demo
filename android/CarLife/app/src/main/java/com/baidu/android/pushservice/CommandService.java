package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.l;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CommandService
  extends Service
{
  private void a(Intent paramIntent)
  {
    String str = p.c(this, getPackageName(), paramIntent.getAction());
    p.b("CommandService#onStartCommand#reflectReceiver#recevier = " + str, this);
    if (TextUtils.isEmpty(str))
    {
      paramIntent.setPackage(getPackageName());
      sendBroadcast(paramIntent);
      return;
    }
    try
    {
      Object localObject2 = Class.forName(str);
      Object localObject1 = ((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]);
      localObject2 = ((Class)localObject2).getMethod("onReceive", new Class[] { Context.class, Intent.class });
      paramIntent.setClassName(getPackageName(), str);
      ((Method)localObject2).invoke(localObject1, new Object[] { getApplicationContext(), paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  private void b(Intent paramIntent)
  {
    try
    {
      String str1 = paramIntent.getStringExtra("bd.cross.request.SOURCE_SERVICE");
      String str2 = paramIntent.getStringExtra("bd.cross.request.SOURCE_PACKAGE");
      if (!TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(str2)) {
          return;
        }
        paramIntent.setPackage(str2);
        paramIntent.setClassName(str2, str1);
        paramIntent.setAction("com.baidu.android.pushservice.action.CROSS_REQUEST");
        paramIntent.putExtra("bd.cross.request.SENDING", false);
        getApplicationContext().startService(paramIntent);
        return;
      }
    }
    catch (Exception paramIntent) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    String str1 = null;
    if (paramIntent == null) {
      return 2;
    }
    String str2 = paramIntent.getAction();
    p.b("CommandService#onStartCommand#action = " + str2, this);
    try
    {
      if (("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str2)) || ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str2)) || ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str2)))
      {
        p.b("push_passthrough: receive  click delete and notified action", getApplicationContext());
        if (!paramIntent.hasExtra("app_id")) {
          break label377;
        }
      }
      label377:
      for (localObject = paramIntent.getStringExtra("app_id");; localObject = null)
      {
        if (paramIntent.hasExtra("msg_id")) {
          str1 = paramIntent.getStringExtra("msg_id");
        }
        l.a(getApplicationContext(), str1, (String)localObject, str2);
        if (paramIntent.getBooleanExtra("self_insert", false)) {
          new q(this).a();
        }
        stopSelf();
        return 2;
        if (("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(str2)) || ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str2)))
        {
          localObject = (PublicMsg)paramIntent.getParcelableExtra("public_msg");
          str1 = paramIntent.getStringExtra("app_id");
          String str3 = paramIntent.getStringExtra("msg_id");
          byte[] arrayOfByte = paramIntent.getByteArrayExtra("baidu_message_secur_info");
          paramIntent = paramIntent.getByteArrayExtra("baidu_message_body");
          ((PublicMsg)localObject).handlePrivateNotification(getApplicationContext(), str2, str3, str1, arrayOfByte, paramIntent);
          if ("com.baidu.android.pushservice.action.privatenotification.CLICK".equals(str2)) {
            q.a(getApplicationContext(), str3, "010203");
          }
          for (;;)
          {
            stopSelf();
            return 2;
            if ("com.baidu.android.pushservice.action.privatenotification.DELETE".equals(str2)) {
              q.a(getApplicationContext(), str3, "010204");
            }
          }
        }
        if (paramIntent.hasExtra("command_type")) {
          localObject = paramIntent.getStringExtra("command_type");
        }
        if ("reflect_receiver".equals(localObject)) {
          a(paramIntent);
        }
        for (;;)
        {
          stopSelf();
          return 2;
          if (paramIntent.hasExtra("bd.cross.request.COMMAND_TYPE"))
          {
            localObject = paramIntent.getStringExtra("bd.cross.request.COMMAND_TYPE");
            if ("bd.cross.command.MESSAGE_DELIVER".equals(localObject)) {
              a(paramIntent);
            } else if ("bd.cross.command.MESSAGE_ACK".equals(localObject)) {
              b(paramIntent);
            }
          }
        }
      }
      return 2;
    }
    catch (RuntimeException paramIntent) {}
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/CommandService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */