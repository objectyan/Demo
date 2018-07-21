package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.p;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class c
{
  protected int a;
  protected int b;
  protected int c;
  protected Uri d;
  protected long[] e;
  protected String f;
  protected String g;
  protected boolean h = false;
  private final String i;
  
  public c(String paramString)
  {
    this.i = paramString;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
  
  private Bitmap a(Drawable paramDrawable, Context paramContext)
  {
    int j = paramDrawable.getIntrinsicWidth();
    int k = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(j, k, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      paramDrawable.setBounds(0, 0, (int)(48.0F * f1), (int)(f1 * 48.0F));
      paramDrawable.draw(localCanvas);
      return (Bitmap)localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public void a(final Context paramContext, final PendingIntent paramPendingIntent, final String paramString)
  {
    int j = a(paramContext, "bpush_lapp_notification_status_icon");
    if (j > 0) {
      a(j);
    }
    while ((Build.VERSION.SDK_INT >= 16) && (!TextUtils.isEmpty(this.i)))
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Object localObject = Drawable.createFromStream(new URL(c.a(c.this)).openStream(), null);
            Notification.Builder localBuilder = new Notification.Builder(paramContext);
            if (p.G(paramContext))
            {
              l.a(paramContext, "com.baidu.android.pushservice.push", "Push");
              localBuilder.setChannelId("com.baidu.android.pushservice.push");
            }
            localObject = localBuilder.setContentTitle(c.this.f).setContentTitle(c.this.f).setContentText(c.this.g).setSmallIcon(c.this.a).setLargeIcon(c.a(c.this, (Drawable)localObject, paramContext)).build();
            if (c.this.b != 0) {
              ((Notification)localObject).flags = c.this.b;
            }
            if (c.this.h) {
              ((Notification)localObject).defaults = 0;
            }
            for (;;)
            {
              ((Notification)localObject).contentIntent = paramPendingIntent;
              ((NotificationManager)paramContext.getSystemService("notification")).notify(paramString, 0, (Notification)localObject);
              return;
              ((Notification)localObject).defaults = -1;
              if (c.this.c != 0) {
                ((Notification)localObject).defaults = c.this.c;
              }
              if (c.this.d != null) {
                ((Notification)localObject).sound = c.this.d;
              }
              if (c.this.e != null) {
                ((Notification)localObject).vibrate = c.this.e;
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            return;
          }
          catch (MalformedURLException localMalformedURLException) {}
        }
      }, "DownNotiIcon").start();
      return;
      a(17301620);
    }
    Notification localNotification = new Notification.Builder(paramContext).setContentTitle(this.f).setContentText(this.g).setSmallIcon(this.a).setContentIntent(paramPendingIntent).getNotification();
    if (this.h) {
      localNotification.defaults = 0;
    }
    for (;;)
    {
      if (this.b != 0) {
        localNotification.flags = this.b;
      }
      if (localNotification == null) {
        break;
      }
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      localNotification.contentIntent = paramPendingIntent;
      paramContext.notify(p.b(paramString), localNotification);
      return;
      localNotification.defaults = -1;
      if (this.c != 0) {
        localNotification.defaults = this.c;
      }
      if (this.d != null) {
        localNotification.sound = this.d;
      }
      if (this.e != null) {
        localNotification.vibrate = this.e;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */