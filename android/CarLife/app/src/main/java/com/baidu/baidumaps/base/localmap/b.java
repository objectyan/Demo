package com.baidu.baidumaps.base.localmap;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.platform.comapi.util.f;

public class b
{
  private static volatile b a;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private NotificationManager f;
  private Notification g;
  private Notification h;
  private Notification i;
  private Notification j;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  
  private b(Context paramContext)
  {
    this.f = ((NotificationManager)paramContext.getSystemService("notification"));
    b(paramContext);
    c(paramContext);
    d(paramContext);
    e(paramContext);
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  private void b(Context paramContext)
  {
    this.g = new Notification();
    this.g.flags = 16;
    this.g.icon = 2130838698;
    new Bundle();
    Intent localIntent = new Intent(paramContext, CarlifeActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("OpenDownloadManager", "openmap");
    this.g.contentIntent = PendingIntent.getActivity(paramContext, 1, localIntent, 0);
    paramContext = new RemoteViews(paramContext.getPackageName(), 2130969022);
    paramContext.setTextViewText(2131626086, "0%");
    this.g.contentView = paramContext;
  }
  
  private void c(Context paramContext)
  {
    this.h = new Notification();
    this.h.flags = 16;
    this.h.icon = 2130838698;
    new Bundle();
    Intent localIntent = new Intent(paramContext, CarlifeActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("OpenDownloadManager", "openmap");
    this.h.contentIntent = PendingIntent.getActivity(paramContext, 2, localIntent, 0);
    paramContext = new RemoteViews(paramContext.getPackageName(), 2130969024);
    paramContext.setTextViewText(2131626086, this.k + "%");
    this.h.contentView = paramContext;
  }
  
  private void d(Context paramContext)
  {
    this.i = new Notification();
    this.i.flags = 16;
    this.i.icon = 2130838698;
    Intent localIntent = new Intent(paramContext, LMBroadcastReceiver.class);
    localIntent.setAction("com.baidu.BaiduMap.ON_LM_NOTIFICATION_FINISHED");
    this.i.contentIntent = PendingIntent.getBroadcast(paramContext, 3, localIntent, 0);
    this.i.contentView = new RemoteViews(paramContext.getPackageName(), 2130969023);
  }
  
  private void e(Context paramContext)
  {
    this.j = new Notification();
    this.j.tickerText = "离线地图导入中...";
    this.j.flags = 16;
    this.j.icon = 2130838698;
    new Bundle();
    Intent localIntent = new Intent(paramContext, CarlifeActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("OpenDownloadManager", "openmap");
    this.j.contentIntent = PendingIntent.getActivity(paramContext, 4, localIntent, 0);
    this.j.contentView = new RemoteViews(paramContext.getPackageName(), 2130968980);
  }
  
  public void a()
  {
    try
    {
      this.f.cancel(4);
      return;
    }
    catch (Exception localException)
    {
      f.a(b.class.getSimpleName(), "cancelImportNotif exception", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 <= 0) || (paramInt1 > paramInt2)) {}
    try
    {
      this.f.cancel(4);
      return;
    }
    catch (Exception localException)
    {
      f.a(b.class.getSimpleName(), "exception", localException);
      return;
    }
    this.j.contentView.setProgressBar(2131625962, paramInt2, paramInt1 + paramInt3, false);
    if (paramInt1 + paramInt3 == paramInt2) {
      if (paramInt3 > 0) {
        this.j.contentView.setTextViewText(2131625963, "共成功导入" + paramInt1 + "个城市, 失败" + paramInt3 + "个");
      }
    }
    for (;;)
    {
      this.f.notify(4, this.j);
      return;
      this.j.contentView.setTextViewText(2131625963, "导入完成，共导入" + paramInt1 + "个城市");
      continue;
      this.j.contentView.setTextViewText(2131625963, "已导入" + paramInt1 + "个城市/共" + paramInt2 + "个城市");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.f.cancel(1);
      this.h.contentView.setTextViewText(2131625346, paramString);
      this.h.contentView.setProgressBar(2131626083, 100, this.k, false);
      this.h.contentView.setTextViewText(2131626086, this.k + "%");
      this.f.notify(2, this.h);
      return;
    }
    catch (Exception paramString)
    {
      f.a(b.class.getSimpleName(), "exception", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.f.cancel(2);
      this.f.cancel(3);
      a(false);
      this.k = paramInt;
      this.g.contentView.setProgressBar(2131626083, 100, paramInt, false);
      this.g.contentView.setTextViewText(2131625346, paramString);
      this.g.contentView.setTextViewText(2131626086, paramInt + "%");
      this.f.notify(1, this.g);
      this.m = true;
      return;
    }
    catch (Exception paramString)
    {
      f.a(b.class.getSimpleName(), "exception", paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      this.f.cancel(1);
      this.f.cancel(2);
      this.f.cancel(3);
      this.f.cancel(4);
      a(false);
      this.m = false;
      return;
    }
    catch (Exception localException)
    {
      f.a(b.class.getSimpleName(), "clearAllNotifs exception", localException);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.f.cancel(1);
      this.f.cancel(2);
      if (this.m)
      {
        this.i.contentView.setTextViewText(2131625346, paramString);
        this.f.notify(3, this.i);
        this.m = false;
        a(true);
        return;
      }
      if (this.l)
      {
        this.i.contentView.setTextViewText(2131625346, paramString);
        this.f.notify(3, this.i);
        return;
      }
    }
    catch (Exception paramString)
    {
      f.a(b.class.getSimpleName(), "exception", paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidumaps/base/localmap/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */