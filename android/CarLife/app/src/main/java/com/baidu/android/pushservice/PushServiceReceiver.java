package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.android.pushservice.d.a.g;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.richmedia.MediaViewActivity;
import com.baidu.android.pushservice.richmedia.b;
import com.baidu.android.pushservice.richmedia.c.a;
import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class PushServiceReceiver
  extends BroadcastReceiver
{
  private final ReentrantLock a = new ReentrantLock();
  
  private static Intent a(String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      return localIntent;
    }
    catch (Exception paramString)
    {
      try
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramString));
        localIntent.setFlags(268435456);
        return localIntent;
      }
      catch (Exception paramString) {}
      paramString = paramString;
      return null;
    }
  }
  
  public static void a(Context paramContext, PublicMsg paramPublicMsg)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      paramContext = Toast.makeText(paramContext, "请插入SD卡", 1);
      paramContext.setGravity(17, 0, 0);
      paramContext.show();
    }
    do
    {
      do
      {
        return;
      } while ((paramPublicMsg == null) || (paramPublicMsg.mUrl == null));
      localObject1 = Uri.parse(paramPublicMsg.mUrl);
      localObject2 = ((Uri)localObject1).getPath();
    } while (TextUtils.isEmpty(((Uri)localObject1).getPath()));
    Object localObject2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "baidu/pushservice/files" + "/" + ((Uri)localObject1).getAuthority() + "/" + ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf('/')));
    Object localObject1 = com.baidu.android.pushservice.richmedia.d.a(c.a.a, ((Uri)localObject1).toString());
    ((com.baidu.android.pushservice.richmedia.c)localObject1).a = paramPublicMsg.mPkgName;
    ((com.baidu.android.pushservice.richmedia.c)localObject1).b = ((File)localObject2).getAbsolutePath();
    ((com.baidu.android.pushservice.richmedia.c)localObject1).c = paramPublicMsg.mTitle;
    ((com.baidu.android.pushservice.richmedia.c)localObject1).d = paramPublicMsg.mDescription;
    new com.baidu.android.pushservice.richmedia.a(paramContext, new a(paramContext, paramPublicMsg), (com.baidu.android.pushservice.richmedia.c)localObject1).start();
  }
  
  private static void a(Context paramContext, PublicMsg paramPublicMsg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(paramPublicMsg.mPkgName);
    localIntent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
    localIntent.putExtra("msgid", paramPublicMsg.mMsgId);
    localIntent.putExtra("notification_title", paramPublicMsg.mTitle);
    localIntent.putExtra("notification_content", paramPublicMsg.mDescription);
    localIntent.putExtra("extra_extra_custom_content", paramPublicMsg.mCustomContent);
    localIntent.putExtra("com.baidu.pushservice.app_id", paramPublicMsg.mAppId);
    localIntent.putExtra("baidu_message_secur_info", paramArrayOfByte1);
    localIntent.putExtra("baidu_message_body", paramArrayOfByte2);
    p.a(paramContext, paramPublicMsg.mMsgId, paramPublicMsg.mAppId, paramPublicMsg.mTitle, paramPublicMsg.mDescription, paramPublicMsg.mCustomContent);
    p.b(paramContext, localIntent, "com.baidu.android.pushservice.action.RECEIVE", paramPublicMsg.mPkgName);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, PublicMsg paramPublicMsg)
  {
    try
    {
      paramString2 = (NotificationManager)paramContext.getSystemService("notification");
      boolean bool = TextUtils.isEmpty(paramPublicMsg.mPkgContent);
      if (!bool) {}
      for (;;)
      {
        try
        {
          paramString1 = Intent.parseUri(paramPublicMsg.mPkgContent, 1);
          paramString1.setPackage(paramContext.getPackageName());
          if (paramString1 == null) {
            break;
          }
          paramString1 = PendingIntent.getActivity(paramContext, 0, paramString1, 0);
          paramContext = d.a(paramContext, 0, 7, paramPublicMsg.mTitle, paramPublicMsg.mDescription, false);
          if (paramContext == null) {
            break;
          }
          paramContext.contentIntent = paramString1;
          long l = System.currentTimeMillis();
          paramString2.notify(l + "", 0, paramContext);
          return;
        }
        catch (URISyntaxException paramString1)
        {
          paramString1 = b(paramContext, paramPublicMsg);
          continue;
        }
        if (!TextUtils.isEmpty(paramPublicMsg.mUrl)) {
          paramString1 = a(paramPublicMsg.mUrl);
        } else {
          paramString1 = b(paramContext, paramPublicMsg);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static Intent b(Context paramContext, PublicMsg paramPublicMsg)
  {
    try
    {
      Intent localIntent = new Intent();
      return localIntent;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramPublicMsg = paramPublicMsg.getLauncherActivityName(paramContext, paramContext.getPackageName());
        localIntent.setClassName(paramContext.getPackageName(), paramPublicMsg);
        localIntent.setFlags(268435456);
        return localIntent;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      return null;
    }
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, PublicMsg paramPublicMsg, String paramString3)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    Object localObject = new Intent("com.baidu.android.pushservice.action.media.CLICK");
    ((Intent)localObject).setClassName(paramString1, paramString2);
    ((Intent)localObject).setData(Uri.parse("content://" + paramPublicMsg.mMsgId));
    ((Intent)localObject).putExtra("public_msg", paramPublicMsg);
    ((Intent)localObject).putExtra("app_id", paramString3);
    localObject = PendingIntent.getService(paramContext, 0, (Intent)localObject, 0);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramString1, paramString2);
    localIntent.setAction("com.baidu.android.pushservice.action.media.DELETE");
    localIntent.setData(Uri.parse("content://" + paramPublicMsg.mMsgId));
    localIntent.putExtra("public_msg", paramPublicMsg);
    localIntent.putExtra("app_id", paramString3);
    paramString1 = PendingIntent.getService(paramContext, 0, localIntent, 0);
    boolean bool = p.q(paramContext, paramPublicMsg.mPkgName);
    paramContext = d.a(paramContext, 8888, paramPublicMsg.mTitle, "富媒体消息：点击后下载与查看", bool);
    paramContext.contentIntent = ((PendingIntent)localObject);
    paramContext.deleteIntent = paramString1;
    localNotificationManager.notify(paramPublicMsg.mMsgId, 0, paramContext);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, PublicMsg paramPublicMsg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramString1, paramString2);
    ((Intent)localObject).setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
    ((Intent)localObject).setData(Uri.parse("content://" + paramPublicMsg.mMsgId));
    ((Intent)localObject).putExtra("public_msg", paramPublicMsg);
    ((Intent)localObject).putExtra("app_id", paramPublicMsg.mAppId);
    ((Intent)localObject).putExtra("msg_id", paramPublicMsg.mMsgId);
    ((Intent)localObject).putExtra("baidu_message_secur_info", paramArrayOfByte1);
    ((Intent)localObject).putExtra("baidu_message_body", paramArrayOfByte2);
    localObject = PendingIntent.getService(paramContext, 0, (Intent)localObject, 0);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramString1, paramString2);
    localIntent.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
    localIntent.setData(Uri.parse("content://" + paramPublicMsg.mMsgId));
    localIntent.putExtra("public_msg", paramPublicMsg);
    localIntent.putExtra("app_id", paramPublicMsg.mAppId);
    localIntent.putExtra("msg_id", paramPublicMsg.mMsgId);
    paramString2 = PendingIntent.getService(paramContext, 0, localIntent, 0);
    boolean bool = p.q(paramContext, paramPublicMsg.mPkgName);
    if (paramPublicMsg.mNotificationBuilder == 0) {}
    for (paramString1 = d.a(paramContext, paramPublicMsg.mNotificationBuilder, paramPublicMsg.mNotificationBasicStyle, paramPublicMsg.mTitle, paramPublicMsg.mDescription, bool);; paramString1 = d.a(paramContext, paramPublicMsg.mNotificationBuilder, paramPublicMsg.mTitle, paramPublicMsg.mDescription, bool))
    {
      paramString1.contentIntent = ((PendingIntent)localObject);
      paramString1.deleteIntent = paramString2;
      localNotificationManager.notify(paramPublicMsg.mMsgId, 0, paramString1);
      a(paramContext, paramPublicMsg, paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    final Object localObject = paramIntent.getAction();
    try
    {
      paramIntent.getByteArrayExtra("baidu_message_secur_info");
      if (("android.intent.action.BOOT_COMPLETED".equals(localObject)) || ("android.net.conn.CONNECTIVITY_CHANGE".equals(localObject)) || ("android.intent.action.USER_PRESENT".equals(localObject)) || ("android.intent.action.MEDIA_CHECKING".equals(localObject)) || ("android.intent.action.ACTION_POWER_CONNECTED".equals(localObject)) || ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(localObject)) || ("android.bluetooth.adapter.action.STATE_CHANGED".equals(localObject))) {
        if ((!com.baidu.android.pushservice.c.d.g(paramContext)) && (p.h(paramContext.getApplicationContext()) > 0L)) {
          o.d(paramContext);
        }
      }
      for (;;)
      {
        return;
        if ("com.baidu.android.pushservice.action.notification.SHOW".equals(localObject))
        {
          if (!com.baidu.android.pushservice.c.d.g(paramContext))
          {
            if (!p.y(paramContext))
            {
              f.g(paramContext);
              return;
            }
            localObject = paramIntent.getStringExtra("pushService_package_name");
            final String str1 = paramIntent.getStringExtra("service_name");
            final String str2 = paramIntent.getStringExtra("notify_type");
            final String str3 = paramIntent.getStringExtra("app_id");
            final byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("baidu_message_body");
            final byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("baidu_message_secur_info");
            int i = paramIntent.getIntExtra("baidu_message_type", -1);
            paramIntent = paramIntent.getStringExtra("message_id");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (arrayOfByte1 != null) && (arrayOfByte2 != null) && (i != -1) && (!p.t(paramContext, paramIntent))) {
              com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("showPrivateNotification", (short)99)
              {
                public void a()
                {
                  PublicMsg localPublicMsg = com.baidu.android.pushservice.message.a.e.a(paramContext, str3, paramIntent, arrayOfByte2, arrayOfByte1);
                  if (localPublicMsg == null) {}
                  do
                  {
                    return;
                    p.a(paramContext, localPublicMsg);
                    if ("private".equals(str2))
                    {
                      PushServiceReceiver.a(paramContext, localObject, str1, localPublicMsg, arrayOfByte2, arrayOfByte1);
                      return;
                    }
                  } while (!"rich_media".equals(str2));
                  PushServiceReceiver.a(paramContext, localObject, str1, localPublicMsg, str3);
                }
              });
            }
          }
        }
        else if ("com.baidu.android.pushservice.action.media.CLICK".equals(localObject))
        {
          com.baidu.android.pushservice.g.a.a("PushServiceReceiver", "Rich media notification clicked", paramContext.getApplicationContext());
          localObject = null;
          try
          {
            if (paramIntent.hasExtra("public_msg")) {
              localObject = (PublicMsg)paramIntent.getParcelableExtra("public_msg");
            }
            if (p.b(paramContext, (PublicMsg)localObject))
            {
              a(paramContext, (PublicMsg)localObject);
              return;
            }
          }
          catch (ClassCastException paramContext) {}
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static class a
    implements com.baidu.android.pushservice.richmedia.f
  {
    public Context a = null;
    public RemoteViews b = null;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    NotificationManager g;
    
    a(Context paramContext, PublicMsg paramPublicMsg)
    {
      this.a = paramContext;
      this.g = ((NotificationManager)paramContext.getSystemService("notification"));
    }
    
    public void a(com.baidu.android.pushservice.richmedia.a parama)
    {
      parama = this.a.getResources();
      String str = this.a.getPackageName();
      if (parama == null) {}
      int i;
      do
      {
        return;
        i = parama.getIdentifier("bpush_download_progress", "layout", str);
        this.b = new RemoteViews(this.a.getPackageName(), i);
      } while (i == 0);
      this.c = parama.getIdentifier("bpush_download_progress", "id", str);
      this.d = parama.getIdentifier("bpush_progress_percent", "id", str);
      this.e = parama.getIdentifier("bpush_progress_text", "id", str);
      this.f = parama.getIdentifier("bpush_download_icon", "id", str);
      this.b.setImageViewResource(this.f, this.a.getApplicationInfo().icon);
    }
    
    @SuppressLint({"NewApi"})
    public void a(com.baidu.android.pushservice.richmedia.a parama, b paramb)
    {
      String str = parama.d.c();
      if (paramb.a == paramb.b) {}
      while (this.b == null) {
        return;
      }
      int i = (int)(paramb.a * 100.0D / paramb.b);
      this.b.setTextViewText(this.d, i + "%");
      this.b.setTextViewText(this.e, "正在下载富媒体:" + str);
      this.b.setProgressBar(this.c, 100, i, false);
      if (Build.VERSION.SDK_INT >= 16) {}
      for (parama = new Notification.Builder(this.a).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build();; parama = new Notification(17301633, null, System.currentTimeMillis()))
      {
        parama.contentView = this.b;
        parama.contentIntent = PendingIntent.getActivity(this.a, 0, new Intent(), 0);
        parama.flags |= 0x20;
        parama.flags |= 0x2;
        this.g.notify(str, 0, parama);
        return;
      }
    }
    
    public void a(com.baidu.android.pushservice.richmedia.a parama, com.baidu.android.pushservice.richmedia.e parame)
    {
      parama = parama.d.c();
      this.g.cancel(parama, 0);
      parame = com.baidu.android.pushservice.d.a.a(this.a, parama);
      ContentValues localContentValues;
      if ((parame != null) && (parame.i == com.baidu.android.pushservice.richmedia.a.f))
      {
        parama = parame.e;
        parame = parame.f;
        if ((!TextUtils.isEmpty(parame)) && (parame.length() > 0))
        {
          parama = parama + "/" + parame.substring(0, parame.lastIndexOf(".")) + "/index.html";
          parame = new Intent();
          parame.setClass(this.a, MediaViewActivity.class);
          int i = p.A(this.a, this.a.getPackageName());
          parama = new File(parama);
          if (i < 24) {
            break label213;
          }
          localContentValues = new ContentValues(1);
          localContentValues.put("_data", parama.getAbsolutePath());
        }
      }
      for (parama = this.a.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);; parama = Uri.fromFile(parama))
      {
        parame.setData(parama);
        parame.addFlags(268435456);
        try
        {
          this.a.startActivity(parame);
          return;
        }
        catch (ActivityNotFoundException parama)
        {
          label213:
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              Toast.makeText(PushServiceReceiver.a.this.a, "富媒体推送没有声明必须的Activity，请检查！", 1).show();
            }
          });
          com.baidu.android.pushservice.g.a.a("PushServiceReceiver", parama, this.a);
        }
      }
    }
    
    public void a(final com.baidu.android.pushservice.richmedia.a parama, Throwable paramThrowable)
    {
      if (this.a == null) {
        return;
      }
      parama = parama.d.c();
      this.g.cancel(parama, 0);
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          Toast localToast = Toast.makeText(PushServiceReceiver.a.this.a, "下载富媒体" + Uri.parse(parama).getAuthority() + "失败", 1);
          localToast.setGravity(17, 0, 0);
          localToast.show();
        }
      });
    }
    
    public void b(com.baidu.android.pushservice.richmedia.a parama)
    {
      parama = parama.d.c();
      this.g.cancel(parama, 0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushServiceReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */