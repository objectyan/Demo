package com.baidu.navi;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.navisdk.BNaviEngineManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ForegroundService
  extends Service
{
  static final String ACTION_BACKGROUND = "com.example.android.apis.BACKGROUND";
  static final String ACTION_FOREGROUND = "com.example.android.apis.FOREGROUND";
  private static final Class<?>[] mSetForegroundSignature = { Boolean.TYPE };
  private static final Class<?>[] mStartForegroundSignature = { Integer.TYPE, Notification.class };
  private static final Class<?>[] mStopForegroundSignature = { Boolean.TYPE };
  private NotificationManager mNM;
  private Method mSetForeground;
  private Object[] mSetForegroundArgs = new Object[1];
  private Method mStartForeground;
  private Object[] mStartForegroundArgs = new Object[2];
  private Method mStopForeground;
  private Object[] mStopForegroundArgs = new Object[1];
  
  public static void start(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("com.example.android.apis.FOREGROUND");
      localIntent.setClass(paramContext, ForegroundService.class);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      i.a(paramContext);
    }
  }
  
  public static void stop(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("com.example.android.apis.FOREGROUND");
      localIntent.setClass(paramContext, ForegroundService.class);
      paramContext.stopService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      i.a(paramContext);
    }
  }
  
  void handleCommand(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.example.android.apis.FOREGROUND".equals(paramIntent.getAction())))
    {
      paramIntent = getString(2131296825);
      localNotification = new Notification.Builder(this).setContentTitle(getString(2131296296)).setContentText(paramIntent).setSmallIcon(2130838698).setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130838698)).build();
      localPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, CarlifeActivity.class), 0);
      localNotification.setLatestEventInfo(this, getString(2131296296), paramIntent, localPendingIntent);
      startForegroundCompat(2131298762, localNotification);
    }
    while (!"com.example.android.apis.BACKGROUND".equals(paramIntent.getAction()))
    {
      Notification localNotification;
      PendingIntent localPendingIntent;
      return;
    }
    stopForegroundCompat(2131298762);
  }
  
  void invokeMethod(Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramMethod.invoke(this, paramArrayOfObject);
      return;
    }
    catch (InvocationTargetException paramMethod)
    {
      i.e("ApiDemos", "Unable to invoke method" + paramMethod.getMessage());
      return;
    }
    catch (IllegalAccessException paramMethod)
    {
      i.e("ApiDemos", "Unable to invoke method" + paramMethod.getMessage());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    this.mNM = ((NotificationManager)getSystemService("notification"));
    try
    {
      this.mStartForeground = getClass().getMethod("startForeground", mStartForegroundSignature);
      this.mStopForeground = getClass().getMethod("stopForeground", mStopForegroundSignature);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      this.mStopForeground = null;
      this.mStartForeground = null;
      try
      {
        this.mSetForeground = getClass().getMethod("setForeground", mSetForegroundSignature);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        throw new IllegalStateException("OS doesn't have Service.startForeground OR Service.setForeground!");
      }
    }
  }
  
  public void onDestroy()
  {
    stopForegroundCompat(2131298762);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    handleCommand(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      handleCommand(paramIntent);
      return 1;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    i.e("ForegroundService", "onTaskRemoved");
    super.onTaskRemoved(paramIntent);
    ActivityStack.exitApp(BNaviEngineManager.getInstance().isEngineInitSucc());
  }
  
  void startForegroundCompat(int paramInt, Notification paramNotification)
  {
    if (this.mStartForeground != null)
    {
      this.mStartForegroundArgs[0] = Integer.valueOf(paramInt);
      this.mStartForegroundArgs[1] = paramNotification;
      invokeMethod(this.mStartForeground, this.mStartForegroundArgs);
      return;
    }
    this.mSetForegroundArgs[0] = Boolean.TRUE;
    invokeMethod(this.mSetForeground, this.mSetForegroundArgs);
    this.mNM.notify(paramInt, paramNotification);
  }
  
  void stopForegroundCompat(int paramInt)
  {
    if (this.mStopForeground != null)
    {
      this.mStopForegroundArgs[0] = Boolean.TRUE;
      invokeMethod(this.mStopForeground, this.mStopForegroundArgs);
      return;
    }
    this.mNM.cancel(paramInt);
    this.mSetForegroundArgs[0] = Boolean.FALSE;
    invokeMethod(this.mSetForeground, this.mSetForegroundArgs);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navi/ForegroundService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */