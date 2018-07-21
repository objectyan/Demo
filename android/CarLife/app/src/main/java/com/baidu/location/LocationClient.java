package com.baidu.location;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LocationClient
{
  public static final int CONNECT_HOT_SPOT_FALSE = 0;
  public static final int CONNECT_HOT_SPOT_TRUE = 1;
  public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
  private static final int LOCATION_PROCESS_CHECK_DELAY_TIME = 1000;
  public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
  public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
  public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
  public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
  public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
  private static final int MIN_REQUEST_SPAN = 1000;
  private static final int MSG_REG_LISTENER = 5;
  private static final int MSG_REG_NOTIFY_LISTENER = 8;
  private static final int MSG_REMOVE_NOTIFY = 10;
  private static final int MSG_REQ_LOC = 4;
  private static final int MSG_REQ_NOTIFY_LOC = 11;
  private static final int MSG_REQ_OFFLINE_LOC = 12;
  private static final int MSG_REQ_POI = 7;
  private static final int MSG_RIGSTER_NOTIFY = 9;
  private static final int MSG_SET_OPT = 3;
  private static final int MSG_START = 1;
  private static final int MSG_STOP = 2;
  private static final int MSG_UNREG_LISTENER = 6;
  public static String PREF_FILE_NAME = "pref_key";
  public static String PREF_KEY_NAME = "access_key";
  private static final String mTAG = "baidu_location_Client";
  private BDLocationListener NotifyLocationListenner = null;
  private Boolean firstConnected = Boolean.valueOf(true);
  private boolean inBLEDoorState = false;
  private boolean inDoorState = false;
  private boolean isScheduled = false;
  private boolean isWaitingForLocation = false;
  private boolean isWaitingLocTag = false;
  private long lastReceiveGpsTime = 0L;
  private long lastReceiveLocationTime = 0L;
  private Boolean mConfig_map = Boolean.valueOf(false);
  private Boolean mConfig_preimport = Boolean.valueOf(false);
  private ServiceConnection mConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      LocationClient.access$102(LocationClient.this, new Messenger(paramAnonymousIBinder));
      if (LocationClient.this.mServer == null) {
        return;
      }
      LocationClient.access$202(LocationClient.this, true);
      try
      {
        paramAnonymousComponentName = Message.obtain(null, 11);
        paramAnonymousComponentName.replyTo = LocationClient.this.mMessenger;
        paramAnonymousComponentName.setData(LocationClient.this.getOptionBundle());
        LocationClient.this.mServer.send(paramAnonymousComponentName);
        LocationClient.access$202(LocationClient.this, true);
        if (LocationClient.this.mOption != null)
        {
          if (LocationClient.this.firstConnected.booleanValue())
          {
            LocationClient.access$602(LocationClient.this, Boolean.valueOf(false));
            LocationClient.this.requestOfflineLocation();
          }
          LocationClient.this.mHandler.obtainMessage(4).sendToTarget();
        }
      }
      catch (Exception paramAnonymousComponentName)
      {
        for (;;) {}
      }
      LocationClient.access$802(LocationClient.this, true);
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      LocationClient.access$102(LocationClient.this, null);
      LocationClient.access$202(LocationClient.this, false);
      LocationClient.this.stop();
      LocationClient.this.restartService3();
      Log.d("baidu_location_Client", "unbindservice...");
    }
  };
  private Context mContext = null;
  private boolean mGpsStatus = false;
  private a mHandler = new a(null);
  private boolean mIsServiceBinded = false;
  private boolean mIsStarted = false;
  private String mKey;
  private BDLocation mLastLocation = null;
  private long mLastRequestTime = 0L;
  private ArrayList<BDLocationListener> mLocationListeners = null;
  private final Object mLock = new Object();
  private final Messenger mMessenger = new Messenger(this.mHandler);
  private LocationClientOption mOption = new LocationClientOption();
  private String mPackName = null;
  private b mScheduledRequest = null;
  private Messenger mServer = null;
  private String serviceName = null;
  
  public LocationClient(Context paramContext)
  {
    this.mContext = paramContext;
    this.mOption = new LocationClientOption();
  }
  
  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    this.mContext = paramContext;
    this.mOption = paramLocationClientOption;
  }
  
  private void callListeners(int paramInt)
  {
    if (this.mLastLocation.getCoorType() == null) {
      this.mLastLocation.setCoorType(this.mOption.coorType);
    }
    if ((this.isWaitingForLocation == true) || ((this.mOption.location_change_notify == true) && (this.mLastLocation.getLocType() == 61)) || (this.mLastLocation.getLocType() == 66) || (this.mLastLocation.getLocType() == 67) || (this.inDoorState) || (this.mLastLocation.getLocType() == 161))
    {
      if (this.mLocationListeners != null)
      {
        Iterator localIterator = this.mLocationListeners.iterator();
        while (localIterator.hasNext()) {
          ((BDLocationListener)localIterator.next()).onReceiveLocation(this.mLastLocation);
        }
      }
      if ((this.mLastLocation.getLocType() != 66) && (this.mLastLocation.getLocType() != 67)) {}
    }
    else
    {
      return;
    }
    this.isWaitingForLocation = false;
    this.lastReceiveLocationTime = System.currentTimeMillis();
  }
  
  private void checkLocationService()
  {
    Iterator localIterator;
    try
    {
      String str1 = this.mContext.getPackageName();
      if ((str1 == null) || (!str1.equals("com.baidu.BaiduMap"))) {
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localIterator = null;
      }
    }
    for (;;)
    {
      try
      {
        localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (ActivityManager.RunningServiceInfo)localIterator.next();
          i = ((ActivityManager.RunningServiceInfo)localObject).pid;
          String str2 = ((ActivityManager.RunningServiceInfo)localObject).process;
          localObject = ((ActivityManager.RunningServiceInfo)localObject).service.getShortClassName();
          if ((!"com.baidu.BaiduMap:MapCoreService".equals(str2)) || (!"com.baidu.location.f".equals(localObject))) {
            continue;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          this.mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              LocationClient.this.restartService2();
            }
          }, 1000L);
          return;
        }
      }
      catch (Exception localException2)
      {
        return;
      }
      int i = 0;
    }
  }
  
  public static BDLocation getBDLocationInCoorType(BDLocation paramBDLocation, String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramBDLocation);
    paramBDLocation = Jni.coorEncrypt(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), paramString);
    localBDLocation.setLatitude(paramBDLocation[1]);
    localBDLocation.setLongitude(paramBDLocation[0]);
    return localBDLocation;
  }
  
  private Bundle getOptionBundle()
  {
    if (this.mOption == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.mPackName);
    localBundle.putString("prodName", this.mOption.prodName);
    localBundle.putString("coorType", this.mOption.coorType);
    localBundle.putString("addrType", this.mOption.addrType);
    localBundle.putBoolean("openGPS", this.mOption.openGps);
    localBundle.putBoolean("location_change_notify", this.mOption.location_change_notify);
    localBundle.putInt("scanSpan", this.mOption.scanSpan);
    localBundle.putInt("timeOut", this.mOption.timeOut);
    localBundle.putInt("priority", this.mOption.priority);
    localBundle.putBoolean("enableSimulateGps", this.mOption.enableSimulateGps);
    localBundle.putBoolean("needDirect", this.mOption.mIsNeedDeviceDirect);
    localBundle.putBoolean("isneedaptag", this.mOption.isNeedAptag);
    localBundle.putBoolean("isneedpoiregion", this.mOption.isNeedPoiRegion);
    localBundle.putBoolean("isneedregular", this.mOption.isNeedRegular);
    localBundle.putBoolean("isneedaptagd", this.mOption.isNeedAptagd);
    localBundle.putBoolean("isneedaltitude", this.mOption.isNeedAltitude);
    localBundle.putInt("autoNotifyMaxInterval", this.mOption.getAutoNotifyMaxInterval());
    localBundle.putInt("autoNotifyMinTimeInterval", this.mOption.getAutoNotifyMinTimeInterval());
    localBundle.putInt("autoNotifyMinDistance", this.mOption.getAutoNotifyMinDistance());
    localBundle.putFloat("autoNotifyLocSensitivity", this.mOption.getAutoNotifyLocSensitivity());
    localBundle.putInt("wifitimeout", this.mOption.wifiCacheTimeOut);
    return localBundle;
  }
  
  private void getRunningServiceInfo()
  {
    try
    {
      Iterator localIterator = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ActivityManager.RunningServiceInfo)localIterator.next();
        int i = ((ActivityManager.RunningServiceInfo)localObject).pid;
        String str = ((ActivityManager.RunningServiceInfo)localObject).process;
        localObject = ((ActivityManager.RunningServiceInfo)localObject).service.getShortClassName();
        if (("com.baidu.BaiduMap:MapCoreService".equals(str)) && ("com.baidu.location.f".equals(localObject))) {
          if (i == 0) {
            restartService();
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void onNewCalibration(Message paramMessage) {}
  
  private void onNewLocation(Message paramMessage, int paramInt)
  {
    try
    {
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(BDLocation.class.getClassLoader());
      this.mLastLocation = ((BDLocation)paramMessage.getParcelable("locStr"));
      if ((this.mLastLocation.getLocType() == 61) || (this.mLastLocation.getGpsCheckStatus() == 1) || (this.mLastLocation.getGpsCheckStatus() == 2)) {
        this.lastReceiveGpsTime = System.currentTimeMillis();
      }
      callListeners(paramInt);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void onNewLocationTag(Message paramMessage)
  {
    this.isWaitingLocTag = false;
    paramMessage = paramMessage.getData().getByteArray("locationtag");
    if (paramMessage != null) {}
    for (paramMessage = new String(paramMessage);; paramMessage = null)
    {
      if (this.mLocationListeners != null)
      {
        Iterator localIterator = this.mLocationListeners.iterator();
        while (localIterator.hasNext()) {
          ((BDLocationListener)localIterator.next()).onReceiveLocationTag(paramMessage);
        }
      }
      return;
    }
  }
  
  private void onNewNaviModeWifiLocation(BDLocation paramBDLocation)
  {
    if (this.mLocationListeners != null)
    {
      Iterator localIterator = this.mLocationListeners.iterator();
      while (localIterator.hasNext()) {
        ((BDLocationListener)localIterator.next()).onReceiveNaviModeWifiLocation(paramBDLocation);
      }
    }
  }
  
  private void onNewNotifyLocation(Message paramMessage)
  {
    try
    {
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(BDLocation.class.getClassLoader());
      paramMessage = (BDLocation)paramMessage.getParcelable("locStr");
      if (this.NotifyLocationListenner != null)
      {
        if ((this.mOption != null) && (this.mOption.isDisableCache()) && (paramMessage.getLocType() == 65)) {
          return;
        }
        this.NotifyLocationListenner.onReceiveLocation(paramMessage);
        return;
      }
    }
    catch (Exception paramMessage) {}
  }
  
  private void onNewUGCData(Message paramMessage)
  {
    paramMessage = paramMessage.getData().getByteArray("gpsintimedata");
    if ((paramMessage != null) && (this.mLocationListeners != null))
    {
      Iterator localIterator = this.mLocationListeners.iterator();
      while (localIterator.hasNext()) {
        ((BDLocationListener)localIterator.next()).onGPSLongLinkPushData(paramMessage, 6);
      }
    }
  }
  
  private void onRegisterListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    do
    {
      return;
      paramMessage = (BDLocationListener)paramMessage.obj;
      if (this.mLocationListeners == null) {
        this.mLocationListeners = new ArrayList();
      }
    } while (this.mLocationListeners.contains(paramMessage));
    this.mLocationListeners.add(paramMessage);
  }
  
  private void onRegisterNotifyLocationListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {
      return;
    }
    this.NotifyLocationListenner = ((BDLocationListener)paramMessage.obj);
  }
  
  private void onRequestLocation()
  {
    if (this.mServer == null) {
      return;
    }
    if (((System.currentTimeMillis() - this.lastReceiveGpsTime > 3000L) || (!this.mOption.location_change_notify) || (this.isWaitingLocTag)) && ((!this.inDoorState) || (System.currentTimeMillis() - this.lastReceiveLocationTime > 20000L) || (this.isWaitingLocTag)))
    {
      ??? = Message.obtain(null, 22);
      if (this.isWaitingLocTag)
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isWaitingLocTag", this.isWaitingLocTag);
        ((Message)???).setData(localBundle);
      }
    }
    try
    {
      ((Message)???).replyTo = this.mMessenger;
      this.mServer.send((Message)???);
      this.mLastRequestTime = System.currentTimeMillis();
      this.isWaitingForLocation = true;
      synchronized (this.mLock)
      {
        if ((this.mOption != null) && (this.mOption.scanSpan >= 1000) && (!this.isScheduled))
        {
          if (this.mScheduledRequest == null) {
            this.mScheduledRequest = new b(null);
          }
          this.mHandler.postDelayed(this.mScheduledRequest, this.mOption.scanSpan);
          this.isScheduled = true;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        restartService3();
      }
    }
  }
  
  private void onRequestNotifyLocation()
  {
    if (this.mServer == null) {
      return;
    }
    Message localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.mMessenger;
      this.mServer.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void onRequestOffLineLocation()
  {
    Message localMessage = Message.obtain(null, 28);
    try
    {
      localMessage.replyTo = this.mMessenger;
      this.mServer.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private void onSetOption(Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 158	com/baidu/location/LocationClient:isWaitingLocTag	Z
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: getfield 605	android/os/Message:obj	Ljava/lang/Object;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: getfield 605	android/os/Message:obj	Ljava/lang/Object;
    //   21: checkcast 129	com/baidu/location/LocationClientOption
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 132	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   29: aload_1
    //   30: invokevirtual 639	com/baidu/location/LocationClientOption:optionEquals	(Lcom/baidu/location/LocationClientOption;)Z
    //   33: ifne -17 -> 16
    //   36: aload_0
    //   37: getfield 132	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   40: getfield 473	com/baidu/location/LocationClientOption:scanSpan	I
    //   43: aload_1
    //   44: getfield 473	com/baidu/location/LocationClientOption:scanSpan	I
    //   47: if_icmpeq +95 -> 142
    //   50: aload_0
    //   51: getfield 166	com/baidu/location/LocationClient:mLock	Ljava/lang/Object;
    //   54: astore_2
    //   55: aload_2
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   61: iconst_1
    //   62: if_icmpne +19 -> 81
    //   65: aload_0
    //   66: getfield 143	com/baidu/location/LocationClient:mHandler	Lcom/baidu/location/LocationClient$a;
    //   69: aload_0
    //   70: getfield 162	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   73: invokevirtual 643	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   81: aload_1
    //   82: getfield 473	com/baidu/location/LocationClientOption:scanSpan	I
    //   85: sipush 1000
    //   88: if_icmplt +52 -> 140
    //   91: aload_0
    //   92: getfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   95: ifne +45 -> 140
    //   98: aload_0
    //   99: getfield 162	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   102: ifnonnull +16 -> 118
    //   105: aload_0
    //   106: new 17	com/baidu/location/LocationClient$b
    //   109: dup
    //   110: aload_0
    //   111: aconst_null
    //   112: invokespecial 632	com/baidu/location/LocationClient$b:<init>	(Lcom/baidu/location/LocationClient;Lcom/baidu/location/LocationClient$1;)V
    //   115: putfield 162	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   118: aload_0
    //   119: getfield 143	com/baidu/location/LocationClient:mHandler	Lcom/baidu/location/LocationClient$a;
    //   122: aload_0
    //   123: getfield 162	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   126: aload_1
    //   127: getfield 473	com/baidu/location/LocationClientOption:scanSpan	I
    //   130: i2l
    //   131: invokevirtual 417	com/baidu/location/LocationClient$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   134: pop
    //   135: aload_0
    //   136: iconst_1
    //   137: putfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   140: aload_2
    //   141: monitorexit
    //   142: aload_0
    //   143: new 129	com/baidu/location/LocationClientOption
    //   146: dup
    //   147: aload_1
    //   148: invokespecial 646	com/baidu/location/LocationClientOption:<init>	(Lcom/baidu/location/LocationClientOption;)V
    //   151: putfield 132	com/baidu/location/LocationClient:mOption	Lcom/baidu/location/LocationClientOption;
    //   154: aload_0
    //   155: getfield 138	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   158: ifnull -142 -> 16
    //   161: aconst_null
    //   162: bipush 15
    //   164: invokestatic 620	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   167: astore_1
    //   168: aload_1
    //   169: aload_0
    //   170: getfield 150	com/baidu/location/LocationClient:mMessenger	Landroid/os/Messenger;
    //   173: putfield 628	android/os/Message:replyTo	Landroid/os/Messenger;
    //   176: aload_1
    //   177: aload_0
    //   178: invokespecial 293	com/baidu/location/LocationClient:getOptionBundle	()Landroid/os/Bundle;
    //   181: invokevirtual 625	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   184: aload_0
    //   185: getfield 138	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   188: aload_1
    //   189: invokevirtual 631	android/os/Messenger:send	(Landroid/os/Message;)V
    //   192: return
    //   193: astore_1
    //   194: aload_0
    //   195: invokespecial 308	com/baidu/location/LocationClient:restartService3	()V
    //   198: return
    //   199: astore_3
    //   200: aload_2
    //   201: monitorexit
    //   202: aload_3
    //   203: athrow
    //   204: astore_2
    //   205: goto -63 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	LocationClient
    //   0	208	1	paramMessage	Message
    //   204	1	2	localException	Exception
    //   199	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   161	192	193	java/lang/Exception
    //   57	81	199	finally
    //   81	118	199	finally
    //   118	140	199	finally
    //   140	142	199	finally
    //   200	202	199	finally
    //   50	57	204	java/lang/Exception
    //   202	204	204	java/lang/Exception
  }
  
  private void onStart()
  {
    if (this.mIsStarted == true) {
      return;
    }
    this.mPackName = this.mContext.getPackageName();
    this.serviceName = (this.mPackName + "_bdls_v2.9");
    Intent localIntent = new Intent(this.mContext, f.class);
    if (this.mOption == null) {
      this.mOption = new LocationClientOption();
    }
    localIntent.putExtra("cache_exception", this.mOption.isIgnoreCacheException);
    localIntent.putExtra("kill_process", this.mOption.isIgnoreKillProcess);
    try
    {
      this.mIsServiceBinded = false;
      this.mContext.bindService(localIntent, this.mConnection, 1);
      new Thread()
      {
        public void run()
        {
          try
          {
            sleep(1000L);
            if (!LocationClient.this.mIsServiceBinded) {
              LocationClient.this.getRunningServiceInfo();
            }
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      }.start();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.mIsStarted = false;
    }
  }
  
  /* Error */
  private void onStop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 134	com/baidu/location/LocationClient:mIsStarted	Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 138	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: bipush 12
    //   18: invokestatic 620	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 150	com/baidu/location/LocationClient:mMessenger	Landroid/os/Messenger;
    //   27: putfield 628	android/os/Message:replyTo	Landroid/os/Messenger;
    //   30: aload_0
    //   31: getfield 138	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   34: aload_1
    //   35: invokevirtual 631	android/os/Messenger:send	(Landroid/os/Message;)V
    //   38: aload_0
    //   39: getfield 136	com/baidu/location/LocationClient:mContext	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 197	com/baidu/location/LocationClient:mConnection	Landroid/content/ServiceConnection;
    //   46: invokevirtual 691	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   49: aload_0
    //   50: getfield 166	com/baidu/location/LocationClient:mLock	Ljava/lang/Object;
    //   53: astore_1
    //   54: aload_1
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   60: iconst_1
    //   61: if_icmpne +19 -> 80
    //   64: aload_0
    //   65: getfield 143	com/baidu/location/LocationClient:mHandler	Lcom/baidu/location/LocationClient$a;
    //   68: aload_0
    //   69: getfield 162	com/baidu/location/LocationClient:mScheduledRequest	Lcom/baidu/location/LocationClient$b;
    //   72: invokevirtual 643	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 160	com/baidu/location/LocationClient:isScheduled	Z
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 138	com/baidu/location/LocationClient:mServer	Landroid/os/Messenger;
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 158	com/baidu/location/LocationClient:isWaitingLocTag	Z
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield 176	com/baidu/location/LocationClient:inDoorState	Z
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 178	com/baidu/location/LocationClient:inBLEDoorState	Z
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 134	com/baidu/location/LocationClient:mIsStarted	Z
    //   107: return
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 635	java/lang/Exception:printStackTrace	()V
    //   113: goto -75 -> 38
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: goto -42 -> 80
    //   125: astore_1
    //   126: goto -77 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	LocationClient
    //   108	10	1	localException1	Exception
    //   125	1	1	localException2	Exception
    //   116	4	2	localObject2	Object
    //   121	1	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	108	java/lang/Exception
    //   56	80	116	finally
    //   80	82	116	finally
    //   117	119	116	finally
    //   56	80	121	java/lang/Exception
    //   38	49	125	java/lang/Exception
  }
  
  private void onUnRegisterListener(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    do
    {
      return;
      paramMessage = (BDLocationListener)paramMessage.obj;
    } while ((this.mLocationListeners == null) || (!this.mLocationListeners.contains(paramMessage)));
    this.mLocationListeners.remove(paramMessage);
  }
  
  private int requestLocationtag()
  {
    if ((this.mServer == null) || (this.mMessenger == null)) {
      return 1;
    }
    if ((this.mLocationListeners == null) || (this.mLocationListeners.size() < 1)) {
      return 2;
    }
    this.isWaitingLocTag = true;
    this.mHandler.obtainMessage(4).sendToTarget();
    return 0;
  }
  
  private void restartService2()
  {
    try
    {
      Intent localIntent = new Intent(this.mContext, f.class);
      this.mContext.bindService(localIntent, this.mConnection, 1);
      localIntent = new Intent(this.mContext, f.class);
      this.mContext.startService(localIntent);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void restartService3() {}
  
  private boolean sendServerMessage(int paramInt)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, paramInt);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      restartService3();
    }
    return false;
  }
  
  public boolean IBeaconValiable()
  {
    return (Build.VERSION.SDK_INT > 17) && (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"));
  }
  
  public void baiduMapSendChangeFloorMessage()
  {
    sendServerMessage(112);
  }
  
  public boolean baiduMapStartIndoorBleMode()
  {
    boolean bool = sendServerMessage(121);
    if (bool)
    {
      this.inDoorState = true;
      this.inBLEDoorState = true;
    }
    return bool;
  }
  
  public boolean baiduMapStartIndoorMode()
  {
    boolean bool = sendServerMessage(110);
    if (bool) {
      this.inDoorState = true;
    }
    return bool;
  }
  
  public boolean baiduMapStopCalibrationWhileIndoorMode()
  {
    return true;
  }
  
  public boolean baiduMapStopIndoorBleMode()
  {
    boolean bool = sendServerMessage(122);
    if (bool) {
      this.inBLEDoorState = false;
    }
    return bool;
  }
  
  public boolean baiduMapStopIndoorMode()
  {
    boolean bool = sendServerMessage(111);
    if (bool) {
      this.inDoorState = false;
    }
    return bool;
  }
  
  public BDLocation getLastKnownLocation()
  {
    return this.mLastLocation;
  }
  
  public String getLocInfo()
  {
    try
    {
      String str2 = new c(this.mContext).a();
      String str1 = str2;
      if (str2 != null) {
        str1 = Jni.encode(str2);
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public LocationClientOption getLocOption()
  {
    return this.mOption;
  }
  
  public String getVersion()
  {
    return "7.3.2";
  }
  
  public boolean isBLEIndoorMode()
  {
    return this.inBLEDoorState;
  }
  
  public boolean isIndoorMode()
  {
    return this.inDoorState;
  }
  
  public boolean isStarted()
  {
    return this.mIsStarted;
  }
  
  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.mHandler.obtainMessage(5);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public void registerNotifyLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.mHandler.obtainMessage(8);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public boolean requestHotSpotState()
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 406);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      restartService3();
    }
    return false;
  }
  
  public int requestLocation()
  {
    if ((this.mServer == null) || (this.mMessenger == null)) {
      return 1;
    }
    if ((this.mLocationListeners == null) || (this.mLocationListeners.size() < 1)) {
      return 2;
    }
    if (System.currentTimeMillis() - this.mLastRequestTime < 1000L) {
      return 6;
    }
    checkLocationService();
    this.mHandler.obtainMessage(4).sendToTarget();
    return 0;
  }
  
  public boolean requestLocationTag()
  {
    return requestLocationtag() == 0;
  }
  
  public void requestNotifyLocation()
  {
    this.mHandler.obtainMessage(11).sendToTarget();
  }
  
  public int requestOfflineLocation()
  {
    if ((this.mServer == null) || (this.mMessenger == null)) {
      return 1;
    }
    if ((this.mLocationListeners == null) || (this.mLocationListeners.size() < 1)) {
      return 2;
    }
    this.mHandler.obtainMessage(12).sendToTarget();
    return 0;
  }
  
  public void restartService()
  {
    try
    {
      this.mContext.unbindService(this.mConnection);
      try
      {
        Intent localIntent = new Intent(this.mContext, f.class);
        this.mContext.stopService(localIntent);
        try
        {
          localIntent = new Intent(this.mContext, f.class);
          this.mContext.bindService(localIntent, this.mConnection, 1);
          localIntent = new Intent(this.mContext, f.class);
          this.mContext.startService(localIntent);
          return;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  public void setAccessKey(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = Pattern.compile("[&=]").matcher(paramString).replaceAll("");
    }
    this.mKey = str;
    this.mContext.getSharedPreferences(PREF_FILE_NAME, 0).edit().putString(PREF_KEY_NAME, this.mKey).commit();
  }
  
  public void setForBaiduMap(boolean paramBoolean)
  {
    this.mConfig_map = Boolean.valueOf(paramBoolean);
  }
  
  public boolean setHotSpotUserCallbackInfo(boolean paramBoolean)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 407);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("user", paramBoolean);
      localMessage.setData(localBundle);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      restartService3();
    }
    return false;
  }
  
  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    LocationClientOption localLocationClientOption = paramLocationClientOption;
    if (paramLocationClientOption == null) {
      localLocationClientOption = new LocationClientOption();
    }
    if (localLocationClientOption.getAutoNotifyMaxInterval() > 0)
    {
      localLocationClientOption.setScanSpan(0);
      localLocationClientOption.setLocationNotify(true);
    }
    paramLocationClientOption = this.mHandler.obtainMessage(3);
    paramLocationClientOption.obj = localLocationClientOption;
    paramLocationClientOption.sendToTarget();
  }
  
  public boolean setNaviModeStatus(int paramInt1, int paramInt2)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("source", paramInt1);
      localBundle.putInt("status", paramInt2);
      Message localMessage = Message.obtain(null, 403);
      localMessage.setData(localBundle);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      restartService3();
    }
    return false;
  }
  
  public boolean setRealTimeBusStationInfo(Bundle paramBundle)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 402);
      localMessage.setData(paramBundle);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception paramBundle)
    {
      restartService3();
    }
    return false;
  }
  
  public boolean setUgcInfo(String paramString)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 401);
      Bundle localBundle = new Bundle();
      localBundle.putString("ugcInfo", paramString);
      localMessage.setData(localBundle);
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception paramString)
    {
      restartService3();
    }
    return false;
  }
  
  public void start()
  {
    this.mHandler.obtainMessage(1).sendToTarget();
  }
  
  public void stop()
  {
    onStop();
  }
  
  public boolean triggerErrorReport(String paramString)
  {
    if ((this.mServer == null) || (!this.mIsStarted)) {
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("errorid", paramString.getBytes());
      paramString = Message.obtain(null, 405);
      paramString.setData(localBundle);
      this.mServer.send(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      restartService3();
    }
    return false;
  }
  
  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.mHandler.obtainMessage(6);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }
  
  public boolean updateLocation(Location paramLocation)
  {
    if ((this.mServer == null) || (this.mMessenger == null) || (paramLocation == null)) {
      return false;
    }
    try
    {
      Message localMessage = Message.obtain(null, 57);
      localMessage.obj = paramLocation;
      this.mServer.send(localMessage);
      return true;
    }
    catch (Exception paramLocation)
    {
      for (;;)
      {
        paramLocation.printStackTrace();
      }
    }
  }
  
  private class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      }
      for (;;)
      {
        return;
        LocationClient.this.onSetOption(paramMessage);
        return;
        LocationClient.this.onRegisterNotifyLocationListener(paramMessage);
        return;
        LocationClient.this.onRegisterListener(paramMessage);
        return;
        LocationClient.this.onUnRegisterListener(paramMessage);
        return;
        LocationClient.this.onStart();
        return;
        LocationClient.this.onStop();
        return;
        LocationClient.this.onRequestNotifyLocation();
        return;
        LocationClient.this.onRequestLocation();
        return;
        LocationClient.this.onRequestOffLineLocation();
        return;
        if (LocationClient.this.mOption.location_change_notify)
        {
          LocationClient.access$2502(LocationClient.this, true);
          return;
          if (LocationClient.this.mOption.location_change_notify)
          {
            LocationClient.access$2502(LocationClient.this, false);
            return;
            LocationClient.this.onNewLocation(paramMessage, 21);
            return;
            LocationClient.this.onNewLocation(paramMessage, 26);
            return;
            LocationClient.this.onNewNotifyLocation(paramMessage);
            return;
            LocationClient.access$2802(LocationClient.this, false);
            LocationClient.access$2902(LocationClient.this, false);
            return;
            LocationClient.this.onNewCalibration(paramMessage);
            return;
            LocationClient.this.onNewUGCData(paramMessage);
            return;
            LocationClient.this.onNewLocationTag(paramMessage);
            return;
            try
            {
              paramMessage = paramMessage.getData();
              int i = paramMessage.getInt("loctype");
              int j = paramMessage.getInt("diagtype");
              paramMessage = paramMessage.getByteArray("diagmessage");
              if ((i <= 0) || (j <= 0) || (paramMessage == null) || (LocationClient.this.mLocationListeners == null)) {
                continue;
              }
              Object localObject = LocationClient.this.mLocationListeners.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((BDLocationListener)((Iterator)localObject).next()).onLocDiagnosticMessage(i, j, new String(paramMessage, "UTF-8"));
              }
              try
              {
                localObject = paramMessage.getData();
                paramMessage = ((Bundle)localObject).getByteArray("mac");
                if (paramMessage != null)
                {
                  paramMessage = new String(paramMessage, "UTF-8");
                  i = ((Bundle)localObject).getInt("hotspot", -1);
                  if (LocationClient.this.mLocationListeners == null) {
                    continue;
                  }
                  localObject = LocationClient.this.mLocationListeners.iterator();
                  while (((Iterator)localObject).hasNext()) {
                    ((BDLocationListener)((Iterator)localObject).next()).onConnectHotSpotMessage(paramMessage, i);
                  }
                  try
                  {
                    paramMessage = paramMessage.getData();
                    paramMessage.setClassLoader(BDLocation.class.getClassLoader());
                    paramMessage = (BDLocation)paramMessage.getParcelable("navimodelocation");
                    LocationClient.this.onNewNaviModeWifiLocation(paramMessage);
                    return;
                  }
                  catch (Exception paramMessage)
                  {
                    return;
                  }
                }
              }
              catch (Exception paramMessage)
              {
                return;
              }
            }
            catch (Exception paramMessage)
            {
              return;
            }
            while (LocationClient.this.mHandler != null)
            {
              LocationClient.this.mHandler.postDelayed(new Runnable()
              {
                public void run()
                {
                  LocationClient.this.restartService3();
                }
              }, 1000L);
              return;
              paramMessage = null;
            }
          }
        }
      }
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      synchronized (LocationClient.this.mLock)
      {
        LocationClient.access$1402(LocationClient.this, false);
        if ((LocationClient.this.mServer == null) || (LocationClient.this.mMessenger == null)) {
          return;
        }
        if ((LocationClient.this.mLocationListeners == null) || (LocationClient.this.mLocationListeners.size() < 1)) {
          return;
        }
      }
      LocationClient.this.mHandler.obtainMessage(4).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/LocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */