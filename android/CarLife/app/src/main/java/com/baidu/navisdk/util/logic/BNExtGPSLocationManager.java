package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;

public class BNExtGPSLocationManager
  extends BNLocationManager
{
  private static final String TAG = BNExtGPSLocationManager.class.getSimpleName();
  private static BNExtGPSLocationManager mInstance = null;
  private Context mContext;
  private int mDebugIndex = 1;
  private boolean mIsGpsEnabled = false;
  private LocationManager mSysLocManager;
  
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
  
  public static BNExtGPSLocationManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BNExtGPSLocationManager();
      }
      BNExtGPSLocationManager localBNExtGPSLocationManager = mInstance;
      return localBNExtGPSLocationManager;
    }
    finally {}
  }
  
  public boolean hasGPSPermission(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null) {}
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      bool1 = bool2;
      if (localPackageManager != null)
      {
        bool1 = bool2;
        if (-1 == localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", PackageUtil.getPackageName()))
        {
          TipTool.onCreateToastDialog(paramContext, BNStyleManager.getString(1711669363));
          bool1 = false;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public void init(Context paramContext)
  {
    try
    {
      this.mContext = paramContext;
      LogUtil.e(TAG, "init");
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public boolean isGpsAvailable()
  {
    return getCurLocation() != null;
  }
  
  public boolean isGpsEnabled()
  {
    if (RouteGuideParams.getRouteGuideMode() == 2) {
      try
      {
        if ((this.mSysLocManager == null) && (this.mContext != null) && (hasGPSPermission(BNaviModuleManager.getContext()))) {
          this.mSysLocManager = ((LocationManager)this.mContext.getSystemService("location"));
        }
        boolean bool = this.mSysLocManager.isProviderEnabled("gps");
        return bool;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return this.mIsGpsEnabled;
  }
  
  public void notifyLocationChangedForEngine(LocData paramLocData)
  {
    if (BNavigator.getInstance().isNaviBegin()) {}
    while (paramLocData == null) {
      return;
    }
    Bundle localBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(paramLocData.longitude, paramLocData.latitude);
    double d1 = localBundle.getDouble("LLx");
    double d2 = localBundle.getDouble("LLy");
    double d3 = paramLocData.altitude;
    float f1 = paramLocData.speed;
    float f2 = paramLocData.direction;
    float f3 = paramLocData.accuracy;
    int j = paramLocData.getStartPointUpStreamLocType();
    int i;
    if (paramLocData.indoorState == 1) {
      i = 1;
    }
    for (;;)
    {
      if (this.mDebugIndex >= 10)
      {
        this.mDebugIndex = 1;
        LogUtil.e("triggerStartLocationData:", "call");
      }
      this.mDebugIndex += 1;
      BNRouteGuider.getInstance().triggerStartLocationData((int)(100000.0D * d1), (int)(100000.0D * d2), (float)d3, f1, f2, f3, j, i);
      return;
      if (paramLocData.indoorState == 0) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void triggerGPSDataChangeForAllLocType(LocData paramLocData)
  {
    if (LogUtil.LOGGABLE) {
      LogUtil.e(TAG, "triggerGPSDataChangeForAllLocType   longitude:" + paramLocData.longitude + ", latitude:" + paramLocData.latitude + ", locType:" + paramLocData.type + ", satellitesNum:" + paramLocData.satellitesNum);
    }
    BNRouteGuider localBNRouteGuider;
    int j;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    int m;
    if (paramLocData != null)
    {
      Bundle localBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(paramLocData.longitude, paramLocData.latitude);
      localBNRouteGuider = BNRouteGuider.getInstance();
      j = (int)(localBundle.getDouble("LLx") * 100000.0D);
      k = (int)(localBundle.getDouble("LLy") * 100000.0D);
      f1 = paramLocData.speed;
      f2 = paramLocData.direction;
      f3 = paramLocData.accuracy;
      f4 = (float)paramLocData.altitude;
      m = paramLocData.satellitesNum;
      if (paramLocData.type != 61) {
        break label182;
      }
    }
    label182:
    for (int i = 0;; i = 1)
    {
      localBNRouteGuider.triggerGPSDataChange(j, k, f1, f2, f3, f4, m, i);
      return;
    }
  }
  
  public void triggerGPSDataChangeForDriving(LocData paramLocData)
  {
    LogUtil.e(TAG, "triggerGPSDataChangeForDriving   longitude:" + paramLocData.longitude + ", latitude:" + paramLocData.latitude + ", locType:" + paramLocData.type + ", satellitesNum:" + paramLocData.satellitesNum);
    if (paramLocData.type == 61)
    {
      Bundle localBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(paramLocData.longitude, paramLocData.latitude);
      paramLocData.locType = 0;
      if (BNSettingManager.isShowJavaLog()) {
        SDKDebugFileUtil.get("sysloc_debug").add("Driving sysloc=long:" + (int)(localBundle.getDouble("LLx") * 100000.0D) + ", lati:" + (int)(localBundle.getDouble("LLy") * 100000.0D) + ", speed:" + paramLocData.speed + ", direction:" + paramLocData.direction + ", accuracy:" + paramLocData.accuracy + ", locType:" + paramLocData.locType + ", satellitesNum:" + paramLocData.satellitesNum);
      }
      BNRouteGuider.getInstance().triggerGPSDataChange((int)(localBundle.getDouble("LLx") * 100000.0D), (int)(localBundle.getDouble("LLy") * 100000.0D), paramLocData.speed, paramLocData.direction, paramLocData.accuracy, (float)paramLocData.altitude, paramLocData.satellitesNum, paramLocData.locType);
      return;
    }
    triggerGPSDataChangeForAllLocType(paramLocData);
  }
  
  public void unInit()
  {
    try
    {
      this.mContext = null;
      this.mSysLocManager = null;
      LogUtil.e(TAG, " unInit");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void updateGpsStatus(boolean paramBoolean)
  {
    LogUtil.e(TAG, "updateGpsStatus: enabled " + paramBoolean);
    this.mIsGpsEnabled = paramBoolean;
    notifyGpsStatusChanged(paramBoolean, true);
  }
  
  public void updateLocation(LocData paramLocData)
  {
    if (paramLocData != null) {
      notifyLocationChanged(paramLocData);
    }
  }
  
  public void updateWGS84Location(LocData paramLocData1, LocData paramLocData2)
  {
    if (paramLocData1 != null) {
      notifyWGS84LocationChanged(paramLocData1, paramLocData2);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/logic/BNExtGPSLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */