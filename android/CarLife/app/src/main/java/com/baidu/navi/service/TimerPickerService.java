package com.baidu.navi.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.navi.NaviOfflineActivityStarter;
import com.baidu.navi.controller.BGPSAlarmController;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TimerPickerService
  extends Service
{
  private static final int MAX_WAIT_TIME = 600000;
  private static final String NAVI_PACK_NAME = "com.baidu.carlife";
  private ILocationListener mGPSLocationListener = new ILocationListener()
  {
    public void onGpsStatusChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((paramAnonymousBoolean1 == true) && (paramAnonymousBoolean2 == true))
      {
        TimerPickerService.this.mHander.removeCallbacks(TimerPickerService.this.mTimeEndThread);
        TimerPickerService.this.stopService();
      }
    }
    
    public void onLocationChange(LocData paramAnonymousLocData)
    {
      if (paramAnonymousLocData != null)
      {
        TimerPickerService.this.mHander.removeCallbacks(TimerPickerService.this.mTimeEndThread);
        TimerPickerService.this.stopService();
      }
    }
    
    public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2) {}
  };
  private Handler mHander = new Handler();
  private int mServiceCount = 0;
  private Runnable mTimeEndThread = new Runnable()
  {
    public void run()
    {
      TimerPickerService.this.stopService();
    }
  };
  
  private void doGPSHotStart()
  {
    int i = new Date(System.currentTimeMillis()).getHours();
    if ((6 <= i) && (i <= 22))
    {
      if ((!BNSysLocationManager.getInstance().isGpsEnabled()) || (isNaviAppStart()))
      {
        stopService();
        return;
      }
      BNSysLocationManager.getInstance().init(this);
      BNSysLocationManager.getInstance().addLocationListener(this.mGPSLocationListener);
      this.mHander.postDelayed(this.mTimeEndThread, 600000L);
      return;
    }
    stopService();
  }
  
  private boolean isNaviAppStart()
  {
    Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningTasks(200).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localIterator.next();
      if (("com.baidu.carlife".equalsIgnoreCase(localRunningTaskInfo.topActivity.getPackageName())) && ("com.baidu.carlife".equalsIgnoreCase(localRunningTaskInfo.baseActivity.getPackageName()))) {
        return true;
      }
    }
    return false;
  }
  
  private void stopService()
  {
    this.mServiceCount -= 1;
    if (this.mServiceCount <= 0) {
      stopSelf();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate() {}
  
  public void onDestroy()
  {
    this.mHander.removeCallbacks(this.mTimeEndThread);
    BNSysLocationManager.getInstance().removeLocationListener(this.mGPSLocationListener);
    if (!isNaviAppStart()) {
      BNSysLocationManager.getInstance().unInit();
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    String str;
    if (paramIntent != null)
    {
      this.mServiceCount += 1;
      DBManager.init(this);
      str = paramIntent.getStringExtra("action");
      if (!"android.intent.action.BOOT_COMPLETED".equals(str)) {
        break label66;
      }
      BGPSAlarmController.getInstance().restartGPSAlarm(this);
      RouteCustomController.getInstance().calcPushTimeAndAddAlarmByRCList(this);
      if (!isNaviAppStart()) {
        DBManager.destroy();
      }
      stopService();
    }
    for (;;)
    {
      return 2;
      label66:
      if ("com.baidu.navi.alarm".equals(str))
      {
        paramInt1 = paramIntent.getIntExtra("id", -1);
        if (paramInt1 != -1) {
          sendNotify(this, paramInt1);
        }
        if (!isNaviAppStart()) {
          DBManager.destroy();
        }
        stopService();
      }
      else if ("com.baidu.navi.service.GPSAlarmService".equals(str))
      {
        BGPSAlarmController.getInstance().restartGPSAlarm(this);
        doGPSHotStart();
      }
    }
  }
  
  public void sendNotify(Context paramContext, int paramInt)
  {
    Object localObject = RouteCustomModel.getInstance().getRouteCustomInfoById(paramInt);
    if (localObject != null)
    {
      if (((RouteCustomDBObject)localObject).getIsRepeat() != 0) {
        break label212;
      }
      ((RouteCustomDBObject)localObject).setOpen(0);
      RouteCustomModel.getInstance().updateRouteCustomInfo((RouteCustomDBObject)localObject);
    }
    for (;;)
    {
      localObject = RouteCustomController.getInstance().getRCShowNameByDBId(paramInt);
      localObject = "查看" + (String)localObject + "的路程时间";
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      Notification localNotification = new Notification();
      localNotification.icon = 2130838698;
      localNotification.tickerText = ((CharSequence)localObject);
      localNotification.defaults = 3;
      localNotification.flags |= 0x10;
      DBManager.init(paramContext);
      Intent localIntent = new Intent("com.baidu.navi.action.START");
      localIntent.setClass(paramContext, NaviOfflineActivityStarter.class);
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("bdnavi://customroute?"));
      localIntent.putExtra("dbId", paramInt);
      localNotification.setLatestEventInfo(paramContext, "小度提醒您现在该出发啦", (CharSequence)localObject, PendingIntent.getActivity(paramContext, paramInt, localIntent, 0));
      localNotificationManager.notify(paramInt, localNotification);
      return;
      label212:
      long l = RouteCustomController.getInstance().getNextPushTimeMillsByRCId(paramInt);
      RouteCustomController.getInstance().deleteAlarmNotify(paramContext, paramInt);
      if (l != -1L) {
        RouteCustomController.getInstance().addAlarmNotify(paramContext, l, paramInt);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/service/TimerPickerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */