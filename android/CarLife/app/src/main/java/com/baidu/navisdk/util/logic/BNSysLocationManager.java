package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.commonui.DebugCommonUIController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BNSysLocationManager
  extends BNLocationManager
{
  private static final long GPS_AVAIL_MAX_INTERVAL = 1500L;
  private static final int GPS_AVAIL_MIN_NUM_DATA = 3;
  private static final float GPS_UPDATE_MIN_DIST = 0.0F;
  private static final int GPS_UPDATE_MIN_TIME = 0;
  private static final int MOCK_JUDGE_TIME_INTERVAL = 10000;
  private static final String TAG = "Location";
  private static BNSysLocationManager mInstance = null;
  public boolean isLocateInitSuccessful = true;
  private int mEventOfGPSStatusChanged = 2;
  private int mFixedSatellitesNum = 0;
  private boolean mGpsAvailable = false;
  private boolean mGpsAvailableDebug = false;
  private GpsStatus mGpsStatus;
  private int mGpsStatusDebug = 0;
  private GpsStatus.Listener mGpsStatusListener = new BNSysLocationManager.3(this);
  private GpsStatus.Listener mGpsStatusRoutePlanListener = new BNSysLocationManager.2(this);
  private boolean mIsStarted = false;
  private long mLastTimeOfSatelliteStatusChanged = 0L;
  private List<Long> mLocDataTimeCache = new ArrayList(3);
  private LocationListener mLocationListener = new BNSysLocationManager.4(this);
  private int mMockJudgeGPSCount = 0;
  private int mMockJudgeGPSStatusAvailableCount = 0;
  private int mMockJudgeGPSStatusTmpAvailableCount = 0;
  private int mMockJudgeGPSStatusUnavailableCount = 0;
  private long mMockJudgeLastTime = 0L;
  private int mMockJudgeTotalCount = 0;
  private int mSearchedSatellitesNum = 0;
  public boolean mSensorFingerEnable = false;
  private LocationManager mSysLocManager = null;
  
  public static void destory()
  {
    try
    {
      if (mInstance != null) {
        mInstance.unInit();
      }
      mInstance = null;
      return;
    }
    finally {}
  }
  
  public static BNSysLocationManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BNSysLocationManager();
      }
      BNSysLocationManager localBNSysLocationManager = mInstance;
      return localBNSysLocationManager;
    }
    finally {}
  }
  
  private String getLocationStatusDebugString()
  {
    switch (this.mGpsStatusDebug)
    {
    default: 
      return "out";
    case 2: 
      return "ok";
    }
    return "tmp";
  }
  
  private HashMap<String, Integer> getSatellitesMap()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if (this.mSysLocManager != null)
      {
        Iterator localIterator;
        int j;
        int i;
        if (this.mGpsStatus == null)
        {
          this.mGpsStatus = this.mSysLocManager.getGpsStatus(null);
          localIterator = this.mGpsStatus.getSatellites().iterator();
          j = 0;
          i = 0;
        }
        for (;;)
        {
          int k;
          if (localIterator.hasNext())
          {
            k = j;
            if (!((GpsSatellite)localIterator.next()).usedInFix()) {
              break label130;
            }
            k = j + 1;
            break label130;
            this.mSysLocManager.getGpsStatus(this.mGpsStatus);
            break;
          }
          localHashMap.put("fixedSatellitesNum", Integer.valueOf(j));
          localHashMap.put("searchedSatellitesNum", Integer.valueOf(i));
          return localHashMap;
          label130:
          i += 1;
          j = k;
        }
      }
      return null;
    }
    catch (Exception localException) {}
  }
  
  private boolean handleLocationWhenGpsLost(Location paramLocation)
  {
    if (paramLocation == null) {
      return true;
    }
    LogUtil.e("Location", "handleLocationWhenGpsLost");
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (!this.mLocDataTimeCache.isEmpty()) {
      l1 = ((Long)this.mLocDataTimeCache.get(this.mLocDataTimeCache.size() - 1)).longValue();
    }
    if (l2 - l1 <= 1500L)
    {
      this.mLocDataTimeCache.add(Long.valueOf(l2));
      LogUtil.e("Location", "GpsLost: add new location, size " + this.mLocDataTimeCache.size());
      if (this.mLocDataTimeCache.size() >= 3)
      {
        this.mGpsAvailable = true;
        notifyGpsStatusChanged(true, true);
        LogUtil.e("Location", "GpsLost: unavailable ----> available");
        this.mLocDataTimeCache.clear();
        return false;
      }
    }
    else
    {
      this.mLocDataTimeCache.clear();
      LogUtil.e("Location", "GpsLost: > interval, clear all");
    }
    return true;
  }
  
  private boolean isMockByGPSStatus()
  {
    LogUtil.e("Location", "iscjaByGPSStatus() ac=" + this.mMockJudgeGPSStatusAvailableCount + ", tc=" + this.mMockJudgeGPSStatusTmpAvailableCount + ", uc=" + this.mMockJudgeGPSStatusUnavailableCount);
    int i = this.mMockJudgeGPSStatusAvailableCount + this.mMockJudgeGPSStatusTmpAvailableCount + this.mMockJudgeGPSStatusUnavailableCount;
    if (i == 0)
    {
      LogUtil.e("Location", "iscjaByGPSStatus() true for 0");
      return true;
    }
    if ((this.mMockJudgeGPSStatusAvailableCount + this.mMockJudgeGPSStatusTmpAvailableCount) / i >= 0.8D)
    {
      LogUtil.e("Location", "iscjaByGPSStatus() false");
      return false;
    }
    LogUtil.e("Location", "iscjaByGPSStatus() true for other");
    return true;
  }
  
  private boolean isMockByLocationAndSatellieteStatus()
  {
    LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() gpsC=" + this.mMockJudgeGPSCount + ", totalC=" + this.mMockJudgeTotalCount);
    if (this.mMockJudgeTotalCount <= 0)
    {
      LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() true for 0");
      return true;
    }
    if (this.mMockJudgeGPSCount / this.mMockJudgeTotalCount >= 0.9D)
    {
      LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() false");
      return false;
    }
    LogUtil.e("Location", "iscjaByLocationAndSatellieteStatus() true other");
    return true;
  }
  
  private void mockJudge()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (SystemClock.elapsedRealtime() - this.mMockJudgeLastTime > 10000L))
    {
      if (SystemClock.elapsedRealtime() - this.mLastTimeOfSatelliteStatusChanged < 3000L) {
        this.mMockJudgeGPSCount += 1;
      }
      this.mMockJudgeTotalCount += 1;
      this.mMockJudgeLastTime = SystemClock.elapsedRealtime();
      LogUtil.e("Location", "cja() gpsC=" + this.mMockJudgeGPSCount + ", totalC=" + this.mMockJudgeTotalCount);
      switch (this.mGpsStatusDebug)
      {
      }
    }
    for (;;)
    {
      if (LogUtil.LOGGABLE) {
        LogUtil.e("Location", "cja() ac=" + this.mMockJudgeGPSStatusAvailableCount + ", tc=" + this.mMockJudgeGPSStatusTmpAvailableCount + ", uc=" + this.mMockJudgeGPSStatusUnavailableCount);
      }
      return;
      this.mMockJudgeGPSStatusAvailableCount += 1;
      continue;
      this.mMockJudgeGPSStatusTmpAvailableCount += 1;
      continue;
      this.mMockJudgeGPSStatusUnavailableCount += 1;
    }
  }
  
  private void notifyGpsStatusWithSatellitesChanged(int paramInt)
  {
    if ((this.mGpsAvailable) && (paramInt == 0))
    {
      this.mGpsAvailable = false;
      LogUtil.e("Location", "notifyGpsStatusWithSatellitesChanged: mGpsAvailable --> " + this.mGpsAvailable);
      notifyGpsStatusChanged(true, false);
    }
    while ((this.mGpsAvailable) || (paramInt <= 0)) {
      return;
    }
    this.mGpsAvailable = true;
    LogUtil.e("Location", "notifyGpsStatusWithSatellitesChanged: mGpsAvailable --> " + this.mGpsAvailable);
    notifyGpsStatusChanged(true, true);
    this.mLocDataTimeCache.clear();
  }
  
  private void recordSensorFingerStarInfos()
  {
    for (;;)
    {
      int k;
      int m;
      try
      {
        Object localObject1 = BNaviModuleManager.getContext();
        if (localObject1 == null) {
          return;
        }
        Object localObject2 = (LocationManager)((Context)localObject1).getSystemService("location");
        if (localObject2 != null)
        {
          localObject1 = new ArrayList();
          localObject2 = ((LocationManager)localObject2).getGpsStatus(null).getSatellites().iterator();
          j = 0;
          i = 0;
          k = j;
          m = i;
          if (((Iterator)localObject2).hasNext())
          {
            GpsSatellite localGpsSatellite = (GpsSatellite)((Iterator)localObject2).next();
            k = j;
            if (localGpsSatellite.usedInFix()) {
              k = j + 1;
            }
            m = i + 1;
            Bundle localBundle = new Bundle();
            localBundle.putInt("nStarId", localGpsSatellite.getPrn());
            localBundle.putFloat("fUpAngle", localGpsSatellite.getElevation());
            localBundle.putFloat("fAngle", localGpsSatellite.getAzimuth());
            localBundle.putFloat("fSNR", localGpsSatellite.getSnr());
            localBundle.putBoolean("bIsUsed", localGpsSatellite.usedInFix());
            localBundle.putBoolean("bIsHaveAlmanac", localGpsSatellite.hasAlmanac());
            localBundle.putBoolean("bIsHaveEphemeris", localGpsSatellite.hasEphemeris());
            ((ArrayList)localObject1).add(localBundle);
            LogUtil.e("SensorFinger", "starID=" + localGpsSatellite.getPrn());
            if (!LogUtil.LOGGABLE) {
              break label297;
            }
            TipTool.onCreateToastDialog(BNaviModuleManager.getActivity(), "SensorFinger.starID=" + localGpsSatellite.getPrn());
            break label297;
          }
          BNRouteGuider.getInstance().triggerGPSStarInfoChange(m, k, (ArrayList)localObject1);
          return;
        }
      }
      catch (Exception localException) {}
      return;
      label297:
      int j = k;
      int i = m;
      if (m != 60) {}
    }
  }
  
  private void recordViaductStartNodeStarInfos()
  {
    for (;;)
    {
      int k;
      int m;
      try
      {
        if (BNaviModuleManager.getContext() == null) {
          return;
        }
        if (this.mSysLocManager != null)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = this.mSysLocManager.getGpsStatus(null).getSatellites().iterator();
          j = 0;
          i = 0;
          k = j;
          m = i;
          if (localIterator.hasNext())
          {
            GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
            k = j;
            if (localGpsSatellite.usedInFix()) {
              k = j + 1;
            }
            m = i + 1;
            Bundle localBundle = new Bundle();
            localBundle.putInt("nStarId", localGpsSatellite.getPrn());
            localBundle.putFloat("fUpAngle", localGpsSatellite.getElevation());
            localBundle.putFloat("fAngle", localGpsSatellite.getAzimuth());
            localBundle.putFloat("fSNR", localGpsSatellite.getSnr());
            localBundle.putBoolean("bIsUsed", localGpsSatellite.usedInFix());
            localBundle.putBoolean("bIsHaveAlmanac", localGpsSatellite.hasAlmanac());
            localBundle.putBoolean("bIsHaveEphemeris", localGpsSatellite.hasEphemeris());
            localArrayList.add(localBundle);
            if (!LogUtil.LOGGABLE) {
              break label487;
            }
            LogUtil.e("recordViaductStartNodeStarInfos:", "nStarId=" + localGpsSatellite.getPrn());
            LogUtil.e("recordViaductStartNodeStarInfos:", "fUpAngle=" + localGpsSatellite.getElevation());
            LogUtil.e("recordViaductStartNodeStarInfos:", "fAngle=" + localGpsSatellite.getAzimuth());
            LogUtil.e("recordViaductStartNodeStarInfos:", "fSNR=" + localGpsSatellite.getSnr());
            LogUtil.e("recordViaductStartNodeStarInfos:", "bIsUsed=" + localGpsSatellite.usedInFix());
            LogUtil.e("recordViaductStartNodeStarInfos:", "bIsHaveAlmanac=" + localGpsSatellite.hasAlmanac());
            LogUtil.e("recordViaductStartNodeStarInfos:", "bIsHaveEphemeris=" + localGpsSatellite.hasEphemeris());
            break label487;
          }
          LogUtil.e("recordViaductStartNodeStarInfos:", "searchedSatellitesNum=" + m);
          LogUtil.e("recordViaductStartNodeStarInfos:", "fixedSatellitesNum=" + k);
          BNRouteGuider.getInstance().triggerGPSStarInfoChange(m, k, localArrayList);
          return;
        }
      }
      catch (Exception localException) {}
      return;
      label487:
      int j = k;
      int i = m;
      if (m != 60) {}
    }
  }
  
  private void resetMockJudge()
  {
    LogUtil.e("Location", "resetcja() mReAddGpsLocation " + BNavigator.getInstance().mReAddGpsLocation);
    if (BNavigator.getInstance().mReAddGpsLocation)
    {
      BNavigator.getInstance().mReAddGpsLocation = false;
      return;
    }
    this.mMockJudgeLastTime = 0L;
    this.mMockJudgeGPSCount = 0;
    this.mMockJudgeTotalCount = 0;
    this.mLastTimeOfSatelliteStatusChanged = 0L;
    this.mEventOfGPSStatusChanged = 2;
    this.mMockJudgeGPSStatusAvailableCount = 0;
    this.mMockJudgeGPSStatusTmpAvailableCount = 0;
    this.mMockJudgeGPSStatusUnavailableCount = 0;
    this.mGpsStatusDebug = 0;
  }
  
  /* Error */
  private boolean startLocate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 22
    //   4: ldc_w 483
    //   7: invokestatic 246	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 63	com/baidu/navisdk/util/logic/BNSysLocationManager:mSysLocManager	Landroid/location/LocationManager;
    //   14: ifnull +213 -> 227
    //   17: aload_0
    //   18: getfield 71	com/baidu/navisdk/util/logic/BNSysLocationManager:mIsStarted	Z
    //   21: ifne +206 -> 227
    //   24: aload_0
    //   25: invokestatic 363	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   28: invokevirtual 487	com/baidu/navisdk/util/logic/BNSysLocationManager:hasGPSPermission	(Landroid/content/Context;)Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +167 -> 200
    //   36: aload_0
    //   37: getfield 63	com/baidu/navisdk/util/logic/BNSysLocationManager:mSysLocManager	Landroid/location/LocationManager;
    //   40: ldc_w 489
    //   43: lconst_0
    //   44: fconst_0
    //   45: aload_0
    //   46: getfield 119	com/baidu/navisdk/util/logic/BNSysLocationManager:mLocationListener	Landroid/location/LocationListener;
    //   49: invokevirtual 493	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   52: aload_0
    //   53: getfield 63	com/baidu/navisdk/util/logic/BNSysLocationManager:mSysLocManager	Landroid/location/LocationManager;
    //   56: aload_0
    //   57: getfield 114	com/baidu/navisdk/util/logic/BNSysLocationManager:mGpsStatusListener	Landroid/location/GpsStatus$Listener;
    //   60: invokevirtual 497	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   63: pop
    //   64: getstatic 502	com/baidu/navisdk/debug/NavSDKDebug:sShowDebugToast	Z
    //   67: ifeq +12 -> 79
    //   70: invokestatic 363	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   73: ldc_w 504
    //   76: invokestatic 507	com/baidu/navisdk/ui/util/TipTool:onCreateDebugToast	(Landroid/content/Context;Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokespecial 509	com/baidu/navisdk/util/logic/BNSysLocationManager:resetMockJudge	()V
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 71	com/baidu/navisdk/util/logic/BNSysLocationManager:mIsStarted	Z
    //   88: ldc 22
    //   90: ldc_w 511
    //   93: invokestatic 246	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: iconst_1
    //   97: istore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_1
    //   101: ireturn
    //   102: astore_2
    //   103: invokestatic 516	com/baidu/navisdk/util/statistic/userop/UserOPController:getInstance	()Lcom/baidu/navisdk/util/statistic/userop/UserOPController;
    //   106: ldc_w 518
    //   109: ldc_w 520
    //   112: aconst_null
    //   113: aconst_null
    //   114: invokevirtual 523	com/baidu/navisdk/util/statistic/userop/UserOPController:add	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   117: getstatic 528	com/baidu/navisdk/util/statistic/PerformStatItem:sUserTest	Z
    //   120: ifeq +47 -> 167
    //   123: invokestatic 533	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   126: ldc_w 535
    //   129: new 279	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 537
    //   139: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 540	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokevirtual 543	com/baidu/navisdk/debug/SDKDebugFileUtil:addCoreLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: invokestatic 533	com/baidu/navisdk/debug/SDKDebugFileUtil:getInstance	()Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   158: iconst_1
    //   159: iconst_1
    //   160: iconst_1
    //   161: ldc2_w 544
    //   164: invokevirtual 549	com/baidu/navisdk/debug/SDKDebugFileUtil:uploadLogFile	(IZZJ)V
    //   167: ldc 22
    //   169: new 279	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 551
    //   179: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: invokevirtual 540	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 246	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: iconst_0
    //   196: istore_1
    //   197: goto -99 -> 98
    //   200: invokestatic 516	com/baidu/navisdk/util/statistic/userop/UserOPController:getInstance	()Lcom/baidu/navisdk/util/statistic/userop/UserOPController;
    //   203: ldc_w 518
    //   206: ldc_w 553
    //   209: aconst_null
    //   210: aconst_null
    //   211: invokevirtual 523	com/baidu/navisdk/util/statistic/userop/UserOPController:add	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc 22
    //   216: ldc_w 555
    //   219: invokestatic 246	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iconst_0
    //   223: istore_1
    //   224: goto -126 -> 98
    //   227: invokestatic 516	com/baidu/navisdk/util/statistic/userop/UserOPController:getInstance	()Lcom/baidu/navisdk/util/statistic/userop/UserOPController;
    //   230: ldc_w 518
    //   233: ldc_w 557
    //   236: aconst_null
    //   237: aconst_null
    //   238: invokevirtual 523	com/baidu/navisdk/util/statistic/userop/UserOPController:add	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   241: ldc 22
    //   243: new 279	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 559
    //   253: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: getfield 71	com/baidu/navisdk/util/logic/BNSysLocationManager:mIsStarted	Z
    //   260: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   263: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 246	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: iconst_0
    //   270: istore_1
    //   271: goto -173 -> 98
    //   274: astore_2
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_2
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	BNSysLocationManager
    //   31	240	1	bool	boolean
    //   102	81	2	localException	Exception
    //   274	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	79	102	java/lang/Exception
    //   79	96	102	java/lang/Exception
    //   2	32	274	finally
    //   36	79	274	finally
    //   79	96	274	finally
    //   103	167	274	finally
    //   167	195	274	finally
    //   200	222	274	finally
    //   227	269	274	finally
  }
  
  private boolean stopLocate()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        LogUtil.e("Location", "stopLocate");
        try
        {
          if ((this.mSysLocManager == null) || (!this.mIsStarted)) {
            break label128;
          }
          if (this.mLocationListener != null) {
            this.mSysLocManager.removeUpdates(this.mLocationListener);
          }
          if (this.mGpsStatusListener != null) {
            this.mSysLocManager.removeGpsStatusListener(this.mGpsStatusListener);
          }
          this.mIsStarted = false;
          LogUtil.e("Location", "stopLocate() ok");
          bool = true;
        }
        catch (Exception localException)
        {
          if (!LogUtil.LOGGABLE) {
            continue;
          }
          localException.printStackTrace();
          LogUtil.e("Location", "stopLocate() error for ex=" + localException.getMessage());
          continue;
        }
        return bool;
      }
      finally {}
      label128:
      LogUtil.e("Location", "stopLocate() error for null. mIsStarted=" + this.mIsStarted);
    }
  }
  
  public void addNmeaListener(GpsStatus.NmeaListener paramNmeaListener)
  {
    try
    {
      if ((this.mSysLocManager != null) && (paramNmeaListener != null))
      {
        this.mSysLocManager.addNmeaListener(paramNmeaListener);
        LogUtil.e("Location", "addNmeaListener() ok");
      }
    }
    catch (Exception paramNmeaListener)
    {
      for (;;)
      {
        LogUtil.e("Location", "addNmeaListener() error. e=" + paramNmeaListener.getMessage());
      }
    }
    finally {}
  }
  
  public int getFixedSatelliteNum()
  {
    return this.mFixedSatellitesNum;
  }
  
  public String getGPSStatusDebugString()
  {
    switch (this.mEventOfGPSStatusChanged)
    {
    default: 
      return "停止定位";
    case 3: 
      return "首次定位";
    case 4: 
      return "卫星变化";
    case 1: 
      return "开始定位";
    }
    return "停止定位";
  }
  
  public int getSearchedSatelliteNum()
  {
    return this.mSearchedSatellitesNum;
  }
  
  public GeoPoint getSysLastKnownLocation()
  {
    if (this.mSysLocManager != null)
    {
      Location localLocation2 = this.mSysLocManager.getLastKnownLocation("gps");
      Location localLocation1 = localLocation2;
      if (localLocation2 == null) {
        localLocation1 = this.mSysLocManager.getLastKnownLocation("network");
      }
      if (localLocation1 != null) {
        return CoordinateTransformUtil.transferWGS84ToGCJ02(localLocation1.getLongitude(), localLocation1.getLatitude());
      }
    }
    return null;
  }
  
  public boolean hasGPSPermission(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if ((localPackageManager != null) && (-1 == localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", PackageUtil.getPackageName())))
      {
        TipTool.onCreateToastDialog(paramContext, BNStyleManager.getString(1711669363));
        LogUtil.e("Location", "hasGPSPermission=false");
        return false;
      }
      LogUtil.e("Location", "hasGPSPermission=true");
      return true;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("Location", "hasGPSPermission=true but exception=" + paramContext.getMessage());
    }
    return true;
  }
  
  public void init(Context paramContext)
  {
    LogUtil.e("Location", "init");
    if ((this.mSysLocManager == null) && (paramContext != null) && (hasGPSPermission(BNaviModuleManager.getContext()))) {
      this.mSysLocManager = ((LocationManager)paramContext.getSystemService("location"));
    }
    if (this.mSysLocManager == null)
    {
      this.isLocateInitSuccessful = false;
      LogUtil.e("Location", "init locateinit failed");
    }
  }
  
  public boolean isGpsAvailable()
  {
    return this.mGpsAvailable;
  }
  
  public boolean isGpsEnabled()
  {
    boolean bool = false;
    try
    {
      if (this.mSysLocManager != null) {
        bool = this.mSysLocManager.isProviderEnabled("gps");
      }
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      LogUtil.e("Location", localIllegalArgumentException.toString());
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      LogUtil.e("Location", localSecurityException.toString());
    }
    return false;
  }
  
  public boolean isMock()
  {
    return isMockByLocationAndSatellieteStatus();
  }
  
  public boolean isSysLocationValid()
  {
    return (this.mGpsAvailable) && (getCurLocation() != null);
  }
  
  public void removeNmeaListener(GpsStatus.NmeaListener paramNmeaListener)
  {
    try
    {
      LogUtil.e("Location", "removeNmeaListener() ");
      if ((this.mSysLocManager != null) && (paramNmeaListener != null)) {
        this.mSysLocManager.removeNmeaListener(paramNmeaListener);
      }
      return;
    }
    finally {}
  }
  
  public void restartLocateModule()
  {
    if ((Build.VERSION.SDK_INT < 23) || (this.mSysLocManager != null)) {
      return;
    }
    LogUtil.e("Location", "restartLocateModule");
    init(BNaviModuleManager.getContext());
  }
  
  public void showDebugUI()
  {
    if (BNSettingManager.isGPSDebug()) {
      DebugCommonUIController.getInstance().showUI("debug_module_location", new BNSysLocationManager.1(this));
    }
  }
  
  public boolean startNaviLocate(Context paramContext)
  {
    try
    {
      super.startNaviLocate(paramContext);
      boolean bool = startLocate();
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public void startNaviLocateForRoutePlan(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/baidu/navisdk/util/logic/BNSysLocationManager:mSysLocManager	Landroid/location/LocationManager;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 114	com/baidu/navisdk/util/logic/BNSysLocationManager:mGpsStatusListener	Landroid/location/GpsStatus$Listener;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 487	com/baidu/navisdk/util/logic/BNSysLocationManager:hasGPSPermission	(Landroid/content/Context;)Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +15 -> 38
    //   26: aload_0
    //   27: getfield 63	com/baidu/navisdk/util/logic/BNSysLocationManager:mSysLocManager	Landroid/location/LocationManager;
    //   30: aload_0
    //   31: getfield 109	com/baidu/navisdk/util/logic/BNSysLocationManager:mGpsStatusRoutePlanListener	Landroid/location/GpsStatus$Listener;
    //   34: invokevirtual 497	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   37: pop
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: goto -9 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	BNSysLocationManager
    //   0	50	1	paramContext	Context
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	41	finally
    //   26	38	41	finally
    //   26	38	46	java/lang/Exception
  }
  
  public void startRecordStarInfos()
  {
    recordViaductStartNodeStarInfos();
  }
  
  public void stopNaviLocate()
  {
    try
    {
      super.stopNaviLocate();
      LogUtil.e("Location", "stopNaviLocate");
      stopLocate();
      if (BNSettingManager.isShowJavaLog())
      {
        SDKDebugFileUtil.end("sysloc_debug");
        SDKDebugFileUtil.end("naving_sysloc_debug");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopNaviLocateForRoutePlan()
  {
    try
    {
      if ((this.mSysLocManager != null) && (this.mGpsStatusListener != null)) {
        this.mSysLocManager.removeGpsStatusListener(this.mGpsStatusRoutePlanListener);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void unInit()
  {
    LogUtil.e("Location", "unInit");
    stopLocate();
    this.mSysLocManager = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/util/logic/BNSysLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */