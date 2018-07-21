package com.baidu.navi.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class BGPSAlarmController
{
  public static final int ALARM_TIME = 10800000;
  public static final String GPS_HOT_START_ALARM_BROADCAST = "com.baidu.navi.GPSHostStart.alarm";
  public static final String INTERVAL_TIME = "interval_time";
  private static final String TAG = "BGPSAlarmController";
  public static final int mPendIntentId = 28888;
  
  public static BGPSAlarmController getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public void addGPSAlarmNotify(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext = PendingIntent.getBroadcast(paramContext, 28888, new Intent("com.baidu.navi.GPSHostStart.alarm"), 0);
    localAlarmManager.set(1, System.currentTimeMillis() + 10800000L, paramContext);
  }
  
  public void deleteGPSAlarmNotify(Context paramContext)
  {
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(paramContext, 28888, new Intent("com.baidu.navi.GPSHostStart.alarm"), 0));
  }
  
  public void restartGPSAlarm(Context paramContext)
  {
    deleteGPSAlarmNotify(paramContext);
    addGPSAlarmNotify(paramContext);
  }
  
  private static class LazyHolder
  {
    private static final BGPSAlarmController sInstance = new BGPSAlarmController();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/BGPSAlarmController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */