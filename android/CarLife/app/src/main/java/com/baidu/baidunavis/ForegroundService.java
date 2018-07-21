package com.baidu.baidunavis;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.baidu.platform.comapi.c;

public class ForegroundService
  extends Service
{
  private static final int RES_ID = 2130968580;
  private static final String TAG = "ForegroundService";
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Notification localNotification3 = new Notification();
    Notification localNotification1 = localNotification3;
    try
    {
      if (c.f() != null) {
        localNotification1 = new NotificationCompat.Builder(c.f()).setSmallIcon(2130838698).setTicker("正在导航").setWhen(System.currentTimeMillis()).setContentTitle("正在导航").setContentText("百度地图").build();
      }
      startForeground(2130968580, localNotification1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Notification localNotification2 = localNotification3;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/ForegroundService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */