package com.baidu.carlife.service;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.baidu.carlife.CarlifeActivity;

public class NotificationDownloadService
  extends Service
{
  private NotificationManager a = null;
  private NotificationCompat.Builder b = null;
  private final int c = 8193;
  private CarlifeActivity d = null;
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    this.a.cancel(8193);
  }
  
  public void a(int paramInt)
  {
    if ((this.b == null) && (this.d != null))
    {
      Object localObject = new Intent(this.d, CarlifeActivity.class);
      TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this.d);
      localTaskStackBuilder.addParentStack(CarlifeActivity.class);
      localTaskStackBuilder.addNextIntent((Intent)localObject);
      localObject = localTaskStackBuilder.getPendingIntent(0, 134217728);
      this.b = new NotificationCompat.Builder(this.d).setSmallIcon(2130838698).setContentTitle("CarLife 正在下载").setProgress(100, paramInt, false).setContentIntent((PendingIntent)localObject).setOngoing(true);
      localObject = this.b.build();
      ((Notification)localObject).flags |= 0x10;
      this.a = ((NotificationManager)this.d.getSystemService("notification"));
      this.a.notify(8193, (Notification)localObject);
      return;
    }
    this.b.setProgress(100, paramInt, false);
    this.a.notify(8193, this.b.build());
  }
  
  public void a(Activity paramActivity)
  {
    this.d = ((CarlifeActivity)paramActivity);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new a();
  }
  
  public class a
    extends Binder
  {
    public a() {}
    
    public NotificationDownloadService a()
    {
      return NotificationDownloadService.this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/service/NotificationDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */